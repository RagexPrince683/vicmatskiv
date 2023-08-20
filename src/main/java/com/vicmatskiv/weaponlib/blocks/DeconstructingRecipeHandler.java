package com.vicmatskiv.weaponlib.blocks;

import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraftforge.oredict.*;
import java.util.*;

public final class DeconstructingRecipeHandler
{
    public Item theItem;
    public DeconstructingAdjustedRecipes deconstructingAdjustedRecipes;
    
    public DeconstructingRecipeHandler() {
        super();
        this.theItem = null;
        this.deconstructingAdjustedRecipes = new DeconstructingAdjustedRecipes();
    }
    
    public ItemStack[] getDeconstructResults(final ItemStack parItemStack) {
        System.out.println("Looking for deconstructing a recipe for " + parItemStack.getUnlocalizedName());
        this.theItem = parItemStack.getItem();
        if (DeconstructingAddedRecipes.shouldAddRecipe(this.theItem)) {
            return DeconstructingAddedRecipes.getCraftingGrid(this.theItem);
        }
        final List<?> listAllRecipes = CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < listAllRecipes.size(); ++i) {
            final IRecipe recipe = (IRecipe)listAllRecipes.get(i);
            if (recipe != null) {
                final ItemStack recipeKeyItemStack = recipe.getRecipeOutput();
                if (recipeKeyItemStack != null && recipeKeyItemStack.getUnlocalizedName().equals(parItemStack.getUnlocalizedName())) {
                    return this.getCraftingGrid(recipe);
                }
            }
        }
        return null;
    }
    
    public ItemStack[] getCraftingGrid(final IRecipe parRecipe) {
        final ItemStack[] resultItemStackArray = new ItemStack[9];
        for (int j = 0; j < resultItemStackArray.length; ++j) {
            resultItemStackArray[j] = null;
        }
        if (parRecipe instanceof ShapedRecipes) {
            System.out.println("getCraftingGrid for shaped recipe");
            final ShapedRecipes shaped = (ShapedRecipes)parRecipe;
            for (int i = 0; i < shaped.recipeItems.length; ++i) {
                resultItemStackArray[i] = shaped.recipeItems[i];
            }
        }
        if (parRecipe instanceof ShapelessRecipes) {
            System.out.println("getCraftingGrid for shapeless recipe");
            final ShapelessRecipes shapeless = (ShapelessRecipes)parRecipe;
            for (int i = 0; i < shapeless.recipeItems.size(); ++i) {
                resultItemStackArray[i] = shapeless.recipeItems.get(i);
            }
        }
        if (parRecipe instanceof ShapedOreRecipe) {
            System.out.println("getCraftingGrid for shaped ore recipe");
            final ShapedOreRecipe shaped2 = (ShapedOreRecipe)parRecipe;
            for (int i = 0; i < shaped2.getInput().length; ++i) {
                if (shaped2.getInput()[i] instanceof ItemStack) {
                    resultItemStackArray[i] = (ItemStack)shaped2.getInput()[i];
                }
                else if (shaped2.getInput()[i] instanceof List) {
                    final Object o = ((List)shaped2.getInput()[i]).get(0);
                    if (o instanceof ItemStack) {
                        resultItemStackArray[i] = (ItemStack)o;
                    }
                }
            }
        }
        if (parRecipe instanceof ShapelessOreRecipe) {
            final ArrayList shapelessArray = ((ShapelessOreRecipe)parRecipe).getInput();
            System.out.println("getCraftingGrid for shapeless ore recipe with input array size = " + shapelessArray.size());
            for (int i = 0; i < shapelessArray.size(); ++i) {
                if (shapelessArray.get(i) instanceof ItemStack) {
                    resultItemStackArray[i] = shapelessArray.get(i);
                }
                else if (shapelessArray.get(i) instanceof List) {
                    final Object o = shapelessArray.get(i).get(0);
                    if (o instanceof ItemStack) {
                        resultItemStackArray[i] = (ItemStack)o;
                    }
                    else {
                        System.out.println("But list element is not an ItemStack");
                    }
                }
            }
        }
        if (BlockSmith.allowPartialDeconstructing) {
            return this.deconstructingAdjustedRecipes.adjustOutputQuantities(resultItemStackArray, parRecipe.getRecipeOutput());
        }
        return resultItemStackArray;
    }
}
