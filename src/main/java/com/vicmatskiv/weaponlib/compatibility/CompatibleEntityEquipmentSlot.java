package com.vicmatskiv.weaponlib.compatibility;

public enum CompatibleEntityEquipmentSlot
{
    HEAD(0), 
    CHEST(1), 
    FEET(3);
    
    private int slot;
    private static final /* synthetic */ CompatibleEntityEquipmentSlot[] $VALUES;
    
    public static CompatibleEntityEquipmentSlot[] values() {
        return CompatibleEntityEquipmentSlot.$VALUES.clone();
    }
    
    public static CompatibleEntityEquipmentSlot valueOf(final String name) {
        return Enum.valueOf(CompatibleEntityEquipmentSlot.class, name);
    }
    
    private CompatibleEntityEquipmentSlot(final int slot) {
        this.slot = slot;
    }
    
    public int getSlot() {
        return this.slot;
    }
    
    static {
        $VALUES = new CompatibleEntityEquipmentSlot[] { CompatibleEntityEquipmentSlot.HEAD, CompatibleEntityEquipmentSlot.CHEST, CompatibleEntityEquipmentSlot.FEET };
    }
}
