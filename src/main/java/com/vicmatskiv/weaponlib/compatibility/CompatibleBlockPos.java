package com.vicmatskiv.weaponlib.compatibility;

public class CompatibleBlockPos
{
    private int blockPosX;
    private int blockPosY;
    private int blockPosZ;
    
    public CompatibleBlockPos(final int blockPosX, final int blockPosY, final int blockPosZ) {
        super();
        this.blockPosX = blockPosX;
        this.blockPosY = blockPosY;
        this.blockPosZ = blockPosZ;
    }
    
    public CompatibleBlockPos(final CompatibleVec3 pos) {
        super();
        this.blockPosX = (int)pos.getVec().xCoord;
        this.blockPosY = (int)pos.getVec().yCoord;
        this.blockPosZ = (int)pos.getVec().zCoord;
    }
    
    public int getBlockPosX() {
        return this.blockPosX;
    }
    
    public int getBlockPosY() {
        return this.blockPosY;
    }
    
    public int getBlockPosZ() {
        return this.blockPosZ;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + this.blockPosX;
        result = 31 * result + this.blockPosY;
        result = 31 * result + this.blockPosZ;
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final CompatibleBlockPos other = (CompatibleBlockPos)obj;
        return this.blockPosX == other.blockPosX && this.blockPosY == other.blockPosY && this.blockPosZ == other.blockPosZ;
    }
}
