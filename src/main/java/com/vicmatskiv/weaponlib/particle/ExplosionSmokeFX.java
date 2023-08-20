package com.vicmatskiv.weaponlib.particle;

import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class ExplosionSmokeFX extends CompatibleParticle
{
    private static final String SMOKE_TEXTURE = "weaponlib:/com/vicmatskiv/weaponlib/resources/large-smoke.png";
    private int imageIndex;
    private static final int columnCount = 4;
    private static final int rowCount = 4;
    private static final TriFunction<Float, Integer, Integer, Float> EXPLOSION_SCALE_UPDATE_FUNCTION;
    private static final TriFunction<Float, Integer, Integer, Float> SMOKE_GRENADE_SCALE_UPDATE_FUNCTION;
    private static final TriFunction<Float, Integer, Integer, Float> EXPLOSION_ALPHA_UPDATE_FUNCTION;
    private static final TriFunction<Float, Integer, Integer, Float> SMOKE_GRENADE_ALPHA_UPDATE_FUNCTION;
    private Behavior behavior;
    
    public ExplosionSmokeFX(final World par1World, final double positionX, final double positionY, final double positionZ, final float scale, float motionX, final float motionY, final float motionZ, final int particleMaxAge, final Behavior behavior) {
        super(par1World, positionX, positionY, positionZ, 0.0, 0.0, 0.0);
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        if (motionX == 0.0f) {
            motionX = 1.0f;
        }
        this.behavior = behavior;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleAlpha = 0.0f;
        this.particleScale *= scale;
        this.particleMaxAge = ((particleMaxAge == 0) ? (50 + (int)(this.rand.nextFloat() * 30.0f)) : particleMaxAge);
        this.imageIndex = this.rand.nextInt(16);
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.motionY += 1.0E-5;
        CompatibilityProvider.compatibility.moveParticle(this, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.599999785423279;
        this.motionY *= 0.9999999785423279;
        this.motionZ *= 0.599999785423279;
        this.particleAlpha = this.behavior.alphaUpdateFunction.apply(this.particleAlpha, this.particleAge, this.particleMaxAge);
        this.particleScale = this.behavior.scaleUpdateFunction.apply(this.particleScale, this.particleAge, this.particleMaxAge);
        if (this.isCollided()) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final CompatibleTessellator tessellator, final float partialTicks, final float par3, final float par4, final float par5, final float par6, final float par7) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("weaponlib:/com/vicmatskiv/weaponlib/resources/large-smoke.png"));
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
        final float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * partialTicks - ExplosionSmokeFX.interpPosX);
        final float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * partialTicks - ExplosionSmokeFX.interpPosY);
        final float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - ExplosionSmokeFX.interpPosZ);
        tessellator.setColorRgba(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        final int i = this.getBrightnessForRender(partialTicks);
        final int j = i >> 16 & 0xFFFF;
        final int k = i & 0xFFFF;
        tessellator.setLightMap(j, k);
        final float columnWidth = 0.25f;
        final float rowHeight = 0.25f;
        final int rowIndex = Math.floorDiv(this.imageIndex, 4);
        final int columnIndex = this.imageIndex % 4;
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
    
    private static /* synthetic */ Float lambda$static$194(final Float currentAlpha, final Integer ticks, final Integer maxTicks) {
        final double alphaRadians = 0.7853981633974483 + 3.141592653589793 * ticks / maxTicks;
        return 0.3f * (float)Math.sin((alphaRadians > 3.141592653589793) ? 3.141592653589793 : alphaRadians);
    }
    
    private static /* synthetic */ Float lambda$static$193(final Float currentAlpha, final Integer ticks, final Integer maxTicks) {
        final double alphaRadians = 0.7853981633974483 + 3.141592653589793 * ticks / maxTicks;
        return 0.3f * (float)Math.sin((alphaRadians > 3.141592653589793) ? 3.141592653589793 : alphaRadians);
    }
    
    private static /* synthetic */ Float lambda$static$192(Float currentScale, final Integer ticks, final Integer maxTicks) {
        if (currentScale > 25.0f) {
            currentScale *= 1.0008f;
        }
        else if (currentScale > 20.0f) {
            currentScale *= 1.002f;
        }
        else if (currentScale > 15.0f) {
            currentScale *= 1.004f;
        }
        else if (currentScale > 5.0f) {
            currentScale *= 1.05f;
        }
        else {
            currentScale *= 2.0f;
        }
        return currentScale;
    }
    
    private static /* synthetic */ Float lambda$static$191(Float currentScale, final Integer ticks, final Integer maxTicks) {
        if (currentScale > 25.0f) {
            currentScale *= 1.0008f;
        }
        else if (currentScale > 20.0f) {
            currentScale *= 1.002f;
        }
        else if (currentScale > 15.0f) {
            currentScale *= 1.004f;
        }
        else if (currentScale > 10.0f) {
            currentScale *= 1.05f;
        }
        else {
            currentScale *= 3.0f;
        }
        return currentScale;
    }
    
    static /* synthetic */ TriFunction access$000() {
        return ExplosionSmokeFX.EXPLOSION_SCALE_UPDATE_FUNCTION;
    }
    
    static /* synthetic */ TriFunction access$100() {
        return ExplosionSmokeFX.EXPLOSION_ALPHA_UPDATE_FUNCTION;
    }
    
    static /* synthetic */ TriFunction access$200() {
        return ExplosionSmokeFX.SMOKE_GRENADE_SCALE_UPDATE_FUNCTION;
    }
    
    static /* synthetic */ TriFunction access$300() {
        return ExplosionSmokeFX.SMOKE_GRENADE_ALPHA_UPDATE_FUNCTION;
    }
    
    static {
        EXPLOSION_SCALE_UPDATE_FUNCTION = ((currentScale, ticks, maxTicks) -> {
            if (currentScale > 25.0f) {
                currentScale *= 1.0008f;
            }
            else if (currentScale > 20.0f) {
                currentScale *= 1.002f;
            }
            else if (currentScale > 15.0f) {
                currentScale *= 1.004f;
            }
            else if (currentScale > 10.0f) {
                currentScale *= 1.05f;
            }
            else {
                currentScale *= 3.0f;
            }
            return currentScale;
        });
        SMOKE_GRENADE_SCALE_UPDATE_FUNCTION = ((currentScale, ticks, maxTicks) -> {
            if (currentScale > 25.0f) {
                currentScale *= 1.0008f;
            }
            else if (currentScale > 20.0f) {
                currentScale *= 1.002f;
            }
            else if (currentScale > 15.0f) {
                currentScale *= 1.004f;
            }
            else if (currentScale > 5.0f) {
                currentScale *= 1.05f;
            }
            else {
                currentScale *= 2.0f;
            }
            return currentScale;
        });
        EXPLOSION_ALPHA_UPDATE_FUNCTION = ((currentAlpha, ticks, maxTicks) -> {
            final double alphaRadians = 0.7853981633974483 + 3.141592653589793 * ticks / maxTicks;
            return Float.valueOf(0.3f * (float)Math.sin((alphaRadians > 3.141592653589793) ? 3.141592653589793 : alphaRadians));
        });
        SMOKE_GRENADE_ALPHA_UPDATE_FUNCTION = ((currentAlpha, ticks, maxTicks) -> {
            final double alphaRadians2 = 0.7853981633974483 + 3.141592653589793 * ticks / maxTicks;
            return Float.valueOf(0.3f * (float)Math.sin((alphaRadians2 > 3.141592653589793) ? 3.141592653589793 : alphaRadians2));
        });
    }
    
    public enum Behavior
    {
        EXPLOSION((TriFunction<Float, Integer, Integer, Float>)ExplosionSmokeFX.EXPLOSION_SCALE_UPDATE_FUNCTION, (TriFunction<Float, Integer, Integer, Float>)ExplosionSmokeFX.EXPLOSION_ALPHA_UPDATE_FUNCTION), 
        SMOKE_GRENADE((TriFunction<Float, Integer, Integer, Float>)ExplosionSmokeFX.SMOKE_GRENADE_SCALE_UPDATE_FUNCTION, (TriFunction<Float, Integer, Integer, Float>)ExplosionSmokeFX.SMOKE_GRENADE_ALPHA_UPDATE_FUNCTION);
        
        private TriFunction<Float, Integer, Integer, Float> scaleUpdateFunction;
        private TriFunction<Float, Integer, Integer, Float> alphaUpdateFunction;
        private static final /* synthetic */ Behavior[] $VALUES;
        
        public static Behavior[] values() {
            return Behavior.$VALUES.clone();
        }
        
        public static Behavior valueOf(final String name) {
            return Enum.valueOf(Behavior.class, name);
        }
        
        private Behavior(final TriFunction<Float, Integer, Integer, Float> scaleUpdateFunction, final TriFunction<Float, Integer, Integer, Float> alphaUpdateFunction) {
            this.scaleUpdateFunction = scaleUpdateFunction;
            this.alphaUpdateFunction = alphaUpdateFunction;
        }
        
        static /* synthetic */ TriFunction access$400(final Behavior x0) {
            return x0.alphaUpdateFunction;
        }
        
        static /* synthetic */ TriFunction access$500(final Behavior x0) {
            return x0.scaleUpdateFunction;
        }
        
        static {
            $VALUES = new Behavior[] { Behavior.EXPLOSION, Behavior.SMOKE_GRENADE };
        }
    }
    
    public interface TriFunction<T, U, V, R>
    {
        R apply(final T p0, final U p1, final V p2);
    }
}
