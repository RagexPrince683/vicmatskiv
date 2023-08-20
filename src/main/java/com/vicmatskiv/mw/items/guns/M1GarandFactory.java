package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;

public class M1GarandFactory implements GunFactory
{
    public M1GarandFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("M1Garand").withAmmoCapacity(8).withFireRate(0.2f).withRecoil(3.0f).withZoom(0.9f).withMaxShots(1).withShootSound("m1Garand").withReloadSound("MosinReload").withUnloadSound("Unload").withReloadingTime(43L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.6f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.08f).withInaccuracy(1.0f).withCreativeTab(ModernWarfareMod.AssaultRiflesTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel", CompatibleBlocks.PLANK).withInformationProvider(stack -> Arrays.asList("Type: Semi-automatic Rifle", "Damage: 15", "Cartridge:", ".30-06 Springfield Bullet", "Fire Rate: Semi")).withCompatibleAttachment(GunSkins.Amethyst, (a, i) -> i.setActiveTextureIndex(GunSkins.Amethyst.getTextureVariantIndex("Amethyst")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Amber, (a, i) -> i.setActiveTextureIndex(GunSkins.Amber.getTextureVariantIndex("Amber")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleBullet(Bullets.BulletSpringfield3006, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof G36CIron1) {
                GL11.glTranslatef(-0.16f, -1.247f, -0.9f);
                GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
            }
            else if (model instanceof G36CIron2) {
                GL11.glTranslatef(-0.16f, -1.16f, -3.0f);
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
                GL11.glTranslatef(-0.153f, -1.25f, -6.15f);
                GL11.glScaled(0.30000001192092896, 0.30000001192092896, 1.2000000476837158);
            }
            else if (model instanceof M14Iron) {
                GL11.glTranslatef(-0.2f, -1.43f, -0.85f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(-0.1f, -1.235f, -0.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withTextureNames("M1Garand").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new M1Garand()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.25, 0.25, 0.25);
            GL11.glTranslatef(1.0f, 2.6f, -2.1f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-1.8f, -1.2f, 2.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.5f, -0.2f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-0.5f, -0.7f, 1.3f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.5f, -0.2f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-0.5f, -0.7f, 1.6f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(0.0f, -0.345f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.315f, -1.21f, 1.8f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.0f, 0.285f, 0.53f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.236f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.236f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.235f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.15f, 3.2f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(Magazines.MP5KMag, renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.525f, 0.2f, 0.775f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.525f, 0.2f, 0.775f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.525f, 0.2f, 0.775f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.825f, 0.5f, 0.65f);
        }, 350L, 250L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.825f, 0.5f, 0.65f);
        }, 350L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.525f, 0.2f, 0.775f);
        }, 250L, 0L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(0.0f, -0.345f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.315f, -1.21f, 1.7f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.0f, 0.285f, 0.53f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.236f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.236f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(0.0f, 0.235f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(1.373f, -1.15f, 3.2f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.05f, 0.05f, 0.325f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.175f, -0.125f, 0.4f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(2.7f, 2.7f, 4.0f);
            GL11.glTranslatef(0.5f, 0.08f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.25f, 0.15f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-7.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(2.7f, 2.7f, 4.0f);
            GL11.glTranslatef(0.6f, 0.2f, -0.1f);
            GL11.glRotatef(125.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.4f, 0.1f, 0.3f);
            GL11.glRotatef(95.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-7.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-130.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(2.2f, 2.2f, 2.2f);
            GL11.glRotatef(-75.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(95.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.475f, -1.05f, -0.1f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.7f, 2.7f, 4.0f);
            GL11.glTranslatef(0.5f, 0.08f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.7f, 2.7f, 4.0f);
            GL11.glTranslatef(0.5f, 0.08f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(2.7f, 2.7f, 4.0f);
            GL11.glTranslatef(0.5f, 0.08f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.7f, 2.7f, 4.0f);
            GL11.glTranslatef(0.5f, 0.08f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.7f, 2.7f, 4.0f);
            GL11.glTranslatef(0.5f, 0.08f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(2.7f, 2.7f, 4.0f);
            GL11.glTranslatef(0.5f, 0.08f, -0.1f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-105.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(155.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.225f, 0.25f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-105.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(155.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.225f, 0.125f, 0.075f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glRotatef(105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(160.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(150.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.4f, -0.25f, 0.225f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.025f, 0.05f, -0.425f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.05f, 0.025f, -0.275f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.5f);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-105.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(155.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.225f, 0.125f, 0.075f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(15.0f).withSpawnEntityGravityVelocity(0.028f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$5220(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-105.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(155.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, 0.125f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5219(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.05f, 0.025f, -0.275f);
    }
    
    private static /* synthetic */ void lambda$createGun$5218(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.025f, 0.05f, -0.425f);
    }
    
    private static /* synthetic */ void lambda$createGun$5217(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glRotatef(105.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(160.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(150.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.4f, -0.25f, 0.225f);
    }
    
    private static /* synthetic */ void lambda$createGun$5216(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-105.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(155.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, 0.125f, 0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$5215(final Object renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.5f);
        GL11.glRotatef(40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-105.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(155.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.225f, 0.25f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5214(final Object renderContext) {
        GL11.glScalef(2.7f, 2.7f, 4.0f);
        GL11.glTranslatef(0.5f, 0.08f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5213(final Object renderContext) {
        GL11.glScalef(2.7f, 2.7f, 4.0f);
        GL11.glTranslatef(0.5f, 0.08f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5212(final Object renderContext) {
        GL11.glScalef(2.7f, 2.7f, 4.0f);
        GL11.glTranslatef(0.5f, 0.08f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5211(final Object renderContext) {
        GL11.glScalef(2.7f, 2.7f, 4.0f);
        GL11.glTranslatef(0.5f, 0.08f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5210(final Object renderContext) {
        GL11.glScalef(2.7f, 2.7f, 4.0f);
        GL11.glTranslatef(0.5f, 0.08f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5209(final Object renderContext) {
        GL11.glScalef(2.7f, 2.7f, 4.0f);
        GL11.glTranslatef(0.5f, 0.08f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5208(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5207(final RenderContext renderContext) {
        GL11.glScalef(2.2f, 2.2f, 2.2f);
        GL11.glRotatef(-75.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(95.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.475f, -1.05f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$5206(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.4f, 0.1f, 0.3f);
        GL11.glRotatef(95.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-7.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-130.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5205(final RenderContext renderContext) {
        GL11.glScalef(2.7f, 2.7f, 4.0f);
        GL11.glTranslatef(0.6f, 0.2f, -0.1f);
        GL11.glRotatef(125.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5204(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.25f, 0.15f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-7.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-110.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5203(final RenderContext renderContext) {
        GL11.glScalef(2.7f, 2.7f, 4.0f);
        GL11.glTranslatef(0.5f, 0.08f, -0.1f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5202(final RenderContext renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.175f, -0.125f, 0.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$5201(final RenderContext renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.05f, 0.05f, 0.325f);
    }
    
    private static /* synthetic */ void lambda$createGun$5200(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, -0.345f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.315f, -1.21f, 1.7f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.0f, 0.285f, 0.53f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.236f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.236f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.235f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.15f, 3.2f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5199(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 0.2f, 0.775f);
    }
    
    private static /* synthetic */ void lambda$createGun$5198(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.825f, 0.5f, 0.65f);
    }
    
    private static /* synthetic */ void lambda$createGun$5197(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.825f, 0.5f, 0.65f);
    }
    
    private static /* synthetic */ void lambda$createGun$5196(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 0.2f, 0.775f);
    }
    
    private static /* synthetic */ void lambda$createGun$5195(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 0.2f, 0.775f);
    }
    
    private static /* synthetic */ void lambda$createGun$5194(final Object renderContext) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.525f, 0.2f, 0.775f);
    }
    
    private static /* synthetic */ void lambda$createGun$5193(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$5192(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, -0.345f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.315f, -1.21f, 1.8f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-1.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.0f, 0.285f, 0.53f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.236f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.236f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(0.0f, 0.235f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(1.373f, -1.15f, 3.2f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5191(final RenderContext renderContext) {
        GL11.glTranslatef(0.5f, -0.2f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-0.5f, -0.7f, 1.6f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5190(final RenderContext renderContext) {
        GL11.glTranslatef(0.5f, -0.2f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-0.5f, -0.7f, 1.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$5189(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.2f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5188(final ItemStack itemStack) {
        GL11.glScaled(0.25, 0.25, 0.25);
        GL11.glTranslatef(1.0f, 2.6f, -2.1f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5187(final ItemStack itemStack) {
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$5186(final ModelBase model) {
        if (model instanceof G36CIron1) {
            GL11.glTranslatef(-0.16f, -1.247f, -0.9f);
            GL11.glScaled(0.20000000298023224, 0.20000000298023224, 0.20000000298023224);
        }
        else if (model instanceof G36CIron2) {
            GL11.glTranslatef(-0.16f, -1.16f, -3.0f);
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
            GL11.glTranslatef(-0.153f, -1.25f, -6.15f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 1.2000000476837158);
        }
        else if (model instanceof M14Iron) {
            GL11.glTranslatef(-0.2f, -1.43f, -0.85f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof MP5Iron) {
            GL11.glTranslatef(-0.1f, -1.235f, -0.2f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$5185(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$5184(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5183(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$5182(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5181(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Amber.getTextureVariantIndex("Amber"));
    }
    
    private static /* synthetic */ void lambda$createGun$5180(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$5179(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Amethyst.getTextureVariantIndex("Amethyst"));
    }
    
    private static /* synthetic */ List lambda$createGun$5178(final ItemStack stack) {
        return Arrays.asList("Type: Semi-automatic Rifle", "Damage: 15", "Cartridge:", ".30-06 Springfield Bullet", "Fire Rate: Semi");
    }
    
    private static /* synthetic */ Float lambda$createGun$5177() {
        return 0.08f;
    }
    
    private static /* synthetic */ Float lambda$createGun$5176() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$5175() {
        return 0.6f;
    }
}
