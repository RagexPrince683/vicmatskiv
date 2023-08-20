package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemLeadIngot extends Item
{
    public ItemLeadIngot() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_LeadIngot");
        this.setTextureName("mw:leadingot");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
