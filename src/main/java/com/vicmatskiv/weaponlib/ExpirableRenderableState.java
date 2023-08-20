package com.vicmatskiv.weaponlib;

class ExpirableRenderableState
{
    RenderableState state;
    long expiresAt;
    boolean singleUse;
    
    public ExpirableRenderableState(final RenderableState state, final long expiresAt, final boolean singleUse) {
        super();
        this.state = state;
        this.expiresAt = expiresAt;
        this.singleUse = singleUse;
    }
}
