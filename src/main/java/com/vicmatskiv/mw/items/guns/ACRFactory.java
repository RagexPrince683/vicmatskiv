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

public class ACRFactory implements GunFactory
{
    public ACRFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("ACRTac").withFireRate(0.7f).withRecoil(3.5f).withZoom(0.9f).withMaxShots(1).withShootSound("acr").withSilencedShootSound("AR15Silenced").withReloadSound("NoBoltReload").withUnloadSound("m4unload").withReloadingTime(30L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.15f).withFlashOffsetY(() -> 0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Assault rifle", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine", "20rnd 5.56x45mm NATO Magazine", "40rnd 5.56x45mm NATO Magazine", "30rnd 5.56x45mm NATO PMAG Magazine", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Amber, (a, i) -> i.setActiveTextureIndex(GunSkins.Amber.getTextureVariantIndex("Amber")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Arctic, (a, i) -> i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(Magazines.NATOMag1, model -> {
            GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
        }).withCompatibleAttachment(Magazines.NATOMag2, model -> {
            GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
        }).withCompatibleAttachment(Magazines.NATO20rnd, model -> {
            GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
        }).withCompatibleAttachment(Magazines.NATO40rnd, model -> {
            GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
        }).withCompatibleAttachment(Magazines.NATODrum100, model -> {
            GL11.glTranslatef(-0.35f, 0.5f, -1.31f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
        }).withCompatibleAttachment(Attachments.AKMIron, true, model -> {
            if (model instanceof ScarIron1) {
                GL11.glTranslatef(0.165f, -1.65f, 1.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof ScarIron2) {
                GL11.glTranslatef(0.24f, -1.56f, -1.7f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AKMiron1) {
                GL11.glTranslatef(0.14f, -1.566f, 0.3f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AKMiron2) {
                GL11.glTranslatef(0.13f, -1.39f, -2.8f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AK47iron) {
                GL11.glTranslatef(-0.22f, -2.08f, -3.7f);
                GL11.glScaled(0.6499999761581421, 1.100000023841858, 0.20000000298023224);
            }
            else if (model instanceof M4Iron1) {
                GL11.glTranslatef(-0.162f, -1.665f, -0.3f);
                GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(0.26f, -1.8f, -2.35f);
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
            else if (model instanceof FALIron) {
                GL11.glTranslatef(-0.173f, -1.7f, -3.72f);
                GL11.glScaled(0.5, 0.5, 0.8500000238418579);
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
            GL11.glTranslatef(-0.288f, -1.625f, -0.5f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Specter, (player, stack) -> {
            GL11.glTranslatef(-0.182f, -1.32f, -0.6f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.15f, -1.035f, 1.513f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Scope, (player, stack) -> {
            GL11.glTranslatef(-0.312f, -1.6f, -0.65f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.272f, 0.67f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.07f, -1.45f, -0.8f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.12f, -1.7f, -0.94f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.055f, -1.49f, -0.8f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.12f, -1.69f, -1.4f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.05f, -1.48f, -0.8f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.12f, -1.78f, -0.8f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.05f, -1.48f, -0.8f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.12f, -1.78f, -0.8f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Grip2, model -> {
            GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.StubbyGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Grip, model -> {
            GL11.glTranslatef(-0.2f, -0.3f, -2.95f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.VGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Bipod, model -> {
            GL11.glTranslatef(-0.2f, -0.35f, -3.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Laser2, (p, s) -> {
            GL11.glTranslatef(0.08f, -1.15f, -3.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.Laser, (p, s) -> {
            GL11.glTranslatef(0.08f, -1.15f, -3.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.Silencer556x45, model -> {
            GL11.glTranslatef(-0.19f, -1.205f, -6.8f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        }).withCompatibleAttachment(AuxiliaryAttachments.BushmasterACRRail, true, model -> {
            if (model instanceof AKRail) {
                GL11.glTranslatef(0.19f, -1.15f, -3.9f);
                GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.800000011920929);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            }
            else if (model instanceof AKRail2) {
                GL11.glTranslatef(-0.43f, -0.93f, -3.92f);
                GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.800000011920929);
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
            }
            else if (model instanceof AKRail3) {
                GL11.glTranslatef(-0.03f, -0.77f, -3.94f);
                GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.75);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            }
            else if (model instanceof AKRail4) {
                GL11.glTranslatef(-0.226f, -1.52f, -3.9f);
                GL11.glScaled(0.7599999904632568, 0.8700000047683716, 0.800000011920929);
            }
            else if (model instanceof AKRail5) {
                GL11.glTranslatef(-0.226f, -1.52f, -2.0f);
                GL11.glScaled(0.7599999904632568, 0.8700000047683716, 0.800000011920929);
            }
        }).withCompatibleAttachment(AuxiliaryAttachments.BushmasterACRAction, true, model -> {
            if (model instanceof ACRAction) {
                GL11.glTranslatef(-0.06f, -1.4f, -2.9f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.5);
            }
            else if (model instanceof ACRAction2) {}
        }).withTextureNames("AK12").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new BushmasterACR()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            GL11.glTranslatef(1.0f, 2.0f, -1.2f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-1.7f, -0.8f, 1.9f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-0.4f, 0.825f, -0.15f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-0.4f, 0.825f, 0.2f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glTranslatef(-0.905f, 2.2f, -2.3f);
            GL11.glRotatef(-0.8f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.0f, 0.08f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.0f, 0.01f, 0.25f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.085f, 0.45f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.0f, 0.035f, 0.25f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(-0.01f, 0.02f, 0.4f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.06f, 0.2f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.059f, 0.2f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, 0.01f, 0.4f);
            }
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }).withFirstPersonCustomPositioning(Magazines.NATOMag1, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATOMag1.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATOMag1.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATO20rnd, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATO20rnd.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATO20rnd.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATO40rnd, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATO40rnd.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATO40rnd.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATOMag2, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATOMag2.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATOMag2.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATODrum100, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATODrum100.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATODrum100.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.BushmasterACRRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.BushmasterACRRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.BushmasterACRRail.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.BushmasterACRAction.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.BushmasterACRAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.9f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.BushmasterACRAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.9f)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
        }, 250L, 300L), new Transition(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
        }, 250L, 20L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.NATOMag1, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATO40rnd, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATO20rnd, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATOMag1, new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATO40rnd, new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATO20rnd, new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATOMag2, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATOMag2, new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATODrum100, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATODrum100, new Transition(renderContext -> {
            GL11.glTranslatef(0.05f, 1.2f, 0.2f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.BushmasterACRRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.BushmasterACRRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.BushmasterACRAction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.BushmasterACRAction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glTranslatef(-0.905f, 2.2f, -2.5f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.0f, 0.08f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.0f, 0.01f, 0.4f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.085f, 0.6f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.0f, 0.035f, 0.25f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(-0.01f, 0.02f, 0.4f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.06f, 0.2f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.059f, 0.2f);
            }
            else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, 0.01f, 0.4f);
            }
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.3f, 0.95f, -0.55f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(2.0, 2.0, 2.0);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.625f, 0.3f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.48f, 0.08f, -0.05f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.375f, -0.8f, 0.15f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.225f, -0.725f, 0.575f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 2.5f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.125f, -0.75f, 0.5f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 2.5f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.125f, -0.75f, 0.5f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.225f, -0.725f, 0.575f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.0f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$584(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$583(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$582(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.725f, 0.575f);
    }
    
    private static /* synthetic */ void lambda$createGun$581(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.75f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$580(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$579(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$578(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.75f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$577(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.725f, 0.575f);
    }
    
    private static /* synthetic */ void lambda$createGun$576(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$575(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$574(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$573(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$572(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.625f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$571(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.3f, 0.95f, -0.55f);
    }
    
    private static /* synthetic */ void lambda$createGun$570(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glTranslatef(-0.905f, 2.2f, -2.5f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.0f, 0.08f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.0f, 0.01f, 0.4f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.085f, 0.6f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.0f, 0.035f, 0.25f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(-0.01f, 0.02f, 0.4f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.06f, 0.2f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.059f, 0.2f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, 0.01f, 0.4f);
        }
        GL11.glTranslatef(1.373f, -1.34f, 2.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$569(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$568(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$567(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$566(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$565(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$564(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$563(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$562(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$561(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$560(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$559(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$558(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$557(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$556(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$555(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$554(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$553(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$552(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$551(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$550(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$549(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$548(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$547(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$546(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$545(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$544(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$543(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$542(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$541(final Object renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$540(final Object renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$539(final Object renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$538(final Object renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$537(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$536(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$535(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$534(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$533(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$532(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$531(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$530(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$529(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$528(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$527(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$526(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$525(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$524(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$523(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$522(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$521(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$520(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$519(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$518(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$517(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$516(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glTranslatef(-0.905f, 2.2f, -2.3f);
        GL11.glRotatef(-0.8f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.0f, 0.08f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.0f, 0.01f, 0.25f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.085f, 0.45f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.0f, 0.035f, 0.25f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(-0.01f, 0.02f, 0.4f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.06f, 0.2f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.059f, 0.2f);
        }
        else if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, 0.01f, 0.4f);
        }
        GL11.glTranslatef(1.373f, -1.34f, 2.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$515(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.4f, 0.825f, 0.2f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$514(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.4f, 0.825f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$513(final RenderContext renderContext) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-1.7f, -0.8f, 1.9f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$512(final ItemStack itemStack) {
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$511(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$510(final ModelBase model) {
        if (model instanceof ACRAction) {
            GL11.glTranslatef(-0.06f, -1.4f, -2.9f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.5);
        }
        else if (model instanceof ACRAction2) {}
    }
    
    private static /* synthetic */ void lambda$createGun$509(final ModelBase model) {
        if (model instanceof AKRail) {
            GL11.glTranslatef(0.19f, -1.15f, -3.9f);
            GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.800000011920929);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        }
        else if (model instanceof AKRail2) {
            GL11.glTranslatef(-0.43f, -0.93f, -3.92f);
            GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.800000011920929);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        }
        else if (model instanceof AKRail3) {
            GL11.glTranslatef(-0.03f, -0.77f, -3.94f);
            GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.75);
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        }
        else if (model instanceof AKRail4) {
            GL11.glTranslatef(-0.226f, -1.52f, -3.9f);
            GL11.glScaled(0.7599999904632568, 0.8700000047683716, 0.800000011920929);
        }
        else if (model instanceof AKRail5) {
            GL11.glTranslatef(-0.226f, -1.52f, -2.0f);
            GL11.glScaled(0.7599999904632568, 0.8700000047683716, 0.800000011920929);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$508(final ModelBase model) {
        GL11.glTranslatef(-0.19f, -1.205f, -6.8f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$createGun$507(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.08f, -1.15f, -3.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$506(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.08f, -1.15f, -3.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$505(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.35f, -3.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$504(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$503(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.3f, -2.95f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$502(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$501(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$500(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.05f, -1.48f, -0.8f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.78f, -0.8f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$499(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.05f, -1.48f, -0.8f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.78f, -0.8f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$498(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.055f, -1.49f, -0.8f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -1.69f, -1.4f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$497(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.07f, -1.45f, -0.8f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -1.7f, -0.94f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$496(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$495(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.312f, -1.6f, -0.65f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$494(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$493(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.182f, -1.32f, -0.6f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$createGun$492(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$491(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.288f, -1.625f, -0.5f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$490(final ModelBase model) {
        if (model instanceof ScarIron1) {
            GL11.glTranslatef(0.165f, -1.65f, 1.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof ScarIron2) {
            GL11.glTranslatef(0.24f, -1.56f, -1.7f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AKMiron1) {
            GL11.glTranslatef(0.14f, -1.566f, 0.3f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AKMiron2) {
            GL11.glTranslatef(0.13f, -1.39f, -2.8f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AK47iron) {
            GL11.glTranslatef(-0.22f, -2.08f, -3.7f);
            GL11.glScaled(0.6499999761581421, 1.100000023841858, 0.20000000298023224);
        }
        else if (model instanceof M4Iron1) {
            GL11.glTranslatef(-0.162f, -1.665f, -0.3f);
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(0.26f, -1.8f, -2.35f);
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
        else if (model instanceof FALIron) {
            GL11.glTranslatef(-0.173f, -1.7f, -3.72f);
            GL11.glScaled(0.5, 0.5, 0.8500000238418579);
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
    
    private static /* synthetic */ void lambda$createGun$489(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$488(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$487(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$486(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$485(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$484(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$483(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$482(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$481(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$480(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$479(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$478(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$477(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$476(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$475(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic"));
    }
    
    private static /* synthetic */ void lambda$createGun$474(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$473(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Amber.getTextureVariantIndex("Amber"));
    }
    
    private static /* synthetic */ void lambda$createGun$472(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$471(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$470(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$469(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$468(final ItemStack stack) {
        return Arrays.asList("Type: Assault rifle", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine", "20rnd 5.56x45mm NATO Magazine", "40rnd 5.56x45mm NATO Magazine", "30rnd 5.56x45mm NATO PMAG Magazine", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$467() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$466() {
        return 0.15f;
    }
    
    private static /* synthetic */ Float lambda$createGun$465() {
        return 0.8f;
    }
}
