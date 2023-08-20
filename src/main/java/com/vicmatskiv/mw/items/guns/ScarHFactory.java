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

public class ScarHFactory implements GunFactory
{
    public ScarHFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("ScarH").withFireRate(0.7f).withRecoil(3.6f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("ScarH").withSilencedShootSound("AR15Silenced").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(50L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.12f).withFlashOffsetY(() -> 0.15f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Battle rifle", "Damage: 7.4", "Nickname: Scar-H", "Caliber: .300 AAC Blackout", "Magazines:", "30rnd .300 AAC Blackout Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Forest, (a, i) -> i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("Forest")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(Magazines.ScarHMag, model -> {
            GL11.glTranslatef(-0.342f, 0.6f, -1.43f);
            GL11.glScaled(1.100000023841858, 1.5, 1.5);
        }).withCompatibleAttachment(AuxiliaryAttachments.ScarAction, true, model -> {}).withCompatibleAttachment(Attachments.AKMIron, true, model -> {
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
                GL11.glTranslatef(-0.163f, -1.85f, 0.2f);
                GL11.glScaled(0.3499999940395355, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof ScarIron2) {
                GL11.glTranslatef(-0.085f, -1.74f, -4.55f);
                GL11.glScaled(0.550000011920929, 0.6399999856948853, 0.6000000238418579);
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
            GL11.glTranslatef(-0.321f, -1.8f, -0.7f);
            GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.8500000238418579);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Specter, (player, stack) -> {
            GL11.glTranslatef(-0.2f, -1.45f, -0.7f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.15f, -1.035f, 1.513f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Scope, (player, stack) -> {
            GL11.glTranslatef(-0.386f, -1.79f, -0.6f);
            GL11.glScaled(1.1100000143051147, 1.1100000143051147, 1.1100000143051147);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.272f, 0.67f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.HP, (player, stack) -> {
            GL11.glTranslatef(-0.386f, -1.79f, -1.0f);
            GL11.glScaled(1.1100000143051147, 1.1100000143051147, 1.1100000143051147);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.235f, 1.16f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.06f, -1.6f, -0.9f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.125f, -1.94f, -1.2f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.041f, -1.63f, -0.8f);
                GL11.glScaled(0.6700000166893005, 0.6700000166893005, 0.6700000166893005);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.125f, -1.94f, -1.2f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.041f, -1.63f, -1.1f);
                GL11.glScaled(0.6700000166893005, 0.6700000166893005, 0.6700000166893005);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.125f, -1.94f, -1.2f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.041f, -1.63f, -0.6f);
                GL11.glScaled(0.6700000166893005, 0.6700000166893005, 0.6700000166893005);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.125f, -1.94f, -1.2f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(Attachments.Grip2, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.StubbyGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Grip, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.VGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Bipod, model -> {
            GL11.glTranslatef(-0.2f, -0.41f, -4.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Laser2, (p, s) -> {
            GL11.glTranslatef(0.0f, -1.25f, -4.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Laser, (p, s) -> {
            GL11.glTranslatef(0.0f, -1.25f, -4.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Silencer300AACBlackout, model -> {
            GL11.glTranslatef(-0.2f, -1.32f, -7.2f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("ScarH").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new Scar()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glTranslatef(1.0f, 2.0f, -1.2f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-2.0f, -1.2f, 2.2f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.375f, 1.399999f, -0.725f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.375f, 1.399999f, -0.5f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 1.349999f, -0.5f);
            GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(-0.005f, 0.115f, 0.85f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(-0.0f, 0.06f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(-0.003f, 0.19f, 0.3f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.0f, 0.19f, -0.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.047f, -0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.045f, -0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.045f, -0.21f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, 0.045f, -0.21f);
            }
        }).withFirstPersonCustomPositioning(Magazines.ScarHMag, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.ScarAction.getRenderablePart(), renderContext -> {
            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.ScarAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.2f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.ScarAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.2f)).withFirstPersonPositioningCustomRecoiled(Magazines.ScarHMag.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.ScarHMag.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, 0.2f, -0.1f);
        }, 300L, 60L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, 0.2f, -0.1f);
        }, 400L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.325f, 0.325f, 0.0f);
        }, 400L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.325f, 0.325f, 0.0f);
        }, 150L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.325f, 0.325f, 0.0f);
        }, 60L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, 0.2f, -0.1f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, 0.2f, -0.1f);
        }, 200L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.ScarHMag, new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.ScarAction.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.ScarAction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.ScarHMag, new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, 1.7f, 0.1f);
            GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(-0.01f, 0.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 1.349999f, -0.6f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(-0.005f, 0.115f, 0.85f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(-0.0f, 0.06f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(-0.003f, 0.19f, 0.3f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.0f, 0.19f, -0.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.047f, -0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.045f, -0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.045f, -0.21f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, 0.045f, -0.21f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.375f, 1.574999f, -0.725f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.075f, 0.925f, 0.15f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 5.5f);
            GL11.glTranslatef(0.48f, 0.0f, -0.05f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.7f, 3.7f, 4.2f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.45f, -0.53f, 0.09f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(3.1f, 3.1f, 3.1f);
            GL11.glTranslatef(0.9f, 0.4f, -0.4f);
            GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
        }, renderContext -> {
            GL11.glScalef(3.7f, 3.7f, 4.2f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.45f, -0.53f, 0.09f);
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
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 2.5f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.025f, -0.725f, -0.3f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 2.5f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.05f, -0.7f, 0.025f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 2.5f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.025f, -0.725f, -0.3f);
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
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
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
    
    private static /* synthetic */ void lambda$createGun$8265(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8264(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8263(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.725f, 0.575f);
    }
    
    private static /* synthetic */ void lambda$createGun$8262(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.75f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8261(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8260(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8259(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8258(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8257(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8256(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.025f, -0.725f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$8255(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.05f, -0.7f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$8254(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.025f, -0.725f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$8253(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 2.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.75f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8252(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.725f, 0.575f);
    }
    
    private static /* synthetic */ void lambda$createGun$8251(final RenderContext renderContext) {
        GL11.glScalef(3.7f, 3.7f, 4.2f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.45f, -0.53f, 0.09f);
    }
    
    private static /* synthetic */ void lambda$createGun$8250(final RenderContext renderContext) {
        GL11.glScalef(3.1f, 3.1f, 3.1f);
        GL11.glTranslatef(0.9f, 0.4f, -0.4f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8249(final RenderContext renderContext) {
        GL11.glScalef(3.7f, 3.7f, 4.2f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.45f, -0.53f, 0.09f);
    }
    
    private static /* synthetic */ void lambda$createGun$8248(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 5.5f);
        GL11.glTranslatef(0.48f, 0.0f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8247(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.075f, 0.925f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$8246(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.375f, 1.574999f, -0.725f);
    }
    
    private static /* synthetic */ void lambda$createGun$8245(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.349999f, -0.6f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(-0.005f, 0.115f, 0.85f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(-0.0f, 0.06f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(-0.003f, 0.19f, 0.3f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.0f, 0.19f, -0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.047f, -0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.045f, -0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.045f, -0.21f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, 0.045f, -0.21f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8244(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8243(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8242(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8241(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8240(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8239(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8238(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8237(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8236(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8235(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8234(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8233(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8232(final Object renderContext) {
        GL11.glTranslatef(0.3f, 1.7f, 0.1f);
        GL11.glRotatef(-30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8231(final Object renderContext) {
        GL11.glTranslatef(-0.01f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8230(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, 0.2f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$8229(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, 0.2f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$8228(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.325f, 0.325f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8227(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.325f, 0.325f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8226(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.325f, 0.325f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8225(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, 0.2f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$8224(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, 0.2f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$8223(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8222(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8221(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$8220(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$8219(final RenderContext renderContext) {
        if (renderContext.getWeaponInstance().getAmmo() == 0) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8218(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8217(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.349999f, -0.5f);
        GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.AKMIron)) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(-0.005f, 0.115f, 0.85f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(-0.0f, 0.06f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(-0.003f, 0.19f, 0.3f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.0f, 0.19f, -0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.047f, -0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.045f, -0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.045f, -0.21f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, 0.045f, -0.21f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8216(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.375f, 1.399999f, -0.5f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8215(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.375f, 1.399999f, -0.725f);
    }
    
    private static /* synthetic */ void lambda$createGun$8214(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-2.0f, -1.2f, 2.2f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8213(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8212(final ItemStack itemStack) {
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8211(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.32f, -7.2f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$8210(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.0f, -1.25f, -4.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$8209(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.0f, -1.25f, -4.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$8208(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -4.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$8207(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$8206(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$8205(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$8204(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.41f, -3.2f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$8203(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.041f, -1.63f, -0.6f);
            GL11.glScaled(0.6700000166893005, 0.6700000166893005, 0.6700000166893005);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -1.94f, -1.2f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8202(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.041f, -1.63f, -1.1f);
            GL11.glScaled(0.6700000166893005, 0.6700000166893005, 0.6700000166893005);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.125f, -1.94f, -1.2f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8201(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.041f, -1.63f, -0.8f);
            GL11.glScaled(0.6700000166893005, 0.6700000166893005, 0.6700000166893005);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.125f, -1.94f, -1.2f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8200(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.06f, -1.6f, -0.9f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -1.94f, -1.2f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8199(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.235f, 1.16f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8198(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.386f, -1.79f, -1.0f);
        GL11.glScaled(1.1100000143051147, 1.1100000143051147, 1.1100000143051147);
    }
    
    private static /* synthetic */ void lambda$createGun$8197(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8196(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.386f, -1.79f, -0.6f);
        GL11.glScaled(1.1100000143051147, 1.1100000143051147, 1.1100000143051147);
    }
    
    private static /* synthetic */ void lambda$createGun$8195(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8194(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.2f, -1.45f, -0.7f);
        GL11.glScaled(0.5, 0.5, 0.5);
    }
    
    private static /* synthetic */ void lambda$createGun$8193(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8192(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.321f, -1.8f, -0.7f);
        GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.8500000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$8191(final ModelBase model) {
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
            GL11.glTranslatef(-0.163f, -1.85f, 0.2f);
            GL11.glScaled(0.3499999940395355, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof ScarIron2) {
            GL11.glTranslatef(-0.085f, -1.74f, -4.55f);
            GL11.glScaled(0.550000011920929, 0.6399999856948853, 0.6000000238418579);
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
    
    private static /* synthetic */ void lambda$createGun$8190(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$8189(final ModelBase model) {
        GL11.glTranslatef(-0.342f, 0.6f, -1.43f);
        GL11.glScaled(1.100000023841858, 1.5, 1.5);
    }
    
    private static /* synthetic */ void lambda$createGun$8188(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8187(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$8186(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8185(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$8184(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8183(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("Forest"));
    }
    
    private static /* synthetic */ void lambda$createGun$8182(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8181(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$8180(final ItemStack stack) {
        return Arrays.asList("Type: Battle rifle", "Damage: 7.4", "Nickname: Scar-H", "Caliber: .300 AAC Blackout", "Magazines:", "30rnd .300 AAC Blackout Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$8179() {
        return 0.15f;
    }
    
    private static /* synthetic */ Float lambda$createGun$8178() {
        return 0.12f;
    }
    
    private static /* synthetic */ Float lambda$createGun$8177() {
        return 0.8f;
    }
}
