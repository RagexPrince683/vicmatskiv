package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemWoodWeaponStock extends Item
{
    public ItemWoodWeaponStock() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_WoodWeaponStock");
        this.setTextureName("mw:woodweaponstock");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
