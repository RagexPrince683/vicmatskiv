package com.vicmatskiv.mw;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import cpw.mods.fml.relauncher.*;

public class AttachmentsTab extends CreativeTabs
{
    public AttachmentsTab(final int par1, final String par2Str) {
        super(par1, par2Str);
    }
    
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Attachments.Leupold;
    }
}
