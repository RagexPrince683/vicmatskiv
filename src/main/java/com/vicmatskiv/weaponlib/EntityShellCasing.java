package com.vicmatskiv.weaponlib;

import java.util.*;
import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import io.netty.buffer.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import org.apache.logging.log4j.*;

public class EntityShellCasing extends EntityProjectile
{
    private static final Logger logger;
    private static final String TAG_ENTITY_ITEM = "entity_item";
    static final float DEFAULT_INACCURACY = 1.0f;
    private Random random;
    private Weapon weapon;
    private PlayerWeaponInstance weaponInstance;
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
    
    public EntityShellCasing(final World world) {
        super(world);
        this.random = new Random();
        this.rotationSlowdownFactor = 0.95f;
        this.maxRotationChange = 30.0f;
        this.setRotations();
    }
    
    public EntityShellCasing(final PlayerWeaponInstance weaponInstance, final World world, final EntityLivingBase player, final float velocity, final float gravityVelocity, final float inaccuracy) {
        super(world, player, velocity, gravityVelocity, inaccuracy);
        this.random = new Random();
        this.rotationSlowdownFactor = 0.95f;
        this.maxRotationChange = 30.0f;
        this.weapon = weaponInstance.getWeapon();
        this.weaponInstance = weaponInstance;
    }
    
    @Override
    public void setPositionAndDirection() {
        this.setSize(0.001f, 0.001f);
        final float forwardOffset = CompatibilityProvider.compatibility.getCompatibleShellCasingForwardOffset() + this.weapon.getShellCasingForwardOffset();
        float sideOffset;
        if (this.weapon.getShellCasingEjectDirection() == Weapon.ShellCasingEjectDirection.RIGHT) {
            sideOffset = (this.weaponInstance.isAimed() ? this.weapon.getShellCasingSideOffsetAimed() : this.weapon.getShellCasingSideOffset());
        }
        else {
            sideOffset = (this.weaponInstance.isAimed() ? -0.1f : 0.0f);
        }
        final float yOffset = this.weapon.getShellCasingVerticalOffset() + (this.thrower.isSneaking() ? -0.1f : 0.0f);
        this.setLocationAndAngles(this.thrower.posX, this.thrower.posY + this.thrower.getEyeHeight() + yOffset, this.thrower.posZ, this.thrower.rotationYaw, this.thrower.rotationPitch);
        this.posX -= CompatibleMathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * sideOffset + (double)(CompatibleMathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * CompatibleMathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * forwardOffset);
        this.posY += -CompatibleMathHelper.sin(this.rotationPitch / 180.0f * 3.1415927f) * forwardOffset;
        this.posZ -= CompatibleMathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * sideOffset - (double)(CompatibleMathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * CompatibleMathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f) * forwardOffset);
        this.setPosition(this.posX, this.posY, this.posZ);
        final float f = this.velocity;
        float adjustedRotationYaw;
        if (this.weapon.getShellCasingEjectDirection() == Weapon.ShellCasingEjectDirection.RIGHT) {
            adjustedRotationYaw = this.rotationYaw + (this.weaponInstance.isAimed() ? -10.0f : -30.0f);
        }
        else {
            adjustedRotationYaw = this.rotationYaw + 0.0f;
        }
        final int directionSignum = (this.weapon.getShellCasingEjectDirection() == Weapon.ShellCasingEjectDirection.RIGHT) ? 1 : -1;
        this.motionX = directionSignum * -(CompatibleMathHelper.cos(adjustedRotationYaw / 180.0f * 3.1415927f) * f);
        this.motionZ = directionSignum * (double)(-CompatibleMathHelper.sin(adjustedRotationYaw / 180.0f * 3.1415927f) * f);
        this.motionY = 0.0;
        this.initialYaw = this.rotationYaw;
        this.initialPitch = this.rotationPitch;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.velocity, this.inaccuracy);
    }
    
    private void setRotations() {
        this.xRotationChange = this.maxRotationChange * (float)this.random.nextGaussian();
        this.yRotationChange = this.maxRotationChange * (float)this.random.nextGaussian();
        this.zRotationChange = this.maxRotationChange * (float)this.random.nextGaussian();
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.xRotation += this.xRotationChange;
        this.yRotation += this.yRotationChange;
        this.zRotation += this.zRotationChange;
        this.xRotationChange *= this.rotationSlowdownFactor;
        this.yRotationChange *= this.rotationSlowdownFactor;
        this.zRotationChange *= this.rotationSlowdownFactor;
    }
    
    @Override
    protected void onImpact(final CompatibleRayTraceResult position) {
        if (!CompatibilityProvider.compatibility.world(this).isRemote) {
            this.setDead();
        }
    }
    
    @Override
    public void writeSpawnData(final ByteBuf buffer) {
        super.writeSpawnData(buffer);
        buffer.writeInt(Item.getIdFromItem((Item)this.weapon));
        buffer.writeFloat(this.initialYaw);
        buffer.writeFloat(this.initialPitch);
    }
    
    @Override
    public void readSpawnData(final ByteBuf buffer) {
        super.readSpawnData(buffer);
        this.weapon = (Weapon)Item.getItemById(buffer.readInt());
        this.initialYaw = buffer.readFloat();
        this.initialPitch = buffer.readFloat();
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        final Item item = Item.getItemById(tagCompound.getInteger("entity_item"));
        if (item instanceof Weapon) {
            this.weapon = (Weapon)item;
        }
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("entity_item", Item.getIdFromItem((Item)this.weapon));
    }
    
    Weapon getWeapon() {
        return this.weapon;
    }
    
    boolean isDamageableEntity(final Entity entity) {
        return false;
    }
    
    public float getInitialYaw() {
        return this.initialYaw;
    }
    
    public float getInitialPitch() {
        return this.initialPitch;
    }
    
    public float getXRotation() {
        return this.initialPitch - this.xRotation;
    }
    
    public float getYRotation() {
        return this.yRotation - this.initialYaw - 90.0f;
    }
    
    public float getZRotation() {
        return this.zRotation;
    }
    
    public void setDead() {
        super.setDead();
        EntityShellCasing.logger.debug("{} despawned", new Object[] { this });
    }
    
    static {
        logger = LogManager.getLogger((Class)EntityShellCasing.class);
    }
}
