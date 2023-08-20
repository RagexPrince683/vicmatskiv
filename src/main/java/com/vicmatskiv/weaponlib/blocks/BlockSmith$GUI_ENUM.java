package com.vicmatskiv.weaponlib.blocks;

public enum GUI_ENUM
{
    GRINDER, 
    COMPACTOR, 
    DECONSTRUCTOR, 
    TANNING_RACK, 
    FORGE;
    
    private static final /* synthetic */ GUI_ENUM[] $VALUES;
    
    public static GUI_ENUM[] values() {
        return GUI_ENUM.$VALUES.clone();
    }
    
    public static GUI_ENUM valueOf(final String name) {
        return Enum.valueOf(GUI_ENUM.class, name);
    }
    
    static {
        $VALUES = new GUI_ENUM[] { GUI_ENUM.GRINDER, GUI_ENUM.COMPACTOR, GUI_ENUM.DECONSTRUCTOR, GUI_ENUM.TANNING_RACK, GUI_ENUM.FORGE };
    }
}
