package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.world.*;
import java.util.function.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class CompatibleRayTracing
{
    public CompatibleRayTracing() {
        super();
    }
    
    public static CompatibleRayTraceResult rayTraceBlocks(final World world, final CompatibleVec3 cvec1, final CompatibleVec3 cvec2, final BiPredicate<Block, CompatibleBlockState> isCollidable) {
        final Vec3 vec1 = cvec1.getVec();
        final Vec3 vec2 = cvec2.getVec();
        final boolean ignoreBlockWithoutBoundingBox = false;
        final boolean returnLastUncollidableBlock = false;
        if (Double.isNaN(vec1.xCoord) || Double.isNaN(vec1.yCoord) || Double.isNaN(vec1.zCoord)) {
            return null;
        }
        if (!Double.isNaN(vec2.xCoord) && !Double.isNaN(vec2.yCoord) && !Double.isNaN(vec2.zCoord)) {
            final int i = MathHelper.floor_double(vec2.xCoord);
            final int j = MathHelper.floor_double(vec2.yCoord);
            final int k = MathHelper.floor_double(vec2.zCoord);
            int l = MathHelper.floor_double(vec1.xCoord);
            int i2 = MathHelper.floor_double(vec1.yCoord);
            int j2 = MathHelper.floor_double(vec1.zCoord);
            final Block block = world.getBlock(l, i2, j2);
            int blockMetadata = world.getBlockMetadata(l, i2, j2);
            if ((!ignoreBlockWithoutBoundingBox || block.getCollisionBoundingBoxFromPool(world, l, i2, j2) != null) && isCollidable.test(block, new CompatibleBlockState(block, blockMetadata))) {
                final MovingObjectPosition movingobjectposition = block.collisionRayTrace(world, l, i2, j2, vec1, vec2);
                if (movingobjectposition != null) {
                    return CompatibleRayTraceResult.fromMovingObjectPosition(movingobjectposition);
                }
            }
            MovingObjectPosition movingobjectposition2 = null;
            blockMetadata = 200;
            while (blockMetadata-- >= 0) {
                if (Double.isNaN(vec1.xCoord) || Double.isNaN(vec1.yCoord) || Double.isNaN(vec1.zCoord)) {
                    return null;
                }
                if (l == i && i2 == j && j2 == k) {
                    return returnLastUncollidableBlock ? CompatibleRayTraceResult.fromMovingObjectPosition(movingobjectposition2) : null;
                }
                boolean flag6 = true;
                boolean flag7 = true;
                boolean flag8 = true;
                double d0 = 999.0;
                double d2 = 999.0;
                double d3 = 999.0;
                if (i > l) {
                    d0 = l + 1.0;
                }
                else if (i < l) {
                    d0 = l + 0.0;
                }
                else {
                    flag6 = false;
                }
                if (j > i2) {
                    d2 = i2 + 1.0;
                }
                else if (j < i2) {
                    d2 = i2 + 0.0;
                }
                else {
                    flag7 = false;
                }
                if (k > j2) {
                    d3 = j2 + 1.0;
                }
                else if (k < j2) {
                    d3 = j2 + 0.0;
                }
                else {
                    flag8 = false;
                }
                double d4 = 999.0;
                double d5 = 999.0;
                double d6 = 999.0;
                final double d7 = vec2.xCoord - vec1.xCoord;
                final double d8 = vec2.yCoord - vec1.yCoord;
                final double d9 = vec2.zCoord - vec1.zCoord;
                if (flag6) {
                    d4 = (d0 - vec1.xCoord) / d7;
                }
                if (flag7) {
                    d5 = (d2 - vec1.yCoord) / d8;
                }
                if (flag8) {
                    d6 = (d3 - vec1.zCoord) / d9;
                }
                byte b0;
                if (d4 < d5 && d4 < d6) {
                    if (i > l) {
                        b0 = 4;
                    }
                    else {
                        b0 = 5;
                    }
                    vec1.xCoord = d0;
                    final Vec3 vec4 = vec1;
                    vec4.yCoord += d8 * d4;
                    final Vec3 vec5 = vec1;
                    vec5.zCoord += d9 * d4;
                }
                else if (d5 < d6) {
                    if (j > i2) {
                        b0 = 0;
                    }
                    else {
                        b0 = 1;
                    }
                    final Vec3 vec6 = vec1;
                    vec6.xCoord += d7 * d5;
                    vec1.yCoord = d2;
                    final Vec3 vec7 = vec1;
                    vec7.zCoord += d9 * d5;
                }
                else {
                    if (k > j2) {
                        b0 = 2;
                    }
                    else {
                        b0 = 3;
                    }
                    final Vec3 vec8 = vec1;
                    vec8.xCoord += d7 * d6;
                    final Vec3 vec9 = vec1;
                    vec9.yCoord += d8 * d6;
                    vec1.zCoord = d3;
                }
                final Vec3 vectorHelper;
                final Vec3 vec3 = vectorHelper = Vec3.createVectorHelper(vec1.xCoord, vec1.yCoord, vec1.zCoord);
                final double xCoord = MathHelper.floor_double(vec1.xCoord);
                vectorHelper.xCoord = xCoord;
                l = (int)xCoord;
                if (b0 == 5) {
                    --l;
                    final Vec3 vec10 = vec3;
                    ++vec10.xCoord;
                }
                final Vec3 vec11 = vec3;
                final double yCoord = MathHelper.floor_double(vec1.yCoord);
                vec11.yCoord = yCoord;
                i2 = (int)yCoord;
                if (b0 == 1) {
                    --i2;
                    final Vec3 vec12 = vec3;
                    ++vec12.yCoord;
                }
                final Vec3 vec13 = vec3;
                final double zCoord = MathHelper.floor_double(vec1.zCoord);
                vec13.zCoord = zCoord;
                j2 = (int)zCoord;
                if (b0 == 3) {
                    --j2;
                    final Vec3 vec14 = vec3;
                    ++vec14.zCoord;
                }
                final Block block2 = world.getBlock(l, i2, j2);
                final int block1Metadata = world.getBlockMetadata(l, i2, j2);
                if (ignoreBlockWithoutBoundingBox && block2.getCollisionBoundingBoxFromPool(world, l, i2, j2) == null) {
                    continue;
                }
                if (isCollidable.test(block2, new CompatibleBlockState(block2, block1Metadata))) {
                    final MovingObjectPosition movingobjectposition3 = block2.collisionRayTrace(world, l, i2, j2, vec1, vec2);
                    if (movingobjectposition3 != null) {
                        return CompatibleRayTraceResult.fromMovingObjectPosition(movingobjectposition3);
                    }
                    continue;
                }
                else {
                    movingobjectposition2 = new MovingObjectPosition(l, i2, j2, (int)b0, vec1, false);
                }
            }
            return returnLastUncollidableBlock ? CompatibleRayTraceResult.fromMovingObjectPosition(movingobjectposition2) : null;
        }
        return null;
    }
}
