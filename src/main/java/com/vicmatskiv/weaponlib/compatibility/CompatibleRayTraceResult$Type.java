package com.vicmatskiv.weaponlib.compatibility;

public enum Type
{
    MISS, 
    BLOCK, 
    ENTITY;
    
    private static final /* synthetic */ Type[] $VALUES;
    
    public static Type[] values() {
        return Type.$VALUES.clone();
    }
    
    public static Type valueOf(final String name) {
        return Enum.valueOf(Type.class, name);
    }
    
    static {
        $VALUES = new Type[] { Type.MISS, Type.BLOCK, Type.ENTITY };
    }
}
