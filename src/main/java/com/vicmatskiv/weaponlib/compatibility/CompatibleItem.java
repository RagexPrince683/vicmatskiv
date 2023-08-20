package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.texture.*;

public abstract class CompatibleItem extends Item
{
    public CompatibleItem() {
        super();
    }
    
    public void onCreated(final ItemStack stack, final World worldIn, final EntityPlayer playerIn) {
        super.onCreated(stack, worldIn, playerIn);
        stack.setTagCompound(new NBTTagCompound());
    }
    
    public final ItemStack onItemRightClick(final ItemStack itemStack, final World world, final EntityPlayer player) {
        return this.onCompatibleItemRightClick(itemStack, world, player, true);
    }
    
    protected ItemStack onCompatibleItemRightClick(final ItemStack itemStack, final World world, final EntityPlayer player, final boolean mainHand) {
        return itemStack;
    }
    
    public final boolean onItemUseFirst(final ItemStack stack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ) {
        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
    
    protected boolean onItemUseFirst(final ItemStack stack, final EntityPlayer player, final World world) {
        return false;
    }
    
    public void registerIcons(final IIconRegister register) {
    }
}
