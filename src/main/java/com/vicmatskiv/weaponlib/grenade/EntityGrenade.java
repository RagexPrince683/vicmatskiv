package com.vicmatskiv.weaponlib.grenade;

import net.minecraft.world.*;
import io.netty.buffer.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.util.*;
import java.util.function.*;
import net.minecraft.block.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.apache.logging.log4j.*;

public class EntityGrenade extends AbstractEntityGrenade
{
    private static final Logger logger;
    private long explosionTimeout;
    private float explosionStrength;
    private long activationTimestamp;
    
    private EntityGrenade(final ModContext modContext, final ItemGrenade itemGrenade, final EntityLivingBase thrower, final float velocity, final float gravityVelocity, final float rotationSlowdownFactor) {
        super(modContext, itemGrenade, thrower, velocity, gravityVelocity, rotationSlowdownFactor);
    }
    
    public EntityGrenade(final World world) {
        super(world);
    }
    
    @Override
    public void writeSpawnData(final ByteBuf buffer) {
        super.writeSpawnData(buffer);
        buffer.writeLong(this.activationTimestamp);
        buffer.writeLong(this.explosionTimeout);
        buffer.writeFloat(this.explosionStrength);
    }
    
    @Override
    public void readSpawnData(final ByteBuf buffer) {
        super.readSpawnData(buffer);
        this.activationTimestamp = buffer.readLong();
        this.explosionTimeout = buffer.readLong();
        this.explosionStrength = buffer.readFloat();
    }
    
    public void onGrenadeUpdate() {
        if (!CompatibilityProvider.compatibility.world(this).isRemote && this.explosionTimeout > 0L && System.currentTimeMillis() > this.activationTimestamp + this.explosionTimeout) {
            this.explode();
        }
    }
    
    @Override
    public void onBounce(final CompatibleRayTraceResult movingobjectposition) {
        if (this.explosionTimeout == -1L && !CompatibilityProvider.compatibility.world(this).isRemote) {
            this.explode();
        }
        else {
            super.onBounce(movingobjectposition);
        }
    }
    
