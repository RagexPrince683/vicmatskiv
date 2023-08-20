package com.vicmatskiv.weaponlib.animation;

import java.util.function.*;
import java.util.*;

public class MultipartTransition<Part, Context>
{
    private static final Consumer<?> ANCHORED_POSITION;
    private Map<Part, Consumer<Context>> multipartPositionFunctions;
    private Map<Part, Part> attachedTo;
    private long duration;
    private long pause;
    
    public static <Context> Consumer<Context> anchoredPosition() {
        return (Consumer<Context>)MultipartTransition.ANCHORED_POSITION;
    }
    
    public MultipartTransition(final Part part, final Consumer<Context> positionFunction, final long duration, final long pause) {
        super();
        this.multipartPositionFunctions = new HashMap<Part, Consumer<Context>>();
        this.attachedTo = new HashMap<Part, Part>();
        this.duration = duration;
        this.pause = pause;
        this.multipartPositionFunctions.put(part, positionFunction);
    }
    
    public MultipartTransition(final Part part, final Consumer<Context> positionFunction, final long duration) {
        this(part, positionFunction, duration, 0L);
    }
    
    public MultipartTransition(final long duration, final long pause) {
        super();
        this.multipartPositionFunctions = new HashMap<Part, Consumer<Context>>();
        this.attachedTo = new HashMap<Part, Part>();
        this.duration = duration;
        this.pause = pause;
    }
    
    public MultipartTransition(final long duration) {
        this(duration, 0L);
    }
    
    public MultipartTransition<Part, Context> withPartPositionFunction(final Part part, final Consumer<Context> positionFunction) {
        return this.withPartPositionFunction(part, null, positionFunction);
    }
    
    public MultipartTransition<Part, Context> withPartPositionFunction(final Part part, final Part attachedTo, final Consumer<Context> positionFunction) {
        this.multipartPositionFunctions.put(part, positionFunction);
        this.attachedTo.put(part, attachedTo);
        return this;
    }
    
    public void position(final Part part, final Context context) {
        final Consumer<Context> positionFunction = this.multipartPositionFunctions.get(part);
        if (positionFunction == null) {
            throw new IllegalArgumentException("Don't know anything about part " + part);
        }
        positionFunction.accept(context);
    }
    
    public Consumer<Context> getPositioning(final Part part) {
        return this.multipartPositionFunctions.get(part);
    }
    
    public long getDuration() {
        return this.duration;
    }
    
    public long getPause() {
        return this.pause;
    }
    
    public Part getAttachedTo(final Part part) {
        return this.attachedTo.get(part);
    }
    
    private static /* synthetic */ void lambda$static$207(final Object c) {
    }
    
    static {
        ANCHORED_POSITION = (c -> {});
    }
}
