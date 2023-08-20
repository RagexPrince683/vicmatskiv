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

public class FamasFactory implements GunFactory
{
    public FamasFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("Famas").withFireRate(0.75f).withRecoil(3.5f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("Famas").withSilencedShootSound("RifleSilencer").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(50L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(0.8f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.12f).withShellCasingForwardOffset(-0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Bullpup assault rifle", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine (Type 2)", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.Voltaic, (a, i) -> i.setActiveTextureIndex(GunSkins.Voltaic.getTextureVariantIndex("voltaic")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(Magazines.NATOFamasMag, model -> {
            GL11.glTranslatef(-0.355f, 0.9f, 1.6f);
            GL11.glScaled(1.2000000476837158, 1.5, 1.5);
        }).withCompatibleAttachment(AuxiliaryAttachments.FelinCarryHandle, true, model -> {
            GL11.glTranslatef(-0.02f, -0.81f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.8999999761581421, 0.949999988079071);
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
        }).withCompatibleAttachment(AuxiliaryAttachments.FelinAction, true, model -> {
            GL11.glTranslatef(-0.02f, -0.81f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.8999999761581421, 0.949999988079071);
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
                GL11.glTranslatef(-0.155f, -1.63f, -2.35f);
                GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.699999988079071);
            }
            else if (model instanceof AK47iron) {
                GL11.glTranslatef(-0.23f, -1.92f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.20000000298023224);
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
            GL11.glTranslatef(-0.286f, -1.72f, -0.4f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Specter, (player, stack) -> {
            GL11.glTranslatef(-0.2f, -1.33f, -0.8f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.15f, -1.035f, 1.513f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.062f, -1.543f, -0.8f);
                GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.118f, -1.87f, -0.9f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.047f, -1.57f, -0.7f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.118f, -1.87f, -0.9f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.047f, -1.57f, -0.7f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.118f, -1.87f, -0.9f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.047f, -1.57f, -0.7f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.118f, -1.87f, -0.9f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Silencer556x45, model -> {
            GL11.glTranslatef(-0.2f, -1.11f, -5.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("AK12").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new Felin()).withEntityPositioning(itemStack -> {
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
            GL11.glTranslatef(-0.795f, 1.81f, -2.4f);
            GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.005f, 0.27f, 0.75f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.0f, 0.28f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.005f, -0.04f, 5.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.005f, -0.04f, 5.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.28f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.1f, 2.6f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(Magazines.NATOFamasMag, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.FelinCarryHandle.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonCustomPositioning(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonCustomPositioning(AuxiliaryAttachments.FelinAction.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.FelinCarryHandle.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.FelinCarryHandle.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATOFamasMag.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATOFamasMag.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.FelinAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.FelinAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
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
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATOFamasMag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.FelinCarryHandle.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.FelinCarryHandle.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.FelinAction.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.FelinAction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f), 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.FamasBipod1.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.FamasBipod2.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glTranslatef(-0.795f, 1.81f, -2.5f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.005f, 0.27f, 0.75f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.0f, 0.28f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.005f, -0.04f, 5.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.005f, -0.04f, 5.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.28f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.1f, 2.6f);
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
    
    private static /* synthetic */ void lambda$createGun$2790(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2789(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2788(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 1.4f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2787(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 1.4f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2786(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2785(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2784(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2783(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.4f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2782(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-130.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.25f, -0.6f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$2781(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-125.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.125f, -0.575f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$2780(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 1.4f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2779(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 1.4f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2778(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2777(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.2f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$2776(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.33f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2775(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.475f, -0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$2774(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.5f, 0.12f);
    }
    
    private static /* synthetic */ void lambda$createGun$2773(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.475f, -0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$2772(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.85f, 0.575f, -0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$2771(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.925f);
    }
    
    private static /* synthetic */ void lambda$createGun$2770(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glTranslatef(-0.795f, 1.81f, -2.5f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.005f, 0.27f, 0.75f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.0f, 0.28f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.005f, -0.04f, 5.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.005f, -0.04f, 5.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.28f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.1f, 2.6f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2769(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2768(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2767(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2766(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2765(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2764(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2763(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2762(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2761(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2760(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2759(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2758(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2757(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$2756(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2755(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2754(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2753(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2752(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2751(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2750(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2749(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2748(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2747(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2746(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2745(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2744(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2743(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2742(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2741(final Object renderContext) {
        GL11.glTranslatef(0.2f, 0.9f, -0.2f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2740(final Object renderContext) {
        GL11.glTranslatef(0.2f, 0.5f, -0.2f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2739(final Object renderContext) {
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
    }
    
    private static /* synthetic */ void lambda$createGun$2738(final Object renderContext) {
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
    }
    
    private static /* synthetic */ void lambda$createGun$2737(final Object renderContext) {
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.175f, -0.1f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$2736(final Object renderContext) {
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.175f, -0.1f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$2735(final Object renderContext) {
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
    }
    
    private static /* synthetic */ void lambda$createGun$2734(final Object renderContext) {
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, -0.475f, -1.749999f);
    }
    
    private static /* synthetic */ void lambda$createGun$2733(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$2732(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$2731(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2730(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2729(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2728(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2727(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2726(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2725(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2724(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2723(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2722(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2721(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2720(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2719(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2718(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glTranslatef(-0.795f, 1.81f, -2.4f);
        GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.005f, 0.27f, 0.75f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.0f, 0.28f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.005f, -0.04f, 5.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.005f, -0.04f, 5.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.28f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.1f, 2.6f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2717(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glTranslatef(-0.3f, 0.7f, -0.4f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2716(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glTranslatef(-0.3f, 0.7f, -0.8f);
    }
    
    private static /* synthetic */ void lambda$createGun$2715(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2714(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(1.0f, 0.8f, 0.0f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2713(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2712(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.11f, -5.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$2711(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.047f, -1.57f, -0.7f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.118f, -1.87f, -0.9f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2710(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.047f, -1.57f, -0.7f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.118f, -1.87f, -0.9f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2709(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.047f, -1.57f, -0.7f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.118f, -1.87f, -0.9f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2708(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.062f, -1.543f, -0.8f);
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.118f, -1.87f, -0.9f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2707(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2706(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.2f, -1.33f, -0.8f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$2705(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2704(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.286f, -1.72f, -0.4f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$2703(final ModelBase model) {
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
            GL11.glTranslatef(-0.155f, -1.63f, -2.35f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.699999988079071);
        }
        else if (model instanceof AK47iron) {
            GL11.glTranslatef(-0.23f, -1.92f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.20000000298023224);
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
    
    private static /* synthetic */ void lambda$createGun$2702(final ModelBase model) {
        GL11.glTranslatef(-0.02f, -0.81f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.8999999761581421, 0.949999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$2701(final ModelBase model) {
        GL11.glTranslatef(-0.25f, -1.05f, -2.5f);
        GL11.glScaled(1.0, 1.0, 0.8799999952316284);
        GL11.glRotatef(200.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-0.8f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(1.5f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2700(final ModelBase model) {
        GL11.glTranslatef(-0.05f, -1.2f, -2.5f);
        GL11.glScaled(1.0, 1.0, 0.8799999952316284);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(1.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(1.8f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2699(final ModelBase model) {
        GL11.glTranslatef(-0.02f, -0.81f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.8999999761581421, 0.949999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$2698(final ModelBase model) {
        GL11.glTranslatef(-0.355f, 0.9f, 1.6f);
        GL11.glScaled(1.2000000476837158, 1.5, 1.5);
    }
    
    private static /* synthetic */ void lambda$createGun$2697(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2696(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$2695(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2694(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$2693(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2692(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$2691(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2690(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Voltaic.getTextureVariantIndex("voltaic"));
    }
    
    private static /* synthetic */ List lambda$createGun$2689(final ItemStack stack) {
        return Arrays.asList("Type: Bullpup assault rifle", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine (Type 2)", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$2688() {
        return 0.12f;
    }
    
    private static /* synthetic */ Float lambda$createGun$2687() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$2686() {
        return 0.8f;
    }
}
