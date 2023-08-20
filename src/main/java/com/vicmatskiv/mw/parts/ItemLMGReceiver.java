package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemLMGReceiver extends Item
{
    public ItemLMGReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_LMGReceiver");
        this.setTextureName("mw:lmgreceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
