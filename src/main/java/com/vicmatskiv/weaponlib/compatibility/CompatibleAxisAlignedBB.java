package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.util.*;

public class CompatibleAxisAlignedBB
{
    private AxisAlignedBB boundingBox;
    
    CompatibleAxisAlignedBB(final AxisAlignedBB boundingBox) {
        super();
        this.boundingBox = boundingBox;
    }
    
    public CompatibleAxisAlignedBB(final CompatibleBlockPos blockPos) {
        super();
        this.boundingBox = AxisAlignedBB.getBoundingBox((double)blockPos.getBlockPosX(), (double)blockPos.getBlockPosY(), (double)blockPos.getBlockPosZ(), (double)(blockPos.getBlockPosX() + 1), (double)(blockPos.getBlockPosY() + 1), (double)(blockPos.getBlockPosZ() + 1));
    }
    
    public CompatibleAxisAlignedBB(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        super();
        this.boundingBox = AxisAlignedBB.getBoundingBox(x1, y1, z1, x2, y2, z2);
    }
    
    AxisAlignedBB getBoundingBox() {
        return this.boundingBox;
    }
    
    public CompatibleRayTraceResult calculateIntercept(final CompatibleVec3 vec3, final CompatibleVec3 vec31) {
        return CompatibleRayTraceResult.fromMovingObjectPosition(this.boundingBox.calculateIntercept(vec3.getVec(), vec31.getVec()));
    }
    
    public CompatibleAxisAlignedBB addCoord(final double x, final double y, final double z) {
        return new CompatibleAxisAlignedBB(this.boundingBox.addCoord(x, y, z));
    }
    
    public CompatibleAxisAlignedBB expand(final double x, final double y, final double z) {
        return new CompatibleAxisAlignedBB(this.boundingBox.expand(x, y, z));
    }
    
    public CompatibleAxisAlignedBB offset(final double x, final double y, final double z) {
        return new CompatibleAxisAlignedBB(this.boundingBox.offset(x, y, z));
    }
    
    public boolean intersectsWith(final CompatibleAxisAlignedBB other) {
        return this.boundingBox.intersectsWith(other.boundingBox);
    }
    
    public double getAverageEdgeLength() {
        return this.boundingBox.getAverageEdgeLength();
    }
}
