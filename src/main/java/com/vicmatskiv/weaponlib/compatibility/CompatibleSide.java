package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.relauncher.*;

public enum CompatibleSide
{
    CLIENT(Side.CLIENT), 
    SERVER(Side.SERVER);
    
    private Side side;
    private static final /* synthetic */ CompatibleSide[] $VALUES;
    
    public static CompatibleSide[] values() {
        return CompatibleSide.$VALUES.clone();
    }
    
    public static CompatibleSide valueOf(final String name) {
        return Enum.valueOf(CompatibleSide.class, name);
    }
    
    private CompatibleSide(final Side side) {
        this.side = side;
    }
    
    public static CompatibleSide fromSide(final Side side) {
        if (side == Side.SERVER) {
            return CompatibleSide.SERVER;
        }
        return CompatibleSide.CLIENT;
    }
    
    public Side getSide() {
        return this.side;
    }
    
    static {
        $VALUES = new CompatibleSide[] { CompatibleSide.CLIENT, CompatibleSide.SERVER };
    }
}
