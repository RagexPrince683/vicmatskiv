package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemShotgunReceiver extends Item
{
    public ItemShotgunReceiver() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_ShotgunReceiver");
        this.setTextureName("mw:shotgunreceiver");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
