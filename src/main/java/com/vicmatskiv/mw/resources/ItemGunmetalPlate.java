package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemGunmetalPlate extends Item
{
    public ItemGunmetalPlate() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_GunmetalPlate");
        this.setTextureName("mw:gunmetalplate");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
