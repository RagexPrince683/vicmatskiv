package com.vicmatskiv.weaponlib.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class BlockDeconstructor extends Block
{
    private Object mod;
    private int modGuidId;
    
    public BlockDeconstructor(final Object mod) {
        super(Material.rock);
        this.mod = mod;
        this.setBlockName("deconstructor");
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    public boolean onBlockActivated(final World parWorld, final int x, final int y, final int z, final EntityPlayer parPlayer, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (!parWorld.isRemote) {
            System.out.println("BlockDeconstructor onBlockActivated");
            parPlayer.openGui(this.mod, BlockSmith.GUI_ENUM.DECONSTRUCTOR.ordinal(), parWorld, x, y, z);
        }
        return true;
    }
}
