package com.vicmatskiv.weaponlib;

import java.util.function.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.state.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import org.apache.logging.log4j.*;
import com.vicmatskiv.weaponlib.network.*;
import java.util.*;

public class WeaponReloadAspect implements Aspect<WeaponState, PlayerWeaponInstance>
{
    private static final Logger logger;
    private static final long ALERT_TIMEOUT = 500L;
    private static final Set<WeaponState> allowedUpdateFromStates;
    private static Predicate<PlayerWeaponInstance> sprinting;
    private static Predicate<PlayerWeaponInstance> supportsDirectBulletLoad;
    private static Predicate<PlayerWeaponInstance> magazineAttached;
    private static Predicate<PlayerWeaponInstance> reloadAnimationCompleted;
    private static Predicate<PlayerWeaponInstance> unloadAnimationCompleted;
    private Predicate<PlayerWeaponInstance> inventoryHasFreeSlots;
    private static Predicate<PlayerWeaponInstance> alertTimeoutExpired;
    private Predicate<ItemStack> magazineNotEmpty;
    private ModContext modContext;
    private PermitManager permitManager;
    private StateManager<WeaponState, ? super PlayerWeaponInstance> stateManager;
    
    public WeaponReloadAspect(final ModContext modContext) {
        super();
        this.inventoryHasFreeSlots = (weaponInstance -> CompatibilityProvider.compatibility.inventoryHasFreeSlots(weaponInstance.getPlayer()));
        this.magazineNotEmpty = (magazineStack -> Tags.getAmmo(magazineStack) > 0);
        this.modContext = modContext;
    }
    
