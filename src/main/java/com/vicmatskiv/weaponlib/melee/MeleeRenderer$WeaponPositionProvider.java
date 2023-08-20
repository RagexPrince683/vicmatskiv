package com.vicmatskiv.weaponlib.melee;

import com.vicmatskiv.weaponlib.*;
import java.util.*;
import com.vicmatskiv.weaponlib.animation.*;

private class WeaponPositionProvider implements MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>>
{
    final /* synthetic */ MeleeRenderer this$0;
    
    private WeaponPositionProvider(final MeleeRenderer this$0) {
        this.this$0 = this$0;
        super();
    }
    
    @Override
    public List<MultipartTransition<Part, RenderContext<RenderableState>>> getPositioning(final RenderableState state) {
        switch (state) {
            case MODIFYING: {
                return MeleeRenderer.access$1200(this.this$0, MeleeRenderer.access$700(this.this$0).firstPersonPositioningModifying, MeleeRenderer.access$700(this.this$0).firstPersonLeftHandPositioningModifying, MeleeRenderer.access$700(this.this$0).firstPersonRightHandPositioningModifying, MeleeRenderer.access$700(this.this$0).firstPersonCustomPositioning, MeleeRenderer.access$700(this.this$0).animationDuration);
            }
            case RUNNING: {
                return MeleeRenderer.access$1200(this.this$0, MeleeRenderer.access$700(this.this$0).firstPersonPositioningRunning, MeleeRenderer.access$700(this.this$0).firstPersonLeftHandPositioningRunning, MeleeRenderer.access$700(this.this$0).firstPersonRightHandPositioningRunning, MeleeRenderer.access$700(this.this$0).firstPersonCustomPositioning, MeleeRenderer.access$700(this.this$0).animationDuration);
            }
            case ATTACKING: {
                return MeleeRenderer.access$1900(this.this$0, MeleeRenderer.access$700(this.this$0).firstPersonPositioningAttacking, MeleeRenderer.access$700(this.this$0).firstPersonLeftHandPositioningAttacking, MeleeRenderer.access$700(this.this$0).firstPersonRightHandPositioningAttacking, MeleeRenderer.access$700(this.this$0).firstPersonCustomPositioningAttacking);
            }
            case HEAVY_ATTACKING: {
                return MeleeRenderer.access$1900(this.this$0, MeleeRenderer.access$700(this.this$0).firstPersonPositioningHeavyAttacking, MeleeRenderer.access$700(this.this$0).firstPersonLeftHandPositioningHeavyAttacking, MeleeRenderer.access$700(this.this$0).firstPersonRightHandPositioningHeavyAttacking, MeleeRenderer.access$700(this.this$0).firstPersonCustomPositioningHeavyAttacking);
            }
            case NORMAL: {
                return MeleeRenderer.access$1200(this.this$0, MeleeRenderer.access$700(this.this$0).firstPersonPositioning, MeleeRenderer.access$700(this.this$0).firstPersonLeftHandPositioning, MeleeRenderer.access$700(this.this$0).firstPersonRightHandPositioning, MeleeRenderer.access$700(this.this$0).firstPersonCustomPositioning, MeleeRenderer.access$700(this.this$0).animationDuration);
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
    
    WeaponPositionProvider(final MeleeRenderer x0, final MeleeRenderer$1 x1) {
        this(x0);
    }
}
