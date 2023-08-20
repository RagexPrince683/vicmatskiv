package com.vicmatskiv.mw.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class BlockRubyOre extends Block
{
    private static final String name = "titaniumore";
    
    public BlockRubyOre() {
        super(Material.rock);
        this.setBlockName("mw_RubyOre");
        this.setBlockTextureName("mw:rubyore");
        this.setHardness(6.0f);
        this.setResistance(600000.0f);
        this.setStepSound(BlockRubyOre.soundTypeStone);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
    
    public Item getItemDropped(final int meta, final Random rand, final int fortune) {
        return Ores.Ruby;
    }
}
