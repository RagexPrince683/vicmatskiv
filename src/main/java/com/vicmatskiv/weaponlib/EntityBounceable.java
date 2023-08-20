package com.vicmatskiv.weaponlib;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.nbt.*;
import io.netty.buffer.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.*;
import org.apache.logging.log4j.*;

public class EntityBounceable extends Entity implements Contextual, CompatibleIEntityAdditionalSpawnData, CompatibleIThrowableEntity
{
    private static final Logger logger;
    private static final int VELOCITY_HISTORY_SIZE = 10;
    private static final double STOP_THRESHOLD = 0.001;
    private static final int MAX_TICKS = 2000;
    protected ModContext modContext;
    private float gravityVelocity;
    private float slowdownFactor;
    private int ticksInAir;
    private EntityLivingBase thrower;
    protected int bounceCount;
    private float initialYaw;
    private float initialPitch;
    private float xRotation;
    private float yRotation;
    private float zRotation;
    private float xRotationChange;
    private float yRotationChange;
    private float zRotationChange;
    private float rotationSlowdownFactor;
    private float maxRotationChange;
    private boolean stopped;
    private Queue<Double> velocityHistory;
    
    public EntityBounceable(final ModContext modContext, final World world, final EntityLivingBase thrower, final float velocity, final float gravityVelocity, final float rotationSlowdownFactor) {
        super(world);
        this.slowdownFactor = 0.5f;
        this.rotationSlowdownFactor = 0.99f;
        this.maxRotationChange = 20.0f;
        this.velocityHistory = new ArrayDeque<Double>(10);
        this.modContext = modContext;
        this.thrower = thrower;
        this.gravityVelocity = gravityVelocity;
        this.rotationSlowdownFactor = rotationSlowdownFactor;
        this.setSize(0.3f, 0.3f);
        this.setLocationAndAngles(thrower.posX, thrower.posY + thrower.getEyeHeight(), thrower.posZ, thrower.rotationYaw, thrower.rotationPitch);
        this.posX -= CompatibleMathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        this.posZ -= CompatibleMathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        final float f = 0.4f;
        this.motionX = -CompatibleMathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * CompatibleMathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * f;
        this.motionZ = CompatibleMathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * CompatibleMathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * f;
        this.motionY = -CompatibleMathHelper.sin((this.rotationPitch + 0.0f) / 180.0f * 3.1415927f) * f;
        this.initialYaw = this.rotationYaw;
        this.initialPitch = this.rotationPitch;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, velocity, 10.0f);
        EntityBounceable.logger.debug("Throwing with position {}{}{}, rotation pitch {}, velocity {}, {}, {}", new Object[] { this.posX, this.posY, this.posZ, this.rotationPitch, this.motionX, this.motionY, this.motionZ });
    }
    
    public void setThrowableHeading(double motionX, double motionY, double motionZ, final float velocity, final float inaccuracy) {
        final float f2 = CompatibleMathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
        motionX /= f2;
        motionY /= f2;
        motionZ /= f2;
        motionX += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        motionY += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        motionZ += this.rand.nextGaussian() * 0.007499999832361937 * inaccuracy;
        motionX *= velocity;
        motionY *= velocity;
        motionZ *= velocity;
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        final float f3 = CompatibleMathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
        final float n = (float)(Math.atan2(motionX, motionZ) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float)(Math.atan2(motionY, f3) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
    }
    
    public EntityBounceable(final World world) {
        super(world);
        this.slowdownFactor = 0.5f;
        this.rotationSlowdownFactor = 0.99f;
        this.maxRotationChange = 20.0f;
        this.velocityHistory = new ArrayDeque<Double>(10);
        this.setRotations();
    }
    
    private void setRotations() {
        this.xRotationChange = this.maxRotationChange * (float)this.rand.nextGaussian();
        this.yRotationChange = this.maxRotationChange * (float)this.rand.nextGaussian();
        this.zRotationChange = this.maxRotationChange * (float)this.rand.nextGaussian();
    }
    
    public EntityLivingBase getThrower() {
        return this.thrower;
    }
    
    public void setThrower(final Entity thrower) {
        this.thrower = (EntityLivingBase)thrower;
    }
    
    public void onUpdate() {
        if (!CompatibilityProvider.compatibility.world(this).isRemote && this.ticksExisted > 2000) {
            this.setDead();
            return;
        }
        this.xRotation += this.xRotationChange;
        this.yRotation += this.yRotationChange;
        this.zRotation += this.zRotationChange;
        this.xRotationChange *= this.rotationSlowdownFactor;
        this.yRotationChange *= this.rotationSlowdownFactor;
        this.zRotationChange *= this.rotationSlowdownFactor;
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        ++this.ticksInAir;
        if (this.stopped) {
            return;
        }
        CompatibleVec3 vec3 = new CompatibleVec3(this.posX, this.posY, this.posZ);
        CompatibleVec3 vec4 = new CompatibleVec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        CompatibleRayTraceResult movingobjectposition = CompatibleRayTracing.rayTraceBlocks(CompatibilityProvider.compatibility.world(this), vec3, vec4, (block, blockMetadata) -> this.canCollideWithBlock(block, blockMetadata));
        vec3 = new CompatibleVec3(this.posX, this.posY, this.posZ);
        vec4 = new CompatibleVec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingobjectposition != null) {
            vec4 = CompatibleVec3.fromCompatibleVec3(movingobjectposition.getHitVec());
        }
        if (this.thrower != null) {
            Entity entity = null;
            final List<?> list = CompatibilityProvider.compatibility.getEntitiesWithinAABBExcludingEntity(CompatibilityProvider.compatibility.world(this), this, CompatibilityProvider.compatibility.getBoundingBox(this).addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0, 1.0, 1.0));
            double d0 = 0.0;
            final EntityLivingBase entitylivingbase = this.getThrower();
            CompatibleRayTraceResult entityMovingObjectPosition = null;
            for (int j = 0; j < list.size(); ++j) {
                final Entity entity2 = (Entity)list.get(j);
                if (entity2.canBeCollidedWith() && (entity2 != entitylivingbase || this.ticksInAir >= 5)) {
                    final float f = 0.3f;
                    final CompatibleAxisAlignedBB axisalignedbb = CompatibilityProvider.compatibility.expandEntityBoundingBox(entity2, f, f, f);
                    final CompatibleRayTraceResult movingobjectposition2 = axisalignedbb.calculateIntercept(vec3, vec4);
                    if (movingobjectposition2 != null) {
                        final double d2 = vec3.distanceTo(movingobjectposition2.getHitVec());
                        if (d2 < d0 || d0 == 0.0) {
                            entity = entity2;
                            entityMovingObjectPosition = movingobjectposition2;
                            d0 = d2;
                        }
                    }
                }
            }
            if (entity != null) {
                movingobjectposition = new CompatibleRayTraceResult(entity);
                movingobjectposition.setSideHit(entityMovingObjectPosition.getSideHit());
                movingobjectposition.setHitVec(entityMovingObjectPosition.getHitVec());
            }
        }
        EntityBounceable.logger.trace("Ori position to {}, {}, {}, motion {} {} {} ", new Object[] { this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ });
        if (movingobjectposition != null && (movingobjectposition.getTypeOfHit() == CompatibleRayTraceResult.Type.BLOCK || movingobjectposition.getTypeOfHit() == CompatibleRayTraceResult.Type.ENTITY)) {
            EntityBounceable.logger.trace("Hit {}, vec set to {}, {}, {}", new Object[] { movingobjectposition.getTypeOfHit(), movingobjectposition.getHitVec().getXCoord(), movingobjectposition.getHitVec().getYCoord(), movingobjectposition.getHitVec().getZCoord() });
            EntityBounceable.logger.trace("Before bouncing {}, side {}, motion set to {}, {}, {}", new Object[] { this.bounceCount, movingobjectposition.getSideHit(), this.motionX, this.motionY, this.motionZ });
            this.posX = movingobjectposition.getHitVec().getXCoord();
            this.posY = movingobjectposition.getHitVec().getYCoord();
            this.posZ = movingobjectposition.getHitVec().getZCoord();
            switch (movingobjectposition.getSideHit()) {
                case DOWN: {
                    this.motionY = -this.motionY;
                    this.posY += this.motionY;
                    break;
                }
                case UP: {
                    this.motionY = -this.motionY;
                    break;
                }
                case NORTH: {
                    this.motionZ = -this.motionZ;
                    this.posZ += this.motionZ;
                    break;
                }
                case SOUTH: {
                    this.motionZ = -this.motionZ;
                    break;
                }
                case WEST: {
                    this.motionX = -this.motionX;
                    this.posX += this.motionX;
                    break;
                }
                case EAST: {
                    this.motionX = -this.motionX;
                    break;
                }
            }
            this.setPosition(this.posX, this.posY, this.posZ);
            if (movingobjectposition.getTypeOfHit() == CompatibleRayTraceResult.Type.ENTITY) {
                this.avoidEntityCollisionAfterBounce(movingobjectposition);
            }
            else if (movingobjectposition.getTypeOfHit() == CompatibleRayTraceResult.Type.BLOCK) {
                this.avoidBlockCollisionAfterBounce(movingobjectposition);
            }
            EntityBounceable.logger.trace("After bouncing {}  motion set to {}, {}, {}", new Object[] { this.bounceCount, this.motionX, this.motionY, this.motionZ });
            this.onBounce(movingobjectposition);
            ++this.bounceCount;
            if (this.isDead) {
                return;
            }
        }
        else {
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
        }
        this.setPosition(this.posX, this.posY, this.posZ);
        final float motionSquared = CompatibleMathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
        this.rotationPitch = (float)(Math.atan2(this.motionY, motionSquared) * 180.0 / 3.141592653589793);
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
        final float currentGravityVelocity = this.getGravityVelocity();
        if (this.isInWater()) {
            for (int i = 0; i < 4; ++i) {
                final float f3 = 0.25f;
                CompatibilityProvider.compatibility.spawnParticle(CompatibilityProvider.compatibility.world(this), "bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
            }
            f2 = 0.8f;
        }
        if (movingobjectposition != null && (movingobjectposition.getTypeOfHit() == CompatibleRayTraceResult.Type.BLOCK || movingobjectposition.getTypeOfHit() == CompatibleRayTraceResult.Type.ENTITY)) {
            f2 = this.slowdownFactor;
            this.rotationSlowdownFactor *= this.slowdownFactor * 1.5f;
        }
        this.motionX *= f2;
        this.motionY *= f2;
        this.motionZ *= f2;
        this.recordVelocityHistory();
        if (!this.velocityHistory.stream().anyMatch(v -> v > 0.001)) {
            final double motionX = 0.0;
            this.motionZ = motionX;
            this.motionY = motionX;
            this.motionX = motionX;
            this.stopped = true;
            EntityBounceable.logger.trace("Stopping {}", new Object[] { this });
            this.onStop();
        }
        else {
            this.motionY -= currentGravityVelocity;
        }
        EntityBounceable.logger.trace("Set position to {}, {}, {}, motion {} {} {} ", new Object[] { this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ });
    }
    
    public void onStop() {
    }
    
    public void onBounce(final CompatibleRayTraceResult movingobjectposition) {
    }
    
    private void avoidBlockCollisionAfterBounce(final CompatibleRayTraceResult movingobjectposition) {
        if (movingobjectposition.getTypeOfHit() != CompatibleRayTraceResult.Type.BLOCK) {
            return;
        }
        final double dX = Math.signum(this.motionX) * 0.05;
        final double dY = Math.signum(this.motionY) * 0.05;
        final double dZ = Math.signum(this.motionZ) * 0.05;
        for (int i = 0; i < 10; ++i) {
            final double projectedXPos = this.posX + dX * i;
            final double projectedYPos = this.posY + dY * i;
            final double projectedZPos = this.posZ + dZ * i;
            final CompatibleVec3 projectedPos = new CompatibleVec3(projectedXPos, projectedYPos, projectedZPos);
            final CompatibleBlockPos blockPos = new CompatibleBlockPos(projectedPos);
            final CompatibleAxisAlignedBB projectedEntityBoundingBox = CompatibilityProvider.compatibility.getBoundingBox(this).offset(dX * i, dY * i, dZ * i);
            if (CompatibilityProvider.compatibility.isAirBlock(CompatibilityProvider.compatibility.world(this), blockPos) || !new CompatibleAxisAlignedBB(blockPos).intersectsWith(projectedEntityBoundingBox)) {
                this.posX = projectedXPos;
                this.posY = projectedYPos;
                this.posZ = projectedZPos;
                EntityBounceable.logger.trace("Found non-intercepting post-bounce position on iteration {}", new Object[] { i });
                break;
            }
        }
    }
    
    private void avoidEntityCollisionAfterBounce(final CompatibleRayTraceResult movingobjectposition) {
        if (movingobjectposition.getEntityHit() == null) {
            return;
        }
        this.slowdownFactor = 0.3f;
        final double dX = Math.signum(this.motionX) * 0.05;
        final double dY = Math.signum(this.motionY) * 0.05;
        final double dZ = Math.signum(this.motionZ) * 0.05;
        final float f = 0.3f;
        final CompatibleAxisAlignedBB axisalignedbb = CompatibilityProvider.compatibility.getBoundingBox(movingobjectposition.getEntityHit()).expand(f, f, f);
        CompatibleRayTraceResult intercept = movingobjectposition;
        int i = 0;
        while (i < 10) {
            final CompatibleVec3 currentPos = new CompatibleVec3(this.posX + dX * i, this.posY + dY * i, this.posZ + dY * i);
            final CompatibleVec3 projectedPos = new CompatibleVec3(this.posX + dX * (i + 1), this.posY + dY * (i + 1), this.posZ + dZ * (i + 1));
            intercept = axisalignedbb.calculateIntercept(currentPos, projectedPos);
            if (intercept == null) {
                final CompatibleBlockPos blockPos = new CompatibleBlockPos(projectedPos);
                final CompatibleBlockState blockState;
                if ((blockState = CompatibilityProvider.compatibility.getBlockAtPosition(CompatibilityProvider.compatibility.world(this), blockPos)) != null && !CompatibilityProvider.compatibility.isAirBlock(blockState)) {
                    EntityBounceable.logger.debug("Found non-intercept position colliding with block {}", new Object[] { blockState });
                    intercept = movingobjectposition;
                    break;
                }
                this.posX = projectedPos.getXCoord();
                this.posY = projectedPos.getYCoord();
                this.posZ = projectedPos.getZCoord();
                break;
            }
            else {
                ++i;
            }
        }
        if (intercept != null) {
            EntityBounceable.logger.debug("Could not find non-intercept position after bounce");
        }
    }
    
    protected float getGravityVelocity() {
        return this.gravityVelocity;
    }
    
    protected void entityInit() {
    }
    
    protected void readEntityFromNBT(final NBTTagCompound tagCompound) {
    }
    
    protected void writeEntityToNBT(final NBTTagCompound tagCompound) {
    }
    
    public void writeSpawnData(final ByteBuf buffer) {
        buffer.writeInt((this.thrower != null) ? this.thrower.getEntityId() : -1);
        buffer.writeDouble(this.posX);
        buffer.writeDouble(this.posY);
        buffer.writeDouble(this.posZ);
        buffer.writeDouble(this.motionX);
        buffer.writeDouble(this.motionY);
        buffer.writeDouble(this.motionZ);
        buffer.writeFloat(this.gravityVelocity);
        buffer.writeFloat(this.rotationSlowdownFactor);
        buffer.writeFloat(this.initialYaw);
        buffer.writeFloat(this.initialPitch);
    }
    
    public void readSpawnData(final ByteBuf buffer) {
        final int entityId = buffer.readInt();
        if (this.thrower == null && entityId >= 0) {
            final Entity entity = CompatibilityProvider.compatibility.world(this).getEntityByID(entityId);
            if (entity instanceof EntityLivingBase) {
                this.thrower = (EntityLivingBase)entity;
            }
        }
        this.posX = buffer.readDouble();
        this.posY = buffer.readDouble();
        this.posZ = buffer.readDouble();
        this.motionX = buffer.readDouble();
        this.motionY = buffer.readDouble();
        this.motionZ = buffer.readDouble();
        this.gravityVelocity = buffer.readFloat();
        this.rotationSlowdownFactor = buffer.readFloat();
        this.initialYaw = buffer.readFloat();
        this.initialPitch = buffer.readFloat();
        this.setPosition(this.posX, this.posY, this.posZ);
        EntityBounceable.logger.debug("Restoring with position {}{}{}, rotation pitch {}, velocity {}, {}, {}", new Object[] { this.posX, this.posY, this.posZ, this.rotationPitch, this.motionX, this.motionY, this.motionZ });
    }
    
    public float getXRotation() {
        return this.xRotation;
    }
    
    public float getYRotation() {
        return this.yRotation - this.initialYaw - 90.0f;
    }
    
    public float getZRotation() {
        return this.zRotation;
    }
    
    public boolean canCollideWithBlock(final Block block, final CompatibleBlockState metadata) {
        return CompatibilityProvider.compatibility.canCollideCheck(block, metadata, false);
    }
    
    private void recordVelocityHistory() {
        final double velocity = this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ;
        this.velocityHistory.add(velocity);
        if (this.velocityHistory.size() > 10) {
            this.velocityHistory.poll();
        }
    }
    
    public void setContext(final ModContext modContext) {
        if (this.modContext == null) {
            this.modContext = modContext;
        }
    }
    
    public /* bridge */ Entity getThrower() {
        return (Entity)this.getThrower();
    }
    
    private static /* synthetic */ boolean lambda$onUpdate$270(final Double v) {
        return v > 0.001;
    }
    
    private /* synthetic */ boolean lambda$onUpdate$269(final Block block, final CompatibleBlockState blockMetadata) {
        return this.canCollideWithBlock(block, blockMetadata);
    }
    
    static {
        logger = LogManager.getLogger((Class)EntityBounceable.class);
    }
}
