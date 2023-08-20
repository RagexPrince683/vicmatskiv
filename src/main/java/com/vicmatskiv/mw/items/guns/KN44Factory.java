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

public class KN44Factory implements GunFactory
{
    public KN44Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("KN44").withFireRate(0.6f).withRecoil(2.3f).withZoom(0.9f).withMaxShots(Integer.MAX_VALUE, 3, 1).withShootSound("KN44").withSilencedShootSound("MP5Silenced").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(43L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.12f).withFlashOffsetY(() -> 0.12f).withCreativeTab(ModernWarfareMod.FunGunsTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Assault Rifle", "Damage: 7.7", "Caliber: 5.56x39mm", "Magazines:", "30rnd 5.56x39mm Magazine (Type 2)", "45rnd 5.56x39mm Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Desert, (a, i) -> i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Forest, (a, i) -> i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("Forest")), (a, i) -> {}).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
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
                GL11.glScaled(0.23999999463558197, 0.23999999463558197, 0.23999999463558197);
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
                GL11.glTranslatef(-0.15f, -1.32f, -3.253f);
                GL11.glScaled(0.25, 0.25, 0.6000000238418579);
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
            GL11.glTranslatef(-0.17f, -0.4f, -2.4f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.VGrip, model -> {
            GL11.glTranslatef(-0.17f, -0.4f, -2.4f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.Bipod, model -> {
            GL11.glTranslatef(-0.17f, -0.4f, -2.4f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.StubbyGrip, model -> {
            GL11.glTranslatef(-0.17f, -0.4f, -2.4f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }).withCompatibleAttachment(Attachments.Silencer556x39, model -> {
            GL11.glTranslatef(-0.2f, -1.08f, -5.4f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.PSO1, (player, stack) -> {
            GL11.glTranslatef(0.08f, -1.0f, -0.75f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(-0.209f, -0.485f, 1.27f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
            else if (model instanceof PSO12) {
                GL11.glTranslatef(-0.27f, -0.6f, 1.21f);
                GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            }
        }).withTextureNames("KN44").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new KN44()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.36000001430511475, 0.36000001430511475, 0.36000001430511475);
            GL11.glTranslatef(1.0f, 2.0f, -1.4f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-1.6f, -0.8f, 1.7f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.65f, 0.25f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.65f, 0.25f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 1.15f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(0.0f, -0.345f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.315f, -1.17f, 1.95f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
                GL11.glTranslatef(1.333f, -1.25f, 2.15f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.7f, -0.5f, -0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 250L, 500L), new Transition(renderContext -> {
            GL11.glTranslatef(0.7f, -0.5f, -0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 250L, 20L), new Transition(renderContext -> {
            GL11.glTranslatef(0.65f, 0.25f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        }, 350L, 60L), new Transition(renderContext -> {
            GL11.glTranslatef(0.65f, 0.25f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        }, 100L, 0L), new Transition(renderContext -> {
            GL11.glTranslatef(0.65f, 0.25f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        }, 100L, 0L), new Transition(renderContext -> {
            GL11.glTranslatef(0.65f, 0.25f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
            GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        }, 250L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.7f, -0.5f, -0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glTranslatef(0.7f, -0.5f, -0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
        }, 150L, 50L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(0.0f, -0.345f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.315f, -1.17f, 1.9f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
                GL11.glTranslatef(1.333f, -1.25f, 2.15f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
            GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
            GL11.glTranslatef(0.3f, -0.35f, -0.1f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
            GL11.glTranslatef(1.3f, -0.8f, -0.2f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.5f, 0.08f, 0.0f);
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
            GL11.glTranslatef(0.5f, 0.08f, 0.0f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.5f, 0.08f, 0.0f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.5f, 0.08f, 0.0f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.4f, 2.4f, 3.7f);
            GL11.glTranslatef(0.5f, 0.08f, 0.0f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
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
            GL11.glTranslatef(-0.18f, 0.2f, -0.65f);
            GL11.glRotatef(95.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.2f, 0.2f, -0.65f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(75.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.2f, 0.2f, -0.65f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(75.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.18f, 0.2f, -0.65f);
            GL11.glRotatef(95.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
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
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.7f).withSpawnEntityGravityVelocity(0.028f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$4095(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4094(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4093(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.7f, 0.0f, 0.37f);
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-40.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4092(final Object renderContext) {
        GL11.glScalef(1.7f, 1.7f, 3.0f);
        GL11.glTranslatef(0.65f, -0.2f, 0.37f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4091(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.18f, 0.2f, -0.65f);
        GL11.glRotatef(95.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4090(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.2f, 0.2f, -0.65f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4089(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.2f, 0.2f, -0.65f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(75.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4088(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.18f, 0.2f, -0.65f);
        GL11.glRotatef(95.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4087(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4086(final Object renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4085(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.5f, 0.08f, 0.0f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4084(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.5f, 0.08f, 0.0f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4083(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.5f, 0.08f, 0.0f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4082(final Object renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.5f, 0.08f, 0.0f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4081(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.3f, 0.6f, 0.3f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-85.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4080(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glTranslatef(0.3f, 0.8f, 0.3f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4079(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4078(final RenderContext renderContext) {
        GL11.glScalef(2.2f, 2.2f, 2.2f);
        GL11.glTranslatef(1.0f, 0.3f, -0.3f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4077(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4076(final RenderContext renderContext) {
        GL11.glScalef(2.4f, 2.4f, 3.7f);
        GL11.glTranslatef(0.5f, 0.08f, 0.0f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4075(final RenderContext renderContext) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(1.3f, -0.8f, -0.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$4074(final RenderContext renderContext) {
        GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
        GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
        GL11.glTranslatef(0.3f, -0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$4073(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, -0.345f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.315f, -1.17f, 1.9f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
            GL11.glTranslatef(1.333f, -1.25f, 2.15f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4072(final Object renderContext) {
        GL11.glTranslatef(0.7f, -0.5f, -0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$4071(final Object renderContext) {
        GL11.glTranslatef(0.7f, -0.5f, -0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$4070(final Object renderContext) {
        GL11.glTranslatef(0.65f, 0.25f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4069(final Object renderContext) {
        GL11.glTranslatef(0.65f, 0.25f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4068(final Object renderContext) {
        GL11.glTranslatef(0.65f, 0.25f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4067(final Object renderContext) {
        GL11.glTranslatef(0.65f, 0.25f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4066(final Object renderContext) {
        GL11.glTranslatef(0.7f, -0.5f, -0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$4065(final Object renderContext) {
        GL11.glTranslatef(0.7f, -0.5f, -0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$4064(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, -0.345f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.315f, -1.17f, 1.95f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
            GL11.glTranslatef(1.333f, -1.25f, 2.15f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4063(final RenderContext renderContext) {
        GL11.glTranslatef(0.65f, 0.25f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 1.15f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4062(final RenderContext renderContext) {
        GL11.glTranslatef(0.65f, 0.25f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.949999988079071, 0.949999988079071, 0.949999988079071);
        GL11.glTranslatef(-0.4f, -0.7f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$4061(final RenderContext renderContext) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-1.6f, -0.8f, 1.7f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4060(final ItemStack itemStack) {
        GL11.glScaled(0.36000001430511475, 0.36000001430511475, 0.36000001430511475);
        GL11.glTranslatef(1.0f, 2.0f, -1.4f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4059(final ItemStack itemStack) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4058(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(-0.209f, -0.485f, 1.27f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
        else if (model instanceof PSO12) {
            GL11.glTranslatef(-0.27f, -0.6f, 1.21f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4057(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(0.08f, -1.0f, -0.75f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$4056(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.08f, -5.4f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$4055(final ModelBase model) {
        GL11.glTranslatef(-0.17f, -0.4f, -2.4f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$4054(final ModelBase model) {
        GL11.glTranslatef(-0.17f, -0.4f, -2.4f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$4053(final ModelBase model) {
        GL11.glTranslatef(-0.17f, -0.4f, -2.4f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$4052(final ModelBase model) {
        GL11.glTranslatef(-0.17f, -0.4f, -2.4f);
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$4051(final ModelBase model) {
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
            GL11.glScaled(0.23999999463558197, 0.23999999463558197, 0.23999999463558197);
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
            GL11.glTranslatef(-0.15f, -1.32f, -3.253f);
            GL11.glScaled(0.25, 0.25, 0.6000000238418579);
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
    
    private static /* synthetic */ void lambda$createGun$4050(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4049(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("Forest"));
    }
    
    private static /* synthetic */ void lambda$createGun$4048(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4047(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Desert.getTextureVariantIndex("Desert"));
    }
    
    private static /* synthetic */ void lambda$createGun$4046(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4045(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$4044(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4043(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$4042(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4041(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$4040(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4039(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$4038(final ItemStack stack) {
        return Arrays.asList("Type: Assault Rifle", "Damage: 7.7", "Caliber: 5.56x39mm", "Magazines:", "30rnd 5.56x39mm Magazine (Type 2)", "45rnd 5.56x39mm Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$4037() {
        return 0.12f;
    }
    
    private static /* synthetic */ Float lambda$createGun$4036() {
        return 0.12f;
    }
    
    private static /* synthetic */ Float lambda$createGun$4035() {
        return 0.8f;
    }
}
