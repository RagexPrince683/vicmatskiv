package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.melee.*;
import com.vicmatskiv.weaponlib.grenade.*;
import net.minecraftforge.client.event.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.entity.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class WeaponEventHandler extends CompatibleWeaponEventHandler
{
    private SafeGlobals safeGlobals;
    private ModContext modContext;
    
    public WeaponEventHandler(final ModContext modContext, final SafeGlobals safeGlobals) {
        super();
        this.modContext = modContext;
        this.safeGlobals = safeGlobals;
    }
    
    public void onCompatibleGuiOpenEvent(final GuiOpenEvent event) {
        this.safeGlobals.guiOpen.set(CompatibilityProvider.compatibility.getGui(event) != null);
    }
    
    public void compatibleZoom(final FOVUpdateEvent event) {
        final PlayerWeaponInstance instance = this.modContext.getMainHeldWeapon();
        if (instance != null) {
            float fov;
            if (instance.isAttachmentZoomEnabled()) {
                if (this.safeGlobals.renderingPhase.get() == RenderingPhase.RENDER_PERSPECTIVE) {
                    fov = instance.getZoom();
                }
                else {
                    fov = (CompatibilityProvider.compatibility.isFlying(CompatibilityProvider.compatibility.clientPlayer()) ? 1.1f : 1.0f);
                }
            }
            else {
                fov = (CompatibilityProvider.compatibility.isFlying(CompatibilityProvider.compatibility.clientPlayer()) ? 1.1f : 1.0f);
            }
            CompatibilityProvider.compatibility.setNewFov(event, fov);
        }
    }
    
    public void onCompatibleMouse(final MouseEvent event) {
        if (CompatibilityProvider.compatibility.getButton(event) == 0 || CompatibilityProvider.compatibility.getButton(event) == 1) {
            final PlayerItemInstance<?> instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(CompatibilityProvider.compatibility.clientPlayer());
            if (instance instanceof PlayerWeaponInstance || instance instanceof PlayerMeleeInstance || instance instanceof PlayerGrenadeInstance) {
                event.setCanceled(true);
            }
        }
    }
    
    public void onCompatibleHandleRenderLivingEvent(final RenderLivingEvent.Pre event) {
        if (event.isCanceled() || !(CompatibilityProvider.compatibility.getEntity(event) instanceof EntityPlayer)) {
            return;
        }
        final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand(CompatibilityProvider.compatibility.getEntity(event));
        if (itemStack != null && itemStack.getItem() instanceof Weapon) {
            final RenderPlayer rp = CompatibilityProvider.compatibility.getRenderer(event);
            if (itemStack != null) {
                final PlayerItemInstance<?> instance = this.modContext.getPlayerItemInstanceRegistry().getItemInstance((EntityPlayer)CompatibilityProvider.compatibility.getEntity(event), itemStack);
                if (instance instanceof PlayerWeaponInstance) {
                    final PlayerWeaponInstance weaponInstance = (PlayerWeaponInstance)instance;
                    CompatibilityProvider.compatibility.setAimed(rp, weaponInstance.isAimed() || weaponInstance.getState() == WeaponState.FIRING || weaponInstance.getState() == WeaponState.RECOILED || weaponInstance.getState() == WeaponState.PAUSED);
                }
            }
        }
    }
    
    @Override
    protected void onCompatibleEntityJoinedWorldEvent(final CompatibleEntityJoinWorldEvent compatibleEntityJoinWorldEvent) {
        if (compatibleEntityJoinWorldEvent.getEntity() instanceof Contextual) {
            ((Contextual)compatibleEntityJoinWorldEvent.getEntity()).setContext(this.modContext);
        }
    }
    
    @Override
    protected ModContext getModContext() {
        return this.modContext;
    }
}
