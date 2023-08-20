package com.vicmatskiv.weaponlib.animation;

import org.lwjgl.util.vector.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import java.nio.*;
import java.util.*;

private class TransitionedPositioning implements MultipartPositioning<Part, Context>
{
    private Map<Part, PartData> partDataMap;
    private Long startTime;
    private long totalDuration;
    private int currentIndex;
    private long currentStartTime;
    private boolean expired;
    private int segmentCount;
    private List<MultipartTransition<Part, Context>> fromPositioning;
    private List<MultipartTransition<Part, Context>> toPositioning;
    private State fromState;
    private State toState;
    final /* synthetic */ MultipartRenderStateManager this$0;
    
    TransitionedPositioning(final MultipartRenderStateManager x0, final State fromState, final State toState) {
        this.this$0 = x0;
        super();
        this.partDataMap = new HashMap<Part, PartData>();
        this.fromState = fromState;
        this.toState = toState;
        this.fromPositioning = MultipartRenderStateManager.access$000(x0).getPositioning(fromState);
        this.toPositioning = MultipartRenderStateManager.access$000(x0).getPositioning(toState);
        this.segmentCount = this.toPositioning.size();
        for (final MultipartTransition<Part, Context> t : this.toPositioning) {
            this.totalDuration += t.getDuration() + t.getPause();
        }
    }
    
    @Override
    public float getProgress() {
        return (this.startTime != null) ? ((System.currentTimeMillis() - this.startTime) / (float)this.totalDuration) : 0.0f;
    }
    
    @Override
    public boolean isExpired(final Queue<MultipartPositioning<Part, Context>> positioningQueue) {
        return this.expired;
    }
    
    @Override
    public <T> T getFromState(final Class<T> stateClass) {
        return stateClass.cast(this.fromState);
    }
    
    @Override
    public <T> T getToState(final Class<T> stateClass) {
        return stateClass.cast(this.toState);
    }
    
    private Matrix4f adjustToAttached(final Matrix4f matrix, final Part fromAttached, final Part toAttached, final Context context) {
        if (fromAttached == toAttached) {
            return matrix;
        }
        final Matrix4f fromMatrix = context.getPartPosition(fromAttached);
        if (fromMatrix == null) {
            return matrix;
        }
        final Matrix4f toMatrix = context.getPartPosition(toAttached);
        if (toMatrix == null) {
            return matrix;
        }
        final Matrix4f invertedToMatrix = Matrix4f.invert(toMatrix, (Matrix4f)null);
        if (invertedToMatrix == null) {
            return matrix;
        }
        final Matrix4f correctionMatrix = Matrix4f.mul(invertedToMatrix, fromMatrix, (Matrix4f)null);
        return Matrix4f.mul(correctionMatrix, matrix, (Matrix4f)null);
    }
    
    private PartData getPartData(final Part part, final Context context) {
        try {
            return this.partDataMap.computeIfAbsent(part, p -> {
                final PartData pd = new PartData(this);
                final MultipartTransition<Part, Context> fromMultipart = this.fromPositioning.get(this.fromPositioning.size() - 1);
                Matrix4f fromMatrix;
                if (fromMultipart.getPositioning((Part)o) == MultipartTransition.anchoredPosition()) {
                    fromMatrix = MultipartRenderStateManager.access$100(this.this$0).get(p);
                    if (fromMatrix == null) {
                        fromMatrix = new Matrix4f();
                        fromMatrix.setIdentity();
                    }
                }
                else {
                    fromMatrix = this.getMatrixForPositioning((MultipartTransition<Object, PartPositionProvider>)fromMultipart, p, context2);
                }
                final Matrix4f fromMatrix2 = this.adjustToAttached(fromMatrix, (Object)fromMultipart.getAttachedTo((Part)p), this.toPositioning.get(0).getAttachedTo(p), context2);
                pd.matrices.add(fromMatrix2);
                pd.attachedTo = (Part)this.toPositioning.get(0).getAttachedTo(p);
                Matrix4f previous = fromMatrix2;
                this.toPositioning.iterator();
                final Iterator iterator;
                while (iterator.hasNext()) {
                    final MultipartTransition<Part, Context> t = iterator.next();
                    Matrix4f current;
                    if (t.getPositioning((Part)o) == MultipartTransition.anchoredPosition()) {
                        current = previous;
                    }
                    else {
                        current = this.getMatrixForPositioning((MultipartTransition<Object, PartPositionProvider>)t, p, context2);
                    }
                    pd.matrices.add(current);
                    previous = current;
                }
                return pd;
            });
        }
        catch (final Exception e) {
            System.err.println("Failed to get data for part " + part + " for transition from [" + this.fromState + "] to [" + this.toState + "]");
            throw e;
        }
    }
    
