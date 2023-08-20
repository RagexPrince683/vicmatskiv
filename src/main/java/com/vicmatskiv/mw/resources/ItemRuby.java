package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemRuby extends Item
{
    public ItemRuby() {
        super();
        this.setMaxStackSize(16);
        this.setUnlocalizedName("mw_Ruby");
        this.setTextureName("mw:ruby");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
