package com.vicmatskiv.weaponlib.particle;

import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class ExplosionParticleFX extends CompatibleParticle
{
    private static final String TEXTURE = "weaponlib:/com/vicmatskiv/weaponlib/resources/explosion-particles.png";
    private int imageIndex;
    private static final int columnCount = 5;
    private static final int rowCount = 5;
    
    public ExplosionParticleFX(final World par1World, final double positionX, final double positionY, final double positionZ, final float scale, final float motionX, final float motionY, final float motionZ) {
        this(par1World, positionY, positionY, positionZ, scale, motionX, motionY, motionZ, 0);
    }
    
    public ExplosionParticleFX(final World par1World, final double positionX, final double positionY, final double positionZ, final float scale, double motionX, final double motionY, final double motionZ, final int particleMaxAge) {
        super(par1World, positionX, positionY, positionZ, 0.0, 0.0, 0.0);
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        if (motionX == 0.0) {
            motionX = 1.0;
        }
        this.particleTextureIndexX = 0;
        this.particleTextureIndexY = 0;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleAlpha = 1.0f;
        this.particleScale = scale;
        this.particleMaxAge = ((particleMaxAge == 0) ? (50 + (int)(this.rand.nextFloat() * 30.0f)) : particleMaxAge);
        this.imageIndex = this.rand.nextInt(25);
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.motionY += 0.004;
        CompatibilityProvider.compatibility.moveParticle(this, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.99;
        this.motionY *= 0.99;
        this.motionY -= 0.07;
        this.motionZ *= 0.99;
        if (CompatibilityProvider.compatibility.isCollided(this)) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        this.particleAlpha = ((this.particleAge < 9) ? 1.0f : ((float)(1 + 9 / this.particleMaxAge - this.particleAge / this.particleMaxAge)));
    }
    
    @Override
    public void renderParticle(final CompatibleTessellator tessellator, final float partialTicks, final float par3, final float par4, final float par5, final float par6, final float par7) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("weaponlib:/com/vicmatskiv/weaponlib/resources/explosion-particles.png"));
        GL11.glPushMatrix();
        GL11.glPushAttrib(8192);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDepthMask(false);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glAlphaFunc(516, 0.003921569f);
        RenderHelper.disableStandardItemLighting();
        tessellator.startDrawingParticles();
        final float f10 = 0.1f * this.particleScale;
        final float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * partialTicks - ExplosionParticleFX.interpPosX);
        final float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * partialTicks - ExplosionParticleFX.interpPosY);
        final float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - ExplosionParticleFX.interpPosZ);
        tessellator.setColorRgba(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        final int i = this.getBrightnessForRender(partialTicks);
        final int j = i >> 16 & 0xFFFF;
        final int k = i & 0xFFFF;
        tessellator.setLightMap(j, k);
        final float columnWidth = 0.2f;
        final float rowHeight = 0.2f;
        final int rowIndex = Math.floorDiv(this.imageIndex, 5);
        final int columnIndex = this.imageIndex % 5;
        final float aU = (columnIndex + 1) * columnWidth;
        final float aV = (rowIndex + 1) * rowHeight;
        final float bU = aU;
        final float bV = rowIndex * rowHeight;
        final float cU = columnIndex * columnWidth;
        final float cV = bV;
        final float dU = cU;
        final float dV = aV;
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
