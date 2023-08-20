package com.vicmatskiv.weaponlib.blocks;

import net.minecraft.item.crafting.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class DeconstructingInputQuantity
{
    public DeconstructingInputQuantity() {
        super();
    }
    
    public static int getStackSizeNeeded(final ItemStack parItemStack) {
        final Item theItem = parItemStack.getItem();
        if (theItem != Items.enchanted_book) {
            final List<?> crafts = CraftingManager.getInstance().getRecipeList();
            for (int i = 0; i < crafts.size(); ++i) {
                final IRecipe recipe = (IRecipe)crafts.get(i);
                if (recipe != null) {
                    final ItemStack outputItemStack = recipe.getRecipeOutput();
                    if (outputItemStack != null && outputItemStack.getUnlocalizedName().equals(parItemStack.getUnlocalizedName())) {
                        System.out.println("getStackSizeNeeded() found matching recipe");
                        return adjustQuantity(theItem, outputItemStack.stackSize);
                    }
                }
            }
            System.out.println("No matching recipe found!");
            return 0;
        }
        if (BlockSmith.allowDeconstructEnchantedBooks) {
            return 1;
        }
        return 0;
    }
    
    public static int adjustQuantity(final Item theItem, final int parDefaultQuantity) {
        if (!BlockSmith.allowDeconstructUnrealistic && (theItem == Items.paper || theItem == Items.melon_seeds || theItem == Items.pumpkin_seeds || theItem == Items.bread || theItem == Items.cake)) {
            System.out.println("Trying to deconstruct unrealistic item when not allowed");
            return 0;
        }
        if (!BlockSmith.allowHorseArmorCrafting && (theItem == Items.saddle || theItem == Items.iron_horse_armor || theItem == Items.golden_horse_armor || theItem == Items.diamond_horse_armor)) {
            System.out.println("Trying to deconstruct horse armor or saddle item when not allowed");
            return 0;
        }
        if (!BlockSmith.allowPartialDeconstructing) {
            System.out.println("Don't look for partial deconstruct recipe when not allowed");
            return parDefaultQuantity;
        }
        if (theItem == Items.iron_door || theItem == Items.paper || theItem == Items.stick || theItem == Item.getItemFromBlock(Blocks.ladder) || theItem == Items.enchanted_book || theItem == Item.getItemFromBlock(Blocks.nether_brick_fence) || theItem == Items.sign || theItem == Items.glass_bottle || theItem == Item.getItemFromBlock(Blocks.cobblestone_wall) || theItem == Item.getItemFromBlock(Blocks.quartz_block) || theItem == Item.getItemFromBlock(Blocks.stained_hardened_clay) || theItem == Item.getItemFromBlock(Blocks.oak_stairs) || theItem == Item.getItemFromBlock(Blocks.spruce_stairs) || theItem == Item.getItemFromBlock(Blocks.birch_stairs) || theItem == Item.getItemFromBlock(Blocks.jungle_stairs) || theItem == Item.getItemFromBlock(Blocks.acacia_stairs) || theItem == Item.getItemFromBlock(Blocks.dark_oak_stairs) || theItem == Item.getItemFromBlock(Blocks.stone_stairs) || theItem == Item.getItemFromBlock(Blocks.sandstone_stairs) || theItem == Item.getItemFromBlock(Blocks.nether_brick_stairs) || theItem == Item.getItemFromBlock(Blocks.quartz_stairs) || theItem == Item.getItemFromBlock(Blocks.stone_brick_stairs) || theItem == Item.getItemFromBlock(Blocks.brick_stairs)) {
            return 1;
        }
        if (theItem == Items.paper || theItem == Item.getItemFromBlock((Block)Blocks.wooden_slab) || theItem == Item.getItemFromBlock((Block)Blocks.stone_slab)) {
            return 2;
        }
        if (theItem == Item.getItemFromBlock(Blocks.iron_bars) || theItem == Item.getItemFromBlock(Blocks.rail) || theItem == Item.getItemFromBlock(Blocks.golden_rail) || theItem == Item.getItemFromBlock(Blocks.activator_rail) || theItem == Item.getItemFromBlock(Blocks.detector_rail) || theItem == Item.getItemFromBlock(Blocks.glass_pane) || theItem == Item.getItemFromBlock((Block)Blocks.stained_glass_pane)) {
            return 8;
        }
        return parDefaultQuantity;
    }
}
