package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.particle.*;

final class ClientEffectManager implements EffectManager
{
    ClientEffectManager() {
        super();
    }
    
    @Override
    public void spawnSmokeParticle(final EntityPlayer player, final float xOffset, final float yOffset) {
        final double motionX = CompatibilityProvider.compatibility.world((Entity)player).rand.nextGaussian() * 0.003;
        final double motionY = CompatibilityProvider.compatibility.world((Entity)player).rand.nextGaussian() * 0.003;
        final double motionZ = CompatibilityProvider.compatibility.world((Entity)player).rand.nextGaussian() * 0.003;
        final CompatibleVec3 look = CompatibilityProvider.compatibility.getLookVec(player);
        final float distance = 0.3f;
        final float scale = 1.0f * CompatibilityProvider.compatibility.getEffectScaleFactor();
        final float positionRandomizationFactor = 0.01f;
        final double posX = player.posX + look.getVec().xCoord * distance + (CompatibilityProvider.compatibility.world((Entity)player).rand.nextFloat() * 2.0f - 1.0f) * positionRandomizationFactor + -look.getVec().zCoord * xOffset;
        final double posY = player.posY + look.getVec().yCoord * distance + (CompatibilityProvider.compatibility.world((Entity)player).rand.nextFloat() * 2.0f - 1.0f) * positionRandomizationFactor - yOffset;
        final double posZ = player.posZ + look.getVec().zCoord * distance + (CompatibilityProvider.compatibility.world((Entity)player).rand.nextFloat() * 2.0f - 1.0f) * positionRandomizationFactor + look.getVec().xCoord * xOffset;
        final SmokeFX smokeParticle = new SmokeFX(CompatibilityProvider.compatibility.world((Entity)player), posX, posY, posZ, scale, (float)motionX, (float)motionY, (float)motionZ);
        Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)smokeParticle);
    }
    
    @Override
    public void spawnFlashParticle(final EntityPlayer player, final float flashIntensity, final float flashScale, final float xOffset, final float yOffset) {
        final float distance = 0.5f;
        final float scale = 0.8f * CompatibilityProvider.compatibility.getEffectScaleFactor() * flashScale;
        final float positionRandomizationFactor = 0.003f;
        final CompatibleVec3 look = CompatibilityProvider.compatibility.getLookVec(player);
        final float motionX = (float)CompatibilityProvider.compatibility.world((Entity)player).rand.nextGaussian() * 0.003f;
        final float motionY = (float)CompatibilityProvider.compatibility.world((Entity)player).rand.nextGaussian() * 0.003f;
        final float motionZ = (float)CompatibilityProvider.compatibility.world((Entity)player).rand.nextGaussian() * 0.003f;
        final double posX = player.posX + look.getVec().xCoord * distance + (CompatibilityProvider.compatibility.world((Entity)player).rand.nextFloat() * 2.0f - 1.0f) * positionRandomizationFactor + -look.getVec().zCoord * xOffset;
        final double posY = player.posY + look.getVec().yCoord * distance + (CompatibilityProvider.compatibility.world((Entity)player).rand.nextFloat() * 2.0f - 1.0f) * positionRandomizationFactor - yOffset;
        final double posZ = player.posZ + look.getVec().zCoord * distance + (CompatibilityProvider.compatibility.world((Entity)player).rand.nextFloat() * 2.0f - 1.0f) * positionRandomizationFactor + look.getVec().xCoord * xOffset;
        final FlashFX flashParticle = new FlashFX(CompatibilityProvider.compatibility.world((Entity)player), posX, posY, posZ, scale, flashIntensity, motionX, motionY, motionZ);
        Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)flashParticle);
    }
    
    @Override
    public void spawnExplosionSmoke(final double posX, final double posY, final double posZ, final double motionX, final double motionY, final double motionZ, final float scale, final int maxAge, final ExplosionSmokeFX.Behavior behavior) {
        final World world = CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer());
        final ExplosionSmokeFX smokeParticle = new ExplosionSmokeFX(world, posX, posY, posZ, scale, (float)motionX, (float)motionY, (float)motionZ, maxAge, ExplosionSmokeFX.Behavior.SMOKE_GRENADE);
        Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)smokeParticle);
    }
    
    @Override
    public void spawnExplosionParticle(final double posX, final double posY, final double posZ, final double motionX, final double motionY, final double motionZ, final float scale, final int maxAge) {
        final World world = CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer());
        final ExplosionParticleFX explosionParticle = new ExplosionParticleFX(world, posX, posY, posZ, scale, motionX, motionY, motionZ, maxAge);
        Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)explosionParticle);
    }
}
