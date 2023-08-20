package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemInductor extends Item
{
    public ItemInductor() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_Inductor");
        this.setTextureName("mw:inductor");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
