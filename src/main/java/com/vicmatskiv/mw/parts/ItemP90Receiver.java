package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemP90Receiver extends Item
{
    public ItemP90Receiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_P90Receiver");
        this.setTextureName("mw:p90receiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
