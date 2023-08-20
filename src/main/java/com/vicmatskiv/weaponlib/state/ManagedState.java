package com.vicmatskiv.weaponlib.state;

import com.vicmatskiv.weaponlib.network.*;

public interface ManagedState<T extends ManagedState<T>> extends UniversallySerializable
{
    default T preparingPhase() {
        return null;
    }
    
    default T permitRequestedPhase() {
        return null;
    }
    
    default T commitPhase() {
        return null;
    }
    
    default boolean isTransient() {
        return false;
    }
    
    int ordinal();
    
    default boolean matches(final T mainState) {
        return mainState == this || mainState == this.preparingPhase() || mainState == this.permitRequestedPhase();
    }
}
