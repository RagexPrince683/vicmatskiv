package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.mw.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;

public class PX90Factory implements GunFactory
{
    public PX90Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("FNP90 TR").withFireRate(0.75f).withRecoil(2.8f).withZoom(0.9f).withShootSound("P90").withSilencedShootSound("RifleSilencer").withReloadSound("P90Reload").withUnloadSound("Unload").withReloadingTime(70L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.6f).withFlashOffsetX(() -> 0.29f).withFlashOffsetY(() -> 0.3f).withInaccuracy(3.0f).withCreativeTab(ModernWarfareMod.SMGTab).withCrafting(CraftingComplexity.HIGH, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate).withInformationProvider(stack -> Arrays.asList("Type: Personal defense weapon", "Damage: 6.5", "Caliber: 5.7x28mm", "Magazines:", "50rnd 5.7x28mm Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Amethyst, (a, i) -> i.setActiveTextureIndex(GunSkins.Amethyst.getTextureVariantIndex("Amethyst")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(Magazines.FNP90Mag, model -> {}).withCompatibleAttachment(Attachments.AKMIron, true, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(0.16f, -1.9f, 0.8f);
                GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(0.26f, -1.55f, -2.35f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof P90iron) {
                GL11.glTranslatef(0.14f, -1.92f, -0.35f);
                GL11.glScaled(0.5, 0.5, 0.5);
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
            GL11.glTranslatef(0.055f, -1.95f, 0.6f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(0.25f, -1.8f, 0.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(0.202f, -2.05f, 0.0f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(0.264f, -1.85f, 0.2f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(0.202f, -2.085f, 0.3f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(0.264f, -1.85f, 0.2f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(0.202f, -2.085f, 0.3f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(0.264f, -1.85f, 0.2f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(0.202f, -2.085f, -0.26f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Silencer57x38, model -> {
            GL11.glTranslatef(0.107f, -1.2f, -2.14f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("P90", "Electric").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new P90()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glTranslatef(2.0f, 0.5f, 0.0f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-1.8f, 0.7f, 1.5f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.1f, -0.3f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.1f, -0.3f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.5f, -0.6f, 0.45f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(-0.3f, -0.32f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.263f, -0.9f, 1.9f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.005f, 0.15f, 0.45f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.4f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.15f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.15f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.15f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.19f, 2.5f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(Magazines.FNP90Mag, renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.1f, -0.1f, -0.2f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
        }, 250L, 500L), new Transition(renderContext -> {
            GL11.glTranslatef(0.1f, -0.1f, -0.2f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
        }, 250L, 20L), new Transition(renderContext -> {
            GL11.glTranslatef(0.1f, -0.1f, -0.2f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
        }, 250L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.1f, -0.1f, -0.2f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glTranslatef(0.1f, -0.1f, -0.2f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.FNP90Mag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, -0.15f, 0.8f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.FNP90Mag, new Transition(renderContext -> GL11.glTranslatef(0.0f, -0.15f, 0.6f), 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 0.0f, 0.2f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(-0.3f, -0.3f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.263f, -0.9f, 1.8f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.005f, 0.15f, 0.45f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.4f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.15f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.15f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.15f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.19f, 2.5f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
            GL11.glTranslatef(1.0f, -0.75f, -1.2f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
            GL11.glTranslatef(1.0f, -0.8f, -2.0f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(1.7f, 1.7f, 3.0f);
            GL11.glTranslatef(0.8f, -0.35f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
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
            GL11.glTranslatef(0.9f, -0.4f, 0.8f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.8f, -0.4f, 0.8f);
            GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.8f, -0.4f, 0.8f);
            GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
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
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.8f, -0.4f, 0.8f);
            GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.9f, -0.4f, 0.8f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
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
        }, 250L, 50L)).build()).withSpawnEntityDamage(6.5f).withSpawnEntityGravityVelocity(0.028f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$7824(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7823(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7822(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.9f, -0.4f, 0.8f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7821(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.8f, -0.4f, 0.8f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7820(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7819(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7818(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7817(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.8f, -0.4f, 0.8f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7816(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.8f, -0.4f, 0.8f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7815(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.9f, -0.4f, 0.8f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7814(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7813(final RenderContext renderContext) {
        GL11.glScalef(2.2f, 2.2f, 2.2f);
        GL11.glTranslatef(1.0f, 0.2f, 0.2f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7812(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7811(final RenderContext renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.8f, -0.35f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7810(final RenderContext renderContext) {
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(1.0f, -0.8f, -2.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7809(final RenderContext renderContext) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
        GL11.glTranslatef(1.0f, -0.75f, -1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$7808(final RenderContext renderContext) {
        GL11.glTranslatef(-0.3f, -0.3f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.263f, -0.9f, 1.8f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.005f, 0.15f, 0.45f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.4f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.15f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.15f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.15f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.19f, 2.5f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7807(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7806(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.2f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7805(final Object renderContext) {
        GL11.glTranslatef(0.0f, -0.15f, 0.6f);
    }
    
    private static /* synthetic */ void lambda$createGun$7804(final Object renderContext) {
        GL11.glTranslatef(0.0f, -0.15f, 0.8f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7803(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7802(final Object renderContext) {
        GL11.glTranslatef(0.1f, -0.1f, -0.2f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$7801(final Object renderContext) {
        GL11.glTranslatef(0.1f, -0.1f, -0.2f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$7800(final Object renderContext) {
        GL11.glTranslatef(0.1f, -0.1f, -0.2f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$7799(final Object renderContext) {
        GL11.glTranslatef(0.1f, -0.1f, -0.2f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$7798(final Object renderContext) {
        GL11.glTranslatef(0.1f, -0.1f, -0.2f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$7797(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7796(final RenderContext renderContext) {
        GL11.glTranslatef(-0.3f, -0.32f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.263f, -0.9f, 1.9f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.005f, 0.15f, 0.45f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.4f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.15f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.15f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.15f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.19f, 2.5f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7795(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.3f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.5f, -0.6f, 0.45f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7794(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.3f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.5f, -0.6f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$7793(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, 0.7f, 1.5f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7792(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(2.0f, 0.5f, 0.0f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7791(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7790(final ModelBase model) {
        GL11.glTranslatef(0.107f, -1.2f, -2.14f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$7789(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(0.264f, -1.85f, 0.2f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(0.202f, -2.085f, -0.26f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7788(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(0.264f, -1.85f, 0.2f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(0.202f, -2.085f, 0.3f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7787(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(0.264f, -1.85f, 0.2f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(0.202f, -2.085f, 0.3f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7786(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(0.25f, -1.8f, 0.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(0.202f, -2.05f, 0.0f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7785(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7784(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(0.055f, -1.95f, 0.6f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$7783(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(0.16f, -1.9f, 0.8f);
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(0.26f, -1.55f, -2.35f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof P90iron) {
            GL11.glTranslatef(0.14f, -1.92f, -0.35f);
            GL11.glScaled(0.5, 0.5, 0.5);
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
    
    private static /* synthetic */ void lambda$createGun$7782(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$7781(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$7780(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$7779(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$7778(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$7777(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$7776(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Amethyst.getTextureVariantIndex("Amethyst"));
    }
    
    private static /* synthetic */ void lambda$createGun$7775(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$7774(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$7773(final ItemStack stack) {
        return Arrays.asList("Type: Personal defense weapon", "Damage: 6.5", "Caliber: 5.7x28mm", "Magazines:", "50rnd 5.7x28mm Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$7772() {
        return 0.3f;
    }
    
    private static /* synthetic */ Float lambda$createGun$7771() {
        return 0.29f;
    }
    
    private static /* synthetic */ Float lambda$createGun$7770() {
        return 0.6f;
    }
}
