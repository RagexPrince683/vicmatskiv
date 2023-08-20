package com.vicmatskiv.weaponlib.grenade;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.world.*;
import io.netty.buffer.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.particle.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class EntitySmokeGrenade extends AbstractEntityGrenade
{
    private long activationDelay;
    private long activationTimestamp;
    private float smokeAmount;
    private long activeDuration;
    
    private EntitySmokeGrenade(final ModContext modContext, final ItemGrenade itemGrenade, final EntityLivingBase thrower, final float velocity, final float gravityVelocity, final float rotationSlowdownFactor) {
        super(modContext, itemGrenade, thrower, velocity, gravityVelocity, rotationSlowdownFactor);
    }
    
    public EntitySmokeGrenade(final World world) {
        super(world);
    }
    
    @Override
    public void writeSpawnData(final ByteBuf buffer) {
        super.writeSpawnData(buffer);
        buffer.writeLong(this.activationTimestamp);
        buffer.writeLong(this.activationDelay);
        buffer.writeLong(this.activeDuration);
        buffer.writeFloat(this.smokeAmount);
    }
    
    @Override
    public void readSpawnData(final ByteBuf buffer) {
        super.readSpawnData(buffer);
        this.activationTimestamp = buffer.readLong();
        this.activationDelay = buffer.readLong();
        this.activeDuration = buffer.readLong();
        this.smokeAmount = buffer.readFloat();
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setLong("activationTimestamp", this.activationTimestamp);
        tagCompound.setLong("activationDelay", this.activationDelay);
        tagCompound.setLong("activeDuration", this.activeDuration);
        tagCompound.setFloat("smokeAmount", this.smokeAmount);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        this.activationTimestamp = tagCompound.getLong("activationTimestamp");
        this.activationDelay = tagCompound.getLong("activationDelay");
        this.activeDuration = tagCompound.getLong("activeDuration");
        this.smokeAmount = tagCompound.getFloat("smokeAmount");
    }
    
    public void onGrenadeUpdate() {
        if (this.modContext == null) {
            return;
        }
        final long timeRemaining = this.activationTimestamp + this.activationDelay + this.activeDuration - System.currentTimeMillis();
        if (this.activationDelay != -1L) {
            if (timeRemaining < 0L) {
                this.setDead();
            }
            else if (!CompatibilityProvider.compatibility.world(this).isRemote && timeRemaining <= this.activeDuration) {
                final double f = 0.4 + Math.sin(3.141592653589793 * (1.0 - timeRemaining / (double)this.activeDuration)) * 0.3;
                if (this.rand.nextDouble() <= f) {
                    for (final Object o : CompatibilityProvider.compatibility.world(this).playerEntities) {
                        final EntityPlayer player = (EntityPlayer)o;
                        if (player.getDistanceSq(this.posX, this.posY, this.posZ) < 4096.0) {
                            final SpawnParticleMessage.ParticleType particleType = SpawnParticleMessage.ParticleType.SMOKE_GRENADE_SMOKE;
                            final double movement = (this.bounceCount > 0) ? 0.007 : 0.001;
                            this.modContext.getChannel().getChannel().sendTo((IMessage)new SpawnParticleMessage(particleType, 1, this.posX + this.rand.nextGaussian() / 7.0, this.posY + this.rand.nextGaussian() / 10.0, this.posZ + this.rand.nextGaussian() / 7.0, this.rand.nextGaussian() * movement, this.rand.nextGaussian() * movement, this.rand.nextGaussian() * movement), (EntityPlayerMP)player);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void onBounce(final CompatibleRayTraceResult movingobjectposition) {
        if (this.activationDelay == -1L) {
            this.activationDelay = 0L;
            this.activationTimestamp = System.currentTimeMillis();
        }
        else {
            super.onBounce(movingobjectposition);
        }
    }
    
    @Override
    public void onStop() {
        final World world = CompatibilityProvider.compatibility.world(this);
        if (!world.isRemote && this.itemGrenade != null) {
            CompatibilityProvider.compatibility.playSound(CompatibilityProvider.compatibility.world(this), this.posX, this.posY, this.posZ, this.itemGrenade.getStopAfterThrowingSound(), 2.0f, (1.0f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2f) * 0.7f);
        }
    }
    
    EntitySmokeGrenade(final ModContext x0, final ItemGrenade x1, final EntityLivingBase x2, final float x3, final float x4, final float x5, final EntitySmokeGrenade$1 x6) {
        this(x0, x1, x2, x3, x4, x5);
    }
    
    static /* synthetic */ long access$102(final EntitySmokeGrenade x0, final long x1) {
        return x0.activationTimestamp = x1;
    }
    
    static /* synthetic */ long access$202(final EntitySmokeGrenade x0, final long x1) {
        return x0.activationDelay = x1;
    }
    
    static /* synthetic */ float access$302(final EntitySmokeGrenade x0, final float x1) {
        return x0.smokeAmount = x1;
    }
    
    static /* synthetic */ long access$402(final EntitySmokeGrenade x0, final long x1) {
        return x0.activeDuration = x1;
    }
    
    public static class Builder
    {
        private long activationDelay;
        private long activationTimestamp;
        private long activeDuration;
        private float smokeAmount;
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
        
        public Builder withActivationDelay(final long activationDelay) {
            this.activationDelay = activationDelay;
            return this;
        }
        
        public Builder withThrower(final EntityLivingBase thrower) {
            this.thrower = thrower;
            return this;
        }
        
        public Builder withSmokeAmount(final float smokeAmount) {
            this.smokeAmount = smokeAmount;
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
        
        public Builder withActiveDuration(final long activeDuration) {
            this.activeDuration = activeDuration;
            return this;
        }
        
        public EntitySmokeGrenade build(final ModContext modContext) {
            final EntitySmokeGrenade entityGrenade = new EntitySmokeGrenade(modContext, this.itemGrenade, this.thrower, this.velocity, this.gravityVelocity, this.rotationSlowdownFactor, null);
            entityGrenade.activationTimestamp = this.activationTimestamp;
            entityGrenade.activationDelay = this.activationDelay;
            entityGrenade.smokeAmount = this.smokeAmount;
            entityGrenade.activeDuration = this.activeDuration;
            return entityGrenade;
        }
    }
}
