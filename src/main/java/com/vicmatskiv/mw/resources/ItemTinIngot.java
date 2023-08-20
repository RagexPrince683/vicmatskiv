package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemTinIngot extends Item
{
    public ItemTinIngot() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_TinIngot");
        this.setTextureName("mw:tiningot");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
