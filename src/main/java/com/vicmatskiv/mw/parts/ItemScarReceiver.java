package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemScarReceiver extends Item
{
    public ItemScarReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_ScarReceiver");
        this.setTextureName("mw:scarreceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
