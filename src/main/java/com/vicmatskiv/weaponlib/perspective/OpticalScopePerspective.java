package com.vicmatskiv.weaponlib.perspective;

import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class OpticalScopePerspective extends FirstPersonPerspective<RenderableState>
{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
    
    public OpticalScopePerspective() {
        super();
        this.width = 400;
        this.height = 400;
    }
    
    @Override
    public float getBrightness(final RenderContext<RenderableState> renderContext) {
        float brightness = 0.0f;
        final PlayerWeaponInstance instance = renderContext.getWeaponInstance();
        if (instance == null) {
            return 0.0f;
        }
        final boolean aimed = instance != null && instance.isAimed();
        final float progress = Math.min(1.0f, renderContext.getTransitionProgress());
        if (isAimingState(renderContext.getFromState()) && isAimingState(renderContext.getToState())) {
            brightness = 1.0f;
        }
        else if (progress > 0.0f && aimed && isAimingState(renderContext.getToState())) {
            brightness = progress;
        }
        else if (isAimingState(renderContext.getFromState()) && progress > 0.0f && !aimed) {
            brightness = Math.max(1.0f - progress, 0.0f);
        }
        return brightness;
    }
    
    private static boolean isAimingState(final RenderableState renderableState) {
        return renderableState == RenderableState.ZOOMING || renderableState == RenderableState.ZOOMING_RECOILED || renderableState == RenderableState.ZOOMING_SHOOTING;
    }
    
    @Override
    public void update(final CompatibleRenderTickEvent event) {
        final PlayerWeaponInstance instance = this.modContext.getMainHeldWeapon();
        if (instance != null && instance.isAimed()) {
            super.update(event);
        }
    }
}
