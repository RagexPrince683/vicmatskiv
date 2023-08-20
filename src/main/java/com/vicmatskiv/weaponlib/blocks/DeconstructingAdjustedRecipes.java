package com.vicmatskiv.weaponlib.blocks;

import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.init.*;

public class DeconstructingAdjustedRecipes
{
    public int divideByTwoCounter;
    public int divideByThreeCounter;
    public int divideByFourCounter;
    public int divideByEightCounter;
    public Item theItem;
    public int theMetadata;
    
    public DeconstructingAdjustedRecipes() {
        super();
        this.divideByTwoCounter = 1;
        this.divideByThreeCounter = 2;
        this.divideByFourCounter = 3;
        this.divideByEightCounter = 7;
        this.theItem = null;
        this.theMetadata = 0;
    }
    
    public ItemStack[] adjustOutputQuantities(final ItemStack[] parOutputItemStackArray, final ItemStack parInputItemStack) {
        this.theItem = parInputItemStack.getItem();
        this.theMetadata = this.theItem.getMetadata(0);
        throw new IllegalStateException("Implement me");
    }
    
    private ItemStack[] outputSingle(final Block parBlock) {
        return new ItemStack[] { new ItemStack(Item.getItemFromBlock(parBlock)), null, null, null, null, null, null, null, null };
    }
    
    private ItemStack[] outputSingle(final Item parItem) {
        return new ItemStack[] { new ItemStack(parItem), null, null, null, null, null, null, null, null };
    }
    
    private ItemStack[] outputSingle(final Block parBlock, final int parMetadata) {
        return new ItemStack[] { new ItemStack(Item.getItemFromBlock(parBlock), 1, parMetadata), null, null, null, null, null, null, null, null };
    }
    
    private ItemStack[] outputSingle(final Item parItem, final int parMetadata) {
        return new ItemStack[] { new ItemStack(parItem, 1, parMetadata), null, null, null, null, null, null, null, null };
    }
    
