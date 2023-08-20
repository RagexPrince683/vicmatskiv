package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.config.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.mw.models.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.electronics.*;
import com.vicmatskiv.weaponlib.model.*;
import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class Electronics
{
    public static ItemAttachment<Object> Tablet;
    
    public Electronics() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        Electronics.Tablet = new ItemTablet.Builder().withOpticalZoom().withZoomRange(0.22f, 0.02f).withViewfinderPositioning((p, s) -> {
            final float scale = 5.9f;
            GL11.glScalef(scale, scale / CompatibilityProvider.compatibility.getAspectRatio(ModernWarfareMod.MOD_CONTEXT), scale);
            GL11.glTranslatef(-0.12f, 0.56f, 0.01f);
            return;
        }).withCreativeTab(ModernWarfareMod.GadgetsTab).withCrosshair("HP").withModel(new TabletModel(), "IPad.png").withFirstPersonPositioning((player, itemStack) -> {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.68f, -1.35f, 0.7f);
            GL11.glScaled(1.0, 1.0, 1.0);
            return;
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof TabletModel) {
                GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
                GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
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
        }).withFirstPersonHandPositioning(c -> {
            GL11.glRotatef(190.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.05f, -1.7f, 0.05f);
            GL11.glScaled(1.100000023841858, 1.100000023841858, 1.100000023841858);
            return;
        }, c -> {
            GL11.glRotatef(190.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.1f, -0.45f, 0.4f);
            GL11.glScaled(1.100000023841858, 1.100000023841858, 1.100000023841858);
            return;
        }).withName("tablet").withModId("mw").withTextureName("Dummy.png").withCraftingRecipe("XXX", "XGX", "XEX", 'X', "ingotSteel", 'E', CommonProxy.ElectronicCircuitBoard, 'G', CompatibleBlocks.GLASS_PANE).build(ModernWarfareMod.MOD_CONTEXT);
        new ItemWirelessCamera.Builder().withModId("mw").withName("wcam").withCreativeTab(ModernWarfareMod.GadgetsTab).withModel(new CameraModel(), "AK12").withCrafting(CraftingComplexity.LOW, CommonProxy.SteelPlate, CommonProxy.ElectronicCircuitBoard).withFirstPersonPositioning((player, itemStack) -> {
            GL11.glRotatef(55.0f, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-0.1f, -1.6f, 1.0f);
            GL11.glScaled(1.0, 1.0, 1.0);
        }).withThirdPersonModelPositioning((model, itemStack) -> {
            if (model instanceof CameraModel) {
                GL11.glTranslatef(-0.9f, -0.8f, 0.5f);
                GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
                GL11.glScaled(0.5, 0.5, 0.5);
            }
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
        }).withEntityModelPositioning((model, itemStack) -> {
            if (model instanceof HP) {
                GL11.glTranslatef(0.1f, 0.2f, 0.4f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
            }
            else if (model instanceof LPscope) {
                GL11.glScaled(0.0, 0.0, 0.0);
            }
        }).withFirstPersonHandPositioning(c -> GL11.glScalef(0.0f, 0.0f, 0.0f), c -> GL11.glScalef(0.0f, 0.0f, 0.0f)).build(ModernWarfareMod.MOD_CONTEXT);
    }
    
    private static /* synthetic */ void lambda$init$241(final RenderContext c) {
        GL11.glScalef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$init$240(final RenderContext c) {
        GL11.glScalef(0.0f, 0.0f, 0.0f);
    }
    
    private static /* synthetic */ void lambda$init$239(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof HP) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$238(final ModelBase model, final ItemStack itemStack) {
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
    
    private static /* synthetic */ void lambda$init$237(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof CameraModel) {
            GL11.glTranslatef(-0.9f, -0.8f, 0.5f);
            GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.5, 0.5, 0.5);
        }
    }
    
    private static /* synthetic */ void lambda$init$236(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glRotatef(55.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.1f, -1.6f, 1.0f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$235(final RenderContext c) {
        GL11.glRotatef(190.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-0.1f, -0.45f, 0.4f);
        GL11.glScaled(1.100000023841858, 1.100000023841858, 1.100000023841858);
    }
    
    private static /* synthetic */ void lambda$init$234(final RenderContext c) {
        GL11.glRotatef(190.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(30.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.05f, -1.7f, 0.05f);
        GL11.glScaled(1.100000023841858, 1.100000023841858, 1.100000023841858);
    }
    
    private static /* synthetic */ void lambda$init$233(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof HP) {
            GL11.glTranslatef(0.1f, 0.2f, 0.4f);
            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScaled(0.4000000059604645, 0.4000000059604645, 0.4000000059604645);
        }
        else if (model instanceof LPscope) {
            GL11.glScaled(0.0, 0.0, 0.0);
        }
    }
    
    private static /* synthetic */ void lambda$init$232(final ModelBase model, final ItemStack itemStack) {
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
    
    private static /* synthetic */ void lambda$init$231(final ModelBase model, final ItemStack itemStack) {
        if (model instanceof TabletModel) {
            GL11.glTranslatef(-0.8f, -0.5f, 0.8f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(80.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScaled(0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        }
    }
    
    private static /* synthetic */ void lambda$init$230(final EntityPlayer player, final ItemStack itemStack) {
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(2.0f, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.68f, -1.35f, 0.7f);
        GL11.glScaled(1.0, 1.0, 1.0);
    }
    
    private static /* synthetic */ void lambda$init$229(final EntityPlayer p, final ItemStack s) {
        final float scale = 5.9f;
        GL11.glScalef(scale, scale / CompatibilityProvider.compatibility.getAspectRatio(ModernWarfareMod.MOD_CONTEXT), scale);
        GL11.glTranslatef(-0.12f, 0.56f, 0.01f);
    }
}
