package com.vicmatskiv.weaponlib.compatibility;

import net.minecraftforge.event.entity.player.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class CompatibleStopTrackingEvent
{
    private PlayerEvent.StopTracking event;
    
    public CompatibleStopTrackingEvent(final PlayerEvent.StopTracking event) {
        super();
        this.event = event;
    }
    
    public EntityPlayer getPlayer() {
        return this.event.entityPlayer;
    }
    
    public Entity getTarget() {
        return this.event.target;
    }
    
    public Entity getEntity() {
        return this.event.entity;
    }
}
