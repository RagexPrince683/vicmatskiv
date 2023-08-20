package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.network.*;

public class CompatibleTargetPoint
{
    private NetworkRegistry.TargetPoint targetPoint;
    
    public CompatibleTargetPoint(final int dimension, final double x, final double y, final double z, final double range) {
        super();
        this.targetPoint = new NetworkRegistry.TargetPoint(dimension, x, y, z, range);
    }
    
    NetworkRegistry.TargetPoint getTargetPoint() {
        return this.targetPoint;
    }
}
