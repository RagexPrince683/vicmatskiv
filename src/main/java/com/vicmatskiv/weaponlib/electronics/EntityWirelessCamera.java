package com.vicmatskiv.weaponlib.electronics;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.tracking.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import io.netty.buffer.*;
import org.apache.logging.log4j.*;

public class EntityWirelessCamera extends CompatibleThrowableEntity
{
    private static final Logger logger;
    private ModContext modContext;
    private ItemWirelessCamera itemWirelessCamera;
    private long timestamp;
    private long duration;
    
    public EntityWirelessCamera(final ModContext modContext, final World world, final EntityPlayer player, final ItemWirelessCamera itemWirelessCamera, final long duration) {
        super(world, (EntityLivingBase)player);
        this.timestamp = System.currentTimeMillis();
        this.duration = duration;
        this.modContext = modContext;
        this.itemWirelessCamera = itemWirelessCamera;
        this.setSize(0.25f, 0.25f);
        this.setLocationAndAngles(player.posX, player.posY + player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
        final double posX = this.posX;
        CompatibilityProvider.compatibility.getMathHelper();
        this.posX = posX - CompatibleMathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        final double posZ = this.posZ;
        CompatibilityProvider.compatibility.getMathHelper();
        this.posZ = posZ - CompatibleMathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        final float f = 0.4f;
        CompatibilityProvider.compatibility.getMathHelper();
        final float n = -CompatibleMathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f);
        CompatibilityProvider.compatibility.getMathHelper();
        this.motionX = n * CompatibleMathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * f;
        CompatibilityProvider.compatibility.getMathHelper();
        final float cos = CompatibleMathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f);
        CompatibilityProvider.compatibility.getMathHelper();
        this.motionZ = cos * CompatibleMathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * f;
        final float pitchOffset = 0.0f;
        CompatibilityProvider.compatibility.getMathHelper();
        this.motionY = -CompatibleMathHelper.sin((this.rotationPitch + pitchOffset) / 180.0f * 3.1415927f) * f;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, 1.5f, 0.0f);
    }
    
    public EntityWirelessCamera(final World world, final EntityLivingBase player) {
        super(world, player);
    }
    
    public EntityWirelessCamera(final World world) {
        super(world);
    }
    
    @Override
    protected void onImpact(final CompatibleRayTraceResult rayTraceResult) {
        final Entity entityHit = rayTraceResult.getEntityHit();
        EntityWirelessCamera.logger.debug("Player {} hit entity {}", new Object[] { this.getThrower(), rayTraceResult.getEntityHit() });
        boolean hit = false;
        if (entityHit != null && this.getThrower() instanceof EntityPlayer) {
            String displayName = "";
            if (entityHit instanceof EntityPlayer) {
                displayName = CompatibilityProvider.compatibility.getDisplayName((EntityPlayer)entityHit);
            }
            else if (entityHit instanceof EntityLivingBase) {
                displayName = EntityList.getEntityString(entityHit);
            }
            if (!CompatibilityProvider.compatibility.world((Entity)this).isRemote) {
                EntityWirelessCamera.logger.debug("Server hit entity uuid {}", new Object[] { rayTraceResult.getEntityHit().getPersistentID() });
                final PlayerEntityTracker tracker = PlayerEntityTracker.getTracker((EntityPlayer)this.getThrower());
                if (tracker != null) {
                    hit = true;
                    tracker.addTrackableEntity(new TrackableEntity(entityHit, this.timestamp, this.duration));
                    this.modContext.getChannel().getChannel().sendTo((IMessage)new SyncPlayerEntityTrackerMessage(tracker, "Tracking " + displayName), (EntityPlayerMP)this.getThrower());
                }
                entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), 0.001f);
            }
        }
        if (!CompatibilityProvider.compatibility.world((Entity)this).isRemote) {
            if (!hit) {
                this.dropItem((Item)this.itemWirelessCamera, 1);
            }
            this.setDead();
        }
    }
    
    public void onUpdate() {
        super.onUpdate();
    }
    
    public void writeSpawnData(final ByteBuf buffer) {
        buffer.writeInt(Item.getIdFromItem((Item)this.itemWirelessCamera));
        buffer.writeLong(this.timestamp);
        buffer.writeLong(this.duration);
    }
    
    public void readSpawnData(final ByteBuf buffer) {
        final Item item = Item.getItemById(buffer.readInt());
        if (item instanceof ItemWirelessCamera) {
            this.itemWirelessCamera = (ItemWirelessCamera)item;
        }
        this.timestamp = buffer.readLong();
        this.duration = buffer.readLong();
    }
    
    @Override
    protected void setCompatibleThrowableHeading(double motionX, double motionY, double motionZ, final float velocity, final float inaccuracy) {
        CompatibilityProvider.compatibility.getMathHelper();
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
        CompatibilityProvider.compatibility.getMathHelper();
        final float f3 = CompatibleMathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
        final float n = (float)(Math.atan2(motionX, motionZ) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float)(Math.atan2(motionY, f3) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
    }
    
    @Override
    protected float getInaccuracy() {
        return 0.0f;
    }
    
    @Override
    protected float getVelocity() {
        return 0.5f;
    }
    
    public ItemWirelessCamera getItem() {
        return this.itemWirelessCamera;
    }
    
    static {
        logger = LogManager.getLogger((Class)EntityWirelessCamera.class);
    }
}
