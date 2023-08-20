package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemSteelIngot extends Item
{
    public ItemSteelIngot() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_SteelIngot");
        this.setTextureName("mw:steelingot");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
