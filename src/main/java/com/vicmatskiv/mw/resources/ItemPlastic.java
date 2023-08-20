package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemPlastic extends Item
{
    public ItemPlastic() {
        super();
        this.setMaxStackSize(16);
        this.setUnlocalizedName("mw_Plastic");
        this.setTextureName("mw:plastic");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
