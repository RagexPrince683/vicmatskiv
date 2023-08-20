package com.vicmatskiv.weaponlib.grenade;

import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.*;

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
        EntityGrenade.access$102(entityGrenade, this.activationTimestamp);
        EntityGrenade.access$202(entityGrenade, this.explosionTimeout);
        EntityGrenade.access$302(entityGrenade, this.explosionStrength);
        entityGrenade.itemGrenade = this.itemGrenade;
        return entityGrenade;
    }
}
