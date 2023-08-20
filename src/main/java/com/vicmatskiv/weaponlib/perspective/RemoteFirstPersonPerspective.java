package com.vicmatskiv.weaponlib.perspective;

import net.minecraft.client.multiplayer.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;

public abstract class RemoteFirstPersonPerspective extends Perspective<RenderableState>
{
    private static final Logger logger;
    private long renderEndNanoTime;
    protected CompatiblePlayerCreatureWrapper watchablePlayer;
    
    public RemoteFirstPersonPerspective() {
        super();
        this.renderEndNanoTime = System.nanoTime();
        this.width = 427;
        this.height = 240;
        final WorldClient world = (WorldClient)CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer());
        this.watchablePlayer = new CompatiblePlayerCreatureWrapper(Minecraft.getMinecraft(), (World)world);
    }
    
    @Override
    public void update(final CompatibleRenderTickEvent event) {
        final EntityPlayer origPlayer = CompatibilityProvider.compatibility.clientPlayer();
        if (origPlayer == null) {
            return;
        }
        this.updateWatchablePlayer();
        final RenderGlobal origRenderGlobal = Minecraft.getMinecraft().renderGlobal;
        final CompatibleParticleManager origEffectRenderer = CompatibilityProvider.compatibility.getCompatibleParticleManager();
        final Entity origRenderViewEntity = CompatibilityProvider.compatibility.getRenderViewEntity();
        final EntityRenderer origEntityRenderer = Minecraft.getMinecraft().entityRenderer;
        final int origDisplayWidth = Minecraft.getMinecraft().displayWidth;
        final int origDisplayHeight = Minecraft.getMinecraft().displayHeight;
        Minecraft.getMinecraft().displayWidth = this.width;
        Minecraft.getMinecraft().displayHeight = this.height;
        this.framebuffer.bindFramebuffer(true);
        Minecraft.getMinecraft().renderGlobal = this.renderGlobal;
        Minecraft.getMinecraft().effectRenderer = this.effectRenderer.getParticleManager();
        Minecraft.getMinecraft().entityRenderer = this.entityRenderer;
        if (this.watchablePlayer.getEntityLiving() != null && !this.watchablePlayer.getEntityLiving().isDead) {
            CompatibilityProvider.compatibility.setRenderViewEntity((Entity)this.watchablePlayer.getEntityLiving());
            CompatibilityProvider.compatibility.setClientPlayer((EntityPlayer)this.watchablePlayer);
            this.modContext.getSafeGlobals().renderingPhase.set(RenderingPhase.RENDER_PERSPECTIVE);
            this.entityRenderer.setPrepareTerrain(true);
            this.entityRenderer.updateRenderer();
            final long p_78471_2_ = this.renderEndNanoTime + 16666666L;
            this.entityRenderer.renderWorld(event.getRenderTickTime(), p_78471_2_);
            this.modContext.getSafeGlobals().renderingPhase.set(RenderingPhase.NORMAL);
            CompatibilityProvider.compatibility.setRenderViewEntity(origRenderViewEntity);
            CompatibilityProvider.compatibility.setClientPlayer(origPlayer);
        }
        this.renderOverlay();
        Minecraft.getMinecraft().getFramebuffer().bindFramebuffer(true);
        Minecraft.getMinecraft().renderGlobal = origRenderGlobal;
        Minecraft.getMinecraft().effectRenderer = origEffectRenderer.getParticleManager();
        Minecraft.getMinecraft().displayWidth = origDisplayWidth;
        Minecraft.getMinecraft().displayHeight = origDisplayHeight;
        Minecraft.getMinecraft().entityRenderer = origEntityRenderer;
        this.renderEndNanoTime = System.nanoTime();
    }
    
    protected abstract void updateWatchablePlayer();
    
    protected void renderOverlay() {
        this.entityRenderer.setupOverlayRendering();
    }
    
    static {
        logger = LogManager.getLogger((Class)RemoteFirstPersonPerspective.class);
    }
}