    private void explode() {
        EntityGrenade.logger.debug("Exploding {}", new Object[] { this });
        Explosion.createServerSideExplosion(this.modContext, CompatibilityProvider.compatibility.world(this), this, this.posX, this.posY, this.posZ, this.explosionStrength, false, true);
        final List<?> nearbyEntities = CompatibilityProvider.compatibility.getEntitiesWithinAABBExcludingEntity(CompatibilityProvider.compatibility.world(this), this, CompatibilityProvider.compatibility.getBoundingBox(this).expand(5.0, 5.0, 5.0));
        final Float damageCoefficient = this.modContext.getConfigurationManager().getExplosions().getDamage();
        final float effectiveRadius = this.itemGrenade.getEffectiveRadius() * damageCoefficient;
        final float fragmentDamage = this.itemGrenade.getFragmentDamage();
        final float configuredFragmentCount = this.itemGrenade.getFragmentCount() * damageCoefficient;
        for (int i = 0; i < configuredFragmentCount; ++i) {
            final double x = (this.rand.nextDouble() - 0.5) * 2.0;
            final double y = (this.rand.nextDouble() - 0.5) * 2.0;
            final double z = (this.rand.nextDouble() - 0.5) * 2.0;
            final double d2 = x * x + y * y + z * z;
            if (d2 == 0.0) {
                EntityGrenade.logger.debug("Ignoring zero distance index {}", new Object[] { i });
            }
            else {
                final double k = Math.sqrt(effectiveRadius * effectiveRadius / d2);
                final double k2 = 0.1;
                final CompatibleVec3 cvec1 = new CompatibleVec3(this.posX + x * k2, this.posY + y * k2, this.posZ + z * k2);
                final CompatibleVec3 cvec2 = new CompatibleVec3(this.posX + x * k2, this.posY + y * k2, this.posZ + z * k2);
                CompatibleVec3 cvec3 = new CompatibleVec3(this.posX + x * k, this.posY + y * k, this.posZ + z * k);
                final BiPredicate<Block, CompatibleBlockState> isCollidable = (block, blockMetadata) -> CompatibilityProvider.compatibility.canCollideCheck(block, blockMetadata, false);
                final CompatibleRayTraceResult rayTraceResult = CompatibleRayTracing.rayTraceBlocks(CompatibilityProvider.compatibility.world(this), cvec1, cvec3, isCollidable);
                if (rayTraceResult != null) {
                    cvec3 = CompatibleVec3.fromCompatibleVec3(rayTraceResult.getHitVec());
                }
                for (final Object nearbyEntityObject : nearbyEntities) {
                    final Entity nearbyEntity = (Entity)nearbyEntityObject;
                    if (nearbyEntity.canBeCollidedWith()) {
                        final float f = 0.5f;
                        final CompatibleAxisAlignedBB axisalignedbb = CompatibilityProvider.compatibility.expandEntityBoundingBox(nearbyEntity, f, f, f);
                        final CompatibleRayTraceResult movingobjectposition1 = axisalignedbb.calculateIntercept(cvec2, cvec3);
                        if (movingobjectposition1 == null) {
                            continue;
                        }
                        final double distanceToEntity = cvec2.distanceTo(movingobjectposition1.getHitVec());
                        final float damageDistanceReductionFactor = (float)Math.abs(1.0 - distanceToEntity / effectiveRadius);
                        EntityGrenade.logger.trace("Hit entity {} at distance {}, damage reduction {}", new Object[] { nearbyEntity, distanceToEntity, damageDistanceReductionFactor });
                        nearbyEntity.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), Math.max(0.1f, this.rand.nextFloat()) * fragmentDamage * damageDistanceReductionFactor);
                    }
                }
            }
        }
        this.setDead();
    }
    
    @Override
    public ItemGrenade getItemGrenade() {
        return this.itemGrenade;
    }
    
    private static /* synthetic */ boolean lambda$explode$273(final Block block, final CompatibleBlockState blockMetadata) {
        return CompatibilityProvider.compatibility.canCollideCheck(block, blockMetadata, false);
    }
    
    EntityGrenade(final ModContext x0, final ItemGrenade x1, final EntityLivingBase x2, final float x3, final float x4, final float x5, final EntityGrenade$1 x6) {
        this(x0, x1, x2, x3, x4, x5);
    }
    
    static /* synthetic */ long access$102(final EntityGrenade x0, final long x1) {
        return x0.activationTimestamp = x1;
    }
    
    static /* synthetic */ long access$202(final EntityGrenade x0, final long x1) {
        return x0.explosionTimeout = x1;
    }
    
    static /* synthetic */ float access$302(final EntityGrenade x0, final float x1) {
        return x0.explosionStrength = x1;
    }
    
    static {
        logger = LogManager.getLogger((Class)EntityGrenade.class);
    }
    
    public static class Builder
    {
        private long explosionTimeout;
        private float explosionStrength;
        private long activationTimestamp;
        private EntityLivingBase thrower;
        private ItemGrenade itemGrenade;
        private float velocity;
        private float gravityVelocity;
        private float rotationSlowdownFactor;
        
        public Builder() {
            super();
            this.velocity = 1.0f;
            this.gravityVelocity = 0.06f;
            this.rotationSlowdownFactor = 0.99f;
        }
        
        public Builder withActivationTimestamp(final long activationTimestamp) {
            this.activationTimestamp = activationTimestamp;
            return this;
        }
        
        public Builder withExplosionTimeout(final long explosionTimeout) {
            this.explosionTimeout = explosionTimeout;
            return this;
        }
        
        public Builder withThrower(final EntityLivingBase thrower) {
            this.thrower = thrower;
            return this;
        }
        
        public Builder withExplosionStrength(final float explosionStrength) {
            this.explosionStrength = explosionStrength;
            return this;
        }
        
        public Builder withGrenade(final ItemGrenade itemGrenade) {
            this.itemGrenade = itemGrenade;
            return this;
        }
        
        public Builder withVelocity(final float velocity) {
            this.velocity = velocity;
            return this;
        }
        
        public Builder withGravityVelocity(final float gravityVelocity) {
            this.gravityVelocity = gravityVelocity;
            return this;
        }
        
        public Builder withRotationSlowdownFactor(final float rotationSlowdownFactor) {
            this.rotationSlowdownFactor = rotationSlowdownFactor;
            return this;
        }
        
        public EntityGrenade build(final ModContext modContext) {
            final EntityGrenade entityGrenade = new EntityGrenade(modContext, this.itemGrenade, this.thrower, this.velocity, this.gravityVelocity, this.rotationSlowdownFactor, null);
            entityGrenade.activationTimestamp = this.activationTimestamp;
            entityGrenade.explosionTimeout = this.explosionTimeout;
            entityGrenade.explosionStrength = this.explosionStrength;
            entityGrenade.itemGrenade = this.itemGrenade;
            return entityGrenade;
        }
    }
}
