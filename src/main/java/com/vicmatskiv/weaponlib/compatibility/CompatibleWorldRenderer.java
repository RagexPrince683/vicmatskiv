package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import java.nio.*;
import java.io.*;
import com.google.gson.*;
import net.minecraft.client.shader.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.client.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import org.lwjgl.util.glu.*;
import net.minecraft.potion.*;
import net.minecraft.client.multiplayer.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.particle.*;
import net.minecraft.world.biome.*;
import net.minecraftforge.client.*;
import net.minecraft.enchantment.*;
import net.minecraftforge.client.event.*;
import org.lwjgl.opengl.*;
import org.apache.logging.log4j.*;

@SideOnly(Side.CLIENT)
public class CompatibleWorldRenderer extends EntityRenderer implements IResourceManagerReloadListener
{
    private static final Logger logger;
    private static final float MAX_ZOOM = 0.01f;
    private static final ResourceLocation locationRainPng;
    private static final ResourceLocation locationSnowPng;
    public static boolean anaglyphEnable;
    public static int anaglyphField;
    private Minecraft mc;
    private float farPlaneDistance;
    public final ItemRenderer itemRenderer;
    private final MapItemRenderer theMapItemRenderer;
    private int rendererUpdateCount;
    private Entity pointedEntity;
    private MouseFilter mouseFilterXAxis;
    private MouseFilter mouseFilterYAxis;
    private MouseFilter mouseFilterDummy1;
    private MouseFilter mouseFilterDummy2;
    private MouseFilter mouseFilterDummy3;
    private MouseFilter mouseFilterDummy4;
    private float thirdPersonDistance;
    private float thirdPersonDistanceTemp;
    private float debugCamYaw;
    private float prevDebugCamYaw;
    private float debugCamPitch;
    private float prevDebugCamPitch;
    private float smoothCamYaw;
    private float smoothCamPitch;
    private float smoothCamFilterX;
    private float smoothCamFilterY;
    private float smoothCamPartialTicks;
    private float debugCamFOV;
    private float prevDebugCamFOV;
    private float camRoll;
    private float prevCamRoll;
    private final DynamicTexture lightmapTexture;
    private final int[] lightmapColors;
    private final ResourceLocation locationLightMap;
    private float fovModifierHand;
    private float fovModifierHandPrev;
    private float fovMultiplierTemp;
    private float bossColorModifier;
    private float bossColorModifierPrev;
    private boolean cloudFog;
    private final IResourceManager resourceManager;
    public ShaderGroup theShaderGroup;
    private static final ResourceLocation[] shaderResourceLocations;
    public static final int shaderCount;
    private int shaderIndex;
    private double cameraZoom;
    private double cameraYaw;
    private double cameraPitch;
    private long prevFrameTime;
    private long renderEndNanoTime;
    private boolean lightmapUpdateNeeded;
    float torchFlickerX;
    float torchFlickerDX;
    float torchFlickerY;
    float torchFlickerDY;
    private Random random;
    private int rainSoundCounter;
    float[] rainXCoords;
    float[] rainYCoords;
    FloatBuffer fogColorBuffer;
    float fogColorRed;
    float fogColorGreen;
    float fogColorBlue;
    private float fogColor2;
    private float fogColor1;
    public int debugViewDirection;
    private static final String __OBFID = "CL_00000947";
    
    public CompatibleWorldRenderer(final Minecraft p_i45076_1_, final IResourceManager p_i45076_2_) {
        super(p_i45076_1_, p_i45076_2_);
        this.mouseFilterXAxis = new MouseFilter();
        this.mouseFilterYAxis = new MouseFilter();
        this.mouseFilterDummy1 = new MouseFilter();
        this.mouseFilterDummy2 = new MouseFilter();
        this.mouseFilterDummy3 = new MouseFilter();
        this.mouseFilterDummy4 = new MouseFilter();
        this.thirdPersonDistance = 4.0f;
        this.thirdPersonDistanceTemp = 4.0f;
        this.shaderIndex = CompatibleWorldRenderer.shaderCount;
        this.cameraZoom = 1.0;
        this.prevFrameTime = Minecraft.getSystemTime();
        this.random = new Random();
        this.fogColorBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.mc = p_i45076_1_;
        this.resourceManager = p_i45076_2_;
        this.theMapItemRenderer = new MapItemRenderer(p_i45076_1_.getTextureManager());
        this.itemRenderer = new ItemRenderer(p_i45076_1_);
        this.lightmapTexture = new DynamicTexture(16, 16);
        this.locationLightMap = p_i45076_1_.getTextureManager().getDynamicTextureLocation("lightMap", this.lightmapTexture);
        this.lightmapColors = this.lightmapTexture.getTextureData();
        this.theShaderGroup = null;
    }
    
    public boolean isShaderActive() {
        return OpenGlHelper.shadersSupported && this.theShaderGroup != null;
    }
    
    public void deactivateShader() {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        this.shaderIndex = CompatibleWorldRenderer.shaderCount;
    }
    
