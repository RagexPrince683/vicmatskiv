package com.vicmatskiv.weaponlib.compatibility;

import
        cpw.mods.fml.relauncher.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.*;
import java.nio.*;
import com.google.common.collect.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.util.*;
import net.minecraftforge.client.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.client.audio.*;
import java.util.concurrent.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.client.particle.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import org.apache.logging.log4j.*;

@SideOnly(Side.CLIENT)
public class CompatibleRenderGlobal extends RenderGlobal implements IWorldAccess
{
    private static final Logger logger;
    private static final ResourceLocation locationMoonPhasesPng;
    private static final ResourceLocation locationSunPng;
    private static final ResourceLocation locationCloudsPng;
    private static final ResourceLocation locationEndSkyPng;
    public List tileEntities;
    private WorldClient theWorld;
    private final TextureManager renderEngine;
    private List worldRenderersToUpdate;
    private WorldRenderer[] sortedWorldRenderers;
    private WorldRenderer[] worldRenderers;
    private int renderChunksWide;
    private int renderChunksTall;
    private int renderChunksDeep;
    private int glRenderListBase;
    private Minecraft mc;
    private RenderBlocks renderBlocksRg;
    private IntBuffer glOcclusionQueryBase;
    private boolean occlusionEnabled;
    private int cloudTickCounter;
    private int starGLCallList;
    private int glSkyList;
    private int glSkyList2;
    private int minBlockX;
    private int minBlockY;
    private int minBlockZ;
    private int maxBlockX;
    private int maxBlockY;
    private int maxBlockZ;
    private final Map damagedBlocks;
    private final Map mapSoundPositions;
    private IIcon[] destroyBlockIcons;
    private boolean displayListEntitiesDirty;
    private int displayListEntities;
    private int renderDistanceChunks;
    private int renderEntitiesStartupCounter;
    private int countEntitiesTotal;
    private int countEntitiesRendered;
    private int countEntitiesHidden;
    IntBuffer occlusionResult;
    private int renderersLoaded;
    private int renderersBeingClipped;
    private int renderersBeingOccluded;
    private int renderersBeingRendered;
    private int renderersSkippingRenderPass;
    private int dummyRenderInt;
    private int worldRenderersCheckIndex;
    private List glRenderLists;
    private RenderList[] allRenderLists;
    double prevSortX;
    double prevSortY;
    double prevSortZ;
    double prevRenderSortX;
    double prevRenderSortY;
    double prevRenderSortZ;
    int prevChunkSortX;
    int prevChunkSortY;
    int prevChunkSortZ;
    int frustumCheckOffset;
    private static final String __OBFID = "CL_00000954";
    
    public CompatibleRenderGlobal(final Minecraft p_i1249_1_) {
        super(p_i1249_1_);
        this.tileEntities = new ArrayList();
        this.worldRenderersToUpdate = new ArrayList();
        this.damagedBlocks = new HashMap();
        this.mapSoundPositions = Maps.newHashMap();
        this.renderDistanceChunks = -1;
        this.renderEntitiesStartupCounter = 2;
        this.occlusionResult = GLAllocation.createDirectIntBuffer(64);
        this.glRenderLists = new ArrayList();
        this.allRenderLists = new RenderList[] { new RenderList(), new RenderList(), new RenderList(), new RenderList() };
        this.prevSortX = -9999.0;
        this.prevSortY = -9999.0;
        this.prevSortZ = -9999.0;
        this.prevRenderSortX = -9999.0;
        this.prevRenderSortY = -9999.0;
        this.prevRenderSortZ = -9999.0;
        this.prevChunkSortX = -999;
        this.prevChunkSortY = -999;
        this.prevChunkSortZ = -999;
        this.mc = p_i1249_1_;
        this.renderEngine = p_i1249_1_.getTextureManager();
        final byte b0 = 34;
        final byte b2 = 16;
        this.glRenderListBase = GLAllocation.generateDisplayLists(b0 * b0 * b2 * 3);
        this.displayListEntitiesDirty = false;
        this.displayListEntities = GLAllocation.generateDisplayLists(1);
        this.occlusionEnabled = OpenGlCapsChecker.checkARBOcclusion();
        if (this.occlusionEnabled) {
            this.occlusionResult.clear();
            (this.glOcclusionQueryBase = GLAllocation.createDirectIntBuffer(b0 * b0 * b2)).clear();
            this.glOcclusionQueryBase.position(0);
            this.glOcclusionQueryBase.limit(b0 * b0 * b2);
            ARBOcclusionQuery.glGenQueriesARB(this.glOcclusionQueryBase);
        }
        this.starGLCallList = GLAllocation.generateDisplayLists(3);
        GL11.glPushMatrix();
        GL11.glNewList(this.starGLCallList, 4864);
        this.renderStars();
        GL11.glEndList();
        GL11.glPopMatrix();
        final Tessellator tessellator = Tessellator.instance;
        GL11.glNewList(this.glSkyList = this.starGLCallList + 1, 4864);
        final byte b3 = 64;
        final int i = 256 / b3 + 2;
        float f = 16.0f;
        for (int j = -b3 * i; j <= b3 * i; j += b3) {
            for (int k = -b3 * i; k <= b3 * i; k += b3) {
                tessellator.startDrawingQuads();
                tessellator.addVertex((double)(j + 0), (double)f, (double)(k + 0));
                tessellator.addVertex((double)(j + b3), (double)f, (double)(k + 0));
                tessellator.addVertex((double)(j + b3), (double)f, (double)(k + b3));
                tessellator.addVertex((double)(j + 0), (double)f, (double)(k + b3));
                tessellator.draw();
            }
        }
        GL11.glEndList();
        GL11.glNewList(this.glSkyList2 = this.starGLCallList + 2, 4864);
        f = -16.0f;
        tessellator.startDrawingQuads();
        for (int j = -b3 * i; j <= b3 * i; j += b3) {
            for (int k = -b3 * i; k <= b3 * i; k += b3) {
                tessellator.addVertex((double)(j + b3), (double)f, (double)(k + 0));
                tessellator.addVertex((double)(j + 0), (double)f, (double)(k + 0));
                tessellator.addVertex((double)(j + 0), (double)f, (double)(k + b3));
                tessellator.addVertex((double)(j + b3), (double)f, (double)(k + b3));
            }
        }
        tessellator.draw();
        GL11.glEndList();
    }
    
    private void renderStars() {
        final Random random = new Random(10842L);
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        for (int i = 0; i < 1500; ++i) {
            double d0 = random.nextFloat() * 2.0f - 1.0f;
            double d2 = random.nextFloat() * 2.0f - 1.0f;
            double d3 = random.nextFloat() * 2.0f - 1.0f;
            final double d4 = 0.15f + random.nextFloat() * 0.1f;
            double d5 = d0 * d0 + d2 * d2 + d3 * d3;
            if (d5 < 1.0 && d5 > 0.01) {
                d5 = 1.0 / Math.sqrt(d5);
                d0 *= d5;
                d2 *= d5;
                d3 *= d5;
                final double d6 = d0 * 100.0;
                final double d7 = d2 * 100.0;
                final double d8 = d3 * 100.0;
                final double d9 = Math.atan2(d0, d3);
                final double d10 = Math.sin(d9);
                final double d11 = Math.cos(d9);
                final double d12 = Math.atan2(Math.sqrt(d0 * d0 + d3 * d3), d2);
                final double d13 = Math.sin(d12);
                final double d14 = Math.cos(d12);
                final double d15 = random.nextDouble() * 3.141592653589793 * 2.0;
                final double d16 = Math.sin(d15);
                final double d17 = Math.cos(d15);
                for (int j = 0; j < 4; ++j) {
                    final double d18 = 0.0;
                    final double d19 = ((j & 0x2) - 1) * d4;
                    final double d20 = ((j + 1 & 0x2) - 1) * d4;
                    final double d21 = d19 * d17 - d20 * d16;
                    final double d22 = d20 * d17 + d19 * d16;
                    final double d23 = d21 * d13 + d18 * d14;
                    final double d24 = d18 * d13 - d21 * d14;
                    final double d25 = d24 * d10 - d22 * d11;
                    final double d26 = d22 * d10 + d24 * d11;
                    tessellator.addVertex(d6 + d25, d7 + d23, d8 + d26);
                }
            }
        }
        tessellator.draw();
    }
    
    public void setWorldAndLoadRenderers(final WorldClient p_72732_1_) {
        if (this.theWorld != null) {
            this.theWorld.removeWorldAccess((IWorldAccess)this);
        }
        this.prevSortX = -9999.0;
        this.prevSortY = -9999.0;
        this.prevSortZ = -9999.0;
        this.prevRenderSortX = -9999.0;
        this.prevRenderSortY = -9999.0;
        this.prevRenderSortZ = -9999.0;
        this.prevChunkSortX = -9999;
        this.prevChunkSortY = -9999;
        this.prevChunkSortZ = -9999;
        RenderManager.instance.set((World)p_72732_1_);
        this.theWorld = p_72732_1_;
        this.renderBlocksRg = new RenderBlocks((IBlockAccess)p_72732_1_);
        if (p_72732_1_ != null) {
            p_72732_1_.addWorldAccess((IWorldAccess)this);
            this.loadRenderers();
        }
    }
    
