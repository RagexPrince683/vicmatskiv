package com.vicmatskiv.weaponlib.compatibility;

import net.minecraftforge.event.entity.item.*;
import cpw.mods.fml.common.eventhandler.*;
import cpw.mods.fml.common.gameevent.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.entity.living.*;

public abstract class CompatibleServerEventHandler
{
    public CompatibleServerEventHandler() {
        super();
    }
    
    @SubscribeEvent
    public void onItemToss(final ItemTossEvent itemTossEvent) {
        this.onCompatibleItemToss(itemTossEvent);
    }
    
    protected abstract void onCompatibleItemToss(final ItemTossEvent p0);
    
    @SubscribeEvent
    public void onTick(final TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {}
    }
    
    @SubscribeEvent
    public void onEntityConstructing(final EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            ExtendedPlayerProperties.init((EntityPlayer)event.entity);
        }
    }
    
    @SubscribeEvent
    public void onEntityJoinWorld(final EntityJoinWorldEvent e) {
        this.onCompatibleEntityJoinWorld(new CompatibleEntityJoinWorldEvent(e));
    }
    
    protected abstract void onCompatibleEntityJoinWorld(final CompatibleEntityJoinWorldEvent p0);
    
    @SubscribeEvent
    public void playerStartedTracking(final PlayerEvent.StartTracking e) {
        this.onCompatiblePlayerStartedTracking(new CompatibleStartTrackingEvent(e));
    }
    
    @SubscribeEvent
    public void playerStoppedTracking(final PlayerEvent.StopTracking e) {
        this.onCompatiblePlayerStoppedTracking(new CompatibleStopTrackingEvent(e));
    }
    
    protected abstract void onCompatiblePlayerStartedTracking(final CompatibleStartTrackingEvent p0);
    
    public abstract String getModId();
    
    protected abstract void onCompatiblePlayerStoppedTracking(final CompatibleStopTrackingEvent p0);
    
    protected abstract void onCompatibleLivingDeathEvent(final LivingDeathEvent p0);
}
