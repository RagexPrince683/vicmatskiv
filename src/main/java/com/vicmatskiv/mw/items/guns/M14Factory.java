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

public class M14Factory implements GunFactory
{
    public M14Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("M14").withFireRate(0.4f).withRecoil(2.0f).withZoom(0.9f).withMaxShots(1, Integer.MAX_VALUE).withShootSound("M14").withSilencedShootSound("RifleSilencer").withReloadSound("m14reload").withUnloadSound("Unload").withReloadingTime(45L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.06f).withCreativeTab(ModernWarfareMod.SnipersTab).withCrafting(CraftingComplexity.HIGH, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Designated marksmen rifle", "Damage: 14", "Caliber: 7.62x51mm NATO", "Magazines:", "21rnd 7.62x51mm NATO Magazine", "Fire Rate: Semi")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Amber, (a, i) -> i.setActiveTextureIndex(GunSkins.Amber.getTextureVariantIndex("M14Amber")), (a, i) -> {}).withCompatibleAttachment(Magazines.M14DMRMag, model -> {
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
        }).withTextureNames("M14DMR").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new M14DMR()).withEntityPositioning(itemStack -> {
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
        }, 250L, 50L)).build()).withSpawnEntityDamage(14.0f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$4801(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4800(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4799(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.525f, -0.7f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$4798(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.675f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$4797(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.075f, 0.05f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$4796(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.075f, -0.1f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$4795(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.075f, 0.05f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$4794(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4793(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4792(final Object renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4791(final Object renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4790(final Object renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4789(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, -0.675f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$4788(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.525f, -0.7f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$4787(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4786(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$4785(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.33f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4784(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.49f, 0.14f, -0.1f);
        GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4783(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4782(final RenderContext renderContext) {
        GL11.glScalef(4.0f, 4.0f, 7.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4781(final RenderContext renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glRotatef(-25.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.05f, 0.575f, 0.875f);
    }
    
    private static /* synthetic */ void lambda$createGun$4780(final RenderContext renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.4f, 0.9f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$4779(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 0.8f, 0.4f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Leupold)) {
            GL11.glTranslatef(-0.008f, 0.26f, 0.2f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4778(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4777(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4776(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4775(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4774(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4773(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4772(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4771(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4770(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$4769(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4768(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4767(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4766(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4765(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4764(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4763(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4762(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4761(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4760(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4759(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4758(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4757(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$4756(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$4755(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$4754(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$4753(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 1.225f, 0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$4752(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$4751(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.625f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$4750(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4749(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4748(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$4747(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$4746(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4745(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4744(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4743(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4742(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4741(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 0.8f, 0.65f);
        GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Leupold)) {
            GL11.glTranslatef(-0.008f, 0.26f, 0.07f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4740(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(-0.45f, 0.675f, 0.7f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4739(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(-0.45f, 0.675f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$4738(final RenderContext renderContext) {
        GL11.glScaled(0.4699999988079071, 0.4699999988079071, 0.4699999988079071);
        GL11.glTranslatef(-2.0f, -1.6f, 2.2f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4737(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4736(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4735(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.3f, -10.63f);
        GL11.glScaled(1.0, 1.0, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$4734(final ModelBase model) {
        if (model instanceof M14Action2) {
            GL11.glTranslatef(0.0f, 0.02f, 0.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4733(final ModelBase model) {
        if (model instanceof M14Action) {
            GL11.glTranslatef(0.0f, 0.01f, 0.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4732(final ModelBase model) {
        if (model instanceof LeupoldReticle) {
            GL11.glTranslatef(0.076f, -0.52f, 4.0251f);
            GL11.glScaled(0.09000000357627869, 0.09000000357627869, 0.09000000357627869);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4731(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.157f, -1.22f, -2.85f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$4730(final ModelBase model) {
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
    
    private static /* synthetic */ void lambda$createGun$4729(final ModelBase model) {
        GL11.glTranslatef(-0.4f, 0.9f, -2.1f);
        GL11.glScaled(1.399999976158142, 1.5, 1.5);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4728(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4727(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Amber.getTextureVariantIndex("M14Amber"));
    }
    
    private static /* synthetic */ void lambda$createGun$4726(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4725(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$4724(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4723(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$4722(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4721(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$4720(final ItemStack stack) {
        return Arrays.asList("Type: Designated marksmen rifle", "Damage: 14", "Caliber: 7.62x51mm NATO", "Magazines:", "21rnd 7.62x51mm NATO Magazine", "Fire Rate: Semi");
    }
    
    private static /* synthetic */ Float lambda$createGun$4719() {
        return 0.06f;
    }
    
    private static /* synthetic */ Float lambda$createGun$4718() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$4717() {
        return 0.8f;
    }
}
