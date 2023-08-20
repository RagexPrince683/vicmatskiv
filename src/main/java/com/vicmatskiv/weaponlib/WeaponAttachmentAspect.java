package com.vicmatskiv.weaponlib;

import java.util.function.*;
import com.vicmatskiv.weaponlib.state.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.item.*;
import java.util.*;
import org.apache.logging.log4j.*;
import com.vicmatskiv.weaponlib.network.*;
import io.netty.buffer.*;

public final class WeaponAttachmentAspect implements Aspect<WeaponState, PlayerWeaponInstance>
{
    private static final Logger logger;
    private ModContext modContext;
    private PermitManager permitManager;
    private StateManager<WeaponState, ? super PlayerWeaponInstance> stateManager;
    private long clickSpammingTimeout;
    private Predicate<PlayerWeaponInstance> clickSpammingPreventer;
    private Collection<WeaponState> allowedUpdateFromStates;
    
    WeaponAttachmentAspect(final ModContext modContext) {
        super();
        this.clickSpammingTimeout = 100L;
        this.clickSpammingPreventer = (es -> System.currentTimeMillis() >= es.getStateUpdateTimestamp() + this.clickSpammingTimeout);
        this.allowedUpdateFromStates = Arrays.asList(WeaponState.MODIFYING_REQUESTED);
        this.modContext = modContext;
    }
    
