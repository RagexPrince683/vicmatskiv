package com.vicmatskiv.weaponlib.blocks;

import cpw.mods.fml.common.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.resources.*;

public class GuiHandler implements IGuiHandler
{
    public GuiHandler() {
        super();
    }
    
    public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity != null) {
            throw new UnsupportedOperationException("Implement me");
        }
        if (ID == BlockSmith.GUI_ENUM.DECONSTRUCTOR.ordinal()) {
            return new ContainerDeconstructor(player.inventory, world, x, y, z);
        }
        if (ID == 1000000) {
            return new ContainerConstructor(player.inventory, world, x, y, z);
        }
        return null;
    }
    
    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity != null) {
            throw new UnsupportedOperationException("Implement me");
        }
        if (ID == BlockSmith.GUI_ENUM.DECONSTRUCTOR.ordinal()) {
            return new GuiDeconstructor(player.inventory, world, I18n.format("tile.deconstructor.name", new Object[0]), x, y, z);
        }
        if (ID == 1000000) {
            return new GuiConstructor(player.inventory, world, I18n.format("tile.constructor.name", new Object[0]), x, y, z);
        }
        return null;
    }
}
