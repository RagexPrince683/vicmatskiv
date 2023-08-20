package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import com.google.common.collect.*;
import io.netty.buffer.*;
import java.util.*;

public class ExplosionMessage implements CompatibleMessage
{
    private double posX;
    private double posY;
    private double posZ;
    private float strength;
    private List<CompatibleBlockPos> affectedBlockPositions;
    private float motionX;
    private float motionY;
    private float motionZ;
    
    public ExplosionMessage() {
        super();
    }
    
    public ExplosionMessage(final double xIn, final double yIn, final double zIn, final float strengthIn, final List<CompatibleBlockPos> affectedBlockPositionsIn, final CompatibleVec3 motion) {
        super();
        this.posX = xIn;
        this.posY = yIn;
        this.posZ = zIn;
        this.strength = strengthIn;
        this.affectedBlockPositions = (List<CompatibleBlockPos>)Lists.newArrayList((Iterable<?>)affectedBlockPositionsIn);
        if (motion != null) {
            this.motionX = (float)motion.getXCoord();
            this.motionY = (float)motion.getYCoord();
            this.motionZ = (float)motion.getZCoord();
        }
    }
    
    public double getPosX() {
        return this.posX;
    }
    
    public double getPosY() {
        return this.posY;
    }
    
    public double getPosZ() {
        return this.posZ;
    }
    
    public float getMotionX() {
        return this.motionX;
    }
    
    public float getMotionY() {
        return this.motionY;
    }
    
    public float getMotionZ() {
        return this.motionZ;
    }
    
    public float getStrength() {
        return this.strength;
    }
    
    public List<CompatibleBlockPos> getAffectedBlockPositions() {
        return this.affectedBlockPositions;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.posX = buf.readFloat();
        this.posY = buf.readFloat();
        this.posZ = buf.readFloat();
        this.strength = buf.readFloat();
        final int i = buf.readInt();
        this.affectedBlockPositions = new ArrayList<CompatibleBlockPos>(i);
        final int j = (int)this.posX;
        final int k = (int)this.posY;
        final int l = (int)this.posZ;
        for (int i2 = 0; i2 < i; ++i2) {
            final int j2 = buf.readByte() + j;
            final int k2 = buf.readByte() + k;
            final int l2 = buf.readByte() + l;
            this.affectedBlockPositions.add(new CompatibleBlockPos(j2, k2, l2));
        }
        this.motionX = buf.readFloat();
        this.motionY = buf.readFloat();
        this.motionZ = buf.readFloat();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeFloat((float)this.posX);
        buf.writeFloat((float)this.posY);
        buf.writeFloat((float)this.posZ);
        buf.writeFloat(this.strength);
        buf.writeInt(this.affectedBlockPositions.size());
        final int i = (int)this.posX;
        final int j = (int)this.posY;
        final int k = (int)this.posZ;
        for (final CompatibleBlockPos blockpos : this.affectedBlockPositions) {
            final int l = blockpos.getBlockPosX() - i;
            final int i2 = blockpos.getBlockPosY() - j;
            final int j2 = blockpos.getBlockPosZ() - k;
            buf.writeByte(l);
            buf.writeByte(i2);
            buf.writeByte(j2);
        }
        buf.writeFloat(this.motionX);
        buf.writeFloat(this.motionY);
        buf.writeFloat(this.motionZ);
    }
}
