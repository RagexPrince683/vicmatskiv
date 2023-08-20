package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemGreenCloth extends Item
{
    public ItemGreenCloth() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_GreenCloth");
        this.setTextureName("mw:greencloth");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
