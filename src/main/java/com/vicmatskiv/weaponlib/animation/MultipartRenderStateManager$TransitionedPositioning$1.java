package com.vicmatskiv.weaponlib.animation;

import org.lwjgl.util.vector.*;

class MultipartRenderStateManager$TransitionedPositioning$1 implements Positioner<Part, Context> {
    final /* synthetic */ TransitionedPositioning this$1;
    
    MultipartRenderStateManager$TransitionedPositioning$1(final TransitionedPositioning this$1) {
        this.this$1 = this$1;
        super();
    }
    
    @Override
    public void position(final Part part, final Context context) {
        final PartData partData = TransitionedPositioning.access$500(this.this$1, part, context);
        TransitionedPositioning.access$700(this.this$1, part, context, partData.matrices.get(TransitionedPositioning.access$600(this.this$1) - 1), partData.matrices.get(TransitionedPositioning.access$600(this.this$1)), partData.attachedTo, 1.0f);
    }
    
    @Override
    public void randomize(final float rate, final float amplitude) {
        MultipartRenderStateManager.access$300(this.this$1.this$0).update(0.0f, 0.0f);
    }
    
    @Override
    public /* bridge */ void position(final Object part, final Object o) {
        this.position(part, (PartPositionProvider)o);
    }
}