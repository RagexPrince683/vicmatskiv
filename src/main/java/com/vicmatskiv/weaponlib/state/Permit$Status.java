package com.vicmatskiv.weaponlib.state;

public enum Status
{
    REQUESTED, 
    GRANTED, 
    DENIED, 
    UNKNOWN;
    
    private static final /* synthetic */ Status[] $VALUES;
    
    public static Status[] values() {
        return Status.$VALUES.clone();
    }
    
    public static Status valueOf(final String name) {
        return Enum.valueOf(Status.class, name);
    }
    
    static {
        $VALUES = new Status[] { Status.REQUESTED, Status.GRANTED, Status.DENIED, Status.UNKNOWN };
    }
}
