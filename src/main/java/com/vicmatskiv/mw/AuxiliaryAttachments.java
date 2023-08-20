package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.config.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.item.*;

public class AuxiliaryAttachments
{
    public static ItemAttachment<Weapon> FNP90Sight;
    public static ItemAttachment<Weapon> AR15Iron;
    public static ItemAttachment<Weapon> Extra;
    public static ItemAttachment<Weapon> ExtraAR;
    public static ItemAttachment<Weapon> GlockTop;
    public static ItemAttachment<Weapon> G18Top;
    public static ItemAttachment<Weapon> M9Top;
    public static ItemAttachment<Weapon> P2000Top;
    public static ItemAttachment<Weapon> DeagleTop;
    public static ItemAttachment<Weapon> Deagle44Top;
    public static ItemAttachment<Weapon> KSGPump;
    public static ItemAttachment<Weapon> L115Bolt1;
    public static ItemAttachment<Weapon> L115Bolt2;
    public static ItemAttachment<Weapon> SV98Action;
    public static ItemAttachment<Weapon> RevolverCase;
    public static ItemAttachment<Weapon> PythonCase;
    public static ItemAttachment<Weapon> R870Pump;
    public static ItemAttachment<Weapon> M1911Top;
    public static ItemAttachment<Weapon> M9SDsuppressor;
    public static ItemAttachment<Weapon> MosinBolt;
    public static ItemAttachment<Weapon> USP45Top;
    public static ItemAttachment<Weapon> MakarovTop;
    public static ItemAttachment<Weapon> AK12IronSight;
    public static ItemAttachment<Weapon> M14Rail;
    public static ItemAttachment<Weapon> P225Top;
    public static ItemAttachment<Weapon> P226Top;
    public static ItemAttachment<Weapon> P30Top;
    public static ItemAttachment<Weapon> MP5KGrip;
    public static ItemAttachment<Weapon> HecateIIBoltAction;
    public static ItemAttachment<Weapon> AR15Action;
    public static ItemAttachment<Weapon> BushmasterACRAction;
    public static ItemAttachment<Weapon> RemingtonACRAction;
    public static ItemAttachment<Weapon> AKIron;
    public static ItemAttachment<Weapon> AKpart;
    public static ItemAttachment<Weapon> AKaction;
    public static ItemAttachment<Weapon> AN94action;
    public static ItemAttachment<Weapon> VSSVintorezAction;
    public static ItemAttachment<Weapon> AK12action;
    public static ItemAttachment<Weapon> AKS74UIron;
    public static ItemAttachment<Weapon> AKRail;
    public static ItemAttachment<Weapon> AUGRail;
    public static ItemAttachment<Weapon> BushmasterACRRail;
    public static ItemAttachment<Weapon> RemingtonACRRail;
    public static ItemAttachment<Weapon> M4Rail;
    public static ItemAttachment<Weapon> ScarAction;
    public static ItemAttachment<Weapon> G36Rail;
    public static ItemAttachment<Weapon> G36Action;
    public static ItemAttachment<Weapon> FamasCarryHandle;
    public static ItemAttachment<Weapon> FamasAction;
    public static ItemAttachment<Weapon> AUGAction;
    public static ItemAttachment<Weapon> FamasBipod1;
    public static ItemAttachment<Weapon> FamasBipod2;
    public static ItemAttachment<Weapon> FelinAction;
    public static ItemAttachment<Weapon> FelinCarryHandle;
    public static ItemAttachment<Weapon> M14Action;
    public static ItemAttachment<Weapon> M14Action2;
    
