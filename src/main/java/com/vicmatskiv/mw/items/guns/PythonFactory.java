package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;

public class PythonFactory implements GunFactory
{
    public PythonFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("Python").withAmmoCapacity(6).withFireRate(0.2f).withRecoil(5.0f).withZoom(0.9f).withMaxShots(1).withShootSound("Python").withReloadSound("MagnumReload").withReloadingTime(25L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.5f).withFlashOffsetX(() -> 0.2f).withFlashOffsetY(() -> 0.1f).withInaccuracy(4.0f).withCreativeTab(ModernWarfareMod.PistolsTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate).withInformationProvider(stack -> Arrays.asList("Type: Revolver", "Damage: 6", "Ammo: .357 Bullet", "Fire Rate: Semi")).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Arctic, (a, i) -> i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic")), (a, i) -> {}).withCompatibleAttachment(AuxiliaryAttachments.PythonCase, true, model -> {}).withCompatibleBullet(Bullets.Bullet357, model -> {}).withTextureNames("Python", "MagnumGold").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new Python()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glTranslatef(-0.9f, 0.6f, 0.5f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
            GL11.glTranslatef(-2.0f, -1.1f, 2.2f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.1f, -0.5f, -1.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.1f, -0.5f, -1.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.PythonCase.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.PythonCase.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(-0.4f, -0.3f, -0.6f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(0.23f, -1.19f, 1.3f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(-0.01f, 0.44f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(1.37f, -1.226f, 3.2f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(AuxiliaryAttachments.PythonCase.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(-0.1f, -0.1f, -0.9f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glTranslatef(-0.1f, -0.1f, -0.9f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        }, 250L, 100L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.PythonCase.getRenderablePart(), new Transition(renderContext -> {
            GL11.glTranslatef(-0.6f, 0.8f, -1.3f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glTranslatef(-0.6f, 0.8f, -1.3f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        }, 250L, 50L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(-0.4f, -0.195f, -0.6f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(0.23f, -1.19f, 1.5f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(-0.01f, 0.44f, 0.6f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(1.37f, -1.226f, 3.2f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glTranslatef(0.1f, -1.5f, -1.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
            GL11.glTranslatef(-1.0f, 0.1f, 0.0f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.6f, -0.1f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(1.6f, 1.6f, 1.6f);
            GL11.glTranslatef(1.5f, 0.1f, -0.2f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.1f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.65f, 0.3f, 0.4f);
            GL11.glRotatef(130.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(70.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.65f, 0.3f, 0.4f);
            GL11.glRotatef(130.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(70.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 200L)).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.4f, -0.1f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.34f, 0.48f, 0.3f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        }).build()).withSpawnEntityDamage(6.0f).withSpawnEntityGravityVelocity(0.016f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$7862(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.34f, 0.48f, 0.3f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7861(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.4f, -0.1f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7860(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7859(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7858(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.65f, 0.3f, 0.4f);
        GL11.glRotatef(130.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7857(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.65f, 0.3f, 0.4f);
        GL11.glRotatef(130.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7856(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.1f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7855(final RenderContext renderContext) {
        GL11.glScalef(1.6f, 1.6f, 1.6f);
        GL11.glTranslatef(1.5f, 0.1f, -0.2f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7854(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7853(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.6f, -0.1f, 0.4f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7852(final RenderContext renderContext) {
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(-1.0f, 0.1f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7851(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -1.5f, -1.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$7850(final RenderContext renderContext) {
        GL11.glTranslatef(-0.4f, -0.195f, -0.6f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(0.23f, -1.19f, 1.5f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(-0.01f, 0.44f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(1.37f, -1.226f, 3.2f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7849(final Object renderContext) {
        GL11.glTranslatef(-0.6f, 0.8f, -1.3f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$7848(final Object renderContext) {
        GL11.glTranslatef(-0.6f, 0.8f, -1.3f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$7847(final Object renderContext) {
        GL11.glTranslatef(-0.1f, -0.1f, -0.9f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$7846(final Object renderContext) {
        GL11.glTranslatef(-0.1f, -0.1f, -0.9f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$7845(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7844(final RenderContext renderContext) {
        GL11.glTranslatef(-0.4f, -0.3f, -0.6f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(0.23f, -1.19f, 1.3f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(-0.01f, 0.44f, 0.6f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(1.37f, -1.226f, 3.2f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$7843(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7842(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$7841(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.5f, -1.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7840(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.5f, -1.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$7839(final RenderContext renderContext) {
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        GL11.glTranslatef(-2.0f, -1.1f, 2.2f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7838(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(-0.9f, 0.6f, 0.5f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7837(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$7836(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$7835(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$7834(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$7833(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Arctic.getTextureVariantIndex("Arctic"));
    }
    
    private static /* synthetic */ void lambda$createGun$7832(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$7831(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$7830(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$7829(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ List lambda$createGun$7828(final ItemStack stack) {
        return Arrays.asList("Type: Revolver", "Damage: 6", "Ammo: .357 Bullet", "Fire Rate: Semi");
    }
    
    private static /* synthetic */ Float lambda$createGun$7827() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$7826() {
        return 0.2f;
    }
    
    private static /* synthetic */ Float lambda$createGun$7825() {
        return 0.5f;
    }
}
