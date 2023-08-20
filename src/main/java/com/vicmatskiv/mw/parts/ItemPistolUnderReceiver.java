package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemPistolUnderReceiver extends Item
{
    public ItemPistolUnderReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_PistolUnderReceiver");
        this.setTextureName("mw:pistolunderreceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
