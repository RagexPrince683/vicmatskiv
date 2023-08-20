package com.vicmatskiv.weaponlib.melee;

public enum RenderableState
{
    NORMAL, 
    MODIFYING, 
    RUNNING, 
    ATTACKING, 
    HEAVY_ATTACKING;
    
    private static final /* synthetic */ RenderableState[] $VALUES;
    
    public static RenderableState[] values() {
        return RenderableState.$VALUES.clone();
    }
    
    public static RenderableState valueOf(final String name) {
        return Enum.valueOf(RenderableState.class, name);
    }
    
    static {
        $VALUES = new RenderableState[] { RenderableState.NORMAL, RenderableState.MODIFYING, RenderableState.RUNNING, RenderableState.ATTACKING, RenderableState.HEAVY_ATTACKING };
    }
}
