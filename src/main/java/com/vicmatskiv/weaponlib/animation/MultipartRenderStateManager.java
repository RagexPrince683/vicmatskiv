package com.vicmatskiv.weaponlib.animation;

import org.lwjgl.util.vector.*;
import org.apache.logging.log4j.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import java.nio.*;
import java.util.*;

public class MultipartRenderStateManager<State, Part, Context extends PartPositionProvider>
{
    private static final Logger logger;
    private Randomizer randomizer;
    private WeakHashMap<Part, Matrix4f> lastApplied;
    private State currentState;
    private MultipartTransitionProvider<State, Part, Context> transitionProvider;
    private Deque<MultipartPositioning<Part, Context>> positioningQueue;
    
    public MultipartRenderStateManager(final State initialState, final MultipartTransitionProvider<State, Part, Context> transitionProvider, final Part mainPart) {
        super();
        this.lastApplied = new WeakHashMap<Part, Matrix4f>();
        this.transitionProvider = transitionProvider;
        this.positioningQueue = new LinkedList<MultipartPositioning<Part, Context>>();
        this.randomizer = new Randomizer();
        this.setState(initialState, false, true);
    }
    
    public void setState(final State newState, final boolean animated, final boolean immediate) {
        if (newState == null) {
            throw new IllegalArgumentException("State cannot be null");
        }
        if (newState.equals(this.currentState)) {
            return;
        }
        if (immediate) {
            this.positioningQueue.clear();
        }
        if (animated) {
            this.positioningQueue.add(new TransitionedPositioning(this.currentState, newState));
        }
        this.positioningQueue.add(new StaticPositioning(newState));
        this.currentState = newState;
    }
    
    public MultipartPositioning<Part, Context> nextPositioning() {
        MultipartPositioning<Part, Context> result = null;
        while (!this.positioningQueue.isEmpty()) {
            final MultipartPositioning<Part, Context> p = this.positioningQueue.poll();
            if (!p.isExpired(this.positioningQueue)) {
                this.positioningQueue.addFirst(p);
                result = p;
                break;
            }
        }
        if (result == null) {
            throw new IllegalStateException("Position cannot be null");
        }
        return result;
    }
    
    static /* synthetic */ MultipartTransitionProvider access$000(final MultipartRenderStateManager x0) {
        return x0.transitionProvider;
    }
    
    static /* synthetic */ WeakHashMap access$100(final MultipartRenderStateManager x0) {
        return x0.lastApplied;
    }
    
    static /* synthetic */ Randomizer access$300(final MultipartRenderStateManager x0) {
        return x0.randomizer;
    }
    
    static /* synthetic */ Logger access$400() {
        return MultipartRenderStateManager.logger;
    }
    
    static {
        logger = LogManager.getLogger((Class)MultipartRenderStateManager.class);
    }
    
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
            final List<MultipartTransition<Part, Context>> transitions = this.this$0.transitionProvider.getPositioning(this.state);
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
                            final Matrix4f m = this.this$1.this$0.lastApplied.get(part);
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
                    this.this$1.this$0.randomizer.update(rate, amplitude);
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
            this.fromPositioning = x0.transitionProvider.getPositioning(fromState);
            this.toPositioning = x0.transitionProvider.getPositioning(toState);
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
                        fromMatrix = this.this$0.lastApplied.get(p);
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
                MultipartRenderStateManager.logger.debug("Starting transition {}, duration {}ms, pause {}ms", new Object[] { this.currentIndex, currentDuration, currentPause });
                this.startTime = currentTime;
            }
            if (this.currentStartTime == 0L) {
                this.currentStartTime = currentTime;
            }
            else if (currentTime > this.currentStartTime + currentDuration + currentPause) {
                MultipartRenderStateManager.logger.debug("Completed transition {}, duration {}ms, pause {}ms", new Object[] { this.currentIndex, currentDuration, currentPause });
                ++this.currentIndex;
                if (MultipartRenderStateManager.logger.isDebugEnabled() && this.currentIndex < this.toPositioning.size()) {
                    final MultipartTransition<Part, Context> multipartTransition = this.toPositioning.get(this.currentIndex);
                    MultipartRenderStateManager.logger.debug("Starting transition {}, duration {}ms, pause {}ms", new Object[] { this.currentIndex, multipartTransition.getDuration(), multipartTransition.getPause() });
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
                        this.this$1.this$0.randomizer.update(0.0f, 0.0f);
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
                    this.this$1.this$0.randomizer.update(0.0f, 0.0f);
                }
                
                @Override
                public /* bridge */ void position(final Object part, final Object o) {
                    this.position(part, (PartPositionProvider)o);
                }
            };
        }
        
        private void applyOnce(final Part part, final Context context, final Matrix4f beforeMatrix, final Matrix4f afterMatrix, final Part attachedTo, final float progress) {
            MultipartRenderStateManager.logger.trace("Applying position for part {}", new Object[] { part });
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
            this.this$0.lastApplied.put(part, deltaMatrix);
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
                fromMatrix = this.this$0.lastApplied.get(p);
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
}
