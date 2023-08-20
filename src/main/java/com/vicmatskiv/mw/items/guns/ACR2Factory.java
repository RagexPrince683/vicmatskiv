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

public class ACR2Factory implements GunFactory
{
    public ACR2Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("ACR").withFireRate(0.7f).withRecoil(3.5f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("acr").withSilencedShootSound("AR15Silenced").withReloadSound("NoBoltReload").withUnloadSound("m4unload").withReloadingTime(30L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.15f).withFlashOffsetY(() -> 0.1f).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withInformationProvider(stack -> Arrays.asList("Type: Assault rifle", "Damage: 7.2", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine", "20rnd 5.56x45mm NATO Magazine", "40rnd 5.56x45mm NATO Magazine", "30rnd 5.56x45mm NATO PMAG Magazine", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Arctic, (a, i) -> i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(Magazines.NATOMag1, model -> {
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
        }).withCompatibleAttachment(AuxiliaryAttachments.RemingtonACRRail, true, model -> {
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
        }).withCompatibleAttachment(AuxiliaryAttachments.RemingtonACRAction, true, model -> {
            if (model instanceof ACRAction) {
                GL11.glTranslatef(-0.06f, -1.4f, -2.9f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.5);
            }
            else if (model instanceof ACRAction2) {}
        }).withTextureNames("ACR").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new BushmasterACR()).withEntityPositioning(itemStack -> {
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
        }).withFirstPersonCustomPositioning(Magazines.NATOMag1, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATOMag1.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATOMag1.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATO20rnd, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATO20rnd.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATO20rnd.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATO40rnd, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATO40rnd.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATO40rnd.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATOMag2, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATOMag2.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATOMag2.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATODrum100, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATODrum100.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATODrum100.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.RemingtonACRRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.RemingtonACRRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.RemingtonACRRail.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.RemingtonACRAction.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.RemingtonACRAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.9f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.RemingtonACRAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.9f)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
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
        }, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.RemingtonACRRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.RemingtonACRRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.RemingtonACRAction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.RemingtonACRAction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
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
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.2f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$464(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$463(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$462(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.725f, 0.575f);
    }
    
    private static /* synthetic */ void lambda$createGun$461(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.75f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$460(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$459(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$458(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.75f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$457(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.725f, 0.575f);
    }
    
    private static /* synthetic */ void lambda$createGun$456(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$455(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$454(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.13f, 0.26f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$453(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$452(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.625f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$451(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.3f, 0.95f, -0.55f);
    }
    
    private static /* synthetic */ void lambda$createGun$450(final RenderContext renderContext) {
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
    
    private static /* synthetic */ void lambda$createGun$449(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$448(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$447(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$446(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$445(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$444(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$443(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$442(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$441(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$440(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$439(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$438(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$437(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$436(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$435(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$434(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$433(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$432(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$431(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$430(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$429(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$428(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$427(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$426(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$425(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$424(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$423(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.2f, 0.2f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$422(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$421(final Object renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$420(final Object renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$419(final Object renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$418(final Object renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.274999f, 0.5f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$417(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$416(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$415(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$414(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$413(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$412(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$411(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$410(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$409(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$408(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$407(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$406(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$405(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$404(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$403(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$402(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$401(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$400(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$399(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$398(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$397(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$396(final RenderContext renderContext) {
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
    
    private static /* synthetic */ void lambda$createGun$395(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.4f, 0.825f, 0.2f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$394(final RenderContext renderContext) {
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.4f, 0.825f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$393(final RenderContext renderContext) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-1.7f, -0.8f, 1.9f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$392(final ItemStack itemStack) {
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$391(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$390(final ModelBase model) {
        if (model instanceof ACRAction) {
            GL11.glTranslatef(-0.06f, -1.4f, -2.9f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.5);
        }
        else if (model instanceof ACRAction2) {}
    }
    
    private static /* synthetic */ void lambda$createGun$389(final ModelBase model) {
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
    
    private static /* synthetic */ void lambda$createGun$388(final ModelBase model) {
        GL11.glTranslatef(-0.19f, -1.205f, -6.8f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$createGun$387(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.08f, -1.15f, -3.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$386(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.08f, -1.15f, -3.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$385(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.35f, -3.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$384(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$383(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.3f, -2.95f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$382(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$381(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.4f, -2.7f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$380(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.05f, -1.48f, -0.8f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.78f, -0.8f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$379(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.05f, -1.48f, -0.8f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.78f, -0.8f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$378(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.055f, -1.49f, -0.8f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -1.69f, -1.4f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$377(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.07f, -1.45f, -0.8f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -1.7f, -0.94f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$376(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$375(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.312f, -1.6f, -0.65f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$374(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$373(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.182f, -1.32f, -0.6f);
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
    }
    
    private static /* synthetic */ void lambda$createGun$372(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$371(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.288f, -1.625f, -0.5f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$370(final ModelBase model) {
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
    
    private static /* synthetic */ void lambda$createGun$369(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$368(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$367(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$366(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$365(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.3f, -1.31f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$364(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$363(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$362(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$361(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$360(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$359(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$358(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$357(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$356(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$355(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic"));
    }
    
    private static /* synthetic */ void lambda$createGun$354(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$353(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$352(final ItemStack stack) {
        return Arrays.asList("Type: Assault rifle", "Damage: 7.2", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine", "20rnd 5.56x45mm NATO Magazine", "40rnd 5.56x45mm NATO Magazine", "30rnd 5.56x45mm NATO PMAG Magazine", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$351() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$350() {
        return 0.15f;
    }
    
    private static /* synthetic */ Float lambda$createGun$349() {
        return 0.8f;
    }
}
