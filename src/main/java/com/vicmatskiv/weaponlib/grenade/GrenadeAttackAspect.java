package com.vicmatskiv.weaponlib.grenade;

import java.util.function.*;
import com.vicmatskiv.weaponlib.state.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import org.apache.logging.log4j.*;
import java.util.*;
import com.vicmatskiv.weaponlib.*;

public class GrenadeAttackAspect implements Aspect<GrenadeState, PlayerGrenadeInstance>
{
    private static final Logger logger;
    private static final long ALERT_TIMEOUT = 300L;
    private Predicate<PlayerGrenadeInstance> hasSafetyPin;
    private static Predicate<PlayerGrenadeInstance> reequipTimeoutExpired;
    private static Predicate<PlayerGrenadeInstance> isSmokeGrenade;
    private static Predicate<PlayerGrenadeInstance> throwingCompleted;
    private static Predicate<PlayerGrenadeInstance> explosionTimeoutExpired;
    private static final Set<GrenadeState> allowedAttackFromStates;
    private static final Set<GrenadeState> allowedPinOffFromStates;
    private static final Set<GrenadeState> allowedUpdateFromStates;
    private static final int SAFETY_IN_ALERT_TIMEOUT = 1000;
    private ModContext modContext;
    private StateManager<GrenadeState, ? super PlayerGrenadeInstance> stateManager;
    
    public GrenadeAttackAspect(final CommonModContext modContext) {
        super();
        this.hasSafetyPin = (instance -> instance.getWeapon().hasSafetyPin());
        this.modContext = modContext;
    }
    
    @Override
    public void setPermitManager(final PermitManager permitManager) {
    }
    
    @Override
    public void setStateManager(final StateManager<GrenadeState, ? super PlayerGrenadeInstance> stateManager) {
        this.stateManager = stateManager;
        stateManager.in((Aspect<GrenadeState, PlayerGrenadeInstance>)this).change(GrenadeState.READY).to(GrenadeState.SAFETY_PING_OFF).withAction(i -> this.takeSafetyPinOff(i)).when(this.hasSafetyPin).manual().in((Aspect<S, PlayerGrenadeInstance>)this).change(GrenadeState.SAFETY_PING_OFF).to(GrenadeState.STRIKER_LEVER_RELEASED).withAction(i -> this.releaseStrikerLever(i)).manual().in((Aspect<S, PlayerGrenadeInstance>)this).change(GrenadeState.STRIKER_LEVER_RELEASED).to(GrenadeState.EXPLODED_IN_HANDS).withAction(i -> this.explode(i)).when(GrenadeAttackAspect.explosionTimeoutExpired.and(GrenadeAttackAspect.isSmokeGrenade.negate())).automatic().in((Aspect<S, PlayerGrenadeInstance>)this).change(GrenadeState.READY).to(GrenadeState.THROWING).when(this.hasSafetyPin.negate()).manual().in((Aspect<S, PlayerGrenadeInstance>)this).change(GrenadeState.THROWING).to(GrenadeState.THROWN).withAction(i -> this.throwIt(i)).when(GrenadeAttackAspect.throwingCompleted).automatic().in((Aspect<S, ExtendedState>)this).change(GrenadeState.STRIKER_LEVER_RELEASED).to(GrenadeState.THROWING).manual().in((Aspect<S, PlayerGrenadeInstance>)this).change(GrenadeState.THROWN).to(GrenadeState.READY).withAction(i -> this.reequip(i)).when(GrenadeAttackAspect.reequipTimeoutExpired).automatic().in((Aspect<S, PlayerGrenadeInstance>)this).change(GrenadeState.EXPLODED_IN_HANDS).to(GrenadeState.READY).withAction(i -> this.reequip(i)).when(GrenadeAttackAspect.reequipTimeoutExpired).automatic();
    }
    
    private void explode(final PlayerGrenadeInstance instance) {
        GrenadeAttackAspect.logger.debug("Exploding!");
        this.modContext.getChannel().getChannel().sendToServer((IMessage)new GrenadeMessage(instance, 0L));
    }
    
    private void throwIt(final PlayerGrenadeInstance instance) {
        GrenadeAttackAspect.logger.debug("Throwing with state " + ((PlayerItemInstance<Object>)instance).getState());
        long activationTimestamp;
        if (instance.getWeapon().isSmokeOnly()) {
            activationTimestamp = System.currentTimeMillis();
        }
        else if (instance.getWeapon().getExplosionTimeout() > 0) {
            activationTimestamp = instance.getActivationTimestamp();
        }
        else {
            activationTimestamp = -1L;
        }
        CompatibilityProvider.compatibility.playSound(instance.getPlayer(), instance.getWeapon().getThrowSound(), 1.0f, 1.0f);
        this.modContext.getChannel().getChannel().sendToServer((IMessage)new GrenadeMessage(instance, activationTimestamp));
    }
    
