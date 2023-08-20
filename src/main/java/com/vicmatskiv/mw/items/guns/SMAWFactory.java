package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.entity.player.*;

public class SMAWFactory implements GunFactory
{
    public SMAWFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("SMAW").withAmmoCapacity(1).withFireRate(0.5f).withRecoil(2.0f).withZoom(0.9f).withMaxShots(1).withShootSound("SMAW").withReloadSound("RocketLauncherReload").withReloadingTime(70L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withShellCasingEjectEnabled(false).withCreativeTab(ModernWarfareMod.ShotgunsTab).withCrafting(CraftingComplexity.HIGH, CommonProxy.SteelPlate, CommonProxy.MetalComponents, CommonProxy.BigSteelPlate).withCompatibleAttachment(Attachments.AKMIron, true, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(0.41f, -2.13f, 1.1f);
                GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(0.26f, -2.0f, -2.22f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof P90iron) {
                GL11.glTranslatef(0.26f, -1.55f, -2.35f);
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
                GL11.glTranslatef(0.36f, -2.1f, -2.0f);
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
        }).withCompatibleAttachment(Attachments.ACOG, (player, stack) -> {
            GL11.glTranslatef(0.4f, -2.0f, 1.2f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Bullets.SMAWRocket, model -> GL11.glTranslatef(0.0f, 0.0f, 0.07f)).withCompatibleAttachment(GunSkins.Fade, (a, i) -> i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("SMAWRuby")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("SMAWGold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("SMAWSapphire")), (a, i) -> {}).withTextureNames("SMAW").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new SMAW()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
            GL11.glTranslatef(1.0f, 0.0f, 1.9f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            GL11.glTranslatef(-1.8f, 0.3f, 1.5f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.1f, -0.2f, -0.3f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.4f, -1.0f, 0.9f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.1f, -0.2f, -0.3f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.4f, -1.0f, 1.3f);
            GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.1f, 0.2f, -0.3f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(-0.1f, -0.1f, 2.0f);
            GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        }, 600L, 4000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(0.0f, -0.58f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.753f, -1.0f, 2.5f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(-0.09f, -0.03f, -0.13f);
            }
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(0.0f, -0.58f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.753f, -1.0f, 2.53f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(-0.09f, -0.03f, -0.13f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
            GL11.glTranslatef(1.0f, -0.5f, -0.8f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
            GL11.glTranslatef(1.0f, -0.8f, -1.5f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 3.0f);
            GL11.glTranslatef(0.85f, -0.1f, 0.35f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.1f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(2.0f, 2.0f, 2.0f);
            GL11.glTranslatef(0.85f, -0.0f, 0.18f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.1f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 3.0f);
            GL11.glTranslatef(0.85f, -0.1f, 0.35f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.1f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L)).build()).withSpawnEntitySpeed(5.0f).withSpawnEntityDamage(60.0f).withSpawnEntityExplosionRadius(4.0f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$8293(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.1f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8292(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 3.0f);
        GL11.glTranslatef(0.85f, -0.1f, 0.35f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8291(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.1f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8290(final RenderContext renderContext) {
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(0.85f, -0.0f, 0.18f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8289(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.1f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8288(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 3.0f);
        GL11.glTranslatef(0.85f, -0.1f, 0.35f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8287(final RenderContext renderContext) {
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(1.0f, -0.8f, -1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$8286(final RenderContext renderContext) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
        GL11.glTranslatef(1.0f, -0.5f, -0.8f);
    }
    
    private static /* synthetic */ void lambda$createGun$8285(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, -0.58f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.753f, -1.0f, 2.53f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(-0.09f, -0.03f, -0.13f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8284(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, -0.58f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.753f, -1.0f, 2.5f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(-0.09f, -0.03f, -0.13f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8283(final Object renderContext) {
        GL11.glTranslatef(0.1f, 0.2f, -0.3f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.1f, -0.1f, 2.0f);
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8282(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.2f, -0.3f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.4f, -1.0f, 1.3f);
        GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8281(final RenderContext renderContext) {
        GL11.glTranslatef(0.1f, -0.2f, -0.3f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(-0.4f, -1.0f, 0.9f);
    }
    
    private static /* synthetic */ void lambda$createGun$8280(final RenderContext renderContext) {
        GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        GL11.glTranslatef(-1.8f, 0.3f, 1.5f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8279(final ItemStack itemStack) {
        GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
        GL11.glTranslatef(1.0f, 0.0f, 1.9f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8278(final ItemStack itemStack) {
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$8277(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8276(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("SMAWSapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$8275(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8274(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("SMAWGold"));
    }
    
    private static /* synthetic */ void lambda$createGun$8273(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8272(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$8271(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$8270(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Fade.getTextureVariantIndex("SMAWRuby"));
    }
    
    private static /* synthetic */ void lambda$createGun$8269(final ModelBase model) {
        GL11.glTranslatef(0.0f, 0.0f, 0.07f);
    }
    
    private static /* synthetic */ void lambda$createGun$8268(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$8267(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(0.4f, -2.0f, 1.2f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    }
    
    private static /* synthetic */ void lambda$createGun$8266(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(0.41f, -2.13f, 1.1f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(0.26f, -2.0f, -2.22f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof P90iron) {
            GL11.glTranslatef(0.26f, -1.55f, -2.35f);
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
            GL11.glTranslatef(0.36f, -2.1f, -2.0f);
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
}
