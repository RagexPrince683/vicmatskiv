package com.vicmatskiv.weaponlib;

import java.util.*;
import com.vicmatskiv.weaponlib.animation.*;

private class WeaponPositionProvider implements MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>>
{
    final /* synthetic */ WeaponRenderer this$0;
    
    private WeaponPositionProvider(final WeaponRenderer this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public List<MultipartTransition<Part, RenderContext<RenderableState>>> getPositioning(final RenderableState state) {
        switch (state) {
            case MODIFYING: {
                return WeaponRenderer.access$1600(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningModifying, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningModifying, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningModifying, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioning, 250);
            }
            case RUNNING: {
                return WeaponRenderer.access$1600(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningRunning, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningRunning, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningRunning, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioning, 250);
            }
            case UNLOADING: {
                return WeaponRenderer.access$2300(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningUnloading, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningUnloading, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningUnloading, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioningUnloading);
            }
            case RELOADING: {
                return WeaponRenderer.access$2300(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningReloading, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningReloading, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningReloading, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioningReloading);
            }
            case RECOILED: {
                return WeaponRenderer.access$1600(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningRecoiled, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningRecoiled, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningRecoiled, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioningRecoiled, WeaponRenderer.access$1100(this.this$0).recoilAnimationDuration);
            }
            case SHOOTING: {
                return WeaponRenderer.access$1600(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningShooting, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningShooting, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningShooting, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioning, WeaponRenderer.access$1100(this.this$0).shootingAnimationDuration);
            }
            case EJECT_SPENT_ROUND: {
                return WeaponRenderer.access$2300(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningEjectSpentRound, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningEjectSpentRound, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningEjectSpentRound, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioningEjectSpentRound);
            }
            case NORMAL: {
                return WeaponRenderer.access$1600(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioning, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioning, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioning, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioning, 250);
            }
            case ZOOMING: {
                return WeaponRenderer.access$1600(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningZooming, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningZooming, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningZooming, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioning, 250);
            }
            case ZOOMING_SHOOTING: {
                return WeaponRenderer.access$1600(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningZoomingShooting, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningZooming, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningZooming, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioningZoomingShooting, 60);
            }
            case ZOOMING_RECOILED: {
                return WeaponRenderer.access$1600(this.this$0, WeaponRenderer.access$1100(this.this$0).firstPersonPositioningZoomingRecoiled, WeaponRenderer.access$1100(this.this$0).firstPersonLeftHandPositioningZooming, WeaponRenderer.access$1100(this.this$0).firstPersonRightHandPositioningZooming, WeaponRenderer.access$1100(this.this$0).firstPersonCustomPositioningZoomingRecoiled, 60);
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public /* bridge */ List getPositioning(final Object o) {
        return this.getPositioning((RenderableState)o);
    }
    
    WeaponPositionProvider(final WeaponRenderer x0, final WeaponRenderer$1 x1) {
        this(x0);
    }
}
