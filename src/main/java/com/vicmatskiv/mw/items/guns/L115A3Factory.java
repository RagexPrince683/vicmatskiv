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

public class L115A3Factory implements GunFactory
{
    public L115A3Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("L115A3").withFireRate(0.16f).withEjectRoundRequired().withEjectSpentRoundSound("L96BoltAction").withRecoil(4.0f).withZoom(0.8f).withMaxShots(1).withShootSound("L96").withPumpTimeout(1000L).withSilencedShootSound("RifleSilencer").withReloadSound("BoltActionReload").withUnloadSound("l96unload").withReloadingTime(40L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.07f).withFlashOffsetY(() -> 0.06f).withShellCasingEjectEnabled(false).withCreativeTab(ModernWarfareMod.SnipersTab).withCrafting(CraftingComplexity.HIGH, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, CommonProxy.BigSteelPlate).withInformationProvider(stack -> Arrays.asList("Type: Sniper rifle", "Damage: 27", "Caliber: 7.62x51mm", "Magazines:", "8rnd 7.62x51mm Magazine", "Fire Rate: Bolt Action")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.LightningStrike, (a, i) -> i.setActiveTextureIndex(GunSkins.LightningStrike.getTextureVariantIndex("AWPLightningStrike")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(Magazines.L115Mag, model -> {
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            GL11.glTranslatef(-0.27f, 0.6f, -0.97f);
        }).withCompatibleAttachment(AuxiliaryAttachments.L115Bolt1, true, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.L115Bolt2, true, model -> {
            GL11.glTranslatef(-0.35f, 0.35f, -1.56f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        }).withCompatibleAttachment(AuxiliaryAttachments.AUGRail, true, model -> {
            if (model instanceof AKRail) {
                GL11.glTranslatef(-0.22f, -1.36f, -3.15f);
                GL11.glScaled(0.699999988079071, 0.800000011920929, 0.8999999761581421);
            }
            else if (model instanceof AKRail2) {
                GL11.glTranslatef(-0.42f, -0.6f, -5.3f);
                GL11.glScaled(1.0, 1.0, 0.699999988079071);
                GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
            }
            else if (model instanceof AKRail3) {
                GL11.glTranslatef(-0.03f, -0.52f, -3.5f);
                GL11.glScaled(0.0, 0.0, 0.0);
                GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            }
            else if (model instanceof AKRail4) {
                GL11.glTranslatef(0.2f, -0.9f, -5.3f);
                GL11.glScaled(1.0, 1.0, 0.699999988079071);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            }
        }).withCompatibleAttachment(Attachments.AKMIron, true, model -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(-0.165f, -1.5f, -1.15f);
                GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            }
            else if (model instanceof M4Iron2) {
                GL11.glTranslatef(0.262f, -0.8f, -2.25f);
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
                GL11.glTranslatef(-0.22f, -1.75f, -3.07f);
                GL11.glScaled(0.6000000238418579, 0.699999988079071, 0.10000000149011612);
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
                GL11.glTranslatef(-0.17f, -1.545f, -3.1f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof M14Iron) {
                GL11.glTranslatef(0.129f, -1.63f, -2.08f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof MP5Iron) {
                GL11.glTranslatef(0.215f, -1.54f, 1.2f);
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withCompatibleAttachment(Attachments.HP, (player, stack) -> {
            GL11.glTranslatef(-0.36f, -1.43f, -1.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.235f, 1.16f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Scope, (player, stack) -> {
            GL11.glTranslatef(-0.36f, -1.43f, -1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }, model -> {
            if (model instanceof LPscope) {
                GL11.glTranslatef(0.237f, -0.272f, 0.67f);
                GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
            }
        }).withCompatibleAttachment(Attachments.ACOG, (player, stack) -> {
            GL11.glTranslatef(-0.335f, -1.45f, -1.3f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.237f, -0.26f, 0.46f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Specter, (player, stack) -> {
            GL11.glTranslatef(-0.19f, -1.15f, -1.5f);
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        }, model -> {
            if (model instanceof Acog2) {
                GL11.glTranslatef(0.15f, -1.035f, 1.513f);
                GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
            }
        }).withCompatibleAttachment(Attachments.Bipod, model -> {
            GL11.glTranslatef(-0.2f, -0.3f, -5.85f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Laser, model -> {
            GL11.glTranslatef(0.06f, -0.9f, -4.8f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withCompatibleAttachment(Attachments.Laser2, model -> {
            GL11.glTranslatef(0.06f, -0.9f, -4.8f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("L115").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new L96()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
            GL11.glTranslatef(1.0f, 2.0f, -1.2f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
            GL11.glTranslatef(-1.8f, -1.0f, 2.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.45f, 0.875f, -0.1f);
        }).withFirstPersonCustomPositioning(Magazines.L115Mag, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AUGRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(-0.45f, 0.875f, 0.2f);
            GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 1.0f, 0.2f);
            GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.0f, 0.145f, 0.15f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.145f, 0.25f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.0f, 0.13f, 0.75f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.0f, 0.055f, 0.6f);
            }
        }).withFirstPersonCustomPositioning(AuxiliaryAttachments.L115Bolt1.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.L115Bolt2.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningEjectSpentRound(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 200L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 200L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 200L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 120L, 0L)).withFirstPersonCustomPositioningEjectSpentRound(AuxiliaryAttachments.L115Bolt1.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 300L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f), 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonCustomPositioningEjectSpentRound(AuxiliaryAttachments.L115Bolt2.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
        }, 250L, 300L), new Transition(renderContext -> {
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.8f, 0.7f, 0.8f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonCustomPositioningEjectSpentRound(AuxiliaryAttachments.AUGRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 300L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonCustomPositioningEjectSpentRound(Magazines.L115Mag.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
        }, 300L, 60L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
        }, 300L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 350L, 120L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 200L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 200L, 100L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 200L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
        }, 120L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.L115Mag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.L115Mag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AUGRail.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AUGRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.L115Bolt1.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 300L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f), 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.L115Bolt2.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
        }, 250L, 300L), new Transition(renderContext -> {
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.8f, 0.7f, 0.8f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.L115Bolt1.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.L115Bolt2.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glTranslatef(0.35f, 1.0f, -0.125f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
                GL11.glTranslatef(0.0f, 0.145f, 0.35f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
                GL11.glTranslatef(0.0f, 0.145f, 0.5f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
                GL11.glTranslatef(0.0f, 0.13f, 1.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
                GL11.glTranslatef(0.0f, 0.055f, 0.8f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.425f, 1.025f, -0.375f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.05f, 0.675f, 0.575f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }).withFirstPersonHandPositioningZooming(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.05f, -0.275f, -0.35f);
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
            GL11.glTranslatef(0.5f, -0.8f, 0.1f);
        }, renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.44f, -0.5f, 0.08f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.675f, 0.7f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.125f, -0.8f, 0.25f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
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
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -0.4f, -0.075f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.095f, -0.31f, -0.02f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.15f, -0.515f, -0.125f);
        }, 350L, 1050L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.095f, -0.31f, -0.02f);
        }, 350L, 1050L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -0.4f, -0.075f);
        }, 350L, 1050L)).withFirstPersonLeftHandPositioningEjectSpentRound(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 7.5f);
            GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.275f, -0.34f);
        }, 250L, 50L)).withFirstPersonRightHandPositioningEjectSpentRound(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -0.4f, -0.075f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.095f, -0.31f, -0.02f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.15f, -0.515f, -0.125f);
        }, 350L, 1050L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.095f, -0.31f, -0.02f);
        }, 350L, 1050L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 4.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.175f, -0.4f, -0.075f);
        }, 350L, 1050L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.125f, -0.8f, 0.25f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.025f, -0.675f, 0.7f);
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
        }, 250L, 50L)).build()).withSpawnEntityDamage(27.0f).withSpawnEntityGravityVelocity(0.0f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$4412(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4411(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4410(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.675f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGun$4409(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.8f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4408(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.4f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$4407(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.095f, -0.31f, -0.02f);
    }
    
    private static /* synthetic */ void lambda$createGun$4406(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.15f, -0.515f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$4405(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.095f, -0.31f, -0.02f);
    }
    
    private static /* synthetic */ void lambda$createGun$4404(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.4f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$4403(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4402(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4401(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4400(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4399(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4398(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.4f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$4397(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.095f, -0.31f, -0.02f);
    }
    
    private static /* synthetic */ void lambda$createGun$4396(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.15f, -0.515f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$4395(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.095f, -0.31f, -0.02f);
    }
    
    private static /* synthetic */ void lambda$createGun$4394(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.4f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$4393(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4392(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4391(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4390(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4389(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4388(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4387(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4386(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.8f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4385(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.675f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGun$4384(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4383(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.5f, -0.8f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$4382(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.33f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4381(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.05f, -0.275f, -0.35f);
    }
    
    private static /* synthetic */ void lambda$createGun$4380(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$4379(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$4378(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.05f, 0.675f, 0.575f);
    }
    
    private static /* synthetic */ void lambda$createGun$4377(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 1.025f, -0.375f);
    }
    
    private static /* synthetic */ void lambda$createGun$4376(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.0f, -0.125f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.0f, 0.145f, 0.35f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.145f, 0.5f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.0f, 0.13f, 1.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.0f, 0.055f, 0.8f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4375(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4374(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4373(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4372(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4371(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4370(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4369(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.8f);
    }
    
    private static /* synthetic */ void lambda$createGun$4368(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4367(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4366(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4365(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4364(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4363(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4362(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4361(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4360(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4359(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4358(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4357(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4356(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4355(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4354(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4353(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4352(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4351(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4350(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4349(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4348(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4347(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4346(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4345(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4344(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4343(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4342(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4341(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4340(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4339(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$4338(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$4337(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4336(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4335(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4334(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4333(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4332(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$4331(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$4330(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4329(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4328(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4327(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4326(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4325(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4324(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4323(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4322(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4321(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4320(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4319(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4318(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.8f);
    }
    
    private static /* synthetic */ void lambda$createGun$4317(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4316(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4315(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4314(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4313(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4312(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4311(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4310(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4309(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4308(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4307(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4306(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$4305(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4304(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4303(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(0.35f, 1.0f, 0.2f);
        GL11.glRotatef(-1.0f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.HP)) {
            GL11.glTranslatef(0.0f, 0.145f, 0.15f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Scope)) {
            GL11.glTranslatef(0.0f, 0.145f, 0.25f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.ACOG)) {
            GL11.glTranslatef(0.0f, 0.13f, 0.75f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Specter)) {
            GL11.glTranslatef(0.0f, 0.055f, 0.6f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4302(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.45f, 0.875f, 0.2f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4301(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4300(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$4299(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.45f, 0.875f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$4298(final RenderContext renderContext) {
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        GL11.glTranslatef(-1.8f, -1.0f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4297(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4296(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$4295(final ModelBase model) {
        GL11.glTranslatef(0.06f, -0.9f, -4.8f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$4294(final ModelBase model) {
        GL11.glTranslatef(0.06f, -0.9f, -4.8f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$4293(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.3f, -5.85f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$4292(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4291(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.19f, -1.15f, -1.5f);
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
    }
    
    private static /* synthetic */ void lambda$createGun$4290(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4289(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.335f, -1.45f, -1.3f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$createGun$4288(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4287(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.36f, -1.43f, -1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$4286(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.235f, 1.16f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4285(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.36f, -1.43f, -1.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$4284(final ModelBase model) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(-0.165f, -1.5f, -1.15f);
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        }
        else if (model instanceof M4Iron2) {
            GL11.glTranslatef(0.262f, -0.8f, -2.25f);
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
            GL11.glTranslatef(-0.22f, -1.75f, -3.07f);
            GL11.glScaled(0.6000000238418579, 0.699999988079071, 0.10000000149011612);
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
            GL11.glTranslatef(-0.17f, -1.545f, -3.1f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
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
    
    private static /* synthetic */ void lambda$createGun$4283(final ModelBase model) {
        if (model instanceof AKRail) {
            GL11.glTranslatef(-0.22f, -1.36f, -3.15f);
            GL11.glScaled(0.699999988079071, 0.800000011920929, 0.8999999761581421);
        }
        else if (model instanceof AKRail2) {
            GL11.glTranslatef(-0.42f, -0.6f, -5.3f);
            GL11.glScaled(1.0, 1.0, 0.699999988079071);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        }
        else if (model instanceof AKRail3) {
            GL11.glTranslatef(-0.03f, -0.52f, -3.5f);
            GL11.glScaled(0.0, 0.0, 0.0);
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        }
        else if (model instanceof AKRail4) {
            GL11.glTranslatef(0.2f, -0.9f, -5.3f);
            GL11.glScaled(1.0, 1.0, 0.699999988079071);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$4282(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.35f, -1.56f);
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$4281(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$4280(final ModelBase model) {
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
        GL11.glTranslatef(-0.27f, 0.6f, -0.97f);
    }
    
    private static /* synthetic */ void lambda$createGun$4279(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4278(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$4277(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4276(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$4275(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4274(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.LightningStrike.getTextureVariantIndex("AWPLightningStrike"));
    }
    
    private static /* synthetic */ void lambda$createGun$4273(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$4272(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$4271(final ItemStack stack) {
        return Arrays.asList("Type: Sniper rifle", "Damage: 27", "Caliber: 7.62x51mm", "Magazines:", "8rnd 7.62x51mm Magazine", "Fire Rate: Bolt Action");
    }
    
    private static /* synthetic */ Float lambda$createGun$4270() {
        return 0.06f;
    }
    
    private static /* synthetic */ Float lambda$createGun$4269() {
        return 0.07f;
    }
    
    private static /* synthetic */ Float lambda$createGun$4268() {
        return 0.8f;
    }
}
