package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.config.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.block.*;

public class WorldGeneratorEventHandler extends CompatibleWorldGenerator
{
    private ConfigurationManager configurationManager;
    
    public WorldGeneratorEventHandler(final ConfigurationManager configurationManager) {
        super();
        this.configurationManager = configurationManager;
    }
    
    public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1: {
                this.generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 0: {
                this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 1: {
                this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
        }
    }
    
    private void generateEnd(final World world, final Random random, final int x, final int z) {
    }
    
    private void generateSurface(final World world, final Random random, final int x, final int z) {
        this.addOreSpawn(Ores.TitaniumOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("TitaniumOre").getSpawnsPerChunk(), random, x, z, 8, 8, 3 + random.nextInt(4), 2, 60);
        this.addOreSpawn(Ores.CopperOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("CopperOre").getSpawnsPerChunk(), random, x, z, 9, 9, 6 + random.nextInt(4), 2, 110);
        this.addOreSpawn(Ores.SulfurOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("SulfurOre").getSpawnsPerChunk(), random, x, z, 13, 13, 6 + random.nextInt(7), 5, 90);
        this.addOreSpawn(Ores.LeadOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("LeadOre").getSpawnsPerChunk(), random, x, z, 10, 10, 4 + random.nextInt(5), 5, 90);
        this.addOreSpawn(Ores.TantalumOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("TantalumOre").getSpawnsPerChunk(), random, x, z, 8, 8, 3 + random.nextInt(4), 2, 60);
        this.addOreSpawn(Ores.BauxiteOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("BauxiteOre").getSpawnsPerChunk(), random, x, z, 8, 8, 3 + random.nextInt(4), 2, 60);
        this.addOreSpawn(Ores.TinOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("TinOre").getSpawnsPerChunk(), random, x, z, 8, 8, 3 + random.nextInt(4), 2, 60);
        this.addOreSpawn(Ores.SiliconOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("SiliconOre").getSpawnsPerChunk(), random, x, z, 7, 7, 4 + random.nextInt(2), 2, 90);
        this.addOreSpawn(Ores.RubyOre, CompatibleBlocks.STONE, world, this.configurationManager.getOre("RubyOre").getSpawnsPerChunk(), random, x, z, 6, 6, 2 + random.nextInt(2), 2, 15);
    }
    
    private void generateNether(final World world, final Random random, final int x, final int z) {
    }
    
    public void addOreSpawn(final Block block, final CompatibleBlocks target, final World world, final int chancesToSpawn, final Random random, final int blockXPos, final int blockZPos, final int maxX, final int maxZ, final int maxVeinSize, final int minY, final int maxY) {
        final int diffBetweenMinMaxY = maxY - minY;
        for (int x = 0; x < chancesToSpawn; ++x) {
            final int posX = blockXPos + random.nextInt(maxX);
            final int posY = minY + random.nextInt(diffBetweenMinMaxY);
            final int posZ = blockZPos + random.nextInt(maxZ);
            this.generate(block, maxVeinSize, target, world, random, posX, posY, posZ);
        }
    }
}
