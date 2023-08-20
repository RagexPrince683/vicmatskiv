package com.vicmatskiv.weaponlib.animation;

import java.util.*;
import org.lwjgl.util.vector.*;

private class StaticPositioning implements MultipartPositioning<Part, Context>
{
    private State state;
    final /* synthetic */ MultipartRenderStateManager this$0;
    
    public StaticPositioning(final MultipartRenderStateManager this$0, final State state) {
        this.this$0 = this$0;
        super();
        this.state = state;
    }
    
    @Override
    public float getProgress() {
        return 1.0f;
    }
    
    @Override
    public boolean isExpired(final Queue<MultipartPositioning<Part, Context>> positioningQueue) {
        return !positioningQueue.isEmpty();
    }
    
    @Override
    public Positioner<Part, Context> getPositioner() {
        final List<MultipartTransition<Part, Context>> transitions = MultipartRenderStateManager.access$000(this.this$0).getPositioning(this.state);
        return new Positioner<Part, Context>() {
            final /* synthetic */ List val$transitions;
            final /* synthetic */ StaticPositioning this$1;
            
            MultipartRenderStateManager$StaticPositioning$1() {
                this.this$1 = this$1;
                super();
            }
            
            @Override
            public void position(final Part part, final Context context) {
                try {
                    final MultipartTransition<Part, Context> multipartTransition = transitions.get(transitions.size() - 1);
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
                    System.err.println("Failed to find static position for " + part + " in " + this.this$1.state);
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
        };
    }
    
    @Override
    public <T> T getFromState(final Class<T> stateClass) {
        return stateClass.cast(this.state);
    }
    
    @Override
    public <T> T getToState(final Class<T> stateClass) {
        return stateClass.cast(this.state);
    }
    
    static /* synthetic */ Object access$200(final StaticPositioning x0) {
        return x0.state;
    }
}
