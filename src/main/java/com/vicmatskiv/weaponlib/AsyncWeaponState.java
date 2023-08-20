package com.vicmatskiv.weaponlib;

public class AsyncWeaponState
{
    private WeaponState state;
    private long timestamp;
    private long duration;
    private boolean isInfinite;
    
    public AsyncWeaponState(final WeaponState state, final long timestamp) {
        super();
        this.state = state;
        this.timestamp = timestamp;
        this.duration = 2147483647L;
        this.isInfinite = true;
    }
    
    public AsyncWeaponState(final WeaponState state, final long timestamp, final long duration) {
        super();
        this.state = state;
        this.timestamp = timestamp;
        this.duration = duration;
    }
    
    public WeaponState getState() {
        return this.state;
    }
    
    public long getTimestamp() {
        return this.timestamp;
    }
    
    public long getDuration() {
        return this.duration;
    }
    
    public boolean isInfinite() {
        return this.isInfinite;
    }
}