    @Override
    public Positioner<Part, Context> getPositioner() {
        final long currentTime = System.currentTimeMillis();
        final MultipartTransition<Part, Context> targetState = this.toPositioning.get(this.currentIndex);
        final long currentDuration = targetState.getDuration();
        final long currentPause = targetState.getPause();
        if (this.currentIndex == 0 && this.startTime == null) {
            MultipartRenderStateManager.access$400().debug("Starting transition {}, duration {}ms, pause {}ms", new Object[] { this.currentIndex, currentDuration, currentPause });
            this.startTime = currentTime;
        }
        if (this.currentStartTime == 0L) {
            this.currentStartTime = currentTime;
        }
        else if (currentTime > this.currentStartTime + currentDuration + currentPause) {
            MultipartRenderStateManager.access$400().debug("Completed transition {}, duration {}ms, pause {}ms", new Object[] { this.currentIndex, currentDuration, currentPause });
            ++this.currentIndex;
            if (MultipartRenderStateManager.access$400().isDebugEnabled() && this.currentIndex < this.toPositioning.size()) {
                final MultipartTransition<Part, Context> multipartTransition = this.toPositioning.get(this.currentIndex);
                MultipartRenderStateManager.access$400().debug("Starting transition {}, duration {}ms, pause {}ms", new Object[] { this.currentIndex, multipartTransition.getDuration(), multipartTransition.getPause() });
            }
            this.currentStartTime = currentTime;
        }
        final long currentOffset = currentTime - this.currentStartTime;
        float currentProgress = currentOffset / (float)currentDuration;
        if (currentProgress > 1.0f) {
            currentProgress = 1.0f;
        }
        final float finalCurrentProgress = currentProgress;
        if (this.currentIndex >= this.segmentCount) {
            this.expired = true;
            return new Positioner<Part, Context>() {
                final /* synthetic */ TransitionedPositioning this$1;
                
                MultipartRenderStateManager$TransitionedPositioning$1() {
                    this.this$1 = this$1;
                    super();
                }
                
                @Override
                public void position(final Part part, final Context context) {
                    final PartData partData = TransitionedPositioning.this.getPartData(part, context);
                    TransitionedPositioning.this.applyOnce(part, context, partData.matrices.get(this.this$1.currentIndex - 1), partData.matrices.get(this.this$1.currentIndex), partData.attachedTo, 1.0f);
                }
                
                @Override
                public void randomize(final float rate, final float amplitude) {
                    MultipartRenderStateManager.access$300(this.this$1.this$0).update(0.0f, 0.0f);
                }
                
                @Override
                public /* bridge */ void position(final Object part, final Object o) {
                    this.position(part, (PartPositionProvider)o);
                }
            };
        }
        return new Positioner<Part, Context>() {
            final /* synthetic */ float val$finalCurrentProgress;
            final /* synthetic */ TransitionedPositioning this$1;
            
            MultipartRenderStateManager$TransitionedPositioning$2() {
                this.this$1 = this$1;
                super();
            }
            
            @Override
            public void position(final Part part, final Context context) {
                final PartData partData = TransitionedPositioning.this.getPartData(part, context);
                TransitionedPositioning.this.applyOnce(part, context, partData.matrices.get(this.this$1.currentIndex), partData.matrices.get(this.this$1.currentIndex + 1), partData.attachedTo, finalCurrentProgress);
            }
            
            @Override
            public void randomize(final float rate, final float amplitude) {
                MultipartRenderStateManager.access$300(this.this$1.this$0).update(0.0f, 0.0f);
            }
            
            @Override
            public /* bridge */ void position(final Object part, final Object o) {
                this.position(part, (PartPositionProvider)o);
            }
        };
    }
    
