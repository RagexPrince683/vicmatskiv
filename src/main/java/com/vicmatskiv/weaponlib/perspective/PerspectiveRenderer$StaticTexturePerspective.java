package com.vicmatskiv.weaponlib.perspective;

import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;

private static class StaticTexturePerspective extends Perspective<RenderableState>
{
    private Integer textureId;
    
    private StaticTexturePerspective() {
        super();
    }
    
    @Override
    public void update(final CompatibleRenderTickEvent event) {
    }
    
    @Override
    public int getTexture(final RenderContext<RenderableState> context) {
        if (this.textureId == null) {
            final ResourceLocation textureResource = new ResourceLocation("weaponlib:/com/vicmatskiv/weaponlib/resources/dark-screen.png");
            Minecraft.getMinecraft().getTextureManager().bindTexture(textureResource);
            final ITextureObject textureObject = Minecraft.getMinecraft().getTextureManager().getTexture(textureResource);
            if (textureObject != null) {
                this.textureId = textureObject.getGlTextureId();
            }
        }
        return this.textureId;
    }
    
    @Override
    public float getBrightness(final RenderContext<RenderableState> context) {
        return 0.0f;
    }
    
    StaticTexturePerspective(final PerspectiveRenderer$1 x0) {
        this();
    }
}
