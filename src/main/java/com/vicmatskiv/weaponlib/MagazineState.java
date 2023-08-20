package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;

public enum MagazineState implements ManagedState<MagazineState>
{
    READY(false), 
    LOAD_REQUESTED, 
    LOAD((MagazineState)null, MagazineState.LOAD_REQUESTED, (MagazineState)null, true);
    
    private static final int DEFAULT_PRIORITY = 0;
    private MagazineState preparingPhase;
    private MagazineState permitRequestedPhase;
    private MagazineState commitPhase;
    private boolean isTransient;
    private int priority;
    private static final /* synthetic */ MagazineState[] $VALUES;
    
    public static MagazineState[] values() {
        return MagazineState.$VALUES.clone();
    }
    
    public static MagazineState valueOf(final String name) {
        return Enum.valueOf(MagazineState.class, name);
    }
    
    private MagazineState() {
        this(null, null, null, true);
    }
    
    private MagazineState(final int priority) {
        this(priority, null, null, null, true);
    }
    
    private MagazineState(final boolean isTransient) {
        this(null, null, null, isTransient);
    }
    
    private MagazineState(final MagazineState preparingPhase, final MagazineState permitRequestedState, final MagazineState transactionFinalState, final boolean isTransient) {
        this(0, preparingPhase, permitRequestedState, transactionFinalState, isTransient);
    }
    
    private MagazineState(final int priority, final MagazineState preparingPhase, final MagazineState permitRequestedState, final MagazineState transactionFinalState, final boolean isTransient) {
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
    public MagazineState preparingPhase() {
        return this.preparingPhase;
    }
    
    @Override
    public MagazineState permitRequestedPhase() {
        return this.permitRequestedPhase;
    }
    
    @Override
    public MagazineState commitPhase() {
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
        $VALUES = new MagazineState[] { MagazineState.READY, MagazineState.LOAD_REQUESTED, MagazineState.LOAD };
        TypeRegistry.getInstance().register(MagazineState.class);
    }
}
