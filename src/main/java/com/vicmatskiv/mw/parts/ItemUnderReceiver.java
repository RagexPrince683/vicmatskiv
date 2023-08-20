package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemUnderReceiver extends Item
{
    public ItemUnderReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_UnderReceiver");
        this.setTextureName("mw:underreceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
