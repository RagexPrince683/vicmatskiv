package com.vicmatskiv.weaponlib;

import net.minecraft.client.*;
import com.vicmatskiv.weaponlib.config.*;
import net.minecraftforge.client.event.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import org.lwjgl.input.*;
import com.vicmatskiv.weaponlib.electronics.*;
import com.vicmatskiv.weaponlib.grenade.*;
import net.minecraft.client.gui.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class CustomGui extends CompatibleGui
{
    private static final int STATUS_BAR_BOTTOM_OFFSET = 15;
    private static final int STATUS_BAR_TOP_OFFSET = 10;
    private Minecraft mc;
    private WeaponAttachmentAspect attachmentAspect;
    private ModContext modContext;
    private ConfigurationManager.StatusBarPosition statusBarPosition;
    
    public CustomGui(final Minecraft mc, final ModContext modContext, final WeaponAttachmentAspect attachmentAspect) {
        super();
        this.mc = mc;
        this.modContext = modContext;
        this.attachmentAspect = attachmentAspect;
        this.statusBarPosition = modContext.getConfigurationManager().getStatusBarPosition();
    }
    
    @Override
    public void onCompatibleRenderHud(final RenderGameOverlayEvent.Pre event) {
        if (CompatibilityProvider.compatibility.getEventType(event) == RenderGameOverlayEvent.ElementType.HELMET) {
            final ItemStack helmet = CompatibilityProvider.compatibility.getHelmet();
            if (helmet != null && this.mc.gameSettings.thirdPersonView == 0 && helmet.getItem() instanceof CustomArmor) {
                final String hudTexture = ((CustomArmor)helmet.getItem()).getHudTexture();
                if (hudTexture != null) {
                    final ScaledResolution scaledResolution = CompatibilityProvider.compatibility.getResolution(event);
                    final int width = scaledResolution.getScaledWidth();
                    final int height = scaledResolution.getScaledHeight();
                    GL11.glPushAttrib(8192);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glDisable(2896);
                    GL11.glBlendFunc(770, 771);
                    GL11.glEnable(3042);
                    this.mc.renderEngine.bindTexture(new ResourceLocation(hudTexture));
                    drawTexturedQuadFit(0.0, 0.0, width, height, 0.0);
                    GL11.glPopAttrib();
                    event.setCanceled(true);
                }
            }
        }
    }
    
    @Override
    public void onCompatibleRenderCrosshair(final RenderGameOverlayEvent.Pre event) {
        if (CompatibilityProvider.compatibility.getEventType(event) != RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            return;
        }
        final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)CompatibilityProvider.compatibility.clientPlayer());
        if (itemStack == null) {
            return;
        }
        final PlayerWeaponInstance weaponInstance = this.modContext.getMainHeldWeapon();
        if (weaponInstance != null) {
            final Weapon weaponItem = (Weapon)itemStack.getItem();
            final String crosshair = (weaponItem != null) ? weaponItem.getCrosshair(weaponInstance) : null;
            if (crosshair != null) {
                final ScaledResolution scaledResolution = CompatibilityProvider.compatibility.getResolution(event);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final FontRenderer fontRender = CompatibilityProvider.compatibility.getFontRenderer();
                this.mc.entityRenderer.setupOverlayRendering();
                int color = 16777215;
                this.mc.renderEngine.bindTexture(new ResourceLocation(crosshair));
                GL11.glPushAttrib(8192);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(2896);
                GL11.glBlendFunc(770, 771);
                GL11.glEnable(3042);
                if (this.isInModifyingState(weaponInstance)) {
                    final String changeScopeMessage = CompatibilityProvider.compatibility.getLocalizedString("gui.attachmentMode.changeScope", Keyboard.getKeyName(KeyBindings.upArrowKey.getKeyCode()));
                    fontRender.drawStringWithShadow(changeScopeMessage, width / 2 - 40, 60, color);
                    final String changeBarrelRigMessage = CompatibilityProvider.compatibility.getLocalizedString("gui.attachmentMode.changeBarrelRig", Keyboard.getKeyName(KeyBindings.leftArrowKey.getKeyCode()));
                    fontRender.drawStringWithShadow(changeBarrelRigMessage, 10, height / 2 - 10, color);
                    final String changeCamoMessage = CompatibilityProvider.compatibility.getLocalizedString("gui.attachmentMode.changeCamo", Keyboard.getKeyName(KeyBindings.rightArrowKey.getKeyCode()));
                    fontRender.drawStringWithShadow(changeCamoMessage, width / 2 + 60, height / 2 - 20, color);
                    final String changeUnderBarrelRig = CompatibilityProvider.compatibility.getLocalizedString("gui.attachmentMode.changeUnderBarrelRig", Keyboard.getKeyName(KeyBindings.downArrowKey.getKeyCode()));
                    fontRender.drawStringWithShadow(changeUnderBarrelRig, 10, height - 40, color);
                }
                else {
                    final StatusMessageCenter.Message message = this.modContext.getStatusMessageCenter().nextMessage();
                    String messageText;
                    if (message != null) {
                        messageText = message.getMessage();
                        if (message.isAlert()) {
                            color = 16776960;
                        }
                    }
                    else {
                        messageText = this.getDefaultWeaponMessage(weaponInstance);
                    }
                    final int x = this.getStatusBarXPosition(width, messageText, fontRender);
                    final int y = this.getStatusBarYPosition(height);
                    fontRender.drawStringWithShadow(messageText, x, y, color);
                }
                GL11.glPopAttrib();
                event.setCanceled(true);
            }
        }
        else if (itemStack.getItem() instanceof ItemMagazine) {
            final ScaledResolution scaledResolution2 = CompatibilityProvider.compatibility.getResolution(event);
            final int width2 = scaledResolution2.getScaledWidth();
            final int height2 = scaledResolution2.getScaledHeight();
            final FontRenderer fontRender2 = CompatibilityProvider.compatibility.getFontRenderer();
            this.mc.entityRenderer.setupOverlayRendering();
            int color2 = 16777215;
            final StatusMessageCenter.Message message2 = this.modContext.getStatusMessageCenter().nextMessage();
            String messageText2;
            if (message2 != null) {
                messageText2 = message2.getMessage();
                if (message2.isAlert()) {
                    color2 = 16711680;
                }
            }
            else {
                messageText2 = this.getDefaultMagazineMessage(itemStack);
            }
            final int x2 = this.getStatusBarXPosition(width2, messageText2, fontRender2);
            final int y2 = this.getStatusBarYPosition(height2);
            fontRender2.drawStringWithShadow(messageText2, x2, y2, color2);
            event.setCanceled(true);
        }
        else if (itemStack.getItem() instanceof ItemWirelessCamera) {
            final ScaledResolution scaledResolution2 = CompatibilityProvider.compatibility.getResolution(event);
            final int width2 = scaledResolution2.getScaledWidth();
            final int height2 = scaledResolution2.getScaledHeight();
            final FontRenderer fontRender2 = CompatibilityProvider.compatibility.getFontRenderer();
            this.mc.entityRenderer.setupOverlayRendering();
            int color2 = 16777215;
            final StatusMessageCenter.Message message2 = this.modContext.getStatusMessageCenter().nextMessage();
            if (message2 != null) {
                final String messageText2 = message2.getMessage();
                if (message2.isAlert()) {
                    color2 = 16711680;
                }
                int x2 = this.getStatusBarXPosition(width2, messageText2, fontRender2);
                final int y2 = this.getStatusBarYPosition(height2);
                final int stringWidth = fontRender2.getStringWidth(messageText2);
                if (stringWidth > 80) {
                    x2 = width2 - stringWidth - 5;
                }
                fontRender2.drawStringWithShadow(messageText2, x2, y2, color2);
                event.setCanceled(true);
            }
        }
        else if (itemStack.getItem() instanceof ItemGrenade) {
            final ScaledResolution scaledResolution2 = CompatibilityProvider.compatibility.getResolution(event);
            final int width2 = scaledResolution2.getScaledWidth();
            final int height2 = scaledResolution2.getScaledHeight();
            final FontRenderer fontRender2 = CompatibilityProvider.compatibility.getFontRenderer();
            this.mc.entityRenderer.setupOverlayRendering();
            int color2 = 16777215;
            final StatusMessageCenter.Message message2 = this.modContext.getStatusMessageCenter().nextMessage();
            if (message2 != null) {
                final String messageText2 = message2.getMessage();
                if (message2.isAlert()) {
                    color2 = 16776960;
                }
                int x2 = this.getStatusBarXPosition(width2, messageText2, fontRender2);
                final int y2 = this.getStatusBarYPosition(height2);
                final int stringWidth = fontRender2.getStringWidth(messageText2);
                if (stringWidth > 80) {
                    x2 = width2 - stringWidth - 5;
                }
                fontRender2.drawStringWithShadow(messageText2, x2, y2, color2);
                event.setCanceled(true);
            }
        }
    }
    
    private int getStatusBarXPosition(final int width, final String text, final FontRenderer fontRender) {
        int x;
        if (this.statusBarPosition == ConfigurationManager.StatusBarPosition.BOTTOM_RIGHT || this.statusBarPosition == ConfigurationManager.StatusBarPosition.TOP_RIGHT) {
            x = width - 80;
            final int stringWidth = fontRender.getStringWidth(text);
            if (stringWidth > 80) {
                x = width - stringWidth - 5;
            }
        }
        else {
            x = 10;
        }
        return x;
    }
    
    private int getStatusBarYPosition(final int height) {
        int yPos = 0;
        switch (this.statusBarPosition) {
            case TOP_RIGHT:
            case TOP_LEFT: {
                yPos = 10;
                break;
            }
            case BOTTOM_RIGHT:
            case BOTTOM_LEFT: {
                yPos = height - 15;
                break;
            }
            default: {
                yPos = 10;
                break;
            }
        }
        return yPos;
    }
    
    private String getDefaultMagazineMessage(final ItemStack itemStack) {
        final ItemMagazine magazine = (ItemMagazine)itemStack.getItem();
        final String ammoCounterMessage = CompatibilityProvider.compatibility.getLocalizedString("gui.ammoCounter", Tags.getAmmo(itemStack) + "/" + magazine.getAmmo());
        return ammoCounterMessage;
    }
    
    private String getDefaultWeaponMessage(final PlayerWeaponInstance weaponInstance) {
        final WeaponAttachmentAspect attachmentAspect = this.attachmentAspect;
        final ItemMagazine magazine = (ItemMagazine)WeaponAttachmentAspect.getActiveAttachment(AttachmentCategory.MAGAZINE, weaponInstance);
        int totalCapacity;
        if (magazine != null) {
            totalCapacity = magazine.getAmmo();
        }
        else {
            totalCapacity = weaponInstance.getWeapon().getAmmoCapacity();
        }
        String text;
        if (weaponInstance.getWeapon().getAmmoCapacity() == 0 && totalCapacity == 0) {
            text = CompatibilityProvider.compatibility.getLocalizedString("gui.noMagazine", new Object[0]);
        }
        else {
            text = CompatibilityProvider.compatibility.getLocalizedString("gui.ammoCounter", weaponInstance.getWeapon().getCurrentAmmo(CompatibilityProvider.compatibility.clientPlayer()) + "/" + totalCapacity);
        }
        return text;
    }
    
    private boolean isInModifyingState(final PlayerWeaponInstance weaponInstance) {
        return weaponInstance.getState() == WeaponState.MODIFYING || weaponInstance.getState() == WeaponState.MODIFYING_REQUESTED || weaponInstance.getState() == WeaponState.NEXT_ATTACHMENT || weaponInstance.getState() == WeaponState.NEXT_ATTACHMENT_REQUESTED;
    }
    
    private static void drawTexturedQuadFit(final double x, final double y, final double width, final double height, final double zLevel) {
        final CompatibleTessellator tessellator = CompatibleTessellator.getInstance();
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0.0, y + height, zLevel, 0.0f, 1.0f);
        tessellator.addVertexWithUV(x + width, y + height, zLevel, 1.0f, 1.0f);
        tessellator.addVertexWithUV(x + width, y + 0.0, zLevel, 1.0f, 0.0f);
        tessellator.addVertexWithUV(x + 0.0, y + 0.0, zLevel, 0.0f, 0.0f);
        tessellator.draw();
    }
}
