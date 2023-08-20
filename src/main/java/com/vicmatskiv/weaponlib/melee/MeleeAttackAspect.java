package com.vicmatskiv.weaponlib.melee;

import java.util.function.*;
import com.vicmatskiv.weaponlib.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.util.*;
import com.vicmatskiv.weaponlib.particle.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.apache.logging.log4j.*;
import java.util.*;
import com.vicmatskiv.weaponlib.*;

public class MeleeAttackAspect implements Aspect<MeleeState, PlayerMeleeInstance>
{
    private static final Logger logger;
    private static final long STUB_DURATION = 250L;
    private static final long HEAVY_STUB_DURATION = 250L;
    private static final long ALERT_TIMEOUT = 300L;
    private static Predicate<PlayerMeleeInstance> attackTimeoutExpired;
    private static Predicate<PlayerMeleeInstance> heavyAttackTimeoutExpired;
    private static Predicate<PlayerMeleeInstance> attackCooldownTimeoutExpired;
    private static Predicate<PlayerMeleeInstance> heavyAttackCooldownTimeoutExpired;
    private static Predicate<PlayerMeleeInstance> readyToStab;
    private static Predicate<PlayerMeleeInstance> readyToHeavyStab;
    private static final Set<MeleeState> allowedAttackFromStates;
    private static final Set<MeleeState> allowedUpdateFromStates;
    private ModContext modContext;
    private StateManager<MeleeState, ? super PlayerMeleeInstance> stateManager;
    
    public MeleeAttackAspect(final CommonModContext modContext) {
        super();
        this.modContext = modContext;
    }
    
    @Override
    public void setPermitManager(final PermitManager permitManager) {
    }
    
    @Override
    public void setStateManager(final StateManager<MeleeState, ? super PlayerMeleeInstance> stateManager) {
        this.stateManager = stateManager;
        stateManager.in((Aspect<MeleeState, PlayerMeleeInstance>)this).change(MeleeState.READY).to(MeleeState.ATTACKING).when(MeleeAttackAspect.attackCooldownTimeoutExpired).manual().in((Aspect<S, PlayerMeleeInstance>)this).change(MeleeState.ATTACKING).to(MeleeState.ATTACKING_STABBING).withAction(i -> this.attack(i, false)).when(MeleeAttackAspect.readyToStab).automatic().in((Aspect<S, PlayerMeleeInstance>)this).change(MeleeState.ATTACKING_STABBING).to(MeleeState.READY).withAction(i -> i.setLastAttackTimestamp(System.currentTimeMillis())).when(MeleeAttackAspect.attackTimeoutExpired).automatic().in((Aspect<S, PlayerMeleeInstance>)this).change(MeleeState.READY).to(MeleeState.HEAVY_ATTACKING).when(MeleeAttackAspect.heavyAttackCooldownTimeoutExpired).manual().in((Aspect<S, PlayerMeleeInstance>)this).change(MeleeState.HEAVY_ATTACKING).to(MeleeState.HEAVY_ATTACKING_STABBING).withAction(i -> this.attack(i, true)).when(MeleeAttackAspect.readyToHeavyStab).automatic().in((Aspect<S, PlayerMeleeInstance>)this).change(MeleeState.HEAVY_ATTACKING_STABBING).to(MeleeState.READY).withAction(i -> i.setLastAttackTimestamp(System.currentTimeMillis())).when(MeleeAttackAspect.heavyAttackTimeoutExpired).automatic();
    }
    
