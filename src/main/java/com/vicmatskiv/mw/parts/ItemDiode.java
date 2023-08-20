package com.vicmatskiv.mw.parts;

import net.minecraft.item.*;
import com.vicmatskiv.mw.*;

public class ItemDiode extends Item
{
    public ItemDiode() {
        super();
        this.setMaxStackSize(64);
        this.setUnlocalizedName("mw_Diode");
        this.setTextureName("mw:diode");
        this.setCreativeTab(ModernWarfareMod.gunsTab);
    }
}
