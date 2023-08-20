package com.vicmatskiv.weaponlib.melee;

import com.vicmatskiv.weaponlib.state.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;

public enum MeleeState implements ManagedState<MeleeState>
{
    READY(false), 
    ATTACKING(9), 
    ATTACKING_STABBING(9), 
    HEAVY_ATTACKING(9), 
    HEAVY_ATTACKING_STABBING(9), 
    MODIFYING_REQUESTED(1), 
    MODIFYING(2, (MeleeState)null, MeleeState.MODIFYING_REQUESTED, (MeleeState)null, false), 
    NEXT_ATTACHMENT_REQUESTED, 
    NEXT_ATTACHMENT(2, (MeleeState)null, MeleeState.NEXT_ATTACHMENT_REQUESTED, (MeleeState)null, false), 
    ALERT;
    
    private static final int DEFAULT_PRIORITY = 0;
    private MeleeState preparingPhase;
    private MeleeState permitRequestedPhase;
    private MeleeState commitPhase;
    private boolean isTransient;
    private int priority;
    private static final /* synthetic */ MeleeState[] $VALUES;
    
    public static MeleeState[] values() {
        return MeleeState.$VALUES.clone();
    }
    
    public static MeleeState valueOf(final String name) {
        return Enum.valueOf(MeleeState.class, name);
    }
    
    private MeleeState() {
        this(null, null, null, true);
    }
    
    private MeleeState(final int priority) {
        this(priority, null, null, null, true);
    }
    
    private MeleeState(final boolean isTransient) {
        this(null, null, null, isTransient);
    }
    
    private MeleeState(final MeleeState preparingPhase, final MeleeState permitRequestedState, final MeleeState transactionFinalState, final boolean isTransient) {
        this(0, preparingPhase, permitRequestedState, transactionFinalState, isTransient);
    }
    
    private MeleeState(final int priority, final MeleeState preparingPhase, final MeleeState permitRequestedState, final MeleeState transactionFinalState, final boolean isTransient) {
        this.priority = 0;
        this.priority = priority;
        this.preparingPhase = preparingPhase;
        this.permitRequestedPhase = permitRequestedState;
        this.commitPhase = transactionFinalState;
        this.isTransient = false;
    }
    
    @Override
    public boolean isTransient() {
        return this.isTransient;
    }
    
    @Override
    public MeleeState preparingPhase() {
        return this.preparingPhase;
    }
    
    @Override
    public MeleeState permitRequestedPhase() {
        return this.permitRequestedPhase;
    }
    
    @Override
    public MeleeState commitPhase() {
        return this.commitPhase;
    }
    
    public int getPriority() {
        return this.priority;
    }
    
    @Override
    public void init(final ByteBuf buf) {
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
    }
    
    @Override
    public /* bridge */ ManagedState commitPhase() {
        return this.commitPhase();
    }
    
    @Override
    public /* bridge */ ManagedState permitRequestedPhase() {
        return this.permitRequestedPhase();
    }
    
    @Override
    public /* bridge */ ManagedState preparingPhase() {
        return this.preparingPhase();
    }
    
    static {
        $VALUES = new MeleeState[] { MeleeState.READY, MeleeState.ATTACKING, MeleeState.ATTACKING_STABBING, MeleeState.HEAVY_ATTACKING, MeleeState.HEAVY_ATTACKING_STABBING, MeleeState.MODIFYING_REQUESTED, MeleeState.MODIFYING, MeleeState.NEXT_ATTACHMENT_REQUESTED, MeleeState.NEXT_ATTACHMENT, MeleeState.ALERT };
        TypeRegistry.getInstance().register(MeleeState.class);
    }
}
