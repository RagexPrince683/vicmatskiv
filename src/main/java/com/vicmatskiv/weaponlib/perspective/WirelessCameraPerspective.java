package com.vicmatskiv.weaponlib.perspective;

import java.util.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.tracking.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.electronics.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.apache.logging.log4j.*;

public class WirelessCameraPerspective extends RemoteFirstPersonPerspective
{
    private static final Logger logger;
    private static final String STATIC_TEXTURE = "weaponlib:/com/vicmatskiv/weaponlib/resources/static.png";
    static final String DARK_SCREEN_TEXTURE = "weaponlib:/com/vicmatskiv/weaponlib/resources/dark-screen.png";
    private static final int STATIC_IMAGES_PER_ROW = 8;
    private int tickCounter;
    private int activeWatchIndex;
    private int badSignalTickCounter;
    private int imageIndex;
    private Random random;
    private int totalTrackableEntities;
    private String displayName;
    private Float batteryLevel;
    
    public WirelessCameraPerspective() {
        super();
        this.random = new Random();
    }
    
    @Override
    protected void updateWatchablePlayer() {
        final EntityPlayer entityPlayer = CompatibilityProvider.compatibility.clientPlayer();
        final PlayerItemInstance<?> instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(entityPlayer);
        if (!(instance instanceof PlayerTabletInstance)) {
            return;
        }
        final PlayerTabletInstance tabletInstance = (PlayerTabletInstance)instance;
        final PlayerEntityTracker playerEntityTracker = PlayerEntityTracker.getTracker(entityPlayer);
        if (playerEntityTracker == null) {
            return;
        }
        this.activeWatchIndex = tabletInstance.getActiveWatchIndex();
        this.totalTrackableEntities = playerEntityTracker.getTrackableEntitites().size();
        final TrackableEntity te = (this.totalTrackableEntities > 0) ? playerEntityTracker.getTrackableEntity(this.activeWatchIndex) : null;
        Entity watchableEntity = null;
        if (te == null) {
            this.displayName = "";
            this.batteryLevel = null;
        }
        else {
            this.displayName = te.getDisplayName();
            watchableEntity = te.getEntity();
            this.batteryLevel = 1.0f - (System.currentTimeMillis() - te.getStartTimestamp()) / (float)te.getTrackingDuration();
            if (this.batteryLevel > 1.0f) {
                this.batteryLevel = 1.0f;
            }
            else if (this.batteryLevel < 0.0f) {
                this.batteryLevel = 0.0f;
            }
        }
        final Entity realEntity = (watchableEntity == null) ? null : CompatibilityProvider.compatibility.world(watchableEntity).getEntityByID(watchableEntity.getEntityId());
        if (realEntity != null && realEntity != watchableEntity) {
            watchableEntity = realEntity;
        }
        if (this.tickCounter++ % 50 == 0) {
            WirelessCameraPerspective.logger.trace("Using entity tracker {}", new Object[] { playerEntityTracker });
            if (watchableEntity != null) {
                WirelessCameraPerspective.logger.debug("Watching {} with uuid {}, distance: {}  ", new Object[] { watchableEntity, watchableEntity.getUniqueID(), Math.sqrt(Math.pow(watchableEntity.posX - CompatibilityProvider.compatibility.getClientPlayer().posX, 2.0) + Math.pow(watchableEntity.posZ - CompatibilityProvider.compatibility.getClientPlayer().posZ, 2.0)) });
            }
        }
        if (watchableEntity == null || watchableEntity instanceof EntityLivingBase) {
            this.watchablePlayer.setEntityLiving((EntityLivingBase)watchableEntity);
        }
    }
    
    @Override
    protected void renderOverlay() {
        super.renderOverlay();
        final int maxDistance = 120;
        final int displayCameraIndex = this.activeWatchIndex + 1;
        String message = "Cam " + displayCameraIndex + "/" + this.totalTrackableEntities + ": " + this.displayName;
        final EntityLivingBase watchableEntity = this.watchablePlayer.getEntityLiving();
        int color = 16776960;
        if (watchableEntity != null) {
            final EntityPlayer origPlayer = CompatibilityProvider.compatibility.clientPlayer();
            final double distance = Math.pow(watchableEntity.posX - origPlayer.posX, 2.0) + Math.pow(watchableEntity.posY - origPlayer.posY, 2.0) + Math.pow(watchableEntity.posZ - origPlayer.posZ, 2.0);
            final SignalQuality quality = SignalQuality.getQuality((int)Math.sqrt(distance), maxDistance);
            if (watchableEntity.isDead || quality.isInterrupted() || (this.badSignalTickCounter > 0 && this.badSignalTickCounter < 5) || watchableEntity.isDead) {
                if (this.badSignalTickCounter == 0) {
                    this.framebuffer.framebufferClear();
                    this.framebuffer.bindFramebuffer(true);
                }
                color = 16776960;
                message = "Cam " + displayCameraIndex + "/" + this.totalTrackableEntities + ": no signal";
                this.drawStatic();
                ++this.badSignalTickCounter;
            }
            if (this.badSignalTickCounter == 5) {
                this.badSignalTickCounter = 0;
            }
        }
        else if (this.totalTrackableEntities == 0) {
            this.framebuffer.framebufferClear();
            this.framebuffer.bindFramebuffer(true);
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("weaponlib:/com/vicmatskiv/weaponlib/resources/dark-screen.png"));
            drawTexturedQuadFit(0.0, 0.0, this.width, this.height, 0.0);
            color = 16711680;
            message = "No Cameras Available";
        }
        else {
            this.framebuffer.framebufferClear();
            this.framebuffer.bindFramebuffer(true);
            message = "Cam " + displayCameraIndex + "/" + this.totalTrackableEntities + ": " + this.displayName;
            this.drawStatic();
        }
        final FontRenderer fontRender = CompatibilityProvider.compatibility.getFontRenderer();
        final float scale = 2.0f;
        GL11.glScalef(scale, scale, scale);
        fontRender.drawString(message, (int)(40.0f / scale), (int)((this.height - 30) / scale), color, false);
        if (this.totalTrackableEntities > 0 && this.batteryLevel != null) {
            fontRender.drawString("Battery: " + (int)(this.batteryLevel * 100.0f) + "%", (int)((this.width - 150.0f) / scale), (int)((this.height - 30) / scale), color, false);
        }
    }
    
    public void drawStatic() {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("weaponlib:/com/vicmatskiv/weaponlib/resources/static.png"));
        this.imageIndex = this.random.nextInt(8);
        final float uWidth = 0.125f;
        final float aU = (this.imageIndex + 1) * uWidth;
        final float aV = 1.0f;
        final float bU = (this.imageIndex + 1) * uWidth;
        final float bV = 0.0f;
        final float cU = this.imageIndex * uWidth;
        final float cV = 0.0f;
        final float dU = this.imageIndex * uWidth;
        final float dV = 1.0f;
        final double x = 0.0;
        final double y = 0.0;
        final double width = this.width;
        final double height = this.height;
        final double zLevel = 0.0;
        final CompatibleTessellator tessellator = CompatibleTessellator.getInstance();
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0.0, y + height, zLevel, aU, aV);
        tessellator.addVertexWithUV(x + width, y + height, zLevel, bU, bV);
        tessellator.addVertexWithUV(x + width, y + 0.0, zLevel, cU, cV);
        tessellator.addVertexWithUV(x + 0.0, y + 0.0, zLevel, dU, dV);
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
    
    static {
        logger = LogManager.getLogger((Class)WirelessCameraPerspective.class);
    }
}
