package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemOpticGlass extends Item
{
    public ItemOpticGlass() {
        super();
        this.setMaxStackSize(16);
        this.setUnlocalizedName("mw_OpticGlass");
        this.setTextureName("mw:opticglass");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
