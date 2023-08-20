package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.item.*;
import net.minecraft.init.*;

public class CompatibleItems
{
    public static final CompatibleItems GUNPOWDER;
    public static final CompatibleItems DYE;
    public static final CompatibleItems IRON_INGOT;
    public static final CompatibleItems EMERALD;
    public static final CompatibleItems DIAMOND;
    public static final CompatibleItems GOLD_NUGGET;
    public static final CompatibleItems STRING;
    public static final CompatibleItems COAL;
    public static final CompatibleItems WATER_BUCKET;
    public static final CompatibleItems STICK;
    public static final CompatibleItems FLINT_AND_STEEL;
    private Item item;
    
    private CompatibleItems(final Item item) {
        super();
        this.item = item;
    }
    
    public Item getItem() {
        return this.item;
    }
    
    CompatibleItems(final Item x0, final CompatibleItems$1 x1) {
        this(x0);
    }
    
    static {
        GUNPOWDER = new CompatibleItems(Items.gunpowder) {
            CompatibleItems$1(final Item item) {
                super(item, null);
            }
        };
        DYE = new CompatibleItems(Items.dye) {
            CompatibleItems$2(final Item item) {
                super(item, null);
            }
        };
        IRON_INGOT = new CompatibleItems(Items.iron_ingot) {
            CompatibleItems$3(final Item item) {
                super(item, null);
            }
        };
        EMERALD = new CompatibleItems(Items.emerald) {
            CompatibleItems$4(final Item item) {
                super(item, null);
            }
        };
        DIAMOND = new CompatibleItems(Items.diamond) {
            CompatibleItems$5(final Item item) {
                super(item, null);
            }
        };
        GOLD_NUGGET = new CompatibleItems(Items.gold_nugget) {
            CompatibleItems$6(final Item item) {
                super(item, null);
            }
        };
        STRING = new CompatibleItems(Items.string) {
            CompatibleItems$7(final Item item) {
                super(item, null);
            }
        };
        COAL = new CompatibleItems(Items.coal) {
            CompatibleItems$8(final Item item) {
                super(item, null);
            }
        };
        WATER_BUCKET = new CompatibleItems(Items.water_bucket) {
            CompatibleItems$9(final Item item) {
                super(item, null);
            }
        };
        STICK = new CompatibleItems(Items.stick) {
            CompatibleItems$10(final Item item) {
                super(item, null);
            }
        };
        FLINT_AND_STEEL = new CompatibleItems(Items.flint_and_steel) {
            CompatibleItems$11(final Item item) {
                super(item, null);
            }
        };
    }
}
