package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;

public class MP5KFactory implements GunFactory
{
    public MP5KFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("HKMP5K").withFireRate(0.85f).withRecoil(2.3f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 1).withShootSound("MP5K").withSilencedShootSound("MP5Silenced").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(43L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.16f).withFlashOffsetY(() -> 0.12f).withInaccuracy(2.0f).withCreativeTab(ModernWarfareMod.SMGTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Submachine gun", "Damage: 6.6", "Caliber: 9mm", "Magazines:", "25rnd 9mm Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(Magazines.MP5KMag, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.MP5KGrip, true, model -> {
            if (model instanceof Grip2) {
                GL11.glTranslatef(-0.21f, -0.5f, -2.3f);
                GL11.glScaled(1.0, 0.800000011920929, 1.0);
            }
        }).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof G36CIron1) {
                GL11.glTranslatef(-0.21f, -1.94f, 4.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof G36CIron2) {
                GL11.glTranslatef(-0.18f, -1.25f, -3.05f);
                GL11.glScaled(0.5, 0.5400000214576721, 0.5);
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
                GL11.glTranslatef(-0.1f, -1.235f, -0.2f);
                GL11.glScaled(0.44999998807907104, 0.41999998688697815, 0.44999998807907104);
            }
        }).withCompatibleAttachment(Attachments.Silencer9mm, model -> {
            GL11.glTranslatef(-0.2f, -1.08f, -4.8f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("MP5K", "Electric").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new MP5K()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3199999928474426, 0.3199999928474426, 0.3199999928474426);
            GL11.glTranslatef(1.0f, 1.8f, -1.0f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-1.6f, -0.8f, 1.7f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.425f, 0.925f, -0.55f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.425f, 0.925f, -0.3f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.36f, 0.75f, -0.7f);
            GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {}
        }).withFirstPersonCustomPositioning(Magazines.MP5KMag, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.MP5KGrip.getRenderablePart(), renderContext -> {
            if (renderContext.getWeaponInstance().getAmmo() == 0) {}
        }).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.5f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 250L, 500L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.5f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 250L, 20L), new Transition(renderContext -> {
            GL11.glTranslatef(0.5f, -0.1f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }, 350L, 60L), new Transition(renderContext -> {
            GL11.glTranslatef(0.5f, -0.1f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }, 100L, 0L), new Transition(renderContext -> {
            GL11.glTranslatef(0.5f, -0.1f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }, 100L, 0L), new Transition(renderContext -> {
            GL11.glTranslatef(0.5f, -0.1f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.5f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.5f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.MP5KMag, new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 0.5f, -0.2f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(1.3f, 0.5f, -0.8f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.MP5KMag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.MP5KGrip.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.MP5KGrip.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.36f, 0.75f, -0.8f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {}
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.225f, 1.025f, -0.45f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.65f, 0.65f, 0.025f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 5.0f);
            GL11.glTranslatef(0.48f, 0.08f, 0.05f);
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
            GL11.glTranslatef(1.0f, 0.3f, -0.3f);
            GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.3f, 0.8f, 0.3f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glTranslatef(0.3f, 0.6f, 0.3f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.7f, 0.3f, -0.05f);
            GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.73f, 0.3f, -0.05f);
            GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.73f, 0.3f, -0.05f);
            GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.7f, 0.3f, -0.05f);
            GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
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
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
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
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(6.6f).withSpawnEntityGravityVelocity(0.028f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$7047(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7046(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7045(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.7f, 0.0f, 0.37f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-40.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7044(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.65f, -0.2f, 0.37f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7043(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7042(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7041(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7040(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7039(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7038(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7037(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.7f, 0.3f, -0.05f);
        GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7036(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.73f, 0.3f, -0.05f);
        GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7035(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.73f, 0.3f, -0.05f);
        GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7034(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.7f, 0.3f, -0.05f);
        GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7033(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.3f, 0.6f, 0.3f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7032(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.3f, 0.8f, 0.3f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7031(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7030(final RenderContext renderContext) {
        GL11.glScalef(2.2f, 2.2f, 2.2f);
        GL11.glTranslatef(1.0f, 0.3f, -0.3f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7029(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7028(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 5.0f);
        GL11.glTranslatef(0.48f, 0.08f, 0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7027(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.65f, 0.65f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$7026(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.225f, 1.025f, -0.45f);
    }
    
    private static /* synthetic */ void lambda$createGun$7025(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.36f, 0.75f, -0.8f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {}
    }
    
    private static /* synthetic */ void lambda$createGun$7024(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7023(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7022(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7021(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7020(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7019(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7018(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7017(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7016(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7015(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7014(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7013(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7012(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7011(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7010(final Object renderContext) {
        GL11.glTranslatef(1.3f, 0.5f, -0.8f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7009(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.5f, -0.2f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7008(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.5f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7007(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.5f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7006(final Object renderContext) {
        GL11.glTranslatef(0.5f, -0.1f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7005(final Object renderContext) {
        GL11.glTranslatef(0.5f, -0.1f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7004(final Object renderContext) {
        GL11.glTranslatef(0.5f, -0.1f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7003(final Object renderContext) {
        GL11.glTranslatef(0.5f, -0.1f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7002(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.5f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7001(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.5f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$7000(final RenderContext renderContext) {
        if (renderContext.getWeaponInstance().getAmmo() == 0) {}
    }
    
    private static /* synthetic */ void lambda$createGun$6999(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6998(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.36f, 0.75f, -0.7f);
        GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {}
    }
    
    private static /* synthetic */ void lambda$createGun$6997(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.425f, 0.925f, -0.3f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6996(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.425f, 0.925f, -0.55f);
    }
    
    private static /* synthetic */ void lambda$createGun$6995(final RenderContext renderContext) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-1.6f, -0.8f, 1.7f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6994(final ItemStack itemStack) {
        GL11.glScaled(0.3199999928474426, 0.3199999928474426, 0.3199999928474426);
        GL11.glTranslatef(1.0f, 1.8f, -1.0f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6993(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6992(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.08f, -4.8f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$6991(final ModelBase model) {
        if (model instanceof G36CIron1) {
            GL11.glTranslatef(-0.21f, -1.94f, 4.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof G36CIron2) {
            GL11.glTranslatef(-0.18f, -1.25f, -3.05f);
            GL11.glScaled(0.5, 0.5400000214576721, 0.5);
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
            GL11.glTranslatef(-0.1f, -1.235f, -0.2f);
            GL11.glScaled(0.44999998807907104, 0.41999998688697815, 0.44999998807907104);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6990(final ModelBase model) {
        if (model instanceof Grip2) {
            GL11.glTranslatef(-0.21f, -0.5f, -2.3f);
            GL11.glScaled(1.0, 0.800000011920929, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6989(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$6988(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6987(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$6986(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6985(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$6984(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6983(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$6982(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6981(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ List lambda$createGun$6980(final ItemStack stack) {
        return Arrays.asList("Type: Submachine gun", "Damage: 6.6", "Caliber: 9mm", "Magazines:", "25rnd 9mm Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$6979() {
        return 0.12f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6978() {
        return 0.16f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6977() {
        return 0.8f;
    }
}
