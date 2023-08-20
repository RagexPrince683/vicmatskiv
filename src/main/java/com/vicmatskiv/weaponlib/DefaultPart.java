package com.vicmatskiv.weaponlib;

public final class DefaultPart implements Part
{
    private String name;
    
    public DefaultPart(final String name) {
        super();
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "[" + this.name + "]";
    }
}
