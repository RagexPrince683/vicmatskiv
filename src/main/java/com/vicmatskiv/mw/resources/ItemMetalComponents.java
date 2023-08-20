package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemMetalComponents extends Item
{
    public ItemMetalComponents() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_MetalComponents");
        this.setTextureName("mw:metalcomponents");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
