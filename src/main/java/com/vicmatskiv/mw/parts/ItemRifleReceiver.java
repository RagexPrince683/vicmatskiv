package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemRifleReceiver extends Item
{
    public ItemRifleReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_RifleReceiver");
        this.setTextureName("mw:riflereceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
