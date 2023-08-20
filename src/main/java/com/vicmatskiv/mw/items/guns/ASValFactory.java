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

public class ASValFactory implements GunFactory
{
    public ASValFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("ASVal").withFireRate(0.5f).withRecoil(2.8f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 1).withShootSound("VSSVintorez").withReloadSound("vssvintorezreload").withUnloadSound("akunload").withReloadingTime(45L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.0f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.1f).withInaccuracy(2.0f).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, CommonProxy.MetalComponents, "ingotSteel").withCreativeTab(ModernWarfareMod.SnipersTab).withInformationProvider(stack -> Arrays.asList("Type: Suppressed Assault Rifle", "Damage: 10", "Caliber: 9x39mm", "Magazines:", "10rnd 9x39mm Magazine", "20rnd 9x39mm Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Arctic, (a, i) -> i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(AuxiliaryAttachments.VSSVintorezAction, true, model -> {}).withCompatibleAttachment(Attachments.PSO1, (player, stack) -> {
            GL11.glTranslatef(0.14f, -0.9f, -1.2f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(-0.209f, -0.485f, 1.27f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
            else if (model instanceof PSO12) {
                GL11.glTranslatef(-0.27f, -0.6f, 1.21f);
                GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            }
        }).withCompatibleAttachment(Magazines.VSSVintorezMag, model -> {
            GL11.glTranslatef(-0.3f, 0.5f, -1.6f);
            GL11.glScaled(0.8999999761581421, 1.399999976158142, 1.399999976158142);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        }).withCompatibleAttachment(Magazines.ASValMag, model -> {
            GL11.glTranslatef(-0.3f, 0.5f, -1.6f);
            GL11.glScaled(0.8999999761581421, 1.399999976158142, 1.399999976158142);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        }).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof AKMiron1) {
                GL11.glTranslatef(0.125f, -1.8f, -0.5f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AKMiron2) {
                GL11.glTranslatef(0.14f, -1.49f, -3.04f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AK47iron) {
                GL11.glTranslatef(-0.23f, -1.56f, -4.0f);
                GL11.glScaled(0.699999988079071, 0.8500000238418579, 0.699999988079071);
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
                GL11.glTranslatef(-0.175f, -1.2f, -6.26f);
                GL11.glScaled(0.5, 0.5, 1.0);
            }
            else if (model instanceof M14Iron) {
                GL11.glTranslatef(0.129f, -1.63f, -2.08f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(0.215f, -1.54f, 1.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withTextureNames("ASVal").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new ASVal()).withEntityPositioning(itemStack -> {
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
            GL11.glScaled(3.0, 3.0, 3.0);
            GL11.glTranslatef(-0.475f, 0.875f, -0.225f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(3.0, 3.0, 3.0);
            GL11.glTranslatef(-0.475f, 0.875f, 0.1f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 0.675f, -0.0f);
            GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
                GL11.glTranslatef(-0.015f, 0.273f, -0.14f);
            }
        }).withFirstPersonCustomPositioning(Magazines.VSSVintorezMag, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.VSSVintorezMag, renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.VSSVintorezMag, renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonCustomPositioning(Magazines.ASValMag, renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.ASValMag, renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.ASValMag, renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.0f)).withFirstPersonCustomPositioning(AuxiliaryAttachments.VSSVintorezAction.getRenderablePart(), renderContext -> {
            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.VSSVintorezAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.VSSVintorezAction.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
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
            GL11.glScalef(2.0f, 2.0f, 2.0f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.325f, 0.575f, 0.25f);
        }, 400L, 100L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.0f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.325f, 0.575f, 0.25f);
        }, 120L, 100L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.0f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.325f, 0.575f, 0.25f);
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
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.VSSVintorezMag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 1.5f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.VSSVintorezMag, new Transition(renderContext -> GL11.glTranslatef(0.0f, 1.5f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.ASValMag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 1.5f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.ASValMag, new Transition(renderContext -> GL11.glTranslatef(0.0f, 1.5f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.VSSVintorezAction.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.VSSVintorezAction.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 0.675f, -0.2f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
                GL11.glTranslatef(-0.015f, 0.273f, 0.0f);
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
            GL11.glScalef(3.0f, 3.0f, 4.0f);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(105.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.075f, -0.35f, -0.475f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.49f, 0.14f, 0.1f);
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
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-40.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.2f, -0.125f, -0.075f);
        }, 260L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.1f, -0.35f, -0.05f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-40.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.2f, -0.125f, -0.075f);
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
        }, 250L, 50L)).build()).withSpawnEntityDamage(10.0f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$1899(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1898(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1897(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.075f, -0.7f, 0.725f);
    }
    
    private static /* synthetic */ void lambda$createGun$1896(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.3f, -0.625f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1895(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-40.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.2f, -0.125f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1894(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.1f, -0.35f, -0.05f);
    }
    
    private static /* synthetic */ void lambda$createGun$1893(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-40.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.2f, -0.125f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1892(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1891(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1890(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1889(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1888(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.5f, 0.1f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1887(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-65.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.3f, -0.625f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1886(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(55.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.075f, -0.7f, 0.725f);
    }
    
    private static /* synthetic */ void lambda$createGun$1885(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1884(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.375f, -0.8f, 0.15f);
    }
    
    private static /* synthetic */ void lambda$createGun$1883(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.33f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1882(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.49f, 0.14f, 0.1f);
        GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1881(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$1880(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 4.0f);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(105.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.075f, -0.35f, -0.475f);
    }
    
    private static /* synthetic */ void lambda$createGun$1879(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.149999f, 0.45f, 0.525f);
    }
    
    private static /* synthetic */ void lambda$createGun$1878(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.35f, 1.025f, -0.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$1877(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 0.675f, -0.2f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
            GL11.glTranslatef(-0.015f, 0.273f, 0.0f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1876(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1875(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1874(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1873(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1872(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1871(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1870(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1869(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1868(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1867(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1866(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1865(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1864(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1863(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1862(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1861(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1860(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1859(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1858(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1857(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1856(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1855(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1854(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1853(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.325f, 0.575f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$1852(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.325f, 0.575f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$1851(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.325f, 0.575f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$1850(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1849(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 0.075f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$1848(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1847(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1846(final RenderContext renderContext) {
        if (renderContext.getWeaponInstance().getAmmo() == 0) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1845(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1844(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1843(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1842(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1841(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1840(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$1839(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 0.675f, -0.0f);
        GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
            GL11.glTranslatef(-0.015f, 0.273f, -0.14f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1838(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(3.0, 3.0, 3.0);
        GL11.glTranslatef(-0.475f, 0.875f, 0.1f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1837(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(3.0, 3.0, 3.0);
        GL11.glTranslatef(-0.475f, 0.875f, -0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$1836(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1835(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1834(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1833(final ModelBase model) {
        if (model instanceof AKMiron1) {
            GL11.glTranslatef(0.125f, -1.8f, -0.5f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AKMiron2) {
            GL11.glTranslatef(0.14f, -1.49f, -3.04f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AK47iron) {
            GL11.glTranslatef(-0.23f, -1.56f, -4.0f);
            GL11.glScaled(0.699999988079071, 0.8500000238418579, 0.699999988079071);
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
            GL11.glTranslatef(-0.175f, -1.2f, -6.26f);
            GL11.glScaled(0.5, 0.5, 1.0);
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
    
    private static /* synthetic */ void lambda$createGun$1832(final ModelBase model) {
        GL11.glTranslatef(-0.3f, 0.5f, -1.6f);
        GL11.glScaled(0.8999999761581421, 1.399999976158142, 1.399999976158142);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1831(final ModelBase model) {
        GL11.glTranslatef(-0.3f, 0.5f, -1.6f);
        GL11.glScaled(0.8999999761581421, 1.399999976158142, 1.399999976158142);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$1830(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(-0.209f, -0.485f, 1.27f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
        else if (model instanceof PSO12) {
            GL11.glTranslatef(-0.27f, -0.6f, 1.21f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$1829(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(0.14f, -0.9f, -1.2f);
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$1828(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$1827(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1826(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$1825(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1824(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$1823(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1822(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic"));
    }
    
    private static /* synthetic */ void lambda$createGun$1821(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$1820(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ List lambda$createGun$1819(final ItemStack stack) {
        return Arrays.asList("Type: Suppressed Assault Rifle", "Damage: 10", "Caliber: 9x39mm", "Magazines:", "10rnd 9x39mm Magazine", "20rnd 9x39mm Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$1818() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$1817() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$1816() {
        return 0.0f;
    }
}
