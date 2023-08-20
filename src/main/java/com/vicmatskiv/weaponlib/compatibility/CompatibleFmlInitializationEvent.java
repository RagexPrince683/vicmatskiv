package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.event.*;

public class CompatibleFmlInitializationEvent
{
    private FMLPreInitializationEvent event;
    
    public CompatibleFmlInitializationEvent(final FMLPreInitializationEvent event) {
        super();
        this.event = event;
    }
    
    public FMLPreInitializationEvent getEvent() {
        return this.event;
    }
}
