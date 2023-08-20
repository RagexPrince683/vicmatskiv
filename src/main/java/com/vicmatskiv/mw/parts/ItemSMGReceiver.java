package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemSMGReceiver extends Item
{
    public ItemSMGReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_SMGReceiver");
        this.setTextureName("mw:smgreceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
