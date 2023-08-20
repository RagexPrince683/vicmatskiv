package com.vicmatskiv.weaponlib.perspective;

import net.minecraft.client.shader.*;
import net.minecraft.client.renderer.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public abstract class Perspective<S>
{
    protected ClientModContext modContext;
    protected Framebuffer framebuffer;
    protected int width;
    protected int height;
    protected CompatibleWorldRenderer entityRenderer;
    protected RenderGlobal renderGlobal;
    protected CompatibleParticleManager effectRenderer;
    
    public Perspective() {
        super();
    }
    
    public void activate(final ClientModContext modContext, final PerspectiveManager manager) {
        this.modContext = modContext;
        if (this.framebuffer == null) {
            (this.framebuffer = new Framebuffer(this.width, this.height, true)).setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.entityRenderer = manager.getEntityRenderer();
        this.effectRenderer = manager.getEffectRenderer();
        this.renderGlobal = manager.getRenderGlobal();
    }
    
    public void deactivate(final ClientModContext modContext) {
        this.framebuffer.framebufferClear();
    }
    
    public float getBrightness(final RenderContext<S> context) {
        return 1.0f;
    }
    
    public int getTexture(final RenderContext<S> context) {
        return (this.framebuffer != null) ? this.framebuffer.framebufferTexture : -1;
    }
    
    public Framebuffer getFramebuffer() {
        return this.framebuffer;
    }
    
    public abstract void update(final CompatibleRenderTickEvent p0);
}
