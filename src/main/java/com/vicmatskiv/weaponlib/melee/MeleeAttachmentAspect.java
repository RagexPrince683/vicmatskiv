package com.vicmatskiv.weaponlib.melee;

import java.util.function.*;
import com.vicmatskiv.weaponlib.state.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;
import org.apache.logging.log4j.*;
import com.vicmatskiv.weaponlib.network.*;
import io.netty.buffer.*;

public final class MeleeAttachmentAspect implements Aspect<MeleeState, PlayerMeleeInstance>
{
    private static final Logger logger;
    private ModContext modContext;
    private PermitManager permitManager;
    private StateManager<MeleeState, ? super PlayerMeleeInstance> stateManager;
    private long clickSpammingTimeout;
    private Predicate<PlayerMeleeInstance> clickSpammingPreventer;
    private Collection<MeleeState> allowedUpdateFromStates;
    
    public MeleeAttachmentAspect(final ModContext modContext) {
        super();
        this.clickSpammingTimeout = 100L;
        this.clickSpammingPreventer = (es -> System.currentTimeMillis() >= es.getStateUpdateTimestamp() + this.clickSpammingTimeout);
        this.allowedUpdateFromStates = Arrays.asList(MeleeState.MODIFYING_REQUESTED);
        this.modContext = modContext;
    }
    
    @Override
    public void setStateManager(final StateManager<MeleeState, ? super PlayerMeleeInstance> stateManager) {
        if (this.permitManager == null) {
            throw new IllegalStateException("Permit manager not initialized");
        }
        this.stateManager = stateManager.in((Aspect<MeleeState, PlayerMeleeInstance>)this).change(MeleeState.READY).to(MeleeState.MODIFYING).when(this.clickSpammingPreventer).withPermit((s, es) -> new EnterAttachmentModePermit(s), this.modContext.getPlayerItemInstanceRegistry()::update, this.permitManager).manual().in((Aspect<S, PlayerMeleeInstance>)this).change(MeleeState.MODIFYING).to(MeleeState.READY).when(this.clickSpammingPreventer).withAction(instance -> this.permitManager.request(new ExitAttachmentModePermit(MeleeState.READY), instance, (p, e) -> {})).manual().in((Aspect<S, PlayerMeleeInstance>)this).change(MeleeState.MODIFYING).to(MeleeState.NEXT_ATTACHMENT).when(this.clickSpammingPreventer).withPermit(null, this.modContext.getPlayerItemInstanceRegistry()::update, this.permitManager).manual().in((Aspect<S, ExtendedState>)this).change(MeleeState.NEXT_ATTACHMENT).to(MeleeState.MODIFYING).automatic();
    }
    
    @Override
    public void setPermitManager(final PermitManager permitManager) {
        (this.permitManager = permitManager).registerEvaluator(EnterAttachmentModePermit.class, PlayerMeleeInstance.class, this::enterAttachmentSelectionMode);
        permitManager.registerEvaluator(ExitAttachmentModePermit.class, PlayerMeleeInstance.class, this::exitAttachmentSelectionMode);
        permitManager.registerEvaluator(ChangeAttachmentPermit.class, PlayerMeleeInstance.class, this::changeAttachment);
    }
    
