package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.world.gen.feature.*;

public abstract class CompatibleWorldGenerator implements IWorldGenerator
{
    public CompatibleWorldGenerator() {
        super();
    }
    
    public void generate(final Block block, final int maxVeinSize, final CompatibleBlocks target, final World world, final Random random, final int posX, final int posY, final int posZ) {
        new WorldGenMinable(block, 0, maxVeinSize, target.getBlock()).generate(world, random, posX, posY, posZ);
    }
}
