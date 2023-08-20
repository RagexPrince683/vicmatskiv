package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.relauncher.*;
import java.nio.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;

@SideOnly(Side.CLIENT)
public class CompatibleActiveRenderInfo
{
    public static float objectX;
    public static float objectY;
    public static float objectZ;
    private static IntBuffer viewport;
    private static FloatBuffer modelview;
    private static FloatBuffer projection;
    private static FloatBuffer objectCoords;
    public static float rotationX;
    public static float rotationXZ;
    public static float rotationZ;
    public static float rotationYZ;
    public static float rotationXY;
    private static final String __OBFID = "CL_00000626";
    
    public CompatibleActiveRenderInfo() {
        super();
    }
    
    public static void updateRenderInfo(final EntityLivingBase p_74583_0_, final boolean p_74583_1_) {
        GL11.glGetFloat(2982, CompatibleActiveRenderInfo.modelview);
        GL11.glGetFloat(2983, CompatibleActiveRenderInfo.projection);
        GL11.glGetInteger(2978, CompatibleActiveRenderInfo.viewport);
        final float f = (float)((CompatibleActiveRenderInfo.viewport.get(0) + CompatibleActiveRenderInfo.viewport.get(2)) / 2);
        final float f2 = (float)((CompatibleActiveRenderInfo.viewport.get(1) + CompatibleActiveRenderInfo.viewport.get(3)) / 2);
        GLU.gluUnProject(f, f2, 0.0f, CompatibleActiveRenderInfo.modelview, CompatibleActiveRenderInfo.projection, CompatibleActiveRenderInfo.viewport, CompatibleActiveRenderInfo.objectCoords);
        CompatibleActiveRenderInfo.objectX = CompatibleActiveRenderInfo.objectCoords.get(0);
        CompatibleActiveRenderInfo.objectY = CompatibleActiveRenderInfo.objectCoords.get(1);
        CompatibleActiveRenderInfo.objectZ = CompatibleActiveRenderInfo.objectCoords.get(2);
        final int i = p_74583_1_ ? 1 : 0;
        final float f3 = p_74583_0_.rotationPitch;
        final float f4 = p_74583_0_.rotationYaw;
        CompatibleActiveRenderInfo.rotationX = MathHelper.cos(f4 * 3.1415927f / 180.0f) * (1 - i * 2);
        CompatibleActiveRenderInfo.rotationZ = MathHelper.sin(f4 * 3.1415927f / 180.0f) * (1 - i * 2);
        CompatibleActiveRenderInfo.rotationYZ = -CompatibleActiveRenderInfo.rotationZ * MathHelper.sin(f3 * 3.1415927f / 180.0f) * (1 - i * 2);
        CompatibleActiveRenderInfo.rotationXY = CompatibleActiveRenderInfo.rotationX * MathHelper.sin(f3 * 3.1415927f / 180.0f) * (1 - i * 2);
        CompatibleActiveRenderInfo.rotationXZ = MathHelper.cos(f3 * 3.1415927f / 180.0f);
    }
    
    public static Vec3 projectViewFromEntity(final EntityLivingBase p_74585_0_, final double p_74585_1_) {
        final double d1 = p_74585_0_.prevPosX + (p_74585_0_.posX - p_74585_0_.prevPosX) * p_74585_1_;
        final double d2 = p_74585_0_.prevPosY + (p_74585_0_.posY - p_74585_0_.prevPosY) * p_74585_1_ + p_74585_0_.getEyeHeight();
        final double d3 = p_74585_0_.prevPosZ + (p_74585_0_.posZ - p_74585_0_.prevPosZ) * p_74585_1_;
        final double d4 = d1 + CompatibleActiveRenderInfo.objectX * 1.0f;
        final double d5 = d2 + CompatibleActiveRenderInfo.objectY * 1.0f;
        final double d6 = d3 + CompatibleActiveRenderInfo.objectZ * 1.0f;
        return Vec3.createVectorHelper(d4, d5, d6);
    }
    
    public static Block getBlockAtEntityViewpoint(final World p_151460_0_, final EntityLivingBase p_151460_1_, final float p_151460_2_) {
        final Vec3 vec3 = projectViewFromEntity(p_151460_1_, p_151460_2_);
        final ChunkPosition chunkposition = new ChunkPosition(vec3);
        Block block = p_151460_0_.getBlock(chunkposition.chunkPosX, chunkposition.chunkPosY, chunkposition.chunkPosZ);
        if (block.getMaterial().isLiquid()) {
            final float f1 = BlockLiquid.getLiquidHeightPercent(p_151460_0_.getBlockMetadata(chunkposition.chunkPosX, chunkposition.chunkPosY, chunkposition.chunkPosZ)) - 0.11111111f;
            final float f2 = chunkposition.chunkPosY + 1 - f1;
            if (vec3.yCoord >= f2) {
                block = p_151460_0_.getBlock(chunkposition.chunkPosX, chunkposition.chunkPosY + 1, chunkposition.chunkPosZ);
            }
        }
        return block;
    }
    
    static {
        CompatibleActiveRenderInfo.viewport = GLAllocation.createDirectIntBuffer(16);
        CompatibleActiveRenderInfo.modelview = GLAllocation.createDirectFloatBuffer(16);
        CompatibleActiveRenderInfo.projection = GLAllocation.createDirectFloatBuffer(16);
        CompatibleActiveRenderInfo.objectCoords = GLAllocation.createDirectFloatBuffer(3);
    }
}
