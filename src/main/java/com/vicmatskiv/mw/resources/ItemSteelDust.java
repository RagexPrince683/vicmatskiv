package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemSteelDust extends Item
{
    public ItemSteelDust() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_SteelDust");
        this.setTextureName("mw:steeldust");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
