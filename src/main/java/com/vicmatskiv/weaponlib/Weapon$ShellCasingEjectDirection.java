package com.vicmatskiv.weaponlib;

public enum ShellCasingEjectDirection
{
    LEFT, 
    RIGHT;
    
    private static final /* synthetic */ ShellCasingEjectDirection[] $VALUES;
    
    public static ShellCasingEjectDirection[] values() {
        return ShellCasingEjectDirection.$VALUES.clone();
    }
    
    public static ShellCasingEjectDirection valueOf(final String name) {
        return Enum.valueOf(ShellCasingEjectDirection.class, name);
    }
    
    static {
        $VALUES = new ShellCasingEjectDirection[] { ShellCasingEjectDirection.LEFT, ShellCasingEjectDirection.RIGHT };
    }
}
