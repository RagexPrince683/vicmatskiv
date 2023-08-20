package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemWoodRifleStock extends Item
{
    public ItemWoodRifleStock() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_WoodRifleStock");
        this.setTextureName("mw:woodriflestock");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