    public AuxiliaryAttachments() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        AuxiliaryAttachments.AR15Iron = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.SCOPE).withCreativeTab(ModernWarfareMod.AttachmentsTab).withModel(new M4Iron1(), "AK12.png").withModel(new M4Iron2(), "AK12.png").withModel(new FALIron(), "AK12.png").withModel(new AR15CarryHandle(), "AK12.png").withInventoryModelPositioning((model, s) -> {
            if (model instanceof AR15CarryHandle) {
                GL11.glTranslatef(-0.6f, 0.0f, 0.2f);
                GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.6000000238418579, 0.699999988079071, 0.75);
            }
            else {
                GL11.glScalef(0.0f, 0.0f, 0.0f);
            }
            return;
        }).withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof AR15CarryHandle) {
                GL11.glTranslatef(0.1f, 0.0f, 0.4f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.5, 0.699999988079071, 0.699999988079071);
            }
            else {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof AR15CarryHandle) {
                GL11.glTranslatef(-1.6f, -0.5f, 1.2f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.30000001192092896, 0.5, 0.5);
            }
            else {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withCraftingRecipe(" AA", "F F", 'A', "ingotSteel", 'F', CommonProxy.SteelPlate).withName("AR15Iron").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.Extra = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA6).withModel(new AKMiron1(), "GunmetalTexture.png").withModel(new AKMiron2(), "GunmetalTexture.png").withModel(new AK47iron(), "GunmetalTexture.png").withModel(new M4Iron1(), "GunmetalTexture.png").withModel(new M4Iron2(), "GunmetalTexture.png").withModel(new P90iron(), "GunmetalTexture.png").withModel(new G36CIron1(), "GunmetalTexture.png").withModel(new G36CIron2(), "GunmetalTexture.png").withModel(new ScarIron1(), "GunmetalTexture.png").withModel(new ScarIron2(), "GunmetalTexture.png").withModel(new FALIron(), "GunmetalTexture.png").withModel(new M14Iron(), "GunmetalTexture.png").withModel(new MP5Iron(), "AK12.png").withName("Extra").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.ExtraAR = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new AR15Iron(), "AK12.png").withModel(new FALIron(), "AK12.png").withModel(new M4Iron1(), "AK12.png").withModel(new M4Iron2(), "AK12.png").withName("ExtraAR").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.GlockTop = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new GlockTop(), "GlockTop.png").withName("GlockTop").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.G18Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new GlockTop(), "G18Top.png").withName("G18Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.M9Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new M9Top(), "M9Top.png").withName("M9Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AK12IronSight = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new AK12IronSight(), "GunmetalTexture.png").withName("AK12IronSight").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.M9SDsuppressor = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA3).withModel(new Suppressor(), "GunmetalTexture.png").withName("M9SDsuppressor").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.P2000Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new P2000Top(), "P2000Top.png").withName("P2000Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.DeagleTop = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new DeagleTop(), "Deagle.png").withName("DeagleTop").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.Deagle44Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new DeagleTop(), "Deagle44.png").withName("Deagle44Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.KSGPump = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new KSG12Pump(), "GunmetalTexture.png").withName("KSGPump").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.L115Bolt1 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new L96Action(), "L96Action.png").withName("L96Action").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.SV98Action = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new SV98Action(), "SV98Action.png").withName("SV98Action").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.L115Bolt2 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA3).withModel(new L115Bolt2(), "AK12.png").withName("LP115Bolt2").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.MosinBolt = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new MosinBolt(), "NATOMag1.png").withName("MosinBolt").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.RevolverCase = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA3).withModel(new MagnumCase(), "MagnumCase.png").withName("RevolverCase").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.PythonCase = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA3).withModel(new MagnumCase(), "PythonCase.png").withName("PythonCase").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.R870Pump = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new R870Pump(), "Remington.png").withName("R870Pump").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.M1911Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new M1911Top(), "M1911.png").withName("M1911Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.USP45Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new USP45Top(), "USP45Top.png").withName("USP45Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.MakarovTop = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new MakarovTop(), "MakarovPM.png").withName("MakarovTop").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.FNP90Sight = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new FNP90Sight(), "AK12.png").withModel(new Reflex2(), "Reflex2.png").withFirstPersonModelPositioning((model, itemStack) -> {
            if (model instanceof FNP90Sight) {
                GL11.glTranslatef(0.1f, -0.8f, 0.2f);
                GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof FNP90Sight) {
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
            if (model instanceof FNP90Sight) {
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
            if (model instanceof FNP90Sight) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof Reflex2) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
            return;
        }).withName("FNP90Sight").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.M14Rail = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new M14Rail(), "GunmetalTexture.png").withName("M14Rail").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.M14Action = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new M14Action(), "AK12.png").withName("M14Action").withModId("mw").withTextureName("Dummy.png").withRenderablePart().build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.M14Action2 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new M14Action2(), "AK12.png").withName("M14Action2").withModId("mw").withTextureName("Dummy.png").withRenderablePart().build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.FamasCarryHandle = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new FamasCarryHandle(), "AK12.png").withName("FamasCarryHandle").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.FelinCarryHandle = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new FelinCarryHandle(), "AK12.png").withName("FelinCarryHandle").withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.P30Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new P2000Top(), "P30Top.png").withName("P30Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.P225Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new P225Top(), "P225Top.png").withName("P225Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.P226Top = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new P225Top(), "P226Top.png").withName("P226Top").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.MP5KGrip = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new Grip2(), "GunmetalTexture.png").withName("MP5KGrip").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.HecateIIBoltAction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new HecateIIBoltAction(), "AK12.png").withName("HecateIIBoltAction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AR15Action = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new AR15Action(), "AK12.png").withName("AR15Action").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.BushmasterACRAction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new ACRAction(), "AK12.png").withModel(new ACRAction2(), "AK12.png").withName("BushmasterACRAction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.RemingtonACRAction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA).withModel(new ACRAction(), "ACR.png").withModel(new ACRAction2(), "AK12.png").withName("RemingtonACRAction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AKIron = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new AKiron3(), "AK12.png").withName("AKIron3").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AKpart = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA3).withModel(new AKpart(), "AK12.png").withName("AKpart").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AKS74UIron = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA3).withModel(new AKS74UIron(), "AK12.png").withName("AKS74UIron").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AKRail = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA5).withModel(new AKRail(), "AK12.png").withName("AKRail").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AUGRail = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA5).withModel(new AKRail(), "AK12.png").withModel(new AKRail2(), "AK12.png").withModel(new AKRail3(), "AK12.png").withModel(new AKRail4(), "AK12.png").withName("AUGRail").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.BushmasterACRRail = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA5).withModel(new AKRail(), "AK12.png").withModel(new AKRail2(), "AK12.png").withModel(new AKRail3(), "AK12.png").withModel(new AKRail4(), "AK12.png").withModel(new AKRail5(), "AK12.png").withName("BushmasterACRRail").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.RemingtonACRRail = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA5).withModel(new AKRail(), "ACR.png").withModel(new AKRail2(), "ACR.png").withModel(new AKRail3(), "ACR.png").withModel(new AKRail4(), "ACR.png").withModel(new AKRail5(), "ACR.png").withName("RemingtonACRRail").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.M4Rail = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA5).withModel(new AKRail(), "AK12.png").withModel(new AKRail2(), "AK12.png").withModel(new AKRail3(), "AK12.png").withModel(new AKRail4(), "AK12.png").withModel(new AKRail5(), "AK12.png").withName("M4Rail").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.G36Rail = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA3).withModel(new G36Rail(), "AK12.png").withName("G36Rail").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AKaction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new AKaction(), "AK12.png").withName("AKaction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AN94action = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new AN94action(), "AK12.png").withName("AN94action").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.VSSVintorezAction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new VSSVintorezAction(), "AK12.png").withName("VSSVintorezAction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AK12action = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new AK12action(), "AK12.png").withName("AK12action").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.ScarAction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new ScarAction(), "AK12.png").withName("ScarAction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.G36Action = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new G36Action(), "AK12.png").withName("G36Action").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.FamasAction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new FamasAction(), "AK12.png").withName("FamasAction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.AUGAction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new AUGAction(), "AK12.png").withName("AUGAction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.FelinAction = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA4).withModel(new FelinAction(), "AK12.png").withName("FelinAction").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.FamasBipod1 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA2).withModel(new FamasBipod(), "AK12.png").withName("FamasBipod1").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        AuxiliaryAttachments.FamasBipod2 = new AttachmentBuilder<Weapon>().withCategory(AttachmentCategory.EXTRA3).withModel(new FamasBipod(), "AK12.png").withName("FamasBipod2").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$init$159(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof FNP90Sight) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$158(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof FNP90Sight) {
            GL11.glTranslatef(-0.6f, -0.1f, 0.3f);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$157(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof FNP90Sight) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$156(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof FNP90Sight) {
            GL11.glTranslatef(0.1f, -0.8f, 0.2f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
        else if (model instanceof Reflex2) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$155(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AR15CarryHandle) {
            GL11.glTranslatef(-1.6f, -0.5f, 1.2f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.30000001192092896, 0.5, 0.5);
        }
        else {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$154(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof AR15CarryHandle) {
            GL11.glTranslatef(0.1f, 0.0f, 0.4f);
            GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScaled(0.5, 0.699999988079071, 0.699999988079071);
        }
        else {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$153(final ModelBase model, final ItemStack s) {
        if (model instanceof AR15CarryHandle) {
            GL11.glTranslatef(-0.6f, 0.0f, 0.2f);
            GL11.glRotatef(10.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-190.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.6000000238418579, 0.699999988079071, 0.75);
        }
        else {
            GL11.glScalef(0.0f, 0.0f, 0.0f);
        }
    }
}
