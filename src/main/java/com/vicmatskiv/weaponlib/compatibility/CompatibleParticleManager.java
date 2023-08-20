package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.particle.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.*;
import net.minecraft.world.*;

public class CompatibleParticleManager
{
    private EffectRenderer effectRenderer;
    
    public CompatibleParticleManager(final WorldClient world) {
        super();
        this.effectRenderer = new EffectRenderer((World)world, Minecraft.getMinecraft().getTextureManager());
    }
    
    public CompatibleParticleManager(final EffectRenderer effectRenderer) {
        super();
        this.effectRenderer = effectRenderer;
    }
    
    public EffectRenderer getParticleManager() {
        return this.effectRenderer;
    }
}
