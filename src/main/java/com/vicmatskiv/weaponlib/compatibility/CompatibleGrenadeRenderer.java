package com.vicmatskiv.weaponlib.compatibility;

import net.minecraftforge.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.client.entity.*;
import java.util.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.grenade.*;

public abstract class CompatibleGrenadeRenderer implements IItemRenderer
{
    private GrenadeRenderer.Builder builder;
    
    protected CompatibleGrenadeRenderer(final GrenadeRenderer.Builder builder) {
        super();
        this.builder = builder;
    }
    
    protected abstract ClientModContext getClientModContext();
    
    protected abstract StateDescriptor getStateDescriptor(final EntityPlayer p0, final ItemStack p1);
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return true;
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack weaponItemStack, final Object... data) {
        GL11.glPushMatrix();
        GL11.glScaled(-1.0, -1.0, 1.0);
        EntityPlayer player;
        if (data.length > 1 && data[1] instanceof EntityPlayer) {
            player = (EntityPlayer)data[1];
        }
        else {
            player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
        }
        final RenderContext<RenderableState> renderContext = new RenderContext<RenderableState>(this.getClientModContext(), player, weaponItemStack);
        renderContext.setAgeInTicks(-0.4f);
        renderContext.setScale(0.08f);
        renderContext.setCompatibleTransformType(CompatibleTransformType.fromItemRenderType(type));
        MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner = null;
        switch (type) {
            case ENTITY: {
                this.builder.getEntityPositioning().accept(weaponItemStack);
                break;
            }
            case INVENTORY: {
                this.builder.getInventoryPositioning().accept(weaponItemStack);
                break;
            }
            case EQUIPPED: {
                this.builder.getThirdPersonPositioning().accept(renderContext);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                final StateDescriptor stateDescriptor = this.getStateDescriptor(player, weaponItemStack);
                renderContext.setPlayerItemInstance(stateDescriptor.instance);
                final MultipartPositioning<Part, RenderContext<RenderableState>> multipartPositioning = stateDescriptor.stateManager.nextPositioning();
                renderContext.setTransitionProgress(multipartPositioning.getProgress());
                renderContext.setFromState(multipartPositioning.getFromState(RenderableState.class));
                renderContext.setToState(multipartPositioning.getToState(RenderableState.class));
                positioner = multipartPositioning.getPositioner();
                renderContext.capturePartPosition(Part.NONE);
                this.renderLeftArm(player, renderContext, positioner);
                positioner.randomize(stateDescriptor.rate, stateDescriptor.amplitude);
                this.renderRightArm(player, renderContext, positioner);
                positioner.position(Part.MAIN_ITEM, renderContext);
                if (DebugPositioner.isDebugModeEnabled()) {
                    DebugPositioner.position(Part.MAIN_ITEM, renderContext);
                }
                renderContext.capturePartPosition(Part.MAIN_ITEM);
                break;
            }
        }
        this.renderItem(weaponItemStack, renderContext, positioner);
        GL11.glPopMatrix();
    }
    
    protected abstract void renderItem(final ItemStack p0, final RenderContext<RenderableState> p1, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> p2);
    
    private void renderRightArm(final EntityPlayer player, final RenderContext<RenderableState> renderContext, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner) {
        final RenderPlayer render = (RenderPlayer)RenderManager.instance.getEntityRenderObject((Entity)player);
        Minecraft.getMinecraft().getTextureManager().bindTexture(((AbstractClientPlayer)player).getLocationSkin());
        GL11.glPushMatrix();
        GL11.glScaled(1.0, 1.0, 1.0);
        GL11.glScaled(1.0, 1.0, 1.0);
        GL11.glTranslatef(-0.25f, 0.0f, 0.2f);
        GL11.glRotatef(5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        positioner.position(Part.RIGHT_HAND, renderContext);
        if (DebugPositioner.isDebugModeEnabled()) {
            DebugPositioner.position(Part.RIGHT_HAND, renderContext);
        }
        renderContext.capturePartPosition(Part.RIGHT_HAND);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        render.modelBipedMain.onGround = 0.0f;
        render.modelBipedMain.setRotationAngles(0.0f, 0.3f, 0.0f, 0.0f, 0.0f, 0.0625f, (Entity)player);
        render.modelBipedMain.bipedRightArm.render(0.0625f);
        GL11.glPopMatrix();
    }
    
    private void renderLeftArm(final EntityPlayer player, final RenderContext<RenderableState> renderContext, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner) {
        final RenderPlayer render = (RenderPlayer)RenderManager.instance.getEntityRenderObject((Entity)player);
        Minecraft.getMinecraft().getTextureManager().bindTexture(((AbstractClientPlayer)player).getLocationSkin());
        GL11.glPushMatrix();
        GL11.glScaled(1.0, 1.0, 1.0);
        GL11.glTranslatef(0.0f, -1.0f, 0.0f);
        GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
        positioner.position(Part.LEFT_HAND, renderContext);
        if (DebugPositioner.isDebugModeEnabled()) {
            DebugPositioner.position(Part.LEFT_HAND, renderContext);
        }
        renderContext.capturePartPosition(Part.LEFT_HAND);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        render.modelBipedMain.onGround = 0.0f;
        render.modelBipedMain.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, (Entity)player);
        render.modelBipedMain.bipedLeftArm.render(0.0625f);
        GL11.glPopMatrix();
    }
    
    public abstract void renderAttachments(final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> p0, final RenderContext<RenderableState> p1, final List<CompatibleAttachment<? extends AttachmentContainer>> p2);
    
    protected static class StateDescriptor
    {
        protected MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>> stateManager;
        protected float rate;
        protected float amplitude;
        private PlayerGrenadeInstance instance;
        
        public StateDescriptor(final PlayerGrenadeInstance instance, final MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>> stateManager, final float rate, final float amplitude) {
            super();
            this.amplitude = 0.04f;
            this.instance = instance;
            this.stateManager = stateManager;
            this.rate = rate;
            this.amplitude = amplitude;
        }
        
        static /* synthetic */ PlayerGrenadeInstance access$000(final StateDescriptor x0) {
            return x0.instance;
        }
    }
}
