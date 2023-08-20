package com.vicmatskiv.weaponlib.state;

import java.util.function.*;
import java.util.*;

public class RuleBuilder<EE extends E>
{
    private static final long DEFAULT_REQUEST_TIMEOUT = 10000L;
    private Aspect<S, EE> aspect;
    private S fromState;
    private S toState;
    private VoidAction<S, EE> prepareAction;
    private PostAction<S, EE> action;
    private BiPredicate<S, EE> predicate;
    private BiFunction<S, EE, Permit<S>> permitProvider;
    private BiFunction<S, EE, Boolean> stateUpdater;
    private PermitManager permitManager;
    private Predicate<EE> preparePredicate;
    private long requestTimeout;
    private boolean isPermitRequired;
    final /* synthetic */ StateManager this$0;
    
    public RuleBuilder(final StateManager this$0, final Aspect<S, EE> aspect) {
        this.this$0 = this$0;
        super();
        this.requestTimeout = 10000L;
        this.aspect = aspect;
    }
    
    public RuleBuilder<EE> prepare(final VoidAction<S, EE> prepareAction, final Predicate<EE> preparePredicate) {
        this.prepareAction = prepareAction;
        this.preparePredicate = preparePredicate;
        return this;
    }
    
    public RuleBuilder<EE> change(final S fromState) {
        this.fromState = fromState;
        return this;
    }
    
    public RuleBuilder<EE> to(final S state) {
        this.toState = state;
        return this;
    }
    
    public RuleBuilder<EE> when(final Predicate<EE> predicate) {
        this.predicate = ((s, e) -> predicate2.test(e));
        return this;
    }
    
    public RuleBuilder<EE> when(final BiPredicate<S, EE> predicate) {
        this.predicate = predicate;
        return this;
    }
    
    public RuleBuilder<EE> withPermit(final BiFunction<S, EE, Permit<S>> permitProvider, final BiFunction<S, EE, Boolean> stateUpdater, final PermitManager permitManager) {
        this.isPermitRequired = true;
        this.permitProvider = permitProvider;
        this.stateUpdater = stateUpdater;
        this.permitManager = permitManager;
        return this;
    }
    
    public RuleBuilder<EE> withAction(final VoidPostAction<S, EE> action) {
        this.action = ((context, from, to, permit) -> {
            voidPostAction.execute(context, from, to, permit);
            return null;
        });
        return this;
    }
    
    public RuleBuilder<EE> withAction(final VoidAction2<EE> action) {
        this.action = ((context, from, to, permit) -> {
            voidAction2.execute(context);
            return null;
        });
        return this;
    }
    
    public StateManager<S, E> automatic() {
        return this.addRule(true);
    }
    
    public StateManager<S, E> manual() {
        return this.addRule(false);
    }
    
    private StateManager<S, E> addRule(final boolean auto) {
        final LinkedHashSet<TransitionRule<S, E>> aspectRules = StateManager.access$000(this.this$0).computeIfAbsent(this.aspect, c -> new LinkedHashSet());
        if (this.predicate == null) {
            this.predicate = ((s, c) -> true);
        }
        if (this.action == null) {
            this.action = ((c, f, t, p) -> null);
        }
        S effectiveFromState;
        BiPredicate<S, E> effectivePredicate;
        boolean isRequestRuleAutoTransitioned;
        if (this.prepareAction != null || this.preparePredicate != null) {
            if (auto) {
                throw new IllegalStateException("Prepared transition cannot be automatic");
            }
            final TransitionRule<S, E> prepareRule = new TransitionRule<S, E>(this.fromState, this.toState.preparingPhase(), (s, e) -> this.predicate.test((S)s, (EE)StateManager.access$200(e)), (c, f, t, p) -> {
                if (this.prepareAction != null) {
                    this.prepareAction.execute((EE)StateManager.access$200(c), (S)f, (S)t);
                }
                return null;
            }, false);
            aspectRules.add(prepareRule);
            effectiveFromState = this.toState.preparingPhase();
            effectivePredicate = ((s, e) -> this.preparePredicate == null || this.preparePredicate.test((EE)StateManager.access$200(e)));
            isRequestRuleAutoTransitioned = true;
        }
        else {
            effectiveFromState = this.fromState;
            effectivePredicate = ((s, e) -> this.predicate.test((S)s, (EE)StateManager.access$200(e)));
            isRequestRuleAutoTransitioned = false;
        }
        if (this.isPermitRequired) {
            if (auto) {
                throw new IllegalStateException("Permitted transitions cannot be automatic");
            }
            final TransitionRule<S, E> requestPermitRule = new TransitionRule<S, E>(effectiveFromState, this.toState.permitRequestedPhase(), effectivePredicate, (s, f, t, p) -> {
                this.permitManager.request((p != null) ? p : this.permitProvider.apply((S)t, (EE)StateManager.access$200(s)), s, this::applyPermit);
                return null;
            }, isRequestRuleAutoTransitioned);
            aspectRules.add(requestPermitRule);
            final TransitionRule<S, E> rollbackRule = new TransitionRule<S, E>(this.toState.permitRequestedPhase(), this.fromState, (s, c) -> System.currentTimeMillis() > c.getStateUpdateTimestamp() + this.requestTimeout, (c, f, t, p) -> this.action.execute((EE)StateManager.access$200(c), (S)f, (S)t, p), true);
            aspectRules.add(rollbackRule);
        }
        else {
            final TransitionRule<S, E> directTransitionRule = new TransitionRule<S, E>(effectiveFromState, this.toState, effectivePredicate, (c, f, t, p) -> this.action.execute((EE)StateManager.access$200(c), (S)f, (S)t, p), auto);
            aspectRules.add(directTransitionRule);
        }
        return this.this$0;
    }
    
