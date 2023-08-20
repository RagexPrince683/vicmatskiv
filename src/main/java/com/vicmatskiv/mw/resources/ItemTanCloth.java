package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemTanCloth extends Item
{
    public ItemTanCloth() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_TanCloth");
        this.setTextureName("mw:tancloth");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
