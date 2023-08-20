package com.vicmatskiv.weaponlib.electronics;

import com.vicmatskiv.weaponlib.state.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;

public enum TabletState implements ManagedState<TabletState>
{
    READY(false), 
    MODIFYING_REQUESTED(1), 
    MODIFYING(2, (TabletState)null, TabletState.MODIFYING_REQUESTED, (TabletState)null, false), 
    NEXT_ATTACHMENT_REQUESTED, 
    NEXT_ATTACHMENT(2, (TabletState)null, TabletState.NEXT_ATTACHMENT_REQUESTED, (TabletState)null, false), 
    ALERT;
    
    private static final int DEFAULT_PRIORITY = 0;
    private TabletState preparingPhase;
    private TabletState permitRequestedPhase;
    private TabletState commitPhase;
    private boolean isTransient;
    private int priority;
    private static final /* synthetic */ TabletState[] $VALUES;
    
    public static TabletState[] values() {
        return TabletState.$VALUES.clone();
    }
    
    public static TabletState valueOf(final String name) {
        return Enum.valueOf(TabletState.class, name);
    }
    
    private TabletState() {
        this(null, null, null, true);
    }
    
    private TabletState(final int priority) {
        this(priority, null, null, null, true);
    }
    
    private TabletState(final boolean isTransient) {
        this(null, null, null, isTransient);
    }
    
    private TabletState(final TabletState preparingPhase, final TabletState permitRequestedState, final TabletState transactionFinalState, final boolean isTransient) {
        this(0, preparingPhase, permitRequestedState, transactionFinalState, isTransient);
    }
    
    private TabletState(final int priority, final TabletState preparingPhase, final TabletState permitRequestedState, final TabletState transactionFinalState, final boolean isTransient) {
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
    public TabletState preparingPhase() {
        return this.preparingPhase;
    }
    
    @Override
    public TabletState permitRequestedPhase() {
        return this.permitRequestedPhase;
    }
    
    @Override
    public TabletState commitPhase() {
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
        $VALUES = new TabletState[] { TabletState.READY, TabletState.MODIFYING_REQUESTED, TabletState.MODIFYING, TabletState.NEXT_ATTACHMENT_REQUESTED, TabletState.NEXT_ATTACHMENT, TabletState.ALERT };
        TypeRegistry.getInstance().register(TabletState.class);
    }
}
