package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;

public class PlayerMagazineInstance extends PlayerItemInstance<MagazineState>
{
    public PlayerMagazineInstance() {
        super();
    }
    
    public PlayerMagazineInstance(final int itemInventoryIndex, final EntityPlayer player, final ItemStack itemStack) {
        super(itemInventoryIndex, player, itemStack);
    }
    
    public PlayerMagazineInstance(final int itemInventoryIndex, final EntityPlayer player) {
        super(itemInventoryIndex, player);
    }
    
    @Override
    public void init(final ByteBuf buf) {
        super.init(buf);
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        super.serialize(buf);
    }
    
    @Override
    protected void updateWith(final PlayerItemInstance<MagazineState> otherItemInstance, final boolean updateManagedState) {
        super.updateWith(otherItemInstance, updateManagedState);
    }
    
    public ItemMagazine getMagazine() {
        return (ItemMagazine)this.item;
    }
    
    static {
        TypeRegistry.getInstance().register(PlayerMagazineInstance.class);
    }
}