    private ItemStack[] outputForWoodenDoor(final int parMetadata) {
        return new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.planks), 1, parMetadata), new ItemStack(Item.getItemFromBlock(Blocks.planks), 1, parMetadata), null, null, null, null, null, null, null };
    }
    
    private ItemStack[] outputForWoodenFence(final int parMetadata) {
        ItemStack[] resultItemStackArray = this.initItemStackArray();
        final ItemStack planksItemStack = new ItemStack(Item.getItemFromBlock(Blocks.planks), 1, parMetadata);
        if (this.divideByThreeCounter == 2) {
            this.decrementDivideByThreeCounter();
            resultItemStackArray = new ItemStack[] { null, null, null, planksItemStack, new ItemStack(Items.stick, 1, 0), null, null, null, null };
        }
        else if (this.divideByThreeCounter == 1) {
            this.decrementDivideByThreeCounter();
            resultItemStackArray = new ItemStack[] { null, null, null, null, null, null, null, new ItemStack(Items.stick, 1, 0), planksItemStack };
        }
        else if (this.divideByThreeCounter == 0) {
            this.decrementDivideByThreeCounter();
            resultItemStackArray = new ItemStack[] { null, null, null, null, null, planksItemStack, planksItemStack, null, null };
        }
        return resultItemStackArray;
    }
    
    private ItemStack[] outputForStoneSlab() {
        ItemStack[] resultItemStackArray = this.initItemStackArray();
        if ((this.theMetadata & 0x7) == 0x0) {
            resultItemStackArray = new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.stone), 1, 0), null, null, null, null, null, null, null, null };
        }
        else if ((this.theMetadata & 0x7) == 0x1) {
            resultItemStackArray = new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.sandstone), 1, 0), null, null, null, null, null, null, null, null };
        }
        else if ((this.theMetadata & 0x7) == 0x2) {
            resultItemStackArray = new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.stone), 1, 0), null, null, null, null, null, null, null, null };
        }
        else if ((this.theMetadata & 0x7) == 0x3) {
            resultItemStackArray = new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.cobblestone), 1, 0), null, null, null, null, null, null, null, null };
        }
        else if ((this.theMetadata & 0x7) == 0x4) {
            resultItemStackArray = new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.brick_block), 1, 0), null, null, null, null, null, null, null, null };
        }
        else if ((this.theMetadata & 0x7) == 0x5) {
            resultItemStackArray = new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.stonebrick), 1, 0), null, null, null, null, null, null, null, null };
        }
        else if ((this.theMetadata & 0x7) == 0x6) {
            resultItemStackArray = new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.nether_brick), 1, 0), null, null, null, null, null, null, null, null };
        }
        else if ((this.theMetadata & 0x7) == 0x7) {
            resultItemStackArray = new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.quartz_block), 1, 0), null, null, null, null, null, null, null, null };
        }
        return resultItemStackArray;
    }
    
    private ItemStack[] outputForQuartz() {
        ItemStack[] resultItemStackArray = this.initItemStackArray();
        if (this.theMetadata == 0) {
            resultItemStackArray = new ItemStack[] { null, null, null, new ItemStack(Items.quartz, 1, 0), new ItemStack(Items.quartz, 1, 0), null, new ItemStack(Items.quartz, 1, 0), new ItemStack(Items.quartz, 1, 0), null };
        }
        else if (this.theMetadata == 1) {
            resultItemStackArray = new ItemStack[] { null, null, null, null, new ItemStack(Item.getItemFromBlock((Block)Blocks.stone_slab), 1, 7), null, null, new ItemStack(Item.getItemFromBlock((Block)Blocks.stone_slab), 1, 7), null };
        }
        else if (this.theMetadata == 2 || this.theMetadata == 3 || this.theMetadata == 4) {
            if (this.divideByTwoCounter == 1) {
                this.decrementDivideByTwoCounter();
                resultItemStackArray = new ItemStack[] { null, null, null, null, null, null, null, new ItemStack(Item.getItemFromBlock(Blocks.quartz_block), 1, 0), null };
            }
            else if (this.divideByTwoCounter == 0) {
                this.decrementDivideByTwoCounter();
                resultItemStackArray = new ItemStack[] { null, null, null, null, new ItemStack(Item.getItemFromBlock(Blocks.quartz_block), 1, 0), null, null, null, null };
            }
        }
        return resultItemStackArray;
    }
    
    private ItemStack[] outputForHardenedClay() {
        if (this.divideByEightCounter != 3) {
            this.decrementDivideByEightCounter();
            return new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.clay), 1, 0), null, null, null, null, null, null, null, null };
        }
        System.out.println("Should output a dye");
        this.decrementDivideByEightCounter();
        return new ItemStack[] { new ItemStack(Item.getItemFromBlock(Blocks.clay), 1, 0), new ItemStack(Items.dye, 1, this.convertClayMetaToDyeMeta(this.theMetadata)), null, null, null, null, null, null, null };
    }
    
    private ItemStack[] outputForStairs(final ItemStack parOutputItemStack) {
        ItemStack[] resultItemStackArray = this.initItemStackArray();
        if (this.divideByFourCounter == 0) {
            this.decrementDivideByFourCounter();
            resultItemStackArray = new ItemStack[] { null, null, parOutputItemStack, null, null, null, null, null, null };
        }
        else if (this.divideByFourCounter == 1) {
            this.decrementDivideByFourCounter();
            resultItemStackArray = new ItemStack[] { null, null, null, null, parOutputItemStack, parOutputItemStack, null, null, null };
        }
        else if (this.divideByFourCounter == 2) {
            this.decrementDivideByFourCounter();
            resultItemStackArray = new ItemStack[] { null, null, null, null, null, null, null, null, parOutputItemStack };
        }
        else if (this.divideByFourCounter == 3) {
            this.decrementDivideByFourCounter();
            resultItemStackArray = new ItemStack[] { null, null, null, null, null, null, parOutputItemStack, parOutputItemStack, null };
        }
        return resultItemStackArray;
    }
    
    private int convertClayMetaToDyeMeta(final int parClayMeta) {
        return 15 - parClayMeta;
    }
    
    private void decrementDivideByTwoCounter() {
        --this.divideByTwoCounter;
        if (this.divideByTwoCounter < 0) {
            this.divideByTwoCounter = 1;
        }
    }
    
    private void decrementDivideByThreeCounter() {
        --this.divideByThreeCounter;
        if (this.divideByThreeCounter < 0) {
            this.divideByThreeCounter = 2;
        }
    }
    
    private void decrementDivideByFourCounter() {
        --this.divideByFourCounter;
        if (this.divideByFourCounter < 0) {
            this.divideByFourCounter = 3;
        }
    }
    
    private void decrementDivideByEightCounter() {
        --this.divideByEightCounter;
        if (this.divideByEightCounter < 0) {
            this.divideByEightCounter = 7;
        }
    }
    
    private ItemStack[] initItemStackArray() {
        final ItemStack[] resultItemStackArray = new ItemStack[9];
        for (int j = 0; j < resultItemStackArray.length; ++j) {
            resultItemStackArray[j] = null;
        }
        return resultItemStackArray;
    }
}
