package com.vicmatskiv.weaponlib.grenade;

import com.vicmatskiv.weaponlib.state.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;

public enum GrenadeState implements ManagedState<GrenadeState>
{
    READY(false), 
    SAFETY_PING_OFF(9), 
    STRIKER_LEVER_RELEASED(9), 
    THROWING(9), 
    THROWN(9), 
    EXPLODED_IN_HANDS(9);
    
    private static final int DEFAULT_PRIORITY = 0;
    private GrenadeState preparingPhase;
    private GrenadeState permitRequestedPhase;
    private GrenadeState commitPhase;
    private boolean isTransient;
    private int priority;
    private static final /* synthetic */ GrenadeState[] $VALUES;
    
    public static GrenadeState[] values() {
        return GrenadeState.$VALUES.clone();
    }
    
    public static GrenadeState valueOf(final String name) {
        return Enum.valueOf(GrenadeState.class, name);
    }
    
    private GrenadeState() {
        this(null, null, null, true);
    }
    
    private GrenadeState(final int priority) {
        this(priority, null, null, null, true);
    }
    
    private GrenadeState(final boolean isTransient) {
        this(null, null, null, isTransient);
    }
    
    private GrenadeState(final GrenadeState preparingPhase, final GrenadeState permitRequestedState, final GrenadeState transactionFinalState, final boolean isTransient) {
        this(0, preparingPhase, permitRequestedState, transactionFinalState, isTransient);
    }
    
    private GrenadeState(final int priority, final GrenadeState preparingPhase, final GrenadeState permitRequestedState, final GrenadeState transactionFinalState, final boolean isTransient) {
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
    public GrenadeState preparingPhase() {
        return this.preparingPhase;
    }
    
    @Override
    public GrenadeState permitRequestedPhase() {
        return this.permitRequestedPhase;
    }
    
    @Override
    public GrenadeState commitPhase() {
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
        $VALUES = new GrenadeState[] { GrenadeState.READY, GrenadeState.SAFETY_PING_OFF, GrenadeState.STRIKER_LEVER_RELEASED, GrenadeState.THROWING, GrenadeState.THROWN, GrenadeState.EXPLODED_IN_HANDS };
        TypeRegistry.getInstance().register(GrenadeState.class);
    }
}