    public void loadRenderers() {
        if (this.theWorld != null) {
            Blocks.leaves.setGraphicsLevel(this.mc.gameSettings.fancyGraphics);
            Blocks.leaves2.setGraphicsLevel(this.mc.gameSettings.fancyGraphics);
            this.renderDistanceChunks = this.mc.gameSettings.renderDistanceChunks;
            if (this.worldRenderers != null) {
                for (int i = 0; i < this.worldRenderers.length; ++i) {
                    this.worldRenderers[i].stopRendering();
                }
            }
            int i = this.renderDistanceChunks * 2 + 1;
            this.renderChunksWide = i;
            this.renderChunksTall = 16;
            this.renderChunksDeep = i;
            this.worldRenderers = new WorldRenderer[this.renderChunksWide * this.renderChunksTall * this.renderChunksDeep];
            this.sortedWorldRenderers = new WorldRenderer[this.renderChunksWide * this.renderChunksTall * this.renderChunksDeep];
            int j = 0;
            int k = 0;
            this.minBlockX = 0;
            this.minBlockY = 0;
            this.minBlockZ = 0;
            this.maxBlockX = this.renderChunksWide;
            this.maxBlockY = this.renderChunksTall;
            this.maxBlockZ = this.renderChunksDeep;
            for (int l = 0; l < this.worldRenderersToUpdate.size(); ++l) {
                this.worldRenderersToUpdate.get(l).needsUpdate = false;
            }
            this.worldRenderersToUpdate.clear();
            this.tileEntities.clear();
            this.onStaticEntitiesChanged();
            for (int l = 0; l < this.renderChunksWide; ++l) {
                for (int i2 = 0; i2 < this.renderChunksTall; ++i2) {
                    for (int j2 = 0; j2 < this.renderChunksDeep; ++j2) {
                        this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l] = new WorldRenderer((World)this.theWorld, this.tileEntities, l * 16, i2 * 16, j2 * 16, this.glRenderListBase + j);
                        if (this.occlusionEnabled) {
                            this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l].glOcclusionQuery = this.glOcclusionQueryBase.get(k);
                        }
                        this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l].isWaitingOnOcclusionQuery = false;
                        this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l].isVisible = true;
                        this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l].isInFrustum = true;
                        this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l].chunkIndex = k++;
                        this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l].markDirty();
                        this.sortedWorldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l] = this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l];
                        this.worldRenderersToUpdate.add(this.worldRenderers[(j2 * this.renderChunksTall + i2) * this.renderChunksWide + l]);
                        j += 3;
                    }
                }
            }
            if (this.theWorld != null) {
                final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
                if (entitylivingbase != null) {
                    this.markRenderersForNewPosition(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ));
                    Arrays.sort(this.sortedWorldRenderers, (Comparator<? super WorldRenderer>)new EntitySorter((Entity)entitylivingbase));
                }
            }
            this.renderEntitiesStartupCounter = 2;
        }
    }
    
    public void renderEntities(final EntityLivingBase p_147589_1_, final ICamera p_147589_2_, final float p_147589_3_) {
        final int pass = MinecraftForgeClient.getRenderPass();
        if (this.renderEntitiesStartupCounter > 0) {
            if (pass > 0) {
                return;
            }
            --this.renderEntitiesStartupCounter;
        }
        else {
            final double d0 = p_147589_1_.prevPosX + (p_147589_1_.posX - p_147589_1_.prevPosX) * p_147589_3_;
            final double d2 = p_147589_1_.prevPosY + (p_147589_1_.posY - p_147589_1_.prevPosY) * p_147589_3_;
            final double d3 = p_147589_1_.prevPosZ + (p_147589_1_.posZ - p_147589_1_.prevPosZ) * p_147589_3_;
            this.theWorld.theProfiler.startSection("prepare");
            TileEntityRendererDispatcher.instance.cacheActiveRenderInfo((World)this.theWorld, this.mc.getTextureManager(), this.mc.fontRenderer, this.mc.renderViewEntity, p_147589_3_);
            RenderManager.instance.cacheActiveRenderInfo((World)this.theWorld, this.mc.getTextureManager(), this.mc.fontRenderer, this.mc.renderViewEntity, this.mc.pointedEntity, this.mc.gameSettings, p_147589_3_);
            if (pass == 0) {
                this.countEntitiesTotal = 0;
                this.countEntitiesRendered = 0;
                this.countEntitiesHidden = 0;
            }
            final EntityLivingBase entitylivingbase1 = this.mc.renderViewEntity;
            final double d4 = entitylivingbase1.lastTickPosX + (entitylivingbase1.posX - entitylivingbase1.lastTickPosX) * p_147589_3_;
            final double d5 = entitylivingbase1.lastTickPosY + (entitylivingbase1.posY - entitylivingbase1.lastTickPosY) * p_147589_3_;
            final double d6 = entitylivingbase1.lastTickPosZ + (entitylivingbase1.posZ - entitylivingbase1.lastTickPosZ) * p_147589_3_;
            TileEntityRendererDispatcher.staticPlayerX = d4;
            TileEntityRendererDispatcher.staticPlayerY = d5;
            TileEntityRendererDispatcher.staticPlayerZ = d6;
            this.theWorld.theProfiler.endStartSection("staticentities");
            if (this.displayListEntitiesDirty) {
                RenderManager.renderPosX = 0.0;
                RenderManager.renderPosY = 0.0;
                RenderManager.renderPosZ = 0.0;
                this.rebuildDisplayListEntities();
            }
            GL11.glMatrixMode(5888);
            GL11.glPushMatrix();
            GL11.glTranslated(-d4, -d5, -d6);
            GL11.glCallList(this.displayListEntities);
            GL11.glPopMatrix();
            RenderManager.renderPosX = d4;
            RenderManager.renderPosY = d5;
            RenderManager.renderPosZ = d6;
            this.mc.entityRenderer.enableLightmap((double)p_147589_3_);
            this.theWorld.theProfiler.endStartSection("global");
            final List list = this.theWorld.getLoadedEntityList();
            if (pass == 0) {
                this.countEntitiesTotal = list.size();
            }
            for (int i = 0; i < this.theWorld.weatherEffects.size(); ++i) {
                final Entity entity = this.theWorld.weatherEffects.get(i);
                if (entity.shouldRenderInPass(pass)) {
                    ++this.countEntitiesRendered;
                    if (entity.isInRangeToRender3d(d0, d2, d3)) {
                        RenderManager.instance.renderEntitySimple(entity, p_147589_3_);
                    }
                }
            }
            this.theWorld.theProfiler.endStartSection("entities");
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity = list.get(i);
                if (entity.shouldRenderInPass(pass)) {
                    boolean flag = entity.isInRangeToRender3d(d0, d2, d3) && (entity.ignoreFrustumCheck || p_147589_2_.isBoundingBoxInFrustum(entity.boundingBox) || entity.riddenByEntity == this.mc.thePlayer);
                    if (!flag && entity instanceof EntityLiving) {
                        final EntityLiving entityliving = (EntityLiving)entity;
                        if (entityliving.getLeashed() && entityliving.getLeashedToEntity() != null) {
                            final Entity entity2 = entityliving.getLeashedToEntity();
                            flag = p_147589_2_.isBoundingBoxInFrustum(entity2.boundingBox);
                        }
                    }
                    if (flag && (entity != this.mc.renderViewEntity || this.mc.gameSettings.thirdPersonView != 0 || this.mc.renderViewEntity.isPlayerSleeping()) && this.theWorld.blockExists(MathHelper.floor_double(entity.posX), 0, MathHelper.floor_double(entity.posZ))) {
                        ++this.countEntitiesRendered;
                        RenderManager.instance.renderEntitySimple(entity, p_147589_3_);
                    }
                }
            }
            this.theWorld.theProfiler.endStartSection("blockentities");
            RenderHelper.enableStandardItemLighting();
            for (int i = 0; i < this.tileEntities.size(); ++i) {
                final TileEntity tile = this.tileEntities.get(i);
                if (tile.shouldRenderInPass(pass) && p_147589_2_.isBoundingBoxInFrustum(tile.getRenderBoundingBox())) {
                    TileEntityRendererDispatcher.instance.renderTileEntity(tile, p_147589_3_);
                }
            }
            this.mc.entityRenderer.disableLightmap((double)p_147589_3_);
            this.theWorld.theProfiler.endSection();
        }
    }
    
    public String getDebugInfoRenders() {
        return "C: " + this.renderersBeingRendered + "/" + this.renderersLoaded + ". F: " + this.renderersBeingClipped + ", O: " + this.renderersBeingOccluded + ", E: " + this.renderersSkippingRenderPass;
    }
    
    public String getDebugInfoEntities() {
        return "E: " + this.countEntitiesRendered + "/" + this.countEntitiesTotal + ". B: " + this.countEntitiesHidden + ", I: " + (this.countEntitiesTotal - this.countEntitiesHidden - this.countEntitiesRendered);
    }
    
    public void onStaticEntitiesChanged() {
        this.displayListEntitiesDirty = true;
    }
    
    public void rebuildDisplayListEntities() {
        this.theWorld.theProfiler.startSection("staticentityrebuild");
        GL11.glPushMatrix();
        GL11.glNewList(this.displayListEntities, 4864);
        final List list = this.theWorld.getLoadedEntityList();
        this.displayListEntitiesDirty = false;
        for (int i = 0; i < list.size(); ++i) {
            final Entity entity = list.get(i);
            if (RenderManager.instance.getEntityRenderObject(entity).isStaticEntity()) {
                this.displayListEntitiesDirty = (this.displayListEntitiesDirty || !RenderManager.instance.renderEntityStatic(entity, 0.0f, true));
            }
        }
        GL11.glEndList();
        GL11.glPopMatrix();
        this.theWorld.theProfiler.endSection();
    }
    
    private void markRenderersForNewPosition(int p_72722_1_, int p_72722_2_, int p_72722_3_) {
        p_72722_1_ -= 8;
        p_72722_2_ -= 8;
        p_72722_3_ -= 8;
        this.minBlockX = Integer.MAX_VALUE;
        this.minBlockY = Integer.MAX_VALUE;
        this.minBlockZ = Integer.MAX_VALUE;
        this.maxBlockX = Integer.MIN_VALUE;
        this.maxBlockY = Integer.MIN_VALUE;
        this.maxBlockZ = Integer.MIN_VALUE;
        final int l = this.renderChunksWide * 16;
        final int i1 = l / 2;
        for (int j1 = 0; j1 < this.renderChunksWide; ++j1) {
            int k1 = j1 * 16;
            int l2 = k1 + i1 - p_72722_1_;
            if (l2 < 0) {
                l2 -= l - 1;
            }
            l2 /= l;
            k1 -= l2 * l;
            if (k1 < this.minBlockX) {
                this.minBlockX = k1;
            }
            if (k1 > this.maxBlockX) {
                this.maxBlockX = k1;
            }
            for (int i2 = 0; i2 < this.renderChunksDeep; ++i2) {
                int j2 = i2 * 16;
                int k2 = j2 + i1 - p_72722_3_;
                if (k2 < 0) {
                    k2 -= l - 1;
                }
                k2 /= l;
                j2 -= k2 * l;
                if (j2 < this.minBlockZ) {
                    this.minBlockZ = j2;
                }
                if (j2 > this.maxBlockZ) {
                    this.maxBlockZ = j2;
                }
                for (int l3 = 0; l3 < this.renderChunksTall; ++l3) {
                    final int i3 = l3 * 16;
                    if (i3 < this.minBlockY) {
                        this.minBlockY = i3;
                    }
                    if (i3 > this.maxBlockY) {
                        this.maxBlockY = i3;
                    }
                    final WorldRenderer worldrenderer = this.worldRenderers[(i2 * this.renderChunksTall + l3) * this.renderChunksWide + j1];
                    final boolean flag = worldrenderer.needsUpdate;
                    worldrenderer.setPosition(k1, i3, j2);
                    if (!flag && worldrenderer.needsUpdate) {
                        this.worldRenderersToUpdate.add(worldrenderer);
                    }
                }
            }
        }
    }
    
    public int sortAndRender(final EntityLivingBase p_72719_1_, final int p_72719_2_, final double p_72719_3_) {
        this.theWorld.theProfiler.startSection("sortchunks");
        for (int j = 0; j < 10; ++j) {
            this.worldRenderersCheckIndex = (this.worldRenderersCheckIndex + 1) % this.worldRenderers.length;
            final WorldRenderer worldrenderer = this.worldRenderers[this.worldRenderersCheckIndex];
            if (worldrenderer.needsUpdate && !this.worldRenderersToUpdate.contains(worldrenderer)) {
                this.worldRenderersToUpdate.add(worldrenderer);
            }
        }
        if (this.mc.gameSettings.renderDistanceChunks != this.renderDistanceChunks) {
            this.loadRenderers();
        }
        if (p_72719_2_ == 0) {
            this.renderersLoaded = 0;
            this.dummyRenderInt = 0;
            this.renderersBeingClipped = 0;
            this.renderersBeingOccluded = 0;
            this.renderersBeingRendered = 0;
            this.renderersSkippingRenderPass = 0;
        }
        final double d9 = p_72719_1_.lastTickPosX + (p_72719_1_.posX - p_72719_1_.lastTickPosX) * p_72719_3_;
        final double d10 = p_72719_1_.lastTickPosY + (p_72719_1_.posY - p_72719_1_.lastTickPosY) * p_72719_3_;
        final double d11 = p_72719_1_.lastTickPosZ + (p_72719_1_.posZ - p_72719_1_.lastTickPosZ) * p_72719_3_;
        final double d12 = p_72719_1_.posX - this.prevSortX;
        final double d13 = p_72719_1_.posY - this.prevSortY;
        final double d14 = p_72719_1_.posZ - this.prevSortZ;
        if (this.prevChunkSortX != p_72719_1_.chunkCoordX || this.prevChunkSortY != p_72719_1_.chunkCoordY || this.prevChunkSortZ != p_72719_1_.chunkCoordZ || d12 * d12 + d13 * d13 + d14 * d14 > 16.0) {
            this.prevSortX = p_72719_1_.posX;
            this.prevSortY = p_72719_1_.posY;
            this.prevSortZ = p_72719_1_.posZ;
            this.prevChunkSortX = p_72719_1_.chunkCoordX;
            this.prevChunkSortY = p_72719_1_.chunkCoordY;
            this.prevChunkSortZ = p_72719_1_.chunkCoordZ;
            this.markRenderersForNewPosition(MathHelper.floor_double(p_72719_1_.posX), MathHelper.floor_double(p_72719_1_.posY), MathHelper.floor_double(p_72719_1_.posZ));
            Arrays.sort(this.sortedWorldRenderers, (Comparator<? super WorldRenderer>)new EntitySorter((Entity)p_72719_1_));
        }
        final double d15 = p_72719_1_.posX - this.prevRenderSortX;
        final double d16 = p_72719_1_.posY - this.prevRenderSortY;
        final double d17 = p_72719_1_.posZ - this.prevRenderSortZ;
        if (d15 * d15 + d16 * d16 + d17 * d17 > 1.0) {
            this.prevRenderSortX = p_72719_1_.posX;
            this.prevRenderSortY = p_72719_1_.posY;
            this.prevRenderSortZ = p_72719_1_.posZ;
            for (int k = 0; k < 27; ++k) {
                this.sortedWorldRenderers[k].updateRendererSort(p_72719_1_);
            }
        }
        RenderHelper.disableStandardItemLighting();
        final byte b1 = 0;
        int k;
        if (this.occlusionEnabled && this.mc.gameSettings.advancedOpengl && !this.mc.gameSettings.anaglyph && p_72719_2_ == 0) {
            final byte b2 = 0;
            int l = 16;
            this.checkOcclusionQueryResult(b2, l);
            for (int i1 = b2; i1 < l; ++i1) {
                this.sortedWorldRenderers[i1].isVisible = true;
            }
            this.theWorld.theProfiler.endStartSection("render");
            k = b1 + this.renderSortedRenderers(b2, l, p_72719_2_, p_72719_3_);
            do {
                this.theWorld.theProfiler.endStartSection("occ");
                final int l2 = l;
                l *= 2;
                if (l > this.sortedWorldRenderers.length) {
                    l = this.sortedWorldRenderers.length;
                }
                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glDisable(3008);
                GL11.glDisable(2912);
                GL11.glColorMask(false, false, false, false);
                GL11.glDepthMask(false);
                this.theWorld.theProfiler.startSection("check");
                this.checkOcclusionQueryResult(l2, l);
                this.theWorld.theProfiler.endSection();
                GL11.glPushMatrix();
                float f9 = 0.0f;
                float f10 = 0.0f;
                float f11 = 0.0f;
                for (int j2 = l2; j2 < l; ++j2) {
                    if (this.sortedWorldRenderers[j2].skipAllRenderPasses()) {
                        this.sortedWorldRenderers[j2].isInFrustum = false;
                    }
                    else {
                        if (!this.sortedWorldRenderers[j2].isInFrustum) {
                            this.sortedWorldRenderers[j2].isVisible = true;
                        }
                        if (this.sortedWorldRenderers[j2].isInFrustum && !this.sortedWorldRenderers[j2].isWaitingOnOcclusionQuery) {
                            final float f12 = MathHelper.sqrt_float(this.sortedWorldRenderers[j2].distanceToEntitySquared((Entity)p_72719_1_));
                            final int k2 = (int)(1.0f + f12 / 128.0f);
                            if (this.cloudTickCounter % k2 == j2 % k2) {
                                final WorldRenderer worldrenderer2 = this.sortedWorldRenderers[j2];
                                final float f13 = (float)(worldrenderer2.posXMinus - d9);
                                final float f14 = (float)(worldrenderer2.posYMinus - d10);
                                final float f15 = (float)(worldrenderer2.posZMinus - d11);
                                final float f16 = f13 - f9;
                                final float f17 = f14 - f10;
                                final float f18 = f15 - f11;
                                if (f16 != 0.0f || f17 != 0.0f || f18 != 0.0f) {
                                    GL11.glTranslatef(f16, f17, f18);
                                    f9 += f16;
                                    f10 += f17;
                                    f11 += f18;
                                }
                                this.theWorld.theProfiler.startSection("bb");
                                ARBOcclusionQuery.glBeginQueryARB(35092, this.sortedWorldRenderers[j2].glOcclusionQuery);
                                this.sortedWorldRenderers[j2].callOcclusionQueryList();
                                ARBOcclusionQuery.glEndQueryARB(35092);
                                this.theWorld.theProfiler.endSection();
                                this.sortedWorldRenderers[j2].isWaitingOnOcclusionQuery = true;
                            }
                        }
                    }
                }
                GL11.glPopMatrix();
                if (this.mc.gameSettings.anaglyph) {
                    if (EntityRenderer.anaglyphField == 0) {
                        GL11.glColorMask(false, true, true, true);
                    }
                    else {
                        GL11.glColorMask(true, false, false, true);
                    }
                }
                else {
                    GL11.glColorMask(true, true, true, true);
                }
                GL11.glDepthMask(true);
                GL11.glEnable(3553);
                GL11.glEnable(3008);
                GL11.glEnable(2912);
                this.theWorld.theProfiler.endStartSection("render");
                k += this.renderSortedRenderers(l2, l, p_72719_2_, p_72719_3_);
            } while (l < this.sortedWorldRenderers.length);
        }
        else {
            this.theWorld.theProfiler.endStartSection("render");
            k = b1 + this.renderSortedRenderers(0, this.sortedWorldRenderers.length, p_72719_2_, p_72719_3_);
        }
        this.theWorld.theProfiler.endSection();
        return k;
    }
    
    private void checkOcclusionQueryResult(final int p_72720_1_, final int p_72720_2_) {
        for (int k = p_72720_1_; k < p_72720_2_; ++k) {
            if (this.sortedWorldRenderers[k].isWaitingOnOcclusionQuery) {
                this.occlusionResult.clear();
                ARBOcclusionQuery.glGetQueryObjectuARB(this.sortedWorldRenderers[k].glOcclusionQuery, 34919, this.occlusionResult);
                if (this.occlusionResult.get(0) != 0) {
                    this.sortedWorldRenderers[k].isWaitingOnOcclusionQuery = false;
                    this.occlusionResult.clear();
                    ARBOcclusionQuery.glGetQueryObjectuARB(this.sortedWorldRenderers[k].glOcclusionQuery, 34918, this.occlusionResult);
                    this.sortedWorldRenderers[k].isVisible = (this.occlusionResult.get(0) != 0);
                }
            }
        }
    }
    
    private int renderSortedRenderers(final int p_72724_1_, final int p_72724_2_, final int p_72724_3_, final double p_72724_4_) {
        this.glRenderLists.clear();
        int l = 0;
        int i1 = p_72724_1_;
        int j1 = p_72724_2_;
        byte b0 = 1;
        if (p_72724_3_ == 1) {
            i1 = this.sortedWorldRenderers.length - 1 - p_72724_1_;
            j1 = this.sortedWorldRenderers.length - 1 - p_72724_2_;
            b0 = -1;
        }
        for (int k1 = i1; k1 != j1; k1 += b0) {
            if (p_72724_3_ == 0) {
                ++this.renderersLoaded;
                if (this.sortedWorldRenderers[k1].skipRenderPass[p_72724_3_]) {
                    ++this.renderersSkippingRenderPass;
                }
                else if (!this.sortedWorldRenderers[k1].isInFrustum) {
                    ++this.renderersBeingClipped;
                }
                else if (this.occlusionEnabled && !this.sortedWorldRenderers[k1].isVisible) {
                    ++this.renderersBeingOccluded;
                }
                else {
                    ++this.renderersBeingRendered;
                }
            }
            if (!this.sortedWorldRenderers[k1].skipRenderPass[p_72724_3_] && this.sortedWorldRenderers[k1].isInFrustum && (!this.occlusionEnabled || this.sortedWorldRenderers[k1].isVisible)) {
                final int l2 = this.sortedWorldRenderers[k1].getGLCallListForPass(p_72724_3_);
                if (l2 >= 0) {
                    this.glRenderLists.add(this.sortedWorldRenderers[k1]);
                    ++l;
                }
            }
        }
        final EntityLivingBase entitylivingbase = this.mc.renderViewEntity;
        final double d3 = entitylivingbase.lastTickPosX + (entitylivingbase.posX - entitylivingbase.lastTickPosX) * p_72724_4_;
        final double d4 = entitylivingbase.lastTickPosY + (entitylivingbase.posY - entitylivingbase.lastTickPosY) * p_72724_4_;
        final double d5 = entitylivingbase.lastTickPosZ + (entitylivingbase.posZ - entitylivingbase.lastTickPosZ) * p_72724_4_;
        int i2 = 0;
        for (int j2 = 0; j2 < this.allRenderLists.length; ++j2) {
            this.allRenderLists[j2].resetList();
        }
        for (int j2 = 0; j2 < this.glRenderLists.size(); ++j2) {
            final WorldRenderer worldrenderer = this.glRenderLists.get(j2);
            int k2 = -1;
            for (int l3 = 0; l3 < i2; ++l3) {
                if (this.allRenderLists[l3].rendersChunk(worldrenderer.posXMinus, worldrenderer.posYMinus, worldrenderer.posZMinus)) {
                    k2 = l3;
                }
            }
            if (k2 < 0) {
                k2 = i2++;
                this.allRenderLists[k2].setupRenderList(worldrenderer.posXMinus, worldrenderer.posYMinus, worldrenderer.posZMinus, d3, d4, d5);
            }
            this.allRenderLists[k2].addGLRenderList(worldrenderer.getGLCallListForPass(p_72724_3_));
        }
        int j2 = MathHelper.floor_double(d3);
        final int i3 = MathHelper.floor_double(d5);
        int k2 = j2 - (j2 & 0x3FF);
        int l3 = i3 - (i3 & 0x3FF);
        Arrays.sort(this.allRenderLists, (Comparator<? super RenderList>)new RenderDistanceSorter(k2, l3));
        this.renderAllRenderLists(p_72724_3_, p_72724_4_);
        return l;
    }
    
    public void renderAllRenderLists(final int p_72733_1_, final double p_72733_2_) {
        this.mc.entityRenderer.enableLightmap(p_72733_2_);
        for (int j = 0; j < this.allRenderLists.length; ++j) {
            this.allRenderLists[j].callLists();
        }
        this.mc.entityRenderer.disableLightmap(p_72733_2_);
    }
    
    public void updateClouds() {
        ++this.cloudTickCounter;
        if (this.cloudTickCounter % 20 == 0) {
            final Iterator iterator = this.damagedBlocks.values().iterator();
            while (iterator.hasNext()) {
                final DestroyBlockProgress destroyblockprogress = iterator.next();
                final int i = destroyblockprogress.getCreationCloudUpdateTick();
                if (this.cloudTickCounter - i > 400) {
                    iterator.remove();
                }
            }
        }
    }
    
    public void renderSky(final float p_72714_1_) {
        IRenderHandler skyProvider = null;
        if ((skyProvider = this.mc.theWorld.provider.getSkyRenderer()) != null) {
            skyProvider.render(p_72714_1_, this.theWorld, this.mc);
            return;
        }
        if (this.mc.theWorld.provider.dimensionId == 1) {
            GL11.glDisable(2912);
            GL11.glDisable(3008);
            GL11.glEnable(3042);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            RenderHelper.disableStandardItemLighting();
            GL11.glDepthMask(false);
            this.renderEngine.bindTexture(CompatibleRenderGlobal.locationEndSkyPng);
            final Tessellator tessellator = Tessellator.instance;
            for (int i = 0; i < 6; ++i) {
                GL11.glPushMatrix();
                if (i == 1) {
                    GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (i == 2) {
                    GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (i == 3) {
                    GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
                }
                if (i == 4) {
                    GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                }
                if (i == 5) {
                    GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
                }
                tessellator.startDrawingQuads();
                tessellator.setColorOpaque_I(2631720);
                tessellator.addVertexWithUV(-100.0, -100.0, -100.0, 0.0, 0.0);
                tessellator.addVertexWithUV(-100.0, -100.0, 100.0, 0.0, 16.0);
                tessellator.addVertexWithUV(100.0, -100.0, 100.0, 16.0, 16.0);
                tessellator.addVertexWithUV(100.0, -100.0, -100.0, 16.0, 0.0);
                tessellator.draw();
                GL11.glPopMatrix();
            }
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
        }
        else if (this.mc.theWorld.provider.isSurfaceWorld()) {
            GL11.glDisable(3553);
            final Vec3 vec3 = this.theWorld.getSkyColor((Entity)this.mc.renderViewEntity, p_72714_1_);
            float f1 = (float)vec3.xCoord;
            float f2 = (float)vec3.yCoord;
            float f3 = (float)vec3.zCoord;
            if (this.mc.gameSettings.anaglyph) {
                final float f4 = (f1 * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
                final float f5 = (f1 * 30.0f + f2 * 70.0f) / 100.0f;
                final float f6 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
                f1 = f4;
                f2 = f5;
                f3 = f6;
            }
            GL11.glColor3f(f1, f2, f3);
            final Tessellator tessellator2 = Tessellator.instance;
            GL11.glDepthMask(false);
            GL11.glEnable(2912);
            GL11.glColor3f(f1, f2, f3);
            GL11.glCallList(this.glSkyList);
            GL11.glDisable(2912);
            GL11.glDisable(3008);
            GL11.glEnable(3042);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            RenderHelper.disableStandardItemLighting();
            final float[] afloat = this.theWorld.provider.calcSunriseSunsetColors(this.theWorld.getCelestialAngle(p_72714_1_), p_72714_1_);
            if (afloat != null) {
                GL11.glDisable(3553);
                GL11.glShadeModel(7425);
                GL11.glPushMatrix();
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef((MathHelper.sin(this.theWorld.getCelestialAngleRadians(p_72714_1_)) < 0.0f) ? 180.0f : 0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
                float f6 = afloat[0];
                float f7 = afloat[1];
                float f8 = afloat[2];
                if (this.mc.gameSettings.anaglyph) {
                    final float f9 = (f6 * 30.0f + f7 * 59.0f + f8 * 11.0f) / 100.0f;
                    final float f10 = (f6 * 30.0f + f7 * 70.0f) / 100.0f;
                    final float f11 = (f6 * 30.0f + f8 * 70.0f) / 100.0f;
                    f6 = f9;
                    f7 = f10;
                    f8 = f11;
                }
                tessellator2.startDrawing(6);
                tessellator2.setColorRGBA_F(f6, f7, f8, afloat[3]);
                tessellator2.addVertex(0.0, 100.0, 0.0);
                final byte b0 = 16;
                tessellator2.setColorRGBA_F(afloat[0], afloat[1], afloat[2], 0.0f);
                for (int j = 0; j <= b0; ++j) {
                    final float f11 = j * 3.1415927f * 2.0f / b0;
                    final float f12 = MathHelper.sin(f11);
                    final float f13 = MathHelper.cos(f11);
                    tessellator2.addVertex((double)(f12 * 120.0f), (double)(f13 * 120.0f), (double)(-f13 * 40.0f * afloat[3]));
                }
                tessellator2.draw();
                GL11.glPopMatrix();
                GL11.glShadeModel(7424);
            }
            GL11.glEnable(3553);
            OpenGlHelper.glBlendFunc(770, 1, 1, 0);
            GL11.glPushMatrix();
            float f6 = 1.0f - this.theWorld.getRainStrength(p_72714_1_);
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, f6);
            GL11.glTranslatef(f7, f8, f9);
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.theWorld.getCelestialAngle(p_72714_1_) * 360.0f, 1.0f, 0.0f, 0.0f);
            float f10 = 30.0f;
            this.renderEngine.bindTexture(CompatibleRenderGlobal.locationSunPng);
            tessellator2.startDrawingQuads();
            tessellator2.addVertexWithUV((double)(-f10), 100.0, (double)(-f10), 0.0, 0.0);
            tessellator2.addVertexWithUV((double)f10, 100.0, (double)(-f10), 1.0, 0.0);
            tessellator2.addVertexWithUV((double)f10, 100.0, (double)f10, 1.0, 1.0);
            tessellator2.addVertexWithUV((double)(-f10), 100.0, (double)f10, 0.0, 1.0);
            tessellator2.draw();
            f10 = 20.0f;
            this.renderEngine.bindTexture(CompatibleRenderGlobal.locationMoonPhasesPng);
            final int k = this.theWorld.getMoonPhase();
            final int l = k % 4;
            final int i2 = k / 4 % 2;
            final float f14 = (l + 0) / 4.0f;
            final float f15 = (i2 + 0) / 2.0f;
            final float f16 = (l + 1) / 4.0f;
            final float f17 = (i2 + 1) / 2.0f;
            tessellator2.startDrawingQuads();
            tessellator2.addVertexWithUV((double)(-f10), -100.0, (double)f10, (double)f16, (double)f17);
            tessellator2.addVertexWithUV((double)f10, -100.0, (double)f10, (double)f14, (double)f17);
            tessellator2.addVertexWithUV((double)f10, -100.0, (double)(-f10), (double)f14, (double)f15);
            tessellator2.addVertexWithUV((double)(-f10), -100.0, (double)(-f10), (double)f16, (double)f15);
            tessellator2.draw();
            GL11.glDisable(3553);
            final float f18 = this.theWorld.getStarBrightness(p_72714_1_) * f6;
            if (f18 > 0.0f) {
                GL11.glColor4f(f18, f18, f18, f18);
                GL11.glCallList(this.starGLCallList);
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            GL11.glEnable(3008);
            GL11.glEnable(2912);
            GL11.glPopMatrix();
            GL11.glDisable(3553);
            GL11.glColor3f(0.0f, 0.0f, 0.0f);
            final double d0 = this.mc.thePlayer.getPosition(p_72714_1_).yCoord - this.theWorld.getHorizon();
            if (d0 < 0.0) {
                GL11.glPushMatrix();
                GL11.glTranslatef(0.0f, 12.0f, 0.0f);
                GL11.glCallList(this.glSkyList2);
                GL11.glPopMatrix();
                f8 = 1.0f;
                f9 = -(float)(d0 + 65.0);
                f10 = -f8;
                tessellator2.startDrawingQuads();
                tessellator2.setColorRGBA_I(0, 255);
                tessellator2.addVertex((double)(-f8), (double)f9, (double)f8);
                tessellator2.addVertex((double)f8, (double)f9, (double)f8);
                tessellator2.addVertex((double)f8, (double)f10, (double)f8);
                tessellator2.addVertex((double)(-f8), (double)f10, (double)f8);
                tessellator2.addVertex((double)(-f8), (double)f10, (double)(-f8));
                tessellator2.addVertex((double)f8, (double)f10, (double)(-f8));
                tessellator2.addVertex((double)f8, (double)f9, (double)(-f8));
                tessellator2.addVertex((double)(-f8), (double)f9, (double)(-f8));
                tessellator2.addVertex((double)f8, (double)f10, (double)(-f8));
                tessellator2.addVertex((double)f8, (double)f10, (double)f8);
                tessellator2.addVertex((double)f8, (double)f9, (double)f8);
                tessellator2.addVertex((double)f8, (double)f9, (double)(-f8));
                tessellator2.addVertex((double)(-f8), (double)f9, (double)(-f8));
                tessellator2.addVertex((double)(-f8), (double)f9, (double)f8);
                tessellator2.addVertex((double)(-f8), (double)f10, (double)f8);
                tessellator2.addVertex((double)(-f8), (double)f10, (double)(-f8));
                tessellator2.addVertex((double)(-f8), (double)f10, (double)(-f8));
                tessellator2.addVertex((double)(-f8), (double)f10, (double)f8);
                tessellator2.addVertex((double)f8, (double)f10, (double)f8);
                tessellator2.addVertex((double)f8, (double)f10, (double)(-f8));
                tessellator2.draw();
            }
            if (this.theWorld.provider.isSkyColored()) {
                GL11.glColor3f(f1 * 0.2f + 0.04f, f2 * 0.2f + 0.04f, f3 * 0.6f + 0.1f);
            }
            else {
                GL11.glColor3f(f1, f2, f3);
            }
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, -(float)(d0 - 16.0), 0.0f);
            GL11.glCallList(this.glSkyList2);
            GL11.glPopMatrix();
            GL11.glEnable(3553);
            GL11.glDepthMask(true);
        }
    }
    
    public void renderClouds(final float p_72718_1_) {
        IRenderHandler renderer = null;
        if ((renderer = this.theWorld.provider.getCloudRenderer()) != null) {
            renderer.render(p_72718_1_, this.theWorld, this.mc);
            return;
        }
        if (this.mc.theWorld.provider.isSurfaceWorld()) {
            if (this.mc.gameSettings.fancyGraphics) {
                this.renderCloudsFancy(p_72718_1_);
            }
            else {
                GL11.glDisable(2884);
                final float f1 = (float)(this.mc.renderViewEntity.lastTickPosY + (this.mc.renderViewEntity.posY - this.mc.renderViewEntity.lastTickPosY) * p_72718_1_);
                final byte b0 = 32;
                final int i = 256 / b0;
                final Tessellator tessellator = Tessellator.instance;
                this.renderEngine.bindTexture(CompatibleRenderGlobal.locationCloudsPng);
                GL11.glEnable(3042);
                OpenGlHelper.glBlendFunc(770, 771, 1, 0);
                final Vec3 vec3 = this.theWorld.getCloudColour(p_72718_1_);
                float f2 = (float)vec3.xCoord;
                float f3 = (float)vec3.yCoord;
                float f4 = (float)vec3.zCoord;
                if (this.mc.gameSettings.anaglyph) {
                    final float f5 = (f2 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
                    final float f6 = (f2 * 30.0f + f3 * 70.0f) / 100.0f;
                    final float f7 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
                    f2 = f5;
                    f3 = f6;
                    f4 = f7;
                }
                final float f5 = 4.8828125E-4f;
                final double d2 = this.cloudTickCounter + p_72718_1_;
                double d3 = this.mc.renderViewEntity.prevPosX + (this.mc.renderViewEntity.posX - this.mc.renderViewEntity.prevPosX) * p_72718_1_ + d2 * 0.029999999329447746;
                double d4 = this.mc.renderViewEntity.prevPosZ + (this.mc.renderViewEntity.posZ - this.mc.renderViewEntity.prevPosZ) * p_72718_1_;
                final int j = MathHelper.floor_double(d3 / 2048.0);
                final int k = MathHelper.floor_double(d4 / 2048.0);
                d3 -= j * 2048;
                d4 -= k * 2048;
                final float f8 = this.theWorld.provider.getCloudHeight() - f1 + 0.33f;
                final float f9 = (float)(d3 * f5);
                final float f10 = (float)(d4 * f5);
                tessellator.startDrawingQuads();
                tessellator.setColorRGBA_F(f2, f3, f4, 0.8f);
                for (int l = -b0 * i; l < b0 * i; l += b0) {
                    for (int i2 = -b0 * i; i2 < b0 * i; i2 += b0) {
                        tessellator.addVertexWithUV((double)(l + 0), (double)f8, (double)(i2 + b0), (double)((l + 0) * f5 + f9), (double)((i2 + b0) * f5 + f10));
                        tessellator.addVertexWithUV((double)(l + b0), (double)f8, (double)(i2 + b0), (double)((l + b0) * f5 + f9), (double)((i2 + b0) * f5 + f10));
                        tessellator.addVertexWithUV((double)(l + b0), (double)f8, (double)(i2 + 0), (double)((l + b0) * f5 + f9), (double)((i2 + 0) * f5 + f10));
                        tessellator.addVertexWithUV((double)(l + 0), (double)f8, (double)(i2 + 0), (double)((l + 0) * f5 + f9), (double)((i2 + 0) * f5 + f10));
                    }
                }
                tessellator.draw();
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(3042);
                GL11.glEnable(2884);
            }
        }
    }
    
    public boolean hasCloudFog(final double p_72721_1_, final double p_72721_3_, final double p_72721_5_, final float p_72721_7_) {
        return false;
    }
    
    public void renderCloudsFancy(final float p_72736_1_) {
        GL11.glDisable(2884);
        final float f1 = (float)(this.mc.renderViewEntity.lastTickPosY + (this.mc.renderViewEntity.posY - this.mc.renderViewEntity.lastTickPosY) * p_72736_1_);
        final Tessellator tessellator = Tessellator.instance;
        final float f2 = 12.0f;
        final float f3 = 4.0f;
        final double d0 = this.cloudTickCounter + p_72736_1_;
        double d2 = (this.mc.renderViewEntity.prevPosX + (this.mc.renderViewEntity.posX - this.mc.renderViewEntity.prevPosX) * p_72736_1_ + d0 * 0.029999999329447746) / f2;
        double d3 = (this.mc.renderViewEntity.prevPosZ + (this.mc.renderViewEntity.posZ - this.mc.renderViewEntity.prevPosZ) * p_72736_1_) / f2 + 0.33000001311302185;
        final float f4 = this.theWorld.provider.getCloudHeight() - f1 + 0.33f;
        final int i = MathHelper.floor_double(d2 / 2048.0);
        final int j = MathHelper.floor_double(d3 / 2048.0);
        d2 -= i * 2048;
        d3 -= j * 2048;
        this.renderEngine.bindTexture(CompatibleRenderGlobal.locationCloudsPng);
        GL11.glEnable(3042);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        final Vec3 vec3 = this.theWorld.getCloudColour(p_72736_1_);
        float f5 = (float)vec3.xCoord;
        float f6 = (float)vec3.yCoord;
        float f7 = (float)vec3.zCoord;
        if (this.mc.gameSettings.anaglyph) {
            final float f8 = (f5 * 30.0f + f6 * 59.0f + f7 * 11.0f) / 100.0f;
            final float f9 = (f5 * 30.0f + f6 * 70.0f) / 100.0f;
            final float f10 = (f5 * 30.0f + f7 * 70.0f) / 100.0f;
            f5 = f8;
            f6 = f9;
            f7 = f10;
        }
        float f8 = (float)(d2 * 0.0);
        float f9 = (float)(d3 * 0.0);
        final float f10 = 0.00390625f;
        f8 = MathHelper.floor_double(d2) * f10;
        f9 = MathHelper.floor_double(d3) * f10;
        final float f11 = (float)(d2 - MathHelper.floor_double(d2));
        final float f12 = (float)(d3 - MathHelper.floor_double(d3));
        final byte b0 = 8;
        final byte b2 = 4;
        final float f13 = 9.765625E-4f;
        GL11.glScalef(f2, 1.0f, f2);
        for (int k = 0; k < 2; ++k) {
            if (k == 0) {
                GL11.glColorMask(false, false, false, false);
            }
            else if (this.mc.gameSettings.anaglyph) {
                if (EntityRenderer.anaglyphField == 0) {
                    GL11.glColorMask(false, true, true, true);
                }
                else {
                    GL11.glColorMask(true, false, false, true);
                }
            }
            else {
                GL11.glColorMask(true, true, true, true);
            }
            for (int l = -b2 + 1; l <= b2; ++l) {
                for (int i2 = -b2 + 1; i2 <= b2; ++i2) {
                    tessellator.startDrawingQuads();
                    final float f14 = (float)(l * b0);
                    final float f15 = (float)(i2 * b0);
                    final float f16 = f14 - f11;
                    final float f17 = f15 - f12;
                    if (f4 > -f3 - 1.0f) {
                        tessellator.setColorRGBA_F(f5 * 0.7f, f6 * 0.7f, f7 * 0.7f, 0.8f);
                        tessellator.setNormal(0.0f, -1.0f, 0.0f);
                        tessellator.addVertexWithUV((double)(f16 + 0.0f), (double)(f4 + 0.0f), (double)(f17 + b0), (double)((f14 + 0.0f) * f10 + f8), (double)((f15 + b0) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + b0), (double)(f4 + 0.0f), (double)(f17 + b0), (double)((f14 + b0) * f10 + f8), (double)((f15 + b0) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + b0), (double)(f4 + 0.0f), (double)(f17 + 0.0f), (double)((f14 + b0) * f10 + f8), (double)((f15 + 0.0f) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + 0.0f), (double)(f4 + 0.0f), (double)(f17 + 0.0f), (double)((f14 + 0.0f) * f10 + f8), (double)((f15 + 0.0f) * f10 + f9));
                    }
                    if (f4 <= f3 + 1.0f) {
                        tessellator.setColorRGBA_F(f5, f6, f7, 0.8f);
                        tessellator.setNormal(0.0f, 1.0f, 0.0f);
                        tessellator.addVertexWithUV((double)(f16 + 0.0f), (double)(f4 + f3 - f13), (double)(f17 + b0), (double)((f14 + 0.0f) * f10 + f8), (double)((f15 + b0) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + b0), (double)(f4 + f3 - f13), (double)(f17 + b0), (double)((f14 + b0) * f10 + f8), (double)((f15 + b0) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + b0), (double)(f4 + f3 - f13), (double)(f17 + 0.0f), (double)((f14 + b0) * f10 + f8), (double)((f15 + 0.0f) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + 0.0f), (double)(f4 + f3 - f13), (double)(f17 + 0.0f), (double)((f14 + 0.0f) * f10 + f8), (double)((f15 + 0.0f) * f10 + f9));
                    }
                    tessellator.setColorRGBA_F(f5 * 0.9f, f6 * 0.9f, f7 * 0.9f, 0.8f);
                    if (l > -1) {
                        tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                        for (int j2 = 0; j2 < b0; ++j2) {
                            tessellator.addVertexWithUV((double)(f16 + j2 + 0.0f), (double)(f4 + 0.0f), (double)(f17 + b0), (double)((f14 + j2 + 0.5f) * f10 + f8), (double)((f15 + b0) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + j2 + 0.0f), (double)(f4 + f3), (double)(f17 + b0), (double)((f14 + j2 + 0.5f) * f10 + f8), (double)((f15 + b0) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + j2 + 0.0f), (double)(f4 + f3), (double)(f17 + 0.0f), (double)((f14 + j2 + 0.5f) * f10 + f8), (double)((f15 + 0.0f) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + j2 + 0.0f), (double)(f4 + 0.0f), (double)(f17 + 0.0f), (double)((f14 + j2 + 0.5f) * f10 + f8), (double)((f15 + 0.0f) * f10 + f9));
                        }
                    }
                    if (l <= 1) {
                        tessellator.setNormal(1.0f, 0.0f, 0.0f);
                        for (int j2 = 0; j2 < b0; ++j2) {
                            tessellator.addVertexWithUV((double)(f16 + j2 + 1.0f - f13), (double)(f4 + 0.0f), (double)(f17 + b0), (double)((f14 + j2 + 0.5f) * f10 + f8), (double)((f15 + b0) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + j2 + 1.0f - f13), (double)(f4 + f3), (double)(f17 + b0), (double)((f14 + j2 + 0.5f) * f10 + f8), (double)((f15 + b0) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + j2 + 1.0f - f13), (double)(f4 + f3), (double)(f17 + 0.0f), (double)((f14 + j2 + 0.5f) * f10 + f8), (double)((f15 + 0.0f) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + j2 + 1.0f - f13), (double)(f4 + 0.0f), (double)(f17 + 0.0f), (double)((f14 + j2 + 0.5f) * f10 + f8), (double)((f15 + 0.0f) * f10 + f9));
                        }
                    }
                    tessellator.setColorRGBA_F(f5 * 0.8f, f6 * 0.8f, f7 * 0.8f, 0.8f);
                    if (i2 > -1) {
                        tessellator.setNormal(0.0f, 0.0f, -1.0f);
                        for (int j2 = 0; j2 < b0; ++j2) {
                            tessellator.addVertexWithUV((double)(f16 + 0.0f), (double)(f4 + f3), (double)(f17 + j2 + 0.0f), (double)((f14 + 0.0f) * f10 + f8), (double)((f15 + j2 + 0.5f) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + b0), (double)(f4 + f3), (double)(f17 + j2 + 0.0f), (double)((f14 + b0) * f10 + f8), (double)((f15 + j2 + 0.5f) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + b0), (double)(f4 + 0.0f), (double)(f17 + j2 + 0.0f), (double)((f14 + b0) * f10 + f8), (double)((f15 + j2 + 0.5f) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + 0.0f), (double)(f4 + 0.0f), (double)(f17 + j2 + 0.0f), (double)((f14 + 0.0f) * f10 + f8), (double)((f15 + j2 + 0.5f) * f10 + f9));
                        }
                    }
                    if (i2 <= 1) {
                        tessellator.setNormal(0.0f, 0.0f, 1.0f);
                        for (int j2 = 0; j2 < b0; ++j2) {
                            tessellator.addVertexWithUV((double)(f16 + 0.0f), (double)(f4 + f3), (double)(f17 + j2 + 1.0f - f13), (double)((f14 + 0.0f) * f10 + f8), (double)((f15 + j2 + 0.5f) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + b0), (double)(f4 + f3), (double)(f17 + j2 + 1.0f - f13), (double)((f14 + b0) * f10 + f8), (double)((f15 + j2 + 0.5f) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + b0), (double)(f4 + 0.0f), (double)(f17 + j2 + 1.0f - f13), (double)((f14 + b0) * f10 + f8), (double)((f15 + j2 + 0.5f) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + 0.0f), (double)(f4 + 0.0f), (double)(f17 + j2 + 1.0f - f13), (double)((f14 + 0.0f) * f10 + f8), (double)((f15 + j2 + 0.5f) * f10 + f9));
                        }
                    }
                    tessellator.draw();
                }
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }
    
    public boolean updateRenderers(final EntityLivingBase p_72716_1_, final boolean p_72716_2_) {
        final byte b0 = 2;
        final RenderSorter rendersorter = new RenderSorter(p_72716_1_);
        final WorldRenderer[] aworldrenderer = new WorldRenderer[b0];
        ArrayList arraylist = null;
        final int i = this.worldRenderersToUpdate.size();
        int j = 0;
        this.theWorld.theProfiler.startSection("nearChunksSearch");
        for (int k = 0; k < i; ++k) {
            final WorldRenderer worldrenderer = this.worldRenderersToUpdate.get(k);
            if (worldrenderer != null) {
                if (!p_72716_2_) {
                    if (worldrenderer.distanceToEntitySquared((Entity)p_72716_1_) > 272.0f) {
                        int l;
                        for (l = 0; l < b0 && (aworldrenderer[l] == null || rendersorter.compare(aworldrenderer[l], worldrenderer) <= 0); ++l) {}
                        if (--l > 0) {
                            int i2 = l;
                            while (--i2 != 0) {
                                aworldrenderer[i2 - 1] = aworldrenderer[i2];
                            }
                            aworldrenderer[l] = worldrenderer;
                        }
                        continue;
                    }
                }
                else if (!worldrenderer.isInFrustum) {
                    continue;
                }
                if (arraylist == null) {
                    arraylist = new ArrayList();
                }
                ++j;
                arraylist.add(worldrenderer);
                this.worldRenderersToUpdate.set(k, null);
            }
        }
        this.theWorld.theProfiler.endSection();
        this.theWorld.theProfiler.startSection("sort");
        if (arraylist != null) {
            if (arraylist.size() > 1) {
                Collections.sort((List<Object>)arraylist, (Comparator<? super Object>)rendersorter);
            }
            for (int k = arraylist.size() - 1; k >= 0; --k) {
                final WorldRenderer worldrenderer = arraylist.get(k);
                worldrenderer.updateRenderer(p_72716_1_);
                worldrenderer.needsUpdate = false;
            }
        }
        this.theWorld.theProfiler.endSection();
        int k = 0;
        this.theWorld.theProfiler.startSection("rebuild");
        for (int k2 = b0 - 1; k2 >= 0; --k2) {
            final WorldRenderer worldrenderer2 = aworldrenderer[k2];
            if (worldrenderer2 != null) {
                if (!worldrenderer2.isInFrustum && k2 != b0 - 1) {
                    aworldrenderer[0] = (aworldrenderer[k2] = null);
                    break;
                }
                aworldrenderer[k2].updateRenderer(p_72716_1_);
                aworldrenderer[k2].needsUpdate = false;
                ++k;
            }
        }
        this.theWorld.theProfiler.endSection();
        this.theWorld.theProfiler.startSection("cleanup");
        int k2 = 0;
        int l = 0;
        for (final int i2 = this.worldRenderersToUpdate.size(); k2 != i2; ++k2) {
            final WorldRenderer worldrenderer3 = this.worldRenderersToUpdate.get(k2);
            if (worldrenderer3 != null) {
                boolean flag1 = false;
                for (int j2 = 0; j2 < b0 && !flag1; ++j2) {
                    if (worldrenderer3 == aworldrenderer[j2]) {
                        flag1 = true;
                    }
                }
                if (!flag1) {
                    if (l != k2) {
                        this.worldRenderersToUpdate.set(l, worldrenderer3);
                    }
                    ++l;
                }
            }
        }
        this.theWorld.theProfiler.endSection();
        this.theWorld.theProfiler.startSection("trim");
        while (--k2 >= l) {
            this.worldRenderersToUpdate.remove(k2);
        }
        this.theWorld.theProfiler.endSection();
        return i == j + k;
    }
    
    public void drawBlockDamageTexture(final Tessellator p_72717_1_, final EntityPlayer p_72717_2_, final float p_72717_3_) {
        this.drawBlockDamageTexture(p_72717_1_, (EntityLivingBase)p_72717_2_, p_72717_3_);
    }
    
    public void drawBlockDamageTexture(final Tessellator p_72717_1_, final EntityLivingBase p_72717_2_, final float p_72717_3_) {
        final double d0 = p_72717_2_.lastTickPosX + (p_72717_2_.posX - p_72717_2_.lastTickPosX) * p_72717_3_;
        final double d2 = p_72717_2_.lastTickPosY + (p_72717_2_.posY - p_72717_2_.lastTickPosY) * p_72717_3_;
        final double d3 = p_72717_2_.lastTickPosZ + (p_72717_2_.posZ - p_72717_2_.lastTickPosZ) * p_72717_3_;
        if (!this.damagedBlocks.isEmpty()) {
            OpenGlHelper.glBlendFunc(774, 768, 1, 0);
            this.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            GL11.glPushMatrix();
            GL11.glPolygonOffset(-3.0f, -3.0f);
            GL11.glEnable(32823);
            GL11.glAlphaFunc(516, 0.1f);
            GL11.glEnable(3008);
            p_72717_1_.startDrawingQuads();
            p_72717_1_.setTranslation(-d0, -d2, -d3);
            p_72717_1_.disableColor();
            final Iterator iterator = this.damagedBlocks.values().iterator();
            while (iterator.hasNext()) {
                final DestroyBlockProgress destroyblockprogress = iterator.next();
                final double d4 = destroyblockprogress.getPartialBlockX() - d0;
                final double d5 = destroyblockprogress.getPartialBlockY() - d2;
                final double d6 = destroyblockprogress.getPartialBlockZ() - d3;
                if (d4 * d4 + d5 * d5 + d6 * d6 > 1024.0) {
                    iterator.remove();
                }
                else {
                    final Block block = this.theWorld.getBlock(destroyblockprogress.getPartialBlockX(), destroyblockprogress.getPartialBlockY(), destroyblockprogress.getPartialBlockZ());
                    if (block.getMaterial() == Material.air) {
                        continue;
                    }
                    this.renderBlocksRg.renderBlockUsingTexture(block, destroyblockprogress.getPartialBlockX(), destroyblockprogress.getPartialBlockY(), destroyblockprogress.getPartialBlockZ(), this.destroyBlockIcons[destroyblockprogress.getPartialBlockDamage()]);
                }
            }
            p_72717_1_.draw();
            p_72717_1_.setTranslation(0.0, 0.0, 0.0);
            GL11.glDisable(3008);
            GL11.glPolygonOffset(0.0f, 0.0f);
            GL11.glDisable(32823);
            GL11.glEnable(3008);
            GL11.glDepthMask(true);
            GL11.glPopMatrix();
        }
    }
    
    public void drawSelectionBox(final EntityPlayer p_72731_1_, final MovingObjectPosition p_72731_2_, final int p_72731_3_, final float p_72731_4_) {
        if (p_72731_3_ == 0 && p_72731_2_.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            GL11.glEnable(3042);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.4f);
            GL11.glLineWidth(2.0f);
            GL11.glDisable(3553);
            GL11.glDepthMask(false);
            final float f1 = 0.002f;
            final Block block = this.theWorld.getBlock(p_72731_2_.blockX, p_72731_2_.blockY, p_72731_2_.blockZ);
            if (block.getMaterial() != Material.air) {
                block.setBlockBoundsBasedOnState((IBlockAccess)this.theWorld, p_72731_2_.blockX, p_72731_2_.blockY, p_72731_2_.blockZ);
                final double d0 = p_72731_1_.lastTickPosX + (p_72731_1_.posX - p_72731_1_.lastTickPosX) * p_72731_4_;
                final double d2 = p_72731_1_.lastTickPosY + (p_72731_1_.posY - p_72731_1_.lastTickPosY) * p_72731_4_;
                final double d3 = p_72731_1_.lastTickPosZ + (p_72731_1_.posZ - p_72731_1_.lastTickPosZ) * p_72731_4_;
                drawOutlinedBoundingBox(block.getSelectedBoundingBoxFromPool((World)this.theWorld, p_72731_2_.blockX, p_72731_2_.blockY, p_72731_2_.blockZ).expand((double)f1, (double)f1, (double)f1).getOffsetBoundingBox(-d0, -d2, -d3), -1);
            }
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
        }
    }
    
    public static void drawOutlinedBoundingBox(final AxisAlignedBB p_147590_0_, final int p_147590_1_) {
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(3);
        if (p_147590_1_ != -1) {
            tessellator.setColorOpaque_I(p_147590_1_);
        }
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.minY, p_147590_0_.minZ);
        tessellator.addVertex(p_147590_0_.maxX, p_147590_0_.minY, p_147590_0_.minZ);
        tessellator.addVertex(p_147590_0_.maxX, p_147590_0_.minY, p_147590_0_.maxZ);
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.minY, p_147590_0_.maxZ);
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.minY, p_147590_0_.minZ);
        tessellator.draw();
        tessellator.startDrawing(3);
        if (p_147590_1_ != -1) {
            tessellator.setColorOpaque_I(p_147590_1_);
        }
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.maxY, p_147590_0_.minZ);
        tessellator.addVertex(p_147590_0_.maxX, p_147590_0_.maxY, p_147590_0_.minZ);
        tessellator.addVertex(p_147590_0_.maxX, p_147590_0_.maxY, p_147590_0_.maxZ);
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.maxY, p_147590_0_.maxZ);
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.maxY, p_147590_0_.minZ);
        tessellator.draw();
        tessellator.startDrawing(1);
        if (p_147590_1_ != -1) {
            tessellator.setColorOpaque_I(p_147590_1_);
        }
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.minY, p_147590_0_.minZ);
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.maxY, p_147590_0_.minZ);
        tessellator.addVertex(p_147590_0_.maxX, p_147590_0_.minY, p_147590_0_.minZ);
        tessellator.addVertex(p_147590_0_.maxX, p_147590_0_.maxY, p_147590_0_.minZ);
        tessellator.addVertex(p_147590_0_.maxX, p_147590_0_.minY, p_147590_0_.maxZ);
        tessellator.addVertex(p_147590_0_.maxX, p_147590_0_.maxY, p_147590_0_.maxZ);
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.minY, p_147590_0_.maxZ);
        tessellator.addVertex(p_147590_0_.minX, p_147590_0_.maxY, p_147590_0_.maxZ);
        tessellator.draw();
    }
    
    public void markBlocksForUpdate(final int p_72725_1_, final int p_72725_2_, final int p_72725_3_, final int p_72725_4_, final int p_72725_5_, final int p_72725_6_) {
        final int k1 = MathHelper.bucketInt(p_72725_1_, 16);
        final int l1 = MathHelper.bucketInt(p_72725_2_, 16);
        final int i2 = MathHelper.bucketInt(p_72725_3_, 16);
        final int j2 = MathHelper.bucketInt(p_72725_4_, 16);
        final int k2 = MathHelper.bucketInt(p_72725_5_, 16);
        final int l2 = MathHelper.bucketInt(p_72725_6_, 16);
        for (int i3 = k1; i3 <= j2; ++i3) {
            int j3 = i3 % this.renderChunksWide;
            if (j3 < 0) {
                j3 += this.renderChunksWide;
            }
            for (int k3 = l1; k3 <= k2; ++k3) {
                int l3 = k3 % this.renderChunksTall;
                if (l3 < 0) {
                    l3 += this.renderChunksTall;
                }
                for (int i4 = i2; i4 <= l2; ++i4) {
                    int j4 = i4 % this.renderChunksDeep;
                    if (j4 < 0) {
                        j4 += this.renderChunksDeep;
                    }
                    final int k4 = (j4 * this.renderChunksTall + l3) * this.renderChunksWide + j3;
                    final WorldRenderer worldrenderer = this.worldRenderers[k4];
                    if (worldrenderer != null && !worldrenderer.needsUpdate) {
                        this.worldRenderersToUpdate.add(worldrenderer);
                        worldrenderer.markDirty();
                    }
                }
            }
        }
    }
    
    public void markBlockForUpdate(final int p_147586_1_, final int p_147586_2_, final int p_147586_3_) {
        this.markBlocksForUpdate(p_147586_1_ - 1, p_147586_2_ - 1, p_147586_3_ - 1, p_147586_1_ + 1, p_147586_2_ + 1, p_147586_3_ + 1);
    }
    
    public void markBlockForRenderUpdate(final int p_147588_1_, final int p_147588_2_, final int p_147588_3_) {
        this.markBlocksForUpdate(p_147588_1_ - 1, p_147588_2_ - 1, p_147588_3_ - 1, p_147588_1_ + 1, p_147588_2_ + 1, p_147588_3_ + 1);
    }
    
    public void markBlockRangeForRenderUpdate(final int p_147585_1_, final int p_147585_2_, final int p_147585_3_, final int p_147585_4_, final int p_147585_5_, final int p_147585_6_) {
        this.markBlocksForUpdate(p_147585_1_ - 1, p_147585_2_ - 1, p_147585_3_ - 1, p_147585_4_ + 1, p_147585_5_ + 1, p_147585_6_ + 1);
    }
    
    public void clipRenderersByFrustum(final ICamera p_72729_1_, final float p_72729_2_) {
        for (int i = 0; i < this.worldRenderers.length; ++i) {
            if (!this.worldRenderers[i].skipAllRenderPasses() && (!this.worldRenderers[i].isInFrustum || (i + this.frustumCheckOffset & 0xF) == 0x0)) {
                this.worldRenderers[i].updateInFrustum(p_72729_1_);
            }
        }
        ++this.frustumCheckOffset;
    }
    
    public void playRecord(final String p_72702_1_, final int p_72702_2_, final int p_72702_3_, final int p_72702_4_) {
        final ChunkCoordinates chunkcoordinates = new ChunkCoordinates(p_72702_2_, p_72702_3_, p_72702_4_);
        final ISound isound = this.mapSoundPositions.get(chunkcoordinates);
        if (isound != null) {
            this.mc.getSoundHandler().stopSound(isound);
            this.mapSoundPositions.remove(chunkcoordinates);
        }
        if (p_72702_1_ != null) {
            final ItemRecord itemrecord = ItemRecord.getRecord(p_72702_1_);
            ResourceLocation resource = null;
            if (itemrecord != null) {
                this.mc.ingameGUI.setRecordPlayingMessage(itemrecord.getRecordNameLocal());
                resource = itemrecord.getRecordResource(p_72702_1_);
            }
            if (resource == null) {
                resource = new ResourceLocation(p_72702_1_);
            }
            final PositionedSoundRecord positionedsoundrecord = PositionedSoundRecord.func_147675_a(resource, (float)p_72702_2_, (float)p_72702_3_, (float)p_72702_4_);
            this.mapSoundPositions.put(chunkcoordinates, positionedsoundrecord);
            this.mc.getSoundHandler().playSound((ISound)positionedsoundrecord);
        }
    }
    
    public void playSound(final String p_72704_1_, final double p_72704_2_, final double p_72704_4_, final double p_72704_6_, final float p_72704_8_, final float p_72704_9_) {
    }
    
    public void playSoundToNearExcept(final EntityPlayer p_85102_1_, final String p_85102_2_, final double p_85102_3_, final double p_85102_5_, final double p_85102_7_, final float p_85102_9_, final float p_85102_10_) {
    }

    public void spawnParticle(final String p_72708_1_, final double p_72708_2_, final double p_72708_4_, final double p_72708_6_, final double p_72708_8_, final double p_72708_10_, final double p_72708_12_) {
        try {
            this.doSpawnParticle(p_72708_1_, p_72708_2_, p_72708_4_, p_72708_6_, p_72708_8_, p_72708_10_, p_72708_12_);
        } catch (final Throwable throwable) {
            final CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Exception while adding particle");
            final CrashReportCategory crashreportcategory = crashreport.makeCategory("Particle being added");
            crashreportcategory.addCrashSection("Name", (Object) p_72708_1_);

            // Modify the anonymous class constructor to accept parameters
            crashreportcategory.addCrashSectionCallable("Position", new Callable<String>() {
                private static final String __OBFID = "CL_00000955";

                @Override
                public String call() {
                    return CrashReportCategory.func_85074_a(p_72708_2_, p_72708_4_, p_72708_6_);
                }
            });

            throw new ReportedException(crashreport);
        }
    }


    public EntityFX doSpawnParticle(final String p_72726_1_, final double p_72726_2_, final double p_72726_4_, final double p_72726_6_, final double p_72726_8_, final double p_72726_10_, final double p_72726_12_) {
        if (this.mc == null || this.mc.renderViewEntity == null || this.mc.effectRenderer == null) {
            return null;
        }
        int i = this.mc.gameSettings.particleSetting;
        if (i == 1 && this.theWorld.rand.nextInt(3) == 0) {
            i = 2;
        }
        final double d6 = this.mc.renderViewEntity.posX - p_72726_2_;
        final double d7 = this.mc.renderViewEntity.posY - p_72726_4_;
        final double d8 = this.mc.renderViewEntity.posZ - p_72726_6_;
        EntityFX entityfx = null;
        if (p_72726_1_.equals("hugeexplosion")) {
            this.mc.effectRenderer.addEffect(entityfx = (EntityFX)new EntityHugeExplodeFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_));
        }
        else if (p_72726_1_.equals("largeexplode")) {
            this.mc.effectRenderer.addEffect(entityfx = (EntityFX)new EntityLargeExplodeFX(this.renderEngine, (World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_));
        }
        else if (p_72726_1_.equals("fireworksSpark")) {
            this.mc.effectRenderer.addEffect(entityfx = (EntityFX)new EntityFireworkSparkFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, this.mc.effectRenderer));
        }
        if (entityfx != null) {
            return entityfx;
        }
        final double d9 = 16.0;
        if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9) {
            return null;
        }
        if (i > 1) {
            return null;
        }
        if (p_72726_1_.equals("bubble")) {
            entityfx = (EntityFX)new EntityBubbleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("suspended")) {
            entityfx = (EntityFX)new EntitySuspendFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("depthsuspend")) {
            entityfx = (EntityFX)new EntityAuraFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("townaura")) {
            entityfx = (EntityFX)new EntityAuraFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("crit")) {
            entityfx = (EntityFX)new EntityCritFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("magicCrit")) {
            entityfx = (EntityFX)new EntityCritFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
            entityfx.setRBGColorF(entityfx.getRedColorF() * 0.3f, entityfx.getGreenColorF() * 0.8f, entityfx.getBlueColorF());
            entityfx.nextTextureIndexX();
        }
        else if (p_72726_1_.equals("smoke")) {
            entityfx = (EntityFX)new EntitySmokeFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("mobSpell")) {
            entityfx = (EntityFX)new EntitySpellParticleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, 0.0, 0.0, 0.0);
            entityfx.setRBGColorF((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
        }
        else if (p_72726_1_.equals("mobSpellAmbient")) {
            entityfx = (EntityFX)new EntitySpellParticleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, 0.0, 0.0, 0.0);
            entityfx.setAlphaF(0.15f);
            entityfx.setRBGColorF((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
        }
        else if (p_72726_1_.equals("spell")) {
            entityfx = (EntityFX)new EntitySpellParticleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("instantSpell")) {
            entityfx = (EntityFX)new EntitySpellParticleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
            ((EntitySpellParticleFX)entityfx).setBaseSpellTextureIndex(144);
        }
        else if (p_72726_1_.equals("witchMagic")) {
            entityfx = (EntityFX)new EntitySpellParticleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
            ((EntitySpellParticleFX)entityfx).setBaseSpellTextureIndex(144);
            final float f = this.theWorld.rand.nextFloat() * 0.5f + 0.35f;
            entityfx.setRBGColorF(1.0f * f, 0.0f * f, 1.0f * f);
        }
        else if (p_72726_1_.equals("note")) {
            entityfx = (EntityFX)new EntityNoteFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("portal")) {
            entityfx = (EntityFX)new EntityPortalFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("enchantmenttable")) {
            entityfx = (EntityFX)new EntityEnchantmentTableParticleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("explode")) {
            entityfx = (EntityFX)new EntityExplodeFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("flame")) {
            entityfx = (EntityFX)new EntityFlameFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("lava")) {
            entityfx = (EntityFX)new EntityLavaFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_);
        }
        else if (p_72726_1_.equals("footstep")) {
            entityfx = (EntityFX)new EntityFootStepFX(this.renderEngine, (World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_);
        }
        else if (p_72726_1_.equals("splash")) {
            entityfx = (EntityFX)new EntitySplashFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("wake")) {
            entityfx = (EntityFX)new EntityFishWakeFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("largesmoke")) {
            entityfx = (EntityFX)new EntitySmokeFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, 2.5f);
        }
        else if (p_72726_1_.equals("cloud")) {
            entityfx = (EntityFX)new EntityCloudFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("reddust")) {
            entityfx = (EntityFX)new EntityReddustFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, (float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
        }
        else if (p_72726_1_.equals("snowballpoof")) {
            entityfx = (EntityFX)new EntityBreakingFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, Items.snowball);
        }
        else if (p_72726_1_.equals("dripWater")) {
            entityfx = (EntityFX)new EntityDropParticleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, Material.water);
        }
        else if (p_72726_1_.equals("dripLava")) {
            entityfx = (EntityFX)new EntityDropParticleFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, Material.lava);
        }
        else if (p_72726_1_.equals("snowshovel")) {
            entityfx = (EntityFX)new EntitySnowShovelFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("slime")) {
            entityfx = (EntityFX)new EntityBreakingFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, Items.slime_ball);
        }
        else if (p_72726_1_.equals("heart")) {
            entityfx = (EntityFX)new EntityHeartFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        }
        else if (p_72726_1_.equals("angryVillager")) {
            entityfx = (EntityFX)new EntityHeartFX((World)this.theWorld, p_72726_2_, p_72726_4_ + 0.5, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
            entityfx.setParticleTextureIndex(81);
            entityfx.setRBGColorF(1.0f, 1.0f, 1.0f);
        }
        else if (p_72726_1_.equals("happyVillager")) {
            entityfx = (EntityFX)new EntityAuraFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
            entityfx.setParticleTextureIndex(82);
            entityfx.setRBGColorF(1.0f, 1.0f, 1.0f);
        }
        else if (p_72726_1_.startsWith("iconcrack_")) {
            final String[] astring = p_72726_1_.split("_", 3);
            final int j = Integer.parseInt(astring[1]);
            if (astring.length > 2) {
                final int k = Integer.parseInt(astring[2]);
                entityfx = (EntityFX)new EntityBreakingFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.getItemById(j), k);
            }
            else {
                entityfx = (EntityFX)new EntityBreakingFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.getItemById(j), 0);
            }
        }
        else if (p_72726_1_.startsWith("blockcrack_")) {
            final String[] astring = p_72726_1_.split("_", 3);
            final Block block = Block.getBlockById(Integer.parseInt(astring[1]));
            final int k = Integer.parseInt(astring[2]);
            entityfx = (EntityFX)new EntityDiggingFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, k).applyRenderColor(k);
        }
        else if (p_72726_1_.startsWith("blockdust_")) {
            final String[] astring = p_72726_1_.split("_", 3);
            final Block block = Block.getBlockById(Integer.parseInt(astring[1]));
            final int k = Integer.parseInt(astring[2]);
            entityfx = (EntityFX)new EntityBlockDustFX((World)this.theWorld, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, k).applyRenderColor(k);
        }
        if (entityfx != null) {
            this.mc.effectRenderer.addEffect(entityfx);
        }
        return entityfx;
    }
    
    public void onEntityCreate(final Entity p_72703_1_) {
    }
    
    public void onEntityDestroy(final Entity p_72709_1_) {
    }
    
    public void deleteAllDisplayLists() {
        GLAllocation.deleteDisplayLists(this.glRenderListBase);
    }
    
    public void broadcastSound(final int p_82746_1_, final int p_82746_2_, final int p_82746_3_, final int p_82746_4_, final int p_82746_5_) {
        final Random random = this.theWorld.rand;
        switch (p_82746_1_) {
            case 1013:
            case 1018: {
                if (this.mc.renderViewEntity == null) {
                    break;
                }
                final double d0 = p_82746_2_ - this.mc.renderViewEntity.posX;
                final double d2 = p_82746_3_ - this.mc.renderViewEntity.posY;
                final double d3 = p_82746_4_ - this.mc.renderViewEntity.posZ;
                final double d4 = Math.sqrt(d0 * d0 + d2 * d2 + d3 * d3);
                double d5 = this.mc.renderViewEntity.posX;
                double d6 = this.mc.renderViewEntity.posY;
                double d7 = this.mc.renderViewEntity.posZ;
                if (d4 > 0.0) {
                    d5 += d0 / d4 * 2.0;
                    d6 += d2 / d4 * 2.0;
                    d7 += d3 / d4 * 2.0;
                }
                if (p_82746_1_ == 1013) {
                    this.theWorld.playSound(d5, d6, d7, "mob.wither.spawn", 1.0f, 1.0f, false);
                    break;
                }
                if (p_82746_1_ == 1018) {
                    this.theWorld.playSound(d5, d6, d7, "mob.enderdragon.end", 5.0f, 1.0f, false);
                    break;
                }
                break;
            }
        }
    }
    
    public void playAuxSFX(final EntityPlayer p_72706_1_, final int p_72706_2_, final int p_72706_3_, final int p_72706_4_, final int p_72706_5_, final int p_72706_6_) {
        final Random random = this.theWorld.rand;
        Block block = null;
        switch (p_72706_2_) {
            case 1000: {
                this.theWorld.playSound((double)p_72706_3_, (double)p_72706_4_, (double)p_72706_5_, "random.click", 1.0f, 1.0f, false);
                break;
            }
            case 1001: {
                this.theWorld.playSound((double)p_72706_3_, (double)p_72706_4_, (double)p_72706_5_, "random.click", 1.0f, 1.2f, false);
                break;
            }
            case 1002: {
                this.theWorld.playSound((double)p_72706_3_, (double)p_72706_4_, (double)p_72706_5_, "random.bow", 1.0f, 1.2f, false);
                break;
            }
            case 1003: {
                if (Math.random() < 0.5) {
                    this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "random.door_open", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                    break;
                }
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "random.door_close", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1004: {
                this.theWorld.playSound((double)(p_72706_3_ + 0.5f), (double)(p_72706_4_ + 0.5f), (double)(p_72706_5_ + 0.5f), "random.fizz", 0.5f, 2.6f + (random.nextFloat() - random.nextFloat()) * 0.8f, false);
                break;
            }
            case 1005: {
                if (Item.getItemById(p_72706_6_) instanceof ItemRecord) {
                    this.theWorld.playRecord("records." + ((ItemRecord)Item.getItemById(p_72706_6_)).recordName, p_72706_3_, p_72706_4_, p_72706_5_);
                    break;
                }
                this.theWorld.playRecord((String)null, p_72706_3_, p_72706_4_, p_72706_5_);
                break;
            }
            case 1007: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.ghast.charge", 10.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1008: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.ghast.fireball", 10.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1009: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.ghast.fireball", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1010: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.zombie.wood", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1011: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.zombie.metal", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1012: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.zombie.woodbreak", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1014: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.wither.shoot", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1015: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.bat.takeoff", 0.05f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1016: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.zombie.infect", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1017: {
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "mob.zombie.unfect", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1020: {
                this.theWorld.playSound((double)(p_72706_3_ + 0.5f), (double)(p_72706_4_ + 0.5f), (double)(p_72706_5_ + 0.5f), "random.anvil_break", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1021: {
                this.theWorld.playSound((double)(p_72706_3_ + 0.5f), (double)(p_72706_4_ + 0.5f), (double)(p_72706_5_ + 0.5f), "random.anvil_use", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1022: {
                this.theWorld.playSound((double)(p_72706_3_ + 0.5f), (double)(p_72706_4_ + 0.5f), (double)(p_72706_5_ + 0.5f), "random.anvil_land", 0.3f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2000: {
                final int j2 = p_72706_6_ % 3 - 1;
                final int j3 = p_72706_6_ / 3 % 3 - 1;
                final double d1 = p_72706_3_ + j2 * 0.6 + 0.5;
                final double d2 = p_72706_4_ + 0.5;
                final double d3 = p_72706_5_ + j3 * 0.6 + 0.5;
                for (int k2 = 0; k2 < 10; ++k2) {
                    final double d4 = random.nextDouble() * 0.2 + 0.01;
                    final double d5 = d1 + j2 * 0.01 + (random.nextDouble() - 0.5) * j3 * 0.5;
                    final double d6 = d2 + (random.nextDouble() - 0.5) * 0.5;
                    final double d7 = d3 + j3 * 0.01 + (random.nextDouble() - 0.5) * j2 * 0.5;
                    final double d8 = j2 * d4 + random.nextGaussian() * 0.01;
                    final double d9 = -0.03 + random.nextGaussian() * 0.01;
                    final double d10 = j3 * d4 + random.nextGaussian() * 0.01;
                    this.spawnParticle("smoke", d5, d6, d7, d8, d9, d10);
                }
                return;
            }
            case 2001: {
                block = Block.getBlockById(p_72706_6_ & 0xFFF);
                if (block.getMaterial() != Material.air) {
                    this.mc.getSoundHandler().playSound((ISound)new PositionedSoundRecord(new ResourceLocation(block.stepSound.getBreakSound()), (block.stepSound.getVolume() + 1.0f) / 2.0f, block.stepSound.getPitch() * 0.8f, p_72706_3_ + 0.5f, p_72706_4_ + 0.5f, p_72706_5_ + 0.5f));
                }
                this.mc.effectRenderer.addBlockDestroyEffects(p_72706_3_, p_72706_4_, p_72706_5_, block, p_72706_6_ >> 12 & 0xFF);
                break;
            }
            case 2002: {
                final double d11 = p_72706_3_;
                final double d1 = p_72706_4_;
                final double d2 = p_72706_5_;
                final String s = "iconcrack_" + Item.getIdFromItem((Item)Items.potionitem) + "_" + p_72706_6_;
                for (int k3 = 0; k3 < 8; ++k3) {
                    this.spawnParticle(s, d11, d1, d2, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
                }
                int k3 = Items.potionitem.getColorFromDamage(p_72706_6_);
                final float f = (k3 >> 16 & 0xFF) / 255.0f;
                final float f2 = (k3 >> 8 & 0xFF) / 255.0f;
                final float f3 = (k3 >> 0 & 0xFF) / 255.0f;
                String s2 = "spell";
                if (Items.potionitem.isEffectInstant(p_72706_6_)) {
                    s2 = "instantSpell";
                }
                for (int l2 = 0; l2 < 100; ++l2) {
                    final double d6 = random.nextDouble() * 4.0;
                    final double d7 = random.nextDouble() * 3.141592653589793 * 2.0;
                    final double d8 = Math.cos(d7) * d6;
                    final double d9 = 0.01 + random.nextDouble() * 0.5;
                    final double d10 = Math.sin(d7) * d6;
                    final EntityFX entityfx = this.doSpawnParticle(s2, d11 + d8 * 0.1, d1 + 0.3, d2 + d10 * 0.1, d8, d9, d10);
                    if (entityfx != null) {
                        final float f4 = 0.75f + random.nextFloat() * 0.25f;
                        entityfx.setRBGColorF(f * f4, f2 * f4, f3 * f4);
                        entityfx.multiplyVelocity((float)d6);
                    }
                }
                this.theWorld.playSound(p_72706_3_ + 0.5, p_72706_4_ + 0.5, p_72706_5_ + 0.5, "game.potion.smash", 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2003: {
                final double d11 = p_72706_3_ + 0.5;
                final double d1 = p_72706_4_;
                final double d2 = p_72706_5_ + 0.5;
                final String s = "iconcrack_" + Item.getIdFromItem(Items.ender_eye);
                for (int k3 = 0; k3 < 8; ++k3) {
                    this.spawnParticle(s, d11, d1, d2, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
                }
                for (double d12 = 0.0; d12 < 6.283185307179586; d12 += 0.15707963267948966) {
                    this.spawnParticle("portal", d11 + Math.cos(d12) * 5.0, d1 - 0.4, d2 + Math.sin(d12) * 5.0, Math.cos(d12) * -5.0, 0.0, Math.sin(d12) * -5.0);
                    this.spawnParticle("portal", d11 + Math.cos(d12) * 5.0, d1 - 0.4, d2 + Math.sin(d12) * 5.0, Math.cos(d12) * -7.0, 0.0, Math.sin(d12) * -7.0);
                }
                return;
            }
            case 2004: {
                for (int l2 = 0; l2 < 20; ++l2) {
                    final double d6 = p_72706_3_ + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    final double d7 = p_72706_4_ + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    final double d8 = p_72706_5_ + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    this.theWorld.spawnParticle("smoke", d6, d7, d8, 0.0, 0.0, 0.0);
                    this.theWorld.spawnParticle("flame", d6, d7, d8, 0.0, 0.0, 0.0);
                }
                return;
            }
            case 2005: {
                ItemDye.func_150918_a((World)this.theWorld, p_72706_3_, p_72706_4_, p_72706_5_, p_72706_6_);
                break;
            }
            case 2006: {
                block = this.theWorld.getBlock(p_72706_3_, p_72706_4_, p_72706_5_);
                if (block.getMaterial() != Material.air) {
                    double d13 = Math.min(0.2f + p_72706_6_ / 15.0f, 10.0f);
                    if (d13 > 2.5) {
                        d13 = 2.5;
                    }
                    for (int l3 = (int)(150.0 * d13), i2 = 0; i2 < l3; ++i2) {
                        final float f5 = MathHelper.randomFloatClamp(random, 0.0f, 6.2831855f);
                        final double d8 = MathHelper.randomFloatClamp(random, 0.75f, 1.0f);
                        final double d9 = 0.20000000298023224 + d13 / 100.0;
                        final double d10 = MathHelper.cos(f5) * 0.2f * d8 * d8 * (d13 + 0.2);
                        final double d14 = MathHelper.sin(f5) * 0.2f * d8 * d8 * (d13 + 0.2);
                        this.theWorld.spawnParticle("blockdust_" + Block.getIdFromBlock(block) + "_" + this.theWorld.getBlockMetadata(p_72706_3_, p_72706_4_, p_72706_5_), (double)(p_72706_3_ + 0.5f), (double)(p_72706_4_ + 1.0f), (double)(p_72706_5_ + 0.5f), d10, d9, d14);
                    }
                    break;
                }
                break;
            }
        }
    }
    
    public void destroyBlockPartially(final int p_147587_1_, final int p_147587_2_, final int p_147587_3_, final int p_147587_4_, final int p_147587_5_) {
        if (p_147587_5_ >= 0 && p_147587_5_ < 10) {
            DestroyBlockProgress destroyblockprogress = this.damagedBlocks.get(p_147587_1_);
            if (destroyblockprogress == null || destroyblockprogress.getPartialBlockX() != p_147587_2_ || destroyblockprogress.getPartialBlockY() != p_147587_3_ || destroyblockprogress.getPartialBlockZ() != p_147587_4_) {
                destroyblockprogress = new DestroyBlockProgress(p_147587_1_, p_147587_2_, p_147587_3_, p_147587_4_);
                this.damagedBlocks.put(p_147587_1_, destroyblockprogress);
            }
            destroyblockprogress.setPartialBlockDamage(p_147587_5_);
            destroyblockprogress.setCloudUpdateTick(this.cloudTickCounter);
        }
        else {
            this.damagedBlocks.remove(p_147587_1_);
        }
    }
    
    public void registerDestroyBlockIcons(final IIconRegister p_94140_1_) {
        this.destroyBlockIcons = new IIcon[10];
        for (int i = 0; i < this.destroyBlockIcons.length; ++i) {
            this.destroyBlockIcons[i] = p_94140_1_.registerIcon("destroy_stage_" + i);
        }
    }
    
    static {
        logger = LogManager.getLogger();
        locationMoonPhasesPng = new ResourceLocation("textures/environment/moon_phases.png");
        locationSunPng = new ResourceLocation("textures/environment/sun.png");
        locationCloudsPng = new ResourceLocation("textures/environment/clouds.png");
        locationEndSkyPng = new ResourceLocation("textures/environment/end_sky.png");
    }
}
