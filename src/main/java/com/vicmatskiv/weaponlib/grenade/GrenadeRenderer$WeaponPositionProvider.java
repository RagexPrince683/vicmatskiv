package com.vicmatskiv.weaponlib.grenade;

import com.vicmatskiv.weaponlib.*;
import java.util.*;
import com.vicmatskiv.weaponlib.animation.*;

private class WeaponPositionProvider implements MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>>
{
    final /* synthetic */ GrenadeRenderer this$0;
    
    private WeaponPositionProvider(final GrenadeRenderer this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public List<MultipartTransition<Part, RenderContext<RenderableState>>> getPositioning(final RenderableState state) {
        switch (state) {
            case SAFETY_PIN_OFF: {
                return GrenadeRenderer.access$1200(this.this$0, GrenadeRenderer.access$700(this.this$0).firstPersonPositioningSafetyPinOff, GrenadeRenderer.access$700(this.this$0).firstPersonLeftHandPositioningSafetyPinOff, GrenadeRenderer.access$700(this.this$0).firstPersonRightHandPositioningSafetyPinOff, GrenadeRenderer.access$700(this.this$0).firstPersonCustomPositioningSafetyPinOff);
            }
            case STRIKER_LEVEL_OFF: {
                return GrenadeRenderer.access$1700(this.this$0, GrenadeRenderer.access$700(this.this$0).firstPersonPositioningStrikerLeverOff, GrenadeRenderer.access$700(this.this$0).firstPersonLeftHandPositioningStrikerLeverOff, GrenadeRenderer.access$700(this.this$0).firstPersonRightHandPositioningStrikerLeverOff, GrenadeRenderer.access$700(this.this$0).firstPersonCustomPositioningStrikerLeverOff, GrenadeRenderer.access$700(this.this$0).animationDuration);
            }
            case THROWING: {
                return GrenadeRenderer.access$1200(this.this$0, GrenadeRenderer.access$700(this.this$0).firstPersonPositioningThrowing, GrenadeRenderer.access$700(this.this$0).firstPersonLeftHandPositioningThrowing, GrenadeRenderer.access$700(this.this$0).firstPersonRightHandPositioningThrowing, GrenadeRenderer.access$700(this.this$0).firstPersonCustomPositioningThrowing);
            }
            case THROWN: {
                return GrenadeRenderer.access$1700(this.this$0, GrenadeRenderer.access$700(this.this$0).firstPersonPositioningThrown, GrenadeRenderer.access$700(this.this$0).firstPersonLeftHandPositioningThrown, GrenadeRenderer.access$700(this.this$0).firstPersonRightHandPositioningThrown, GrenadeRenderer.access$700(this.this$0).firstPersonCustomPositioningThrown, GrenadeRenderer.access$700(this.this$0).animationDuration);
            }
            case NORMAL:
            case RUNNING: {
                return GrenadeRenderer.access$1700(this.this$0, GrenadeRenderer.access$700(this.this$0).firstPersonPositioning, GrenadeRenderer.access$700(this.this$0).firstPersonLeftHandPositioning, GrenadeRenderer.access$700(this.this$0).firstPersonRightHandPositioning, GrenadeRenderer.access$700(this.this$0).firstPersonCustomPositioning, GrenadeRenderer.access$700(this.this$0).animationDuration);
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
    
    WeaponPositionProvider(final GrenadeRenderer x0, final GrenadeRenderer$1 x1) {
        this(x0);
    }
}
