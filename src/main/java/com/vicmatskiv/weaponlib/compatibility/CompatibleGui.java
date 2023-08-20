package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.gui.*;
import net.minecraftforge.client.event.*;
import cpw.mods.fml.common.eventhandler.*;

public abstract class CompatibleGui extends Gui
{
    public CompatibleGui() {
        super();
    }
    
    @SubscribeEvent
    public final void onRenderHud(final RenderGameOverlayEvent.Pre event) {
        this.onCompatibleRenderHud(event);
    }
    
    public abstract void onCompatibleRenderHud(final RenderGameOverlayEvent.Pre p0);
    
    @SubscribeEvent
    public final void onRenderCrosshair(final RenderGameOverlayEvent.Pre event) {
        this.onCompatibleRenderCrosshair(event);
    }
    
    public abstract void onCompatibleRenderCrosshair(final RenderGameOverlayEvent.Pre p0);
}
