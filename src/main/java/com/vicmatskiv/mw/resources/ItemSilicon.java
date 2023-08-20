package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemSilicon extends Item
{
    public ItemSilicon() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_Silicon");
        this.setTextureName("mw:silicon");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
