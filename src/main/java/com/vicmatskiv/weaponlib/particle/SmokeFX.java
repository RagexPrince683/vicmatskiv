package com.vicmatskiv.weaponlib.particle;

import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class SmokeFX extends CompatibleParticle
{
    private static final double SMOKE_SCALE_FACTOR = 1.0005988079071;
    private static final String SMOKE_TEXTURE = "weaponlib:/com/vicmatskiv/weaponlib/resources/smokes.png";
    private int imageIndex;
    private static final int imagesPerRow = 4;
    
    public SmokeFX(final World par1World, final double positionX, final double positionY, final double positionZ, final float scale, float motionX, final float motionY, final float motionZ) {
        super(par1World, positionX, positionY, positionZ, 0.0, 0.0, 0.0);
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        if (motionX == 0.0f) {
            motionX = 1.0f;
        }
        this.particleTextureIndexX = 0;
        this.particleTextureIndexY = 0;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleAlpha = 0.0f;
        this.particleScale *= scale;
        this.particleMaxAge = 50 + (int)(this.rand.nextFloat() * 30.0f);
        this.imageIndex = this.rand.nextInt() % 4;
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.motionY += 5.0E-4;
        CompatibilityProvider.compatibility.moveParticle(this, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.599999785423279;
        this.motionY *= 0.9999999785423279;
        this.motionZ *= 0.599999785423279;
        final double alphaRadians = 0.7853981633974483 + 3.141592653589793 * (float)this.particleAge / (float)this.particleMaxAge;
        this.particleAlpha = 0.2f * (float)Math.sin((alphaRadians > 3.141592653589793) ? 3.141592653589793 : alphaRadians);
        this.particleScale *= (float)1.0005988079071;
        if (this.isCollided()) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final CompatibleTessellator tessellator, final float partialTicks, final float par3, final float par4, final float par5, final float par6, final float par7) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("weaponlib:/com/vicmatskiv/weaponlib/resources/smokes.png"));
        GL11.glPushMatrix();
        GL11.glPushAttrib(8192);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glAlphaFunc(516, 0.003921569f);
        tessellator.startDrawingParticles();
        final float f10 = 0.1f * this.particleScale;
        final float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * partialTicks - SmokeFX.interpPosX);
        final float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * partialTicks - SmokeFX.interpPosY);
        final float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - SmokeFX.interpPosZ);
        tessellator.setColorRgba(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        final int i = this.getBrightnessForRender(partialTicks);
        final int j = i >> 16 & 0xFFFF;
        final int k = i & 0xFFFF;
        tessellator.setLightMap(j, k);
        RenderHelper.disableStandardItemLighting();
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
