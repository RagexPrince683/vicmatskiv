package com.vicmatskiv.weaponlib.state;

public interface Aspect<T extends ManagedState<T>, E extends ExtendedState<T>>
{
    void setStateManager(final StateManager<T, ? super E> p0);
    
    void setPermitManager(final PermitManager p0);
}
