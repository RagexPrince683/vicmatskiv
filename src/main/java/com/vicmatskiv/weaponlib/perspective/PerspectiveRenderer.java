package com.vicmatskiv.weaponlib.perspective;

import java.util.function.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;

public class PerspectiveRenderer implements CustomRenderer<RenderableState>
{
    private static Perspective<RenderableState> STATIC_TEXTURE_PERSPECTIVE;
    private ViewfinderModel model;
    private BiConsumer<EntityPlayer, ItemStack> positioning;
    
    public PerspectiveRenderer(final BiConsumer<EntityPlayer, ItemStack> positioning) {
        super();
        this.model = new ViewfinderModel();
        this.positioning = positioning;
    }
    
    @Override
    public void render(final RenderContext<RenderableState> renderContext) {
        if (renderContext.getCompatibleTransformType() != CompatibleTransformType.FIRST_PERSON_RIGHT_HAND && renderContext.getCompatibleTransformType() != CompatibleTransformType.FIRST_PERSON_LEFT_HAND) {
            return;
        }
        if (renderContext.getModContext() == null) {
            return;
        }
        final ClientModContext clientModContext = (ClientModContext)renderContext.getModContext();
        Perspective<RenderableState> perspective = (Perspective<RenderableState>)clientModContext.getViewManager().getPerspective(renderContext.getPlayerItemInstance(), false);
        if (perspective == null) {
            perspective = PerspectiveRenderer.STATIC_TEXTURE_PERSPECTIVE;
        }
        final float brightness = perspective.getBrightness(renderContext);
        GL11.glPushMatrix();
        GL11.glPushAttrib(8193);
        this.positioning.accept(renderContext.getPlayer(), renderContext.getWeapon());
        GL11.glBindTexture(3553, perspective.getTexture(renderContext));
        CompatibilityProvider.compatibility.disableLightMap();
        GL11.glEnable(2929);
        GL11.glDisable(2896);
        GL11.glDisable(3008);
        GL11.glDisable(3042);
        GL11.glColor4f(brightness, brightness, brightness, 1.0f);
        this.model.render((Entity)renderContext.getPlayer(), renderContext.getLimbSwing(), renderContext.getFlimbSwingAmount(), renderContext.getAgeInTicks(), renderContext.getNetHeadYaw(), renderContext.getHeadPitch(), renderContext.getScale());
        CompatibilityProvider.compatibility.enableLightMap();
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }
    
    static {
        PerspectiveRenderer.STATIC_TEXTURE_PERSPECTIVE = new StaticTexturePerspective();
    }
    
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
}
