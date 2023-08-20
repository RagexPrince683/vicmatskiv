package com.vicmatskiv.mw;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import cpw.mods.fml.relauncher.*;

public class AmmoTab extends CreativeTabs
{
    public AmmoTab(final int par1, final String par2Str) {
        super(par1, par2Str);
    }
    
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Magazines.NATOMag1;
    }
}