    public void toggleClientAttachmentSelectionMode(final EntityPlayer player) {
        final PlayerMeleeInstance weaponInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerMeleeInstance.class);
        if (weaponInstance != null) {
            this.stateManager.changeState(this, weaponInstance, MeleeState.MODIFYING, MeleeState.READY);
        }
    }
    
    public void onUpdate(final EntityPlayer player) {
        final PlayerMeleeInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerMeleeInstance.class);
        if (instance != null) {
            this.stateManager.changeStateFromAnyOf(this, instance, this.allowedUpdateFromStates, new MeleeState[0]);
        }
    }
    
    private void enterAttachmentSelectionMode(final EnterAttachmentModePermit permit, final PlayerMeleeInstance weaponInstance) {
        MeleeAttachmentAspect.logger.debug("Entering attachment mode");
        final byte[] selectedAttachmentIndexes = new byte[AttachmentCategory.values.length];
        Arrays.fill(selectedAttachmentIndexes, (byte)(-1));
        weaponInstance.setSelectedAttachmentIndexes(selectedAttachmentIndexes);
        permit.setStatus(Permit.Status.GRANTED);
    }
    
    private void exitAttachmentSelectionMode(final ExitAttachmentModePermit permit, final PlayerMeleeInstance weaponInstance) {
        MeleeAttachmentAspect.logger.debug("Exiting attachment mode");
        weaponInstance.setSelectedAttachmentIndexes(new byte[0]);
        permit.setStatus(Permit.Status.GRANTED);
    }
    
    List<CompatibleAttachment<? extends AttachmentContainer>> getActiveAttachments(final EntityPlayer player, final ItemStack itemStack) {
        CompatibilityProvider.compatibility.ensureTagCompound(itemStack);
        final List<CompatibleAttachment<? extends AttachmentContainer>> activeAttachments = new ArrayList<CompatibleAttachment<? extends AttachmentContainer>>();
        final PlayerItemInstance<?> itemInstance = this.modContext.getPlayerItemInstanceRegistry().getItemInstance(player, itemStack);
        int[] activeAttachmentsIds;
        if (!(itemInstance instanceof PlayerMeleeInstance)) {
            activeAttachmentsIds = new int[AttachmentCategory.values.length];
            for (final CompatibleAttachment<ItemMelee> attachment : ((ItemMelee)itemStack.getItem()).getCompatibleAttachments().values()) {
                if (attachment.isDefault()) {
                    activeAttachmentsIds[attachment.getAttachment().getCategory().ordinal()] = Item.getIdFromItem((Item)attachment.getAttachment());
                }
            }
        }
        else {
            activeAttachmentsIds = ((PlayerMeleeInstance)itemInstance).getActiveAttachmentIds();
        }
        final ItemMelee weapon = (ItemMelee)itemStack.getItem();
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
    
    public void changeAttachment(final AttachmentCategory attachmentCategory, final PlayerMeleeInstance weaponInstance) {
        if (weaponInstance != null) {
            this.stateManager.changeState(this, weaponInstance, new ChangeAttachmentPermit(attachmentCategory), MeleeState.NEXT_ATTACHMENT);
        }
    }
    
    private void changeAttachment(final ChangeAttachmentPermit permit, final PlayerMeleeInstance weaponInstance) {
        final AttachmentCategory attachmentCategory = permit.attachmentCategory;
        final int[] originalActiveAttachmentIds = weaponInstance.getActiveAttachmentIds();
        final int[] activeAttachmentIds = Arrays.copyOf(originalActiveAttachmentIds, originalActiveAttachmentIds.length);
        final int activeAttachmentIdForThisCategory = activeAttachmentIds[attachmentCategory.ordinal()];
        ItemAttachment<ItemMelee> currentAttachment = null;
        if (activeAttachmentIdForThisCategory > 0) {
            currentAttachment = (ItemAttachment)Item.getItemById(activeAttachmentIdForThisCategory);
        }
        final AttachmentLookupResult lookupResult = this.next(attachmentCategory, currentAttachment, weaponInstance);
        if (currentAttachment != null) {
            if (currentAttachment.getRemove() != null) {
                currentAttachment.getRemove().apply(currentAttachment, weaponInstance.getWeapon(), weaponInstance.getPlayer());
            }
            if (currentAttachment.getRemove3() != null) {
                currentAttachment.getRemove3().apply(currentAttachment, weaponInstance);
            }
        }
        if (lookupResult.index >= 0) {
            final ItemStack slotItemStack = weaponInstance.getPlayer().inventory.getStackInSlot(lookupResult.index);
            final ItemAttachment<ItemMelee> nextAttachment = (ItemAttachment<ItemMelee>)slotItemStack.getItem();
            if (nextAttachment.getApply() != null) {
                nextAttachment.getApply().apply(nextAttachment, weaponInstance.getWeapon(), weaponInstance.getPlayer());
            }
            else if (nextAttachment.getApply3() != null) {
                nextAttachment.getApply3().apply(nextAttachment, weaponInstance);
            }
            else if (lookupResult.compatibleAttachment.getMeleeApplyHandler() != null) {
                lookupResult.compatibleAttachment.getMeleeApplyHandler().apply(nextAttachment, weaponInstance);
            }
            CompatibilityProvider.compatibility.consumeInventoryItemFromSlot(weaponInstance.getPlayer(), lookupResult.index);
            activeAttachmentIds[attachmentCategory.ordinal()] = Item.getIdFromItem((Item)nextAttachment);
        }
        else {
            activeAttachmentIds[attachmentCategory.ordinal()] = -1;
        }
        if (currentAttachment != null) {
            CompatibilityProvider.compatibility.addItemToPlayerInventory(weaponInstance.getPlayer(), currentAttachment, lookupResult.index);
        }
        weaponInstance.setActiveAttachmentIds(activeAttachmentIds);
    }
    
    private AttachmentLookupResult next(final AttachmentCategory category, final Item currentAttachment, final PlayerMeleeInstance weaponInstance) {
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
            MeleeAttachmentAspect.logger.debug("Searching for an attachment in slot {}", new Object[] { currentIndex });
            if (currentIndex == -1) {
                result.index = -1;
                break;
            }
            final ItemStack slotItemStack = weaponInstance.getPlayer().inventory.getStackInSlot(currentIndex);
            if (slotItemStack != null && slotItemStack.getItem() instanceof ItemAttachment) {
                final ItemAttachment<ItemMelee> attachmentItemFromInventory = (ItemAttachment<ItemMelee>)slotItemStack.getItem();
                final CompatibleAttachment<ItemMelee> compatibleAttachment;
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
    
    void addAttachment(final ItemAttachment<ItemMelee> attachment, final PlayerMeleeInstance weaponInstance) {
        final int[] activeAttachmentsIds = weaponInstance.getActiveAttachmentIds();
        final int activeAttachmentIdForThisCategory = activeAttachmentsIds[attachment.getCategory().ordinal()];
        ItemAttachment<ItemMelee> currentAttachment = null;
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
    
    ItemAttachment<ItemMelee> removeAttachment(final AttachmentCategory attachmentCategory, final PlayerMeleeInstance weaponInstance) {
        final int[] activeAttachmentIds = weaponInstance.getActiveAttachmentIds();
        final int activeAttachmentIdForThisCategory = activeAttachmentIds[attachmentCategory.ordinal()];
        ItemAttachment<ItemMelee> currentAttachment = null;
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
    
    static ItemAttachment<ItemMelee> getActiveAttachment(final AttachmentCategory category, final PlayerMeleeInstance weaponInstance) {
        ItemAttachment<ItemMelee> itemAttachment = null;
        final int[] activeAttachmentIds2;
        final int[] activeAttachmentIds = activeAttachmentIds2 = weaponInstance.getActiveAttachmentIds();
        for (final int activeIndex : activeAttachmentIds2) {
            if (activeIndex != 0) {
                final Item item = Item.getItemById(activeIndex);
                if (item instanceof ItemAttachment) {
                    final CompatibleAttachment<ItemMelee> compatibleAttachment = weaponInstance.getWeapon().getCompatibleAttachments().get(item);
                    if (compatibleAttachment != null && category == compatibleAttachment.getAttachment().getCategory()) {
                        itemAttachment = compatibleAttachment.getAttachment();
                        break;
                    }
                }
            }
        }
        return itemAttachment;
    }
    
    static boolean isActiveAttachment(final ItemAttachment<ItemMelee> attachment, final PlayerMeleeInstance weaponInstance) {
        final int[] activeAttachmentIds = weaponInstance.getActiveAttachmentIds();
        return Arrays.stream(activeAttachmentIds).anyMatch(attachmentId -> itemAttachment == Item.getItemById(attachmentId));
    }
    
    ItemAttachment<ItemMelee> getActiveAttachment(final PlayerMeleeInstance weaponInstance, final AttachmentCategory category) {
        return weaponInstance.getAttachmentItemWithCategory(category);
    }
    
    private static /* synthetic */ boolean lambda$isActiveAttachment$179(final ItemAttachment itemAttachment, final int attachmentId) {
        return itemAttachment == Item.getItemById(attachmentId);
    }
    
    private /* synthetic */ void lambda$setStateManager$178(final PlayerMeleeInstance instance) {
        this.permitManager.request(new ExitAttachmentModePermit(MeleeState.READY), instance, (p, e) -> {});
    }
    
    private static /* synthetic */ void lambda$null$177(final ExitAttachmentModePermit p, final PlayerMeleeInstance e) {
    }
    
    private static /* synthetic */ Permit lambda$setStateManager$176(final MeleeState s, final PlayerMeleeInstance es) {
        return new EnterAttachmentModePermit(s);
    }
    
    private /* synthetic */ boolean lambda$new$175(final PlayerMeleeInstance es) {
        return System.currentTimeMillis() >= es.getStateUpdateTimestamp() + this.clickSpammingTimeout;
    }
    
    static {
        logger = LogManager.getLogger((Class)MeleeAttachmentAspect.class);
        TypeRegistry.getInstance().register(EnterAttachmentModePermit.class);
        TypeRegistry.getInstance().register(ExitAttachmentModePermit.class);
        TypeRegistry.getInstance().register(ChangeAttachmentPermit.class);
    }
    
    private static class AttachmentLookupResult
    {
        CompatibleAttachment<ItemMelee> compatibleAttachment;
        int index;
        
        private AttachmentLookupResult() {
            super();
            this.index = -1;
        }
        
        AttachmentLookupResult(final MeleeAttachmentAspect$1 x0) {
            this();
        }
    }
    
    public static class EnterAttachmentModePermit extends Permit<MeleeState>
    {
        public EnterAttachmentModePermit() {
            super();
        }
        
        public EnterAttachmentModePermit(final MeleeState state) {
            super(state);
        }
    }
    
    public static class ExitAttachmentModePermit extends Permit<MeleeState>
    {
        public ExitAttachmentModePermit() {
            super();
        }
        
        public ExitAttachmentModePermit(final MeleeState state) {
            super(state);
        }
    }
    
    public static class ChangeAttachmentPermit extends Permit<MeleeState>
    {
        AttachmentCategory attachmentCategory;
        
        public ChangeAttachmentPermit() {
            super();
        }
        
        public ChangeAttachmentPermit(final AttachmentCategory attachmentCategory) {
            super(MeleeState.NEXT_ATTACHMENT);
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
