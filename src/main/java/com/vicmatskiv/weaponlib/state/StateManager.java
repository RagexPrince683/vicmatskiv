package com.vicmatskiv.weaponlib.state;

import java.util.*;
import java.util.stream.*;
import org.apache.logging.log4j.*;
import java.util.function.*;

public class StateManager<S extends ManagedState<S>, E extends ExtendedState<S>>
{
    private static final Logger logger;
    private StateComparator<S> stateComparator;
    private Map<Aspect<S, ? extends E>, LinkedHashSet<TransitionRule<S, E>>> contextRules;
    
    private static <T, U> T safeCast(final U u) {
        return (T)u;
    }
    
    public StateManager(final StateComparator<S> stateComparator) {
        super();
        this.contextRules = new HashMap<Aspect<S, ? extends E>, LinkedHashSet<TransitionRule<S, E>>>();
        this.stateComparator = stateComparator;
    }
    
    public <EE extends E> RuleBuilder<EE> in(final Aspect<S, EE> aspect) {
        return new RuleBuilder<EE>(aspect);
    }
    
    public Result changeState(final Aspect<S, ? extends E> aspect, final E extendedState, final S... targetStates) {
        return this.changeState(aspect, extendedState, (Permit<S>)null, targetStates);
    }
    
    public Result changeState(final Aspect<S, ? extends E> aspect, final E extendedState, final Permit<S> permit, final S... targetStates) {
        final S currentState = extendedState.getState();
        return this.changeStateFromTo(aspect, extendedState, permit, currentState, targetStates);
    }
    
    public Result changeStateFromAnyOf(final Aspect<S, ? extends E> aspect, final E extendedState, final Collection<S> fromStates, final S... targetStates) {
        final S currentState = extendedState.getState();
        if (!fromStates.contains(currentState)) {
            return new Result(this, false, (ManagedState)currentState);
        }
        return this.changeStateFromTo(aspect, extendedState, currentState, targetStates);
    }
    
    protected Result changeStateFromTo(final Aspect<S, ? extends E> aspect, final E extendedState, final S currentState, final S... targetStates) {
        return this.changeStateFromTo(aspect, extendedState, null, currentState, targetStates);
    }
    
    protected Result changeStateFromTo(final Aspect<S, ? extends E> aspect, final E extendedState, final Permit<S> permit, final S currentState, final S... targetStates) {
        if (extendedState == null) {
            return null;
        }
        if (targetStates.length == 1 && Arrays.stream(targetStates).anyMatch(target -> this.stateComparator.compare((S)managedState, (S)target))) {
            return new Result(this, false, (ManagedState)currentState);
        }
        Result result = null;
        S s = currentState;
        TransitionRule<S, E> newStateRule;
        for (S[] ts = targetStates; (newStateRule = this.findNextStateRule(aspect, extendedState, s, ts)) != null; s = newStateRule.toState, ts = safeCast(new ManagedState[0])) {
            extendedState.setState(newStateRule.toState);
            StateManager.logger.debug("Changed state of {} to {}", new Object[] { extendedState, newStateRule.toState });
            result = new Result(this, true, (ManagedState)newStateRule.toState);
            if (newStateRule.action != null) {
                result.actionResult = newStateRule.action.execute(extendedState, s, newStateRule.toState, permit);
            }
        }
        if (result == null) {
            result = new Result(this, false, (ManagedState)s);
        }
        return result;
    }
    
    private TransitionRule<S, E> findNextStateRule(final Aspect<S, ? extends E> aspect, final E extendedState, final S currentState, final S... targetStates) {
        return this.contextRules.entrySet().stream().filter(e -> e.getKey() == aspect2).map(e -> e.getValue()).flatMap((Function<? super Object, ? extends Stream<? extends TransitionRule<S, E>>>)Collection::stream).filter(rule -> rule.matches(this.stateComparator, context, fromState, (ManagedState<S>[])targetStates2)).findFirst().orElse(null);
    }
    
    private /* synthetic */ boolean lambda$findNextStateRule$229(final ExtendedState context, final ManagedState fromState, final ManagedState[] targetStates, final TransitionRule rule) {
        return rule.matches(this.stateComparator, context, fromState, (ManagedState<S>[])targetStates);
    }
    
    private static /* synthetic */ LinkedHashSet lambda$findNextStateRule$228(final Map.Entry e) {
        return e.getValue();
    }
    
    private static /* synthetic */ boolean lambda$findNextStateRule$227(final Aspect aspect, final Map.Entry e) {
        return e.getKey() == aspect;
    }
    
    private /* synthetic */ boolean lambda$changeStateFromTo$226(final ManagedState managedState, final ManagedState target) {
        return this.stateComparator.compare((S)managedState, (S)target);
    }
    
    static /* synthetic */ Map access$000(final StateManager x0) {
        return x0.contextRules;
    }
    
    static /* synthetic */ Logger access$100() {
        return StateManager.logger;
    }
    
    static /* synthetic */ Object access$200(final Object x0) {
        return safeCast(x0);
    }
    
