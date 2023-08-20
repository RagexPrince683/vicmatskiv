package com.vicmatskiv.mw.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import java.util.*;
import com.vicmatskiv.mw.*;

public class BlockLeadOre extends Block
{
    private static final String name = "titaniumore";
    
    public BlockLeadOre() {
        super(Material.rock);
        this.setBlockName("mw_LeadOre");
        this.setBlockTextureName("mw:leadore");
        this.setHardness(6.0f);
        this.setResistance(600000.0f);
        this.setStepSound(BlockLeadOre.soundTypeStone);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
    
    public Block getBlockDropped(final int meta, final Random rand, final int fortune) {
        return Ores.LeadOre;
    }
}
