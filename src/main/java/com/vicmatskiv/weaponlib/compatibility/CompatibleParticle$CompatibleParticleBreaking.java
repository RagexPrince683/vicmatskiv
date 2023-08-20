package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.particle.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;

public static class CompatibleParticleBreaking extends EntityBreakingFX
{
    public static final String TEXTURE_BLOOD_PARTICLES = "particle/blood";
    
    protected CompatibleParticleBreaking(final ModContext modContext, final World worldIn, final double posXIn, final double posYIn, final double posZIn) {
        super(worldIn, posXIn, posYIn, posZIn, Items.snowball);
        final TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(modContext.getNamedResource("particle/blood").toString());
        this.setParticleIcon((IIcon)sprite);
    }
}
