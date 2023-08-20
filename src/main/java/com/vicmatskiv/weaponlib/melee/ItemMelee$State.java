package com.vicmatskiv.weaponlib.melee;

public enum State
{
    READY, 
    SHOOTING, 
    RELOAD_REQUESTED, 
    RELOAD_CONFIRMED, 
    UNLOAD_STARTED, 
    UNLOAD_REQUESTED_FROM_SERVER, 
    UNLOAD_CONFIRMED, 
    PAUSED, 
    MODIFYING, 
    EJECT_SPENT_ROUND;
    
    private static final /* synthetic */ State[] $VALUES;
    
    public static State[] values() {
        return State.$VALUES.clone();
    }
    
    public static State valueOf(final String name) {
        return Enum.valueOf(State.class, name);
    }
    
    static {
        $VALUES = new State[] { State.READY, State.SHOOTING, State.RELOAD_REQUESTED, State.RELOAD_CONFIRMED, State.UNLOAD_STARTED, State.UNLOAD_REQUESTED_FROM_SERVER, State.UNLOAD_CONFIRMED, State.PAUSED, State.MODIFYING, State.EJECT_SPENT_ROUND };
    }
}
