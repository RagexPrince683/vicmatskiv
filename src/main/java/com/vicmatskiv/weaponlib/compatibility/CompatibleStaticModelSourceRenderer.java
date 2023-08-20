package com.vicmatskiv.weaponlib.compatibility;

import net.minecraftforge.client.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import java.util.*;
import com.vicmatskiv.weaponlib.*;

public abstract class CompatibleStaticModelSourceRenderer implements IItemRenderer
{
    protected StaticModelSourceRenderer.Builder builder;
    
    protected CompatibleStaticModelSourceRenderer(final StaticModelSourceRenderer.Builder builder) {
        super();
        this.builder = builder;
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return true;
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack itemStack, final Object... data) {
        GL11.glPushMatrix();
        GL11.glScaled(-1.0, -1.0, 1.0);
        final EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
        final RenderContext<RenderableState> renderContext = new RenderContext<RenderableState>(this.getModContext(), player, itemStack);
        switch (type) {
            case ENTITY: {
                this.builder.getEntityPositioning().accept(itemStack);
                break;
            }
            case INVENTORY: {
                this.builder.getInventoryPositioning().accept(itemStack);
                break;
            }
            case EQUIPPED: {
                this.builder.getThirdPersonPositioning().accept(player, itemStack);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                this.builder.getFirstPersonPositioning().accept(player, itemStack);
                CompatibleWeaponRenderer.renderLeftArm(player, renderContext, (p, c) -> this.builder.getFirstPersonLeftHandPositioning().accept(c));
                CompatibleWeaponRenderer.renderRightArm(player, renderContext, (p, c) -> this.builder.getFirstPersonRightHandPositioning().accept(c));
                break;
            }
        }
        this.renderModelSource(renderContext, itemStack, type, null, 0.0f, 0.0f, -0.4f, 0.0f, 0.0f, 0.08f);
        GL11.glPopMatrix();
    }
    
    private void renderModelSource(final RenderContext<RenderableState> renderContext, final ItemStack itemStack, final IItemRenderer.ItemRenderType type, final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        if (!(itemStack.getItem() instanceof ModelSource)) {
            throw new IllegalArgumentException();
        }
        GL11.glPushMatrix();
        final ModelSource modelSource = (ModelSource)itemStack.getItem();
        for (final Tuple<ModelBase, String> texturedModel : modelSource.getTexturedModels()) {
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(this.builder.getModId() + ":textures/models/" + texturedModel.getV()));
            GL11.glPushMatrix();
            GL11.glPushAttrib(8192);
            final ModelBase model = texturedModel.getU();
            switch (type) {
                case ENTITY: {
                    this.builder.getEntityModelPositioning().accept(model, itemStack);
                    break;
                }
                case INVENTORY: {
                    this.builder.getInventoryModelPositioning().accept(model, itemStack);
                    break;
                }
                case EQUIPPED: {
                    this.builder.getThirdPersonModelPositioning().accept(model, itemStack);
                    break;
                }
                case EQUIPPED_FIRST_PERSON: {
                    this.builder.getFirstPersonModelPositioning().accept(model, itemStack);
                    break;
                }
            }
            model.render(entity, f, f1, f2, f3, f4, f5);
            GL11.glPopAttrib();
            GL11.glPopMatrix();
        }
        final CustomRenderer<RenderableState> postRenderer = (CustomRenderer<RenderableState>)modelSource.getPostRenderer();
        if (postRenderer != null) {
            renderContext.setAgeInTicks(-0.4f);
            renderContext.setScale(0.08f);
            renderContext.setCompatibleTransformType(CompatibleTransformType.fromItemRenderType(type));
            renderContext.setPlayerItemInstance(this.getModContext().getPlayerItemInstanceRegistry().getItemInstance(renderContext.getPlayer(), itemStack));
            GL11.glPushMatrix();
            GL11.glPushAttrib(8193);
            postRenderer.render(renderContext);
            GL11.glPopAttrib();
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
    }
    
    protected abstract ModContext getModContext();
    
    private /* synthetic */ void lambda$renderItem$250(final Part p, final RenderContext c) {
        this.builder.getFirstPersonRightHandPositioning().accept(c);
    }
    
    private /* synthetic */ void lambda$renderItem$249(final Part p, final RenderContext c) {
        this.builder.getFirstPersonLeftHandPositioning().accept(c);
    }
}
