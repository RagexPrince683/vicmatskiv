package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemAluminumIngot extends Item
{
    public ItemAluminumIngot() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_AluminumIngot");
        this.setTextureName("mw:aluminumingot");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
