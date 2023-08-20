package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemCopperIngot extends Item
{
    public ItemCopperIngot() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_CopperIngot");
        this.setTextureName("mw:copperingot");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
