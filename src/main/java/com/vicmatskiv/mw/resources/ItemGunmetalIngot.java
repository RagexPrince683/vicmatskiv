package com.vicmatskiv.mw.resources;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemGunmetalIngot extends Item
{
    public ItemGunmetalIngot() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_GunmetalIngot");
        this.setTextureName("mw:gunmetalingot");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
