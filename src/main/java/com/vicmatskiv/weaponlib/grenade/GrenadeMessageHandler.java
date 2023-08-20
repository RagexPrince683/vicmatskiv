package com.vicmatskiv.weaponlib.grenade;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class GrenadeMessageHandler implements CompatibleMessageHandler<GrenadeMessage, CompatibleMessage>
{
    private GrenadeAttackAspect attackAspect;
    
    public GrenadeMessageHandler(final GrenadeAttackAspect attackAspect) {
        super();
        this.attackAspect = attackAspect;
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final GrenadeMessage message, final CompatibleMessageContext ctx) {
        if (ctx.isServerSide()) {
            final EntityPlayer player = ctx.getPlayer();
            final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)player);
            if (itemStack != null && itemStack.getItem() instanceof ItemGrenade) {
                ctx.runInMainThread(() -> {
                    grenadeMessage.getInstance().setPlayer(entityPlayer);
                    this.attackAspect.serverThrowGrenade(entityPlayer, grenadeMessage.getInstance(), grenadeMessage.getActivationTimestamp());
                    return;
                });
            }
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((GrenadeMessage)compatibleMessage, ctx);
    }
    
    private /* synthetic */ void lambda$onCompatibleMessage$274(final GrenadeMessage grenadeMessage, final EntityPlayer entityPlayer) {
        grenadeMessage.getInstance().setPlayer(entityPlayer);
        this.attackAspect.serverThrowGrenade(entityPlayer, grenadeMessage.getInstance(), grenadeMessage.getActivationTimestamp());
    }
}
