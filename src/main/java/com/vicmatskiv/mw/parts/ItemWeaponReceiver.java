package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemWeaponReceiver extends Item
{
    public ItemWeaponReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_WeaponReceiver");
        this.setTextureName("mw:weaponreceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
