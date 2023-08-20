package com.vicmatskiv.mw.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import com.vicmatskiv.mw.*;

public class BlockTinOre extends Block
{
    private static final String name = "titaniumore";
    
    public BlockTinOre() {
        super(Material.rock);
        this.setBlockName("mw_TinOre");
        this.setBlockTextureName("mw:tinore");
        this.setHardness(4.0f);
        this.setResistance(600000.0f);
        this.setStepSound(BlockTinOre.soundTypeStone);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
    
    public Block getBlockDropped(final int meta, final Random rand, final int fortune) {
        return Ores.TinOre;
    }
}
