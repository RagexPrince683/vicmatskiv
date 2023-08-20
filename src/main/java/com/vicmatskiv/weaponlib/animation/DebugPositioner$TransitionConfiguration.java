package com.vicmatskiv.weaponlib.animation;

public static final class TransitionConfiguration
{
    private long pause;
    
    public TransitionConfiguration() {
        super();
    }
    
    public long getPause() {
        return this.pause;
    }
    
    public void setPause(final long pause) {
        this.pause = pause;
    }
    
    static /* synthetic */ long access$802(final TransitionConfiguration x0, final long x1) {
        return x0.pause = x1;
    }
}
