package com.vicmatskiv.weaponlib.blocks;

import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class InventoryDeconstructResult implements IInventory
{
    private final ItemStack[] stackResult;
    
    public InventoryDeconstructResult() {
        super();
        this.stackResult = new ItemStack[9];
    }
    
    public int getSizeInventory() {
        return 9;
    }
    
    public ItemStack getStackInSlot(final int par1) {
        return this.stackResult[par1];
    }
    
    public ItemStack decrStackSize(final int par1, final int par2) {
        if (this.stackResult[par1] != null) {
            final ItemStack itemstack = this.stackResult[par1];
            this.stackResult[par1] = null;
            return itemstack;
        }
        return null;
    }
    
    public ItemStack getStackInSlotOnClosing(final int par1) {
        if (this.stackResult[par1] != null) {
            final ItemStack itemstack = this.stackResult[par1];
            this.stackResult[par1] = null;
            return itemstack;
        }
        return null;
    }
    
    public void setInventorySlotContents(final int par1, final ItemStack par2ItemStack) {
        this.stackResult[par1] = par2ItemStack;
    }
    
    public int getInventoryStackLimit() {
        return 1;
    }
    
    public boolean isUseableByPlayer(final EntityPlayer par1EntityPlayer) {
        return true;
    }
    
    public boolean isItemValidForSlot(final int par1, final ItemStack par2ItemStack) {
        return true;
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < this.stackResult.length; ++i) {
            if (this.stackResult[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    public void markDirty() {
    }
    
    public String getInventoryName() {
        return null;
    }
    
    public boolean hasCustomInventoryName() {
        return false;
    }
    
    public void openInventory() {
    }
    
    public void closeInventory() {
    }
}
