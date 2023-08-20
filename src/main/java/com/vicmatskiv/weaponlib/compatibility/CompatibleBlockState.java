package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.block.*;

public class CompatibleBlockState
{
    private int blockMetadata;
    private Block block;
    
    CompatibleBlockState(final Block block, final int blockMetadata) {
        super();
        this.block = block;
        this.blockMetadata = blockMetadata;
    }
    
    static CompatibleBlockState fromBlock(final Block block) {
        return (block != null) ? new CompatibleBlockState(block) : null;
    }
    
    private CompatibleBlockState(final Block block) {
        super();
        this.block = block;
    }
    
    public int getBlockMetadata() {
        return this.blockMetadata;
    }
    
    Block getBlock() {
        return this.block;
    }
}
