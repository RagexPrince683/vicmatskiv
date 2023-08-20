package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemRevolverAction extends Item
{
    public ItemRevolverAction() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_RevolverAction");
        this.setTextureName("mw:revolveraction");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
