package com.vicmatskiv.weaponlib.animation;

private static class Position
{
    private float xRotation;
    private float yRotation;
    private float zRotation;
    private float x;
    private float y;
    private float z;
    private float scale;
    private float step;
    
    private Position() {
        super();
        this.scale = 1.0f;
        this.step = 0.025f;
    }
    
    static /* synthetic */ float access$000(final Position x0) {
        return x0.xRotation;
    }
    
    static /* synthetic */ float access$002(final Position x0, final float x1) {
        return x0.xRotation = x1;
    }
    
    static /* synthetic */ float access$100(final Position x0) {
        return x0.yRotation;
    }
    
    static /* synthetic */ float access$200(final Position x0) {
        return x0.zRotation;
    }
    
    static /* synthetic */ float access$102(final Position x0, final float x1) {
        return x0.yRotation = x1;
    }
    
    static /* synthetic */ float access$202(final Position x0, final float x1) {
        return x0.zRotation = x1;
    }
    
    static /* synthetic */ float access$300(final Position x0) {
        return x0.x;
    }
    
    static /* synthetic */ float access$302(final Position x0, final float x1) {
        return x0.x = x1;
    }
    
    static /* synthetic */ float access$400(final Position x0) {
        return x0.step;
    }
    
    static /* synthetic */ float access$500(final Position x0) {
        return x0.y;
    }
    
    static /* synthetic */ float access$600(final Position x0) {
        return x0.z;
    }
    
    static /* synthetic */ float access$502(final Position x0, final float x1) {
        return x0.y = x1;
    }
    
    static /* synthetic */ float access$602(final Position x0, final float x1) {
        return x0.z = x1;
    }
    
    static /* synthetic */ float access$702(final Position x0, final float x1) {
        return x0.scale = x1;
    }
    
    static /* synthetic */ float access$402(final Position x0, final float x1) {
        return x0.step = x1;
    }
    
    static /* synthetic */ float access$700(final Position x0) {
        return x0.scale;
    }
    
    Position(final DebugPositioner$1 x0) {
        this();
    }
}
