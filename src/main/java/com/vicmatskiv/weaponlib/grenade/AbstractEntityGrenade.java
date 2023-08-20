package com.vicmatskiv.weaponlib.grenade;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.block.*;

public abstract class AbstractEntityGrenade extends EntityBounceable
{
    private static final String TAG_ENTITY_ITEM = "entity_item";
    protected ItemGrenade itemGrenade;
    
    protected AbstractEntityGrenade(final ModContext modContext, final ItemGrenade itemGrenade, final EntityLivingBase thrower, final float velocity, final float gravityVelocity, final float rotationSlowdownFactor) {
        super(modContext, CompatibilityProvider.compatibility.world((Entity)thrower), thrower, velocity, gravityVelocity, rotationSlowdownFactor);
        this.itemGrenade = itemGrenade;
    }
    
    public AbstractEntityGrenade(final World world) {
        super(world);
    }
    
    public void readEntityFromNBT(final NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        final Item item = Item.getItemById(tagCompound.getInteger("entity_item"));
        if (item instanceof ItemGrenade) {
            this.itemGrenade = (ItemGrenade)item;
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("entity_item", Item.getIdFromItem((Item)this.itemGrenade));
    }
    
    @Override
    public void writeSpawnData(final ByteBuf buffer) {
        super.writeSpawnData(buffer);
        buffer.writeInt(Item.getIdFromItem((Item)this.itemGrenade));
    }
    
    @Override
    public void readSpawnData(final ByteBuf buffer) {
        super.readSpawnData(buffer);
        final Item item = Item.getItemById(buffer.readInt());
        if (item instanceof ItemGrenade) {
            this.itemGrenade = (ItemGrenade)item;
        }
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.onGrenadeUpdate();
    }
    
    protected abstract void onGrenadeUpdate();
    
    @Override
    public void onBounce(final CompatibleRayTraceResult movingobjectposition) {
        if (movingobjectposition.getTypeOfHit() == CompatibleRayTraceResult.Type.BLOCK && this.itemGrenade != null) {
            final CompatibleSound bounceHardSound = this.itemGrenade.getBounceHardSound();
            if (bounceHardSound != null) {
                final CompatibleBlockState blockState = CompatibilityProvider.compatibility.getBlockAtPosition(CompatibilityProvider.compatibility.world(this), movingobjectposition);
                if (CompatibilityProvider.compatibility.madeFromHardMaterial(blockState)) {
                    CompatibilityProvider.compatibility.playSoundAtEntity(this, bounceHardSound, 2.0f / (this.bounceCount + 1.0f), 1.0f);
                }
            }
            final CompatibleSound bounceSoftSound = this.itemGrenade.getBounceSoftSound();
            if (bounceSoftSound != null) {
                final CompatibleBlockState blockState2 = CompatibilityProvider.compatibility.getBlockAtPosition(CompatibilityProvider.compatibility.world(this), movingobjectposition);
                if (!CompatibilityProvider.compatibility.madeFromHardMaterial(blockState2)) {
                    CompatibilityProvider.compatibility.playSoundAtEntity(this, bounceSoftSound, 1.0f / (this.bounceCount + 1.0f), 1.0f);
                }
            }
        }
    }
    
    public ItemGrenade getItemGrenade() {
        return this.itemGrenade;
    }
    
    @Override
    public boolean canCollideWithBlock(final Block block, final CompatibleBlockState metadata) {
        return !CompatibilityProvider.compatibility.isBlockPenetratableByGrenades(block) && super.canCollideWithBlock(block, metadata);
    }
}
