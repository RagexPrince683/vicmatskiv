package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemRetractableStock extends Item
{
    public ItemRetractableStock() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_RetractableStock");
        this.setTextureName("mw:retractablestock");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
