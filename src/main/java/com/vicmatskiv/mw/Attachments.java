package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.config.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.entity.player.*;

public class Attachments
{
    public static ItemAttachment<Weapon> Reflex;
    public static ItemAttachment<Weapon> Holo2;
    public static ItemAttachment<Weapon> Holographic2;
    public static ItemAttachment<Weapon> Kobra;
    public static ItemAttachment<Weapon> ACOG;
    public static ItemAttachment<Weapon> Specter;
    public static ItemAttachment<Weapon> G36Scope;
    public static ItemAttachment<Weapon> AUGScope;
    public static ItemAttachment<Weapon> Scope;
    public static ItemAttachment<Weapon> HP;
    public static ItemAttachment<Weapon> Leupold;
    public static ItemAttachment<Weapon> PSO1;
    public static ItemAttachment<Weapon> Silencer556x45;
    public static ItemAttachment<Weapon> Silencer762x39;
    public static ItemAttachment<Weapon> Silencer556x39;
    public static ItemAttachment<Weapon> Silencer50BMG;
    public static ItemAttachment<Weapon> Silencer9mm;
    public static ItemAttachment<Weapon> Silencer762x54;
    public static ItemAttachment<Weapon> Silencer762x51;
    public static ItemAttachment<Weapon> Silencer45ACP;
    public static ItemAttachment<Weapon> Silencer12Gauge;
    public static ItemAttachment<Weapon> Silencer65x39;
    public static ItemAttachment<Weapon> Silencer57x38;
    public static ItemAttachment<Weapon> Silencer300AACBlackout;
    public static ItemAttachment<Weapon> Silencer357;
    public static ItemAttachment<Weapon> SilencerMP7;
    public static ItemAttachment<Weapon> Laser;
    public static ItemAttachment<Weapon> Laser2;
    public static ItemAttachment<Weapon> Grip2;
    public static ItemAttachment<Weapon> Grip;
    public static ItemAttachment<Weapon> StubbyGrip;
    public static ItemAttachment<Weapon> VGrip;
    public static ItemAttachment<Weapon> Bipod;
    public static ItemAttachment<Weapon> AKMIron;
    
