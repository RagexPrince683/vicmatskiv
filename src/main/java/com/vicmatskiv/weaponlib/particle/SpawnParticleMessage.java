package com.vicmatskiv.weaponlib.particle;

import com.vicmatskiv.weaponlib.compatibility.*;
import io.netty.buffer.*;

public class SpawnParticleMessage implements CompatibleMessage
{
    private double posX;
    private double posY;
    private double posZ;
    private double motionX;
    private double motionY;
    private double motionZ;
    private int count;
    private ParticleType particleType;
    
    public SpawnParticleMessage() {
        super();
    }
    
    public SpawnParticleMessage(final ParticleType particleType, final int count, final double posX, final double posY, final double posZ) {
        super();
        this.particleType = particleType;
        this.count = count;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
    
    public SpawnParticleMessage(final ParticleType particleType, final int count, final double posX, final double posY, final double posZ, final double motionX, final double motionY, final double motionZ) {
        super();
        this.particleType = particleType;
        this.count = count;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.particleType = ParticleType.values()[buf.readInt()];
        this.count = buf.readInt();
        this.posX = buf.readDouble();
        this.posY = buf.readDouble();
        this.posZ = buf.readDouble();
        if (this.particleType == ParticleType.SMOKE_GRENADE_SMOKE) {
            this.motionX = buf.readDouble();
            this.motionY = buf.readDouble();
            this.motionZ = buf.readDouble();
        }
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.particleType.ordinal());
        buf.writeInt(this.count);
        buf.writeDouble(this.posX);
        buf.writeDouble(this.posY);
        buf.writeDouble(this.posZ);
        if (this.particleType == ParticleType.SMOKE_GRENADE_SMOKE) {
            buf.writeDouble(this.motionX);
            buf.writeDouble(this.motionY);
            buf.writeDouble(this.motionZ);
        }
    }
    
    public ParticleType getParticleType() {
        return this.particleType;
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
    
    public int getCount() {
        return this.count;
    }
    
    public double getMotionX() {
        return this.motionX;
    }
    
    public double getMotionY() {
        return this.motionY;
    }
    
    public double getMotionZ() {
        return this.motionZ;
    }
    
    public enum ParticleType
    {
        BLOOD, 
        SHELL, 
        SMOKE_GRENADE_SMOKE;
        
        private static final /* synthetic */ ParticleType[] $VALUES;
        
        public static ParticleType[] values() {
            return ParticleType.$VALUES.clone();
        }
        
        public static ParticleType valueOf(final String name) {
            return Enum.valueOf(ParticleType.class, name);
        }
        
        static {
            $VALUES = new ParticleType[] { ParticleType.BLOOD, ParticleType.SHELL, ParticleType.SMOKE_GRENADE_SMOKE };
        }
    }
}
