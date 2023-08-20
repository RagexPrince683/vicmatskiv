package com.vicmatskiv.weaponlib;

public enum RenderableState
{
    NORMAL, 
    MODIFYING, 
    ZOOMING, 
    RUNNING, 
    UNLOADING, 
    RELOADING, 
    SHOOTING, 
    AUTO_SHOOTING, 
    RECOILED, 
    ZOOMING_RECOILED, 
    ZOOMING_SHOOTING, 
    EJECT_SPENT_ROUND;
    
    private static final /* synthetic */ RenderableState[] $VALUES;
    
    public static RenderableState[] values() {
        return RenderableState.$VALUES.clone();
    }
    
    public static RenderableState valueOf(final String name) {
        return Enum.valueOf(RenderableState.class, name);
    }
    
    static {
        $VALUES = new RenderableState[] { RenderableState.NORMAL, RenderableState.MODIFYING, RenderableState.ZOOMING, RenderableState.RUNNING, RenderableState.UNLOADING, RenderableState.RELOADING, RenderableState.SHOOTING, RenderableState.AUTO_SHOOTING, RenderableState.RECOILED, RenderableState.ZOOMING_RECOILED, RenderableState.ZOOMING_SHOOTING, RenderableState.EJECT_SPENT_ROUND };
    }
}
