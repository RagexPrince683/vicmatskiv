package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemCopperWiring extends Item
{
    public ItemCopperWiring() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_CopperWiring");
        this.setTextureName("mw:copperwiring");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
