package com.vicmatskiv.weaponlib.grenade;

public enum RenderableState
{
    NORMAL, 
    RUNNING, 
    SAFETY_PIN_OFF, 
    STRIKER_LEVEL_OFF, 
    THROWING, 
    THROWN;
    
    private static final /* synthetic */ RenderableState[] $VALUES;
    
    public static RenderableState[] values() {
        return RenderableState.$VALUES.clone();
    }
    
    public static RenderableState valueOf(final String name) {
        return Enum.valueOf(RenderableState.class, name);
    }
    
    static {
        $VALUES = new RenderableState[] { RenderableState.NORMAL, RenderableState.RUNNING, RenderableState.SAFETY_PIN_OFF, RenderableState.STRIKER_LEVEL_OFF, RenderableState.THROWING, RenderableState.THROWN };
    }
}
