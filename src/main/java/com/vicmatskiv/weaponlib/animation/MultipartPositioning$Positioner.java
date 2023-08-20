package com.vicmatskiv.weaponlib.animation;

public interface Positioner<Part, Context>
{
    void position(final Part p0, final Context p1);
    
    default void randomize(final float rate, final float amplitude) {
    }
}
