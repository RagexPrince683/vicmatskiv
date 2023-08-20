package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemAluminumPlate extends Item
{
    public ItemAluminumPlate() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_AluminumPlate");
        this.setTextureName("mw:aluminumplate");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