    void onAttackButtonClick(final EntityPlayer player) {
        final PlayerMeleeInstance weaponInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerMeleeInstance.class);
        if (weaponInstance != null) {
            this.stateManager.changeStateFromAnyOf(this, weaponInstance, MeleeAttackAspect.allowedAttackFromStates, MeleeState.ATTACKING, MeleeState.ALERT);
        }
    }
    
    void onHeavyAttackButtonClick(final EntityPlayer player) {
        final PlayerMeleeInstance weaponInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerMeleeInstance.class);
        if (weaponInstance != null) {
            this.stateManager.changeStateFromAnyOf(this, weaponInstance, MeleeAttackAspect.allowedAttackFromStates, MeleeState.HEAVY_ATTACKING, MeleeState.ALERT);
        }
    }
    
    void onUpdate(final EntityPlayer player) {
        final PlayerMeleeInstance weaponInstance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerMeleeInstance.class);
        if (weaponInstance != null) {
            this.stateManager.changeStateFromAnyOf(this, weaponInstance, MeleeAttackAspect.allowedUpdateFromStates, new MeleeState[0]);
        }
    }
    
    private void cannotAttack(final PlayerMeleeInstance meleeInstance) {
        this.modContext.getStatusMessageCenter().addAlertMessage(CompatibilityProvider.compatibility.getLocalizedString("gui.coolingDown", new Object[0]), 2, 200L, 100L);
        CompatibilityProvider.compatibility.playSound(meleeInstance.getPlayer(), this.modContext.getNoAmmoSound(), 1.0f, 1.0f);
    }
    
    private void attack(final PlayerMeleeInstance meleeInstance, final boolean isHeavyAttack) {
        final CompatibleRayTraceResult objectMouseOver = CompatibilityProvider.compatibility.getObjectMouseOver();
        if (objectMouseOver != null) {
            final EntityPlayer player = CompatibilityProvider.compatibility.clientPlayer();
            final World world = CompatibilityProvider.compatibility.world((Entity)player);
            CompatibilityProvider.compatibility.playSound(player, isHeavyAttack ? meleeInstance.getWeapon().getHeavyAtackSound() : meleeInstance.getWeapon().getLightAtackSound(), 1.0f, 1.0f);
            switch (objectMouseOver.getTypeOfHit()) {
                case ENTITY: {
                    this.attackEntity(objectMouseOver.getEntityHit(), player, meleeInstance, isHeavyAttack);
                    break;
                }
                case BLOCK: {
                    if (!CompatibilityProvider.compatibility.isAirBlock(world, objectMouseOver.getBlockPos())) {
                        CompatibilityProvider.compatibility.clickBlock(objectMouseOver.getBlockPos(), objectMouseOver.getSideHit());
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void attackEntity(final Entity entity, final EntityPlayer player, final PlayerMeleeInstance instance, final boolean isHeavyAttack) {
        this.modContext.getChannel().getChannel().sendToServer((IMessage)new TryAttackMessage(instance, entity, isHeavyAttack));
        entity.attackEntityFrom(DamageSource.causePlayerDamage(player), instance.getWeapon().getDamage(isHeavyAttack));
    }
    
    public void serverAttack(final EntityPlayer player, final PlayerMeleeInstance instance, final Entity entity, final boolean isHeavyAttack) {
        MeleeAttackAspect.logger.debug("Player {} hits {} with {} in state {} with damage {}", new Object[] { player, entity, instance, ((PlayerItemInstance<Object>)instance).getState(), instance.getWeapon().getDamage(isHeavyAttack) });
        final float damage = instance.getWeapon().getDamage(isHeavyAttack);
        entity.attackEntityFrom(DamageSource.causePlayerDamage(player), damage);
        final CompatibleTargetPoint point = new CompatibleTargetPoint(entity.dimension, entity.posX, entity.posY, entity.posZ, 100.0);
        final double motionX = entity.posX - player.posX;
        final double motionY = entity.posY - player.posY;
        final double motionZ = entity.posZ - player.posZ;
        final int count = this.getParticleCount(damage);
        MeleeAttackAspect.logger.debug("Generating {} particle(s) per damage {}", new Object[] { count, damage });
        this.modContext.getChannel().sendToAllAround(new SpawnParticleMessage(SpawnParticleMessage.ParticleType.BLOOD, count, entity.posX - motionX / 2.0, entity.posY - motionY / 2.0, entity.posZ - motionZ / 2.0), point);
    }
    
    int getParticleCount(final float damage) {
        return (int)(-0.11 * (damage - 30.0f) * (damage - 30.0f) + 100.0);
    }
    
    private static /* synthetic */ void lambda$setStateManager$174(final PlayerMeleeInstance i) {
        i.setLastAttackTimestamp(System.currentTimeMillis());
    }
    
    private /* synthetic */ void lambda$setStateManager$173(final PlayerMeleeInstance i) {
        this.attack(i, true);
    }
    
    private static /* synthetic */ void lambda$setStateManager$172(final PlayerMeleeInstance i) {
        i.setLastAttackTimestamp(System.currentTimeMillis());
    }
    
    private /* synthetic */ void lambda$setStateManager$171(final PlayerMeleeInstance i) {
        this.attack(i, false);
    }
    
    private static /* synthetic */ boolean lambda$static$170(final PlayerMeleeInstance instance) {
        return System.currentTimeMillis() > instance.getStateUpdateTimestamp() + instance.getWeapon().getPrepareHeavyStubTimeout();
    }
    
    private static /* synthetic */ boolean lambda$static$169(final PlayerMeleeInstance instance) {
        return System.currentTimeMillis() > instance.getStateUpdateTimestamp() + instance.getWeapon().getPrepareStubTimeout();
    }
    
    private static /* synthetic */ boolean lambda$static$168(final PlayerMeleeInstance instance) {
        return System.currentTimeMillis() > instance.getLastAttackTimestamp() + instance.getWeapon().getHeavyAttackCooldownTimeout();
    }
    
    private static /* synthetic */ boolean lambda$static$167(final PlayerMeleeInstance instance) {
        return System.currentTimeMillis() > instance.getLastAttackTimestamp() + instance.getWeapon().getAttackCooldownTimeout();
    }
    
    private static /* synthetic */ boolean lambda$static$166(final PlayerMeleeInstance instance) {
        return System.currentTimeMillis() > instance.getStateUpdateTimestamp() + 250L;
    }
    
    private static /* synthetic */ boolean lambda$static$165(final PlayerMeleeInstance instance) {
        return System.currentTimeMillis() > instance.getStateUpdateTimestamp() + 250L;
    }
    
    static {
        logger = LogManager.getLogger((Class)MeleeAttackAspect.class);
        MeleeAttackAspect.attackTimeoutExpired = (instance -> System.currentTimeMillis() > instance.getStateUpdateTimestamp() + 250L);
        MeleeAttackAspect.heavyAttackTimeoutExpired = (instance -> System.currentTimeMillis() > instance.getStateUpdateTimestamp() + 250L);
        MeleeAttackAspect.attackCooldownTimeoutExpired = (instance -> System.currentTimeMillis() > instance.getLastAttackTimestamp() + instance.getWeapon().getAttackCooldownTimeout());
        MeleeAttackAspect.heavyAttackCooldownTimeoutExpired = (instance -> System.currentTimeMillis() > instance.getLastAttackTimestamp() + instance.getWeapon().getHeavyAttackCooldownTimeout());
        MeleeAttackAspect.readyToStab = (instance -> System.currentTimeMillis() > instance.getStateUpdateTimestamp() + instance.getWeapon().getPrepareStubTimeout());
        MeleeAttackAspect.readyToHeavyStab = (instance -> System.currentTimeMillis() > instance.getStateUpdateTimestamp() + instance.getWeapon().getPrepareHeavyStubTimeout());
        allowedAttackFromStates = new HashSet<MeleeState>(Arrays.asList(MeleeState.READY));
        allowedUpdateFromStates = new HashSet<MeleeState>(Arrays.asList(MeleeState.ATTACKING, MeleeState.HEAVY_ATTACKING, MeleeState.ATTACKING_STABBING, MeleeState.HEAVY_ATTACKING_STABBING, MeleeState.ALERT));
    }
}
