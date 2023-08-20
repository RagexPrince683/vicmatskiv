package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;

public interface PlayerContext
{
    EntityPlayer getPlayer();
    
    void setPlayer(final EntityPlayer p0);
}
