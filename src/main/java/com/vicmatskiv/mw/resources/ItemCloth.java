package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemCloth extends Item
{
    public ItemCloth() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_Cloth");
        this.setTextureName("mw:cloth");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
