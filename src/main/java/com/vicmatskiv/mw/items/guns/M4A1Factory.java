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

public class M4A1Factory implements GunFactory
{
    public M4A1Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("M4A1").withFireRate(0.7f).withRecoil(3.5f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("M4A1").withSilencedShootSound("ar15silenced").withReloadSound("m4reload").withUnloadSound("m4unload").withReloadingTime(50L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Carbine", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine", "20rnd 5.56x45mm NATO Magazine", "40rnd 5.56x45mm NATO Magazine", "30rnd 5.56x45mm NATO PMAG Magazine", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Desert, (a, i) -> i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Arctic, (a, i) -> i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic")), (a, i) -> {}).withCompatibleAttachment(Magazines.NATOMag1, model -> {
            GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
        }).withCompatibleAttachment(Magazines.NATO40rnd, model -> {
            GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
        }).withCompatibleAttachment(Magazines.NATO20rnd, model -> {
            GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
        }).withCompatibleAttachment(Magazines.NATOMag2, model -> {
            GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
        }).withCompatibleAttachment(Magazines.NATODrum100, model -> {
            GL11.glTranslatef(-0.35f, 0.69f, -1.25f);
            GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
        }).withCompatibleAttachment(AuxiliaryAttachments.AR15Action, true, model -> {
            GL11.glTranslatef(-0.175f, -1.28f, -0.67f);
            GL11.glScaled(0.699999988079071, 0.4000000059604645, 0.699999988079071);
        }).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(0.162f, -1.75f, 1.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(-0.055f, -1.35f, -4.05f);
                GL11.glScaled(0.800000011920929, 0.6800000071525574, 1.0);
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
                GL11.glTranslatef(0.13f, -1.55f, -3.05f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AK47iron) {
                GL11.glTranslatef(0.092f, -1.91f, -0.9f);
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
                GL11.glTranslatef(-0.185f, -1.53f, -4.05f);
                GL11.glScaled(0.550000011920929, 0.5, 1.0);
            }
            else if (model instanceof M14Iron) {
                GL11.glTranslatef(0.129f, -1.63f, -2.08f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(0.215f, -1.54f, 1.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withCompatibleAttachment(AuxiliaryAttachments.AR15Iron, true, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(-0.145f, -1.55f, -0.35f);
                GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(0.255f, -1.55f, -2.25f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof FALIron) {
                GL11.glTranslatef(0.127f, -1.77f, -2.22f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AR15CarryHandle) {
                GL11.glTranslatef(-0.063f, -1.07f, -0.43f);
                GL11.glScaled(0.3100000023841858, 0.44999998807907104, 0.5400000214576721);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(0.215f, -1.54f, 1.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withCompatibleAttachment(Attachments.AKMIron, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(-0.16f, -1.5f, -0.3f);
                GL11.glScaled(0.3499999940395355, 0.3799999952316284, 0.3499999940395355);
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
                GL11.glTranslatef(0.13f, -1.55f, -3.05f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AK47iron) {
                GL11.glTranslatef(0.092f, -1.91f, -0.9f);
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
            GL11.glTranslatef(-0.265f, -1.41f, -0.3f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Specter, (player, stack) -> {
            GL11.glTranslatef(-0.17f, -1.14f, -0.45f);
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.15f, -1.035f, 1.513f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Scope, (player, stack) -> {
            GL11.glTranslatef(-0.3f, -1.38f, -0.3f);
            GL11.glScaled(0.75, 0.75, 0.75);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.272f, 0.67f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.HP, (player, stack) -> {
            GL11.glTranslatef(-0.3f, -1.38f, -0.5f);
            GL11.glScaled(0.75, 0.75, 0.75);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.235f, 1.16f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.072f, -1.25f, -0.9f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.125f, -1.53f, -0.9f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
                GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.12f, -1.545f, -0.5f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
                GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.12f, -1.55f, -0.5f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
                GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.12f, -1.53f, -1.05f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(Attachments.Grip2, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.StubbyGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Grip, model -> {
            GL11.glTranslatef(-0.2f, -0.35f, -2.9f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.VGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Bipod, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Laser2, (p, s) -> {
            GL11.glTranslatef(0.05f, -1.18f, -3.2f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }).withCompatibleAttachment(Attachments.Laser, (p, s) -> {
            GL11.glTranslatef(0.05f, -1.18f, -3.2f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }).withCompatibleAttachment(Attachments.Silencer556x45, model -> {
            GL11.glTranslatef(-0.2f, -1.235f, -6.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("AK12").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new M4A1()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glTranslatef(1.0f, 2.0f, -1.2f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-1.7f, -0.8f, 1.9f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.225f, 0.95f, -0.3f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.225f, 0.95f, -0.1f);
            GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 1.0f, -0.4f);
            GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.001f, -0.005f, 0.67f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(-0.003f, -0.065f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.001f, 0.02f, 0.43f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.001f, 0.02f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, -0.02f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, -0.02f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, -0.015f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, -0.015f, 0.1f);
            }
        }).withFirstPersonCustomPositioning(Magazines.NATOMag1, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATO20rnd, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATO40rnd, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATOMag2, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATODrum100, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AR15Action.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
        }, 300L, 60L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
        }, 400L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
        }, 400L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
        }, 150L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
        }, 60L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
        }, 200L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.NATOMag1, new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AR15Action.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AR15Action.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.4f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATO40rnd, new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATO20rnd, new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATOMag1, new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATO40rnd, new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATO20rnd, new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATOMag2, new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATOMag2, new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATODrum100, new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATODrum100, new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 1.0f, -0.525f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.001f, -0.005f, 0.75f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {}
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(-0.003f, -0.065f, 0.55f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.001f, 0.02f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.001f, 0.02f, 0.25f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, -0.02f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, -0.02f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, -0.015f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, -0.015f, 0.1f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.2f, 1.0f, -0.1f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.75f, 0.675f, 0.25f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.48f, 0.08f, -0.05f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(2.2f, 2.2f, 2.2f);
            GL11.glTranslatef(1.0f, 0.4f, -0.4f);
            GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.0f, -0.1f, 0.6f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-75.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.1f, -0.55f, 0.475f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.48f, 0.08f, -0.05f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.48f, 0.08f, -0.05f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.48f, 0.08f, -0.05f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glRotatef(-215.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.6f, -0.25f, -0.125f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glRotatef(-230.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.675f, -0.25f, -0.2f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glRotatef(-215.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.6f, -0.25f, -0.125f);
        }, 250L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-75.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.1f, -0.55f, 0.475f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.0f, -0.1f, 0.6f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.0f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$5721(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5720(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5719(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -0.1f, 0.6f);
    }
    
    private static /* synthetic */ void lambda$createGun$5718(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-75.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.1f, -0.55f, 0.475f);
    }
    
    private static /* synthetic */ void lambda$createGun$5717(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glRotatef(-215.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.6f, -0.25f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$5716(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glRotatef(-230.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.675f, -0.25f, -0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$5715(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glRotatef(-215.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.6f, -0.25f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$5714(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5713(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5712(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5711(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5710(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5709(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-75.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.1f, -0.55f, 0.475f);
    }
    
    private static /* synthetic */ void lambda$createGun$5708(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -0.1f, 0.6f);
    }
    
    private static /* synthetic */ void lambda$createGun$5707(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5706(final RenderContext renderContext) {
        GL11.glScalef(2.2f, 2.2f, 2.2f);
        GL11.glTranslatef(1.0f, 0.4f, -0.4f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5705(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5704(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5703(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.675f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$5702(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.2f, 1.0f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$5701(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.0f, -0.525f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.001f, -0.005f, 0.75f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {}
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(-0.003f, -0.065f, 0.55f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.001f, 0.02f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.001f, 0.02f, 0.25f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, -0.02f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, -0.02f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, -0.015f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, -0.015f, 0.1f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5700(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5699(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5698(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5697(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5696(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5695(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5694(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5693(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5692(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5691(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5690(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5689(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5688(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5687(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5686(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5685(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5684(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5683(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5682(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5681(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5680(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5679(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5678(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5677(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5676(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5675(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5674(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5673(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5672(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5671(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5670(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5669(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5668(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5667(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5666(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$5665(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5664(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5663(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5662(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5661(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5660(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5659(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5658(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5657(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5656(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$5655(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$5654(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$5653(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5652(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5651(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5650(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5649(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5648(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5647(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5646(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5645(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.0f, -0.4f);
        GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.001f, -0.005f, 0.67f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(-0.003f, -0.065f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.001f, 0.02f, 0.43f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.001f, 0.02f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, -0.02f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, -0.02f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, -0.015f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, -0.015f, 0.1f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5644(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.225f, 0.95f, -0.1f);
        GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5643(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.225f, 0.95f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$5642(final RenderContext renderContext) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-1.7f, -0.8f, 1.9f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5641(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5640(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5639(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.235f, -6.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5638(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.05f, -1.18f, -3.2f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$5637(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.05f, -1.18f, -3.2f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$5636(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5635(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5634(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.35f, -2.9f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5633(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5632(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5631(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -1.53f, -1.05f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5630(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.55f, -0.5f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5629(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.545f, -0.5f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5628(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.072f, -1.25f, -0.9f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -1.53f, -0.9f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5627(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.235f, 1.16f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5626(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.3f, -1.38f, -0.5f);
        GL11.glScaled(0.75, 0.75, 0.75);
    }
    
    private static /* synthetic */ void lambda$createGun$5625(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5624(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.3f, -1.38f, -0.3f);
        GL11.glScaled(0.75, 0.75, 0.75);
    }
    
    private static /* synthetic */ void lambda$createGun$5623(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5622(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.17f, -1.14f, -0.45f);
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
    }
    
    private static /* synthetic */ void lambda$createGun$5621(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5620(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.265f, -1.41f, -0.3f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$5619(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(-0.16f, -1.5f, -0.3f);
            GL11.glScaled(0.3499999940395355, 0.3799999952316284, 0.3499999940395355);
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
            GL11.glTranslatef(0.13f, -1.55f, -3.05f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AK47iron) {
            GL11.glTranslatef(0.092f, -1.91f, -0.9f);
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
    
    private static /* synthetic */ void lambda$createGun$5618(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(-0.145f, -1.55f, -0.35f);
            GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(0.255f, -1.55f, -2.25f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof FALIron) {
            GL11.glTranslatef(0.127f, -1.77f, -2.22f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AR15CarryHandle) {
            GL11.glTranslatef(-0.063f, -1.07f, -0.43f);
            GL11.glScaled(0.3100000023841858, 0.44999998807907104, 0.5400000214576721);
        }
        else if (model instanceof MP5Iron) {
            GL11.glTranslatef(0.215f, -1.54f, 1.2f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5617(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(0.162f, -1.75f, 1.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(-0.055f, -1.35f, -4.05f);
            GL11.glScaled(0.800000011920929, 0.6800000071525574, 1.0);
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
            GL11.glTranslatef(0.13f, -1.55f, -3.05f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AK47iron) {
            GL11.glTranslatef(0.092f, -1.91f, -0.9f);
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
            GL11.glTranslatef(-0.185f, -1.53f, -4.05f);
            GL11.glScaled(0.550000011920929, 0.5, 1.0);
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
    
    private static /* synthetic */ void lambda$createGun$5616(final ModelBase model) {
        GL11.glTranslatef(-0.175f, -1.28f, -0.67f);
        GL11.glScaled(0.699999988079071, 0.4000000059604645, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$5615(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.69f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5614(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5613(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5612(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5611(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5610(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5609(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic"));
    }
    
    private static /* synthetic */ void lambda$createGun$5608(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5607(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert"));
    }
    
    private static /* synthetic */ void lambda$createGun$5606(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5605(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$5604(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5603(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$5602(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5601(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$5600(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5599(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ void lambda$createGun$5598(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5597(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ List lambda$createGun$5596(final ItemStack stack) {
        return Arrays.asList("Type: Carbine", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine", "20rnd 5.56x45mm NATO Magazine", "40rnd 5.56x45mm NATO Magazine", "30rnd 5.56x45mm NATO PMAG Magazine", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$5595() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$5594() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$5593() {
        return 0.8f;
    }
}
