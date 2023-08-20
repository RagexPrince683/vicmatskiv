package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class TryFireMessageHandler implements CompatibleMessageHandler<TryFireMessage, CompatibleMessage>
{
    private WeaponFireAspect fireManager;
    
    TryFireMessageHandler(final WeaponFireAspect fireManager) {
        super();
        this.fireManager = fireManager;
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final TryFireMessage message, final CompatibleMessageContext ctx) {
        if (ctx.isServerSide()) {
            final EntityPlayer player = ctx.getPlayer();
            final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)player);
            if (itemStack != null && itemStack.getItem() instanceof Weapon && message.isOn()) {
                ctx.runInMainThread(() -> this.fireManager.serverFire(player2, itemStack2));
            }
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((TryFireMessage)compatibleMessage, ctx);
    }
    
    private /* synthetic */ void lambda$onCompatibleMessage$284(final EntityPlayer player, final ItemStack itemStack) {
        this.fireManager.serverFire(player, itemStack);
    }
}
