package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemPiston extends Item
{
    public ItemPiston() {
        super();
        this.setMaxStackSize(16);
        this.setUnlocalizedName("mw_Piston");
        this.setTextureName("mw:piston");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
