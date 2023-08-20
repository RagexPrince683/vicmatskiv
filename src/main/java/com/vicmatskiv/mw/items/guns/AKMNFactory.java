package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class AKMNFactory implements GunFactory
{
    public AKMNFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("AKMN").withFireRate(0.6f).withRecoil(2.5f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 1).withShootSound("AK47").withSilencedShootSound("AKsilenced").withReloadSound("AKReload").withUnloadSound("akunload").withReloadingTime(45L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, CommonProxy.MetalComponents, CompatibleBlocks.PLANK).withInformationProvider(stack -> Arrays.asList("Type: Assault rifle", "Damage: 7.4", "Caliber: 7.62x39mm", "Magazines:", "30rnd 7.62x39mm Magazine", "30rnd 7.62x39mm PMAG Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(Attachments.Silencer762x39, model -> {
            GL11.glTranslatef(-0.2f, -1.06f, -7.55f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.ACOG, (player, stack) -> {
            GL11.glTranslatef(-0.295f, -1.41f, -0.8f);
            GL11.glScaled(0.75, 0.75, 0.75);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Scope, (player, stack) -> {
            GL11.glTranslatef(-0.35f, -1.4f, -0.8f);
            GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.272f, 0.67f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.HP, (player, stack) -> {
            GL11.glTranslatef(-0.295f, -1.41f, -0.8f);
            GL11.glScaled(0.75, 0.75, 0.75);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.235f, 1.16f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.065f, -1.225f, -1.3f);
                GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.125f, -1.54f, -1.4f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.045f, -1.26f, -1.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.12f, -1.55f, -1.0f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.045f, -1.26f, -1.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.12f, -1.55f, -1.0f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.045f, -1.26f, -1.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.12f, -1.53f, -1.5f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(AuxiliaryAttachments.AKIron, true, model -> {
            GL11.glTranslatef(-0.175f, -1.06f, -5.96f);
            GL11.glScaled(0.6000000238418579, 0.550000011920929, 0.5);
        }).withCompatibleAttachment(AuxiliaryAttachments.AKRail, true, model -> {
            GL11.glTranslatef(-0.23f, -1.31f, -2.7f);
            GL11.glScaled(0.800000011920929, 1.100000023841858, 1.059999942779541);
        }).withCompatibleAttachment(AuxiliaryAttachments.AKaction, true, model -> {}).withCompatibleAttachment(Magazines.Magazine762x39, model -> GL11.glTranslatef(0.0f, -0.17f, 0.05f)).withCompatibleAttachment(Magazines.Mag75rnd762x39, model -> {
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.011f, 0.59f, 0.05f);
            GL11.glScaled(1.100000023841858, 1.2999999523162842, 1.0);
        }).withCompatibleAttachment(Magazines.PMAG762x39, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof AKMiron1) {
                GL11.glTranslatef(0.125f, -1.8f, -0.5f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AKMiron2) {
                GL11.glTranslatef(-0.183f, -1.32f, -5.95f);
                GL11.glScaled(0.550000011920929, 0.550000011920929, 0.6800000071525574);
            }
            else if (model instanceof AK47iron) {
                GL11.glTranslatef(-0.25f, -1.65f, -3.05f);
                GL11.glScaled(0.800000011920929, 0.699999988079071, 0.6000000238418579);
            }
            else if (model instanceof M4Iron1) {
                GL11.glTranslatef(0.155f, -1.74f, 1.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(0.26f, -1.55f, -2.35f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof P90iron) {
                GL11.glTranslatef(0.26f, -1.55f, -2.35f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof G36CIron1) {
                GL11.glTranslatef(-0.22f, -1.94f, 0.13f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof G36CIron2) {
                GL11.glTranslatef(-0.205f, -1.9f, -3.15f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof ScarIron1) {
                GL11.glTranslatef(0.165f, -1.65f, 1.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof ScarIron2) {
                GL11.glTranslatef(0.25f, -1.55f, -2.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof FALIron) {
                GL11.glTranslatef(0.129f, -1.63f, -2.08f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof M14Iron) {
                GL11.glTranslatef(0.129f, -1.63f, -2.08f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(0.215f, -1.54f, 1.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withTextureNames("AKMN").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new AKMN()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
            GL11.glTranslatef(1.0f, 2.0f, -1.2f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.52f, 1.0f, -0.35f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.52f, 1.0f, 0.0f);
            GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(-0.06f, -0.31f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.65f, -1.2f, 1.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-0.7f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(-0.01f, 0.24f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.3f, 0.45f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(-0.01f, 0.2401f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.18f, 0.3f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.18f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.181f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.16f, 2.8f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(Magazines.Magazine762x39, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.PMAG762x39, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.Mag75rnd762x39, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AKIron.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AKRail.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AKaction.getRenderablePart(), renderContext -> {
            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.AKaction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.AKaction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f)).withFirstPersonPositioningCustomRecoiled(Magazines.Magazine762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.Magazine762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.Mag75rnd762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.Mag75rnd762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.PMAG762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.PMAG762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.AKIron.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.AKIron.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.AKRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.AKRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
        }, 300L, 60L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
        }, 300L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
        }, 400L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
        }, 120L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
        }, 130L, 150L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AKIron.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AKIron.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AKRail.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AKRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AKaction.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AKaction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.Magazine762x39, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.Magazine762x39, new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {}, 50L, 200L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.Mag75rnd762x39, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.Mag75rnd762x39, new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {}, 50L, 200L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.PMAG762x39, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.PMAG762x39, new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {}, 50L, 200L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(-0.06f, -0.31f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.65f, -1.2f, 1.5f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(-0.01f, 0.24f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.3f, 0.45f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(-0.01f, 0.2401f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.18f, 0.3f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.18f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.181f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.16f, 2.8f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.35f, 1.025f, -0.4f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.149999f, 0.45f, 0.525f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.49f, 0.14f, -0.1f);
            GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.33f, -0.5f, 0.08f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.375f, -0.8f, 0.15f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.075f, -0.7f, 0.725f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.3f, -0.625f, 0.075f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.0f, -0.075f, 0.075f);
        }, 260L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.025f, -0.425f, 0.15f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.0f, -0.075f, 0.075f);
        }, 280L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.3f, -0.625f, 0.075f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.075f, -0.7f, 0.725f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.4f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$1545(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1544(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1543(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.075f, -0.7f, 0.725f);
    }
    
    private static /* synthetic */ void lambda$createGun$1542(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.3f, -0.625f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1541(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1540(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.025f, -0.425f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$1539(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1538(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1537(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1536(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1535(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1534(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1533(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.3f, -0.625f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1532(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.075f, -0.7f, 0.725f);
    }
    
    private static /* synthetic */ void lambda$createGun$1531(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1530(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$1529(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.33f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1528(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.49f, 0.14f, -0.1f);
        GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1527(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1526(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1525(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.149999f, 0.45f, 0.525f);
    }
    
    private static /* synthetic */ void lambda$createGun$1524(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.35f, 1.025f, -0.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$1523(final RenderContext renderContext) {
        GL11.glTranslatef(-0.06f, -0.31f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.65f, -1.2f, 1.5f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(-0.01f, 0.24f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.3f, 0.45f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(-0.01f, 0.2401f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.18f, 0.3f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.18f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.181f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.16f, 2.8f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1522(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1521(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1520(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1519(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1518(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1517(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1516(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1515(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1514(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1513(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1512(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1511(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1510(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1509(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1508(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1507(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1506(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1505(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1504(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1503(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1502(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1501(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1500(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$1499(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1498(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1497(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1496(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1495(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1494(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1493(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1492(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1491(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1490(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1489(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1488(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1487(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1486(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1485(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1484(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1483(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1482(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1481(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1480(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1479(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1478(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$1477(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$1476(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$1475(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1474(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1473(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1472(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1471(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1470(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1469(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1468(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1467(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1466(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1465(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1464(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1463(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1462(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1461(final RenderContext renderContext) {
        if (renderContext.getWeaponInstance().getAmmo() == 0) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1460(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1459(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1458(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1457(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1456(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1455(final RenderContext renderContext) {
        GL11.glTranslatef(-0.06f, -0.31f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.65f, -1.2f, 1.6f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-0.7f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(-0.01f, 0.24f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.3f, 0.45f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(-0.01f, 0.2401f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.18f, 0.3f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.18f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.181f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.16f, 2.8f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1454(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.52f, 1.0f, 0.0f);
        GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1453(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.52f, 1.0f, -0.35f);
    }
    
    private static /* synthetic */ void lambda$createGun$1452(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1451(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1450(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1449(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1448(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$1447(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1446(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$1445(final ModelBase model) {
        if (model instanceof AKMiron1) {
            GL11.glTranslatef(0.125f, -1.8f, -0.5f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AKMiron2) {
            GL11.glTranslatef(-0.183f, -1.32f, -5.95f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.6800000071525574);
        }
        else if (model instanceof AK47iron) {
            GL11.glTranslatef(-0.25f, -1.65f, -3.05f);
            GL11.glScaled(0.800000011920929, 0.699999988079071, 0.6000000238418579);
        }
        else if (model instanceof M4Iron1) {
            GL11.glTranslatef(0.155f, -1.74f, 1.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(0.26f, -1.55f, -2.35f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof P90iron) {
            GL11.glTranslatef(0.26f, -1.55f, -2.35f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof G36CIron1) {
            GL11.glTranslatef(-0.22f, -1.94f, 0.13f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof G36CIron2) {
            GL11.glTranslatef(-0.205f, -1.9f, -3.15f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof ScarIron1) {
            GL11.glTranslatef(0.165f, -1.65f, 1.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof ScarIron2) {
            GL11.glTranslatef(0.25f, -1.55f, -2.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof FALIron) {
            GL11.glTranslatef(0.129f, -1.63f, -2.08f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof M14Iron) {
            GL11.glTranslatef(0.129f, -1.63f, -2.08f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof MP5Iron) {
            GL11.glTranslatef(0.215f, -1.54f, 1.2f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1444(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$1443(final ModelBase model) {
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.011f, 0.59f, 0.05f);
        GL11.glScaled(1.100000023841858, 1.2999999523162842, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$1442(final ModelBase model) {
        GL11.glTranslatef(0.0f, -0.17f, 0.05f);
    }
    
    private static /* synthetic */ void lambda$createGun$1441(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$1440(final ModelBase model) {
        GL11.glTranslatef(-0.23f, -1.31f, -2.7f);
        GL11.glScaled(0.800000011920929, 1.100000023841858, 1.059999942779541);
    }
    
    private static /* synthetic */ void lambda$createGun$1439(final ModelBase model) {
        GL11.glTranslatef(-0.175f, -1.06f, -5.96f);
        GL11.glScaled(0.6000000238418579, 0.550000011920929, 0.5);
    }
    
    private static /* synthetic */ void lambda$createGun$1438(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.045f, -1.26f, -1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -1.53f, -1.5f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1437(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.045f, -1.26f, -1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.55f, -1.0f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1436(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.045f, -1.26f, -1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.55f, -1.0f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1435(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.065f, -1.225f, -1.3f);
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -1.54f, -1.4f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1434(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.235f, 1.16f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1433(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.295f, -1.41f, -0.8f);
        GL11.glScaled(0.75, 0.75, 0.75);
    }
    
    private static /* synthetic */ void lambda$createGun$1432(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1431(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.35f, -1.4f, -0.8f);
        GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$1430(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1429(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.295f, -1.41f, -0.8f);
        GL11.glScaled(0.75, 0.75, 0.75);
    }
    
    private static /* synthetic */ void lambda$createGun$1428(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.06f, -7.55f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$1427(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1426(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$1425(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1424(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$1423(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1422(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$1421(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1420(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$1419(final ItemStack stack) {
        return Arrays.asList("Type: Assault rifle", "Damage: 7.4", "Caliber: 7.62x39mm", "Magazines:", "30rnd 7.62x39mm Magazine", "30rnd 7.62x39mm PMAG Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$1418() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$1417() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$1416() {
        return 0.8f;
    }
}
