package com.vicmatskiv.mw.items.guns;

import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;

public class MosinNagantFactory implements GunFactory
{
    public MosinNagantFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("MosinNagantM91-30").withAmmoCapacity(5).withFireRate(0.16f).withEjectRoundRequired().withEjectSpentRoundSound("MosinBoltAction").withRecoil(6.0f).withZoom(0.8f).withMaxShots(1).withShootSound("MosinNagant").withPumpTimeout(1600L).withReloadSound("MosinReload").withReloadingTime(40L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.1f).withCreativeTab(ModernWarfareMod.SnipersTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, CommonProxy.MetalComponents, CompatibleBlocks.PLANK).withInformationProvider(stack -> Arrays.asList("Type: Bolt-action rifle", "Damage: 20", "Cartridge:", "7.62x54mm Bullet", "Fire Rate: Bolt Action")).withCompatibleAttachment(AuxiliaryAttachments.MosinBolt, true, model -> {
            if (model instanceof MosinBolt) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
        }).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("MosinNagantEmerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Forest, (a, i) -> i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("MosinNagantForest")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("MosinNagantGold")), (a, i) -> {}).withCompatibleAttachment(Attachments.PSO1, (player, stack) -> {
            GL11.glTranslatef(0.349f, -1.1f, -0.2f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(-0.209f, -0.485f, 1.27f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
            else if (model instanceof PSO12) {
                GL11.glTranslatef(-0.27f, -0.6f, 1.21f);
                GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            }
        }).withCompatibleBullet(Bullets.Bullet762x54, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.Extra, true, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(0.17f, -1.42f, 0.43f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(0.255f, -0.8f, -2.25f);
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
                GL11.glTranslatef(0.092f, -1.91f, -2.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof G36CIron1) {
                GL11.glTranslatef(-0.22f, -1.94f, -1.0f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof G36CIron2) {
                GL11.glTranslatef(0.158f, -1.23f, -4.2f);
                GL11.glScaled(0.25, 0.25, 0.25);
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
                GL11.glTranslatef(0.125f, -1.43f, -4.88f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof M14Iron) {
                GL11.glTranslatef(0.129f, -1.63f, -2.08f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(0.215f, -1.54f, 1.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withTextureNames("MosinNagant", "Electric").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new MosinNagant()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.3199999928474426, 0.3199999928474426, 0.3199999928474426);
            GL11.glTranslatef(1.0f, 0.8f, 0.0f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-1.7f, 0.25f, 1.3f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glTranslatef(0.25f, -0.13f, -0.3f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glTranslatef(0.25f, -0.13f, -0.3f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            GL11.glTranslatef(-0.4f, -0.8f, 1.3f);
            GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(0.2f, -0.3f, 0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(0.17f, -1.07f, 0.61f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-0.4f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
                GL11.glTranslatef(1.37f, -1.12f, 2.6f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(AuxiliaryAttachments.MosinBolt.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningEjectSpentRound(new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 250L, 200L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 250L, 50L)).withFirstPersonCustomPositioningEjectSpentRound(AuxiliaryAttachments.MosinBolt.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 300L), new Transition(renderContext -> {}, 250L, 0L)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 250L, 100L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 350L, 250L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 350L, 100L), new Transition(renderContext -> {
            GL11.glTranslatef(0.3f, -0.3f, -0.15f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
        }, 250L, 0L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.MosinBolt.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 50L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 50L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 50L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 0.5f), 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(0.2f, -0.3f, 0.1f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            GL11.glTranslatef(0.17f, -1.07f, 0.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
                GL11.glTranslatef(1.37f, -1.12f, 2.6f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
            GL11.glTranslatef(0.3f, -0.15f, -0.3f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
            GL11.glTranslatef(1.0f, -0.8f, -1.5f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.2f, 0.0f, 0.8f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.3f, 0.2f, 0.6f);
            GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 1.0f);
            GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(2.2f, 2.2f, 2.2f);
            GL11.glTranslatef(1.0f, 0.2f, 0.0f);
            GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
        }, renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.2f, 0.0f, 0.8f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.4f, -0.2f, 0.3f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.35f, 0.06f, 0.01f);
            GL11.glRotatef(100.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.45f, 0.5f, 0.01f);
            GL11.glRotatef(100.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.3f, -0.2f, -0.2f);
            GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.35f, 0.06f, 0.01f);
            GL11.glRotatef(100.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.4f, -0.2f, 0.3f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).withFirstPersonLeftHandPositioningEjectSpentRound(new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 3.0f);
            GL11.glTranslatef(0.7f, -0.04f, 0.17f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        }, 250L, 50L)).withFirstPersonRightHandPositioningEjectSpentRound(new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.4f, -0.2f, 0.3f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        }, 350L, 1050L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.35f, 0.06f, 0.01f);
            GL11.glRotatef(100.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        }, 350L, 1050L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.4f, -0.2f, 0.3f);
            GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
        }, 350L, 1050L)).build()).withSpawnEntityDamage(20.0f).withSpawnEntityGravityVelocity(0.0f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$6803(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.4f, -0.2f, 0.3f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6802(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.35f, 0.06f, 0.01f);
        GL11.glRotatef(100.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6801(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.4f, -0.2f, 0.3f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6800(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6799(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6798(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6797(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.4f, -0.2f, 0.3f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6796(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.35f, 0.06f, 0.01f);
        GL11.glRotatef(100.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6795(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.3f, -0.2f, -0.2f);
        GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6794(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.45f, 0.5f, 0.01f);
        GL11.glRotatef(100.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6793(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.35f, 0.06f, 0.01f);
        GL11.glRotatef(100.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(60.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6792(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.4f, -0.2f, 0.3f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6791(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6790(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6789(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6788(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6787(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6786(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6785(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.2f, 0.0f, 0.8f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6784(final RenderContext renderContext) {
        GL11.glScalef(2.2f, 2.2f, 2.2f);
        GL11.glTranslatef(1.0f, 0.2f, 0.0f);
        GL11.glRotatef(99.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-60.0f, 20.0f, 20.0f, -20.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6783(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.3f, 0.2f, 0.6f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 1.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6782(final RenderContext renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6781(final RenderContext renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.2f, 0.0f, 0.8f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-105.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6780(final RenderContext renderContext) {
        GL11.glScalef(1.5f, 1.5f, 3.0f);
        GL11.glTranslatef(0.7f, -0.04f, 0.17f);
        GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-50.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6779(final RenderContext renderContext) {
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-35.0f, 2.0f, 1.0f, 1.0f);
        GL11.glTranslatef(1.0f, -0.8f, -1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6778(final RenderContext renderContext) {
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        GL11.glRotatef(-20.0f, -4.0f, 1.0f, -2.0f);
        GL11.glTranslatef(0.3f, -0.15f, -0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$6777(final RenderContext renderContext) {
        GL11.glTranslatef(0.2f, -0.3f, 0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(0.17f, -1.07f, 0.6f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
            GL11.glTranslatef(1.37f, -1.12f, 2.6f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6776(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6775(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6774(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6773(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6772(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6771(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6770(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6769(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6768(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6767(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6766(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6765(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6764(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6763(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 0.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6762(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6761(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6760(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6759(final Object renderContext) {
        GL11.glTranslatef(0.3f, -0.3f, -0.15f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(7.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6758(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6757(final RenderContext renderContext) {
        GL11.glTranslatef(0.2f, -0.3f, 0.1f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        GL11.glTranslatef(0.17f, -1.07f, 0.61f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-0.4f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.PSO1)) {
            GL11.glTranslatef(1.37f, -1.12f, 2.6f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6756(final RenderContext renderContext) {
        GL11.glTranslatef(0.25f, -0.13f, -0.3f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-0.4f, -0.8f, 1.3f);
        GL11.glRotatef(-4.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6755(final RenderContext renderContext) {
        GL11.glTranslatef(0.25f, -0.13f, -0.3f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-0.4f, -0.8f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$createGun$6754(final RenderContext renderContext) {
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        GL11.glTranslatef(-1.7f, 0.25f, 1.3f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6753(final ItemStack itemStack) {
        GL11.glScaled(0.3199999928474426, 0.3199999928474426, 0.3199999928474426);
        GL11.glTranslatef(1.0f, 0.8f, 0.0f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6752(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6751(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(0.17f, -1.42f, 0.43f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(0.255f, -0.8f, -2.25f);
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
            GL11.glTranslatef(0.092f, -1.91f, -2.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof G36CIron1) {
            GL11.glTranslatef(-0.22f, -1.94f, -1.0f);
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof G36CIron2) {
            GL11.glTranslatef(0.158f, -1.23f, -4.2f);
            GL11.glScaled(0.25, 0.25, 0.25);
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
            GL11.glTranslatef(0.125f, -1.43f, -4.88f);
            GL11.glScaled(0.0, 0.0, 0.0);
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
    
    private static /* synthetic */ void lambda$createGun$6750(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$6749(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(-0.209f, -0.485f, 1.27f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
        else if (model instanceof PSO12) {
            GL11.glTranslatef(-0.27f, -0.6f, 1.21f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6748(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(0.349f, -1.1f, -0.2f);
        GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
    }
    
    private static /* synthetic */ void lambda$createGun$6747(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6746(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("MosinNagantGold"));
    }
    
    private static /* synthetic */ void lambda$createGun$6745(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6744(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$6743(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6742(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("MosinNagantForest"));
    }
    
    private static /* synthetic */ void lambda$createGun$6741(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6740(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("MosinNagantEmerald"));
    }
    
    private static /* synthetic */ void lambda$createGun$6739(final ModelBase model) {
        if (model instanceof MosinBolt) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ List lambda$createGun$6738(final ItemStack stack) {
        return Arrays.asList("Type: Bolt-action rifle", "Damage: 20", "Cartridge:", "7.62x54mm Bullet", "Fire Rate: Bolt Action");
    }
    
    private static /* synthetic */ Float lambda$createGun$6737() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6736() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6735() {
        return 0.8f;
    }
}
