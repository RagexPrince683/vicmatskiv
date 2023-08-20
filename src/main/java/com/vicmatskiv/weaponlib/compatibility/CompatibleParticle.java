package com.vicmatskiv.weaponlib.compatibility;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.particle.*;
import net.minecraft.init.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;

public abstract class CompatibleParticle extends EntityFX
{
    public static CompatibleParticleBreaking createParticleBreaking(final ModContext modContext, final World worldIn, final double posXIn, final double posYIn, final double posZIn) {
        return new CompatibleParticleBreaking(modContext, worldIn, posXIn, posYIn, posZIn);
    }
    
    public CompatibleParticle(final World par1World, final double positionX, final double positionY, final double positionZ, final double motionX, final double motionY, final double motionZ) {
        super(par1World, positionX, positionY, positionZ, motionX, motionY, motionZ);
    }
    
    protected void setExpired() {
        this.setDead();
    }
    
    protected boolean isCollided() {
        return this.onGround;
    }
    
    @SideOnly(Side.CLIENT)
    public final void renderParticle(final Tessellator tessellator, final float p_70539_2_, final float p_70539_3_, final float p_70539_4_, final float p_70539_5_, final float p_70539_6_, final float p_70539_7_) {
        this.renderParticle(CompatibleTessellator.getInstance(), p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
    }
    
    public abstract void renderParticle(final CompatibleTessellator p0, final float p1, final float p2, final float p3, final float p4, final float p5, final float p6);
    
    public static class CompatibleParticleBreaking extends EntityBreakingFX
    {
        public static final String TEXTURE_BLOOD_PARTICLES = "particle/blood";
        
        protected CompatibleParticleBreaking(final ModContext modContext, final World worldIn, final double posXIn, final double posYIn, final double posZIn) {
            super(worldIn, posXIn, posYIn, posZIn, Items.snowball);
            final TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(modContext.getNamedResource("particle/blood").toString());
            this.setParticleIcon((IIcon)sprite);
        }
    }
}
