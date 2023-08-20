package com.vicmatskiv.weaponlib.state;

public interface VoidAction<S extends ManagedState<S>, EE>
{
    void execute(final EE p0, final S p1, final S p2);
}
