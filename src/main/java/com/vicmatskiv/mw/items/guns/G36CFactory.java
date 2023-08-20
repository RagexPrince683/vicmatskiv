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

public class G36CFactory implements GunFactory
{
    public G36CFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("G36C").withFireRate(0.7f).withRecoil(3.2f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("G36").withSilencedShootSound("RifleSilencer").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(50L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.13f).withFlashOffsetY(() -> 0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Assault rifle/Carbine", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine (Type 3)", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Desert, (a, i) -> i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Amethyst, (a, i) -> i.setActiveTextureIndex(GunSkins.Amethyst.getTextureVariantIndex("Amethyst")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(Magazines.NATOG36Mag, model -> {
            GL11.glTranslatef(-0.37f, 0.8f, -1.7f);
            GL11.glScaled(1.25, 1.7000000476837158, 1.7000000476837158);
        }).withCompatibleAttachment(Magazines.NATODrum100, model -> {
            GL11.glTranslatef(-0.37f, 0.8f, -1.7f);
            GL11.glScaled(1.25, 1.600000023841858, 1.7000000476837158);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        }).withCompatibleAttachment(AuxiliaryAttachments.G36Rail, true, model -> {
            GL11.glTranslatef(-0.31f, -2.0f, -2.52f);
            GL11.glScaled(0.6700000166893005, 0.675000011920929, 0.6650000214576721);
        }).withCompatibleAttachment(AuxiliaryAttachments.G36Action, true, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof AKMiron1) {
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
                GL11.glTranslatef(-0.171f, -1.95f, -0.3f);
                GL11.glScaled(0.25, 0.25, 0.25);
            }
            else if (model instanceof G36CIron2) {
                GL11.glTranslatef(-0.19f, -1.92f, -3.6f);
                GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
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
                GL11.glTranslatef(0.14f, -1.74f, 1.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(0.215f, -1.54f, 1.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withCompatibleAttachment(Attachments.ACOG, (player, stack) -> {
            GL11.glTranslatef(-0.31f, -2.0f, -1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Specter, (player, stack) -> {
            GL11.glTranslatef(-0.21f, -1.64f, -1.4f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.15f, -1.035f, 1.513f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Scope, (player, stack) -> {
            GL11.glTranslatef(-0.325f, -2.0f, -1.0f);
            GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.8500000238418579);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.272f, 0.67f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.07f, -1.82f, -1.5f);
                GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.125f, -2.15f, -1.7f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.05f, -1.87f, -1.5f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.125f, -2.165f, -1.7f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.05f, -1.87f, -1.5f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.125f, -2.165f, -1.7f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.05f, -1.87f, -1.5f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.125f, -2.165f, -1.7f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Grip2, model -> {
            GL11.glTranslatef(-0.2f, -0.35f, -4.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.StubbyGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.35f, -4.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.VGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.4f, -4.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Laser2, (p, s) -> {
            GL11.glTranslatef(0.1f, -1.3f, -4.3f);
            GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.8500000238418579);
        }).withCompatibleAttachment(Attachments.Laser, (p, s) -> {
            GL11.glTranslatef(0.1f, -1.3f, -4.3f);
            GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.8500000238418579);
        }).withCompatibleAttachment(Attachments.Silencer556x45, model -> {
            GL11.glTranslatef(-0.2f, -1.45f, -6.4f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("AK12").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new G36C()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.5, 0.5, 0.5);
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
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glTranslatef(-0.225f, 0.725f, 0.0f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glTranslatef(-0.225f, 0.725f, 0.4f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 1.374999f, 0.1f);
            GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(-0.002f, 0.275f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.009f, 0.283f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(-0.0f, 0.29f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.225f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.1f);
            }
        }).withFirstPersonCustomPositioning(AuxiliaryAttachments.G36Action.getRenderablePart(), renderContext -> {
            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.G36Action.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.G36Action.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f)).withFirstPersonCustomPositioning(AuxiliaryAttachments.G36Rail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.G36Rail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.G36Rail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATOG36Mag.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATOG36Mag.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATODrum100.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATODrum100.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATOG36Mag, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATODrum100, renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
        }, 250L, 500L), new Transition(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
        }, 250L, 20L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.3f, 0.85f, 0.3f);
        }, 500L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.3f, 0.85f, 0.3f);
        }, 70L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.G36Action.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.G36Action.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f), 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATOG36Mag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 1.5f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATOG36Mag, new Transition(renderContext -> GL11.glTranslatef(0.0f, 1.5f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.G36Rail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.G36Rail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATODrum100, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.5f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATODrum100, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.5f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 1.374999f, 0.025f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(-0.002f, 0.275f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.009f, 0.283f, 0.4f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(-0.0f, 0.29f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.225f, 0.2f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.1f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.45f, 1.174999f, -0.125f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.249999f, 0.8f, 0.7f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 5.5f);
            GL11.glTranslatef(0.5f, 0.01f, -0.05f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(110.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(205.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-95.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.775f, -0.025f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.625f, -0.575f, -0.175f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.8f, -0.075f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.175f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-55.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.15f, -0.45f, -0.075f);
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
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.8f, -0.075f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.625f, -0.575f, -0.175f);
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
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.0f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$3251(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3250(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3249(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.625f, -0.575f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$3248(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.8f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$3247(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3246(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3245(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3244(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3243(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-55.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.15f, -0.45f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$3242(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.175f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3241(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.8f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$3240(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.625f, -0.575f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$3239(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3238(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(110.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(205.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-95.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.775f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$3237(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3236(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 5.5f);
        GL11.glTranslatef(0.5f, 0.01f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3235(final RenderContext renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.8f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGun$3234(final RenderContext renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.45f, 1.174999f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$3233(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.374999f, 0.025f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(-0.002f, 0.275f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.009f, 0.283f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(-0.0f, 0.29f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.225f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.1f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3232(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3231(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3230(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3229(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3228(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3227(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3226(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3225(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3224(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3223(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3222(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3221(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3220(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3219(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3218(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3217(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3216(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3215(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3214(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$3213(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3212(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3211(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3210(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3209(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3208(final Object renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$3207(final Object renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$3206(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.3f, 0.85f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$3205(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.3f, 0.85f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$3204(final Object renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$3203(final Object renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$3202(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3201(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3200(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3199(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3198(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3197(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3196(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3195(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3194(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$3193(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$3192(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$3191(final RenderContext renderContext) {
        if (renderContext.getWeaponInstance().getAmmo() == 0) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3190(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.374999f, 0.1f);
        GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(-0.002f, 0.275f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.009f, 0.283f, 0.4f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(-0.0f, 0.29f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.225f, 0.2f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.1f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3189(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glTranslatef(-0.225f, 0.725f, 0.4f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3188(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glTranslatef(-0.225f, 0.725f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3187(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3186(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3185(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3184(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.45f, -6.4f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$3183(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.1f, -1.3f, -4.3f);
        GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.8500000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$3182(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(0.1f, -1.3f, -4.3f);
        GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.8500000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$3181(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.4f, -4.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$3180(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.35f, -4.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$3179(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.35f, -4.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$3178(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.05f, -1.87f, -1.5f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.125f, -2.165f, -1.7f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3177(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.05f, -1.87f, -1.5f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.125f, -2.165f, -1.7f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3176(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.05f, -1.87f, -1.5f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -2.165f, -1.7f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3175(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.07f, -1.82f, -1.5f);
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -2.15f, -1.7f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3174(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3173(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.325f, -2.0f, -1.0f);
        GL11.glScaled(0.8500000238418579, 0.8500000238418579, 0.8500000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$3172(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3171(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.21f, -1.64f, -1.4f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$3170(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3169(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.31f, -2.0f, -1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$3168(final ModelBase model) {
        if (model instanceof AKMiron1) {
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
            GL11.glTranslatef(-0.171f, -1.95f, -0.3f);
            GL11.glScaled(0.25, 0.25, 0.25);
        }
        else if (model instanceof G36CIron2) {
            GL11.glTranslatef(-0.19f, -1.92f, -3.6f);
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
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
            GL11.glTranslatef(0.14f, -1.74f, 1.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof MP5Iron) {
            GL11.glTranslatef(0.215f, -1.54f, 1.2f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$3167(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$3166(final ModelBase model) {
        GL11.glTranslatef(-0.31f, -2.0f, -2.52f);
        GL11.glScaled(0.6700000166893005, 0.675000011920929, 0.6650000214576721);
    }
    
    private static /* synthetic */ void lambda$createGun$3165(final ModelBase model) {
        GL11.glTranslatef(-0.37f, 0.8f, -1.7f);
        GL11.glScaled(1.25, 1.600000023841858, 1.7000000476837158);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$3164(final ModelBase model) {
        GL11.glTranslatef(-0.37f, 0.8f, -1.7f);
        GL11.glScaled(1.25, 1.7000000476837158, 1.7000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$3163(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$3162(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$3161(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$3160(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Amethyst.getTextureVariantIndex("Amethyst"));
    }
    
    private static /* synthetic */ void lambda$createGun$3159(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$3158(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$3157(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$3156(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert"));
    }
    
    private static /* synthetic */ void lambda$createGun$3155(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$3154(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$3153(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$3152(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$3151(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$3150(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$3149(final ItemStack stack) {
        return Arrays.asList("Type: Assault rifle/Carbine", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "30rnd 5.56x45mm NATO Magazine (Type 3)", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$3148() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$3147() {
        return 0.13f;
    }
    
    private static /* synthetic */ Float lambda$createGun$3146() {
        return 0.8f;
    }
}
