package com.vicmatskiv.weaponlib;

import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.vicmatskiv.weaponlib.particle.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.config.*;
import io.netty.buffer.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.apache.logging.log4j.*;

public class WeaponSpawnEntity extends EntityProjectile
{
    private static final Logger logger;
    private static final String TAG_ENTITY_ITEM = "entityItem";
    private static final String TAG_DAMAGE = "damage";
    private static final String TAG_EXPLOSION_RADIUS = "explosionRadius";
    private float explosionRadius;
    private float damage;
    private Weapon weapon;
    
    public WeaponSpawnEntity(final World world) {
        super(world);
        this.damage = 6.0f;
    }
    
    public WeaponSpawnEntity(final Weapon weapon, final World world, final EntityLivingBase player, final float speed, final float gravityVelocity, final float inaccuracy, final float damage, final float explosionRadius, final Material... damageableBlockMaterials) {
        super(world, player, speed, gravityVelocity, inaccuracy);
        this.damage = 6.0f;
        this.weapon = weapon;
        this.damage = damage;
        this.explosionRadius = explosionRadius;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
    }
    
    @Override
    protected void onImpact(final CompatibleRayTraceResult position) {
        if (CompatibilityProvider.compatibility.world(this).isRemote) {
            return;
        }
        if (this.weapon == null) {
            return;
        }
        if (this.explosionRadius > 0.0f) {
            Explosion.createServerSideExplosion(this.weapon.getModContext(), CompatibilityProvider.compatibility.world(this), this, position.getHitVec().getXCoord(), position.getHitVec().getYCoord(), position.getHitVec().getZCoord(), this.explosionRadius, false, true);
        }
        else if (position.getEntityHit() != null) {
            final Projectiles projectilesConfig = this.weapon.getModContext().getConfigurationManager().getProjectiles();
            if (this.getThrower() != null && (projectilesConfig.isKnockbackOnHit() == null || projectilesConfig.isKnockbackOnHit())) {
                position.getEntityHit().attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)this.getThrower()), this.damage);
            }
            else {
                position.getEntityHit().attackEntityFrom(CompatibilityProvider.compatibility.genericDamageSource(), this.damage);
            }
            position.getEntityHit().hurtResistantTime = 0;
            final Entity entityHit = position.getEntityHit();
            entityHit.prevRotationYaw -= (float)0.3;
            WeaponSpawnEntity.logger.debug("Hit entity {}", new Object[] { position.getEntityHit() });
            final CompatibleTargetPoint point = new CompatibleTargetPoint(position.getEntityHit().dimension, this.posX, this.posY, this.posZ, 100.0);
            final double magnitude = Math.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ) + 2.0;
            final Float bleedingCoefficient = projectilesConfig.getBleedingOnHit();
            if (bleedingCoefficient != null && bleedingCoefficient > 0.0f) {
                final int count = (int)(this.getParticleCount(this.damage) * bleedingCoefficient);
                WeaponSpawnEntity.logger.debug("Generating {} particle(s) per damage {}", new Object[] { count, this.damage });
                this.weapon.getModContext().getChannel().sendToAllAround(new SpawnParticleMessage(SpawnParticleMessage.ParticleType.BLOOD, count, position.getEntityHit().posX - this.motionX / magnitude, position.getEntityHit().posY - this.motionY / magnitude, position.getEntityHit().posZ - this.motionZ / magnitude), point);
            }
        }
        else if (position.getTypeOfHit() == CompatibleRayTraceResult.Type.BLOCK) {
            this.weapon.onSpawnEntityBlockImpact(CompatibilityProvider.compatibility.world(this), null, this, position);
        }
        this.setDead();
    }
    
    @Override
    public void writeSpawnData(final ByteBuf buffer) {
        super.writeSpawnData(buffer);
        buffer.writeInt(Item.getIdFromItem((Item)this.weapon));
        buffer.writeFloat(this.damage);
        buffer.writeFloat(this.explosionRadius);
    }
    
    @Override
    public void readSpawnData(final ByteBuf buffer) {
        super.readSpawnData(buffer);
        this.weapon = (Weapon)Item.getItemById(buffer.readInt());
        this.damage = buffer.readFloat();
        this.explosionRadius = buffer.readFloat();
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        final Item item = Item.getItemById(tagCompound.getInteger("entityItem"));
        if (item instanceof Weapon) {
            this.weapon = (Weapon)item;
        }
        this.damage = tagCompound.getFloat("damage");
        this.explosionRadius = tagCompound.getFloat("explosionRadius");
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("entityItem", Item.getIdFromItem((Item)this.weapon));
        tagCompound.setFloat("damage", this.damage);
        tagCompound.setFloat("explosionRadius", this.explosionRadius);
    }
    
    Weapon getWeapon() {
        return this.weapon;
    }
    
    boolean isDamageableEntity(final Entity entity) {
        return false;
    }
    
    int getParticleCount(final float damage) {
        return (int)(-0.11 * (damage - 30.0f) * (damage - 30.0f) + 100.0);
    }
    
    @Override
    public boolean canCollideWithBlock(final Block block, final CompatibleBlockState metadata) {
        return !CompatibilityProvider.compatibility.isBlockPenetratableByBullets(block) && super.canCollideWithBlock(block, metadata);
    }
    
    static {
        logger = LogManager.getLogger((Class)WeaponSpawnEntity.class);
    }
}
