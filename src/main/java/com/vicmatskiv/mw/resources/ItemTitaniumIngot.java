package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemTitaniumIngot extends Item
{
    public ItemTitaniumIngot() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_TitaniumIngot");
        this.setTextureName("mw:titaniumingot");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
