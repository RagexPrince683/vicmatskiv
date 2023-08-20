package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.gameevent.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.common.eventhandler.*;
import com.vicmatskiv.weaponlib.*;

public abstract class CompatibleClientEventHandler
{
    public CompatibleClientEventHandler() {
        super();
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public final void onClientTick(final TickEvent.ClientTickEvent event) {
        this.onCompatibleClientTick(new CompatibleClientTickEvent(event));
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public final void onRenderTickEvent(final TickEvent.RenderTickEvent event) {
        this.onCompatibleRenderTickEvent(new CompatibleRenderTickEvent(event));
    }
    
    protected abstract void onCompatibleRenderTickEvent(final CompatibleRenderTickEvent p0);
    
    protected abstract void onCompatibleClientTick(final CompatibleClientTickEvent p0);
    
    protected abstract ModContext getModContext();
}