    public Attachments() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        Attachments.Reflex = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Reflex(), "Reflex.png").withModel(new Reflex2(), "Reflex2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(0.1f, -0.8f, 0.2f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(-0.6f, -0.1f, 1.15f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Reflex) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("A  ", "ORX", "AXX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE).withName("Reflex").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.ACOG = new ItemScope.Builder().withOpticalZoom().withZoomRange(0.22f, 0.1f).withViewfinderPositioning((p, s) -> {
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glTranslatef(0.12f, 0.37f, 0.45f);
            return;
        }).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new ACOG(), "Acog.png").withModel(new Acog2(), "Acog2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof ACOG) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof Acog2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof ACOG) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Acog2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof ACOG) {
                GL11.glTranslatef(-0.6f, -0.7f, 0.65f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            }
            else if (model instanceof Acog2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof ACOG) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Acog2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("FXA", "ORG", "AXX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE, 'F', CommonProxy.CopperWiring).withName("Acog").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Specter = new ItemScope.Builder().withOpticalZoom().withZoomRange(0.22f, 0.1f).withViewfinderPositioning((p, s) -> {
            GL11.glScalef(2.7f, 2.8f, 2.7f);
            GL11.glTranslatef(-0.06f, 0.275f, 0.56f);
            return;
        }).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new SpecterSight(), "SpecterSight.png").withModel(new Acog2(), "Acog2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof SpecterSight) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            }
            else if (model instanceof Acog2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof SpecterSight) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.25, 0.25, 0.25);
            }
            else if (model instanceof Acog2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof SpecterSight) {
                GL11.glTranslatef(-0.6f, 0.0f, 0.85f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof Acog2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof SpecterSight) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Acog2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("FXA", "ORG", "XAX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE, 'F', CommonProxy.CopperWiring).withName("Specter").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Holo2 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Holographic(), "Holographic.png").withModel(new Holo2(), "Holo3.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(0.1f, -0.8f, 0.2f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Holo2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(-0.6f, -0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            else if (model instanceof Holo2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Holographic) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Holo2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("  A", "XRO", "AXX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE).withName("Holographic").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Holographic2 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Holographic2(), "Holographic2.png").withModel(new Holo2(), "Holo3.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(0.1f, -0.8f, 0.2f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Holo2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Holo2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(-0.6f, -0.1f, 0.5f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            else if (model instanceof Holo2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Holographic2) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Holo2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("  A", "XRO", "AXX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE).withName("Holographic2").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Kobra = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Kobra(), "Kobra.png").withModel(new Reflex2(), "Reflex2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(0.4f, -0.8f, 0.5f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(-0.6f, -0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Kobra) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("X  ", "OGX", "ARX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE).withName("Kobra").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.G36Scope = new ItemScope.Builder().withOpticalZoom().withZoomRange(0.22f, 0.1f).withViewfinderPositioning((p, s) -> {
            GL11.glScalef(1.5f, 1.5f, 1.5f);
            GL11.glTranslatef(-0.095f, 0.6f, 0.85f);
            return;
        }).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new UFCG36Scope(), "AK12.png").withModel(new Reflex2(), "Holo3.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof UFCG36Scope) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof UFCG36Scope) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof UFCG36Scope) {
                GL11.glTranslatef(-0.6f, -0.7f, 1.2f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof UFCG36Scope) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe(new Object[0]).withName("G36Scope").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.AUGScope = new ItemScope.Builder().withOpticalZoom().withZoomRange(0.22f, 0.1f).withViewfinderPositioning((p, s) -> {
            GL11.glScalef(1.65f, 1.65f, 1.6f);
            GL11.glTranslatef(-0.07f, 0.559f, 1.82f);
            return;
        }).withModel(new AUGScope(), "AK12.png").withModel(new LPscope(), "HP2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof AUGScope) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof AUGScope) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof AUGScope) {
                GL11.glTranslatef(-0.6f, -0.7f, 0.65f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof AUGScope) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withName("AUGScope").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Scope = new ItemScope.Builder().withOpticalZoom().withZoomRange(0.22f, 0.06f).withViewfinderPositioning((p, s) -> {
            GL11.glScalef(1.1f, 1.1f, 1.1f);
            GL11.glTranslatef(0.1f, 0.395f, 0.6f);
            return;
        }).withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withCrosshair("LP").withModel(new LP(), "AK12.png").withModel(new LPscope(), "HP2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof LP) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof LP) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof LP) {
                GL11.glTranslatef(-0.6f, -0.6f, 0.5f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof LP) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("A R", "OGO", "XXX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE).withName("LPScope").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Leupold = new ItemScope.Builder().withOpticalZoom().withZoomRange(0.22f, 0.04f).withViewfinderPositioning((p, s) -> {
            GL11.glScalef(2.3f, 2.3f, 2.3f);
            GL11.glTranslatef(-0.085f, 0.33f, 1.75f);
            return;
        }).withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withCrosshair("LP").withModel(new Leupold(), "Leupold.png").withModel(new LeupoldReticle(), "Reticle.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Leupold) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof LeupoldReticle) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Leupold) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof LeupoldReticle) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Leupold) {
                GL11.glTranslatef(-0.6f, -0.45f, 0.94f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
            }
            else if (model instanceof LeupoldReticle) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Leupold) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof LeupoldReticle) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("ARR", "OGO", "XXX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE).withName("Leupold").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.PSO1 = new ItemScope.Builder().withOpticalZoom().withZoomRange(0.22f, 0.06f).withViewfinderPositioning((p, s) -> {
            GL11.glScalef(1.05f, 1.05f, 1.05f);
            GL11.glTranslatef(-0.32f, 0.168f, 1.2f);
            return;
        }).withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withCrosshair("LP").withModel(new PSO1(), "AK12.png").withModel(new PSO12(), "AK12.png").withModel(new LPscope(), "HP2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof PSO1) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof PSO12) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof PSO1) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof PSO12) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof PSO1) {
                GL11.glTranslatef(-0.6f, -0.3f, 0.7f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof PSO12) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof PSO1) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            else if (model instanceof PSO12) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withName("PSO1").withCraftingRecipe("ARR", "XXX", "OGO", "  X", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass, 'G', CompatibleBlocks.GLASS_PANE).withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.HP = new ItemScope.Builder().withOpticalZoom().withZoomRange(0.22f, 0.02f).withViewfinderPositioning((p, s) -> {
            GL11.glScalef(1.65f, 1.65f, 1.65f);
            GL11.glTranslatef(0.0285f, 0.492f, 0.7f);
            return;
        }).withCreativeTab(ModernWarfareMod.AttachmentsTab).withCrosshair("HP").withModel(new HP(), "AK12.png").withModel(new LPscope(), "HP2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof HP) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof HP) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof HP) {
                GL11.glTranslatef(-0.6f, -0.6f, 0.6f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.6499999761581421, 0.6499999761581421, 0.6499999761581421);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof HP) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("ARX", "ORO", "AXX", 'R', CommonProxy.ElectronicCircuitBoard, 'A', CommonProxy.MiniSteelPlate, 'X', "ingotSteel", 'O', CommonProxy.OpticGlass).withName("HPScope").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer556x45 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor556x45(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x45) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x45) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x45) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x45) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer556x45").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer762x39 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor762x39(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor762x39) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor762x39) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor762x39) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor762x39) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer762x39").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer9mm = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor(), "GunmetalTexture.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer9mm").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer45ACP = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor45ACP(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor45ACP) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor45ACP) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor45ACP) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor45ACP) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer45ACP").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer762x54 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer762x54").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer762x51 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor762x51(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor762x51) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor762x51) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor762x51) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor762x51) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer762x51").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer50BMG = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor(), "GunmetalTexture.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer50BMG").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer556x39 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor556x39(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x39) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x39) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x39) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x39) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer556x39").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.AKMIron = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new AKMiron1(), "AK12.png").withModel(new AKMiron2(), "AK12.png").withModel(new AK47iron(), "AK12.png").withModel(new M4Iron1(), "AK12.png").withModel(new M4Iron2(), "AK12.png").withModel(new P90iron(), "AK12.png").withModel(new G36CIron1(), "AK12.png").withModel(new G36CIron2(), "AK12.png").withModel(new ScarIron1(), "AK12.png").withModel(new ScarIron2(), "AK12.png").withModel(new FALIron(), "AK12.png").withModel(new M14Iron(), "AK12.png").withModel(new MP5Iron(), "AK12.png").withModel(new MP5Iron(), "AK12.png").withInventoryModelPositioning((model, s) -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(-0.6f, -0.7f, 0.65f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            }
            else {
                GL11.glScalef(0.0f, 0.0f, 0.0f);
            }
            return;
        }).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(0.1f, -0.8f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
            }
            else {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof M4Iron1) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            else {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe("AAA", 'A', "ingotSteel").withName("AKMIron").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.SilencerMP7 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("SilencerMP7").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer357 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor(), "GunmetalTexture.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer357").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer57x38 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer57x38").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer12Gauge = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor45ACP(), "GunmetalTexture.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor45ACP) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor45ACP) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor45ACP) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor45ACP) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer12Gauge").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer300AACBlackout = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor300AACBlackout(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor300AACBlackout) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor300AACBlackout) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor300AACBlackout) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor300AACBlackout) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer300AACBlackout").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Silencer65x39 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SILENCER).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Suppressor556x39(), "AK12.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x39) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x39) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x39) {
                GL11.glTranslatef(0.6f, 0.1f, 0.3f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.0, 1.0, 1.0);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Suppressor556x39) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCrafting(CraftingComplexity.MEDIUM, "ingotSteel", CommonProxy.SteelPlate).withName("Silencer65x39").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Laser = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.GRIP).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Laser(), "AK12.png").withPostRender(new LaserBeamRenderer((p, s) -> GL11.glTranslatef(-0.2f, 1.4f, 1.8f))).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Laser) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withFirstPersonModelPositioning((model, itemStack) -> {
            if (!(model instanceof AR15Iron)) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Laser) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Laser) {
                GL11.glTranslatef(0.6f, -0.3f, 0.65f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.7999999523162842, 1.7999999523162842, 1.7999999523162842);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Laser) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCraftingRecipe(" X ", "ARE", "AXX", 'X', "ingotSteel", 'A', CommonProxy.MiniSteelPlate, 'R', CommonProxy.LaserPointer, 'E', CommonProxy.ElectronicCircuitBoard).withName("Laser").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Laser2 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.GRIP).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Laser2(), "AK12.png").withPostRender(new LaserBeamRenderer((p, s) -> GL11.glTranslatef(-0.2f, 1.3f, 1.8f))).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Laser2) {
                GL11.glTranslatef(0.5f, -1.3f, -0.1f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Laser2) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Laser2) {
                GL11.glTranslatef(0.6f, -0.3f, 0.65f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.7999999523162842, 1.7999999523162842, 1.7999999523162842);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Laser2) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            return;
        }).withCraftingRecipe("AXA", "XRE", "AXX", 'X', "ingotSteel", 'A', CommonProxy.MiniSteelPlate, 'R', CommonProxy.LaserPointer, 'E', CommonProxy.ElectronicCircuitBoard).withName("Laser2").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Grip2 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.GRIP).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Grip2(), "AK12.png").withApply((a, i) -> i.setRecoil(i.getWeapon().getRecoil() * 0.6f)).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Grip2) {
                GL11.glTranslatef(0.7f, -1.2f, 0.5f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Grip2) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Grip2) {
                GL11.glTranslatef(0.6f, 0.3f, -0.5f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.2999999523162842, 1.2999999523162842, 1.2999999523162842);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Grip2) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withCraftingRecipe("AXX", " X ", " X ", 'X', "ingotSteel", 'A', CommonProxy.MiniSteelPlate).withName("Grip2").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Grip = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.GRIP).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new AngledGrip(), "AK12.png").withApply((a, weapon, player) -> weapon.changeRecoil(player, 1.5f)).withRemove((attachment, weapon, player) -> weapon.changeRecoil(player, 1.0f)).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof AngledGrip) {
                GL11.glTranslatef(0.7f, -1.1f, 0.5f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof AngledGrip) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof AngledGrip) {
                GL11.glTranslatef(0.6f, 0.8f, -0.45f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof AngledGrip) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withCraftingRecipe("X A", " XX", 'X', "ingotSteel", 'A', CommonProxy.MiniSteelPlate).withName("AngledGrip").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.StubbyGrip = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.GRIP).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new StubbyGrip(), "AK12.png").withApply((a, i) -> i.setRecoil(i.getWeapon().getRecoil() * 0.6f)).withRemove((a, i) -> i.setRecoil(i.getWeapon().getRecoil())).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof StubbyGrip) {
                GL11.glTranslatef(0.7f, -1.2f, 0.5f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof StubbyGrip) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof StubbyGrip) {
                GL11.glTranslatef(0.6f, 0.5f, -0.5f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof StubbyGrip) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withCraftingRecipe("AXA", " X ", 'X', "ingotSteel", 'A', CommonProxy.MiniSteelPlate).withName("StubbyGrip").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.VGrip = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.GRIP).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new VGrip(), "AK12.png").withApply((a, i) -> i.setRecoil(i.getWeapon().getRecoil() * 0.6f)).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof VGrip) {
                GL11.glTranslatef(0.7f, -1.1f, 0.5f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof VGrip) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
            return;
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof VGrip) {
                GL11.glTranslatef(0.6f, 0.3f, -0.5f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(1.2999999523162842, 1.2999999523162842, 1.2999999523162842);
            }
            return;
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof VGrip) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            return;
        }).withCraftingRecipe("XAX", " X ", " X ", 'X', "ingotSteel", 'A', CommonProxy.MiniSteelPlate).withName("VGrip").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Attachments.Bipod = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.GRIP).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new Bipod(), "AK12.png").withApply((a, i) -> i.setRecoil(i.getWeapon().getRecoil() * 0.4f)).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Bipod) {
                GL11.glTranslatef(0.7f, -1.1f, 0.5f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof Bipod) {
                GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
        }).withInventoryModelPositioning((model, itemStack) -> {
            if (model instanceof Bipod) {
                GL11.glTranslatef(0.6f, -0.05f, -0.5f);
                GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
            }
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof Bipod) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
        }).withCraftingRecipe(" X ", "A A", "X X", 'X', "ingotSteel", 'A', CommonProxy.MiniSteelPlate).withName("Bipod").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$init$152(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Bipod) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$151(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Bipod) {
            GL11.glTranslatef(0.6f, -0.05f, -0.5f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        }
    }
    
    private static /* synthetic */ void lambda$init$150(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Bipod) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$149(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Bipod) {
            GL11.glTranslatef(0.7f, -1.1f, 0.5f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$148(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setRecoil(i.getWeapon().getRecoil() * 0.4f);
    }
    
    private static /* synthetic */ void lambda$init$147(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof VGrip) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$146(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof VGrip) {
            GL11.glTranslatef(0.6f, 0.3f, -0.5f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2999999523162842, 1.2999999523162842, 1.2999999523162842);
        }
    }
    
    private static /* synthetic */ void lambda$init$145(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof VGrip) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$144(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof VGrip) {
            GL11.glTranslatef(0.7f, -1.1f, 0.5f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$143(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setRecoil(i.getWeapon().getRecoil() * 0.6f);
    }
    
    private static /* synthetic */ void lambda$init$142(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof StubbyGrip) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$141(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof StubbyGrip) {
            GL11.glTranslatef(0.6f, 0.5f, -0.5f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.600000023841858, 1.600000023841858, 1.600000023841858);
        }
    }
    
    private static /* synthetic */ void lambda$init$140(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof StubbyGrip) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$139(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof StubbyGrip) {
            GL11.glTranslatef(0.7f, -1.2f, 0.5f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$138(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setRecoil(i.getWeapon().getRecoil());
    }
    
    private static /* synthetic */ void lambda$init$137(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setRecoil(i.getWeapon().getRecoil() * 0.6f);
    }
    
    private static /* synthetic */ void lambda$init$136(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AngledGrip) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$135(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AngledGrip) {
            GL11.glTranslatef(0.6f, 0.8f, -0.45f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        }
    }
    
    private static /* synthetic */ void lambda$init$134(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AngledGrip) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$133(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AngledGrip) {
            GL11.glTranslatef(0.7f, -1.1f, 0.5f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$132(final ItemAttachment attachment, final Weapon weapon, final EntityPlayer player) {
        weapon.changeRecoil(player, 1.0f);
    }
    
    private static /* synthetic */ void lambda$init$131(final ItemAttachment a, final Weapon weapon, final EntityPlayer player) {
        weapon.changeRecoil(player, 1.5f);
    }
    
    private static /* synthetic */ void lambda$init$130(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Grip2) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$129(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Grip2) {
            GL11.glTranslatef(0.6f, 0.3f, -0.5f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2999999523162842, 1.2999999523162842, 1.2999999523162842);
        }
    }
    
    private static /* synthetic */ void lambda$init$128(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Grip2) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$127(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Grip2) {
            GL11.glTranslatef(0.7f, -1.2f, 0.5f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$126(final ItemAttachment a, final PlayerWeaponInstance i) {
        i.setRecoil(i.getWeapon().getRecoil() * 0.6f);
    }
    
    private static /* synthetic */ void lambda$init$125(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Laser2) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$124(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Laser2) {
            GL11.glTranslatef(0.6f, -0.3f, 0.65f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.7999999523162842, 1.7999999523162842, 1.7999999523162842);
        }
    }
    
    private static /* synthetic */ void lambda$init$123(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Laser2) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$122(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Laser2) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$121(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(-0.2f, 1.3f, 1.8f);
    }
    
    private static /* synthetic */ void lambda$init$120(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Laser) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$119(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Laser) {
            GL11.glTranslatef(0.6f, -0.3f, 0.65f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.7999999523162842, 1.7999999523162842, 1.7999999523162842);
        }
    }
    
    private static /* synthetic */ void lambda$init$118(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Laser) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$117(final ModelBase model, final ItemStack itemStack) {
        if (!(model instanceof AR15Iron)) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$116(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Laser) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$115(final EntityPlayer p, final ItemStack s) {
        GL11.glTranslatef(-0.2f, 1.4f, 1.8f);
    }
    
    private static /* synthetic */ void lambda$init$114(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x39) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$113(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x39) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$112(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x39) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$111(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x39) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$110(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor300AACBlackout) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$109(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor300AACBlackout) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$108(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor300AACBlackout) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$107(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor300AACBlackout) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$106(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor45ACP) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$105(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor45ACP) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$104(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor45ACP) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$103(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor45ACP) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$102(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$101(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$100(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$99(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$98(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$97(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$96(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$95(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$94(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$93(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$92(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$91(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$90(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$89(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$88(final ModelBase model, final ItemStack s) {
        if (model instanceof M4Iron1) {
            GL11.glTranslatef(-0.6f, -0.7f, 0.65f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        }
        else {
            GL11.glScalef(0.0f, 0.0f, 0.0f);
        }
    }
    
    private static /* synthetic */ void lambda$init$87(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x39) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$86(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x39) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$85(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x39) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$84(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x39) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$83(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$82(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$81(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$80(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$79(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor762x51) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$78(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor762x51) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$77(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor762x51) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$76(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor762x51) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$75(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$74(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$73(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$72(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$71(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor45ACP) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$70(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor45ACP) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$69(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor45ACP) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$68(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor45ACP) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$67(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$66(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$65(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$64(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$63(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor762x39) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$62(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor762x39) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$61(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor762x39) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$60(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor762x39) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$59(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x45) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
    }
    
    private static /* synthetic */ void lambda$init$58(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x45) {
            GL11.glTranslatef(0.6f, 0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$57(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x45) {
            GL11.glTranslatef(-0.7f, -0.5f, 0.6f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$56(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Suppressor556x45) {
            GL11.glTranslatef(0.5f, -1.3f, -0.1f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$55(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof HP) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$54(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof HP) {
            GL11.glTranslatef(-0.6f, -0.6f, 0.6f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6499999761581421, 0.6499999761581421, 0.6499999761581421);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$53(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof HP) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$52(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof HP) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$51(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(1.65f, 1.65f, 1.65f);
        GL11.glTranslatef(0.0285f, 0.492f, 0.7f);
    }
    
    private static /* synthetic */ void lambda$init$50(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof PSO1) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof PSO12) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$49(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof PSO1) {
            GL11.glTranslatef(-0.6f, -0.3f, 0.7f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof PSO12) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$48(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof PSO1) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof PSO12) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$47(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof PSO1) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
        else if (model instanceof PSO12) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$46(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(1.05f, 1.05f, 1.05f);
        GL11.glTranslatef(-0.32f, 0.168f, 1.2f);
    }
    
    private static /* synthetic */ void lambda$init$45(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Leupold) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof LeupoldReticle) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$44(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Leupold) {
            GL11.glTranslatef(-0.6f, -0.45f, 0.94f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        }
        else if (model instanceof LeupoldReticle) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$43(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Leupold) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof LeupoldReticle) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$42(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Leupold) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof LeupoldReticle) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$41(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(2.3f, 2.3f, 2.3f);
        GL11.glTranslatef(-0.085f, 0.33f, 1.75f);
    }
    
    private static /* synthetic */ void lambda$init$40(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof LP) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$39(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof LP) {
            GL11.glTranslatef(-0.6f, -0.6f, 0.5f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.800000011920929, 0.800000011920929, 0.800000011920929);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$38(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof LP) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$37(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof LP) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$36(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(1.1f, 1.1f, 1.1f);
        GL11.glTranslatef(0.1f, 0.395f, 0.6f);
    }
    
    private static /* synthetic */ void lambda$init$35(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AUGScope) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$34(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AUGScope) {
            GL11.glTranslatef(-0.6f, -0.7f, 0.65f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$33(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AUGScope) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$32(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AUGScope) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$31(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(1.65f, 1.65f, 1.6f);
        GL11.glTranslatef(-0.07f, 0.559f, 1.82f);
    }
    
    private static /* synthetic */ void lambda$init$30(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof UFCG36Scope) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$29(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof UFCG36Scope) {
            GL11.glTranslatef(-0.6f, -0.7f, 1.2f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.8999999761581421, 0.8999999761581421, 0.8999999761581421);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$28(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof UFCG36Scope) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$27(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof UFCG36Scope) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$26(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(1.5f, 1.5f, 1.5f);
        GL11.glTranslatef(-0.095f, 0.6f, 0.85f);
    }
    
    private static /* synthetic */ void lambda$init$25(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$24(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.6f, -0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$23(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$22(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Kobra) {
            GL11.glTranslatef(0.4f, -0.8f, 0.5f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$21(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Holo2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$20(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.6f, -0.1f, 0.5f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
        else if (model instanceof Holo2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$19(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Holo2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$18(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Holographic2) {
            GL11.glTranslatef(0.1f, -0.8f, 0.2f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$17(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Holo2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$16(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.6f, -0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
        else if (model instanceof Holo2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$15(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Holo2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$14(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Holographic) {
            GL11.glTranslatef(0.1f, -0.8f, 0.2f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Holo2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$13(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof SpecterSight) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Acog2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$12(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof SpecterSight) {
            GL11.glTranslatef(-0.6f, 0.0f, 0.85f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof Acog2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$11(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof SpecterSight) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.25, 0.25, 0.25);
        }
        else if (model instanceof Acog2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$10(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof SpecterSight) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.3499999940395355, 0.3499999940395355, 0.3499999940395355);
        }
        else if (model instanceof Acog2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$9(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(2.7f, 2.8f, 2.7f);
        GL11.glTranslatef(-0.06f, 0.275f, 0.56f);
    }
    
    private static /* synthetic */ void lambda$init$8(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof ACOG) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Acog2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$7(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof ACOG) {
            GL11.glTranslatef(-0.6f, -0.7f, 0.65f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.2000000476837158, 1.2000000476837158, 1.2000000476837158);
        }
        else if (model instanceof Acog2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$6(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof ACOG) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Acog2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$5(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof ACOG) {
            GL11.glTranslatef(0.1f, -0.8f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.699999988079071, 0.699999988079071, 0.699999988079071);
        }
        else if (model instanceof Acog2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$4(final EntityPlayer p, final ItemStack s) {
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glTranslatef(0.12f, 0.37f, 0.45f);
    }
    
    private static /* synthetic */ void lambda$init$3(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$2(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.6f, -0.1f, 1.15f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$1(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.30000001192092896, 0.30000001192092896);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$0(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof Reflex) {
            GL11.glTranslatef(0.1f, -0.8f, 0.2f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
}
