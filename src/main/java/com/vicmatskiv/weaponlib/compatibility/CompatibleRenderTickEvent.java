package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.gameevent.*;

public class CompatibleRenderTickEvent
{
    private TickEvent.RenderTickEvent event;
    
    public CompatibleRenderTickEvent(final TickEvent.RenderTickEvent event) {
        super();
        this.event = event;
    }
    
    public Phase getPhase() {
        return (this.event.phase == TickEvent.Phase.START) ? Phase.START : Phase.END;
    }
    
    public float getRenderTickTime() {
        return this.event.renderTickTime;
    }
    
    public enum Phase
    {
        START, 
        END;
        
        private static final /* synthetic */ Phase[] $VALUES;
        
        public static Phase[] values() {
            return Phase.$VALUES.clone();
        }
        
        public static Phase valueOf(final String name) {
            return Enum.valueOf(Phase.class, name);
        }
        
        static {
            $VALUES = new Phase[] { Phase.START, Phase.END };
        }
    }
}
