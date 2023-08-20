package com.vicmatskiv.weaponlib;

import java.util.function.*;
import com.vicmatskiv.weaponlib.state.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import java.util.*;

public class WeaponFireAspect implements Aspect<WeaponState, PlayerWeaponInstance>
{
    private static final float FLASH_X_OFFSET_ZOOMED = 0.0f;
    private static final long ALERT_TIMEOUT = 500L;
    private static Predicate<PlayerWeaponInstance> readyToShootAccordingToFireRate;
    private static Predicate<PlayerWeaponInstance> readyToShootAccordingToFireMode;
    private static Predicate<PlayerWeaponInstance> hasAmmo;
    private static Predicate<PlayerWeaponInstance> ejectSpentRoundRequired;
    private static Predicate<PlayerWeaponInstance> ejectSpentRoundTimeoutExpired;
    private static Predicate<PlayerWeaponInstance> alertTimeoutExpired;
    private static Predicate<PlayerWeaponInstance> sprinting;
    private static final Set<WeaponState> allowedFireOrEjectFromStates;
    private static final Set<WeaponState> allowedUpdateFromStates;
    private ModContext modContext;
    private StateManager<WeaponState, ? super PlayerWeaponInstance> stateManager;
    
    public WeaponFireAspect(final CommonModContext modContext) {
        super();
        this.modContext = modContext;
    }
    
    @Override
    public void setPermitManager(final PermitManager permitManager) {
    }
    