    private void applyPermit(final Permit<S> processedPermit, final E updatedState) {
        final S updateToState = (processedPermit.getStatus() == Permit.Status.GRANTED) ? this.toState : this.fromState;
        StateManager.access$100().debug("Applying permit with status {} to {}, changing state to {}", new Object[] { processedPermit.getStatus(), updatedState, this.toState });
        if (this.stateUpdater.apply(updateToState, (EE)StateManager.access$200(updatedState))) {
            this.action.execute((EE)StateManager.access$200(updatedState), this.fromState, this.toState, processedPermit);
        }
    }
    
    private /* synthetic */ Object lambda$addRule$224(final ExtendedState c, final ManagedState f, final ManagedState t, final Permit p) {
        return this.action.execute((EE)StateManager.access$200(c), (S)f, (S)t, p);
    }
    
    private /* synthetic */ Object lambda$addRule$223(final ExtendedState c, final ManagedState f, final ManagedState t, final Permit p) {
        return this.action.execute((EE)StateManager.access$200(c), (S)f, (S)t, p);
    }
    
    private /* synthetic */ boolean lambda$addRule$222(final ManagedState s, final ExtendedState c) {
        return System.currentTimeMillis() > c.getStateUpdateTimestamp() + this.requestTimeout;
    }
    
    private /* synthetic */ Object lambda$addRule$221(final ExtendedState s, final ManagedState f, final ManagedState t, final Permit p) {
        this.permitManager.request((p != null) ? p : this.permitProvider.apply((S)t, (EE)StateManager.access$200(s)), s, this::applyPermit);
        return null;
    }
    
    private /* synthetic */ boolean lambda$addRule$220(final ManagedState s, final ExtendedState e) {
        return this.predicate.test((S)s, (EE)StateManager.access$200(e));
    }
    
    private /* synthetic */ boolean lambda$addRule$219(final ManagedState s, final ExtendedState e) {
        return this.preparePredicate == null || this.preparePredicate.test((EE)StateManager.access$200(e));
    }
    
    private /* synthetic */ Object lambda$addRule$218(final ExtendedState c, final ManagedState f, final ManagedState t, final Permit p) {
        if (this.prepareAction != null) {
            this.prepareAction.execute((EE)StateManager.access$200(c), (S)f, (S)t);
        }
        return null;
    }
    
    private /* synthetic */ boolean lambda$addRule$217(final ManagedState s, final ExtendedState e) {
        return this.predicate.test((S)s, (EE)StateManager.access$200(e));
    }
    
    private static /* synthetic */ Object lambda$addRule$216(final ExtendedState c, final ManagedState f, final ManagedState t, final Permit p) {
        return null;
    }
    
    private static /* synthetic */ boolean lambda$addRule$215(final ManagedState s, final ExtendedState c) {
        return true;
    }
    
    private static /* synthetic */ LinkedHashSet lambda$addRule$214(final Aspect c) {
        return new LinkedHashSet();
    }
    
    private static /* synthetic */ Object lambda$withAction$213(final VoidAction2 voidAction2, final ExtendedState context, final ManagedState from, final ManagedState to, final Permit permit) {
        voidAction2.execute(context);
        return null;
    }
    
    private static /* synthetic */ Object lambda$withAction$212(final VoidPostAction voidPostAction, final ExtendedState context, final ManagedState from, final ManagedState to, final Permit permit) {
        voidPostAction.execute(context, from, to, permit);
        return null;
    }
    
    private static /* synthetic */ boolean lambda$when$211(final Predicate predicate, final ManagedState s, final ExtendedState e) {
        return predicate.test(e);
    }
}
