package com.vicmatskiv.mw.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import com.vicmatskiv.mw.*;

public class BlockTantalumOre extends Block
{
    private static final String name = "titaniumore";
    
    public BlockTantalumOre() {
        super(Material.rock);
        this.setBlockName("mw_TantalumOre");
        this.setBlockTextureName("mw:tantalumore");
        this.setHardness(4.0f);
        this.setResistance(600000.0f);
        this.setStepSound(BlockTantalumOre.soundTypeStone);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
    
    public Block getBlockDropped(final int meta, final Random rand, final int fortune) {
        return Ores.TantalumOre;
    }
}