    @Override
    public void setStateManager(final StateManager<WeaponState, ? super PlayerWeaponInstance> stateManager) {
        this.stateManager = stateManager;
        stateManager.in((Aspect<WeaponState, PlayerWeaponInstance>)this).change(WeaponState.READY).to(WeaponState.ALERT).when(WeaponFireAspect.hasAmmo.negate()).withAction(this::cannotFire).manual().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.ALERT).to(WeaponState.READY).when(WeaponFireAspect.alertTimeoutExpired).automatic().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.READY).to(WeaponState.FIRING).when(WeaponFireAspect.hasAmmo.and(WeaponFireAspect.sprinting.negate()).and(WeaponFireAspect.readyToShootAccordingToFireRate)).withAction(this::fire).manual().in((Aspect<S, ExtendedState>)this).change(WeaponState.FIRING).to(WeaponState.RECOILED).automatic().in((Aspect<S, ExtendedState>)this).change(WeaponState.RECOILED).to(WeaponState.PAUSED).automatic().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.PAUSED).to(WeaponState.EJECT_REQUIRED).when(WeaponFireAspect.ejectSpentRoundRequired).manual().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.EJECT_REQUIRED).to(WeaponState.EJECTING).withAction(this::ejectSpentRound).manual().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.EJECTING).to(WeaponState.READY).when(WeaponFireAspect.ejectSpentRoundTimeoutExpired).automatic().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.PAUSED).to(WeaponState.FIRING).when(WeaponFireAspect.hasAmmo.and(WeaponFireAspect.sprinting.negate()).and(WeaponFireAspect.readyToShootAccordingToFireMode).and(WeaponFireAspect.readyToShootAccordingToFireRate)).withAction(this::fire).manual().in((Aspect<S, PlayerWeaponInstance>)this).change(WeaponState.PAUSED).to(WeaponState.READY).when(WeaponFireAspect.ejectSpentRoundRequired.negate()).withAction(PlayerWeaponInstance::resetCurrentSeries).manual();
    }
    
    void onFireButtonClick(final EntityPlayer player) {
        final PlayerWeaponInstance weaponInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
        if (weaponInstance != null) {
            this.stateManager.changeStateFromAnyOf(this, weaponInstance, WeaponFireAspect.allowedFireOrEjectFromStates, WeaponState.FIRING, WeaponState.EJECTING, WeaponState.ALERT);
        }
    }
    
    void onFireButtonRelease(final EntityPlayer player) {
        final PlayerWeaponInstance weaponInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
        if (weaponInstance != null) {
            this.stateManager.changeState(this, weaponInstance, WeaponState.EJECT_REQUIRED, WeaponState.READY);
        }
    }
    
    void onUpdate(final EntityPlayer player) {
        final PlayerWeaponInstance weaponInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
        if (weaponInstance != null) {
            this.stateManager.changeStateFromAnyOf(this, weaponInstance, WeaponFireAspect.allowedUpdateFromStates, new WeaponState[0]);
        }
    }
    
    private void cannotFire(final PlayerWeaponInstance weaponInstance) {
        if (weaponInstance.getAmmo() == 0) {
            String message;
            if (weaponInstance.getWeapon().getAmmoCapacity() == 0 && this.modContext.getAttachmentAspect().getActiveAttachment(weaponInstance, AttachmentCategory.MAGAZINE) == null) {
                message = CompatibilityProvider.compatibility.getLocalizedString("gui.noMagazine", new Object[0]);
            }
            else {
                message = CompatibilityProvider.compatibility.getLocalizedString("gui.noAmmo", new Object[0]);
            }
            this.modContext.getStatusMessageCenter().addAlertMessage(message, 3, 250L, 200L);
            CompatibilityProvider.compatibility.playSound(weaponInstance.getPlayer(), this.modContext.getNoAmmoSound(), 1.0f, 1.0f);
        }
    }
    
    private void fire(final PlayerWeaponInstance weaponInstance) {
        final EntityPlayer player = weaponInstance.getPlayer();
        final Weapon weapon = (Weapon)weaponInstance.getItem();
        final Random random = player.getRNG();
        this.modContext.getChannel().getChannel().sendToServer((IMessage)new TryFireMessage(true));
        final boolean silencerOn = this.modContext.getAttachmentAspect().isSilencerOn(weaponInstance);
        CompatibilityProvider.compatibility.playSound(player, silencerOn ? weapon.getSilencedShootSound() : weapon.getShootSound(), silencerOn ? weapon.getSilencedShootSoundVolume() : weapon.getShootSoundVolume(), 1.0f);
        player.rotationPitch -= weaponInstance.getRecoil();
        final float rotationYawFactor = -1.0f + random.nextFloat() * 2.0f;
        player.rotationYaw += weaponInstance.getRecoil() * rotationYawFactor;
        final Boolean muzzleFlash = this.modContext.getConfigurationManager().getProjectiles().isMuzzleEffects();
        if (muzzleFlash == null || muzzleFlash) {
            if (weapon.builder.flashIntensity > 0.0f) {
                this.modContext.getEffectManager().spawnFlashParticle(player, weapon.builder.flashIntensity, weapon.builder.flashScale.get(), weaponInstance.isAimed() ? 0.0f : (CompatibilityProvider.compatibility.getEffectOffsetX() + weapon.builder.flashOffsetX.get()), CompatibilityProvider.compatibility.getEffectOffsetY() + weapon.builder.flashOffsetY.get());
            }
            this.modContext.getEffectManager().spawnSmokeParticle(player, CompatibilityProvider.compatibility.getEffectOffsetX() + weapon.builder.smokeOffsetX.get(), CompatibilityProvider.compatibility.getEffectOffsetY() + weapon.builder.smokeOffsetY.get());
        }
        weaponInstance.setSeriesShotCount(weaponInstance.getSeriesShotCount() + 1);
        weaponInstance.setLastFireTimestamp(System.currentTimeMillis());
        weaponInstance.setAmmo(weaponInstance.getAmmo() - 1);
    }
    
    private void ejectSpentRound(final PlayerWeaponInstance weaponInstance) {
        final EntityPlayer player = weaponInstance.getPlayer();
        CompatibilityProvider.compatibility.playSound(player, weaponInstance.getWeapon().getEjectSpentRoundSound(), 1.0f, 1.0f);
    }
    
    void serverFire(final EntityPlayer player, final ItemStack itemStack) {
        if (!(itemStack.getItem() instanceof Weapon)) {
            return;
        }
        final Weapon weapon = (Weapon)itemStack.getItem();
        for (int i = 0; i < weapon.builder.pellets; ++i) {
            final WeaponSpawnEntity spawnEntity = (WeaponSpawnEntity)weapon.builder.spawnEntityWith.apply(weapon, player);
            CompatibilityProvider.compatibility.spawnEntity(player, spawnEntity);
        }
        final PlayerWeaponInstance playerWeaponInstance = Tags.getInstance(itemStack, PlayerWeaponInstance.class);
        if (weapon.isShellCasingEjectEnabled()) {
            final EntityShellCasing entityShellCasing = (EntityShellCasing)weapon.builder.spawnShellWith.apply(playerWeaponInstance, player);
            if (entityShellCasing != null) {
                CompatibilityProvider.compatibility.spawnEntity(player, entityShellCasing);
            }
        }
        final boolean silencerOn = this.modContext.getAttachmentAspect().isSilencerOn(playerWeaponInstance);
        CompatibilityProvider.compatibility.playSoundToNearExcept(player, (playerWeaponInstance != null && silencerOn) ? weapon.getSilencedShootSound() : weapon.getShootSound(), silencerOn ? weapon.getSilencedShootSoundVolume() : weapon.getShootSoundVolume(), 1.0f);
    }
    
    private static /* synthetic */ boolean lambda$static$78(final PlayerWeaponInstance instance) {
        return instance.getPlayer().isSprinting();
    }
    
    private static /* synthetic */ boolean lambda$static$77(final PlayerWeaponInstance instance) {
        return System.currentTimeMillis() >= 500L + instance.getStateUpdateTimestamp();
    }
    
    private static /* synthetic */ boolean lambda$static$76(final PlayerWeaponInstance instance) {
        return System.currentTimeMillis() >= instance.getWeapon().builder.pumpTimeoutMilliseconds + instance.getStateUpdateTimestamp();
    }
    
    private static /* synthetic */ boolean lambda$static$75(final PlayerWeaponInstance instance) {
        return instance.getWeapon().ejectSpentRoundRequired();
    }
    
    private static /* synthetic */ boolean lambda$static$74(final PlayerWeaponInstance instance) {
        return instance.getAmmo() > 0;
    }
    
    private static /* synthetic */ boolean lambda$static$73(final PlayerWeaponInstance instance) {
        return instance.getSeriesShotCount() < instance.getMaxShots();
    }
    
    private static /* synthetic */ boolean lambda$static$72(final PlayerWeaponInstance instance) {
        return System.currentTimeMillis() - instance.getLastFireTimestamp() >= 50.0f / instance.getWeapon().builder.fireRate;
    }
    
    static {
        WeaponFireAspect.readyToShootAccordingToFireRate = (instance -> System.currentTimeMillis() - instance.getLastFireTimestamp() >= 50.0f / instance.getWeapon().builder.fireRate);
        WeaponFireAspect.readyToShootAccordingToFireMode = (instance -> instance.getSeriesShotCount() < instance.getMaxShots());
        WeaponFireAspect.hasAmmo = (instance -> instance.getAmmo() > 0);
        WeaponFireAspect.ejectSpentRoundRequired = (instance -> instance.getWeapon().ejectSpentRoundRequired());
        WeaponFireAspect.ejectSpentRoundTimeoutExpired = (instance -> System.currentTimeMillis() >= instance.getWeapon().builder.pumpTimeoutMilliseconds + instance.getStateUpdateTimestamp());
        WeaponFireAspect.alertTimeoutExpired = (instance -> System.currentTimeMillis() >= 500L + instance.getStateUpdateTimestamp());
        WeaponFireAspect.sprinting = (instance -> instance.getPlayer().isSprinting());
        allowedFireOrEjectFromStates = new HashSet<WeaponState>(Arrays.asList(WeaponState.READY, WeaponState.PAUSED, WeaponState.EJECT_REQUIRED));
        allowedUpdateFromStates = new HashSet<WeaponState>(Arrays.asList(WeaponState.EJECTING, WeaponState.PAUSED, WeaponState.FIRING, WeaponState.RECOILED, WeaponState.PAUSED, WeaponState.ALERT));
    }
}
