package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.item.*;
import net.minecraft.init.*;

public class CompatibleItems {
    public static final CompatibleItems GUNPOWDER = new CompatibleItems(Items.gunpowder);
    public static final CompatibleItems DYE = new CompatibleItems(Items.dye);
    public static final CompatibleItems IRON_INGOT = new CompatibleItems(Items.iron_ingot);
    public static final CompatibleItems EMERALD = new CompatibleItems(Items.emerald);
    public static final CompatibleItems DIAMOND = new CompatibleItems(Items.diamond);
    public static final CompatibleItems GOLD_NUGGET = new CompatibleItems(Items.gold_nugget);
    public static final CompatibleItems STRING = new CompatibleItems(Items.string);
    public static final CompatibleItems COAL = new CompatibleItems(Items.coal);
    public static final CompatibleItems WATER_BUCKET = new CompatibleItems(Items.water_bucket);
    public static final CompatibleItems STICK = new CompatibleItems(Items.stick);
    public static final CompatibleItems FLINT_AND_STEEL = new CompatibleItems(Items.flint_and_steel);

    private Item item;

    private CompatibleItems(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }
}