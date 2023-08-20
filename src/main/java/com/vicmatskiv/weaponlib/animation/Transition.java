package com.vicmatskiv.weaponlib.animation;

import java.util.function.*;
import com.vicmatskiv.weaponlib.*;

public class Transition<Context>
{
    private static final Consumer<?> ANCHORED_POSITION;
    private Consumer<Context> itemPositioning;
    private long duration;
    private long pause;
    private Part attachedTo;
    private boolean animated;
    
    public static <T> Consumer<T> anchoredPosition() {
        return (Consumer<T>)Transition.ANCHORED_POSITION;
    }
    
    public Transition(final Consumer<Context> itemPositioning, final Part attachedTo, final boolean animated) {
        this(itemPositioning, 0L, 0L);
        this.animated = animated;
    }
    
    public Transition(final Consumer<Context> itemPositioning, final long duration) {
        this(itemPositioning, duration, 0L);
    }
    
    public Transition(final Consumer<Context> itemPositioning, final long duration, final long pause) {
        this(itemPositioning, duration, pause, null);
    }
    
    public Transition(final Consumer<Context> itemPositioning, final long duration, final long pause, final Part attachedTo) {
        super();
        this.itemPositioning = itemPositioning;
        this.duration = duration;
        this.pause = pause;
        this.attachedTo = attachedTo;
    }
    
    public Consumer<Context> getItemPositioning() {
        return this.itemPositioning;
    }
    
    public long getDuration() {
        return this.duration;
    }
    
    public long getPause() {
        return this.pause;
    }
    
    public Part getAttachedTo() {
        return this.attachedTo;
    }
    
    public boolean isAnimated() {
        return this.animated;
    }
    
    private static /* synthetic */ void lambda$static$206(final Object c) {
    }
    
    static {
        ANCHORED_POSITION = (c -> {});
    }
}
