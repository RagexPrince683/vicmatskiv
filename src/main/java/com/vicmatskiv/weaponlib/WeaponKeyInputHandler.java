package com.vicmatskiv.weaponlib;

import java.util.function.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.melee.*;
import com.vicmatskiv.weaponlib.electronics.*;
import net.minecraft.item.*;

public class WeaponKeyInputHandler extends CompatibleWeaponKeyInputHandler
{
    private CompatibleChannel channel;
    private Function<CompatibleMessageContext, EntityPlayer> entityPlayerSupplier;
    private ModContext modContext;
    
    public WeaponKeyInputHandler(final ModContext modContext, final Function<CompatibleMessageContext, EntityPlayer> entityPlayerSupplier, final WeaponAttachmentAspect attachmentAspect, final CompatibleChannel channel) {
        super();
        this.modContext = modContext;
        this.entityPlayerSupplier = entityPlayerSupplier;
        this.channel = channel;
    }
    
    public void onCompatibleKeyInput() {
        final EntityPlayer player = this.entityPlayerSupplier.apply(null);
        final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)player);
        if (DebugPositioner.isDebugModeEnabled() && KeyBindings.upArrowKey.isPressed()) {
            DebugPositioner.incrementXRotation(5.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.downArrowKey.isPressed()) {
            DebugPositioner.incrementXRotation(-5.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.leftArrowKey.isPressed()) {
            DebugPositioner.incrementYRotation(5.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.rightArrowKey.isPressed()) {
            DebugPositioner.incrementYRotation(-5.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.jDebugKey.isPressed()) {
            DebugPositioner.incrementZRotation(5.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.kDebugKey.isPressed()) {
            DebugPositioner.incrementZRotation(-5.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.minusDebugKey.isPressed()) {
            DebugPositioner.incrementXPosition(-1.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.equalsDebugKey.isPressed()) {
            DebugPositioner.incrementXPosition(1.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.lBracketDebugKey.isPressed()) {
            DebugPositioner.incrementYPosition(-1.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.rBracketDebugKey.isPressed()) {
            DebugPositioner.incrementYPosition(1.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.semicolonDebugKey.isPressed()) {
            DebugPositioner.incrementZPosition(-1.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.apostropheDebugKey.isPressed()) {
            DebugPositioner.incrementZPosition(1.0f);
        }
        else if (DebugPositioner.isDebugModeEnabled() && KeyBindings.deleteDebugKey.isPressed()) {
            DebugPositioner.reset();
        }
        else if (KeyBindings.reloadKey.isPressed()) {
            if (itemStack != null) {
                final Item item = itemStack.getItem();
                if (item instanceof Reloadable) {
                    ((Reloadable)item).reloadMainHeldItemForPlayer(player);
                }
            }
        }
        else if (KeyBindings.laserSwitchKey.isPressed()) {
            final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
            if (instance != null && (instance.getState() == WeaponState.READY || instance.getState() == WeaponState.MODIFYING)) {
                instance.setLaserOn(!instance.isLaserOn());
            }
        }
        else if (KeyBindings.attachmentKey.isPressed()) {
            if (itemStack != null && itemStack.getItem() instanceof Modifiable) {
                ((Modifiable)itemStack.getItem()).toggleClientAttachmentSelectionMode(player);
            }
        }
        else if (KeyBindings.upArrowKey.isPressed()) {
            final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
            if (instance != null && instance.getState() == WeaponState.MODIFYING) {
                this.modContext.getAttachmentAspect().changeAttachment(AttachmentCategory.SCOPE, instance);
            }
        }
        else if (KeyBindings.rightArrowKey.isPressed()) {
            final PlayerItemInstance<?> instance2 = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player);
            if (instance2 instanceof PlayerWeaponInstance && instance2.getState() == WeaponState.MODIFYING) {
                this.modContext.getAttachmentAspect().changeAttachment(AttachmentCategory.SKIN, (PlayerWeaponInstance)instance2);
            }
            else if (instance2 instanceof PlayerMeleeInstance && instance2.getState() == MeleeState.MODIFYING) {
                this.modContext.getMeleeAttachmentAspect().changeAttachment(AttachmentCategory.SKIN, (PlayerMeleeInstance)instance2);
            }
            else if (instance2 instanceof PlayerTabletInstance) {
                final PlayerTabletInstance playerTabletInstance = (PlayerTabletInstance)instance2;
                playerTabletInstance.nextActiveWatchIndex();
            }
        }
        else if (KeyBindings.downArrowKey.isPressed()) {
            final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
            if (instance != null && instance.getState() == WeaponState.MODIFYING) {
                this.modContext.getAttachmentAspect().changeAttachment(AttachmentCategory.GRIP, instance);
            }
        }
        else if (KeyBindings.leftArrowKey.isPressed()) {
            final PlayerItemInstance<?> instance2 = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player);
            if (instance2 instanceof PlayerWeaponInstance && instance2.getState() == WeaponState.MODIFYING) {
                this.modContext.getAttachmentAspect().changeAttachment(AttachmentCategory.SILENCER, (PlayerWeaponInstance)instance2);
            }
            else if (instance2 instanceof PlayerTabletInstance) {
                final PlayerTabletInstance playerTabletInstance = (PlayerTabletInstance)instance2;
                playerTabletInstance.previousActiveWatchIndex();
            }
        }
        else if (KeyBindings.fireModeKey.isPressed()) {
            final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
            if (instance != null && instance.getState() == WeaponState.READY) {
                instance.getWeapon().changeFireMode(instance);
            }
        }
        else if (KeyBindings.addKey.isPressed()) {
            final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
            if (instance != null && (instance.getState() == WeaponState.READY || instance.getState() == WeaponState.EJECT_REQUIRED)) {
                instance.getWeapon().incrementZoom(instance);
            }
        }
        else if (KeyBindings.subtractKey.isPressed()) {
            final PlayerWeaponInstance instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(player, PlayerWeaponInstance.class);
            if (instance != null && (instance.getState() == WeaponState.READY || instance.getState() == WeaponState.EJECT_REQUIRED)) {
                instance.getWeapon().decrementZoom(instance);
            }
        }
    }
}
