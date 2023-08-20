package com.vicmatskiv.weaponlib.compatibility;

import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.*;

protected static class StateDescriptor
{
    protected MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>> stateManager;
    protected float rate;
    protected float amplitude;
    private PlayerWeaponInstance instance;
    
    public StateDescriptor(final PlayerWeaponInstance instance, final MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>> stateManager, final float rate, final float amplitude) {
        super();
        this.amplitude = 0.04f;
        this.instance = instance;
        this.stateManager = stateManager;
        this.rate = rate;
        this.amplitude = amplitude;
    }
    
    static /* synthetic */ PlayerWeaponInstance access$000(final StateDescriptor x0) {
        return x0.instance;
    }
}
