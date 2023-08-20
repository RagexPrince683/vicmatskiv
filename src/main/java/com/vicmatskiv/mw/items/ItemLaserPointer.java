package com.vicmatskiv.mw.items;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemLaserPointer extends Item
{
    public ItemLaserPointer() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_LaserPointer");
        this.setTextureName("mw:laserpointer");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
