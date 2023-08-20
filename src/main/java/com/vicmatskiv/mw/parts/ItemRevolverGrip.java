package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemRevolverGrip extends Item
{
    public ItemRevolverGrip() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_RevolverGrip");
        this.setTextureName("mw:revolvergrip");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
