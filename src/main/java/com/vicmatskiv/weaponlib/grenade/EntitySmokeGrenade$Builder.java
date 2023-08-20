package com.vicmatskiv.weaponlib.grenade;

import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.*;

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
        EntitySmokeGrenade.access$102(entityGrenade, this.activationTimestamp);
        EntitySmokeGrenade.access$202(entityGrenade, this.activationDelay);
        EntitySmokeGrenade.access$302(entityGrenade, this.smokeAmount);
        EntitySmokeGrenade.access$402(entityGrenade, this.activeDuration);
        return entityGrenade;
    }
}
