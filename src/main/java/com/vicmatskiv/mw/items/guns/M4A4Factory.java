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

public class M4A4Factory implements GunFactory
{
    public M4A4Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("HK416A5").withFireRate(0.7f).withRecoil(3.4f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("hk416a5").withSilencedShootSound("ar15silenced").withReloadSound("m4reload").withUnloadSound("m4unload").withReloadingTime(50L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Assault rifle/Carbine", "Damage: 7.4", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine", "20rnd 5.56x45mm NATO Magazine", "40rnd 5.56x45mm NATO Magazine", "30rnd 5.56x45mm NATO PMAG Magazine", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Desert, (a, i) -> i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Arctic, (a, i) -> i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic")), (a, i) -> {}).withCompatibleAttachment(Magazines.NATOMag1, model -> {
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
                GL11.glTranslatef(-0.085f, -1.42f, -3.54f);
                GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
            }
            else if (model instanceof FALIron) {
                GL11.glTranslatef(-0.185f, -1.5f, -4.05f);
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
        }).withCompatibleAttachment(Attachments.AKMIron, true, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(-0.16f, -1.5f, -0.3f);
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
                GL11.glTranslatef(-0.15f, -1.48f, -0.2f);
                GL11.glScaled(0.25, 0.3499999940395355, 0.30000001192092896);
            }
            else if (model instanceof ScarIron2) {
                GL11.glTranslatef(0.25f, -1.55f, -2.5f);
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
            GL11.glTranslatef(-0.2f, -1.235f, -6.4f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("AK12").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new SPAR16()).withEntityPositioning(itemStack -> {
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
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.4f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$5964(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5963(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5962(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -0.1f, 0.6f);
    }
    
    private static /* synthetic */ void lambda$createGun$5961(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-75.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.1f, -0.55f, 0.475f);
    }
    
    private static /* synthetic */ void lambda$createGun$5960(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glRotatef(-215.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.6f, -0.25f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$5959(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glRotatef(-230.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.675f, -0.25f, -0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$5958(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glRotatef(-215.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(130.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.6f, -0.25f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$5957(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5956(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5955(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5954(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5953(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5952(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-75.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.1f, -0.55f, 0.475f);
    }
    
    private static /* synthetic */ void lambda$createGun$5951(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -0.1f, 0.6f);
    }
    
    private static /* synthetic */ void lambda$createGun$5950(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5949(final RenderContext renderContext) {
        GL11.glScalef(2.2f, 2.2f, 2.2f);
        GL11.glTranslatef(1.0f, 0.4f, -0.4f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5948(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5947(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5946(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.675f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$5945(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.2f, 1.0f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$5944(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.0f, -0.525f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.001f, -0.005f, 0.75f);
        }
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
    
    private static /* synthetic */ void lambda$createGun$5943(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5942(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5941(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5940(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5939(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5938(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5937(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5936(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5935(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5934(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5933(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5932(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5931(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5930(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5929(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5928(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5927(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5926(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5925(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5924(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5923(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5922(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5921(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5920(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5919(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5918(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5917(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5916(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5915(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5914(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5913(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5912(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5911(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5910(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5909(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$5908(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5907(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5906(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5905(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5904(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5903(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5902(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5901(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5900(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5899(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$5898(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$5897(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.15f, 0.9f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$5896(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5895(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-35.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.725f, 1.1f, -0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5894(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5893(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5892(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5891(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5890(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5889(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5888(final RenderContext renderContext) {
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
    
    private static /* synthetic */ void lambda$createGun$5887(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.225f, 0.95f, -0.1f);
        GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5886(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.225f, 0.95f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$5885(final RenderContext renderContext) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-1.7f, -0.8f, 1.9f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5884(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5883(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5882(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.235f, -6.4f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5881(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.05f, -1.18f, -3.2f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$5880(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.05f, -1.18f, -3.2f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$5879(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5878(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5877(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.35f, -2.9f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5876(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5875(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -2.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$5874(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.12f, -1.53f, -1.05f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5873(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.55f, -0.5f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5872(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.053f, -1.28f, -0.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.12f, -1.545f, -0.5f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5871(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.072f, -1.25f, -0.9f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -1.53f, -0.9f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5870(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.235f, 1.16f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5869(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.3f, -1.38f, -0.5f);
        GL11.glScaled(0.75, 0.75, 0.75);
    }
    
    private static /* synthetic */ void lambda$createGun$5868(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5867(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.3f, -1.38f, -0.3f);
        GL11.glScaled(0.75, 0.75, 0.75);
    }
    
    private static /* synthetic */ void lambda$createGun$5866(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5865(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.17f, -1.14f, -0.45f);
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
    }
    
    private static /* synthetic */ void lambda$createGun$5864(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5863(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.265f, -1.41f, -0.3f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$5862(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(-0.16f, -1.5f, -0.3f);
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
            GL11.glTranslatef(-0.15f, -1.48f, -0.2f);
            GL11.glScaled(0.25, 0.3499999940395355, 0.30000001192092896);
        }
        else if (model instanceof ScarIron2) {
            GL11.glTranslatef(0.25f, -1.55f, -2.5f);
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
    
    private static /* synthetic */ void lambda$createGun$5861(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(0.162f, -1.75f, 1.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(-0.055f, -1.35f, -4.05f);
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
            GL11.glTranslatef(-0.085f, -1.42f, -3.54f);
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        }
        else if (model instanceof FALIron) {
            GL11.glTranslatef(-0.185f, -1.5f, -4.05f);
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
    
    private static /* synthetic */ void lambda$createGun$5860(final ModelBase model) {
        GL11.glTranslatef(-0.175f, -1.28f, -0.67f);
        GL11.glScaled(0.699999988079071, 0.4000000059604645, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$5859(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.69f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5858(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5857(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5856(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5855(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.5f, -1.25f);
        GL11.glScaled(1.149999976158142, 1.2000000476837158, 1.149999976158142);
    }
    
    private static /* synthetic */ void lambda$createGun$5854(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5853(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic"));
    }
    
    private static /* synthetic */ void lambda$createGun$5852(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5851(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert"));
    }
    
    private static /* synthetic */ void lambda$createGun$5850(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5849(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$5848(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5847(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$5846(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5845(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$5844(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5843(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$5842(final ItemStack stack) {
        return Arrays.asList("Type: Assault rifle/Carbine", "Damage: 7.4", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine", "20rnd 5.56x45mm NATO Magazine", "40rnd 5.56x45mm NATO Magazine", "30rnd 5.56x45mm NATO PMAG Magazine", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$5841() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$5840() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$5839() {
        return 0.8f;
    }
}
