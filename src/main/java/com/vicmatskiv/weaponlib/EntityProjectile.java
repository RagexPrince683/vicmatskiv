package com.vicmatskiv.weaponlib;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import io.netty.buffer.*;
import net.minecraft.block.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.apache.logging.log4j.*;

public abstract class EntityProjectile extends Entity implements IProjectile, CompatibleIEntityAdditionalSpawnData
{
    private static final Logger logger;
    private static final String TAG_GRAVITY_VELOCITY = "gravityVelocity";
    private static final int MAX_TICKS = 200;
    private static final int DEFAULT_MAX_LIFETIME = 5000;
    private int xTile;
    private int yTile;
    private int zTile;
    protected boolean inGround;
    public int throwableShake;
    protected EntityLivingBase thrower;
    private String throwerName;
    private int ticksInAir;
    protected float gravityVelocity;
    protected float velocity;
    protected float inaccuracy;
    private long timestamp;
    protected long maxLifetime;
    
    public EntityProjectile(final World world) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.maxLifetime = 5000L;
        this.setSize(0.25f, 0.25f);
        this.timestamp = System.currentTimeMillis();
    }
    
    public EntityProjectile(final World world, final EntityLivingBase thrower, final float velocity, final float gravityVelocity, final float inaccuracy) {
        this(world);
        this.thrower = thrower;
        this.velocity = velocity;
        this.gravityVelocity = gravityVelocity;
        this.inaccuracy = inaccuracy;
    }
    
    public void setPositionAndDirection() {
        this.setLocationAndAngles(this.thrower.posX, this.thrower.posY + this.thrower.getEyeHeight(), this.thrower.posZ, this.thrower.rotationYaw, this.thrower.rotationPitch);
        this.posX -= CompatibleMathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        this.posZ -= CompatibleMathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        final float f = this.velocity;
        this.motionX = -CompatibleMathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * CompatibleMathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * f;
        this.motionZ = CompatibleMathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * CompatibleMathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * f;
        this.motionY = -CompatibleMathHelper.sin((this.rotationPitch + this.getPitchOffset()) / 180.0f * 3.1415927f) * f;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.velocity, this.inaccuracy);
    }
    
    public EntityProjectile(final World world, final double posX, final double posY, final double posZ) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.maxLifetime = 5000L;
        this.setSize(0.25f, 0.25f);
        this.setPosition(posX, posY, posZ);
    }
    
    protected float getPitchOffset() {
        return 0.0f;
    }
    
    public void setThrowableHeading(double x, double y, double z, final float velocity, final float inaccuracy) {
        final float f2 = CompatibleMathHelper.sqrt_double(x * x + y * y + z * z);
        x /= f2;
        y /= f2;
        z /= f2;
        x += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        y += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        z += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        x *= velocity;
        y *= velocity;
        z *= velocity;
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        final float f3 = CompatibleMathHelper.sqrt_double(x * x + z * z);
        final float n = (float)(Math.atan2(x, z) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float)(Math.atan2(y, f3) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
    }
    
    public void setVelocity(final double mX, final double mY, final double mZ) {
        this.motionX = mX;
        this.motionY = mY;
        this.motionZ = mZ;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float f = CompatibleMathHelper.sqrt_double(mX * mX + mZ * mZ);
            final float n = (float)(Math.atan2(mX, mZ) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float)(Math.atan2(mY, f) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
        }
    }
    
    public void onUpdate() {
        if (this.ticksExisted > 200) {
            this.setDead();
            return;
        }
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        if (this.throwableShake > 0) {
            --this.throwableShake;
        }
        if (this.inGround) {
            this.inGround = false;
            this.motionX *= this.rand.nextFloat() * 0.2f;
            this.motionY *= this.rand.nextFloat() * 0.2f;
            this.motionZ *= this.rand.nextFloat() * 0.2f;
            this.ticksInAir = 0;
        }
        else {
            ++this.ticksInAir;
        }
        CompatibleVec3 vec3 = new CompatibleVec3(this.posX, this.posY, this.posZ);
        CompatibleVec3 vec4 = new CompatibleVec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        CompatibleRayTraceResult movingobjectposition = CompatibleRayTracing.rayTraceBlocks(CompatibilityProvider.compatibility.world(this), vec3, vec4, (block, blockMetadata) -> this.canCollideWithBlock(block, blockMetadata));
        vec3 = new CompatibleVec3(this.posX, this.posY, this.posZ);
        vec4 = new CompatibleVec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingobjectposition != null) {
            vec4 = CompatibleVec3.fromCompatibleVec3(movingobjectposition.getHitVec());
        }
        if (!CompatibilityProvider.compatibility.world(this).isRemote) {
            final Entity entity = this.getRayTraceEntities(vec3, vec4);
            if (entity != null) {
                movingobjectposition = new CompatibleRayTraceResult(entity);
            }
        }
        if (movingobjectposition != null) {
            this.onImpact(movingobjectposition);
        }
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        final float f1 = CompatibleMathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
        this.rotationPitch = (float)(Math.atan2(this.motionY, f1) * 180.0 / 3.141592653589793);
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
        float f2 = 0.99f;
        final float f3 = this.gravityVelocity;
        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                final float f4 = 0.25f;
                CompatibilityProvider.compatibility.spawnParticle(CompatibilityProvider.compatibility.world(this), "bubble", this.posX - this.motionX * f4, this.posY - this.motionY * f4, this.posZ - this.motionZ * f4, this.motionX, this.motionY, this.motionZ);
            }
            f2 = 0.8f;
        }
        this.motionX *= f2;
        this.motionY *= f2;
        this.motionZ *= f2;
        this.motionY -= f3;
        this.setPosition(this.posX, this.posY, this.posZ);
    }
    
    private Entity getRayTraceEntities(final CompatibleVec3 vec3, final CompatibleVec3 vec31) {
        Entity entity = null;
        final List<?> list = CompatibilityProvider.compatibility.getEntitiesWithinAABBExcludingEntity(CompatibilityProvider.compatibility.world(this), this, CompatibilityProvider.compatibility.getBoundingBox(this).addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
        double d0 = 0.0;
        final EntityLivingBase entitylivingbase = this.getThrower();
        for (int j = 0; j < list.size(); ++j) {
            final Entity entity2 = (Entity)list.get(j);
            if (entity2.canBeCollidedWith() && (entity2 != entitylivingbase || this.ticksInAir >= 5)) {
                final float f = 0.3f;
                final CompatibleAxisAlignedBB axisalignedbb = CompatibilityProvider.compatibility.expandEntityBoundingBox(entity2, f, f, f);
                final CompatibleRayTraceResult movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);
                if (movingobjectposition1 != null) {
                    final double d2 = vec3.distanceTo(movingobjectposition1.getHitVec());
                    if (d2 < d0 || d0 == 0.0) {
                        entity = entity2;
                        d0 = d2;
                    }
                }
            }
        }
        return entity;
    }
    
    protected abstract void onImpact(final CompatibleRayTraceResult p0);
    
    public void writeEntityToNBT(final NBTTagCompound tagCompound) {
        tagCompound.setLong("timestamp", this.timestamp);
        tagCompound.setShort("xTile", (short)this.xTile);
        tagCompound.setShort("yTile", (short)this.yTile);
        tagCompound.setShort("zTile", (short)this.zTile);
        tagCompound.setByte("shake", (byte)this.throwableShake);
        tagCompound.setByte("inGround", (byte)(byte)(this.inGround ? 1 : 0));
        if ((this.throwerName == null || this.throwerName.length() == 0) && this.thrower != null && this.thrower instanceof EntityPlayer) {
            this.throwerName = CompatibilityProvider.compatibility.getPlayerName((EntityPlayer)this.thrower);
        }
        tagCompound.setString("ownerName", (this.throwerName == null) ? "" : this.throwerName);
        tagCompound.setFloat("gravityVelocity", this.gravityVelocity);
    }
    
    public void readEntityFromNBT(final NBTTagCompound tagCompound) {
        this.xTile = tagCompound.getShort("xTile");
        this.yTile = tagCompound.getShort("yTile");
        this.zTile = tagCompound.getShort("zTile");
        this.throwableShake = (tagCompound.getByte("shake") & 0xFF);
        this.inGround = (tagCompound.getByte("inGround") == 1);
        this.throwerName = tagCompound.getString("ownerName");
        if (this.throwerName != null && this.throwerName.length() == 0) {
            this.throwerName = null;
        }
        this.gravityVelocity = tagCompound.getFloat("gravityVelocity");
        this.timestamp = tagCompound.getLong("timestamp");
        if (System.currentTimeMillis() > this.timestamp + this.maxLifetime) {
            this.setDead();
        }
    }
    
    public void writeSpawnData(final ByteBuf buffer) {
        buffer.writeFloat(this.gravityVelocity);
    }
    
    public void readSpawnData(final ByteBuf buffer) {
        this.gravityVelocity = buffer.readFloat();
    }
    
    public float getShadowSize() {
        return 0.0f;
    }
    
    public EntityLivingBase getThrower() {
        if (this.thrower == null && this.throwerName != null && this.throwerName.length() > 0) {
            this.thrower = (EntityLivingBase)CompatibilityProvider.compatibility.world(this).getPlayerEntityByName(this.throwerName);
        }
        return this.thrower;
    }
    
    protected void entityInit() {
    }
    
    public boolean isInRangeToRenderDist(final double p_70112_1_) {
        double d1 = CompatibilityProvider.compatibility.getBoundingBox(this).getAverageEdgeLength() * 4.0;
        d1 *= 64.0;
        return p_70112_1_ < d1 * d1;
    }
    
    public boolean canCollideWithBlock(final Block block, final CompatibleBlockState metadata) {
        return CompatibilityProvider.compatibility.canCollideCheck(block, metadata, false);
    }
    
    private /* synthetic */ boolean lambda$onUpdate$195(final Block block, final CompatibleBlockState blockMetadata) {
        return this.canCollideWithBlock(block, blockMetadata);
    }
    
    static {
        logger = LogManager.getLogger((Class)EntityProjectile.class);
    }
}
