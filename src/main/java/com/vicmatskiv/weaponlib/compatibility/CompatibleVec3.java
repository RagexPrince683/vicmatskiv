package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.util.*;

public class CompatibleVec3
{
    private Vec3 vec;
    
    public CompatibleVec3(final Vec3 vec) {
        super();
        this.vec = vec;
    }
    
    public CompatibleVec3(final double posX, final double posY, final double posZ) {
        super();
        this.vec = Vec3.createVectorHelper(posX, posY, posZ);
    }
    
    public static CompatibleVec3 fromCompatibleVec3(final CompatibleVec3 otherVec) {
        if (otherVec == null) {
            return null;
        }
        return new CompatibleVec3(Vec3.createVectorHelper(otherVec.vec.xCoord, otherVec.vec.yCoord, otherVec.vec.zCoord));
    }
    
    public Vec3 getVec() {
        return this.vec;
    }
    
    public double getXCoord() {
        return this.vec.xCoord;
    }
    
    public double getYCoord() {
        return this.vec.yCoord;
    }
    
    public double getZCoord() {
        return this.vec.zCoord;
    }
    
    public double distanceTo(final CompatibleVec3 otherVec) {
        return this.vec.distanceTo(otherVec.vec);
    }
}
