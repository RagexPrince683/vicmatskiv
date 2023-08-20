package com.vicmatskiv.weaponlib.compatibility;

import net.minecraftforge.event.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class CompatibleEntityJoinWorldEvent
{
    private EntityJoinWorldEvent event;
    
    public CompatibleEntityJoinWorldEvent(final EntityJoinWorldEvent event) {
        super();
        this.event = event;
    }
    
    public World getWorld() {
        return this.event.world;
    }
    
    public Entity getEntity() {
        return this.event.entity;
    }
}
