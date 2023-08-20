package com.vicmatskiv.weaponlib.compatibility;

public enum Phase
{
    START, 
    END;
    
    private static final /* synthetic */ Phase[] $VALUES;
    
    public static Phase[] values() {
        return Phase.$VALUES.clone();
    }
    
    public static Phase valueOf(final String name) {
        return Enum.valueOf(Phase.class, name);
    }
    
    static {
        $VALUES = new Phase[] { Phase.START, Phase.END };
    }
}
