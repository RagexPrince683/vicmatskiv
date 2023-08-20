package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemBigSteelPlate extends Item
{
    public ItemBigSteelPlate() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_BigSteelPlate");
        this.setTextureName("mw:bigsteelplate");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
