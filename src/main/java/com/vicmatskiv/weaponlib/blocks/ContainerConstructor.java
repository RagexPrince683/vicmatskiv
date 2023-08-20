package com.vicmatskiv.weaponlib.blocks;

import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.client.resources.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;

public class ContainerConstructor extends Container
{
    public InventoryCrafting inputInventory;
    public int inputSlotNumber;
    public InventoryDeconstructResult outputInventory;
    public DeconstructingRecipeHandler deconstructingRecipeHandler;
    private final World worldObj;
    public InventoryPlayer playerInventory;
    public String resultString;
    public State deconstructingState;
    public int x;
    public int y;
    public int z;
    
    public ContainerConstructor(final InventoryPlayer parPlayerInventory, final World parWorld, final int parX, final int parY, final int parZ) {
        super();
        this.inputInventory = new InventoryCrafting((Container)this, 1, 1);
        this.outputInventory = new InventoryDeconstructResult();
        this.resultString = "deconstructing.result.ready";
        this.deconstructingState = State.READY;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.x = parX;
        this.y = parY;
        this.z = parZ;
        this.worldObj = parWorld;
        this.deconstructingRecipeHandler = new DeconstructingRecipeHandler();
        for (int outputSlotIndexX = 0; outputSlotIndexX < 3; ++outputSlotIndexX) {
            for (int outputSlotIndexY = 0; outputSlotIndexY < 3; ++outputSlotIndexY) {
                this.addSlotToContainer(new Slot((IInventory)this.outputInventory, outputSlotIndexY + outputSlotIndexX * 3, 112 + outputSlotIndexY * 18, 17 + outputSlotIndexX * 18));
            }
        }
        this.inputSlotNumber = this.addSlotToContainer(new Slot((IInventory)this.inputInventory, 0, 45, 35)).slotNumber;
        for (int playerSlotIndexY = 0; playerSlotIndexY < 3; ++playerSlotIndexY) {
            for (int playerSlotIndexX = 0; playerSlotIndexX < 9; ++playerSlotIndexX) {
                this.addSlotToContainer(new Slot((IInventory)parPlayerInventory, playerSlotIndexX + playerSlotIndexY * 9 + 9, 8 + playerSlotIndexX * 18, 84 + playerSlotIndexY * 18));
            }
        }
        for (int hotbarSlotIndex = 0; hotbarSlotIndex < 9; ++hotbarSlotIndex) {
            this.addSlotToContainer(new Slot((IInventory)parPlayerInventory, hotbarSlotIndex, 8 + hotbarSlotIndex * 18, 142));
        }
        this.playerInventory = parPlayerInventory;
    }
    
    public void onCraftMatrixChanged(final IInventory parInventory) {
        if (parInventory == this.inputInventory) {
            if (this.inputInventory.getStackInSlot(0) == null) {
                this.resultString = I18n.format("deconstructing.result.ready", new Object[0]);
                this.deconstructingState = State.READY;
                return;
            }
            final int amountRequired = DeconstructingInputQuantity.getStackSizeNeeded(this.inputInventory.getStackInSlot(0));
            System.out.println("Amount required = " + amountRequired);
            if (amountRequired > this.inputInventory.getStackInSlot(0).stackSize) {
                this.resultString = I18n.format("deconstructing.result.needMoreStacks", new Object[] { amountRequired - this.inputInventory.getStackInSlot(0).stackSize });
                this.deconstructingState = State.ERROR;
                return;
            }
            if (amountRequired <= 0) {
                this.resultString = I18n.format("deconstructing.result.impossible", new Object[0]);
                this.deconstructingState = State.ERROR;
                return;
            }
            final ItemStack[] outputItemStackArray = this.deconstructingRecipeHandler.getDeconstructResults(this.inputInventory.getStackInSlot(0));
            if (outputItemStackArray == null) {
                this.resultString = I18n.format("deconstructing.result.impossible", new Object[0]);
                this.deconstructingState = State.ERROR;
                return;
            }
            while (this.inputInventory.getStackInSlot(0) != null && amountRequired > 0 && amountRequired <= this.inputInventory.getStackInSlot(0).stackSize) {
                if (!this.outputInventory.isEmpty()) {
                    for (int i = 0; i < this.outputInventory.getSizeInventory(); ++i) {
                        final ItemStack itemStackInOutputSlot = this.outputInventory.getStackInSlot(i);
                        if (itemStackInOutputSlot != null && outputItemStackArray[i] != null && !itemStackInOutputSlot.isItemEqual(outputItemStackArray[i])) {
                            if (!this.playerInventory.addItemStackToInventory(itemStackInOutputSlot)) {
                                final EntityItem entityItem = this.playerInventory.player.entityDropItem(itemStackInOutputSlot, 0.5f);
                                entityItem.posX = this.playerInventory.player.posX;
                                entityItem.posY = this.playerInventory.player.posY;
                                entityItem.posZ = this.playerInventory.player.posZ;
                            }
                            this.outputInventory.setInventorySlotContents(i, null);
                        }
                    }
                }
                for (int i = 0; i < outputItemStackArray.length; ++i) {
                    final ItemStack outputItemStack = outputItemStackArray[i];
                    final ItemStack currentStack = this.outputInventory.getStackInSlot(i);
                    if (outputItemStack != null) {
                        int metadata = outputItemStack.getItemDamage();
                        if (metadata == 32767) {
                            metadata = 0;
                        }
                        ItemStack newStack = null;
                        if (currentStack != null && 1 + currentStack.stackSize <= outputItemStack.getMaxStackSize()) {
                            newStack = new ItemStack(outputItemStack.getItem(), 1 + currentStack.stackSize, metadata);
                        }
                        else {
                            if (currentStack != null && !this.playerInventory.addItemStackToInventory(currentStack)) {
                                final EntityItem entityItem2 = this.playerInventory.player.entityDropItem(currentStack, 0.5f);
                                entityItem2.posX = this.playerInventory.player.posX;
                                entityItem2.posY = this.playerInventory.player.posY;
                                entityItem2.posZ = this.playerInventory.player.posZ;
                            }
                            newStack = new ItemStack(outputItemStack.getItem(), 1, metadata);
                        }
                        this.outputInventory.setInventorySlotContents(i, newStack);
                    }
                }
                this.playerInventory.player.addStat(BlockSmith.deconstructedItemsStat, amountRequired);
                this.playerInventory.player.triggerAchievement(BlockSmith.deconstructAny);
                this.inputInventory.decrStackSize(0, amountRequired);
            }
        }
        else {
            this.resultString = I18n.format("deconstructing.result.impossible", new Object[0]);
            this.deconstructingState = State.ERROR;
        }
    }
    
