package com.vicmatskiv.weaponlib.particle;

import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class FlashFX extends CompatibleParticle
{
    private static final float FLASH_ALPHA_FACTOR = 0.8f;
    private static final double FLASH_SCALE_FACTOR = 1.1;
    private static final String FLASH_TEXTURE = "weaponlib:/com/vicmatskiv/weaponlib/resources/flashes.png";
    private int imageIndex;
    private static final int imagesPerRow = 4;
    
    public FlashFX(final World par1World, final double positionX, final double positionY, final double positionZ, final float scale, final float alpha, float motionX, float motionY, float motionZ) {
        super(par1World, positionX, positionY, positionZ, 0.0, 0.0, 0.0);
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        if (motionX == 0.0f) {
            motionX = 0.01f;
        }
        if (motionZ == 0.0f) {
            motionZ = 0.01f;
        }
        if (motionY == 0.0f) {
            motionY = 0.01f;
        }
        this.particleTextureIndexX = 0;
        this.particleTextureIndexY = 0;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleAlpha = alpha;
        this.particleScale *= 1.4f;
        this.particleScale *= scale;
        this.particleMaxAge = 2;
        this.imageIndex = this.rand.nextInt() % 4;
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        CompatibilityProvider.compatibility.moveParticle(this, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9999999785423279;
        this.motionY *= 0.9999999785423279;
        this.motionZ *= 0.9999999785423279;
        this.particleAlpha *= 0.8f;
        this.particleScale *= (float)1.1;
        if (this.isCollided()) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final CompatibleTessellator tessellator, final float partialTicks, final float par3, final float par4, final float par5, final float par6, final float par7) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("weaponlib:/com/vicmatskiv/weaponlib/resources/flashes.png"));
        GL11.glPushMatrix();
        GL11.glPushAttrib(8192);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glAlphaFunc(516, 0.003921569f);
        tessellator.startDrawingParticles();
        final int i = this.getBrightnessForRender(partialTicks);
        final int j = i >> 16 & 0xFFFF;
        final int k = i & 0xFFFF;
        tessellator.setLightMap(j, k);
        RenderHelper.disableStandardItemLighting();
        final float f10 = 0.1f * this.particleScale;
        final float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * partialTicks - FlashFX.interpPosX);
        final float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * partialTicks - FlashFX.interpPosY);
        final float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - FlashFX.interpPosZ);
        tessellator.setColorRgba(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        final float uWidth = 0.25f;
        final float aU = (this.imageIndex + 1) * uWidth;
        final float aV = 1.0f;
        final float bU = (this.imageIndex + 1) * uWidth;
        final float bV = 0.0f;
        final float cU = this.imageIndex * uWidth;
        final float cV = 0.0f;
        final float dU = this.imageIndex * uWidth;
        final float dV = 1.0f;
        tessellator.addVertexWithUV(f11 - par3 * f10 - par6 * f10, f12 - par4 * f10, f13 - par5 * f10 - par7 * f10, aU, aV);
        tessellator.addVertexWithUV(f11 - par3 * f10 + par6 * f10, f12 + par4 * f10, f13 - par5 * f10 + par7 * f10, bU, bV);
        tessellator.addVertexWithUV(f11 + par3 * f10 + par6 * f10, f12 + par4 * f10, f13 + par5 * f10 + par7 * f10, cU, cV);
        tessellator.addVertexWithUV(f11 + par3 * f10 - par6 * f10, f12 - par4 * f10, f13 + par5 * f10 - par7 * f10, dU, dV);
        tessellator.draw();
        RenderHelper.enableStandardItemLighting();
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }
    
    public int getFXLayer() {
        return 3;
    }
}
