package com.vicmatskiv.weaponlib.config;

public enum StatusBarPosition
{
    TOP_RIGHT, 
    BOTTOM_RIGHT, 
    TOP_LEFT, 
    BOTTOM_LEFT;
    
    private static final /* synthetic */ StatusBarPosition[] $VALUES;
    
    public static StatusBarPosition[] values() {
        return StatusBarPosition.$VALUES.clone();
    }
    
    public static StatusBarPosition valueOf(final String name) {
        return Enum.valueOf(StatusBarPosition.class, name);
    }
    
    static {
        $VALUES = new StatusBarPosition[] { StatusBarPosition.TOP_RIGHT, StatusBarPosition.BOTTOM_RIGHT, StatusBarPosition.TOP_LEFT, StatusBarPosition.BOTTOM_LEFT };
    }
}
