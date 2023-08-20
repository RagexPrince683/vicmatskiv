package com.vicmatskiv.weaponlib.crafting;

public enum CraftingComplexity
{
    LOW, 
    MEDIUM, 
    HIGH;
    
    private static final /* synthetic */ CraftingComplexity[] $VALUES;
    
    public static CraftingComplexity[] values() {
        return CraftingComplexity.$VALUES.clone();
    }
    
    public static CraftingComplexity valueOf(final String name) {
        return Enum.valueOf(CraftingComplexity.class, name);
    }
    
    static {
        $VALUES = new CraftingComplexity[] { CraftingComplexity.LOW, CraftingComplexity.MEDIUM, CraftingComplexity.HIGH };
    }
}
