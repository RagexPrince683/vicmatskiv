package com.vicmatskiv.weaponlib.state;

public interface ExtendedState<T extends ManagedState<T>>
{
    boolean setState(final T p0);
    
    T getState();
    
    long getStateUpdateTimestamp();
    
     <E extends ExtendedState<T>> void prepareTransaction(final E p0);
}
