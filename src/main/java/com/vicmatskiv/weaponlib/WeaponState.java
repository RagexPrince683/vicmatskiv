package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;

public enum WeaponState implements ManagedState<WeaponState>
{
    READY(false), 
    LOAD_REQUESTED, 
    LOAD((WeaponState)null, WeaponState.LOAD_REQUESTED, (WeaponState)null, true), 
    UNLOAD_PREPARING, 
    UNLOAD_REQUESTED, 
    UNLOAD(WeaponState.UNLOAD_PREPARING, WeaponState.UNLOAD_REQUESTED, WeaponState.READY, true), 
    FIRING(9), 
    RECOILED(10), 
    PAUSED(10), 
    EJECT_REQUIRED, 
    EJECTING, 
    MODIFYING_REQUESTED(1), 
    MODIFYING(2, (WeaponState)null, WeaponState.MODIFYING_REQUESTED, (WeaponState)null, false), 
    NEXT_ATTACHMENT_REQUESTED, 
    NEXT_ATTACHMENT(2, (WeaponState)null, WeaponState.NEXT_ATTACHMENT_REQUESTED, (WeaponState)null, false), 
    ALERT;
    
    private static final int DEFAULT_PRIORITY = 0;
    private WeaponState preparingPhase;
    private WeaponState permitRequestedPhase;
    private WeaponState commitPhase;
    private boolean isTransient;
    private int priority;
    private static final /* synthetic */ WeaponState[] $VALUES;
    
    public static WeaponState[] values() {
        return WeaponState.$VALUES.clone();
    }
    
    public static WeaponState valueOf(final String name) {
        return Enum.valueOf(WeaponState.class, name);
    }
    
    private WeaponState() {
        this(null, null, null, true);
    }
    
    private WeaponState(final int priority) {
        this(priority, null, null, null, true);
    }
    
    private WeaponState(final boolean isTransient) {
        this(null, null, null, isTransient);
    }
    
    private WeaponState(final WeaponState preparingPhase, final WeaponState permitRequestedState, final WeaponState transactionFinalState, final boolean isTransient) {
        this(0, preparingPhase, permitRequestedState, transactionFinalState, isTransient);
    }
    
    private WeaponState(final int priority, final WeaponState preparingPhase, final WeaponState permitRequestedState, final WeaponState transactionFinalState, final boolean isTransient) {
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
    public WeaponState preparingPhase() {
        return this.preparingPhase;
    }
    
    @Override
    public WeaponState permitRequestedPhase() {
        return this.permitRequestedPhase;
    }
    
    @Override
    public WeaponState commitPhase() {
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
        $VALUES = new WeaponState[] { WeaponState.READY, WeaponState.LOAD_REQUESTED, WeaponState.LOAD, WeaponState.UNLOAD_PREPARING, WeaponState.UNLOAD_REQUESTED, WeaponState.UNLOAD, WeaponState.FIRING, WeaponState.RECOILED, WeaponState.PAUSED, WeaponState.EJECT_REQUIRED, WeaponState.EJECTING, WeaponState.MODIFYING_REQUESTED, WeaponState.MODIFYING, WeaponState.NEXT_ATTACHMENT_REQUESTED, WeaponState.NEXT_ATTACHMENT, WeaponState.ALERT };
        TypeRegistry.getInstance().register(WeaponState.class);
    }
}
