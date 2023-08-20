package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.util.*;
import net.minecraft.entity.*;

public class CompatibleRayTraceResult
{
    private MovingObjectPosition position;
    private CompatibleBlockPos blockPos;
    private CompatibleVec3 hitVec;
    
    static CompatibleRayTraceResult fromMovingObjectPosition(final MovingObjectPosition position) {
        if (position == null) {
            return null;
        }
        return new CompatibleRayTraceResult(position);
    }
    
    private CompatibleRayTraceResult(final MovingObjectPosition position) {
        super();
        this.position = position;
        this.init();
    }
    
    public CompatibleRayTraceResult(final Entity entity) {
        super();
        this.position = new MovingObjectPosition(entity);
        this.init();
    }
    
    private void init() {
        this.blockPos = new CompatibleBlockPos(this.position.blockX, this.position.blockY, this.position.blockZ);
        this.hitVec = ((this.position.hitVec != null) ? new CompatibleVec3(this.position.hitVec) : null);
    }
    
    protected MovingObjectPosition getPosition() {
        return this.position;
    }
    
    public Entity getEntityHit() {
        return this.position.entityHit;
    }
    
    public Type getTypeOfHit() {
        Type result = null;
        switch (this.position.typeOfHit) {
            case BLOCK: {
                result = Type.BLOCK;
                break;
            }
            case ENTITY: {
                result = Type.ENTITY;
                break;
            }
            case MISS: {
                result = Type.MISS;
                break;
            }
        }
        return result;
    }
    
    public int getBlockPosX() {
        return this.position.blockX;
    }
    
    public int getBlockPosY() {
        return this.position.blockY;
    }
    
    public int getBlockPosZ() {
        return this.position.blockZ;
    }
    
    public CompatibleEnumFacing getSideHit() {
        return CompatibleEnumFacing.values()[this.position.sideHit];
    }
    
    public CompatibleBlockPos getBlockPos() {
        return this.blockPos;
    }
    
    public CompatibleVec3 getHitVec() {
        return this.hitVec;
    }
    
    public void setSideHit(final CompatibleEnumFacing sideHit) {
        this.position.sideHit = sideHit.ordinal();
    }
    
    public void setHitVec(final CompatibleVec3 hitVec) {
        this.position.hitVec = hitVec.getVec();
        this.hitVec = hitVec;
    }
    
    @Override
    public String toString() {
        return this.position.toString();
    }
    
    public enum Type
    {
        MISS, 
        BLOCK, 
        ENTITY;
        
        private static final /* synthetic */ Type[] $VALUES;
        
        public static Type[] values() {
            return Type.$VALUES.clone();
        }
        
        public static Type valueOf(final String name) {
            return Enum.valueOf(Type.class, name);
        }
        
        static {
            $VALUES = new Type[] { Type.MISS, Type.BLOCK, Type.ENTITY };
        }
    }
}
