package com.vicmatskiv.weaponlib.perspective;

import net.minecraft.client.renderer.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.client.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.entity.*;
import org.apache.logging.log4j.*;

public class PerspectiveManager
{
    private static final Logger logger;
    private Perspective<?> currentPerspective;
    private ClientModContext clientModContext;
    private CompatibleWorldRenderer entityRenderer;
    private RenderGlobal renderGlobal;
    private CompatibleParticleManager effectRenderer;
    
    public PerspectiveManager(final ClientModContext clientModContext) {
        super();
        this.clientModContext = clientModContext;
    }
    
    public Perspective<?> getPerspective(final PlayerItemInstance<?> currentInstance, final boolean init) {
        if (currentInstance == null || (this.currentPerspective == null && !init)) {
            return null;
        }
        final Class<? extends Perspective<?>> perspectiveClass = currentInstance.getRequiredPerspectiveType();
        if (perspectiveClass != null) {
            if (this.currentPerspective == null) {
                this.currentPerspective = this.createActivePerspective(perspectiveClass);
            }
            else if (!perspectiveClass.isInstance(this.currentPerspective)) {
                this.currentPerspective.deactivate(this.clientModContext);
                this.currentPerspective = this.createActivePerspective(perspectiveClass);
            }
        }
        else if (this.currentPerspective != null) {
            if (init) {
                this.currentPerspective.deactivate(this.clientModContext);
            }
            this.currentPerspective = null;
        }
        return this.currentPerspective;
    }
    
    private Perspective<?> createActivePerspective(final Class<? extends Perspective<?>> perspectiveClass) {
        Perspective<?> result = null;
        try {
            result = (Perspective)perspectiveClass.newInstance();
            result.activate(this.clientModContext, this);
        }
        catch (final InstantiationException | IllegalAccessException e) {
            PerspectiveManager.logger.error("Failed to create view of {} - {}", new Object[] { perspectiveClass, e, e });
        }
        return result;
    }
    
    CompatibleWorldRenderer getEntityRenderer() {
        if (this.entityRenderer == null) {
            this.entityRenderer = new CompatibleWorldRenderer(Minecraft.getMinecraft(), Minecraft.getMinecraft().getResourceManager());
        }
        return this.entityRenderer;
    }
    
    RenderGlobal getRenderGlobal() {
        if (this.renderGlobal == null) {
            this.renderGlobal = CompatibilityProvider.compatibility.createCompatibleRenderGlobal();
            final WorldClient world = (WorldClient)CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer());
            this.renderGlobal.setWorldAndLoadRenderers(world);
        }
        return this.renderGlobal;
    }
    
    CompatibleParticleManager getEffectRenderer() {
        if (this.effectRenderer == null) {
            final WorldClient world = (WorldClient)CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer());
            this.effectRenderer = CompatibilityProvider.compatibility.createCompatibleParticleManager(world);
        }
        return this.effectRenderer;
    }
    
    static {
        logger = LogManager.getLogger((Class)PerspectiveManager.class);
    }
}