    private void reequip(final PlayerGrenadeInstance instance) {
        GrenadeAttackAspect.logger.debug("Reequipping");
    }
    
    private void takeSafetyPinOff(final PlayerGrenadeInstance instance) {
        CompatibilityProvider.compatibility.playSound(instance.getPlayer(), instance.getWeapon().getSafetyPinOffSound(), 1.0f, 1.0f);
        GrenadeAttackAspect.logger.debug("Taking safety pin off");
    }
    
    private void releaseStrikerLever(final PlayerGrenadeInstance instance) {
        GrenadeAttackAspect.logger.debug("Safety pin is off");
        instance.setActivationTimestamp(System.currentTimeMillis());
    }
    
    void onAttackButtonClick(final EntityPlayer player, final boolean throwingFar) {
        final PlayerGrenadeInstance grenadeInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerGrenadeInstance.class);
        if (grenadeInstance != null) {
            grenadeInstance.setThrowingFar(throwingFar);
            this.stateManager.changeStateFromAnyOf(this, grenadeInstance, GrenadeAttackAspect.allowedAttackFromStates, GrenadeState.SAFETY_PING_OFF, GrenadeState.THROWING);
        }
    }
    
    void onAttackButtonUp(final EntityPlayer player, final boolean throwingFar) {
        final PlayerGrenadeInstance grenadeInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerGrenadeInstance.class);
        if (grenadeInstance != null) {
            grenadeInstance.setThrowingFar(throwingFar);
            this.stateManager.changeStateFromAnyOf(this, grenadeInstance, GrenadeAttackAspect.allowedPinOffFromStates, GrenadeState.STRIKER_LEVER_RELEASED);
        }
    }
    
    void onUpdate(final EntityPlayer player) {
        final PlayerGrenadeInstance grenadeInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerGrenadeInstance.class);
        if (grenadeInstance != null) {
            if (grenadeInstance.getState() == GrenadeState.STRIKER_LEVER_RELEASED && !grenadeInstance.getWeapon().isSmokeOnly() && System.currentTimeMillis() > grenadeInstance.getLastSafetyPinAlertTimestamp() + 1000L) {
                long remainingTimeUntilExplosion = grenadeInstance.getWeapon().getExplosionTimeout() - (System.currentTimeMillis() - grenadeInstance.getActivationTimestamp());
                if (remainingTimeUntilExplosion < 0L) {
                    remainingTimeUntilExplosion = 0L;
                }
                final String message = CompatibilityProvider.compatibility.getLocalizedString("gui.grenadeExplodes", Math.round(remainingTimeUntilExplosion / 1000.0f));
                this.modContext.getStatusMessageCenter().addAlertMessage(message, 1, 1000L, 0L);
                grenadeInstance.setLastSafetyPinAlertTimestamp(System.currentTimeMillis());
            }
            this.stateManager.changeStateFromAnyOf(this, grenadeInstance, GrenadeAttackAspect.allowedUpdateFromStates, new GrenadeState[0]);
        }
    }
    
    public void serverThrowGrenade(final EntityPlayer player, final PlayerGrenadeInstance instance, final long activationTimestamp) {
        GrenadeAttackAspect.logger.debug("Throwing grenade");
        final boolean isSmokeGrenade = instance.getWeapon().isSmokeOnly();
        if (activationTimestamp == 0L && !isSmokeGrenade) {
            Explosion.createServerSideExplosion(this.modContext, CompatibilityProvider.compatibility.world((Entity)player), null, player.posX, player.posY, player.posZ, instance.getWeapon().getExplosionStrength(), false, true);
        }
        else if (isSmokeGrenade) {
            final float velocity = instance.isThrowingFar() ? instance.getWeapon().getFarVelocity() : instance.getWeapon().getVelocity();
            final EntitySmokeGrenade entityGrenade = new EntitySmokeGrenade.Builder().withThrower((EntityLivingBase)player).withActivationTimestamp(activationTimestamp).withGrenade(instance.getWeapon()).withSmokeAmount(instance.getWeapon().getExplosionStrength()).withActivationDelay(0L).withActiveDuration(instance.getWeapon().getActiveDuration()).withVelocity(velocity).withGravityVelocity(instance.getWeapon().getGravityVelocity()).withRotationSlowdownFactor(instance.getWeapon().getRotationSlowdownFactor()).build(this.modContext);
            GrenadeAttackAspect.logger.debug("Throwing velocity {} ", new Object[] { velocity });
            CompatibilityProvider.compatibility.spawnEntity(player, entityGrenade);
        }
        else {
            final float velocity = instance.isThrowingFar() ? instance.getWeapon().getFarVelocity() : instance.getWeapon().getVelocity();
            final EntityGrenade entityGrenade2 = new EntityGrenade.Builder().withThrower((EntityLivingBase)player).withActivationTimestamp(activationTimestamp).withGrenade(instance.getWeapon()).withExplosionStrength(instance.getWeapon().getExplosionStrength()).withExplosionTimeout(instance.getWeapon().getExplosionTimeout()).withVelocity(velocity).withGravityVelocity(instance.getWeapon().getGravityVelocity()).withRotationSlowdownFactor(instance.getWeapon().getRotationSlowdownFactor()).build(this.modContext);
            GrenadeAttackAspect.logger.debug("Throwing velocity {} ", new Object[] { velocity });
            CompatibilityProvider.compatibility.spawnEntity(player, entityGrenade2);
        }
        CompatibilityProvider.compatibility.consumeInventoryItemFromSlot(player, instance.getItemInventoryIndex());
    }
    
    int getParticleCount(final float damage) {
        return (int)(-0.11 * (damage - 30.0f) * (damage - 30.0f) + 100.0);
    }
    
    private /* synthetic */ void lambda$setStateManager$190(final PlayerGrenadeInstance i) {
        this.reequip(i);
    }
    
    private /* synthetic */ void lambda$setStateManager$189(final PlayerGrenadeInstance i) {
        this.reequip(i);
    }
    
    private /* synthetic */ void lambda$setStateManager$188(final PlayerGrenadeInstance i) {
        this.throwIt(i);
    }
    
    private /* synthetic */ void lambda$setStateManager$187(final PlayerGrenadeInstance i) {
        this.explode(i);
    }
    
    private /* synthetic */ void lambda$setStateManager$186(final PlayerGrenadeInstance i) {
        this.releaseStrikerLever(i);
    }
    
    private /* synthetic */ void lambda$setStateManager$185(final PlayerGrenadeInstance i) {
        this.takeSafetyPinOff(i);
    }
    
    private static /* synthetic */ boolean lambda$static$184(final PlayerGrenadeInstance instance) {
        return System.currentTimeMillis() >= instance.getStateUpdateTimestamp() + instance.getWeapon().getExplosionTimeout();
    }
    
    private static /* synthetic */ boolean lambda$static$183(final PlayerGrenadeInstance instance) {
        return System.currentTimeMillis() >= instance.getStateUpdateTimestamp() + instance.getWeapon().getTotalThrowingDuration() * 1.1;
    }
    
    private static /* synthetic */ boolean lambda$static$182(final PlayerGrenadeInstance instance) {
        return instance.getWeapon().isSmokeOnly();
    }
    
    private static /* synthetic */ boolean lambda$static$181(final PlayerGrenadeInstance instance) {
        return System.currentTimeMillis() > instance.getStateUpdateTimestamp() + instance.getWeapon().getReequipTimeout();
    }
    
    private static /* synthetic */ boolean lambda$new$180(final PlayerGrenadeInstance instance) {
        return instance.getWeapon().hasSafetyPin();
    }
    
    static {
        logger = LogManager.getLogger((Class)GrenadeAttackAspect.class);
        GrenadeAttackAspect.reequipTimeoutExpired = (instance -> System.currentTimeMillis() > instance.getStateUpdateTimestamp() + instance.getWeapon().getReequipTimeout());
        GrenadeAttackAspect.isSmokeGrenade = (instance -> instance.getWeapon().isSmokeOnly());
        GrenadeAttackAspect.throwingCompleted = (instance -> System.currentTimeMillis() >= instance.getStateUpdateTimestamp() + instance.getWeapon().getTotalThrowingDuration() * 1.1);
        GrenadeAttackAspect.explosionTimeoutExpired = (instance -> System.currentTimeMillis() >= instance.getStateUpdateTimestamp() + instance.getWeapon().getExplosionTimeout());
        allowedAttackFromStates = new HashSet<GrenadeState>(Arrays.asList(GrenadeState.READY, GrenadeState.STRIKER_LEVER_RELEASED));
        allowedPinOffFromStates = new HashSet<GrenadeState>(Arrays.asList(GrenadeState.SAFETY_PING_OFF));
        allowedUpdateFromStates = new HashSet<GrenadeState>(Arrays.asList(GrenadeState.STRIKER_LEVER_RELEASED, GrenadeState.THROWING, GrenadeState.THROWN, GrenadeState.EXPLODED_IN_HANDS));
    }
}
