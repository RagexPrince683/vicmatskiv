package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemElectronics extends Item
{
    public ItemElectronics() {
        super();
        this.setMaxStackSize(32);
        this.setUnlocalizedName("mw_Electronics");
        this.setTextureName("mw:electronics");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
