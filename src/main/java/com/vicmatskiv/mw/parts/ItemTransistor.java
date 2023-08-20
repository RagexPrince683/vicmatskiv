package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemTransistor extends Item
{
    public ItemTransistor() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_Transistor");
        this.setTextureName("mw:transistor");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
