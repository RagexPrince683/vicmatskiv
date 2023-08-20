package com.vicmatskiv.weaponlib.melee;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class TryAttackMessageHandler implements CompatibleMessageHandler<TryAttackMessage, CompatibleMessage>
{
    private MeleeAttackAspect attackAspect;
    
    public TryAttackMessageHandler(final MeleeAttackAspect attackAspect) {
        super();
        this.attackAspect = attackAspect;
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final TryAttackMessage message, final CompatibleMessageContext ctx) {
        if (ctx.isServerSide()) {
            final EntityPlayer player = ctx.getPlayer();
            final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)player);
            if (itemStack != null && itemStack.getItem() instanceof ItemMelee) {
                ctx.runInMainThread(() -> this.attackAspect.serverAttack(player2, tryAttackMessage.getInstance(), tryAttackMessage.getEntity(CompatibilityProvider.compatibility.world((Entity)player2)), tryAttackMessage.isHeavyAttack()));
            }
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((TryAttackMessage)compatibleMessage, ctx);
    }
    
    private /* synthetic */ void lambda$onCompatibleMessage$279(final EntityPlayer player, final TryAttackMessage tryAttackMessage) {
        this.attackAspect.serverAttack(player, tryAttackMessage.getInstance(), tryAttackMessage.getEntity(CompatibilityProvider.compatibility.world((Entity)player)), tryAttackMessage.isHeavyAttack());
    }
}