    public ItemStack slotClick(final int parSlotId, final int parMouseButtonId, final int parClickMode, final EntityPlayer parPlayer) {
        final ItemStack clickItemStack = super.slotClick(parSlotId, parMouseButtonId, parClickMode, parPlayer);
        if (this.inventorySlots.size() > parSlotId && parSlotId >= 0 && this.inventorySlots.get(parSlotId) != null && this.inventorySlots.get(parSlotId).inventory == this.inputInventory) {
            this.onCraftMatrixChanged((IInventory)this.inputInventory);
        }
        return clickItemStack;
    }
    
    public void onContainerClosed(final EntityPlayer parPlayer) {
        if (this.playerInventory.getItemStack() != null) {
            parPlayer.entityDropItem(this.playerInventory.getItemStack(), 0.5f);
        }
        if (!this.worldObj.isRemote) {
            ItemStack itemStack = this.inputInventory.getStackInSlotOnClosing(0);
            if (itemStack != null) {
                parPlayer.entityDropItem(itemStack, 0.5f);
            }
            for (int i = 0; i < this.outputInventory.getSizeInventory(); ++i) {
                itemStack = this.outputInventory.getStackInSlotOnClosing(i);
                if (itemStack != null) {
                    parPlayer.entityDropItem(itemStack, 0.5f);
                }
            }
        }
    }
    
    public boolean canInteractWith(final EntityPlayer player) {
        return true;
    }
    
    public ItemStack transferStackInSlot(final EntityPlayer parPlayer, final int parSlotIndex) {
        final Slot slot = this.inventorySlots.get(parSlotIndex);
        if (slot != null && slot.getHasStack()) {
            if (slot.inventory.equals(this.inputInventory) || slot.inventory.equals(this.outputInventory)) {
                if (!this.playerInventory.addItemStackToInventory(slot.getStack())) {
                    return null;
                }
                slot.putStack((ItemStack)null);
                slot.onSlotChanged();
            }
            else if (slot.inventory.equals(this.playerInventory)) {
                System.out.println("Shift-clicked on player inventory slot");
                if (!this.inventorySlots.get(this.inputSlotNumber).getHasStack()) {
                    this.inventorySlots.get(this.inputSlotNumber).putStack(slot.getStack());
                    slot.putStack((ItemStack)null);
                    slot.onSlotChanged();
                }
                else {
                    System.out.println("There is already something in the input slot");
                }
            }
        }
        return null;
    }
    
    public Slot getSlot(int parSlotIndex) {
        if (parSlotIndex >= this.inventorySlots.size()) {
            parSlotIndex = this.inventorySlots.size() - 1;
        }
        return super.getSlot(parSlotIndex);
    }
    
    public enum State
    {
        ERROR, 
        READY;
        
        private static final /* synthetic */ State[] $VALUES;
        
        public static State[] values() {
            return State.$VALUES.clone();
        }
        
        public static State valueOf(final String name) {
            return Enum.valueOf(State.class, name);
        }
        
        static {
            $VALUES = new State[] { State.ERROR, State.READY };
        }
    }
}
