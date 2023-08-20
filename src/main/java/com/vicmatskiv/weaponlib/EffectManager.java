package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.particle.*;

public interface EffectManager
{
    void spawnSmokeParticle(final EntityPlayer p0, final float p1, final float p2);
    
    void spawnFlashParticle(final EntityPlayer p0, final float p1, final float p2, final float p3, final float p4);
    
    void spawnExplosionSmoke(final double p0, final double p1, final double p2, final double p3, final double p4, final double p5, final float p6, final int p7, final ExplosionSmokeFX.Behavior p8);
    
    void spawnExplosionParticle(final double p0, final double p1, final double p2, final double p3, final double p4, final double p5, final float p6, final int p7);
}
