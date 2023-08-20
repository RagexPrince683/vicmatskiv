package com.vicmatskiv.mw.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class BlockSulfurOre extends Block
{
    private static final String name = "titaniumore";
    
    public BlockSulfurOre() {
        super(Material.rock);
        this.setBlockName("mw_SulfurOre");
        this.setBlockTextureName("mw:sulfurore");
        this.setHardness(4.0f);
        this.setResistance(600000.0f);
        this.setStepSound(BlockSulfurOre.soundTypeStone);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
    
    public Item getItemDropped(final int meta, final Random rand, final int fortune) {
        return Ores.SulfurDust;
    }
}