    public void activateNextShader() {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.deleteShaderGroup();
            }
            this.shaderIndex = (this.shaderIndex + 1) % (CompatibleWorldRenderer.shaderResourceLocations.length + 1);
            if (this.shaderIndex != CompatibleWorldRenderer.shaderCount) {
                try {
                    CompatibleWorldRenderer.logger.info("Selecting effect " + CompatibleWorldRenderer.shaderResourceLocations[this.shaderIndex]);
                    (this.theShaderGroup = new ShaderGroup(this.mc.getTextureManager(), this.resourceManager, this.mc.getFramebuffer(), CompatibleWorldRenderer.shaderResourceLocations[this.shaderIndex])).createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                }
                catch (final IOException ioexception) {
                    CompatibleWorldRenderer.logger.warn("Failed to load shader: " + CompatibleWorldRenderer.shaderResourceLocations[this.shaderIndex], (Throwable)ioexception);
                    this.shaderIndex = CompatibleWorldRenderer.shaderCount;
                }
                catch (final JsonSyntaxException jsonsyntaxexception) {
                    CompatibleWorldRenderer.logger.warn("Failed to load shader: " + CompatibleWorldRenderer.shaderResourceLocations[this.shaderIndex], (Throwable)jsonsyntaxexception);
                    this.shaderIndex = CompatibleWorldRenderer.shaderCount;
                }
            }
            else {
                this.theShaderGroup = null;
                CompatibleWorldRenderer.logger.info("No effect selected");
            }
        }
    }
    
    public void onResourceManagerReload(final IResourceManager p_110549_1_) {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        if (this.shaderIndex != CompatibleWorldRenderer.shaderCount) {
            try {
                (this.theShaderGroup = new ShaderGroup(this.mc.getTextureManager(), p_110549_1_, this.mc.getFramebuffer(), CompatibleWorldRenderer.shaderResourceLocations[this.shaderIndex])).createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
            }
            catch (final IOException ioexception) {
                CompatibleWorldRenderer.logger.warn("Failed to load shader: " + CompatibleWorldRenderer.shaderResourceLocations[this.shaderIndex], (Throwable)ioexception);
                this.shaderIndex = CompatibleWorldRenderer.shaderCount;
            }
        }
    }
    
    public void updateRenderer() {
        if (OpenGlHelper.shadersSupported && ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
        }
        this.updateFovModifierHand();
        this.updateTorchFlicker();
        this.fogColor2 = this.fogColor1;
        this.thirdPersonDistanceTemp = this.thirdPersonDistance;
        this.prevDebugCamYaw = this.debugCamYaw;
        this.prevDebugCamPitch = this.debugCamPitch;
        this.prevDebugCamFOV = this.debugCamFOV;
        this.prevCamRoll = this.camRoll;
        if (this.mc.gameSettings.smoothCamera) {
            final float f = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float f2 = f * f * f * 8.0f;
            this.smoothCamFilterX = this.mouseFilterXAxis.smooth(this.smoothCamYaw, 0.05f * f2);
            this.smoothCamFilterY = this.mouseFilterYAxis.smooth(this.smoothCamPitch, 0.05f * f2);
            this.smoothCamPartialTicks = 0.0f;
            this.smoothCamYaw = 0.0f;
            this.smoothCamPitch = 0.0f;
        }
        if (this.mc.renderViewEntity == null) {
            this.mc.renderViewEntity = (EntityLivingBase)this.mc.thePlayer;
        }
        final float f = this.mc.theWorld.getLightBrightness(MathHelper.floor_double(this.mc.renderViewEntity.posX), MathHelper.floor_double(this.mc.renderViewEntity.posY), MathHelper.floor_double(this.mc.renderViewEntity.posZ));
        final float f2 = this.mc.gameSettings.renderDistanceChunks / 16.0f;
        final float f3 = f * (1.0f - f2) + f2;
        this.fogColor1 += (f3 - this.fogColor1) * 0.1f;
        ++this.rendererUpdateCount;
        this.itemRenderer.updateEquippedItem();
        this.addRainParticles();
        this.bossColorModifierPrev = this.bossColorModifier;
        if (BossStatus.hasColorModifier) {
            this.bossColorModifier += 0.05f;
            if (this.bossColorModifier > 1.0f) {
                this.bossColorModifier = 1.0f;
            }
            BossStatus.hasColorModifier = false;
        }
        else if (this.bossColorModifier > 0.0f) {
            this.bossColorModifier -= 0.0125f;
        }
    }
    
    public ShaderGroup getShaderGroup() {
        return this.theShaderGroup;
    }
    
    public void updateShaderGroupSize(final int p_147704_1_, final int p_147704_2_) {
        if (OpenGlHelper.shadersSupported && this.theShaderGroup != null) {
            this.theShaderGroup.createBindFramebuffers(p_147704_1_, p_147704_2_);
        }
    }
    
    public void getMouseOver(final float p_78473_1_) {
        if (this.mc.renderViewEntity != null && this.mc.theWorld != null) {
            this.mc.pointedEntity = null;
            double d0 = this.mc.playerController.getBlockReachDistance();
            this.mc.objectMouseOver = this.mc.renderViewEntity.rayTrace(d0, p_78473_1_);
            double d2 = d0;
            final Vec3 vec3 = this.mc.renderViewEntity.getPosition(p_78473_1_);
            if (this.mc.playerController.extendedReach()) {
                d0 = 6.0;
                d2 = 6.0;
            }
            else {
                if (d0 > 3.0) {
                    d2 = 3.0;
                }
                d0 = d2;
            }
            if (this.mc.objectMouseOver != null) {
                d2 = this.mc.objectMouseOver.hitVec.distanceTo(vec3);
            }
            final Vec3 vec4 = this.mc.renderViewEntity.getLook(p_78473_1_);
            final Vec3 vec5 = vec3.addVector(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0);
            this.pointedEntity = null;
            Vec3 vec6 = null;
            final float f1 = 1.0f;
            final List list = this.mc.theWorld.getEntitiesWithinAABBExcludingEntity((Entity)this.mc.renderViewEntity, this.mc.renderViewEntity.boundingBox.addCoord(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0).expand((double)f1, (double)f1, (double)f1));
            double d3 = d2;
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity = list.get(i);
                if (entity.canBeCollidedWith()) {
                    final float f2 = entity.getCollisionBorderSize();
                    final AxisAlignedBB axisalignedbb = entity.boundingBox.expand((double)f2, (double)f2, (double)f2);
                    final MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec5);
                    if (axisalignedbb.isVecInside(vec3)) {
                        if (0.0 < d3 || d3 == 0.0) {
                            this.pointedEntity = entity;
                            vec6 = ((movingobjectposition == null) ? vec3 : movingobjectposition.hitVec);
                            d3 = 0.0;
                        }
                    }
                    else if (movingobjectposition != null) {
                        final double d4 = vec3.distanceTo(movingobjectposition.hitVec);
                        if (d4 < d3 || d3 == 0.0) {
                            if (entity == this.mc.renderViewEntity.ridingEntity && !entity.canRiderInteract()) {
                                if (d3 == 0.0) {
                                    this.pointedEntity = entity;
                                    vec6 = movingobjectposition.hitVec;
                                }
                            }
                            else {
                                this.pointedEntity = entity;
                                vec6 = movingobjectposition.hitVec;
                                d3 = d4;
                            }
                        }
                    }
                }
            }
            if (this.pointedEntity != null && (d3 < d2 || this.mc.objectMouseOver == null)) {
                this.mc.objectMouseOver = new MovingObjectPosition(this.pointedEntity, vec6);
                if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame) {
                    this.mc.pointedEntity = this.pointedEntity;
                }
            }
        }
    }
    
    private void updateFovModifierHand() {
        if (this.mc.renderViewEntity instanceof EntityPlayerSP) {
            final EntityPlayerSP entityplayersp = (EntityPlayerSP)this.mc.renderViewEntity;
            this.fovMultiplierTemp = entityplayersp.getFOVMultiplier();
        }
        else {
            this.fovMultiplierTemp = this.mc.thePlayer.getFOVMultiplier();
        }
        this.fovModifierHandPrev = this.fovModifierHand;
        this.fovModifierHand += (this.fovMultiplierTemp - this.fovModifierHand) * 0.5f;
        if (this.fovModifierHand > 1.5f) {
            this.fovModifierHand = 1.5f;
        }
        if (this.fovModifierHand < 0.01f) {
            this.fovModifierHand = 0.01f;
        }
    }
    
    private float getFOVModifier(final float p_78481_1_, final boolean p_78481_2_) {
        if (this.debugViewDirection > 0) {
            return 90.0f;
        }
        final EntityLivingBase entityplayer = this.mc.renderViewEntity;
        float f1 = 70.0f;
        if (p_78481_2_) {
            f1 = this.mc.gameSettings.fovSetting;
            f1 *= this.fovModifierHandPrev + (this.fovModifierHand - this.fovModifierHandPrev) * p_78481_1_;
        }
        if (entityplayer.getHealth() <= 0.0f) {
            final float f2 = entityplayer.deathTime + p_78481_1_;
            f1 /= (1.0f - 500.0f / (f2 + 500.0f)) * 2.0f + 1.0f;
        }
        final Block block = ActiveRenderInfo.getBlockAtEntityViewpoint((World)this.mc.theWorld, entityplayer, p_78481_1_);
        if (block.getMaterial() == Material.water) {
            f1 = f1 * 60.0f / 70.0f;
        }
        return f1 + this.prevDebugCamFOV + (this.debugCamFOV - this.prevDebugCamFOV) * p_78481_1_;
    }
    
    private void hurtCameraEffect(final float p_78482_1_) {
        final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
        float f1 = entitylivingbase.hurtTime - p_78482_1_;
        if (entitylivingbase.getHealth() <= 0.0f) {
            final float f2 = entitylivingbase.deathTime + p_78482_1_;
            GL11.glRotatef(40.0f - 8000.0f / (f2 + 200.0f), 0.0f, 0.0f, 1.0f);
        }
        if (f1 >= 0.0f) {
            f1 /= entitylivingbase.maxHurtTime;
            f1 = MathHelper.sin(f1 * f1 * f1 * f1 * 3.1415927f);
            final float f2 = entitylivingbase.attackedAtYaw;
            GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f1 * 14.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        }
    }
    
    private void setupViewBobbing(final float p_78475_1_) {
        if (this.mc.renderViewEntity instanceof EntityPlayer) {
            final EntityPlayer entityplayer = (EntityPlayer)this.mc.renderViewEntity;
            final float f1 = entityplayer.distanceWalkedModified - entityplayer.prevDistanceWalkedModified;
            final float f2 = -(entityplayer.distanceWalkedModified + f1 * p_78475_1_);
            final float f3 = entityplayer.prevCameraYaw + (entityplayer.cameraYaw - entityplayer.prevCameraYaw) * p_78475_1_;
            final float f4 = entityplayer.prevCameraPitch + (entityplayer.cameraPitch - entityplayer.prevCameraPitch) * p_78475_1_;
            GL11.glTranslatef(MathHelper.sin(f2 * 3.1415927f) * f3 * 0.5f, -Math.abs(MathHelper.cos(f2 * 3.1415927f) * f3), 0.0f);
            GL11.glRotatef(MathHelper.sin(f2 * 3.1415927f) * f3 * 3.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(Math.abs(MathHelper.cos(f2 * 3.1415927f - 0.2f) * f3) * 5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(f4, 1.0f, 0.0f, 0.0f);
        }
    }
    
    private void orientCamera(final float p_78467_1_) {
        final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
        float f1 = entitylivingbase.yOffset - 1.62f;
        double d0 = entitylivingbase.prevPosX + (entitylivingbase.posX - entitylivingbase.prevPosX) * p_78467_1_;
        double d2 = entitylivingbase.prevPosY + (entitylivingbase.posY - entitylivingbase.prevPosY) * p_78467_1_ - f1;
        double d3 = entitylivingbase.prevPosZ + (entitylivingbase.posZ - entitylivingbase.prevPosZ) * p_78467_1_;
        GL11.glRotatef(this.prevCamRoll + (this.camRoll - this.prevCamRoll) * p_78467_1_, 0.0f, 0.0f, 1.0f);
        if (entitylivingbase.isPlayerSleeping()) {
            ++f1;
            GL11.glTranslatef(0.0f, 0.3f, 0.0f);
            if (!this.mc.gameSettings.debugCamEnable) {
                ForgeHooksClient.orientBedCamera(this.mc, entitylivingbase);
                GL11.glRotatef(entitylivingbase.prevRotationYaw + (entitylivingbase.rotationYaw - entitylivingbase.prevRotationYaw) * p_78467_1_ + 180.0f, 0.0f, -1.0f, 0.0f);
                GL11.glRotatef(entitylivingbase.prevRotationPitch + (entitylivingbase.rotationPitch - entitylivingbase.prevRotationPitch) * p_78467_1_, -1.0f, 0.0f, 0.0f);
            }
        }
        else if (this.mc.gameSettings.thirdPersonView > 0) {
            double d4 = this.thirdPersonDistanceTemp + (this.thirdPersonDistance - this.thirdPersonDistanceTemp) * p_78467_1_;
            if (this.mc.gameSettings.debugCamEnable) {
                final float f2 = this.prevDebugCamYaw + (this.debugCamYaw - this.prevDebugCamYaw) * p_78467_1_;
                final float f3 = this.prevDebugCamPitch + (this.debugCamPitch - this.prevDebugCamPitch) * p_78467_1_;
                GL11.glTranslatef(0.0f, 0.0f, (float)(-d4));
                GL11.glRotatef(f3, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
            }
            else {
                final float f2 = entitylivingbase.rotationYaw;
                float f3 = entitylivingbase.rotationPitch;
                if (this.mc.gameSettings.thirdPersonView == 2) {
                    f3 += 180.0f;
                }
                final double d5 = -MathHelper.sin(f2 / 180.0f * 3.1415927f) * MathHelper.cos(f3 / 180.0f * 3.1415927f) * d4;
                final double d6 = MathHelper.cos(f2 / 180.0f * 3.1415927f) * MathHelper.cos(f3 / 180.0f * 3.1415927f) * d4;
                final double d7 = -MathHelper.sin(f3 / 180.0f * 3.1415927f) * d4;
                for (int k = 0; k < 8; ++k) {
                    float f4 = (float)((k & 0x1) * 2 - 1);
                    float f5 = (float)((k >> 1 & 0x1) * 2 - 1);
                    float f6 = (float)((k >> 2 & 0x1) * 2 - 1);
                    f4 *= 0.1f;
                    f5 *= 0.1f;
                    f6 *= 0.1f;
                    final MovingObjectPosition movingobjectposition = this.mc.theWorld.rayTraceBlocks(Vec3.createVectorHelper(d0 + f4, d2 + f5, d3 + f6), Vec3.createVectorHelper(d0 - d5 + f4 + f6, d2 - d7 + f5, d3 - d6 + f6));
                    if (movingobjectposition != null) {
                        final double d8 = movingobjectposition.hitVec.distanceTo(Vec3.createVectorHelper(d0, d2, d3));
                        if (d8 < d4) {
                            d4 = d8;
                        }
                    }
                }
                if (this.mc.gameSettings.thirdPersonView == 2) {
                    GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                }
                GL11.glRotatef(entitylivingbase.rotationPitch - f3, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(entitylivingbase.rotationYaw - f2, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.0f, 0.0f, (float)(-d4));
                GL11.glRotatef(f2 - entitylivingbase.rotationYaw, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(f3 - entitylivingbase.rotationPitch, 1.0f, 0.0f, 0.0f);
            }
        }
        else {
            GL11.glTranslatef(0.0f, 0.0f, -0.1f);
        }
        if (!this.mc.gameSettings.debugCamEnable) {
            GL11.glRotatef(entitylivingbase.prevRotationPitch + (entitylivingbase.rotationPitch - entitylivingbase.prevRotationPitch) * p_78467_1_, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(entitylivingbase.prevRotationYaw + (entitylivingbase.rotationYaw - entitylivingbase.prevRotationYaw) * p_78467_1_ + 180.0f, 0.0f, 1.0f, 0.0f);
        }
        GL11.glTranslatef(0.0f, f1, 0.0f);
        d0 = entitylivingbase.prevPosX + (entitylivingbase.posX - entitylivingbase.prevPosX) * p_78467_1_;
        d2 = entitylivingbase.prevPosY + (entitylivingbase.posY - entitylivingbase.prevPosY) * p_78467_1_ - f1;
        d3 = entitylivingbase.prevPosZ + (entitylivingbase.posZ - entitylivingbase.prevPosZ) * p_78467_1_;
        this.cloudFog = this.mc.renderGlobal.hasCloudFog(d0, d2, d3, p_78467_1_);
    }
    
    private void setupCameraTransform(final float p_78479_1_, final int p_78479_2_) {
        this.farPlaneDistance = (float)(this.mc.gameSettings.renderDistanceChunks * 16);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        final float f1 = 0.07f;
        if (this.mc.gameSettings.anaglyph) {
            GL11.glTranslatef(-(p_78479_2_ * 2 - 1) * f1, 0.0f, 0.0f);
        }
        if (this.cameraZoom != 1.0) {
            GL11.glTranslatef((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0f);
            GL11.glScaled(this.cameraZoom, this.cameraZoom, 1.0);
        }
        Project.gluPerspective(this.getFOVModifier(p_78479_1_, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.farPlaneDistance * 2.0f);
        if (this.mc.playerController.enableEverythingIsScrewedUpMode()) {
            final float f2 = 0.6666667f;
            GL11.glScalef(1.0f, f2, 1.0f);
        }
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        if (this.mc.gameSettings.anaglyph) {
            GL11.glTranslatef((p_78479_2_ * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.hurtCameraEffect(p_78479_1_);
        if (this.mc.gameSettings.viewBobbing) {
            this.setupViewBobbing(p_78479_1_);
        }
        final float f2 = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * p_78479_1_;
        if (f2 > 0.0f) {
            byte b0 = 20;
            if (this.mc.thePlayer.isPotionActive(Potion.confusion)) {
                b0 = 7;
            }
            float f3 = 5.0f / (f2 * f2 + 5.0f) - f2 * 0.04f;
            f3 *= f3;
            GL11.glRotatef((this.rendererUpdateCount + p_78479_1_) * b0, 0.0f, 1.0f, 1.0f);
            GL11.glScalef(1.0f / f3, 1.0f, 1.0f);
            GL11.glRotatef(-(this.rendererUpdateCount + p_78479_1_) * b0, 0.0f, 1.0f, 1.0f);
        }
        this.orientCamera(p_78479_1_);
        if (this.debugViewDirection > 0) {
            final int j = this.debugViewDirection - 1;
            if (j == 1) {
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            }
            if (j == 2) {
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            }
            if (j == 3) {
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            }
            if (j == 4) {
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            }
            if (j == 5) {
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            }
        }
    }
    
    private void renderHand(final float p_78476_1_, final int p_78476_2_) {
        if (this.debugViewDirection <= 0) {
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            final float f1 = 0.07f;
            if (this.mc.gameSettings.anaglyph) {
                GL11.glTranslatef(-(p_78476_2_ * 2 - 1) * f1, 0.0f, 0.0f);
            }
            if (this.cameraZoom != 1.0) {
                GL11.glTranslatef((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0f);
                GL11.glScaled(this.cameraZoom, this.cameraZoom, 1.0);
            }
            Project.gluPerspective(this.getFOVModifier(p_78476_1_, false), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.farPlaneDistance * 2.0f);
            if (this.mc.playerController.enableEverythingIsScrewedUpMode()) {
                final float f2 = 0.6666667f;
                GL11.glScalef(1.0f, f2, 1.0f);
            }
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            if (this.mc.gameSettings.anaglyph) {
                GL11.glTranslatef((p_78476_2_ * 2 - 1) * 0.1f, 0.0f, 0.0f);
            }
            GL11.glPushMatrix();
            this.hurtCameraEffect(p_78476_1_);
            if (this.mc.gameSettings.viewBobbing) {
                this.setupViewBobbing(p_78476_1_);
            }
            if (this.mc.gameSettings.thirdPersonView == 0 && !this.mc.renderViewEntity.isPlayerSleeping() && !this.mc.gameSettings.hideGUI && !this.mc.playerController.enableEverythingIsScrewedUpMode()) {
                this.enableLightmap(p_78476_1_);
                this.itemRenderer.renderItemInFirstPerson(p_78476_1_);
                this.disableLightmap(p_78476_1_);
            }
            GL11.glPopMatrix();
            if (this.mc.gameSettings.thirdPersonView == 0 && !this.mc.renderViewEntity.isPlayerSleeping()) {
                this.itemRenderer.renderOverlays(p_78476_1_);
                this.hurtCameraEffect(p_78476_1_);
            }
            if (this.mc.gameSettings.viewBobbing) {
                this.setupViewBobbing(p_78476_1_);
            }
        }
    }
    
    public void disableLightmap(final double p_78483_1_) {
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(3553);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    public void enableLightmap(final double p_78463_1_) {
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glMatrixMode(5890);
        GL11.glLoadIdentity();
        final float f = 0.00390625f;
        GL11.glScalef(f, f, f);
        GL11.glTranslatef(8.0f, 8.0f, 8.0f);
        GL11.glMatrixMode(5888);
        this.mc.getTextureManager().bindTexture(this.locationLightMap);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 10496);
        GL11.glTexParameteri(3553, 10243, 10496);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3553);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    private void updateTorchFlicker() {
        this.torchFlickerDX += (float)((Math.random() - Math.random()) * Math.random() * Math.random());
        this.torchFlickerDY += (float)((Math.random() - Math.random()) * Math.random() * Math.random());
        this.torchFlickerDX *= (float)0.9;
        this.torchFlickerDY *= (float)0.9;
        this.torchFlickerX += (this.torchFlickerDX - this.torchFlickerX) * 1.0f;
        this.torchFlickerY += (this.torchFlickerDY - this.torchFlickerY) * 1.0f;
        this.lightmapUpdateNeeded = true;
    }
    
    void updateLightmap(final float p_78472_1_) {
        final WorldClient worldclient = this.mc.theWorld;
        if (worldclient != null) {
            for (int i = 0; i < 256; ++i) {
                final float f1 = worldclient.getSunBrightness(1.0f) * 0.95f + 0.05f;
                float f2 = worldclient.provider.lightBrightnessTable[i / 16] * f1;
                final float f3 = worldclient.provider.lightBrightnessTable[i % 16] * (this.torchFlickerX * 0.1f + 1.5f);
                if (worldclient.lastLightningBolt > 0) {
                    f2 = worldclient.provider.lightBrightnessTable[i / 16];
                }
                final float f4 = f2 * (worldclient.getSunBrightness(1.0f) * 0.65f + 0.35f);
                final float f5 = f2 * (worldclient.getSunBrightness(1.0f) * 0.65f + 0.35f);
                final float f6 = f3 * ((f3 * 0.6f + 0.4f) * 0.6f + 0.4f);
                final float f7 = f3 * (f3 * f3 * 0.6f + 0.4f);
                float f8 = f4 + f3;
                float f9 = f5 + f6;
                float f10 = f2 + f7;
                f8 = f8 * 0.96f + 0.03f;
                f9 = f9 * 0.96f + 0.03f;
                f10 = f10 * 0.96f + 0.03f;
                if (this.bossColorModifier > 0.0f) {
                    final float f11 = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * p_78472_1_;
                    f8 = f8 * (1.0f - f11) + f8 * 0.7f * f11;
                    f9 = f9 * (1.0f - f11) + f9 * 0.6f * f11;
                    f10 = f10 * (1.0f - f11) + f10 * 0.6f * f11;
                }
                if (worldclient.provider.dimensionId == 1) {
                    f8 = 0.22f + f3 * 0.75f;
                    f9 = 0.28f + f6 * 0.75f;
                    f10 = 0.25f + f7 * 0.75f;
                }
                if (this.mc.thePlayer.isPotionActive(Potion.nightVision)) {
                    final float f11 = this.getNightVisionBrightness((EntityPlayer)this.mc.thePlayer, p_78472_1_);
                    float f12 = 1.0f / f8;
                    if (f12 > 1.0f / f9) {
                        f12 = 1.0f / f9;
                    }
                    if (f12 > 1.0f / f10) {
                        f12 = 1.0f / f10;
                    }
                    f8 = f8 * (1.0f - f11) + f8 * f12 * f11;
                    f9 = f9 * (1.0f - f11) + f9 * f12 * f11;
                    f10 = f10 * (1.0f - f11) + f10 * f12 * f11;
                }
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (f9 > 1.0f) {
                    f9 = 1.0f;
                }
                if (f10 > 1.0f) {
                    f10 = 1.0f;
                }
                final float f11 = this.mc.gameSettings.gammaSetting;
                float f12 = 1.0f - f8;
                float f13 = 1.0f - f9;
                float f14 = 1.0f - f10;
                f12 = 1.0f - f12 * f12 * f12 * f12;
                f13 = 1.0f - f13 * f13 * f13 * f13;
                f14 = 1.0f - f14 * f14 * f14 * f14;
                f8 = f8 * (1.0f - f11) + f12 * f11;
                f9 = f9 * (1.0f - f11) + f13 * f11;
                f10 = f10 * (1.0f - f11) + f14 * f11;
                f8 = f8 * 0.96f + 0.03f;
                f9 = f9 * 0.96f + 0.03f;
                f10 = f10 * 0.96f + 0.03f;
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (f9 > 1.0f) {
                    f9 = 1.0f;
                }
                if (f10 > 1.0f) {
                    f10 = 1.0f;
                }
                if (f8 < 0.0f) {
                    f8 = 0.0f;
                }
                if (f9 < 0.0f) {
                    f9 = 0.0f;
                }
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                final short short1 = 255;
                final int j = (int)(f8 * 255.0f);
                final int k = (int)(f9 * 255.0f);
                final int l = (int)(f10 * 255.0f);
                this.lightmapColors[i] = (short1 << 24 | j << 16 | k << 8 | l);
            }
            this.lightmapTexture.updateDynamicTexture();
            this.lightmapUpdateNeeded = false;
        }
    }
    
    private float getNightVisionBrightness(final EntityPlayer p_82830_1_, final float p_82830_2_) {
        final int i = p_82830_1_.getActivePotionEffect(Potion.nightVision).getDuration();
        return (i > 200) ? 1.0f : (0.7f + MathHelper.sin((i - p_82830_2_) * 3.1415927f * 0.2f) * 0.3f);
    }
    
    public void updateCameraAndRender(final float p_78480_1_) {
        this.mc.mcProfiler.startSection("lightTex");
        if (this.lightmapUpdateNeeded) {
            this.updateLightmap(p_78480_1_);
        }
        this.mc.mcProfiler.endSection();
        final boolean flag = Display.isActive();
        if (!flag && this.mc.gameSettings.pauseOnLostFocus && (!this.mc.gameSettings.touchscreen || !Mouse.isButtonDown(1))) {
            if (Minecraft.getSystemTime() - this.prevFrameTime > 500L) {
                this.mc.displayInGameMenu();
            }
        }
        else {
            this.prevFrameTime = Minecraft.getSystemTime();
        }
        this.mc.mcProfiler.startSection("mouse");
        if (this.mc.inGameHasFocus && flag) {
            this.mc.mouseHelper.mouseXYChange();
            final float f1 = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float f2 = f1 * f1 * f1 * 8.0f;
            float f3 = this.mc.mouseHelper.deltaX * f2;
            float f4 = this.mc.mouseHelper.deltaY * f2;
            byte b0 = 1;
            if (this.mc.gameSettings.invertMouse) {
                b0 = -1;
            }
            if (this.mc.gameSettings.smoothCamera) {
                this.smoothCamYaw += f3;
                this.smoothCamPitch += f4;
                final float f5 = p_78480_1_ - this.smoothCamPartialTicks;
                this.smoothCamPartialTicks = p_78480_1_;
                f3 = this.smoothCamFilterX * f5;
                f4 = this.smoothCamFilterY * f5;
                this.mc.thePlayer.setAngles(f3, f4 * b0);
            }
            else {
                this.mc.thePlayer.setAngles(f3, f4 * b0);
            }
        }
        this.mc.mcProfiler.endSection();
        if (!this.mc.skipRenderWorld) {
            CompatibleWorldRenderer.anaglyphEnable = this.mc.gameSettings.anaglyph;
            final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int i = scaledresolution.getScaledWidth();
            final int j = scaledresolution.getScaledHeight();
            final int k = Mouse.getX() * i / this.mc.displayWidth;
            final int l = j - Mouse.getY() * j / this.mc.displayHeight - 1;
            final int i2 = this.mc.gameSettings.limitFramerate;
            if (this.mc.theWorld != null) {
                this.mc.mcProfiler.startSection("level");
                if (this.mc.isFramerateLimitBelowMax()) {
                    this.renderWorld(p_78480_1_, this.renderEndNanoTime + 1000000000 / i2);
                }
                else {
                    this.renderWorld(p_78480_1_, 0L);
                }
                if (OpenGlHelper.shadersSupported) {
                    if (this.theShaderGroup != null) {
                        GL11.glMatrixMode(5890);
                        GL11.glPushMatrix();
                        GL11.glLoadIdentity();
                        this.theShaderGroup.loadShaderGroup(p_78480_1_);
                        GL11.glPopMatrix();
                    }
                    this.mc.getFramebuffer().bindFramebuffer(true);
                }
                this.renderEndNanoTime = System.nanoTime();
                this.mc.mcProfiler.endStartSection("gui");
                if (!this.mc.gameSettings.hideGUI || this.mc.currentScreen != null) {
                    GL11.glAlphaFunc(516, 0.1f);
                    this.mc.ingameGUI.renderGameOverlay(p_78480_1_, this.mc.currentScreen != null, k, l);
                }
                this.mc.mcProfiler.endSection();
            }
            else {
                GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
                GL11.glMatrixMode(5889);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glLoadIdentity();
                this.setupOverlayRendering();
                this.renderEndNanoTime = System.nanoTime();
            }
            if (this.mc.currentScreen != null) {
                GL11.glClear(256);
                try {
                    if (!MinecraftForge.EVENT_BUS.post((Event)new GuiScreenEvent.DrawScreenEvent.Pre(this.mc.currentScreen, k, l, p_78480_1_))) {
                        this.mc.currentScreen.drawScreen(k, l, p_78480_1_);
                    }
                    MinecraftForge.EVENT_BUS.post((Event)new GuiScreenEvent.DrawScreenEvent.Post(this.mc.currentScreen, k, l, p_78480_1_));
                }
                catch (final Throwable throwable) {
                    final CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Rendering screen");
                    final CrashReportCategory crashreportcategory = crashreport.makeCategory("Screen render details");
                    crashreportcategory.addCrashSectionCallable("Screen name", (Callable)new Callable() {
                        private static final String __OBFID = "CL_00000948";
                        final /* synthetic */ CompatibleWorldRenderer this$0;
                        
                        CompatibleWorldRenderer$1() {
                            this.this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public String call() {
                            return this.this$0.mc.currentScreen.getClass().getCanonicalName();
                        }
                        
                        @Override
                        public /* bridge */ Object call() throws Exception {
                            return this.call();
                        }
                    });
                    crashreportcategory.addCrashSectionCallable("Mouse location", (Callable)new Callable() {
                        private static final String __OBFID = "CL_00000950";
                        final /* synthetic */ int val$k;
                        final /* synthetic */ int val$l;
                        final /* synthetic */ CompatibleWorldRenderer this$0;
                        
                        CompatibleWorldRenderer$2() {
                            this.this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public String call() {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", k, l, Mouse.getX(), Mouse.getY());
                        }
                        
                        @Override
                        public /* bridge */ Object call() throws Exception {
                            return this.call();
                        }
                    });
                    crashreportcategory.addCrashSectionCallable("Screen size", (Callable)new Callable() {
                        private static final String __OBFID = "CL_00000951";
                        final /* synthetic */ ScaledResolution val$scaledresolution;
                        final /* synthetic */ CompatibleWorldRenderer this$0;
                        
                        CompatibleWorldRenderer$3() {
                            this.this$0 = this$0;
                            super();
                        }
                        
                        @Override
                        public String call() {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight(), this.this$0.mc.displayWidth, this.this$0.mc.displayHeight, scaledresolution.getScaleFactor());
                        }
                        
                        @Override
                        public /* bridge */ Object call() throws Exception {
                            return this.call();
                        }
                    });
                    throw new ReportedException(crashreport);
                }
            }
        }
    }
    
    public void func_152430_c(final float p_152430_1_) {
        this.setupOverlayRendering();
        final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int i = scaledresolution.getScaledWidth();
        final int j = scaledresolution.getScaledHeight();
        this.mc.ingameGUI.func_152126_a((float)i, (float)j);
    }
    
    public void renderWorld(final float p_78471_1_, final long p_78471_2_) {
        this.mc.mcProfiler.startSection("lightTex");
        if (this.lightmapUpdateNeeded) {
            this.updateLightmap(p_78471_1_);
        }
        GL11.glEnable(2884);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.5f);
        if (this.mc.renderViewEntity == null) {
            this.mc.renderViewEntity = (EntityLivingBase)this.mc.thePlayer;
        }
        this.mc.mcProfiler.endStartSection("pick");
        this.getMouseOver(p_78471_1_);
        final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
        final RenderGlobal renderglobal = this.mc.renderGlobal;
        final EffectRenderer effectrenderer = this.mc.effectRenderer;
        final double d0 = entitylivingbase.lastTickPosX + (entitylivingbase.posX - entitylivingbase.lastTickPosX) * p_78471_1_;
        final double d2 = entitylivingbase.lastTickPosY + (entitylivingbase.posY - entitylivingbase.lastTickPosY) * p_78471_1_;
        final double d3 = entitylivingbase.lastTickPosZ + (entitylivingbase.posZ - entitylivingbase.lastTickPosZ) * p_78471_1_;
        this.mc.mcProfiler.endStartSection("center");
        for (int j = 0; j < 2; ++j) {
            if (this.mc.gameSettings.anaglyph) {
                CompatibleWorldRenderer.anaglyphField = j;
                if (CompatibleWorldRenderer.anaglyphField == 0) {
                    GL11.glColorMask(false, true, true, false);
                }
                else {
                    GL11.glColorMask(true, false, false, false);
                }
            }
            this.mc.mcProfiler.endStartSection("clear");
            final int width = 150;
            final int height = 100 * this.mc.displayHeight / this.mc.displayWidth;
            GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
            this.updateFogColor(p_78471_1_);
            GL11.glClear(16640);
            GL11.glEnable(2884);
            this.mc.mcProfiler.endStartSection("camera");
            this.setupCameraTransform(p_78471_1_, j);
            ActiveRenderInfo.updateRenderInfo((EntityPlayer)this.mc.thePlayer, this.mc.gameSettings.thirdPersonView == 2);
            this.mc.mcProfiler.endStartSection("frustrum");
            ClippingHelperImpl.getInstance();
            if (this.mc.gameSettings.renderDistanceChunks >= 4) {
                this.setupFog(-1, p_78471_1_);
                this.mc.mcProfiler.endStartSection("sky");
                renderglobal.renderSky(p_78471_1_);
            }
            GL11.glEnable(2912);
            this.setupFog(1, p_78471_1_);
            if (this.mc.gameSettings.ambientOcclusion != 0) {
                GL11.glShadeModel(7425);
            }
            this.mc.mcProfiler.endStartSection("culling");
            final Frustrum frustrum = new Frustrum();
            frustrum.setPosition(d0, d2, d3);
            this.mc.renderGlobal.clipRenderersByFrustum((ICamera)frustrum, p_78471_1_);
            if (j == 0) {
                this.mc.mcProfiler.endStartSection("updatechunks");
                while (!this.mc.renderGlobal.updateRenderers(entitylivingbase, false) && p_78471_2_ != 0L) {
                    final long k = p_78471_2_ - System.nanoTime();
                    if (k < 0L) {
                        break;
                    }
                    if (k > 1000000000L) {
                        break;
                    }
                }
            }
            if (entitylivingbase.posY < 128.0) {
                this.renderCloudsCheck(renderglobal, p_78471_1_);
            }
            this.mc.mcProfiler.endStartSection("prepareterrain");
            this.setupFog(0, p_78471_1_);
            GL11.glEnable(2912);
            this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            RenderHelper.disableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("terrain");
            GL11.glMatrixMode(5888);
            GL11.glPushMatrix();
            renderglobal.sortAndRender(entitylivingbase, 0, (double)p_78471_1_);
            GL11.glShadeModel(7424);
            GL11.glAlphaFunc(516, 0.1f);
            if (this.debugViewDirection == 0) {
                GL11.glMatrixMode(5888);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                RenderHelper.enableStandardItemLighting();
                this.mc.mcProfiler.endStartSection("entities");
                ForgeHooksClient.setRenderPass(0);
                renderglobal.renderEntities(entitylivingbase, (ICamera)frustrum, p_78471_1_);
                ForgeHooksClient.setRenderPass(0);
                RenderHelper.disableStandardItemLighting();
                this.disableLightmap(p_78471_1_);
                GL11.glMatrixMode(5888);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                if (this.mc.objectMouseOver != null && entitylivingbase.isInsideOfMaterial(Material.water) && entitylivingbase instanceof EntityPlayer && !this.mc.gameSettings.hideGUI) {
                    final EntityPlayer entityplayer = (EntityPlayer)entitylivingbase;
                    GL11.glDisable(3008);
                    this.mc.mcProfiler.endStartSection("outline");
                    if (!ForgeHooksClient.onDrawBlockHighlight(renderglobal, entityplayer, this.mc.objectMouseOver, 0, entityplayer.inventory.getCurrentItem(), p_78471_1_)) {
                        renderglobal.drawSelectionBox(entityplayer, this.mc.objectMouseOver, 0, p_78471_1_);
                    }
                    GL11.glEnable(3008);
                }
            }
            GL11.glMatrixMode(5888);
            GL11.glPopMatrix();
            if (this.cameraZoom == 1.0 && entitylivingbase instanceof EntityPlayer && !this.mc.gameSettings.hideGUI && this.mc.objectMouseOver != null && !entitylivingbase.isInsideOfMaterial(Material.water)) {
                final EntityPlayer entityplayer = (EntityPlayer)entitylivingbase;
                GL11.glDisable(3008);
                this.mc.mcProfiler.endStartSection("outline");
                if (!ForgeHooksClient.onDrawBlockHighlight(renderglobal, entityplayer, this.mc.objectMouseOver, 0, entityplayer.inventory.getCurrentItem(), p_78471_1_)) {
                    renderglobal.drawSelectionBox(entityplayer, this.mc.objectMouseOver, 0, p_78471_1_);
                }
                GL11.glEnable(3008);
            }
            this.mc.mcProfiler.endStartSection("destroyProgress");
            GL11.glEnable(3042);
            OpenGlHelper.glBlendFunc(770, 1, 1, 0);
            renderglobal.drawBlockDamageTexture(Tessellator.instance, entitylivingbase, p_78471_1_);
            GL11.glDisable(3042);
            if (this.debugViewDirection == 0) {
                this.enableLightmap(p_78471_1_);
                this.mc.mcProfiler.endStartSection("litParticles");
                effectrenderer.renderLitParticles((Entity)entitylivingbase, p_78471_1_);
                RenderHelper.disableStandardItemLighting();
                this.setupFog(0, p_78471_1_);
                this.mc.mcProfiler.endStartSection("particles");
                effectrenderer.renderParticles((Entity)entitylivingbase, p_78471_1_);
                this.disableLightmap(p_78471_1_);
            }
            GL11.glDepthMask(false);
            GL11.glEnable(2884);
            this.mc.mcProfiler.endStartSection("weather");
            this.renderRainSnow(p_78471_1_);
            GL11.glDepthMask(true);
            GL11.glDisable(3042);
            GL11.glEnable(2884);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glAlphaFunc(516, 0.1f);
            this.setupFog(0, p_78471_1_);
            GL11.glEnable(3042);
            GL11.glDepthMask(false);
            this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            if (this.mc.gameSettings.fancyGraphics) {
                this.mc.mcProfiler.endStartSection("water");
                if (this.mc.gameSettings.ambientOcclusion != 0) {
                    GL11.glShadeModel(7425);
                }
                GL11.glEnable(3042);
                OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                if (this.mc.gameSettings.anaglyph) {
                    if (CompatibleWorldRenderer.anaglyphField == 0) {
                        GL11.glColorMask(false, true, true, true);
                    }
                    else {
                        GL11.glColorMask(true, false, false, true);
                    }
                    renderglobal.sortAndRender(entitylivingbase, 1, (double)p_78471_1_);
                }
                else {
                    renderglobal.sortAndRender(entitylivingbase, 1, (double)p_78471_1_);
                }
                GL11.glDisable(3042);
                GL11.glShadeModel(7424);
            }
            else {
                this.mc.mcProfiler.endStartSection("water");
                renderglobal.sortAndRender(entitylivingbase, 1, (double)p_78471_1_);
            }
            if (this.debugViewDirection == 0) {
                RenderHelper.enableStandardItemLighting();
                this.mc.mcProfiler.endStartSection("entities");
                ForgeHooksClient.setRenderPass(1);
                renderglobal.renderEntities(entitylivingbase, (ICamera)frustrum, p_78471_1_);
                ForgeHooksClient.setRenderPass(-1);
                RenderHelper.disableStandardItemLighting();
            }
            GL11.glDepthMask(true);
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GL11.glDisable(2912);
            if (entitylivingbase.posY >= 128.0) {
                this.mc.mcProfiler.endStartSection("aboveClouds");
                this.renderCloudsCheck(renderglobal, p_78471_1_);
            }
            this.mc.mcProfiler.endStartSection("FRenderLast");
            ForgeHooksClient.dispatchRenderLast(renderglobal, p_78471_1_);
            this.mc.mcProfiler.endStartSection("hand");
            if (!this.mc.gameSettings.anaglyph) {
                this.mc.mcProfiler.endSection();
                return;
            }
        }
        GL11.glColorMask(true, true, true, false);
        this.mc.mcProfiler.endSection();
    }
    
    private void renderCloudsCheck(final RenderGlobal p_82829_1_, final float p_82829_2_) {
        if (this.mc.gameSettings.shouldRenderClouds()) {
            this.mc.mcProfiler.endStartSection("clouds");
            GL11.glPushMatrix();
            this.setupFog(0, p_82829_2_);
            GL11.glEnable(2912);
            p_82829_1_.renderClouds(p_82829_2_);
            GL11.glDisable(2912);
            this.setupFog(1, p_82829_2_);
            GL11.glPopMatrix();
        }
    }
    
    private void addRainParticles() {
        float f = this.mc.theWorld.getRainStrength(1.0f);
        if (!this.mc.gameSettings.fancyGraphics) {
            f /= 2.0f;
        }
        if (f != 0.0f) {
            this.random.setSeed(this.rendererUpdateCount * 312987231L);
            final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
            final WorldClient worldclient = this.mc.theWorld;
            final int i = MathHelper.floor_double(entitylivingbase.posX);
            final int j = MathHelper.floor_double(entitylivingbase.posY);
            final int k = MathHelper.floor_double(entitylivingbase.posZ);
            final byte b0 = 10;
            double d0 = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            int l = 0;
            int i2 = (int)(100.0f * f * f);
            if (this.mc.gameSettings.particleSetting == 1) {
                i2 >>= 1;
            }
            else if (this.mc.gameSettings.particleSetting == 2) {
                i2 = 0;
            }
            for (int j2 = 0; j2 < i2; ++j2) {
                final int k2 = i + this.random.nextInt(b0) - this.random.nextInt(b0);
                final int l2 = k + this.random.nextInt(b0) - this.random.nextInt(b0);
                final int i3 = worldclient.getPrecipitationHeight(k2, l2);
                final Block block = worldclient.getBlock(k2, i3 - 1, l2);
                final BiomeGenBase biomegenbase = worldclient.getBiomeGenForCoords(k2, l2);
                if (i3 <= j + b0 && i3 >= j - b0 && biomegenbase.canSpawnLightningBolt() && biomegenbase.getFloatTemperature(k2, i3, l2) >= 0.15f) {
                    final float f2 = this.random.nextFloat();
                    final float f3 = this.random.nextFloat();
                    if (block.getMaterial() == Material.lava) {
                        this.mc.effectRenderer.addEffect((EntityFX)new EntitySmokeFX((World)worldclient, (double)(k2 + f2), i3 + 0.1f - block.getBlockBoundsMinY(), (double)(l2 + f3), 0.0, 0.0, 0.0));
                    }
                    else if (block.getMaterial() != Material.air) {
                        ++l;
                        if (this.random.nextInt(l) == 0) {
                            d0 = k2 + f2;
                            d2 = i3 + 0.1f - block.getBlockBoundsMinY();
                            d3 = l2 + f3;
                        }
                        this.mc.effectRenderer.addEffect((EntityFX)new EntityRainFX((World)worldclient, (double)(k2 + f2), i3 + 0.1f - block.getBlockBoundsMinY(), (double)(l2 + f3)));
                    }
                }
            }
            if (l > 0 && this.random.nextInt(3) < this.rainSoundCounter++) {
                this.rainSoundCounter = 0;
                if (d2 > entitylivingbase.posY + 1.0 && worldclient.getPrecipitationHeight(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posZ)) > MathHelper.floor_double(entitylivingbase.posY)) {
                    this.mc.theWorld.playSound(d0, d2, d3, "ambient.weather.rain", 0.1f, 0.5f, false);
                }
                else {
                    this.mc.theWorld.playSound(d0, d2, d3, "ambient.weather.rain", 0.2f, 1.0f, false);
                }
            }
        }
    }
    
    protected void renderRainSnow(final float p_78474_1_) {
        IRenderHandler renderer = null;
        if ((renderer = this.mc.theWorld.provider.getWeatherRenderer()) != null) {
            renderer.render(p_78474_1_, this.mc.theWorld, this.mc);
            return;
        }
        final float f1 = this.mc.theWorld.getRainStrength(p_78474_1_);
        if (f1 > 0.0f) {
            this.enableLightmap(p_78474_1_);
            if (this.rainXCoords == null) {
                this.rainXCoords = new float[1024];
                this.rainYCoords = new float[1024];
                for (int i = 0; i < 32; ++i) {
                    for (int j = 0; j < 32; ++j) {
                        final float f2 = (float)(j - 16);
                        final float f3 = (float)(i - 16);
                        final float f4 = MathHelper.sqrt_float(f2 * f2 + f3 * f3);
                        this.rainXCoords[i << 5 | j] = -f3 / f4;
                        this.rainYCoords[i << 5 | j] = f2 / f4;
                    }
                }
            }
            final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
            final WorldClient worldclient = this.mc.theWorld;
            final int k2 = MathHelper.floor_double(entitylivingbase.posX);
            final int l2 = MathHelper.floor_double(entitylivingbase.posY);
            final int i2 = MathHelper.floor_double(entitylivingbase.posZ);
            final Tessellator tessellator = Tessellator.instance;
            GL11.glDisable(2884);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glEnable(3042);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glAlphaFunc(516, 0.1f);
            final double d0 = entitylivingbase.lastTickPosX + (entitylivingbase.posX - entitylivingbase.lastTickPosX) * p_78474_1_;
            final double d2 = entitylivingbase.lastTickPosY + (entitylivingbase.posY - entitylivingbase.lastTickPosY) * p_78474_1_;
            final double d3 = entitylivingbase.lastTickPosZ + (entitylivingbase.posZ - entitylivingbase.lastTickPosZ) * p_78474_1_;
            final int m = MathHelper.floor_double(d2);
            byte b0 = 5;
            if (this.mc.gameSettings.fancyGraphics) {
                b0 = 10;
            }
            boolean flag = false;
            byte b2 = -1;
            final float f5 = this.rendererUpdateCount + p_78474_1_;
            if (this.mc.gameSettings.fancyGraphics) {
                b0 = 10;
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            flag = false;
            for (int l3 = i2 - b0; l3 <= i2 + b0; ++l3) {
                for (int i3 = k2 - b0; i3 <= k2 + b0; ++i3) {
                    final int j2 = (l3 - i2 + 16) * 32 + i3 - k2 + 16;
                    final float f6 = this.rainXCoords[j2] * 0.5f;
                    final float f7 = this.rainYCoords[j2] * 0.5f;
                    final BiomeGenBase biomegenbase = worldclient.getBiomeGenForCoords(i3, l3);
                    if (biomegenbase.canSpawnLightningBolt() || biomegenbase.getEnableSnow()) {
                        final int k3 = worldclient.getPrecipitationHeight(i3, l3);
                        int l4 = l2 - b0;
                        int i4 = l2 + b0;
                        if (l4 < k3) {
                            l4 = k3;
                        }
                        if (i4 < k3) {
                            i4 = k3;
                        }
                        final float f8 = 1.0f;
                        int j3;
                        if ((j3 = k3) < m) {
                            j3 = m;
                        }
                        if (l4 != i4) {
                            this.random.setSeed(i3 * i3 * 3121 + i3 * 45238971 ^ l3 * l3 * 418711 + l3 * 13761);
                            final float f9 = biomegenbase.getFloatTemperature(i3, l4, l3);
                            if (worldclient.getWorldChunkManager().getTemperatureAtHeight(f9, k3) >= 0.15f) {
                                if (b2 != 0) {
                                    if (b2 >= 0) {
                                        tessellator.draw();
                                    }
                                    b2 = 0;
                                    this.mc.getTextureManager().bindTexture(CompatibleWorldRenderer.locationRainPng);
                                    tessellator.startDrawingQuads();
                                }
                                final float f10 = ((this.rendererUpdateCount + i3 * i3 * 3121 + i3 * 45238971 + l3 * l3 * 418711 + l3 * 13761 & 0x1F) + p_78474_1_) / 32.0f * (3.0f + this.random.nextFloat());
                                final double d4 = i3 + 0.5f - entitylivingbase.posX;
                                final double d5 = l3 + 0.5f - entitylivingbase.posZ;
                                final float f11 = MathHelper.sqrt_double(d4 * d4 + d5 * d5) / b0;
                                final float f12 = 1.0f;
                                tessellator.setBrightness(worldclient.getLightBrightnessForSkyBlocks(i3, j3, l3, 0));
                                tessellator.setColorRGBA_F(f12, f12, f12, ((1.0f - f11 * f11) * 0.5f + 0.5f) * f1);
                                tessellator.setTranslation(-d0 * 1.0, -d2 * 1.0, -d3 * 1.0);
                                tessellator.addVertexWithUV(i3 - f6 + 0.5, (double)l4, l3 - f7 + 0.5, (double)(0.0f * f8), (double)(l4 * f8 / 4.0f + f10 * f8));
                                tessellator.addVertexWithUV(i3 + f6 + 0.5, (double)l4, l3 + f7 + 0.5, (double)(1.0f * f8), (double)(l4 * f8 / 4.0f + f10 * f8));
                                tessellator.addVertexWithUV(i3 + f6 + 0.5, (double)i4, l3 + f7 + 0.5, (double)(1.0f * f8), (double)(i4 * f8 / 4.0f + f10 * f8));
                                tessellator.addVertexWithUV(i3 - f6 + 0.5, (double)i4, l3 - f7 + 0.5, (double)(0.0f * f8), (double)(i4 * f8 / 4.0f + f10 * f8));
                                tessellator.setTranslation(0.0, 0.0, 0.0);
                            }
                            else {
                                if (b2 != 1) {
                                    if (b2 >= 0) {
                                        tessellator.draw();
                                    }
                                    b2 = 1;
                                    this.mc.getTextureManager().bindTexture(CompatibleWorldRenderer.locationSnowPng);
                                    tessellator.startDrawingQuads();
                                }
                                final float f10 = ((this.rendererUpdateCount & 0x1FF) + p_78474_1_) / 512.0f;
                                final float f13 = this.random.nextFloat() + f5 * 0.01f * (float)this.random.nextGaussian();
                                final float f14 = this.random.nextFloat() + f5 * (float)this.random.nextGaussian() * 0.001f;
                                final double d5 = i3 + 0.5f - entitylivingbase.posX;
                                final double d6 = l3 + 0.5f - entitylivingbase.posZ;
                                final float f15 = MathHelper.sqrt_double(d5 * d5 + d6 * d6) / b0;
                                final float f16 = 1.0f;
                                tessellator.setBrightness((worldclient.getLightBrightnessForSkyBlocks(i3, j3, l3, 0) * 3 + 15728880) / 4);
                                tessellator.setColorRGBA_F(f16, f16, f16, ((1.0f - f15 * f15) * 0.3f + 0.5f) * f1);
                                tessellator.setTranslation(-d0 * 1.0, -d2 * 1.0, -d3 * 1.0);
                                tessellator.addVertexWithUV(i3 - f6 + 0.5, (double)l4, l3 - f7 + 0.5, (double)(0.0f * f8 + f13), (double)(l4 * f8 / 4.0f + f10 * f8 + f14));
                                tessellator.addVertexWithUV(i3 + f6 + 0.5, (double)l4, l3 + f7 + 0.5, (double)(1.0f * f8 + f13), (double)(l4 * f8 / 4.0f + f10 * f8 + f14));
                                tessellator.addVertexWithUV(i3 + f6 + 0.5, (double)i4, l3 + f7 + 0.5, (double)(1.0f * f8 + f13), (double)(i4 * f8 / 4.0f + f10 * f8 + f14));
                                tessellator.addVertexWithUV(i3 - f6 + 0.5, (double)i4, l3 - f7 + 0.5, (double)(0.0f * f8 + f13), (double)(i4 * f8 / 4.0f + f10 * f8 + f14));
                                tessellator.setTranslation(0.0, 0.0, 0.0);
                            }
                        }
                    }
                }
            }
            if (b2 >= 0) {
                tessellator.draw();
            }
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            this.disableLightmap(p_78474_1_);
        }
    }
    
    public void setupOverlayRendering() {
        final ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, scaledresolution.getScaledWidth_double(), scaledresolution.getScaledHeight_double(), 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
    }
    
    private void updateFogColor(final float p_78466_1_) {
        final WorldClient worldclient = this.mc.theWorld;
        final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
        float f1 = 0.25f + 0.75f * this.mc.gameSettings.renderDistanceChunks / 16.0f;
        f1 = 1.0f - (float)Math.pow(f1, 0.25);
        final Vec3 vec3 = worldclient.getSkyColor((Entity)this.mc.renderViewEntity, p_78466_1_);
        final float f2 = (float)vec3.xCoord;
        final float f3 = (float)vec3.yCoord;
        final float f4 = (float)vec3.zCoord;
        final Vec3 vec4 = worldclient.getFogColor(p_78466_1_);
        this.fogColorRed = (float)vec4.xCoord;
        this.fogColorGreen = (float)vec4.yCoord;
        this.fogColorBlue = (float)vec4.zCoord;
        if (this.mc.gameSettings.renderDistanceChunks >= 4) {
            final Vec3 vec5 = (MathHelper.sin(worldclient.getCelestialAngleRadians(p_78466_1_)) > 0.0f) ? Vec3.createVectorHelper(-1.0, 0.0, 0.0) : Vec3.createVectorHelper(1.0, 0.0, 0.0);
            float f5 = (float)entitylivingbase.getLook(p_78466_1_).dotProduct(vec5);
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            if (f5 > 0.0f) {
                final float[] afloat = worldclient.provider.calcSunriseSunsetColors(worldclient.getCelestialAngle(p_78466_1_), p_78466_1_);
                if (afloat != null) {
                    f5 *= afloat[3];
                    this.fogColorRed = this.fogColorRed * (1.0f - f5) + afloat[0] * f5;
                    this.fogColorGreen = this.fogColorGreen * (1.0f - f5) + afloat[1] * f5;
                    this.fogColorBlue = this.fogColorBlue * (1.0f - f5) + afloat[2] * f5;
                }
            }
        }
        this.fogColorRed += (f2 - this.fogColorRed) * f1;
        this.fogColorGreen += (f3 - this.fogColorGreen) * f1;
        this.fogColorBlue += (f4 - this.fogColorBlue) * f1;
        final float f6 = worldclient.getRainStrength(p_78466_1_);
        if (f6 > 0.0f) {
            final float f5 = 1.0f - f6 * 0.5f;
            final float f7 = 1.0f - f6 * 0.4f;
            this.fogColorRed *= f5;
            this.fogColorGreen *= f5;
            this.fogColorBlue *= f7;
        }
        float f5 = worldclient.getWeightedThunderStrength(p_78466_1_);
        if (f5 > 0.0f) {
            final float f7 = 1.0f - f5 * 0.5f;
            this.fogColorRed *= f7;
            this.fogColorGreen *= f7;
            this.fogColorBlue *= f7;
        }
        final Block block = ActiveRenderInfo.getBlockAtEntityViewpoint((World)this.mc.theWorld, entitylivingbase, p_78466_1_);
        if (this.cloudFog) {
            final Vec3 vec6 = worldclient.getCloudColour(p_78466_1_);
            this.fogColorRed = (float)vec6.xCoord;
            this.fogColorGreen = (float)vec6.yCoord;
            this.fogColorBlue = (float)vec6.zCoord;
        }
        else if (block.getMaterial() == Material.water) {
            final float f8 = EnchantmentHelper.getRespiration(entitylivingbase) * 0.2f;
            this.fogColorRed = 0.02f + f8;
            this.fogColorGreen = 0.02f + f8;
            this.fogColorBlue = 0.2f + f8;
        }
        else if (block.getMaterial() == Material.lava) {
            this.fogColorRed = 0.6f;
            this.fogColorGreen = 0.1f;
            this.fogColorBlue = 0.0f;
        }
        final float f8 = this.fogColor2 + (this.fogColor1 - this.fogColor2) * p_78466_1_;
        this.fogColorRed *= f8;
        this.fogColorGreen *= f8;
        this.fogColorBlue *= f8;
        double d0 = (entitylivingbase.lastTickPosY + (entitylivingbase.posY - entitylivingbase.lastTickPosY) * p_78466_1_) * worldclient.provider.getVoidFogYFactor();
        if (entitylivingbase.isPotionActive(Potion.blindness)) {
            final int i = entitylivingbase.getActivePotionEffect(Potion.blindness).getDuration();
            if (i < 20) {
                d0 *= 1.0f - i / 20.0f;
            }
            else {
                d0 = 0.0;
            }
        }
        if (d0 < 1.0) {
            if (d0 < 0.0) {
                d0 = 0.0;
            }
            d0 *= d0;
            this.fogColorRed *= (float)d0;
            this.fogColorGreen *= (float)d0;
            this.fogColorBlue *= (float)d0;
        }
        if (this.bossColorModifier > 0.0f) {
            final float f9 = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * p_78466_1_;
            this.fogColorRed = this.fogColorRed * (1.0f - f9) + this.fogColorRed * 0.7f * f9;
            this.fogColorGreen = this.fogColorGreen * (1.0f - f9) + this.fogColorGreen * 0.6f * f9;
            this.fogColorBlue = this.fogColorBlue * (1.0f - f9) + this.fogColorBlue * 0.6f * f9;
        }
        if (entitylivingbase.isPotionActive(Potion.nightVision)) {
            final float f9 = this.getNightVisionBrightness((EntityPlayer)this.mc.thePlayer, p_78466_1_);
            float f10 = 1.0f / this.fogColorRed;
            if (f10 > 1.0f / this.fogColorGreen) {
                f10 = 1.0f / this.fogColorGreen;
            }
            if (f10 > 1.0f / this.fogColorBlue) {
                f10 = 1.0f / this.fogColorBlue;
            }
            this.fogColorRed = this.fogColorRed * (1.0f - f9) + this.fogColorRed * f10 * f9;
            this.fogColorGreen = this.fogColorGreen * (1.0f - f9) + this.fogColorGreen * f10 * f9;
            this.fogColorBlue = this.fogColorBlue * (1.0f - f9) + this.fogColorBlue * f10 * f9;
        }
        if (this.mc.gameSettings.anaglyph) {
            final float f9 = (this.fogColorRed * 30.0f + this.fogColorGreen * 59.0f + this.fogColorBlue * 11.0f) / 100.0f;
            final float f10 = (this.fogColorRed * 30.0f + this.fogColorGreen * 70.0f) / 100.0f;
            final float f11 = (this.fogColorRed * 30.0f + this.fogColorBlue * 70.0f) / 100.0f;
            this.fogColorRed = f9;
            this.fogColorGreen = f10;
            this.fogColorBlue = f11;
        }
        final EntityViewRenderEvent.FogColors event = new EntityViewRenderEvent.FogColors((EntityRenderer)this, entitylivingbase, block, (double)p_78466_1_, this.fogColorRed, this.fogColorGreen, this.fogColorBlue);
        MinecraftForge.EVENT_BUS.post((Event)event);
        this.fogColorRed = event.red;
        this.fogColorBlue = event.blue;
        this.fogColorGreen = event.green;
        GL11.glClearColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 0.0f);
    }
    
    private void setupFog(final int p_78468_1_, final float p_78468_2_) {
        final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
        boolean flag = false;
        if (entitylivingbase instanceof EntityPlayer) {
            flag = ((EntityPlayer)entitylivingbase).capabilities.isCreativeMode;
        }
        if (p_78468_1_ == 999) {
            GL11.glFog(2918, this.setFogColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, 0.0f);
            GL11.glFogf(2916, 8.0f);
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GL11.glFogi(34138, 34139);
            }
            GL11.glFogf(2915, 0.0f);
        }
        else {
            GL11.glFog(2918, this.setFogColorBuffer(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 1.0f));
            GL11.glNormal3f(0.0f, -1.0f, 0.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            final Block block = ActiveRenderInfo.getBlockAtEntityViewpoint((World)this.mc.theWorld, entitylivingbase, p_78468_2_);
            final EntityViewRenderEvent.FogDensity event = new EntityViewRenderEvent.FogDensity((EntityRenderer)this, entitylivingbase, block, (double)p_78468_2_, 0.1f);
            if (MinecraftForge.EVENT_BUS.post((Event)event)) {
                GL11.glFogf(2914, event.density);
            }
            else if (entitylivingbase.isPotionActive(Potion.blindness)) {
                float f1 = 5.0f;
                final int j = entitylivingbase.getActivePotionEffect(Potion.blindness).getDuration();
                if (j < 20) {
                    f1 = 5.0f + (this.farPlaneDistance - 5.0f) * (1.0f - j / 20.0f);
                }
                GL11.glFogi(2917, 9729);
                if (p_78468_1_ < 0) {
                    GL11.glFogf(2915, 0.0f);
                    GL11.glFogf(2916, f1 * 0.8f);
                }
                else {
                    GL11.glFogf(2915, f1 * 0.25f);
                    GL11.glFogf(2916, f1);
                }
                if (GLContext.getCapabilities().GL_NV_fog_distance) {
                    GL11.glFogi(34138, 34139);
                }
            }
            else if (this.cloudFog) {
                GL11.glFogi(2917, 2048);
                GL11.glFogf(2914, 0.1f);
            }
            else if (block.getMaterial() == Material.water) {
                GL11.glFogi(2917, 2048);
                if (entitylivingbase.isPotionActive(Potion.waterBreathing)) {
                    GL11.glFogf(2914, 0.05f);
                }
                else {
                    GL11.glFogf(2914, 0.1f - EnchantmentHelper.getRespiration(entitylivingbase) * 0.03f);
                }
            }
            else if (block.getMaterial() == Material.lava) {
                GL11.glFogi(2917, 2048);
                GL11.glFogf(2914, 2.0f);
            }
            else {
                float f1 = this.farPlaneDistance;
                if (this.mc.theWorld.provider.getWorldHasVoidParticles() && !flag) {
                    double d0 = ((entitylivingbase.getBrightnessForRender(p_78468_2_) & 0xF00000) >> 20) / 16.0 + (entitylivingbase.lastTickPosY + (entitylivingbase.posY - entitylivingbase.lastTickPosY) * p_78468_2_ + 4.0) / 32.0;
                    if (d0 < 1.0) {
                        if (d0 < 0.0) {
                            d0 = 0.0;
                        }
                        d0 *= d0;
                        float f2 = 100.0f * (float)d0;
                        if (f2 < 5.0f) {
                            f2 = 5.0f;
                        }
                        if (f1 > f2) {
                            f1 = f2;
                        }
                    }
                }
                GL11.glFogi(2917, 9729);
                if (p_78468_1_ < 0) {
                    GL11.glFogf(2915, 0.0f);
                    GL11.glFogf(2916, f1);
                }
                else {
                    GL11.glFogf(2915, f1 * 0.75f);
                    GL11.glFogf(2916, f1);
                }
                if (GLContext.getCapabilities().GL_NV_fog_distance) {
                    GL11.glFogi(34138, 34139);
                }
                if (this.mc.theWorld.provider.doesXZShowFog((int)entitylivingbase.posX, (int)entitylivingbase.posZ)) {
                    GL11.glFogf(2915, f1 * 0.05f);
                    GL11.glFogf(2916, Math.min(f1, 192.0f) * 0.5f);
                }
                MinecraftForge.EVENT_BUS.post((Event)new EntityViewRenderEvent.RenderFogEvent((EntityRenderer)this, entitylivingbase, block, (double)p_78468_2_, p_78468_1_, f1));
            }
            GL11.glEnable(2903);
            GL11.glColorMaterial(1028, 4608);
        }
    }
    
    private FloatBuffer setFogColorBuffer(final float p_78469_1_, final float p_78469_2_, final float p_78469_3_, final float p_78469_4_) {
        this.fogColorBuffer.clear();
        this.fogColorBuffer.put(p_78469_1_).put(p_78469_2_).put(p_78469_3_).put(p_78469_4_);
        this.fogColorBuffer.flip();
        return this.fogColorBuffer;
    }
    
    public MapItemRenderer getMapItemRenderer() {
        return this.theMapItemRenderer;
    }
    
    public void setPrepareTerrain(final boolean b) {
    }
    
    static /* synthetic */ Minecraft access$000(final CompatibleWorldRenderer x0) {
        return x0.mc;
    }
    
    static {
        logger = LogManager.getLogger();
        locationRainPng = new ResourceLocation("textures/environment/rain.png");
        locationSnowPng = new ResourceLocation("textures/environment/snow.png");
        shaderResourceLocations = new ResourceLocation[] { new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json") };
        shaderCount = CompatibleWorldRenderer.shaderResourceLocations.length;
    }
}
