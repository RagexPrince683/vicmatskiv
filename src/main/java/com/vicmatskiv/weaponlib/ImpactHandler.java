package com.vicmatskiv.weaponlib;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;

@FunctionalInterface
public interface ImpactHandler
{
    void onImpact(final World p0, final EntityPlayer p1, final WeaponSpawnEntity p2, final CompatibleRayTraceResult p3);
}
