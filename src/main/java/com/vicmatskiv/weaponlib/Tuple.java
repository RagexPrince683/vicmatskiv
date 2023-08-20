package com.vicmatskiv.weaponlib;

public final class Tuple<U, V>
{
    private U u;
    private V v;
    
    public Tuple(final U u, final V v) {
        super();
        this.u = u;
        this.v = v;
    }
    
    public U getU() {
        return this.u;
    }
    
    public void setU(final U u) {
        this.u = u;
    }
    
    public V getV() {
        return this.v;
    }
    
    public void setV(final V v) {
        this.v = v;
    }
}
