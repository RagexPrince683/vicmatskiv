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

public class USP45Factory implements GunFactory
{
    public USP45Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("HKUSP45").withFireRate(0.4f).withRecoil(5.0f).withZoom(0.9f).withMaxShots(1).withShootSound("USP45").withSilencedShootSound("silencer").withReloadSound("PistolReload").withUnloadSound("Unload").withReloadingTime(50L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.5f).withFlashOffsetX(() -> 0.2f).withFlashOffsetY(() -> 0.1f).withInaccuracy(3.0f).withCreativeTab(ModernWarfareMod.PistolsTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate).withInformationProvider(stack -> Arrays.asList("Type: Pistol", "Damage: 5.5", "Caliber: .45 ACP", "Magazines:", "10rnd .45 ACP Magazine", "Fire Rate: Semi")).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Forest, (a, i) -> i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("Forest")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(AuxiliaryAttachments.USP45Top, true, model -> {}).withCompatibleAttachment(Magazines.ColtM1911Mag, model -> GL11.glTranslatef(0.0f, 0.15f, 0.0f)).withCompatibleAttachment(Attachments.Silencer45ACP, model -> {
            GL11.glTranslatef(-0.25f, -1.2f, -4.6f);
            GL11.glScaled(1.5, 1.5, 1.5);
        }).withTextureNames("AK12", "Electric").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new USP45()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glTranslatef(0.0f, 0.8f, 0.0f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-1.8f, -1.0f, 2.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.1f, -0.5f, -1.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.0f, -0.6f, -1.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.USP45Top.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.USP45Top.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f)).withFirstPersonPositioningCustomRecoiled(Magazines.ColtM1911Mag, renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.ColtM1911Mag, renderContext -> {}).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(-0.3f, -0.4f, -0.5f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.31f, -1.34f, 1.5f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.5f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(1.38f, -1.115f, 3.2f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(Magazines.ColtM1911Mag, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.USP45Top.getRenderablePart(), renderContext -> {
            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                GL11.glTranslatef(0.0f, 0.0f, 0.5f);
            }
        }).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(-0.6f, -0.6f, -0.6f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(1.0f, -1.2f, 0.0f);
        }, 250L, 500L), new Transition(renderContext -> {
            GL11.glTranslatef(-0.4f, -0.2f, -0.3f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(1.0f, -1.2f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glTranslatef(-0.4f, -0.2f, -0.3f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(1.0f, -1.2f, 0.0f);
        }, 50L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glTranslatef(-0.6f, -0.6f, -0.6f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(1.0f, -1.2f, 0.0f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glTranslatef(-0.6f, -0.6f, -0.6f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(1.0f, -1.2f, 0.0f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.ColtM1911Mag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.3f, 0.4f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.ColtM1911Mag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.3f, 0.4f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.USP45Top.getRenderablePart(), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.USP45Top.getRenderablePart(), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(-0.2f, -0.31f, -0.4f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.31f, -1.31f, 1.5f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.5f, 0.7f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(1.38f, -1.17f, 3.3f);
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
            GL11.glTranslatef(0.9f, 0.8f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 20.0f, 20.0f, -20.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.5f, 0.5f, 0.3f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.5f, 0.5f, 0.3f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.8f, 0.1f, 0.6f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.8f, 0.1f, 0.6f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.3f, 3.3f, 3.3f);
            GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).withFirstPersonHandPositioningZooming(renderContext -> {
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
        }).build()).withSpawnEntityDamage(5.5f).withSpawnEntityGravityVelocity(0.02f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$8821(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.34f, 0.48f, 0.3f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8820(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.4f, -0.1f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8819(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8818(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8817(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.8f, 0.1f, 0.6f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8816(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.8f, 0.1f, 0.6f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8815(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8814(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8813(final Object renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8812(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.5f, 0.5f, 0.3f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8811(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.5f, 0.5f, 0.3f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8810(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.9f, 0.8f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8809(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.1f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8808(final RenderContext renderContext) {
        GL11.glScalef(1.6f, 1.6f, 1.6f);
        GL11.glTranslatef(1.5f, 0.1f, -0.2f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8807(final RenderContext renderContext) {
        GL11.glScalef(3.3f, 3.3f, 3.3f);
        GL11.glTranslatef(-0.13f, 0.38f, 0.52f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8806(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.6f, -0.1f, 0.4f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8805(final RenderContext renderContext) {
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(-1.0f, 0.1f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8804(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -1.5f, -1.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8803(final RenderContext renderContext) {
        GL11.glTranslatef(-0.2f, -0.31f, -0.4f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.31f, -1.31f, 1.5f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.5f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(1.38f, -1.17f, 3.3f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8802(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8801(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8800(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8799(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8798(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8797(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8796(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8795(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.3f, 0.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$8794(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.3f, 0.4f);
    }
    
    private static /* synthetic */ void lambda$createGun$8793(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8792(final Object renderContext) {
        GL11.glTranslatef(-0.6f, -0.6f, -0.6f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(1.0f, -1.2f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8791(final Object renderContext) {
        GL11.glTranslatef(-0.6f, -0.6f, -0.6f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(1.0f, -1.2f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8790(final Object renderContext) {
        GL11.glTranslatef(-0.4f, -0.2f, -0.3f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(1.0f, -1.2f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8789(final Object renderContext) {
        GL11.glTranslatef(-0.4f, -0.2f, -0.3f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(1.0f, -1.2f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8788(final Object renderContext) {
        GL11.glTranslatef(-0.6f, -0.6f, -0.6f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(1.0f, -1.2f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8787(final RenderContext renderContext) {
        if (renderContext.getWeaponInstance().getAmmo() == 0) {
            GL11.glTranslatef(0.0f, 0.0f, 0.5f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8786(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8785(final RenderContext renderContext) {
        GL11.glTranslatef(-0.3f, -0.4f, -0.5f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.31f, -1.34f, 1.5f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.5f, 0.7f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(1.38f, -1.115f, 3.2f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8784(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8783(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$8782(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8781(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8780(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, -0.6f, -1.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8779(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.5f, -1.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-1.1f, -0.76f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8778(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.0f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8777(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glTranslatef(0.0f, 0.8f, 0.0f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8776(final ItemStack itemStack) {
        GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8775(final ModelBase model) {
        GL11.glTranslatef(-0.25f, -1.2f, -4.6f);
        GL11.glScaled(1.5, 1.5, 1.5);
    }
    
    private static /* synthetic */ void lambda$createGun$8774(final ModelBase model) {
        GL11.glTranslatef(0.0f, 0.15f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8773(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$8772(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8771(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$8770(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8769(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("Ruby"));
    }
    
    private static /* synthetic */ void lambda$createGun$8768(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8767(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("Forest"));
    }
    
    private static /* synthetic */ void lambda$createGun$8766(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8765(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ List lambda$createGun$8764(final ItemStack stack) {
        return Arrays.asList("Type: Pistol", "Damage: 5.5", "Caliber: .45 ACP", "Magazines:", "10rnd .45 ACP Magazine", "Fire Rate: Semi");
    }
    
    private static /* synthetic */ Float lambda$createGun$8763() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$8762() {
        return 0.2f;
    }
    
    private static /* synthetic */ Float lambda$createGun$8761() {
        return 0.5f;
    }
}
