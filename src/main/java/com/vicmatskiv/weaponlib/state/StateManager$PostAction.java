package com.vicmatskiv.weaponlib.state;

public interface PostAction<S extends ManagedState<S>, EE>
{
    Object execute(final EE p0, final S p1, final S p2, final Permit<S> p3);
}
