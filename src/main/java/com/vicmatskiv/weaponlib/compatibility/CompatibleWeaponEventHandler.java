package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.entity.*;
import cpw.mods.fml.relauncher.*;
import com.vicmatskiv.weaponlib.*;

public abstract class CompatibleWeaponEventHandler
{
    public CompatibleWeaponEventHandler() {
        super();
    }
    
    @SubscribeEvent
    public final void onGuiOpenEvent(final GuiOpenEvent event) {
        this.onCompatibleGuiOpenEvent(event);
    }
    
    protected abstract void onCompatibleGuiOpenEvent(final GuiOpenEvent p0);
    
    @SubscribeEvent
    public final void zoom(final FOVUpdateEvent event) {
        this.compatibleZoom(event);
    }
    
    protected abstract void compatibleZoom(final FOVUpdateEvent p0);
    
    @SubscribeEvent
    public final void onMouse(final MouseEvent event) {
        this.onCompatibleMouse(event);
    }
    
    protected abstract void onCompatibleMouse(final MouseEvent p0);
    
    @SubscribeEvent
    public final void handleRenderLivingEvent(final RenderLivingEvent.Pre event) {
        this.onCompatibleHandleRenderLivingEvent(event);
    }
    
    protected abstract void onCompatibleHandleRenderLivingEvent(final RenderLivingEvent.Pre p0);
    
    @SubscribeEvent
    public void onTextureStitchEvent(final TextureStitchEvent.Pre event) {
        event.map.registerIcon(this.getModContext().getNamedResource("particle/blood").toString());
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public final void onEntityJoinWorldEvent(final EntityJoinWorldEvent event) {
        this.onCompatibleEntityJoinedWorldEvent(new CompatibleEntityJoinWorldEvent(event));
    }
    
    protected abstract void onCompatibleEntityJoinedWorldEvent(final CompatibleEntityJoinWorldEvent p0);
    
    protected abstract ModContext getModContext();
}
