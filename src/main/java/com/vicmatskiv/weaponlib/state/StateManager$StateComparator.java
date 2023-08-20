package com.vicmatskiv.weaponlib.state;

public interface StateComparator<S extends ManagedState<S>>
{
    boolean compare(final S p0, final S p1);
}
