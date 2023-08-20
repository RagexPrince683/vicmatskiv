package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemMiniSteelPlate extends Item
{
    public ItemMiniSteelPlate() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_MiniSteelPlate");
        this.setTextureName("mw:ministeelplate");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
