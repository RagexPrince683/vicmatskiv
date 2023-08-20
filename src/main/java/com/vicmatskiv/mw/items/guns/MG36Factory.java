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

public class MG36Factory implements GunFactory
{
    public MG36Factory() {
        super();
    }
    
    @Override
    public Item createGun(final CommonProxy commonProxy) {
        return new Weapon.Builder().withModId("mw").withName("MG36").withFireRate(0.7f).withRecoil(2.5f).withZoom(0.8f).withShootSound("G36").withSilencedShootSound("RifleSilencer").withReloadSound("StandardReload").withUnloadSound("Unload").withReloadingTime(45L).withCrosshair("gun").withCrosshairRunning("Running").withCrosshairZoomed("Sight").withFlashIntensity(1.0f).withFlashScale(() -> 0.8f).withFlashOffsetX(() -> 0.1f).withFlashOffsetY(() -> 0.05f).withCreativeTab(ModernWarfareMod.ShotgunsTab).withCrafting(CraftingComplexity.MEDIUM, CommonProxy.SteelPlate, CommonProxy.MiniSteelPlate, "ingotSteel").withInformationProvider(stack -> Arrays.asList("Type: Light machine gun", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto")).withCompatibleAttachment(GunSkins.Emerald, (a, i) -> i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Forest, (a, i) -> i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("Forest")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Amber, (a, i) -> i.setActiveTextureIndex(GunSkins.Amber.getTextureVariantIndex("Amber")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Diamond, (a, i) -> i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Gold, (a, i) -> i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold")), (a, i) -> {}).withCompatibleAttachment(GunSkins.Sapphire, (a, i) -> i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire")), (a, i) -> {}).withCompatibleAttachment(Attachments.G36Scope, true, (player, stack) -> {
            GL11.glTranslatef(-0.138f, -2.2f, -1.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.800000011920929);
        }, model -> {
            if (model instanceof Reflex2) {
                GL11.glTranslatef(0.035f, -0.065f, 1.28f);
                GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
            }
        }).withCompatibleAttachment(Attachments.Reflex, model -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.073f, -2.12f, -0.7f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.125f, -2.395f, -0.95f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Kobra, model -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.05f, -2.13f, -0.25f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Reflex2) {
                GL11.glTranslatef(-0.125f, -2.415f, -0.95f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Holo2, model -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.05f, -2.13f, -0.25f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.125f, -2.415f, -0.95f);
                GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
            }
        }).withCompatibleAttachment(Attachments.Holographic2, model -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.05f, -2.13f, -0.4f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glTranslatef(-0.125f, -2.418f, -0.5f);
                GL11.glScaled(0.03999999910593033, 0.03999999910593033, 0.03999999910593033);
            }
        }).withCompatibleAttachment(Attachments.Bipod, true, true, (player, stack) -> {
            GL11.glTranslatef(-0.2f, -0.4f, -5.4f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }, model -> {}).withCompatibleAttachment(Magazines.NATOG36Mag, model -> {
            GL11.glTranslatef(-0.37f, 0.8f, -1.7f);
            GL11.glScaled(1.25, 1.7000000476837158, 1.7000000476837158);
        }).withCompatibleAttachment(Magazines.NATODrum100, model -> {
            GL11.glTranslatef(-0.37f, 0.8f, -1.7f);
            GL11.glScaled(1.25, 1.600000023841858, 1.7000000476837158);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        }).withCompatibleAttachment(AuxiliaryAttachments.G36Action, true, model -> {}).withCompatibleAttachment(Attachments.Silencer556x45, model -> {
            GL11.glTranslatef(-0.2f, -1.45f, -8.5f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withTextureNames("AK12").withRenderer(new WeaponRenderer.Builder().withModId("mw").withModel(new G36()).withEntityPositioning(itemStack -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
        }).withInventoryPositioning(itemStack -> {
            GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
            GL11.glTranslatef(1.0f, 2.0f, -1.2f);
            GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
        }).withThirdPersonPositioning(renderContext -> {
            GL11.glScaled(0.5, 0.5, 0.5);
            GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioning(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glTranslatef(-0.225f, 0.725f, 0.0f);
        }).withFirstPersonPositioningRecoiled(renderContext -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glTranslatef(-0.225f, 0.725f, 0.4f);
            GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonPositioningZoomingRecoiled(renderContext -> {
            GL11.glTranslatef(0.14f, -0.1f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.135f, -1.08f, 1.65f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.G36Scope)) {
                GL11.glTranslatef(-0.005f, -0.05f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.13f, 0.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, 0.15f, -0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(1.373f, -1.205f, 2.3f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonCustomPositioning(AuxiliaryAttachments.G36Action.getRenderablePart(), renderContext -> {
            if (renderContext.getWeaponInstance().getAmmo() == 0) {
                GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            }
        }).withFirstPersonPositioningCustomRecoiled(AuxiliaryAttachments.G36Action.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f)).withFirstPersonPositioningCustomZoomingRecoiled(AuxiliaryAttachments.G36Action.getRenderablePart(), renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f)).withFirstPersonPositioningCustomRecoiled(Magazines.NATOG36Mag.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATOG36Mag.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomRecoiled(Magazines.NATODrum100.getRenderablePart(), renderContext -> {}).withFirstPersonPositioningCustomZoomingRecoiled(Magazines.NATODrum100.getRenderablePart(), renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATOG36Mag, renderContext -> {}).withFirstPersonCustomPositioning(Magazines.NATODrum100, renderContext -> {}).withFirstPersonPositioningReloading(new Transition(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
        }, 250L, 500L), new Transition(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
        }, 250L, 20L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.3f, 0.85f, 0.3f);
        }, 500L, 100L), new Transition(renderContext -> {
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.3f, 0.85f, 0.3f);
        }, 70L, 0L)).withFirstPersonPositioningUnloading(new Transition(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
        }, 150L, 50L), new Transition(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
        }, 150L, 50L)).withFirstPersonCustomPositioningUnloading(AuxiliaryAttachments.G36Action.getRenderablePart(), new Transition(renderContext -> {}, 500L, 1000L), new Transition(renderContext -> {}, 500L, 1000L)).withFirstPersonCustomPositioningReloading(AuxiliaryAttachments.G36Action.getRenderablePart(), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 0.0f, 1.5f), 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATOG36Mag, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.0f, 1.5f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATOG36Mag, new Transition(renderContext -> GL11.glTranslatef(0.0f, 1.5f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonCustomPositioningUnloading(Magazines.NATODrum100, new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.5f, 0.0f), 250L, 1000L)).withFirstPersonCustomPositioningReloading(Magazines.NATODrum100, new Transition(renderContext -> GL11.glTranslatef(0.05f, 1.5f, 0.0f), 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L), new Transition(renderContext -> {}, 250L, 1000L)).withFirstPersonPositioningZooming(renderContext -> {
            GL11.glTranslatef(0.14f, -0.1f, -0.2f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            GL11.glTranslatef(0.135f, -1.08f, 1.6f);
            GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.G36Scope)) {
                GL11.glTranslatef(-0.005f, -0.05f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
                GL11.glTranslatef(0.0f, 0.13f, 0.0f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
                GL11.glTranslatef(0.0f, 0.15f, -0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
                GL11.glTranslatef(0.0f, 0.24f, 0.1f);
            }
            if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
                GL11.glTranslatef(1.373f, -1.205f, 2.3f);
            }
            else {
                GL11.glTranslatef(1.373f, -1.34f, 2.4f);
            }
        }).withFirstPersonPositioningRunning(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.45f, 1.174999f, -0.125f);
        }).withFirstPersonPositioningModifying(renderContext -> {
            GL11.glScaled(1.5, 1.5, 1.5);
            GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-1.249999f, 0.8f, 0.7f);
        }).withFirstPersonHandPositioning(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 5.5f);
            GL11.glTranslatef(0.5f, 0.01f, -0.05f);
            GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonHandPositioningModifying(renderContext -> {
            GL11.glScalef(3.5f, 3.5f, 3.5f);
            GL11.glRotatef(110.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(205.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-95.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.775f, -0.025f);
        }, renderContext -> {
            GL11.glScalef(2.5f, 2.5f, 3.0f);
            GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        }).withFirstPersonLeftHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.625f, -0.575f, -0.175f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.8f, -0.075f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.175f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-55.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.15f, -0.45f, -0.075f);
        }, 250L, 0L)).withFirstPersonRightHandPositioningReloading(new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 0L)).withFirstPersonLeftHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.35f, -0.8f, -0.075f);
        }, 50L, 200L), new Transition(renderContext -> {
            GL11.glScalef(3.0f, 3.0f, 3.0f);
            GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.625f, -0.575f, -0.175f);
        }, 50L, 200L)).withFirstPersonRightHandPositioningUnloading(new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 1000L), new Transition(renderContext -> {
            GL11.glScalef(1.8f, 1.8f, 2.5f);
            GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
        }, 250L, 50L)).build()).withSpawnEntityDamage(7.0f).withSpawnEntityGravityVelocity(0.0118f).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$createGun$6668(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6667(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6666(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.625f, -0.575f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$6665(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.8f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$6664(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6663(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6662(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6661(final Object renderContext) {
        GL11.glScalef(1.8f, 1.8f, 2.5f);
        GL11.glTranslatef(-0.15f, 0.0f, 1.0f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-95.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6660(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-55.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.15f, -0.45f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$6659(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.175f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6658(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-60.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.8f, -0.075f);
    }
    
    private static /* synthetic */ void lambda$createGun$6657(final Object renderContext) {
        GL11.glScalef(3.0f, 3.0f, 3.0f);
        GL11.glRotatef(-40.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-80.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.625f, -0.575f, -0.175f);
    }
    
    private static /* synthetic */ void lambda$createGun$6656(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6655(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 3.5f);
        GL11.glRotatef(110.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(205.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-95.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.35f, -0.775f, -0.025f);
    }
    
    private static /* synthetic */ void lambda$createGun$6654(final RenderContext renderContext) {
        GL11.glScalef(2.5f, 2.5f, 3.0f);
        GL11.glTranslatef(-0.15f, 0.3f, 0.5f);
        GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6653(final RenderContext renderContext) {
        GL11.glScalef(3.5f, 3.5f, 5.5f);
        GL11.glTranslatef(0.5f, 0.01f, -0.05f);
        GL11.glRotatef(115.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-70.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(30.0f, 1.0f, 1.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6652(final RenderContext renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-5.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-1.249999f, 0.8f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$createGun$6651(final RenderContext renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.45f, 1.174999f, -0.125f);
    }
    
    private static /* synthetic */ void lambda$createGun$6650(final RenderContext renderContext) {
        GL11.glTranslatef(0.14f, -0.1f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.135f, -1.08f, 1.6f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.G36Scope)) {
            GL11.glTranslatef(-0.005f, -0.05f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.13f, 0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, 0.15f, -0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(1.373f, -1.205f, 2.3f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6649(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6648(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6647(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6646(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6645(final Object renderContext) {
        GL11.glTranslatef(0.05f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6644(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6643(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6642(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6641(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6640(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6639(final Object renderContext) {
        GL11.glTranslatef(0.0f, 1.5f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6638(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6637(final Object renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6636(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6635(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6634(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6633(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6632(final Object renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6631(final Object renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$6630(final Object renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$6629(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.3f, 0.85f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$6628(final Object renderContext) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(40.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.3f, 0.85f, 0.3f);
    }
    
    private static /* synthetic */ void lambda$createGun$6627(final Object renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$6626(final Object renderContext) {
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glRotatef(-15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(35.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-35.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.875f, 0.35f, -0.1f);
    }
    
    private static /* synthetic */ void lambda$createGun$6625(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6624(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6623(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6622(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6621(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6620(final RenderContext renderContext) {
    }
    
    private static /* synthetic */ void lambda$createGun$6619(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6618(final RenderContext renderContext) {
        GL11.glTranslatef(0.0f, 0.0f, 1.5f);
    }
    
    private static /* synthetic */ void lambda$createGun$6617(final RenderContext renderContext) {
        if (renderContext.getWeaponInstance().getAmmo() == 0) {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6616(final RenderContext renderContext) {
        GL11.glTranslatef(0.14f, -0.1f, -0.2f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glTranslatef(0.135f, -1.08f, 1.65f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.550000011920929);
        GL11.glRotatef(-0.5f, 1.0f, 0.0f, 0.0f);
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.G36Scope)) {
            GL11.glTranslatef(-0.005f, -0.05f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Reflex)) {
            GL11.glTranslatef(0.0f, 0.13f, 0.0f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Kobra)) {
            GL11.glTranslatef(0.0f, 0.15f, -0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holo2)) {
            GL11.glTranslatef(0.0f, 0.24f, 0.1f);
        }
        if (Weapon.isActiveAttachment(renderContext.getWeaponInstance(), Attachments.Holographic2)) {
            GL11.glTranslatef(1.373f, -1.205f, 2.3f);
        }
        else {
            GL11.glTranslatef(1.373f, -1.34f, 2.4f);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6615(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glTranslatef(-0.225f, 0.725f, 0.4f);
        GL11.glRotatef(-3.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6614(final RenderContext renderContext) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScaled(1.5, 1.5, 1.5);
        GL11.glTranslatef(-0.225f, 0.725f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6613(final RenderContext renderContext) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glTranslatef(-1.8f, -1.1f, 2.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6612(final ItemStack itemStack) {
        GL11.glScaled(0.2800000011920929, 0.2800000011920929, 0.2800000011920929);
        GL11.glTranslatef(1.0f, 2.0f, -1.2f);
        GL11.glRotatef(-120.0f, -0.5f, 7.0f, 3.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6611(final ItemStack itemStack) {
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 4.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6610(final ModelBase model) {
        GL11.glTranslatef(-0.2f, -1.45f, -8.5f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$6609(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$6608(final ModelBase model) {
        GL11.glTranslatef(-0.37f, 0.8f, -1.7f);
        GL11.glScaled(1.25, 1.600000023841858, 1.7000000476837158);
        GL11.glRotatef(-5.0f, 1.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$createGun$6607(final ModelBase model) {
        GL11.glTranslatef(-0.37f, 0.8f, -1.7f);
        GL11.glScaled(1.25, 1.7000000476837158, 1.7000000476837158);
    }
    
    private static /* synthetic */ void lambda$createGun$6606(final ModelBase model) {
    }
    
    private static /* synthetic */ void lambda$createGun$6605(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.2f, -0.4f, -5.4f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$createGun$6604(final ModelBase model) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.05f, -2.13f, -0.4f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.125f, -2.418f, -0.5f);
            GL11.glScaled(0.03999999910593033, 0.03999999910593033, 0.03999999910593033);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6603(final ModelBase model) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.05f, -2.13f, -0.25f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glTranslatef(-0.125f, -2.415f, -0.95f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6602(final ModelBase model) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.05f, -2.13f, -0.25f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -2.415f, -0.95f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6601(final ModelBase model) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.073f, -2.12f, -0.7f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glTranslatef(-0.125f, -2.395f, -0.95f);
            GL11.glScaled(0.05999999865889549, 0.05999999865889549, 0.05999999865889549);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6600(final ModelBase model) {
        if (model instanceof Reflex2) {
            GL11.glTranslatef(0.035f, -0.065f, 1.28f);
            GL11.glScaled(0.07000000029802322, 0.07000000029802322, 0.07000000029802322);
        }
    }
    
    private static /* synthetic */ void lambda$createGun$6599(final EntityPlayer player, final ItemStack stack) {
        GL11.glTranslatef(-0.138f, -2.2f, -1.0f);
        GL11.glScaled(0.550000011920929, 0.550000011920929, 0.800000011920929);
    }
    
    private static /* synthetic */ void lambda$createGun$6598(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6597(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Sapphire.getTextureVariantIndex("Sapphire"));
    }
    
    private static /* synthetic */ void lambda$createGun$6596(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6595(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Gold.getTextureVariantIndex("Gold"));
    }
    
    private static /* synthetic */ void lambda$createGun$6594(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6593(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Diamond.getTextureVariantIndex("Diamond"));
    }
    
    private static /* synthetic */ void lambda$createGun$6592(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6591(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Amber.getTextureVariantIndex("Amber"));
    }
    
    private static /* synthetic */ void lambda$createGun$6590(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6589(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Forest.getTextureVariantIndex("Forest"));
    }
    
    private static /* synthetic */ void lambda$createGun$6588(final ItemAttachment a, final PlayerWeaponInstance i) {
    }
    
    private static /* synthetic */ void lambda$createGun$6587(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setActiveTextureIndex(GunSkins.Emerald.getTextureVariantIndex("Emerald"));
    }
    
    private static /* synthetic */ List lambda$createGun$6586(final ItemStack stack) {
        return Arrays.asList("Type: Light machine gun", "Damage: 7", "Caliber: 5.56x45mm NATO", "Magazines:", "100rnd 5.56x45mm NATO Beta-C Magazine", "Fire Rate: Auto");
    }
    
    private static /* synthetic */ Float lambda$createGun$6585() {
        return 0.05f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6584() {
        return 0.1f;
    }
    
    private static /* synthetic */ Float lambda$createGun$6583() {
        return 0.8f;
    }
}