    @Override
    public void setStateManager(final StateManager<WeaponState, ? super PlayerWeaponInstance> stateManager) {
        if (this.permitManager == null) {
            throw new IllegalStateException("Permit manager not initialized");
        }
        this.stateManager = stateManager.in((Aspect<WeaponState, PlayerWeaponInstance>)this).change(WeaponState.READY).to(WeaponState.LOAD).when(WeaponReloadAspect.supportsDirectBulletLoad.or(WeaponReloadAspect.magazineAttached.negate())).withPermit((s, es) -> new LoadPermit(s), this.modContext.getPlayerItemInstanceRegistry()::update, this.permitManager).withAction((c, f, t, p) -> this.completeClientLoad(c, (LoadPermit)p)).manual().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.LOAD).to(WeaponState.READY).when(WeaponReloadAspect.reloadAnimationCompleted).automatic().in((Aspect<S, PlayerWeaponInstance>)this).prepare((c, f, t) -> this.prepareUnload(c), WeaponReloadAspect.unloadAnimationCompleted).change(WeaponState.READY).to(WeaponState.UNLOAD).when(WeaponReloadAspect.magazineAttached.and(this.inventoryHasFreeSlots)).withPermit((s, c) -> new UnloadPermit(s), this.modContext.getPlayerItemInstanceRegistry()::update, this.permitManager).withAction((c, f, t, p) -> this.completeClientUnload(c, (UnloadPermit)p)).manual().in((Aspect<S, ExtendedState>)this).change(WeaponState.UNLOAD).to(WeaponState.READY).automatic().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.READY).to(WeaponState.ALERT).when(this.inventoryHasFreeSlots.negate()).withAction(this::inventoryFullAlert).manual().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.ALERT).to(WeaponState.READY).when(WeaponReloadAspect.alertTimeoutExpired).automatic();
    }
    
    @Override
    public void setPermitManager(final PermitManager permitManager) {
        (this.permitManager = permitManager).registerEvaluator(LoadPermit.class, PlayerWeaponInstance.class, (p, c) -> this.processLoadPermit(p, c));
        permitManager.registerEvaluator(UnloadPermit.class, PlayerWeaponInstance.class, (p, c) -> this.processUnloadPermit(p, c));
    }
    
    public void reloadMainHeldItem(final EntityPlayer player) {
        final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
        if (instance != null) {
            this.stateManager.changeState(this, instance, WeaponState.LOAD, WeaponState.UNLOAD, WeaponState.ALERT);
        }
    }
    
    void updateMainHeldItem(final EntityPlayer player) {
        final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
        if (instance != null) {
            this.stateManager.changeStateFromAnyOf(this, instance, WeaponReloadAspect.allowedUpdateFromStates, new WeaponState[0]);
        }
    }
    
    private void processLoadPermit(final LoadPermit p, final PlayerWeaponInstance weaponInstance) {
        WeaponReloadAspect.logger.debug("Processing load permit on server for {}", new Object[] { weaponInstance });
        final ItemStack weaponItemStack = weaponInstance.getItemStack();
        if (weaponItemStack == null) {
            return;
        }
        Permit.Status status = Permit.Status.GRANTED;
        final Weapon weapon = (Weapon)weaponInstance.getItem();
        final EntityPlayer player = weaponInstance.getPlayer();
        if (CompatibilityProvider.compatibility.getTagCompound(weaponItemStack) == null) {
            CompatibilityProvider.compatibility.setTagCompound(weaponItemStack, new NBTTagCompound());
        }
        final List<ItemMagazine> compatibleMagazines = weapon.getCompatibleMagazines();
        final List<ItemAttachment<Weapon>> compatibleBullets = weapon.getCompatibleAttachments(ItemBullet.class);
        if (!compatibleMagazines.isEmpty()) {
            final ItemAttachment<Weapon> existingMagazine = WeaponAttachmentAspect.getActiveAttachment(AttachmentCategory.MAGAZINE, weaponInstance);
            int ammo = Tags.getAmmo(weaponItemStack);
            if (existingMagazine == null) {
                ammo = 0;
                final ItemStack magazineItemStack = CompatibilityProvider.compatibility.tryConsumingCompatibleItem(compatibleMagazines, 1, player, this.magazineNotEmpty, magazineStack -> true);
                if (magazineItemStack != null) {
                    ammo = Tags.getAmmo(magazineItemStack);
                    Tags.setAmmo(weaponItemStack, ammo);
                    WeaponReloadAspect.logger.debug("Setting server side ammo for {} to {}", new Object[] { weaponInstance, ammo });
                    this.modContext.getAttachmentAspect().addAttachment((ItemAttachment<Weapon>)magazineItemStack.getItem(), weaponInstance);
                    CompatibilityProvider.compatibility.playSoundToNearExcept(player, weapon.getReloadSound(), 1.0f, 1.0f);
                }
                else {
                    status = Permit.Status.DENIED;
                }
            }
            weaponInstance.setAmmo(ammo);
        }
        else {
            final ItemStack consumedStack;
            if (!compatibleBullets.isEmpty() && (consumedStack = CompatibilityProvider.compatibility.tryConsumingCompatibleItem(compatibleBullets, Math.min(weapon.getMaxBulletsPerReload(), weapon.getAmmoCapacity() - weaponInstance.getAmmo()), player, i -> true)) != null) {
                final int ammo2 = weaponInstance.getAmmo() + CompatibilityProvider.compatibility.getStackSize(consumedStack);
                Tags.setAmmo(weaponItemStack, ammo2);
                weaponInstance.setAmmo(ammo2);
                CompatibilityProvider.compatibility.playSoundToNearExcept(player, weapon.getReloadSound(), 1.0f, 1.0f);
            }
            else if (CompatibilityProvider.compatibility.consumeInventoryItem(player.inventory, weapon.builder.ammo)) {
                Tags.setAmmo(weaponItemStack, weapon.builder.ammoCapacity);
                weaponInstance.setAmmo(weapon.builder.ammoCapacity);
                CompatibilityProvider.compatibility.playSoundToNearExcept(player, weapon.getReloadSound(), 1.0f, 1.0f);
            }
            else {
                WeaponReloadAspect.logger.debug("No suitable ammo found for {}. Permit denied.", new Object[] { weaponInstance });
                status = Permit.Status.DENIED;
            }
        }
        p.setStatus(status);
    }
    
    private void prepareUnload(final PlayerWeaponInstance weaponInstance) {
        CompatibilityProvider.compatibility.playSound(weaponInstance.getPlayer(), weaponInstance.getWeapon().getUnloadSound(), 1.0f, 1.0f);
    }
    
    private void processUnloadPermit(final UnloadPermit p, final PlayerWeaponInstance weaponInstance) {
        WeaponReloadAspect.logger.debug("Processing unload permit on server for {}", new Object[] { weaponInstance });
        final ItemStack weaponItemStack = weaponInstance.getItemStack();
        final EntityPlayer player = weaponInstance.getPlayer();
        final Weapon weapon = (Weapon)weaponItemStack.getItem();
        if (CompatibilityProvider.compatibility.getTagCompound(weaponItemStack) != null) {
            final ItemAttachment<Weapon> attachment = this.modContext.getAttachmentAspect().removeAttachment(AttachmentCategory.MAGAZINE, weaponInstance);
            if (attachment instanceof ItemMagazine) {
                final ItemStack attachmentItemStack = ((ItemMagazine)attachment).createItemStack();
                Tags.setAmmo(attachmentItemStack, weaponInstance.getAmmo());
                if (!player.inventory.addItemStackToInventory(attachmentItemStack)) {
                    WeaponReloadAspect.logger.error("Cannot add attachment " + attachment + " for " + weaponInstance + "back to the inventory");
                }
            }
            Tags.setAmmo(weaponItemStack, 0);
            weaponInstance.setAmmo(0);
            CompatibilityProvider.compatibility.playSoundToNearExcept(player, weapon.getUnloadSound(), 1.0f, 1.0f);
            p.setStatus(Permit.Status.GRANTED);
        }
        else {
            p.setStatus(Permit.Status.DENIED);
        }
        p.setStatus(Permit.Status.GRANTED);
    }
    
    private void completeClientLoad(final PlayerWeaponInstance weaponInstance, final LoadPermit permit) {
        if (permit == null) {
            WeaponReloadAspect.logger.error("Permit is null, something went wrong");
            return;
        }
        if (permit.getStatus() == Permit.Status.GRANTED) {
            CompatibilityProvider.compatibility.playSound(weaponInstance.getPlayer(), weaponInstance.getWeapon().getReloadSound(), 1.0f, 1.0f);
        }
    }
    
    private void completeClientUnload(final PlayerWeaponInstance weaponInstance, final UnloadPermit p) {
    }
    
    public void inventoryFullAlert(final PlayerWeaponInstance weaponInstance) {
        this.modContext.getStatusMessageCenter().addAlertMessage(CompatibilityProvider.compatibility.getLocalizedString("gui.inventoryFull", new Object[0]), 3, 250L, 200L);
    }
    
    private static /* synthetic */ boolean lambda$processLoadPermit$71(final ItemStack i) {
        return true;
    }
    
    private static /* synthetic */ boolean lambda$processLoadPermit$70(final ItemStack magazineStack) {
        return true;
    }
    
    private /* synthetic */ void lambda$setPermitManager$69(final UnloadPermit p, final PlayerWeaponInstance c) {
        this.processUnloadPermit(p, c);
    }
    
    private /* synthetic */ void lambda$setPermitManager$68(final LoadPermit p, final PlayerWeaponInstance c) {
        this.processLoadPermit(p, c);
    }
    
    private /* synthetic */ void lambda$setStateManager$67(final PlayerWeaponInstance c, final WeaponState f, final WeaponState t, final Permit p) {
        this.completeClientUnload(c, (UnloadPermit)p);
    }
    
    private static /* synthetic */ Permit lambda$setStateManager$66(final WeaponState s, final PlayerWeaponInstance c) {
        return new UnloadPermit(s);
    }
    
    private /* synthetic */ void lambda$setStateManager$65(final PlayerWeaponInstance c, final WeaponState f, final WeaponState t) {
        this.prepareUnload(c);
    }
    
    private /* synthetic */ void lambda$setStateManager$64(final PlayerWeaponInstance c, final WeaponState f, final WeaponState t, final Permit p) {
        this.completeClientLoad(c, (LoadPermit)p);
    }
    
    private static /* synthetic */ Permit lambda$setStateManager$63(final WeaponState s, final PlayerWeaponInstance es) {
        return new LoadPermit(s);
    }
    
    private static /* synthetic */ boolean lambda$new$62(final ItemStack magazineStack) {
        return Tags.getAmmo(magazineStack) > 0;
    }
    
    private static /* synthetic */ boolean lambda$static$61(final PlayerWeaponInstance instance) {
        return System.currentTimeMillis() >= 500L + instance.getStateUpdateTimestamp();
    }
    
    private static /* synthetic */ boolean lambda$new$60(final PlayerWeaponInstance weaponInstance) {
        return CompatibilityProvider.compatibility.inventoryHasFreeSlots(weaponInstance.getPlayer());
    }
    
    private static /* synthetic */ boolean lambda$static$59(final PlayerWeaponInstance weaponInstance) {
        return System.currentTimeMillis() >= weaponInstance.getStateUpdateTimestamp() + weaponInstance.getWeapon().getTotalUnloadingDuration() * 1.1;
    }
    
    private static /* synthetic */ boolean lambda$static$58(final PlayerWeaponInstance weaponInstance) {
        return System.currentTimeMillis() >= weaponInstance.getStateUpdateTimestamp() + Math.max((double)weaponInstance.getWeapon().builder.reloadingTimeout, weaponInstance.getWeapon().getTotalReloadingDuration() * 1.1);
    }
    
    private static /* synthetic */ boolean lambda$static$57(final PlayerWeaponInstance weaponInstance) {
        return WeaponAttachmentAspect.getActiveAttachment(AttachmentCategory.MAGAZINE, weaponInstance) != null;
    }
    
    private static /* synthetic */ boolean lambda$static$56(final PlayerWeaponInstance weaponInstance) {
        return weaponInstance.getWeapon().getAmmoCapacity() > 0;
    }
    
    private static /* synthetic */ boolean lambda$static$55(final PlayerWeaponInstance instance) {
        return instance.getPlayer().isSprinting();
    }
    
    static {
        logger = LogManager.getLogger((Class)WeaponReloadAspect.class);
        TypeRegistry.getInstance().register(UnloadPermit.class);
        TypeRegistry.getInstance().register(LoadPermit.class);
        TypeRegistry.getInstance().register(PlayerWeaponInstance.class);
        allowedUpdateFromStates = new HashSet<WeaponState>(Arrays.asList(WeaponState.LOAD_REQUESTED, WeaponState.LOAD, WeaponState.UNLOAD_PREPARING, WeaponState.UNLOAD_REQUESTED, WeaponState.UNLOAD, WeaponState.ALERT));
        WeaponReloadAspect.sprinting = (instance -> instance.getPlayer().isSprinting());
        WeaponReloadAspect.supportsDirectBulletLoad = (weaponInstance -> weaponInstance.getWeapon().getAmmoCapacity() > 0);
        WeaponReloadAspect.magazineAttached = (weaponInstance -> WeaponAttachmentAspect.getActiveAttachment(AttachmentCategory.MAGAZINE, weaponInstance) != null);
        WeaponReloadAspect.reloadAnimationCompleted = (weaponInstance -> System.currentTimeMillis() >= weaponInstance.getStateUpdateTimestamp() + Math.max((double)weaponInstance.getWeapon().builder.reloadingTimeout, weaponInstance.getWeapon().getTotalReloadingDuration() * 1.1));
        WeaponReloadAspect.unloadAnimationCompleted = (weaponInstance -> System.currentTimeMillis() >= weaponInstance.getStateUpdateTimestamp() + weaponInstance.getWeapon().getTotalUnloadingDuration() * 1.1);
        WeaponReloadAspect.alertTimeoutExpired = (instance -> System.currentTimeMillis() >= 500L + instance.getStateUpdateTimestamp());
    }
    
    public static class UnloadPermit extends Permit<WeaponState>
    {
        public UnloadPermit() {
            super();
        }
        
        public UnloadPermit(final WeaponState state) {
            super(state);
        }
    }
    
    public static class LoadPermit extends Permit<WeaponState>
    {
        public LoadPermit() {
            super();
        }
        
        public LoadPermit(final WeaponState state) {
            super(state);
        }
    }
}
