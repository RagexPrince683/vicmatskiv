package com.vicmatskiv.weaponlib.state;

import java.util.function.*;

public interface PermitManager
{
     <S extends ManagedState<S>, P extends Permit<S>, E extends ExtendedState<S>> void request(final P p0, final E p1, final BiConsumer<P, E> p2);
    
     <S extends ManagedState<S>, P extends Permit<S>, E extends ExtendedState<S>> void registerEvaluator(final Class<? extends P> p0, final Class<? extends E> p1, final BiConsumer<P, E> p2);
}
