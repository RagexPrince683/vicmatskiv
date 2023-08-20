package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;

public class FamasF1Factory implements GunFactory
{
    public FamasF1Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("FamasF1").withFireRate(0.75f).withRecoil(2.0f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("Famas").withSilencedShootSound("RifleSilencer").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(50L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(0.8f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.11f).withFlashOffsetY(() -> 0.12f).withShellCasingForwardOffset(-0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Bullpup assault rifle", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine (Type 2)", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.Voltaic, (a, i) -> i.setActiveTextureIndex(GunSkins.Voltaic.getTextureVariantIndex("voltaic")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(Magazines.NATOFamasMag, model -> {
            GL11.glTranslatef(-0.355f, 0.9f, 1.65f);
            GL11.glScaled(1.2000000476837158, 1.5, 1.5);
        }).withCompatibleAttachment(AuxiliaryAttachments.FamasCarryHandle, true, model -> {
            GL11.glTranslatef(-0.241f, -1.15f, -1.1f);
            GL11.glScaled(0.5199999809265137, 0.550000011920929, 0.8500000238418579);
        }).withCompatibleAttachment(AuxiliaryAttachments.FamasBipod1, true, model -> {
            GL11.glTranslatef(-0.05f, -1.2f, -2.5f);
            GL11.glScaled(1.0, 1.0, 0.8799999952316284);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(1.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(1.8f, 0.0f, 1.0f, 0.0f);
        }).withCompatibleAttachment(AuxiliaryAttachments.FamasBipod2, true, model -> {
            GL11.glTranslatef(-0.25f, -1.05f, -2.5f);
            GL11.glScaled(1.0, 1.0, 0.8799999952316284);
            GL11.glRotatef(200.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-0.8f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(1.5f, 0.0f, 1.0f, 0.0f);
        }).withCompatibleAttachment(AuxiliaryAttachments.FamasAction, true, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.AKRail, true, model -> {
            GL11.glTranslatef(-0.215f, -1.9f, -3.0f);
            GL11.glScaled(0.699999988079071, 1.2000000476837158, 1.25);
        }).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(-0.3f, -1.5f, -0.3f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(0.255f, -1.55f, -2.25f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof P90iron) {
                GL11.glTranslatef(0.26f, -1.55f, -2.35f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AKMiron1) {
                GL11.glTranslatef(0.125f, -1.8f, -0.5f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AKMiron2) {
                GL11.glTranslatef(-0.155f, -1.925f, -3.0f);
                GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.699999988079071);
            }
            else if (model instanceof AK47iron) {
                GL11.glTranslatef(-0.23f, -2.22f, -0.17f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.30000001192092896);
            }
            else if (model instanceof G36CIron1) {
                GL11.glTranslatef(-0.22f, -1.94f, 0.13f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof G36CIron2) {
                GL11.glTranslatef(-0.205f, -2.5f, -3.15f);
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
                GL11.glTranslatef(0.127f, -1.77f, -2.22f);
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
        }).withCompatibleAttachment(Attachments.ACOG, (player, stack) -> {
            GL11.glTranslatef(-0.297f, -2.0f, -0.7f);
            GL11.glScaled(0.75, 0.75, 0.75);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Specter, (player, stack) -> {
            GL11.glTranslatef(-0.195f, -1.65f, -0.7f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.15f, -1.035f, 1.513f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.07f, -1.825f, -1.1f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.12f, -2.11f, -0.9f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.05f, -1.85f, -0.8f);
                GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.12f, -2.11f, -0.9f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.05f, -1.85f, -0.8f);
                GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.12f, -2.11f, -0.9f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.05f, -1.85f, -0.8f);
                GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.12f, -2.11f, -0.9f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Silencer556x45, model -> {
            GL11.glTranslatef(-0.2f, -1.11f, -5.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("AK12").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new FamasF1()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glTranslatef(1.0f, 0.8f, 0.0f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glTranslatef(-0.3f, 0.7f, -0.8f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glTranslatef(-0.3f, 0.7f, -0.4f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glTranslatef(-0.795f, 2.1f, -2.3f);
            GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.005f, 0.275f, 1.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.005f, 0.25f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.005f, -0.04f, 5.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.005f, -0.04f, 5.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.2f, 0.28f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.19f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.19f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.14f, 2.8f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(Magazines.NATOFamasMag, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AKRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.AKRail.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.AKRail.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonCustomPositioning(AuxiliaryAttachments.FamasCarryHandle.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonCustomPositioning(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonCustomPositioning(AuxiliaryAttachments.FamasAction.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.FamasCarryHandle.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.FamasCarryHandle.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATOFamasMag.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATOFamasMag.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.FamasAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.FamasAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
        }, 300L, 60L), new Transition(renderContext -> {
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
        }, 400L, 200L), new Transition(renderContext -> {
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.175f, -0.1f, -0.125f);
        }, 400L, 100L), new Transition(renderContext -> {
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.175f, -0.1f, -0.125f);
        }, 150L, 100L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.NATOFamasMag, new Transition(renderContext -> {
            GL11.glTranslatef(0.2f, 0.5f, -0.2f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.2f, 0.9f, -0.2f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATOFamasMag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.FamasCarryHandle.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.FamasCarryHandle.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AKRail.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AKRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.FamasAction.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.FamasAction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f), 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glTranslatef(-0.795f, 2.1f, -2.5f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.005f, 0.275f, 1.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.005f, 0.25f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.005f, -0.04f, 5.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.005f, -0.04f, 5.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.2f, 0.28f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.19f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.19f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.14f, 2.8f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.925f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.85f, 0.575f, -0.5f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.475f, -0.225f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.5f, 0.12f);
        }).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.475f, -0.225f);
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
            GL11.glTranslatef(0.2f, -0.8f, 0.15f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.5f, 0.12f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.4f, 0.5f, 1.4f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.4f, 0.5f, 1.4f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-125.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.125f, -0.575f, 0.075f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-130.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.25f, -0.6f, -0.075f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.4f, -0.5f, 0.12f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.4f, -0.5f, 0.12f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.5f, 0.12f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.5f, 0.12f);
        }, 250L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.4f, 0.5f, 1.4f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.4f, 0.5f, 1.4f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.4f, -0.5f, 0.12f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.4f, -0.5f, 0.12f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.0f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$2685(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2684(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2683(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 1.4f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2682(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 1.4f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2681(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2680(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2679(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2678(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2677(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-130.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.25f, -0.6f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$2676(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-125.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.125f, -0.575f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$2675(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 1.4f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2674(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 1.4f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2673(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2672(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.2f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$2671(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.33f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2670(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.475f, -0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$2669(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2668(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.475f, -0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$2667(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.85f, 0.575f, -0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$2666(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.925f);
    }
    
    private static /* synthetic */ void lambda$createGun$2665(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glTranslatef(-0.795f, 2.1f, -2.5f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.005f, 0.275f, 1.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.005f, 0.25f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.005f, -0.04f, 5.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.005f, -0.04f, 5.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.2f, 0.28f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.19f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.19f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.14f, 2.8f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2664(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2663(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2662(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2661(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2660(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2659(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2658(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2657(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2656(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2655(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2654(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2653(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2652(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2651(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2650(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2649(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2648(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2647(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2646(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2645(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2644(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2643(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2642(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2641(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2640(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2639(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2638(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2637(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2636(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2635(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2634(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2633(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2632(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2631(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2630(final Object renderContext) {
        GL11.glTranslatef(0.2f, 0.9f, -0.2f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2629(final Object renderContext) {
        GL11.glTranslatef(0.2f, 0.5f, -0.2f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2628(final Object renderContext) {
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
    }
    
    private static /* synthetic */ void lambda$createGun$2627(final Object renderContext) {
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
    }
    
    private static /* synthetic */ void lambda$createGun$2626(final Object renderContext) {
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.175f, -0.1f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$2625(final Object renderContext) {
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.175f, -0.1f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$2624(final Object renderContext) {
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
    }
    
    private static /* synthetic */ void lambda$createGun$2623(final Object renderContext) {
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
    }
    
    private static /* synthetic */ void lambda$createGun$2622(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2621(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2620(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2619(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2618(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2617(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2616(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2615(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2614(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2613(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2612(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2611(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2610(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2609(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2608(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2607(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2606(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2605(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2604(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glTranslatef(-0.795f, 2.1f, -2.3f);
        GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.005f, 0.275f, 1.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.005f, 0.25f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.005f, -0.04f, 5.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.005f, -0.04f, 5.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.2f, 0.28f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.19f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.19f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.14f, 2.8f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2603(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glTranslatef(-0.3f, 0.7f, -0.4f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2602(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glTranslatef(-0.3f, 0.7f, -0.8f);
    }
    
    private static /* synthetic */ void lambda$createGun$2601(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2600(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(1.0f, 0.8f, 0.0f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2599(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2598(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.11f, -5.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$2597(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.05f, -1.85f, -0.8f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -2.11f, -0.9f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2596(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.05f, -1.85f, -0.8f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -2.11f, -0.9f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2595(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.05f, -1.85f, -0.8f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -2.11f, -0.9f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2594(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.07f, -1.825f, -1.1f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -2.11f, -0.9f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2593(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2592(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.195f, -1.65f, -0.7f);
        GL11.glScaled(0.5, 0.5, 0.5);
    }
    
    private static /* synthetic */ void lambda$createGun$2591(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2590(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.297f, -2.0f, -0.7f);
        GL11.glScaled(0.75, 0.75, 0.75);
    }
    
    private static /* synthetic */ void lambda$createGun$2589(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(-0.3f, -1.5f, -0.3f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(0.255f, -1.55f, -2.25f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof P90iron) {
            GL11.glTranslatef(0.26f, -1.55f, -2.35f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AKMiron1) {
            GL11.glTranslatef(0.125f, -1.8f, -0.5f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AKMiron2) {
            GL11.glTranslatef(-0.155f, -1.925f, -3.0f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.699999988079071);
        }
        else if (model instanceof AK47iron) {
            GL11.glTranslatef(-0.23f, -2.22f, -0.17f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.30000001192092896);
        }
        else if (model instanceof G36CIron1) {
            GL11.glTranslatef(-0.22f, -1.94f, 0.13f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof G36CIron2) {
            GL11.glTranslatef(-0.205f, -2.5f, -3.15f);
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
            GL11.glTranslatef(0.127f, -1.77f, -2.22f);
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
    
    private static /* synthetic */ void lambda$createGun$2588(final ModelBase model) {
        GL11.glTranslatef(-0.215f, -1.9f, -3.0f);
        GL11.glScaled(0.699999988079071, 1.2000000476837158, 1.25);
    }
    
    private static /* synthetic */ void lambda$createGun$2587(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$2586(final ModelBase model) {
        GL11.glTranslatef(-0.25f, -1.05f, -2.5f);
        GL11.glScaled(1.0, 1.0, 0.8799999952316284);
        GL11.glRotatef(200.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-0.8f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(1.5f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2585(final ModelBase model) {
        GL11.glTranslatef(-0.05f, -1.2f, -2.5f);
        GL11.glScaled(1.0, 1.0, 0.8799999952316284);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(1.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(1.8f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2584(final ModelBase model) {
        GL11.glTranslatef(-0.241f, -1.15f, -1.1f);
        GL11.glScaled(0.5199999809265137, 0.550000011920929, 0.8500000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$2583(final ModelBase model) {
        GL11.glTranslatef(-0.355f, 0.9f, 1.65f);
        GL11.glScaled(1.2000000476837158, 1.5, 1.5);
    }
    
    private static /* synthetic */ void lambda$createGun$2582(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2581(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$2580(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2579(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$2578(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2577(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$2576(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2575(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$2574(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2573(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Voltaic.getTextureVariantIndex("voltaic"));
    }
    
    private static /* synthetic */ List lambda$createGun$2572(final ItemStack stack) {
        return Arrays.asList("Type: Bullpup assault rifle", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine (Type 2)", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$2571() {
        return 0.12f;
    }
    
    private static /* synthetic */ Float lambda$createGun$2570() {
        return 0.11f;
    }
    
    private static /* synthetic */ Float lambda$createGun$2569() {
        return 0.8f;
    }
}
