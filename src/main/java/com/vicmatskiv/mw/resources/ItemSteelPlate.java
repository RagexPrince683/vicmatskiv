package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemSteelPlate extends Item
{
    public ItemSteelPlate() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_SteelPlate");
        this.setTextureName("mw:steelplate");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
