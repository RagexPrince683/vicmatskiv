package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemResistor extends Item
{
    public ItemResistor() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_Resistor");
        this.setTextureName("mw:resistor");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
