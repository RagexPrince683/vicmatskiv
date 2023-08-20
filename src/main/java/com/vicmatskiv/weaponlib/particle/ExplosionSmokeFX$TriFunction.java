package com.vicmatskiv.weaponlib.particle;

public interface TriFunction<T, U, V, R>
{
    R apply(final T p0, final U p1, final V p2);
}
