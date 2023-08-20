package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;

public class M21Factory implements GunFactory
{
    public M21Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("M21").withFireRate(0.4f).withRecoil(2.0f).withZoom(0.9f).withMaxShots(1).withShootSound("M21").withSilencedShootSound("RifleSilencer").withReloadSound("m14reload").withUnloadSound("Unload").withReloadingTime(45L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.06f).withCreativeTab(ModernWarfareMod.SnipersTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, CommonProxy.MetalComponents, CompatibleBlocks.PLANK).withInformationProvider(stack -> Arrays.asList("Type: Sniper", "Damage: 14", "Caliber: 7.62x51mm NATO", "Magazines:", "21rnd 7.62x51mm NATO Magazine", "Fire Rate: Semi")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(Magazines.M14DMRMag, model -> {
            GL11.glTranslatef(-0.4f, 0.9f, -2.1f);
            GL11.glScaled(1.399999976158142, 1.5, 1.5);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        }).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof AKMiron1) {
                GL11.glTranslatef(0.125f, -1.8f, -0.5f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof M14Iron) {
                GL11.glTranslatef(-0.215f, -1.58f, -1.34f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof AKMiron2) {
                GL11.glTranslatef(0.129f, -1.63f, -5.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof FALIron) {
                GL11.glTranslatef(-0.163f, -1.36f, -8.512f);
                GL11.glScaled(0.36000001430511475, 0.36000001430511475, 0.699999988079071);
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
                GL11.glTranslatef(-0.165f, -1.36f, -1.4f);
                GL11.glScaled(0.23000000417232513, 0.23000000417232513, 0.23000000417232513);
            }
            else if (model instanceof G36CIron2) {
                GL11.glTranslatef(-0.205f, -1.9f, -3.15f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof ScarIron1) {
                GL11.glTranslatef(0.177f, -1.65f, 1.4f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof ScarIron2) {
                GL11.glTranslatef(0.25f, -1.55f, -2.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(0.215f, -1.54f, 1.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withCompatibleAttachment(Attachments.Leupold, (player, stack) -> {
            GL11.glTranslatef(-0.157f, -1.22f, -2.85f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        }, model -> {
            if (model instanceof LeupoldReticle) {
                GL11.glTranslatef(0.076f, -0.52f, 4.0251f);
                GL11.glScaled(0.09000000357627869, 0.09000000357627869, 0.09000000357627869);
            }
        }).withCompatibleAttachment(AuxiliaryAttachments.M14Action, true, model -> {
            if (model instanceof M14Action) {
                GL11.glTranslatef(0.0f, 0.01f, 0.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
        }).withCompatibleAttachment(AuxiliaryAttachments.M14Action2, true, model -> {
            if (model instanceof M14Action2) {
                GL11.glTranslatef(0.0f, 0.02f, 0.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
        }).withCompatibleAttachment(Attachments.Silencer762x51, model -> {
            GL11.glTranslatef(-0.2f, -1.3f, -10.63f);
            GL11.glScaled(1.0, 1.0, 1.2000000476837158);
        }).withTextureNames("M21").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new M21()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
            GL11.glTranslatef(1.0f, 2.0f, -1.2f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.4699999988079071, 0.4699999988079071, 0.4699999988079071);
            GL11.glTranslatef(-2.0f, -1.6f, 2.2f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(2.0f, 2.0f, 2.0f);
            GL11.glTranslatef(-0.45f, 0.675f, 0.15f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(2.0f, 2.0f, 2.0f);
            GL11.glTranslatef(-0.45f, 0.675f, 0.7f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 0.8f, 0.65f);
            GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Leupold)) {
                GL11.glTranslatef(-0.008f, 0.26f, 0.07f);
            }
        }).withFirstPersonCustomPositioning(Magazines.M14DMRMag, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.M14DMRMag, renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.M14DMRMag, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.M14Action.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.M14Action2.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.M14Action.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.2f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.M14Action.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.2f)).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.M14Action2.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.34f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.M14Action2.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.34f)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
        }, 350L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
        }, 450L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
        }, 350L, 160L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
        }, 200L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
        }, 230L, 50L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.M14DMRMag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.M14DMRMag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.M14Action.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.M14Action.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.2f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.M14Action2.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.M14Action2.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.34f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 0.8f, 0.4f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Leupold)) {
                GL11.glTranslatef(-0.008f, 0.26f, 0.2f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.4f, 0.9f, 0.15f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.0f);
            GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.05f, 0.575f, 0.875f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(4.0f, 4.0f, 7.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.5f, 0.075f);
        }).withFirstPersonHandPositioningRunning(renderContext -> {
            GL11.glScalef(4.0f, 4.0f, 7.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.325f, -0.425f, 0.025f);
        }).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.49f, 0.14f, -0.1f);
            GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.5f, 0.075f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.375f, -0.8f, 0.15f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.5f, 0.075f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.525f, -0.7f, 0.1f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.225f, -0.675f, 0.1f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(4.0f, 4.0f, 7.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(4.0f, 4.0f, 7.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(4.0f, 4.0f, 7.0f);
            GL11.glTranslatef(0.5f, 0.1f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.5f, 0.075f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.5f, 0.075f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.075f, 0.05f, 0.225f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.075f, -0.1f, 0.225f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.075f, 0.05f, 0.225f);
        }, 250L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.225f, -0.675f, 0.1f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.525f, -0.7f, 0.1f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.5f, 0.075f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.25f, -0.5f, 0.075f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(14.0f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$5309(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5308(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5307(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.525f, -0.7f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$5306(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.675f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$5305(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.075f, 0.05f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$5304(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.075f, -0.1f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$5303(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.075f, 0.05f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$5302(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5301(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5300(final Object renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5299(final Object renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5298(final Object renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5297(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.675f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$5296(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.525f, -0.7f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$5295(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5294(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5293(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5292(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.49f, 0.14f, -0.1f);
        GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5291(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.325f, -0.425f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$5290(final RenderContext renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5289(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-85.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.25f, -0.5f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5288(final RenderContext renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5287(final RenderContext renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.05f, 0.575f, 0.875f);
    }
    
    private static /* synthetic */ void lambda$createGun$5286(final RenderContext renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.4f, 0.9f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5285(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 0.8f, 0.4f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Leupold)) {
            GL11.glTranslatef(-0.008f, 0.26f, 0.2f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5284(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5283(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$5282(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5281(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5280(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5279(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5278(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5277(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5276(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$5275(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5274(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5273(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5272(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5271(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5270(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5269(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5268(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5267(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5266(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5265(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5264(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5263(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$5262(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$5261(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$5260(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$5259(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$5258(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$5257(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$5256(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$5255(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$5254(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$5253(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$5252(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5251(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5250(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5249(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5248(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5247(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 0.8f, 0.65f);
        GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Leupold)) {
            GL11.glTranslatef(-0.008f, 0.26f, 0.07f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5246(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(-0.45f, 0.675f, 0.7f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5245(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(-0.45f, 0.675f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$5244(final RenderContext renderContext) {
        GL11.glScaled(0.4699999988079071, 0.4699999988079071, 0.4699999988079071);
        GL11.glTranslatef(-2.0f, -1.6f, 2.2f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5243(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5242(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5241(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.3f, -10.63f);
        GL11.glScaled(1.0, 1.0, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$5240(final ModelBase model) {
        if (model instanceof M14Action2) {
            GL11.glTranslatef(0.0f, 0.02f, 0.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5239(final ModelBase model) {
        if (model instanceof M14Action) {
            GL11.glTranslatef(0.0f, 0.01f, 0.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5238(final ModelBase model) {
        if (model instanceof LeupoldReticle) {
            GL11.glTranslatef(0.076f, -0.52f, 4.0251f);
            GL11.glScaled(0.09000000357627869, 0.09000000357627869, 0.09000000357627869);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5237(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.157f, -1.22f, -2.85f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$5236(final ModelBase model) {
        if (model instanceof AKMiron1) {
            GL11.glTranslatef(0.125f, -1.8f, -0.5f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof M14Iron) {
            GL11.glTranslatef(-0.215f, -1.58f, -1.34f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof AKMiron2) {
            GL11.glTranslatef(0.129f, -1.63f, -5.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof FALIron) {
            GL11.glTranslatef(-0.163f, -1.36f, -8.512f);
            GL11.glScaled(0.36000001430511475, 0.36000001430511475, 0.699999988079071);
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
            GL11.glTranslatef(-0.165f, -1.36f, -1.4f);
            GL11.glScaled(0.23000000417232513, 0.23000000417232513, 0.23000000417232513);
        }
        else if (model instanceof G36CIron2) {
            GL11.glTranslatef(-0.205f, -1.9f, -3.15f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof ScarIron1) {
            GL11.glTranslatef(0.177f, -1.65f, 1.4f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof ScarIron2) {
            GL11.glTranslatef(0.25f, -1.55f, -2.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof MP5Iron) {
            GL11.glTranslatef(0.215f, -1.54f, 1.2f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5235(final ModelBase model) {
        GL11.glTranslatef(-0.4f, 0.9f, -2.1f);
        GL11.glScaled(1.399999976158142, 1.5, 1.5);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5234(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5233(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$5232(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5231(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$5230(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5229(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$5228(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5227(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$5226(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5225(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$5224(final ItemStack stack) {
        return Arrays.asList("Type: Sniper", "Damage: 14", "Caliber: 7.62x51mm NATO", "Magazines:", "21rnd 7.62x51mm NATO Magazine", "Fire Rate: Semi");
    }
    
    private static /* synthetic */ Float lambda$createGun$5223() {
        return 0.06f;
    }
    
    private static /* synthetic */ Float lambda$createGun$5222() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$5221() {
        return 0.8f;
    }
}
