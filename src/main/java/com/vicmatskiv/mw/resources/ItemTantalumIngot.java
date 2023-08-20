package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemTantalumIngot extends Item
{
    public ItemTantalumIngot() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_TantalumIngot");
        this.setTextureName("mw:tantalumingot");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
