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

public class M8A7Factory implements GunFactory
{
    public M8A7Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("M8A7").withFireRate(0.9f).withRecoil(2.4f).withZoom(0.9f).withMaxShots(4).withShootSound("M8A7").withSilencedShootSound("MP5Silenced").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(43L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.12f).withFlashOffsetY(() -> 0.12f).withCreativeTab(ModernWarfareMod.FunGunsTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Assault Rifle", "Damage: 7.9", "Caliber: .300 AAC Blackout", "Magazines:", "32rnd .300 AAC Blackout Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Desert, (a, i) -> i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(Magazines.M8A7Mag, model -> GL11.glTranslatef(0.0f, -0.05f, 0.0f)).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof G36CIron1) {
                GL11.glTranslatef(-0.17f, -1.155f, -0.1f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof G36CIron2) {
                GL11.glTranslatef(-0.16f, -1.15f, -3.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof AKMiron1) {
                GL11.glTranslatef(-0.157f, -1.425f, -1.57f);
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
                GL11.glTranslatef(-0.144f, -1.61f, 0.0f);
                GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
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
                GL11.glTranslatef(-0.164f, -1.6f, -3.85f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof M14Iron) {
                GL11.glTranslatef(0.129f, -1.63f, -2.08f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(-0.1f, -1.235f, -0.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withCompatibleAttachment(Attachments.Grip2, model -> {
            GL11.glTranslatef(-0.2f, -0.1f, -2.9f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.VGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.1f, -2.9f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Bipod, model -> {
            GL11.glTranslatef(-0.2f, -0.1f, -2.9f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.StubbyGrip, model -> {
            GL11.glTranslatef(-0.2f, -0.1f, -2.9f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Silencer300AACBlackout, model -> {
            GL11.glTranslatef(-0.2f, -1.11f, -6.8f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("M8A7").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new M8A7()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.25, 0.25, 0.25);
            GL11.glTranslatef(1.0f, 2.0f, -1.4f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-1.9f, -1.0f, 2.1f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.32f, 0.15f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.32f, 0.15f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glTranslatef(-0.4f, -0.7f, 1.2f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(0.07f, -0.39f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-0.2f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(0.315f, -1.17f, 2.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
                GL11.glTranslatef(1.333f, -1.25f, 2.15f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(Magazines.M8A7Mag, renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.7f, -0.5f, -0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 250L, 500L), new Transition(renderContext -> {
            GL11.glTranslatef(0.7f, -0.5f, -0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 250L, 20L), new Transition(renderContext -> {
            GL11.glTranslatef(0.32f, 0.15f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        }, 350L, 60L), new Transition(renderContext -> {
            GL11.glTranslatef(0.32f, 0.15f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        }, 100L, 0L), new Transition(renderContext -> {
            GL11.glTranslatef(0.32f, 0.15f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        }, 100L, 0L), new Transition(renderContext -> {
            GL11.glTranslatef(0.32f, 0.15f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        }, 250L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.7f, -0.5f, -0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glTranslatef(0.7f, -0.5f, -0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.M8A7Mag, new Transition(renderContext -> {
            GL11.glTranslatef(0.0f, 0.5f, -0.2f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(1.3f, 0.5f, -0.8f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.M8A7Mag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(0.07f, -0.39f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(0.315f, -1.17f, 1.9f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
                GL11.glTranslatef(1.333f, -1.25f, 2.15f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
            GL11.glTranslatef(0.3f, -0.25f, -0.1f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
            GL11.glTranslatef(1.3f, -1.2f, -0.2f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.2f, 3.2f, 4.6f);
            GL11.glTranslatef(0.5f, 0.08f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.9f, 0.5f, -0.4f);
            GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
        }, renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.3f, 2.3f, 2.5f);
            GL11.glTranslatef(0.3f, 0.8f, 0.3f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.3f, 2.3f, 2.5f);
            GL11.glTranslatef(0.3f, 0.6f, 0.3f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.7f, 0.25f, 0.2f);
            GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.73f, 0.25f, 0.2f);
            GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.73f, 0.25f, 0.2f);
            GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.7f, 0.25f, 0.2f);
            GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
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
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(2.8f, 2.8f, 3.3f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.9f).withSpawnEntityGravityVelocity(0.028f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$6135(final Object renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6134(final Object renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6133(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.7f, 0.0f, 0.37f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-40.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6132(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.65f, -0.2f, 0.37f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6131(final Object renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6130(final Object renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6129(final Object renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6128(final Object renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6127(final Object renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6126(final Object renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6125(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.7f, 0.25f, 0.2f);
        GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6124(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.73f, 0.25f, 0.2f);
        GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6123(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.73f, 0.25f, 0.2f);
        GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6122(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.7f, 0.25f, 0.2f);
        GL11.glRotatef(160.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(50.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6121(final Object renderContext) {
        GL11.glScalef(2.3f, 2.3f, 2.5f);
        GL11.glTranslatef(0.3f, 0.6f, 0.3f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6120(final Object renderContext) {
        GL11.glScalef(2.3f, 2.3f, 2.5f);
        GL11.glTranslatef(0.3f, 0.8f, 0.3f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6119(final RenderContext renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6118(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.9f, 0.5f, -0.4f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6117(final RenderContext renderContext) {
        GL11.glScalef(2.8f, 2.8f, 3.3f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.45f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6116(final RenderContext renderContext) {
        GL11.glScalef(3.2f, 3.2f, 4.6f);
        GL11.glTranslatef(0.5f, 0.08f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6115(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(1.3f, -1.2f, -0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6114(final RenderContext renderContext) {
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
        GL11.glTranslatef(0.3f, -0.25f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$6113(final RenderContext renderContext) {
        GL11.glTranslatef(0.07f, -0.39f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(0.315f, -1.17f, 1.9f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
            GL11.glTranslatef(1.333f, -1.25f, 2.15f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6112(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6111(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6110(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6109(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6108(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6107(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6106(final Object renderContext) {
        GL11.glTranslatef(1.3f, 0.5f, -0.8f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6105(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.5f, -0.2f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6104(final Object renderContext) {
        GL11.glTranslatef(0.7f, -0.5f, -0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6103(final Object renderContext) {
        GL11.glTranslatef(0.7f, -0.5f, -0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6102(final Object renderContext) {
        GL11.glTranslatef(0.32f, 0.15f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6101(final Object renderContext) {
        GL11.glTranslatef(0.32f, 0.15f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6100(final Object renderContext) {
        GL11.glTranslatef(0.32f, 0.15f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6099(final Object renderContext) {
        GL11.glTranslatef(0.32f, 0.15f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6098(final Object renderContext) {
        GL11.glTranslatef(0.7f, -0.5f, -0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6097(final Object renderContext) {
        GL11.glTranslatef(0.7f, -0.5f, -0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6096(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6095(final RenderContext renderContext) {
        GL11.glTranslatef(0.07f, -0.39f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-0.2f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(0.315f, -1.17f, 2.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
            GL11.glTranslatef(1.333f, -1.25f, 2.15f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6094(final RenderContext renderContext) {
        GL11.glTranslatef(0.32f, 0.15f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glTranslatef(-0.4f, -0.7f, 1.2f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6093(final RenderContext renderContext) {
        GL11.glTranslatef(0.32f, 0.15f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$6092(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.9f, -1.0f, 2.1f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6091(final ItemStack itemStack) {
        GL11.glScaled(0.25, 0.25, 0.25);
        GL11.glTranslatef(1.0f, 2.0f, -1.4f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6090(final ItemStack itemStack) {
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6089(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.11f, -6.8f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$6088(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.1f, -2.9f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$6087(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.1f, -2.9f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$6086(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.1f, -2.9f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$6085(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.1f, -2.9f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$6084(final ModelBase model) {
        if (model instanceof G36CIron1) {
            GL11.glTranslatef(-0.17f, -1.155f, -0.1f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof G36CIron2) {
            GL11.glTranslatef(-0.16f, -1.15f, -3.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof AKMiron1) {
            GL11.glTranslatef(-0.157f, -1.425f, -1.57f);
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
            GL11.glTranslatef(-0.144f, -1.61f, 0.0f);
            GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
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
            GL11.glTranslatef(-0.164f, -1.6f, -3.85f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof M14Iron) {
            GL11.glTranslatef(0.129f, -1.63f, -2.08f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof MP5Iron) {
            GL11.glTranslatef(-0.1f, -1.235f, -0.2f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6083(final ModelBase model) {
        GL11.glTranslatef(0.0f, -0.05f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6082(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6081(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$6080(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6079(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert"));
    }
    
    private static /* synthetic */ void lambda$createGun$6078(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6077(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$6076(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6075(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$6074(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6073(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$6072(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6071(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$6070(final ItemStack stack) {
        return Arrays.asList("Type: Assault Rifle", "Damage: 7.9", "Caliber: .300 AAC Blackout", "Magazines:", "32rnd .300 AAC Blackout Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$6069() {
        return 0.12f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6068() {
        return 0.12f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6067() {
        return 0.8f;
    }
}
