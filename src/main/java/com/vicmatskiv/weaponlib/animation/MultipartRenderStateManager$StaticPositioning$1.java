package com.vicmatskiv.weaponlib.animation;

import java.util.*;
import org.lwjgl.util.vector.*;

class MultipartRenderStateManager$StaticPositioning$1 implements Positioner<Part, Context> {
    final /* synthetic */ List val$transitions;
    final /* synthetic */ StaticPositioning this$1;
    
    MultipartRenderStateManager$StaticPositioning$1(final StaticPositioning this$1, final List val$transitions) {
        this.this$1 = this$1;
        this.val$transitions = val$transitions;
        super();
    }
    
    @Override
    public void position(final Part part, final Context context) {
        try {
            final MultipartTransition<Part, Context> multipartTransition = this.val$transitions.get(this.val$transitions.size() - 1);
            final Part attachedTo = multipartTransition.getAttachedTo(part);
            if (attachedTo != null) {
                MatrixHelper.loadMatrix(context.getPartPosition(attachedTo));
            }
            if (multipartTransition.getPositioning(part) == MultipartTransition.anchoredPosition()) {
                final Matrix4f m = MultipartRenderStateManager.access$100(this.this$1.this$0).get(part);
                MatrixHelper.applyMatrix(m);
            }
            else {
                multipartTransition.position(part, context);
            }
        }
        catch (final Exception e) {
            System.err.println("Failed to find static position for " + part + " in " + StaticPositioning.access$200(this.this$1));
            throw e;
        }
    }
    
    @Override
    public void randomize(final float rate, final float amplitude) {
        MultipartRenderStateManager.access$300(this.this$1.this$0).update(rate, amplitude);
    }
    
    @Override
    public /* bridge */ void position(final Object part, final Object o) {
        this.position(part, (PartPositionProvider)o);
    }
}