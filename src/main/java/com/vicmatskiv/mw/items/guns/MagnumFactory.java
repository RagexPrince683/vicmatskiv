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

public class MagnumFactory implements GunFactory
{
    public MagnumFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("Magnum").withAmmoCapacity(6).withFireRate(0.2f).withRecoil(5.0f).withZoom(0.9f).withMaxShots(1).withShootSound("Magnum").withReloadSound("MagnumReload").withReloadingTime(25L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.5f).withFlashOffsetX(() -> 0.2f).withFlashOffsetY(() -> 0.1f).withInaccuracy(4.0f).withCreativeTab(ModernWarfareMod.PistolsTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate).withInformationProvider(stack -> Arrays.asList("Type: Revolver", "Damage: 5.5", "Ammo: .44 Bullet", "Fire Rate: Semi")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(AuxiliaryAttachments.RevolverCase, true, model -> {}).withCompatibleBullet(Bullets.Magnum44Ammo, model -> {}).withTextureNames("Magnum", "MagnumGold").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new Magnum()).withEntityPositioning(itemStack -> {
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
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.RevolverCase.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.RevolverCase.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
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
        }).withFirstPersonCustomPositioning(AuxiliaryAttachments.RevolverCase.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
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
        }, 250L, 100L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.RevolverCase.getRenderablePart(), new Transition(renderContext -> {
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
        }).build()).withSpawnEntityDamage(5.5f).withSpawnEntityGravityVelocity(0.016f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$6468(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.34f, 0.48f, 0.3f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6467(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.4f, -0.1f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6466(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6465(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6464(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.65f, 0.3f, 0.4f);
        GL11.glRotatef(130.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6463(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.65f, 0.3f, 0.4f);
        GL11.glRotatef(130.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6462(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.1f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6461(final RenderContext renderContext) {
        GL11.glScalef(1.6f, 1.6f, 1.6f);
        GL11.glTranslatef(1.5f, 0.1f, -0.2f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6460(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6459(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.6f, -0.1f, 0.4f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6458(final RenderContext renderContext) {
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(-1.0f, 0.1f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6457(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -1.5f, -1.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6456(final RenderContext renderContext) {
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
    
    private static /* synthetic */ void lambda$createGun$6455(final Object renderContext) {
        GL11.glTranslatef(-0.6f, 0.8f, -1.3f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6454(final Object renderContext) {
        GL11.glTranslatef(-0.6f, 0.8f, -1.3f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6453(final Object renderContext) {
        GL11.glTranslatef(-0.1f, -0.1f, -0.9f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6452(final Object renderContext) {
        GL11.glTranslatef(-0.1f, -0.1f, -0.9f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6451(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6450(final RenderContext renderContext) {
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
    
    private static /* synthetic */ void lambda$createGun$6449(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6448(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6447(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.5f, -1.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6446(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.5f, -1.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6445(final RenderContext renderContext) {
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        GL11.glTranslatef(-2.0f, -1.1f, 2.2f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6444(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(-0.9f, 0.6f, 0.5f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6443(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6442(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$6441(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$6440(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6439(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$6438(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6437(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$6436(final ItemStack stack) {
        return Arrays.asList("Type: Revolver", "Damage: 5.5", "Ammo: .44 Bullet", "Fire Rate: Semi");
    }
    
    private static /* synthetic */ Float lambda$createGun$6435() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6434() {
        return 0.2f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6433() {
        return 0.5f;
    }
}