    private void applyOnce(final Part part, final Context context, final Matrix4f beforeMatrix, final Matrix4f afterMatrix, final Part attachedTo, final float progress) {
        MultipartRenderStateManager.access$400().trace("Applying position for part {}", new Object[] { part });
        Matrix4f currentMatrix = null;
        if (attachedTo != null) {
            currentMatrix = context.getPartPosition(attachedTo);
        }
        if (currentMatrix == null) {
            currentMatrix = MatrixHelper.captureMatrix();
        }
        final Matrix4f m1 = MatrixHelper.interpolateMatrix(beforeMatrix, 1.0f - progress);
        final Matrix4f m2 = MatrixHelper.interpolateMatrix(afterMatrix, progress);
        final Matrix4f deltaMatrix = Matrix4f.add(m1, m2, (Matrix4f)null);
        MultipartRenderStateManager.access$100(this.this$0).put(part, deltaMatrix);
        final Matrix4f composite = Matrix4f.mul(currentMatrix, deltaMatrix, (Matrix4f)null);
        MatrixHelper.loadMatrix(composite);
    }
    
    private Matrix4f getMatrixForPositioning(final MultipartTransition<Part, Context> transition, final Part part, final Context context) {
        GL11.glPushMatrix();
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        final FloatBuffer buf = BufferUtils.createFloatBuffer(16);
        transition.position(part, context);
        GL11.glGetFloat(2982, buf);
        buf.rewind();
        final Matrix4f matrix = new Matrix4f();
        matrix.load(buf);
        GL11.glPopMatrix();
        return matrix;
    }
    
    private /* synthetic */ PartData lambda$getPartData$199(final Object o, final PartPositionProvider context, final Object p) {
        final PartData pd = new PartData(this);
        final MultipartTransition<Part, Context> fromMultipart = this.fromPositioning.get(this.fromPositioning.size() - 1);
        Matrix4f fromMatrix;
        if (fromMultipart.getPositioning((Part)o) == MultipartTransition.anchoredPosition()) {
            fromMatrix = MultipartRenderStateManager.access$100(this.this$0).get(p);
            if (fromMatrix == null) {
                fromMatrix = new Matrix4f();
                fromMatrix.setIdentity();
            }
        }
        else {
            fromMatrix = this.getMatrixForPositioning((MultipartTransition<Object, PartPositionProvider>)fromMultipart, p, context);
        }
        fromMatrix = this.adjustToAttached(fromMatrix, (Object)fromMultipart.getAttachedTo((Part)p), this.toPositioning.get(0).getAttachedTo(p), context);
        pd.matrices.add(fromMatrix);
        pd.attachedTo = (Part)this.toPositioning.get(0).getAttachedTo(p);
        Matrix4f previous = fromMatrix;
        for (final MultipartTransition<Part, Context> t : this.toPositioning) {
            Matrix4f current;
            if (t.getPositioning((Part)o) == MultipartTransition.anchoredPosition()) {
                current = previous;
            }
            else {
                current = this.getMatrixForPositioning((MultipartTransition<Object, PartPositionProvider>)t, p, context);
            }
            pd.matrices.add(current);
            previous = current;
        }
        return pd;
    }
    
    static /* synthetic */ PartData access$500(final TransitionedPositioning x0, final Object x1, final PartPositionProvider x2) {
        return x0.getPartData(x1, x2);
    }
    
    static /* synthetic */ int access$600(final TransitionedPositioning x0) {
        return x0.currentIndex;
    }
    
    static /* synthetic */ void access$700(final TransitionedPositioning x0, final Object x1, final PartPositionProvider x2, final Matrix4f x3, final Matrix4f x4, final Object x5, final float x6) {
        x0.applyOnce(x1, x2, x3, x4, x5, x6);
    }
    
    private class PartData
    {
        List<Matrix4f> matrices;
        Part attachedTo;
        final /* synthetic */ TransitionedPositioning this$1;
        
        private PartData(final TransitionedPositioning this$1) {
            this.this$1 = this$1;
            super();
            this.matrices = new ArrayList<Matrix4f>();
        }
        
        PartData(final TransitionedPositioning x0, final MultipartRenderStateManager$1 x1) {
            this(x0);
        }
    }
}
