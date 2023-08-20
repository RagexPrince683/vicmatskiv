package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemWeaponStock extends Item
{
    public ItemWeaponStock() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_WeaponStock");
        this.setTextureName("mw:weaponstock");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
