package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemDeagleReceiver extends Item
{
    public ItemDeagleReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_DeagleReceiver");
        this.setTextureName("mw:deaglereceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
