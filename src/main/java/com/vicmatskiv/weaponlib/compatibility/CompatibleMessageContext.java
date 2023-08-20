package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.network.simpleimpl.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.player.*;

public class CompatibleMessageContext
{
    private MessageContext ctx;
    
    public CompatibleMessageContext(final MessageContext ctx) {
        super();
        this.ctx = ctx;
    }
    
    public boolean isServerSide() {
        return this.ctx.side == Side.SERVER;
    }
    
    public EntityPlayer getPlayer() {
        return (EntityPlayer)this.ctx.getServerHandler().playerEntity;
    }
    
    public void runInMainThread(final Runnable runnable) {
        runnable.run();
    }
}
