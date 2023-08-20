package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemCapacitor extends Item
{
    public ItemCapacitor() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_Capacitor");
        this.setTextureName("mw:capacitor");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
