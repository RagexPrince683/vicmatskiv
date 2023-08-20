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

public class AWPFactory implements GunFactory
{
    public AWPFactory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("AWP").withFireRate(0.16f).withEjectRoundRequired().withEjectSpentRoundSound("L96BoltAction").withRecoil(4.0f).withZoom(0.8f).withMaxShots(1).withShootSound("L96").withPumpTimeout(1000L).withSilencedShootSound("RifleSilencer").withReloadSound("BoltActionReload").withUnloadSound("l96unload").withReloadingTime(40L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.07f).withFlashOffsetY(() -> 0.06f).withShellCasingEjectEnabled(false).withCreativeTab(ModernWarfareMod.SnipersTab).withCrafting(CraftingComplexity.HIGH, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, CommonProxy.BigSteelPlate).withInformationProvider(stack -> Arrays.asList("Type: Sniper rifle", "Damage: 27", "Caliber: 7.62x51mm", "Magazines:", "8rnd 7.62x51mm Magazine", "Fire Rate: Bolt Action")).withCompatibleAttachment(GunSkins.ElectricSkin, (a, i) -> i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric")), (a, i) -> {}).withCompatibleAttachment(GunSkins.LightningStrike, (a, i) -> i.setActiveTextureIndex(GunSkins.LightningStrike.getTextureVariantIndex("AWPLightningStrike")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(Magazines.L115Mag, model -> {
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            GL11.glTranslatef(-0.27f, 0.6f, -0.97f);
        }).withCompatibleAttachment(AuxiliaryAttachments.L115Bolt1, true, model -> {}).withCompatibleAttachment(AuxiliaryAttachments.L115Bolt2, true, model -> {
            GL11.glTranslatef(-0.35f, 0.35f, -1.56f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        }).withCompatibleAttachment(AuxiliaryAttachments.AKRail, true, model -> {
            GL11.glTranslatef(-0.22f, -1.36f, -3.15f);
            GL11.glScaled(0.699999988079071, 0.800000011920929, 0.8999999761581421);
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
        }).withTextureNames("awp").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new L96()).withEntityPositioning(itemStack -> {
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
        }).withFirstPersonCustomPositioning(Magazines.L115Mag, renderContext -> {}).withFirstPersonCustomPositioning(AuxiliaryAttachments.AKRail.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningRecoiled(renderContext -> {
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
        }, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonCustomPositioningEjectSpentRound(AuxiliaryAttachments.AKRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 300L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonCustomPositioningEjectSpentRound(Magazines.L115Mag.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonPositioningReloading(new Transition(renderContext -> {
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
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(Magazines.L115Mag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.L115Mag, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.0f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.AKRail.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.AKRail.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.L115Bolt1.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 300L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.0f), 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.L115Bolt2.getRenderablePart(), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {}, 250L, 50L), new Transition(renderContext -> {
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
    
    private static /* synthetic */ void lambda$createGun$2354(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2353(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2352(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.675f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGun$2351(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.8f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2350(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.4f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$2349(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.095f, -0.31f, -0.02f);
    }
    
    private static /* synthetic */ void lambda$createGun$2348(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.15f, -0.515f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$2347(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.095f, -0.31f, -0.02f);
    }
    
    private static /* synthetic */ void lambda$createGun$2346(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.4f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$2345(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2344(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2343(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2342(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2341(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2340(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.4f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$2339(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.095f, -0.31f, -0.02f);
    }
    
    private static /* synthetic */ void lambda$createGun$2338(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-115.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.15f, -0.515f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$2337(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-120.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.095f, -0.31f, -0.02f);
    }
    
    private static /* synthetic */ void lambda$createGun$2336(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.175f, -0.4f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$2335(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2334(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2333(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2332(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2331(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2330(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2329(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2328(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.125f, -0.8f, 0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2327(final Object renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(65.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.675f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGun$2326(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2325(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.5f, -0.8f, 0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$2324(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.33f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2323(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.05f, -0.275f, -0.35f);
    }
    
    private static /* synthetic */ void lambda$createGun$2322(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 4.0f);
        GL11.glRotatef(-80.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.44f, -0.5f, 0.08f);
    }
    
    private static /* synthetic */ void lambda$createGun$2321(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 7.5f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(75.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.025f, -0.275f, -0.34f);
    }
    
    private static /* synthetic */ void lambda$createGun$2320(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-15.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.05f, 0.675f, 0.575f);
    }
    
    private static /* synthetic */ void lambda$createGun$2319(final RenderContext renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.425f, 1.025f, -0.375f);
    }
    
    private static /* synthetic */ void lambda$createGun$2318(final RenderContext renderContext) {
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
    
    private static /* synthetic */ void lambda$createGun$2317(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2316(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2315(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2314(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2313(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2312(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2311(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.8f);
    }
    
    private static /* synthetic */ void lambda$createGun$2310(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2309(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2308(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2307(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2306(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2305(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2304(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2303(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2302(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2301(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2300(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2299(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2298(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2297(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2296(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2295(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2294(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2293(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2292(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2291(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2290(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2289(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2288(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2287(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2286(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2285(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2284(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2283(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2282(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2281(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$2280(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$2279(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2278(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2277(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2276(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2275(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2274(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$2273(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.75f, 0.725f, 0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$2272(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2271(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2270(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2269(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2268(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2267(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2266(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2265(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2264(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2263(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2262(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2261(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2260(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.8f);
    }
    
    private static /* synthetic */ void lambda$createGun$2259(final Object renderContext) {
        GL11.glRotatef(50.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.8f, 0.7f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2258(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2257(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2256(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2255(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2254(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2253(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2252(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2251(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2250(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2249(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2248(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.475f, 0.9f, -0.25f);
    }
    
    private static /* synthetic */ void lambda$createGun$2247(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2246(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2245(final RenderContext renderContext) {
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
    
    private static /* synthetic */ void lambda$createGun$2244(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.45f, 0.875f, 0.2f);
        GL11.glRotatef(-2.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2243(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2242(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$2241(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glTranslatef(-0.45f, 0.875f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$2240(final RenderContext renderContext) {
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
        GL11.glTranslatef(-1.8f, -1.0f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2239(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2238(final ItemStack itemStack) {
        GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$2237(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -0.3f, -5.85f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$2236(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.15f, -1.035f, 1.513f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2235(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.19f, -1.15f, -1.5f);
        GL11.glScaled(0.44999998807907104, 0.44999998807907104, 0.44999998807907104);
    }
    
    private static /* synthetic */ void lambda$createGun$2234(final ModelBase model) {
        if (model instanceof Acog2) {
            GL11.glTranslatef(0.237f, -0.26f, 0.46f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2233(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.335f, -1.45f, -1.3f);
        GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$createGun$2232(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.272f, 0.67f);
            GL11.glScaled(0.05000000074505806, 0.05000000074505806, 0.05000000074505806);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2231(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.36f, -1.43f, -1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$2230(final ModelBase model) {
        if (model instanceof LPscope) {
            GL11.glTranslatef(0.237f, -0.235f, 1.16f);
            GL11.glScaled(0.10000000149011612, 0.10000000149011612, 0.10000000149011612);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$2229(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.36f, -1.43f, -1.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$2228(final ModelBase model) {
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
    
    private static /* synthetic */ void lambda$createGun$2227(final ModelBase model) {
        GL11.glTranslatef(-0.22f, -1.36f, -3.15f);
        GL11.glScaled(0.699999988079071, 0.800000011920929, 0.8999999761581421);
    }
    
    private static /* synthetic */ void lambda$createGun$2226(final ModelBase model) {
        GL11.glTranslatef(-0.35f, 0.35f, -1.56f);
        GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$2225(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$2224(final ModelBase model) {
        GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
        GL11.glTranslatef(-0.27f, 0.6f, -0.97f);
    }
    
    private static /* synthetic */ void lambda$createGun$2223(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2222(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$2221(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2220(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$2219(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2218(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.LightningStrike.getTextureVariantIndex("AWPLightningStrike"));
    }
    
    private static /* synthetic */ void lambda$createGun$2217(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$2216(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.ElectricSkin.getTextureVariantIndex("Electric"));
    }
    
    private static /* synthetic */ List lambda$createGun$2215(final ItemStack stack) {
        return Arrays.asList("Type: Sniper rifle", "Damage: 27", "Caliber: 7.62x51mm", "Magazines:", "8rnd 7.62x51mm Magazine", "Fire Rate: Bolt Action");
    }
    
    private static /* synthetic */ Float lambda$createGun$2214() {
        return 0.06f;
    }
    
    private static /* synthetic */ Float lambda$createGun$2213() {
        return 0.07f;
    }
    
    private static /* synthetic */ Float lambda$createGun$2212() {
        return 0.8f;
    }
}
