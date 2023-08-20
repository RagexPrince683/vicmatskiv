package com.vicmatskiv.weaponlib.compatibility;

import net.minecraftforge.client.*;

public enum CompatibleTransformType
{
    NONE, 
    THIRD_PERSON_LEFT_HAND, 
    THIRD_PERSON_RIGHT_HAND, 
    FIRST_PERSON_LEFT_HAND, 
    FIRST_PERSON_RIGHT_HAND, 
    HEAD, 
    GUI, 
    GROUND, 
    FIXED;
    
    private static final /* synthetic */ CompatibleTransformType[] $VALUES;
    
    public static CompatibleTransformType[] values() {
        return CompatibleTransformType.$VALUES.clone();
    }
    
    public static CompatibleTransformType valueOf(final String name) {
        return Enum.valueOf(CompatibleTransformType.class, name);
    }
    
    public static CompatibleTransformType fromItemRenderType(final IItemRenderer.ItemRenderType itemRenderType) {
        CompatibleTransformType result = null;
        switch (itemRenderType) {
            case ENTITY: {
                result = CompatibleTransformType.GROUND;
                return result;
            }
            case EQUIPPED: {
                result = CompatibleTransformType.THIRD_PERSON_RIGHT_HAND;
                return result;
            }
            case EQUIPPED_FIRST_PERSON: {
                result = CompatibleTransformType.FIRST_PERSON_RIGHT_HAND;
                return result;
            }
            case INVENTORY: {
                result = CompatibleTransformType.GUI;
                break;
            }
        }
        result = CompatibleTransformType.NONE;
        return result;
    }
    
    static {
        $VALUES = new CompatibleTransformType[] { CompatibleTransformType.NONE, CompatibleTransformType.THIRD_PERSON_LEFT_HAND, CompatibleTransformType.THIRD_PERSON_RIGHT_HAND, CompatibleTransformType.FIRST_PERSON_LEFT_HAND, CompatibleTransformType.FIRST_PERSON_RIGHT_HAND, CompatibleTransformType.HEAD, CompatibleTransformType.GUI, CompatibleTransformType.GROUND, CompatibleTransformType.FIXED };
    }
}
