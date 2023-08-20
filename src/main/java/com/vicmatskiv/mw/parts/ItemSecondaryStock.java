package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemSecondaryStock extends Item
{
    public ItemSecondaryStock() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_SecondaryStock");
        this.setTextureName("mw:secondarystock");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
