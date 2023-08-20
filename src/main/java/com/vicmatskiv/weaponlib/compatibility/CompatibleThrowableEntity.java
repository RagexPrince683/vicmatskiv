package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.entity.projectile.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public abstract class CompatibleThrowableEntity extends EntityThrowable implements IEntityAdditionalSpawnData
{
    public CompatibleThrowableEntity(final World world) {
        super(world);
    }
    
    public CompatibleThrowableEntity(final World par1World, final EntityLivingBase player) {
        super(par1World, player);
    }
    
    public CompatibleThrowableEntity(final World world, final double x, final double y, final double z) {
        super(world, x, y, z);
    }
    
    protected final float func_70182_d() {
        return this.getVelocity();
    }
    
    protected final void onImpact(final MovingObjectPosition position) {
        this.onImpact(CompatibleRayTraceResult.fromMovingObjectPosition(position));
    }
    
    protected abstract void onImpact(final CompatibleRayTraceResult p0);
    
    public final void setThrowableHeading(final double motionX, final double motionY, final double motionZ, final float velocity, final float ignoredInaccuracy) {
        this.setCompatibleThrowableHeading(motionX, motionY, motionZ, velocity, this.getInaccuracy());
    }
    
    protected abstract void setCompatibleThrowableHeading(final double p0, final double p1, final double p2, final float p3, final float p4);
    
    protected abstract float getInaccuracy();
    
    protected abstract float getVelocity();
}
