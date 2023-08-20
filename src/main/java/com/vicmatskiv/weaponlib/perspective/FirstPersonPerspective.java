package com.vicmatskiv.weaponlib.perspective;

import net.minecraft.client.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.client.renderer.*;

public class FirstPersonPerspective<S> extends Perspective<S>
{
    private long renderEndNanoTime;
    
    public FirstPersonPerspective() {
        super();
        this.renderEndNanoTime = System.nanoTime();
        this.width = Minecraft.getMinecraft().displayWidth;
        this.height = Minecraft.getMinecraft().displayHeight;
    }
    
    @Override
    public void update(final CompatibleRenderTickEvent event) {
        this.modContext.getSafeGlobals().renderingPhase.set(RenderingPhase.RENDER_PERSPECTIVE);
        final long p_78471_2_ = this.renderEndNanoTime + 16666666L;
        final int origDisplayWidth = Minecraft.getMinecraft().displayWidth;
        final int origDisplayHeight = Minecraft.getMinecraft().displayHeight;
        final EntityRenderer origEntityRenderer = Minecraft.getMinecraft().entityRenderer;
        this.framebuffer.bindFramebuffer(true);
        Minecraft.getMinecraft().displayWidth = this.width;
        Minecraft.getMinecraft().displayHeight = this.height;
        Minecraft.getMinecraft().entityRenderer = this.entityRenderer;
        this.entityRenderer.setPrepareTerrain(false);
        this.entityRenderer.updateRenderer();
        this.entityRenderer.renderWorld(event.getRenderTickTime(), p_78471_2_);
        Minecraft.getMinecraft().entityRenderer = origEntityRenderer;
        Minecraft.getMinecraft().getFramebuffer().bindFramebuffer(true);
        Minecraft.getMinecraft().displayWidth = origDisplayWidth;
        Minecraft.getMinecraft().displayHeight = origDisplayHeight;
        this.renderEndNanoTime = System.nanoTime();
        this.modContext.getSafeGlobals().renderingPhase.set(RenderingPhase.NORMAL);
    }
}
