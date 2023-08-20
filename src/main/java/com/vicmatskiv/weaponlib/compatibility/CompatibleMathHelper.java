package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.util.*;

public class CompatibleMathHelper
{
    public CompatibleMathHelper() {
        super();
    }
    
    public static float cos(final float in) {
        return MathHelper.cos(in);
    }
    
    public static float sin(final float in) {
        return MathHelper.sin(in);
    }
    
    public static float sqrt_float(final float in) {
        return MathHelper.sqrt_float(in);
    }
    
    public static float sqrt_double(final double in) {
        return MathHelper.sqrt_double(in);
    }
    
    public static int floor_double(final double d) {
        return MathHelper.floor_double(d);
    }
}
