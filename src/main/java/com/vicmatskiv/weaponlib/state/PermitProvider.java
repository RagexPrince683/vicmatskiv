package com.vicmatskiv.weaponlib.state;

public interface PermitProvider<S extends ManagedState<S>, Context>
{
    void set(final Permit<S> p0, final S p1, final Context p2);
    
    Permit<S> get(final S p0, final Context p1);
}
