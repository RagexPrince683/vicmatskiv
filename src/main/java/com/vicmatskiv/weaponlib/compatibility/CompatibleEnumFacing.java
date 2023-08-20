package com.vicmatskiv.weaponlib.compatibility;

public enum CompatibleEnumFacing
{
    DOWN, 
    UP, 
    NORTH, 
    SOUTH, 
    WEST, 
    EAST;
    
    private static final /* synthetic */ CompatibleEnumFacing[] $VALUES;
    
    public static CompatibleEnumFacing[] values() {
        return CompatibleEnumFacing.$VALUES.clone();
    }
    
    public static CompatibleEnumFacing valueOf(final String name) {
        return Enum.valueOf(CompatibleEnumFacing.class, name);
    }
    
    static {
        $VALUES = new CompatibleEnumFacing[] { CompatibleEnumFacing.DOWN, CompatibleEnumFacing.UP, CompatibleEnumFacing.NORTH, CompatibleEnumFacing.SOUTH, CompatibleEnumFacing.WEST, CompatibleEnumFacing.EAST };
    }
}
