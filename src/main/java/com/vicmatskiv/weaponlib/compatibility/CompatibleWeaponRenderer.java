package com.vicmatskiv.weaponlib.compatibility;

import net.minecraftforge.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.shader.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.client.entity.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.*;

public abstract class CompatibleWeaponRenderer implements IItemRenderer
{
    private static final int INVENTORY_TEXTURE_WIDTH = 256;
    private static final int INVENTORY_TEXTURE_HEIGHT = 256;
    private WeaponRenderer.Builder builder;
    
    protected CompatibleWeaponRenderer(final WeaponRenderer.Builder builder) {
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
        int originalFramebufferId = -1;
        Framebuffer framebuffer = null;
        Integer inventoryTexture = null;
        boolean inventoryTextureInitializationPhaseOn = false;
        final Minecraft mc = Minecraft.getMinecraft();
        final ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        if (type == IItemRenderer.ItemRenderType.INVENTORY) {
            final Object textureMapKey = this;
            inventoryTexture = this.getClientModContext().getInventoryTextureMap().get(textureMapKey);
            if (inventoryTexture == null) {
                inventoryTextureInitializationPhaseOn = true;
                originalFramebufferId = Framebuffers.getCurrentFramebuffer();
                Framebuffers.unbindFramebuffer();
                framebuffer = new Framebuffer(256, 256, true);
                inventoryTexture = framebuffer.framebufferTexture;
                this.getClientModContext().getInventoryTextureMap().put(textureMapKey, inventoryTexture);
                framebuffer.bindFramebuffer(true);
                this.setupInventoryRendering(256.0, 256.0);
                GL11.glScalef(130.0f, 130.0f, 130.0f);
                if (DebugPositioner.isDebugModeEnabled()) {
                    DebugPositioner.position(Part.INVENTORY, null);
                }
                GL11.glScalef(1.0f, 1.0f, 1.0f);
                GL11.glRotatef(25.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(1.449999f, 1.399999f, 0.0f);
            }
        }
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
                positioner.randomize(stateDescriptor.rate, stateDescriptor.amplitude);
                positioner.position(Part.MAIN_ITEM, renderContext);
                if (DebugPositioner.isDebugModeEnabled()) {
                    DebugPositioner.position(Part.MAIN_ITEM, renderContext);
                }
                renderLeftArm(player, renderContext, positioner);
                renderRightArm(player, renderContext, positioner);
                break;
            }
        }
        if (type != IItemRenderer.ItemRenderType.INVENTORY || inventoryTextureInitializationPhaseOn) {
            this.renderItem(weaponItemStack, renderContext, positioner);
        }
        if (type == IItemRenderer.ItemRenderType.INVENTORY && inventoryTextureInitializationPhaseOn) {
            framebuffer.unbindFramebuffer();
            framebuffer.framebufferTexture = -1;
            framebuffer.deleteFramebuffer();
            this.restoreInventoryRendering(scaledresolution);
        }
        GL11.glPopMatrix();
        if (originalFramebufferId >= 0) {
            Framebuffers.bindFramebuffer(originalFramebufferId, true, mc.getFramebuffer().framebufferWidth, mc.getFramebuffer().framebufferHeight);
        }
        if (type == IItemRenderer.ItemRenderType.INVENTORY) {
            this.renderCachedInventoryTexture(inventoryTexture);
        }
    }
    
    private void setupInventoryRendering(final double projectionWidth, final double projectionHeight) {
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, projectionWidth, projectionHeight, 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
    }
    
    private void restoreInventoryRendering(final ScaledResolution scaledresolution) {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, scaledresolution.getScaledWidth_double(), scaledresolution.getScaledHeight_double(), 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
    }
    
    private void renderCachedInventoryTexture(final Integer inventoryTexture) {
        GL11.glPushMatrix();
        GL11.glPushAttrib(8192);
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-210.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(1.0f, 1.0f, -1.0f);
        GL11.glTranslatef(-0.8f, -0.8f, -1.0f);
        GL11.glScalef(0.006f, 0.006f, 0.006f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glAlphaFunc(516, 0.003921569f);
        GL11.glBindTexture(3553, (int)inventoryTexture);
        drawTexturedQuadFit(0.0, 0.0, 256.0, 256.0, 0.0);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }
    
    public void drawTexturedModalRect(final int x, final int y, final int u, final int v, final int width, final int height) {
        final int zLevel = 50;
        final float f = 0.00390625f;
        final float f2 = 0.00390625f;
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)zLevel, (double)((u + 0) * f), (double)((v + height) * f2));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)zLevel, (double)((u + width) * f), (double)((v + height) * f2));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)zLevel, (double)((u + width) * f), (double)((v + 0) * f2));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)zLevel, (double)((u + 0) * f), (double)((v + 0) * f2));
        tessellator.draw();
    }
    
    private static void drawTexturedQuadFit(final double x, final double y, final double width, final double height, final double zLevel) {
        final CompatibleTessellator tessellator = CompatibleTessellator.getInstance();
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0.0, y + height, zLevel, 0.0f, 1.0f);
        tessellator.addVertexWithUV(x + width, y + height, zLevel, 1.0f, 1.0f);
        tessellator.addVertexWithUV(x + width, y + 0.0, zLevel, 1.0f, 0.0f);
        tessellator.addVertexWithUV(x + 0.0, y + 0.0, zLevel, 0.0f, 0.0f);
        tessellator.draw();
    }
    
    protected abstract void renderItem(final ItemStack p0, final RenderContext<RenderableState> p1, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> p2);
    
    static void renderRightArm(final EntityPlayer player, final RenderContext<RenderableState> renderContext, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner) {
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
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        render.modelBipedMain.onGround = 0.0f;
        render.modelBipedMain.setRotationAngles(0.0f, 0.3f, 0.0f, 0.0f, 0.0f, 0.0625f, (Entity)player);
        render.modelBipedMain.bipedRightArm.render(0.0625f);
        GL11.glPopMatrix();
    }
    
    static void renderLeftArm(final EntityPlayer player, final RenderContext<RenderableState> renderContext, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner) {
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
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        render.modelBipedMain.onGround = 0.0f;
        render.modelBipedMain.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, (Entity)player);
        render.modelBipedMain.bipedLeftArm.render(0.0625f);
        GL11.glPopMatrix();
    }
    
    protected static class StateDescriptor
    {
        protected MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>> stateManager;
        protected float rate;
        protected float amplitude;
        private PlayerWeaponInstance instance;
        
        public StateDescriptor(final PlayerWeaponInstance instance, final MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>> stateManager, final float rate, final float amplitude) {
            super();
            this.amplitude = 0.04f;
            this.instance = instance;
            this.stateManager = stateManager;
            this.rate = rate;
            this.amplitude = amplitude;
        }
        
        static /* synthetic */ PlayerWeaponInstance access$000(final StateDescriptor x0) {
            return x0.instance;
        }
    }
}
