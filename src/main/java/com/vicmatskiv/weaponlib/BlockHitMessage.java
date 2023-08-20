package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import io.netty.buffer.*;

public class BlockHitMessage implements CompatibleMessage
{
    private int posX;
    private int posY;
    private int posZ;
    private int enumFacing;
    
    public BlockHitMessage() {
        super();
    }
    
    public BlockHitMessage(final int posX, final int posY, final int posZ, final CompatibleEnumFacing enumFacing) {
        super();
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.enumFacing = enumFacing.ordinal();
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.posX = buf.readInt();
        this.posY = buf.readInt();
        this.posZ = buf.readInt();
        this.enumFacing = buf.readInt();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.posX);
        buf.writeInt(this.posY);
        buf.writeInt(this.posZ);
        buf.writeInt(this.enumFacing);
    }
    
    public int getPosX() {
        return this.posX;
    }
    
    public int getPosY() {
        return this.posY;
    }
    
    public int getPosZ() {
        return this.posZ;
    }
    
    public CompatibleEnumFacing getSideHit() {
        return CompatibleEnumFacing.values()[this.enumFacing];
    }
}
