package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.block.*;
import net.minecraft.init.*;

public class CompatibleBlocks
{
    public static final CompatibleBlocks PLANK;
    public static final CompatibleBlocks STONE;
    public static final CompatibleBlocks SAND;
    public static final CompatibleBlocks LEAVES;
    public static final CompatibleBlocks TNT;
    public static final CompatibleBlocks GLASS_PANE;
    public static final CompatibleBlocks WOOL;
    public static final CompatibleBlocks SANDSTONE;
    public static final CompatibleBlocks STONE_BUTTON;
    private Block block;
    
    private CompatibleBlocks(final Block block) {
        super();
        this.block = block;
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    static {
        PLANK = new CompatibleBlocks(Blocks.planks);
        STONE = new CompatibleBlocks(Blocks.stone);
        SAND = new CompatibleBlocks((Block)Blocks.sand);
        LEAVES = new CompatibleBlocks((Block)Blocks.leaves);
        TNT = new CompatibleBlocks(Blocks.tnt);
        GLASS_PANE = new CompatibleBlocks(Blocks.glass_pane);
        WOOL = new CompatibleBlocks(Blocks.wool);
        SANDSTONE = new CompatibleBlocks(Blocks.sandstone);
        STONE_BUTTON = new CompatibleBlocks(Blocks.stone_button);
    }
}
