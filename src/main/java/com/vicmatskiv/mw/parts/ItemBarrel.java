package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemBarrel extends Item
{
    public ItemBarrel() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_Barrel");
        this.setTextureName("mw:barrel");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
