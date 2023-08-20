package com.vicmatskiv.weaponlib;

public enum EntityAction
{
    STOP;
    
    private static final /* synthetic */ EntityAction[] $VALUES;
    
    public static EntityAction[] values() {
        return EntityAction.$VALUES.clone();
    }
    
    public static EntityAction valueOf(final String name) {
        return Enum.valueOf(EntityAction.class, name);
    }
    
    static {
        $VALUES = new EntityAction[] { EntityAction.STOP };
    }
}
