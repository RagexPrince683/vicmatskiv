package com.vicmatskiv.weaponlib;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.particle.*;
import net.minecraft.entity.item.*;

public class Explosion
{
    private ModContext modContext;
    private final boolean isFlaming;
    private final boolean isSmoking;
    private final Random explosionRNG;
    private final World world;
    private final double explosionX;
    private final double explosionY;
    private final double explosionZ;
    private final Entity exploder;
    private final float explosionSize;
    private final List<CompatibleBlockPos> affectedBlockPositions;
    private final Map<EntityPlayer, CompatibleVec3> playerKnockbackMap;
    private final CompatibleVec3 position;
    
    public static void createServerSideExplosion(final ModContext modContext, final World world, final Entity entity, final double posX, final double posY, final double posZ, float explosionStrength, final boolean isFlaming, final boolean isSmoking) {
        final Float damageCoefficient = modContext.getConfigurationManager().getExplosions().getDamage();
        explosionStrength *= damageCoefficient;
        final Explosion explosion = new Explosion(modContext, world, entity, posX, posY, posZ, explosionStrength, isFlaming, isSmoking);
        explosion.doExplosionA();
        explosion.doExplosionB(false);
        if (!isSmoking) {
            explosion.clearAffectedBlockPositions();
        }
        for (final Object o : world.playerEntities) {
            final EntityPlayer player = (EntityPlayer)o;
            if (player.getDistanceSq(posX, posY, posZ) < 4096.0) {
                modContext.getChannel().getChannel().sendTo((IMessage)new ExplosionMessage(posX, posY, posZ, explosionStrength, explosion.getAffectedBlockPositions(), explosion.getPlayerKnockbackMap().get(player)), (EntityPlayerMP)player);
            }
        }
    }
    
    public Explosion(final ModContext modContext, final World worldIn, final Entity entityIn, final double x, final double y, final double z, final float size, final List<CompatibleBlockPos> affectedPositions) {
        this(modContext, worldIn, entityIn, x, y, z, size, false, true, affectedPositions);
    }
    
    public Explosion(final ModContext modContext, final World worldIn, final Entity entityIn, final double x, final double y, final double z, final float size, final boolean flaming, final boolean smoking, final List<CompatibleBlockPos> affectedPositions) {
        this(modContext, worldIn, entityIn, x, y, z, size, flaming, smoking);
        this.affectedBlockPositions.addAll(affectedPositions);
    }
    
    public Explosion(final ModContext modContext, final World worldIn, final Entity entityIn, final double x, final double y, final double z, final float size, final boolean flaming, final boolean smoking) {
        super();
        this.modContext = modContext;
        this.explosionRNG = new Random();
        this.affectedBlockPositions = (List<CompatibleBlockPos>)Lists.newArrayList();
        this.playerKnockbackMap = (Map<EntityPlayer, CompatibleVec3>)Maps.newHashMap();
        this.world = worldIn;
        this.exploder = entityIn;
        this.explosionSize = size;
        this.explosionX = x;
        this.explosionY = y;
        this.explosionZ = z;
        this.isFlaming = flaming;
        this.isSmoking = smoking;
        this.position = new CompatibleVec3(this.explosionX, this.explosionY, this.explosionZ);
    }
    
    public double getExplosionX() {
        return this.explosionX;
    }
    
    public double getExplosionY() {
        return this.explosionY;
    }
    
    public double getExplosionZ() {
        return this.explosionZ;
    }
    
    public World getWorld() {
        return this.world;
    }
    
    public Entity getExploder() {
        return this.exploder;
    }
    
    public float getExplosionSize() {
        return this.explosionSize;
    }
    
