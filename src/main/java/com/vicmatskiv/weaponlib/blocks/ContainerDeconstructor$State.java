package com.vicmatskiv.weaponlib.blocks;

public enum State
{
    ERROR, 
    READY;
    
    private static final /* synthetic */ State[] $VALUES;
    
    public static State[] values() {
        return State.$VALUES.clone();
    }
    
    public static State valueOf(final String name) {
        return Enum.valueOf(State.class, name);
    }
    
    static {
        $VALUES = new State[] { State.ERROR, State.READY };
    }
}