    @Override
    public void setStateManager(final StateManager<WeaponState, ? super PlayerWeaponInstance> stateManager) {
        if (this.permitManager == null) {
            throw new IllegalStateException("Permit manager not initialized");
        }
        this.stateManager = stateManager.in((Aspect<WeaponState, PlayerWeaponInstance>)this).change(WeaponState.READY).to(WeaponState.MODIFYING).when(this.clickSpammingPreventer).withPermit((s, es) -> new EnterAttachmentModePermit(s), this.modContext.getPlayerItemInstanceRegistry()::update, this.permitManager).manual().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.MODIFYING).to(WeaponState.READY).when(this.clickSpammingPreventer).withAction(instance -> this.permitManager.request(new ExitAttachmentModePermit(WeaponState.READY), instance, (p, e) -> {})).manual().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.MODIFYING).to(WeaponState.NEXT_ATTACHMENT).when(this.clickSpammingPreventer).withPermit(null, this.modContext.getPlayerItemInstanceRegistry()::update, this.permitManager).manual().in((Aspect<S, ExtendedState>)this).change(WeaponState.NEXT_ATTACHMENT).to(WeaponState.MODIFYING).automatic();
    }
    
    @Override
    public void setPermitManager(final PermitManager permitManager) {
        (this.permitManager = permitManager).registerEvaluator(EnterAttachmentModePermit.class, PlayerWeaponInstance.class, this::enterAttachmentSelectionMode);
        permitManager.registerEvaluator(ExitAttachmentModePermit.class, PlayerWeaponInstance.class, this::exitAttachmentSelectionMode);
        permitManager.registerEvaluator(ChangeAttachmentPermit.class, PlayerWeaponInstance.class, this::changeAttachment);
    }
    
    public void toggleClientAttachmentSelectionMode(final EntityPlayer player) {
        final PlayerWeaponInstance weaponInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
        if (weaponInstance != null) {
            this.stateManager.changeState(this, weaponInstance, WeaponState.MODIFYING, WeaponState.READY);
        }
    }
    
    void updateMainHeldItem(final EntityPlayer player) {
        final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
        if (instance != null) {
            this.stateManager.changeStateFromAnyOf(this, instance, this.allowedUpdateFromStates, new WeaponState[0]);
        }
    }
    
    private void enterAttachmentSelectionMode(final EnterAttachmentModePermit permit, final PlayerWeaponInstance weaponInstance) {
        WeaponAttachmentAspect.logger.debug("Entering attachment mode");
        final byte[] selectedAttachmentIndexes = new byte[AttachmentCategory.values.length];
        Arrays.fill(selectedAttachmentIndexes, (byte)(-1));
        weaponInstance.setSelectedAttachmentIndexes(selectedAttachmentIndexes);
        permit.setStatus(Permit.Status.GRANTED);
    }
    
    private void exitAttachmentSelectionMode(final ExitAttachmentModePermit permit, final PlayerWeaponInstance weaponInstance) {
        WeaponAttachmentAspect.logger.debug("Exiting attachment mode");
        weaponInstance.setSelectedAttachmentIndexes(new byte[0]);
        permit.setStatus(Permit.Status.GRANTED);
    }
    
    List<CompatibleAttachment<? extends AttachmentContainer>> getActiveAttachments(final EntityPlayer player, final ItemStack itemStack) {
        CompatibilityProvider.compatibility.ensureTagCompound(itemStack);
        final List<CompatibleAttachment<? extends AttachmentContainer>> activeAttachments = new ArrayList<CompatibleAttachment<? extends AttachmentContainer>>();
        final PlayerItemInstance<?> itemInstance = this.modContext.getPlayerItemInstanceRegistry().getItemInstance(player, itemStack);
        int[] activeAttachmentsIds;
        if (!(itemInstance instanceof PlayerWeaponInstance)) {
            activeAttachmentsIds = new int[AttachmentCategory.values.length];
            for (final CompatibleAttachment<Weapon> attachment : ((Weapon)itemStack.getItem()).getCompatibleAttachments().values()) {
                if (attachment.isDefault()) {
                    activeAttachmentsIds[attachment.getAttachment().getCategory().ordinal()] = Item.getIdFromItem((Item)attachment.getAttachment());
                }
            }
        }
        else {
            activeAttachmentsIds = ((PlayerWeaponInstance)itemInstance).getActiveAttachmentIds();
        }
        final Weapon weapon = (Weapon)itemStack.getItem();
        for (final int activeIndex : activeAttachmentsIds) {
            if (activeIndex != 0) {
                final Item item = Item.getItemById(activeIndex);
                if (item instanceof ItemAttachment) {
                    final CompatibleAttachment<? extends AttachmentContainer> compatibleAttachment = weapon.getCompatibleAttachments().get(item);
                    if (compatibleAttachment != null) {
                        activeAttachments.add(compatibleAttachment);
                    }
                }
            }
        }
        return activeAttachments;
    }
    
    void changeAttachment(final AttachmentCategory attachmentCategory, final PlayerWeaponInstance weaponInstance) {
        if (weaponInstance != null) {
            this.stateManager.changeState(this, weaponInstance, new ChangeAttachmentPermit(attachmentCategory), WeaponState.NEXT_ATTACHMENT);
        }
    }
    
    private void changeAttachment(final ChangeAttachmentPermit permit, final PlayerWeaponInstance weaponInstance) {
        final AttachmentCategory attachmentCategory = permit.attachmentCategory;
        final int[] originalActiveAttachmentIds = weaponInstance.getActiveAttachmentIds();
        final int[] activeAttachmentIds = Arrays.copyOf(originalActiveAttachmentIds, originalActiveAttachmentIds.length);
        final int activeAttachmentIdForThisCategory = activeAttachmentIds[attachmentCategory.ordinal()];
        ItemAttachment<Weapon> currentAttachment = null;
        if (activeAttachmentIdForThisCategory > 0) {
            currentAttachment = (ItemAttachment)Item.getItemById(activeAttachmentIdForThisCategory);
        }
        if (currentAttachment != null) {
            final CompatibleAttachment<Weapon> currentCompatibleAttachment = weaponInstance.getWeapon().getCompatibleAttachments().get(currentAttachment);
            if (currentCompatibleAttachment.isPermanent()) {
                return;
            }
        }
        final AttachmentLookupResult lookupResult = this.next(attachmentCategory, currentAttachment, weaponInstance);
        if (currentAttachment != null) {
            if (currentAttachment.getRemove() != null) {
                currentAttachment.getRemove().apply(currentAttachment, weaponInstance.getWeapon(), weaponInstance.getPlayer());
            }
            if (currentAttachment.getRemove2() != null) {
                currentAttachment.getRemove2().apply(currentAttachment, weaponInstance);
            }
        }
        if (lookupResult.index >= 0) {
            final ItemStack slotItemStack = weaponInstance.getPlayer().inventory.getStackInSlot(lookupResult.index);
            final ItemAttachment<Weapon> nextAttachment = (ItemAttachment<Weapon>)slotItemStack.getItem();
            if (nextAttachment.getApply() != null) {
                nextAttachment.getApply().apply(nextAttachment, weaponInstance.getWeapon(), weaponInstance.getPlayer());
            }
            else if (nextAttachment.getApply2() != null) {
                nextAttachment.getApply2().apply(nextAttachment, weaponInstance);
            }
            else if (lookupResult.compatibleAttachment.getApplyHandler() != null) {
                lookupResult.compatibleAttachment.getApplyHandler().apply(nextAttachment, weaponInstance);
            }
            else {
                final ItemAttachment.ApplyHandler2<Weapon> handler = weaponInstance.getWeapon().getEquivalentHandler(attachmentCategory);
                if (handler != null) {
                    handler.apply(null, weaponInstance);
                }
            }
            CompatibilityProvider.compatibility.consumeInventoryItemFromSlot(weaponInstance.getPlayer(), lookupResult.index);
            activeAttachmentIds[attachmentCategory.ordinal()] = Item.getIdFromItem((Item)nextAttachment);
        }
        else {
            activeAttachmentIds[attachmentCategory.ordinal()] = -1;
            final ItemAttachment.ApplyHandler2<Weapon> handler2 = weaponInstance.getWeapon().getEquivalentHandler(attachmentCategory);
            if (handler2 != null) {
                handler2.apply(null, weaponInstance);
            }
        }
        if (currentAttachment != null) {
            CompatibilityProvider.compatibility.addItemToPlayerInventory(weaponInstance.getPlayer(), currentAttachment, lookupResult.index);
        }
        weaponInstance.setActiveAttachmentIds(activeAttachmentIds);
    }
    
    private AttachmentLookupResult next(final AttachmentCategory category, final Item currentAttachment, final PlayerWeaponInstance weaponInstance) {
        final AttachmentLookupResult result = new AttachmentLookupResult();
        final byte[] originallySelectedAttachmentIndexes = weaponInstance.getSelectedAttachmentIds();
        if (originallySelectedAttachmentIndexes == null || originallySelectedAttachmentIndexes.length != AttachmentCategory.values.length) {
            return result;
        }
        final byte[] selectedAttachmentIndexes = Arrays.copyOf(originallySelectedAttachmentIndexes, originallySelectedAttachmentIndexes.length);
        final int activeIndex = selectedAttachmentIndexes[category.ordinal()];
        result.index = -1;
        final int offset = activeIndex + 1;
        for (int i = 0; i < 37; ++i) {
            int currentIndex = i + offset;
            if (currentIndex >= 36) {
                currentIndex -= 37;
            }
            WeaponAttachmentAspect.logger.debug("Searching for an attachment in slot {}", new Object[] { currentIndex });
            if (currentIndex == -1) {
                result.index = -1;
                break;
            }
            final ItemStack slotItemStack = weaponInstance.getPlayer().inventory.getStackInSlot(currentIndex);
            if (slotItemStack != null && slotItemStack.getItem() instanceof ItemAttachment) {
                final ItemAttachment<Weapon> attachmentItemFromInventory = (ItemAttachment<Weapon>)slotItemStack.getItem();
                final CompatibleAttachment<Weapon> compatibleAttachment;
                if (attachmentItemFromInventory.getCategory() == category && (compatibleAttachment = weaponInstance.getWeapon().getCompatibleAttachments().get(attachmentItemFromInventory)) != null && attachmentItemFromInventory != currentAttachment) {
                    result.index = currentIndex;
                    result.compatibleAttachment = compatibleAttachment;
                    break;
                }
            }
        }
        selectedAttachmentIndexes[category.ordinal()] = (byte)result.index;
        weaponInstance.setSelectedAttachmentIndexes(selectedAttachmentIndexes);
        return result;
    }
    
    void addAttachment(final ItemAttachment<Weapon> attachment, final PlayerWeaponInstance weaponInstance) {
        final int[] activeAttachmentsIds = weaponInstance.getActiveAttachmentIds();
        final int activeAttachmentIdForThisCategory = activeAttachmentsIds[attachment.getCategory().ordinal()];
        ItemAttachment<Weapon> currentAttachment = null;
        if (activeAttachmentIdForThisCategory > 0) {
            currentAttachment = (ItemAttachment)Item.getItemById(activeAttachmentIdForThisCategory);
        }
        if (currentAttachment == null) {
            if (attachment != null && attachment.getApply() != null) {
                attachment.getApply().apply(attachment, weaponInstance.getWeapon(), weaponInstance.getPlayer());
            }
            activeAttachmentsIds[attachment.getCategory().ordinal()] = Item.getIdFromItem((Item)attachment);
        }
        else {
            System.err.println("Attachment of category " + attachment.getCategory() + " installed, remove it first");
        }
    }
    
    ItemAttachment<Weapon> removeAttachment(final AttachmentCategory attachmentCategory, final PlayerWeaponInstance weaponInstance) {
        final int[] activeAttachmentIds = weaponInstance.getActiveAttachmentIds();
        final int activeAttachmentIdForThisCategory = activeAttachmentIds[attachmentCategory.ordinal()];
        ItemAttachment<Weapon> currentAttachment = null;
        if (activeAttachmentIdForThisCategory > 0) {
            currentAttachment = (ItemAttachment)Item.getItemById(activeAttachmentIdForThisCategory);
        }
        if (currentAttachment != null && currentAttachment.getRemove() != null) {
            currentAttachment.getRemove().apply(currentAttachment, weaponInstance.getWeapon(), weaponInstance.getPlayer());
        }
        if (currentAttachment != null) {
            activeAttachmentIds[attachmentCategory.ordinal()] = -1;
            weaponInstance.setActiveAttachmentIds(activeAttachmentIds);
        }
        return currentAttachment;
    }
    
    static ItemAttachment<Weapon> getActiveAttachment(final AttachmentCategory category, final PlayerWeaponInstance weaponInstance) {
        ItemAttachment<Weapon> itemAttachment = null;
        final int[] activeAttachmentIds2;
        final int[] activeAttachmentIds = activeAttachmentIds2 = weaponInstance.getActiveAttachmentIds();
        for (final int activeIndex : activeAttachmentIds2) {
            if (activeIndex != 0) {
                final Item item = Item.getItemById(activeIndex);
                if (item instanceof ItemAttachment) {
                    final CompatibleAttachment<Weapon> compatibleAttachment = weaponInstance.getWeapon().getCompatibleAttachments().get(item);
                    if (compatibleAttachment != null && category == compatibleAttachment.getAttachment().getCategory()) {
                        itemAttachment = compatibleAttachment.getAttachment();
                        break;
                    }
                }
            }
        }
        return itemAttachment;
    }
    
    static boolean isActiveAttachment(final ItemAttachment<Weapon> attachment, final PlayerWeaponInstance weaponInstance) {
        final int[] activeAttachmentIds = weaponInstance.getActiveAttachmentIds();
        return Arrays.stream(activeAttachmentIds).anyMatch(attachmentId -> itemAttachment == Item.getItemById(attachmentId));
    }
    
    boolean isSilencerOn(final PlayerWeaponInstance weaponInstance) {
        final int[] activeAttachmentsIds = weaponInstance.getActiveAttachmentIds();
        final int activeAttachmentIdForThisCategory = activeAttachmentsIds[AttachmentCategory.SILENCER.ordinal()];
        return activeAttachmentIdForThisCategory > 0;
    }
    
    ItemAttachment<Weapon> getActiveAttachment(final PlayerWeaponInstance weaponInstance, final AttachmentCategory category) {
        return weaponInstance.getAttachmentItemWithCategory(category);
    }
    
    private static /* synthetic */ boolean lambda$isActiveAttachment$87(final ItemAttachment itemAttachment, final int attachmentId) {
        return itemAttachment == Item.getItemById(attachmentId);
    }
    
    private /* synthetic */ void lambda$setStateManager$86(final PlayerWeaponInstance instance) {
        this.permitManager.request(new ExitAttachmentModePermit(WeaponState.READY), instance, (p, e) -> {});
    }
    
    private static /* synthetic */ void lambda$null$85(final ExitAttachmentModePermit p, final PlayerWeaponInstance e) {
    }
    
    private static /* synthetic */ Permit lambda$setStateManager$84(final WeaponState s, final PlayerWeaponInstance es) {
        return new EnterAttachmentModePermit(s);
    }
    
    private /* synthetic */ boolean lambda$new$83(final PlayerWeaponInstance es) {
        return System.currentTimeMillis() >= es.getStateUpdateTimestamp() + this.clickSpammingTimeout;
    }
    
    static {
        logger = LogManager.getLogger((Class)WeaponAttachmentAspect.class);
        TypeRegistry.getInstance().register(EnterAttachmentModePermit.class);
        TypeRegistry.getInstance().register(ExitAttachmentModePermit.class);
        TypeRegistry.getInstance().register(ChangeAttachmentPermit.class);
    }
    
    private static class AttachmentLookupResult
    {
        CompatibleAttachment<Weapon> compatibleAttachment;
        int index;
        
        private AttachmentLookupResult() {
            super();
            this.index = -1;
        }
        
        AttachmentLookupResult(final WeaponAttachmentAspect$1 x0) {
            this();
        }
    }
    
    public static class EnterAttachmentModePermit extends Permit<WeaponState>
    {
        public EnterAttachmentModePermit() {
            super();
        }
        
        public EnterAttachmentModePermit(final WeaponState state) {
            super(state);
        }
    }
    
    public static class ExitAttachmentModePermit extends Permit<WeaponState>
    {
        public ExitAttachmentModePermit() {
            super();
        }
        
        public ExitAttachmentModePermit(final WeaponState state) {
            super(state);
        }
    }
    
    public static class ChangeAttachmentPermit extends Permit<WeaponState>
    {
        AttachmentCategory attachmentCategory;
        
        public ChangeAttachmentPermit() {
            super();
        }
        
        public ChangeAttachmentPermit(final AttachmentCategory attachmentCategory) {
            super(WeaponState.NEXT_ATTACHMENT);
            this.attachmentCategory = attachmentCategory;
        }
        
        @Override
        public void init(final ByteBuf buf) {
            super.init(buf);
            this.attachmentCategory = AttachmentCategory.values()[buf.readInt()];
        }
        
        @Override
        public void serialize(final ByteBuf buf) {
            super.serialize(buf);
            buf.writeInt(this.attachmentCategory.ordinal());
        }
    }
}
