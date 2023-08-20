package com.vicmatskiv.weaponlib;

public enum RenderingPhase
{
    RENDER_PERSPECTIVE, 
    NORMAL;
    
    private static final /* synthetic */ RenderingPhase[] $VALUES;
    
    public static RenderingPhase[] values() {
        return RenderingPhase.$VALUES.clone();
    }
    
    public static RenderingPhase valueOf(final String name) {
        return Enum.valueOf(RenderingPhase.class, name);
    }
    
    static {
        $VALUES = new RenderingPhase[] { RenderingPhase.RENDER_PERSPECTIVE, RenderingPhase.NORMAL };
    }
}