    static {
        logger = LogManager.getLogger((Class)StateManager.class);
    }
    
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
            final LinkedHashSet<TransitionRule<S, E>> aspectRules = this.this$0.contextRules.computeIfAbsent(this.aspect, c -> new LinkedHashSet());
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
                final TransitionRule<S, E> prepareRule = new TransitionRule<S, E>(this.fromState, this.toState.preparingPhase(), (s, e) -> this.predicate.test((S)s, (EE)safeCast(e)), (c, f, t, p) -> {
                    if (this.prepareAction != null) {
                        this.prepareAction.execute((EE)safeCast(c), (S)f, (S)t);
                    }
                    return null;
                }, false);
                aspectRules.add(prepareRule);
                effectiveFromState = this.toState.preparingPhase();
                effectivePredicate = ((s, e) -> this.preparePredicate == null || this.preparePredicate.test((EE)safeCast(e)));
                isRequestRuleAutoTransitioned = true;
            }
            else {
                effectiveFromState = this.fromState;
                effectivePredicate = ((s, e) -> this.predicate.test((S)s, (EE)safeCast(e)));
                isRequestRuleAutoTransitioned = false;
            }
            if (this.isPermitRequired) {
                if (auto) {
                    throw new IllegalStateException("Permitted transitions cannot be automatic");
                }
                final TransitionRule<S, E> requestPermitRule = new TransitionRule<S, E>(effectiveFromState, this.toState.permitRequestedPhase(), effectivePredicate, (s, f, t, p) -> {
                    this.permitManager.request((p != null) ? p : this.permitProvider.apply((S)t, (EE)safeCast(s)), s, this::applyPermit);
                    return null;
                }, isRequestRuleAutoTransitioned);
                aspectRules.add(requestPermitRule);
                final TransitionRule<S, E> rollbackRule = new TransitionRule<S, E>(this.toState.permitRequestedPhase(), this.fromState, (s, c) -> System.currentTimeMillis() > c.getStateUpdateTimestamp() + this.requestTimeout, (c, f, t, p) -> this.action.execute((EE)safeCast(c), (S)f, (S)t, p), true);
                aspectRules.add(rollbackRule);
            }
            else {
                final TransitionRule<S, E> directTransitionRule = new TransitionRule<S, E>(effectiveFromState, this.toState, effectivePredicate, (c, f, t, p) -> this.action.execute((EE)safeCast(c), (S)f, (S)t, p), auto);
                aspectRules.add(directTransitionRule);
            }
            return this.this$0;
        }
        
        private void applyPermit(final Permit<S> processedPermit, final E updatedState) {
            final S updateToState = (processedPermit.getStatus() == Permit.Status.GRANTED) ? this.toState : this.fromState;
            StateManager.logger.debug("Applying permit with status {} to {}, changing state to {}", new Object[] { processedPermit.getStatus(), updatedState, this.toState });
            if (this.stateUpdater.apply(updateToState, (EE)safeCast(updatedState))) {
                this.action.execute((EE)safeCast(updatedState), this.fromState, this.toState, processedPermit);
            }
        }
        
        private /* synthetic */ Object lambda$addRule$224(final ExtendedState c, final ManagedState f, final ManagedState t, final Permit p) {
            return this.action.execute((EE)safeCast(c), (S)f, (S)t, p);
        }
        
        private /* synthetic */ Object lambda$addRule$223(final ExtendedState c, final ManagedState f, final ManagedState t, final Permit p) {
            return this.action.execute((EE)safeCast(c), (S)f, (S)t, p);
        }
        
        private /* synthetic */ boolean lambda$addRule$222(final ManagedState s, final ExtendedState c) {
            return System.currentTimeMillis() > c.getStateUpdateTimestamp() + this.requestTimeout;
        }
        
        private /* synthetic */ Object lambda$addRule$221(final ExtendedState s, final ManagedState f, final ManagedState t, final Permit p) {
            this.permitManager.request((p != null) ? p : this.permitProvider.apply((S)t, (EE)safeCast(s)), s, this::applyPermit);
            return null;
        }
        
        private /* synthetic */ boolean lambda$addRule$220(final ManagedState s, final ExtendedState e) {
            return this.predicate.test((S)s, (EE)safeCast(e));
        }
        
        private /* synthetic */ boolean lambda$addRule$219(final ManagedState s, final ExtendedState e) {
            return this.preparePredicate == null || this.preparePredicate.test((EE)safeCast(e));
        }
        
        private /* synthetic */ Object lambda$addRule$218(final ExtendedState c, final ManagedState f, final ManagedState t, final Permit p) {
            if (this.prepareAction != null) {
                this.prepareAction.execute((EE)safeCast(c), (S)f, (S)t);
            }
            return null;
        }
        
        private /* synthetic */ boolean lambda$addRule$217(final ManagedState s, final ExtendedState e) {
            return this.predicate.test((S)s, (EE)safeCast(e));
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
    
    public class Result
    {
        private boolean stateChanged;
        private S state;
        protected Object actionResult;
        final /* synthetic */ StateManager this$0;
        
        private Result(final StateManager this$0, final boolean stateChanged, final S targetState) {
            this.this$0 = this$0;
            super();
            this.stateChanged = stateChanged;
            this.state = targetState;
        }
        
        public boolean isStateChanged() {
            return this.stateChanged;
        }
        
        public S getState() {
            return this.state;
        }
        
        public Object getActionResult() {
            return this.actionResult;
        }
        
        Result(final StateManager x0, final boolean x1, final ManagedState x2, final StateManager$1 x3) {
            this(x1, (S)x2);
        }
    }
    
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
    
    public interface PostAction<S extends ManagedState<S>, EE>
    {
        Object execute(final EE p0, final S p1, final S p2, final Permit<S> p3);
    }
    
    public interface StateComparator<S extends ManagedState<S>>
    {
        boolean compare(final S p0, final S p1);
    }
    
    public interface VoidAction2<EE>
    {
        void execute(final EE p0);
    }
    
    public interface VoidAction<S extends ManagedState<S>, EE>
    {
        void execute(final EE p0, final S p1, final S p2);
    }
    
    public interface VoidPostAction<S extends ManagedState<S>, EE>
    {
        void execute(final EE p0, final S p1, final S p2, final Permit<S> p3);
    }
}
