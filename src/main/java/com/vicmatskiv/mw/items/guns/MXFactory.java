package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class MXFactory implements GunFactory
{
    public MXFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("MX").withFireRate(0.55f).withRecoil(3.0f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("AR15").withSilencedShootSound("AR15Silenced").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(50L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, CommonProxy.MetalComponents).withInformationProvider(stack -> Arrays.asList("Type: Assault rifle", "Damage: 8", "Caliber: 6.5x39mm NATO", "Magazines:", "30rnd 6.5x39mm NATO Magazine")).withCompatibleAttachment(Magazines.MXMag, model -> GL11.glTranslatef(0.0f, 0.0f, 0.07f)).withCompatibleAttachment(Attachments.AKMIron, true, model -> {
            if (model instanceof ScarIron1) {
                GL11.glTranslatef(0.17f, -1.61f, 1.3f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof ScarIron2) {
                GL11.glTranslatef(0.25f, -1.52f, -2.3f);
                GL11.glScaled(0.5199999809265137, 0.5199999809265137, 0.5199999809265137);
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
                GL11.glTranslatef(0.13f, -1.55f, -3.05f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof M4Iron1) {
                GL11.glTranslatef(0.167f, -1.62f, 0.8f);
                GL11.glScaled(0.25999999046325684, 0.25999999046325684, 0.25999999046325684);
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
        }).withCompatibleAttachment(Attachments.ACOG, (player, stack) -> {
            GL11.glTranslatef(0.055f, -1.58f, 0.2f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Scope, (player, stack) -> {
            GL11.glTranslatef(0.055f, -1.56f, 0.4f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.272f, 0.67f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.HP, (player, stack) -> {
            GL11.glTranslatef(0.055f, -1.58f, 0.2f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.235f, 1.16f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(0.27f, -1.4f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(0.202f, -1.65f, 0.0f);
                GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(0.29f, -1.45f, 0.5f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(0.202f, -1.67f, -0.15f);
                GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(0.27f, -1.48f, 0.21f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(0.202f, -1.77f, 0.3f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(0.27f, -1.48f, 0.21f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(0.202f, -1.77f, 0.3f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Grip2, model -> {
            GL11.glTranslatef(0.135f, -0.6f, -1.25f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.StubbyGrip, model -> {
            GL11.glTranslatef(0.135f, -0.6f, -1.25f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.Grip, model -> {
            GL11.glTranslatef(0.135f, -0.5f, -1.25f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.VGrip, model -> {
            GL11.glTranslatef(0.135f, -0.6f, -1.25f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.Bipod, model -> {
            GL11.glTranslatef(0.135f, -0.5f, -1.25f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.Laser2, (p, s) -> {
            GL11.glTranslatef(0.35f, -1.2f, -2.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }).withCompatibleAttachment(Attachments.Laser, (p, s) -> {
            GL11.glTranslatef(0.35f, -1.2f, -2.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }).withCompatibleAttachment(Attachments.Silencer65x39, model -> {
            GL11.glTranslatef(0.107f, -1.35f, -4.2f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("MX", "Electric").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new MX()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glTranslatef(1.0f, 0.8f, 0.0f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-1.8f, 0.3f, 1.5f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.3f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.3f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(-0.047f, -0.315f, -0.25f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.136f, -1.035f, 1.36f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.0f, 0.08f, 0.75f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.061f, 0.43f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.0f, 0.061f, 0.3f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(-0.01f, 0.13f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.13f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.13f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.369f, -1.21f, 2.8f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(Magazines.MXMag, renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, -0.4f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 250L, 500L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, -0.4f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 250L, 20L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.28f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.3f, -0.8f, 0.8f);
        }, 250L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, -0.4f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, -0.4f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.MXMag, new Transition(renderContext -> {
            GL11.glTranslatef(0.2f, 0.5f, -0.2f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(1.3f, 0.5f, -0.8f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.MXMag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(-0.047f, -0.315f, -0.25f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.136f, -1.035f, 1.34f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.0f, 0.08f, 0.75f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.061f, 0.43f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.0f, 0.061f, 0.3f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(-0.01f, 0.13f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.13f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.13f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.369f, -1.21f, 2.8f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
            GL11.glTranslatef(0.5f, -0.35f, -1.0f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
            GL11.glTranslatef(1.0f, -0.8f, -1.5f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(1.7f, 1.7f, 3.0f);
            GL11.glTranslatef(0.65f, -0.35f, 0.37f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-55.0f, 1.0f, 0.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(2.2f, 2.2f, 2.2f);
            GL11.glTranslatef(1.0f, 0.2f, 0.2f);
            GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
        }, renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.4f, 0.5f, 0.8f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.4f, 0.5f, 0.8f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.7f, 1.7f, 3.0f);
            GL11.glTranslatef(0.65f, -0.35f, 0.37f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-55.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.4f, -0.2f, 0.6f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(1.7f, 1.7f, 3.0f);
            GL11.glTranslatef(0.65f, -0.2f, 0.37f);
            GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.7f, 1.7f, 3.0f);
            GL11.glTranslatef(0.7f, 0.0f, 0.37f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-40.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(8.0f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$7356(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7355(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7354(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.7f, 0.0f, 0.37f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-40.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7353(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.65f, -0.2f, 0.37f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7352(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.4f, -0.2f, 0.6f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7351(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7350(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7349(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.65f, -0.35f, 0.37f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-55.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7348(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 0.8f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7347(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.4f, 0.5f, 0.8f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7346(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7345(final RenderContext renderContext) {
        GL11.glScalef(2.2f, 2.2f, 2.2f);
        GL11.glTranslatef(1.0f, 0.2f, 0.2f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7344(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7343(final RenderContext renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.65f, -0.35f, 0.37f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-55.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7342(final RenderContext renderContext) {
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(1.0f, -0.8f, -1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$7341(final RenderContext renderContext) {
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
        GL11.glTranslatef(0.5f, -0.35f, -1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7340(final RenderContext renderContext) {
        GL11.glTranslatef(-0.047f, -0.315f, -0.25f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.136f, -1.035f, 1.34f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.0f, 0.08f, 0.75f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.061f, 0.43f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.0f, 0.061f, 0.3f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(-0.01f, 0.13f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.13f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.13f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.369f, -1.21f, 2.8f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7339(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7338(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7337(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7336(final Object renderContext) {
        GL11.glTranslatef(1.3f, 0.5f, -0.8f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7335(final Object renderContext) {
        GL11.glTranslatef(0.2f, 0.5f, -0.2f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7334(final Object renderContext) {
        GL11.glTranslatef(0.0f, -0.4f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7333(final Object renderContext) {
        GL11.glTranslatef(0.0f, -0.4f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7332(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.28f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.3f, -0.8f, 0.8f);
    }
    
    private static /* synthetic */ void lambda$createGun$7331(final Object renderContext) {
        GL11.glTranslatef(0.0f, -0.4f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7330(final Object renderContext) {
        GL11.glTranslatef(0.0f, -0.4f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7329(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7328(final RenderContext renderContext) {
        GL11.glTranslatef(-0.047f, -0.315f, -0.25f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.136f, -1.035f, 1.36f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.0f, 0.08f, 0.75f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.061f, 0.43f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.0f, 0.061f, 0.3f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(-0.01f, 0.13f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.13f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.13f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.369f, -1.21f, 2.8f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7327(final RenderContext renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.3f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7326(final RenderContext renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.3f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7325(final RenderContext renderContext) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-1.8f, 0.3f, 1.5f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7324(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(1.0f, 0.8f, 0.0f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7323(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7322(final ModelBase model) {
        GL11.glTranslatef(0.107f, -1.35f, -4.2f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$7321(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.35f, -1.2f, -2.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$7320(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.35f, -1.2f, -2.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$7319(final ModelBase model) {
        GL11.glTranslatef(0.135f, -0.5f, -1.25f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$7318(final ModelBase model) {
        GL11.glTranslatef(0.135f, -0.6f, -1.25f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$7317(final ModelBase model) {
        GL11.glTranslatef(0.135f, -0.5f, -1.25f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$7316(final ModelBase model) {
        GL11.glTranslatef(0.135f, -0.6f, -1.25f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$7315(final ModelBase model) {
        GL11.glTranslatef(0.135f, -0.6f, -1.25f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$7314(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(0.27f, -1.48f, 0.21f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(0.202f, -1.77f, 0.3f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7313(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(0.27f, -1.48f, 0.21f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(0.202f, -1.77f, 0.3f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7312(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(0.29f, -1.45f, 0.5f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(0.202f, -1.67f, -0.15f);
            GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7311(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(0.27f, -1.4f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(0.202f, -1.65f, 0.0f);
            GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7310(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.235f, 1.16f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7309(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(0.055f, -1.58f, 0.2f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$7308(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7307(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(0.055f, -1.56f, 0.4f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$7306(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7305(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(0.055f, -1.58f, 0.2f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$7304(final ModelBase model) {
        if (model instanceof ScarIron1) {
            GL11.glTranslatef(0.17f, -1.61f, 1.3f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof ScarIron2) {
            GL11.glTranslatef(0.25f, -1.52f, -2.3f);
            GL11.glScaled(0.5199999809265137, 0.5199999809265137, 0.5199999809265137);
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
            GL11.glTranslatef(0.13f, -1.55f, -3.05f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof M4Iron1) {
            GL11.glTranslatef(0.167f, -1.62f, 0.8f);
            GL11.glScaled(0.25999999046325684, 0.25999999046325684, 0.25999999046325684);
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
    
    private static /* synthetic */ void lambda$createGun$7303(final ModelBase model) {
        GL11.glTranslatef(0.0f, 0.0f, 0.07f);
    }
    
    private static /* synthetic */ List lambda$createGun$7302(final ItemStack stack) {
        return Arrays.asList("Type: Assault rifle", "Damage: 8", "Caliber: 6.5x39mm NATO", "Magazines:", "30rnd 6.5x39mm NATO Magazine");
    }
    
    private static /* synthetic */ Float lambda$createGun$7301() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$7300() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$7299() {
        return 0.8f;
    }
}
