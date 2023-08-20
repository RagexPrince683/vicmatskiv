package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemRevolverReceiver extends Item
{
    public ItemRevolverReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_RevolverReceiver");
        this.setTextureName("mw:revolverreceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