    public void doExplosionA() {
        final Set<CompatibleBlockPos> set = (Set<CompatibleBlockPos>)Sets.newHashSet();
        for (int j = 0; j < 16; ++j) {
            for (int k = 0; k < 16; ++k) {
                for (int l = 0; l < 16; ++l) {
                    if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
                        double d0 = j / 15.0f * 2.0f - 1.0f;
                        double d2 = k / 15.0f * 2.0f - 1.0f;
                        double d3 = l / 15.0f * 2.0f - 1.0f;
                        final double d4 = Math.sqrt(d0 * d0 + d2 * d2 + d3 * d3);
                        d0 /= d4;
                        d2 /= d4;
                        d3 /= d4;
                        float f = this.explosionSize * (0.7f + this.world.rand.nextFloat() * 0.6f);
                        double d5 = this.explosionX;
                        double d6 = this.explosionY;
                        double d7 = this.explosionZ;
                        while (f > 0.0f) {
                            final CompatibleBlockPos blockpos = new CompatibleBlockPos((int)d5, (int)d6, (int)d7);
                            final CompatibleBlockState blockState = CompatibilityProvider.compatibility.getBlockAtPosition(this.world, blockpos);
                            if (!CompatibilityProvider.compatibility.isAirBlock(blockState)) {
                                final float f2 = (this.exploder != null) ? CompatibilityProvider.compatibility.getExplosionResistance(this.world, this.exploder, this, blockpos, blockState) : CompatibilityProvider.compatibility.getExplosionResistance(this.world, blockState, blockpos, null, this);
                                f -= (f2 + 0.3f) * 0.3f;
                            }
                            if (f > 0.0f && (this.exploder == null || CompatibilityProvider.compatibility.verifyExplosion(this.world, this.exploder, this, blockpos, blockState, f))) {
                                set.add(blockpos);
                            }
                            d5 += d0 * 0.30000001192092896;
                            d6 += d2 * 0.30000001192092896;
                            d7 += d3 * 0.30000001192092896;
                            f -= 0.22500001f;
                        }
                    }
                }
            }
        }
        this.affectedBlockPositions.addAll(set);
        final float f3 = this.explosionSize * 2.0f;
        final int k2 = CompatibleMathHelper.floor_double(this.explosionX - f3 - 1.0);
        final int l2 = CompatibleMathHelper.floor_double(this.explosionX + f3 + 1.0);
        final int i2 = CompatibleMathHelper.floor_double(this.explosionY - f3 - 1.0);
        final int i3 = CompatibleMathHelper.floor_double(this.explosionY + f3 + 1.0);
        final int j2 = CompatibleMathHelper.floor_double(this.explosionZ - f3 - 1.0);
        final int j3 = CompatibleMathHelper.floor_double(this.explosionZ + f3 + 1.0);
        final List<Entity> list = CompatibilityProvider.compatibility.getEntitiesWithinAABBExcludingEntity(this.world, this.exploder, new CompatibleAxisAlignedBB(k2, i2, j2, l2, i3, j3));
        final CompatibleVec3 vec3d = new CompatibleVec3(this.explosionX, this.explosionY, this.explosionZ);
        for (int k3 = 0; k3 < list.size(); ++k3) {
            final Entity entity = list.get(k3);
            if (!CompatibilityProvider.compatibility.isImmuneToExplosions(entity)) {
                final double d8 = entity.getDistance(this.explosionX, this.explosionY, this.explosionZ) / f3;
                if (d8 <= 1.0) {
                    double d9 = entity.posX - this.explosionX;
                    double d10 = entity.posY + entity.getEyeHeight() - this.explosionY;
                    double d11 = entity.posZ - this.explosionZ;
                    final double d12 = CompatibleMathHelper.sqrt_double(d9 * d9 + d10 * d10 + d11 * d11);
                    if (d12 != 0.0) {
                        d9 /= d12;
                        d10 /= d12;
                        d11 /= d12;
                        final double d13 = CompatibilityProvider.compatibility.getBlockDensity(this.world, vec3d, CompatibilityProvider.compatibility.getBoundingBox(entity));
                        final double d14 = (1.0 - d8) * d13;
                        entity.attackEntityFrom(CompatibilityProvider.compatibility.getDamageSource(this), (float)(int)((d14 * d14 + d14) / 2.0 * 7.0 * f3 + 1.0));
                        double d15 = 1.0;
                        if (entity instanceof EntityLivingBase) {
                            d15 = CompatibilityProvider.compatibility.getBlastDamageReduction((EntityLivingBase)entity, d14);
                        }
                        final Entity entity2 = entity;
                        entity2.motionX += d9 * d15;
                        final Entity entity3 = entity;
                        entity3.motionY += d10 * d15;
                        final Entity entity4 = entity;
                        entity4.motionZ += d11 * d15;
                        if (entity instanceof EntityPlayer) {
                            final EntityPlayer entityplayer = (EntityPlayer)entity;
                            if (!CompatibilityProvider.compatibility.isSpectator(entityplayer) && (!CompatibilityProvider.compatibility.isCreative(entityplayer) || !entityplayer.capabilities.isFlying)) {
                                this.playerKnockbackMap.put(entityplayer, new CompatibleVec3(d9 * d14, d10 * d14, d11 * d14));
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void doExplosionB(final boolean spawnParticles) {
        CompatibilityProvider.compatibility.playSound(this.world, this.explosionX, this.explosionY, this.explosionZ, this.modContext.getExplosionSound(), 4.0f, (1.0f + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2f) * 0.7f);
        if (this.isSmoking) {
            for (final CompatibleBlockPos blockpos : this.affectedBlockPositions) {
                final CompatibleBlockState blockState = CompatibilityProvider.compatibility.getBlockAtPosition(this.world, blockpos);
                if (spawnParticles) {
                    for (int i = 0; i < 3; ++i) {
                        final double d0 = blockpos.getBlockPosX() + this.world.rand.nextFloat();
                        final double d2 = blockpos.getBlockPosY() + this.world.rand.nextFloat();
                        final double d3 = blockpos.getBlockPosZ() + this.world.rand.nextFloat();
                        double d4 = d0 - this.explosionX;
                        double d5 = d2 - this.explosionY;
                        double d6 = d3 - this.explosionZ;
                        final double d7 = CompatibleMathHelper.sqrt_double(d4 * d4 + d5 * d5 + d6 * d6);
                        d4 /= d7;
                        d5 /= d7;
                        d6 /= d7;
                        double d8 = 4.0 / (d7 / this.explosionSize + 0.1);
                        d8 *= this.world.rand.nextFloat() * this.world.rand.nextFloat() + 0.3f;
                        d4 *= d8;
                        d5 *= d8;
                        d6 *= d8;
                        this.modContext.getEffectManager().spawnExplosionParticle((d0 + this.explosionX) / 2.0, (d2 + this.explosionY) / 2.0, (d3 + this.explosionZ) / 2.0, d4 / 2.0, d5 * 2.0, d6 / 2.0, 1.5f * this.world.rand.nextFloat(), 15 + (int)(this.world.rand.nextFloat() * 10.0f));
                    }
                }
                if (!CompatibilityProvider.compatibility.isAirBlock(blockState)) {
                    if (CompatibilityProvider.compatibility.canDropBlockFromExplosion(blockState, this)) {
                        CompatibilityProvider.compatibility.dropBlockAsItemWithChance(this.world, blockState, blockpos, this.modContext.getConfigurationManager().getExplosions().getDropBlockChance() * (1.0f / this.explosionSize), 0);
                    }
                    CompatibilityProvider.compatibility.onBlockExploded(this.world, blockState, blockpos, this);
                }
            }
            if (spawnParticles) {
                for (int j = 0; j < 15; ++j) {
                    final double pX = this.explosionX + this.world.rand.nextGaussian() * 0.8;
                    final double pY = this.explosionY + this.world.rand.nextGaussian() * 0.9;
                    final double pZ = this.explosionZ + this.world.rand.nextGaussian() * 0.8;
                    final double motionX = this.world.rand.nextGaussian() * 0.001;
                    final double motionY = this.world.rand.nextGaussian() * 1.0E-4;
                    final double motionZ = this.world.rand.nextGaussian() * 0.001;
                    this.modContext.getEffectManager().spawnExplosionSmoke(pX, pY, pZ, motionX, motionY, motionZ, 1.0f, 250 + (int)(this.world.rand.nextFloat() * 30.0f), ExplosionSmokeFX.Behavior.EXPLOSION);
                }
            }
        }
        if (this.isFlaming) {
            for (final CompatibleBlockPos blockpos2 : this.affectedBlockPositions) {
                if (CompatibilityProvider.compatibility.isAirBlock(this.world, blockpos2) && CompatibilityProvider.compatibility.isFullBlock(CompatibilityProvider.compatibility.getBlockBelow(this.world, blockpos2)) && this.explosionRNG.nextInt(3) == 0) {
                    CompatibilityProvider.compatibility.setBlockToFire(this.world, blockpos2);
                }
            }
        }
    }
    
    public Map<EntityPlayer, CompatibleVec3> getPlayerKnockbackMap() {
        return this.playerKnockbackMap;
    }
    
    public EntityLivingBase getExplosivePlacedBy() {
        return (this.exploder == null) ? null : ((this.exploder instanceof EntityTNTPrimed) ? ((EntityTNTPrimed)this.exploder).getTntPlacedBy() : ((this.exploder instanceof EntityLivingBase) ? this.exploder : null));
    }
    
    public void clearAffectedBlockPositions() {
        this.affectedBlockPositions.clear();
    }
    
    public List<CompatibleBlockPos> getAffectedBlockPositions() {
        return this.affectedBlockPositions;
    }
    
    public CompatibleVec3 getPosition() {
        return this.position;
    }
}
