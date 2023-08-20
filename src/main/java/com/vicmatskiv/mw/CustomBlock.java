package com.vicmatskiv.mw;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.texture.*;

public class CustomBlock extends BlockContainer
{
    private String iconName;
    
    public CustomBlock(final Material material, final String iconName) {
        super(material);
        this.iconName = iconName;
        this.setCreativeTab(ModernWarfareMod.gunsTab);
        this.setBlockBounds(0.4f, 0.0f, 0.4f, 0.6f, 3.0f, 0.6f);
    }
    
    public TileEntity createNewTileEntity(final World p_149915_1_, final int p_149915_2_) {
        return new CustomBlockEntity();
    }
    
    public int getRenderType() {
        return -1;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public void registerIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("mw:" + this.iconName);
    }
}
