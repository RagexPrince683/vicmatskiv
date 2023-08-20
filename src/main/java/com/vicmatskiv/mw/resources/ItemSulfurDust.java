package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemSulfurDust extends Item
{
    public ItemSulfurDust() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_SulfurDust");
        this.setTextureName("mw:sulfurdust");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
