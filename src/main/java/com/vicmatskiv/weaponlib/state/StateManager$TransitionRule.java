package com.vicmatskiv.weaponlib.state;

import java.util.function.*;
import java.util.*;

private static class TransitionRule<S extends ManagedState<S>, E extends ExtendedState<S>>
{
    S fromState;
    S toState;
    BiPredicate<S, E> predicate;
    PostAction<S, E> action;
    boolean auto;
    
    TransitionRule(final S fromState, final S toState, final BiPredicate<S, E> predicate, final PostAction<S, E> action, final boolean auto) {
        super();
        if (fromState == null) {
            throw new IllegalArgumentException("From-state cannot be null");
        }
        if (toState == null) {
            throw new IllegalArgumentException("To-state cannot be null");
        }
        this.fromState = fromState;
        this.toState = toState;
        this.predicate = predicate;
        this.action = action;
        this.auto = auto;
    }
    
    boolean matches(final StateComparator<S> stateComparator, final E context, final S fromState, final S... targetStates) {
        boolean result = fromState == null || stateComparator.compare(this.fromState, fromState);
        result = (result && ((this.auto && targetStates.length == 0) || Arrays.stream(targetStates).anyMatch(targetState -> stateComparator2.compare(this.toState, targetState) || stateComparator2.compare(this.toState, targetState.preparingPhase()) || stateComparator2.compare(this.toState, targetState.permitRequestedPhase()))));
        result = (result && this.predicate.test(this.toState, context));
        return result;
    }
    
    private /* synthetic */ boolean lambda$matches$225(final StateComparator stateComparator, final ManagedState targetState) {
        return stateComparator.compare(this.toState, targetState) || stateComparator.compare(this.toState, targetState.preparingPhase()) || stateComparator.compare(this.toState, targetState.permitRequestedPhase());
    }
}
