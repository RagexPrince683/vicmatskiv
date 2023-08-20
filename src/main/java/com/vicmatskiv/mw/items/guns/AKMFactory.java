package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;

public class AKMFactory implements GunFactory
{
    public AKMFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("AKM").withFireRate(0.6f).withRecoil(3.0f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 1).withShootSound("AK47").withSilencedShootSound("AKsilenced").withReloadSound("AKReload").withUnloadSound("akunload").withReloadingTime(45L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.1f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, CommonProxy.MetalComponents, CompatibleBlocks.PLANK).withInformationProvider(stack -> Arrays.asList("Type: Assault rifle", "Damage: 7.4", "Caliber: 7.62x39mm", "Magazines:", "30rnd 7.62x39mm Magazine", "30rnd 7.62x39mm PMAG Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(Attachments.Silencer762x39, model -> {
            GL11.glTranslatef(-0.2f, -1.06f, -7.55f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(AuxiliaryAttachments.AKIron, true, model -> {
            GL11.glTranslatef(-0.175f, -1.06f, -5.96f);
            GL11.glScaled(0.6000000238418579, 0.550000011920929, 0.5);
        }).withCompatibleAttachment(AuxiliaryAttachments.AKpart, true, model -> {
            GL11.glTranslatef(-0.14f, -0.81f, -5.96f);
            GL11.glScaled(0.5, 0.5, 3.0);
        }).withCompatibleAttachment(AuxiliaryAttachments.AKaction, true, model -> {}).withCompatibleAttachment(Magazines.Magazine762x39, model -> GL11.glTranslatef(0.0f, -0.17f, 0.05f)).withCompatibleAttachment(Magazines.Mag75rnd762x39, model -> {
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.011f, 0.59f, 0.05f);
            GL11.glScaled(1.100000023841858, 1.2999999523162842, 1.0);
        }).withCompatibleAttachment(Magazines.PMAG762x39, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof AKMiron1) {
                GL11.glTranslatef(0.125f, -1.8f, -0.5f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AKMiron2) {
                GL11.glTranslatef(-0.183f, -1.32f, -5.95f);
                GL11.glScaled(0.550000011920929, 0.550000011920929, 0.6800000071525574);
            }
            else if (model instanceof AK47iron) {
                GL11.glTranslatef(-0.25f, -1.65f, -3.05f);
                GL11.glScaled(0.800000011920929, 0.699999988079071, 0.6000000238418579);
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
        }).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withTextureNames("AKM").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new AKM()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
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
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.52f, 1.0f, -0.35f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.52f, 1.0f, 0.0f);
            GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 0.8f, -0.0f);
            GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.005f, 0.25f, 0.3f);
            }
        }).withFirstPersonCustomPositioning(Magazines.Magazine762x39, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.PMAG762x39, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.Mag75rnd762x39, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AKIron.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AKpart.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AKaction.getRenderablePart(), renderContext -> {
            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.AKaction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.AKaction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f)).withFirstPersonPositioningCustomRecoiled(Magazines.Magazine762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.Magazine762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.Mag75rnd762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.Mag75rnd762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.PMAG762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.PMAG762x39.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.AKIron.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.AKIron.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.AKpart.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.AKpart.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
        }, 300L, 60L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
        }, 300L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
        }, 400L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
        }, 120L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
        }, 130L, 150L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AKIron.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AKIron.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AKpart.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AKpart.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AKaction.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AKaction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.Magazine762x39, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.Magazine762x39, new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {}, 50L, 200L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.Mag75rnd762x39, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.Mag75rnd762x39, new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {}, 50L, 200L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.PMAG762x39, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.PMAG762x39, new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 1.3f, 0.5f);
            GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {}, 50L, 200L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 0.8f, -0.1f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.005f, 0.25f, 0.3f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.35f, 1.025f, -0.4f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.149999f, 0.45f, 0.525f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.49f, 0.14f, -0.1f);
            GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 1.0f, 1.0f, 0.0f);
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
            GL11.glTranslatef(0.375f, -0.8f, 0.15f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.075f, -0.7f, 0.725f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.3f, -0.625f, 0.075f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.0f, -0.075f, 0.075f);
        }, 260L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.025f, -0.425f, 0.15f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.0f, -0.075f, 0.075f);
        }, 280L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.3f, -0.625f, 0.075f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.075f, -0.7f, 0.725f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.4f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$1415(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1414(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1413(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.075f, -0.7f, 0.725f);
    }
    
    private static /* synthetic */ void lambda$createGun$1412(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.3f, -0.625f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1411(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1410(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.025f, -0.425f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$1409(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1408(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1407(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1406(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1405(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1404(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1403(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.3f, -0.625f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1402(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.075f, -0.7f, 0.725f);
    }
    
    private static /* synthetic */ void lambda$createGun$1401(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1400(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$1399(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.33f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1398(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.49f, 0.14f, -0.1f);
        GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1397(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1396(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1395(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.149999f, 0.45f, 0.525f);
    }
    
    private static /* synthetic */ void lambda$createGun$1394(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.35f, 1.025f, -0.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$1393(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 0.8f, -0.1f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.005f, 0.25f, 0.3f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1392(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1391(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1390(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1389(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1388(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1387(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1386(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1385(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1384(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1383(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1382(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1381(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1380(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1379(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1378(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1377(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1376(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1375(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1374(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1373(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.3f, 0.5f);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1372(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1371(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1370(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$1369(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1368(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1367(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1366(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1365(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1364(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1363(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1362(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1361(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1360(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1359(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1358(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1357(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1356(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1355(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1354(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1353(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1352(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1351(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1350(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1349(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1348(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$1347(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$1346(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.275f, -0.1f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$1345(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1344(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1343(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1342(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1341(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1340(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1339(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1338(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1337(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1336(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1335(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1334(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1333(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1332(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1331(final RenderContext renderContext) {
        if (renderContext.getWeaponInstance().getAmmo() == 0) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1330(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1329(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1328(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1327(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1326(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1325(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 0.8f, -0.0f);
        GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.005f, 0.25f, 0.3f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1324(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.52f, 1.0f, 0.0f);
        GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1323(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.52f, 1.0f, -0.35f);
    }
    
    private static /* synthetic */ void lambda$createGun$1322(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1321(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1320(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1319(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1318(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$1317(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1316(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$1315(final ModelBase model) {
        if (model instanceof AKMiron1) {
            GL11.glTranslatef(0.125f, -1.8f, -0.5f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AKMiron2) {
            GL11.glTranslatef(-0.183f, -1.32f, -5.95f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.6800000071525574);
        }
        else if (model instanceof AK47iron) {
            GL11.glTranslatef(-0.25f, -1.65f, -3.05f);
            GL11.glScaled(0.800000011920929, 0.699999988079071, 0.6000000238418579);
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
    
    private static /* synthetic */ void lambda$createGun$1314(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$1313(final ModelBase model) {
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.011f, 0.59f, 0.05f);
        GL11.glScaled(1.100000023841858, 1.2999999523162842, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$1312(final ModelBase model) {
        GL11.glTranslatef(0.0f, -0.17f, 0.05f);
    }
    
    private static /* synthetic */ void lambda$createGun$1311(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$1310(final ModelBase model) {
        GL11.glTranslatef(-0.14f, -0.81f, -5.96f);
        GL11.glScaled(0.5, 0.5, 3.0);
    }
    
    private static /* synthetic */ void lambda$createGun$1309(final ModelBase model) {
        GL11.glTranslatef(-0.175f, -1.06f, -5.96f);
        GL11.glScaled(0.6000000238418579, 0.550000011920929, 0.5);
    }
    
    private static /* synthetic */ void lambda$createGun$1308(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.06f, -7.55f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$1307(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1306(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$1305(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1304(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$1303(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1302(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$1301(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1300(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$1299(final ItemStack stack) {
        return Arrays.asList("Type: Assault rifle", "Damage: 7.4", "Caliber: 7.62x39mm", "Magazines:", "30rnd 7.62x39mm Magazine", "30rnd 7.62x39mm PMAG Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$1298() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$1297() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$1296() {
        return 0.8f;
    }
}
