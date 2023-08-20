package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemShotgunGrip extends Item
{
    public ItemShotgunGrip() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_ShotgunGrip");
        this.setTextureName("mw:shotgungrip");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
