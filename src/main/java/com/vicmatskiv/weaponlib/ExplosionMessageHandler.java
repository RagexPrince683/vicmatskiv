package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class ExplosionMessageHandler implements CompatibleMessageHandler<ExplosionMessage, CompatibleMessage>
{
    private ModContext modContext;
    
    public ExplosionMessageHandler(final ModContext modContext) {
        super();
        this.modContext = modContext;
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final ExplosionMessage message, final CompatibleMessageContext ctx) {
        if (!ctx.isServerSide()) {
            final EntityPlayer player = CompatibilityProvider.compatibility.clientPlayer();
            CompatibilityProvider.compatibility.runInMainClientThread(() -> {
                final Explosion explosion = new Explosion(this.modContext, CompatibilityProvider.compatibility.world((Entity)entityPlayer), null, explosionMessage.getPosX(), explosionMessage.getPosY(), explosionMessage.getPosZ(), explosionMessage.getStrength(), explosionMessage.getAffectedBlockPositions());
                explosion.doExplosionB(true);
                entityPlayer.motionX += explosionMessage.getMotionX();
                entityPlayer.motionY += explosionMessage.getMotionY();
                entityPlayer.motionZ += explosionMessage.getMotionZ();
                return;
            });
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((ExplosionMessage)compatibleMessage, ctx);
    }
    
    private /* synthetic */ void lambda$onCompatibleMessage$272(final EntityPlayer entityPlayer, final ExplosionMessage explosionMessage) {
        final Explosion explosion = new Explosion(this.modContext, CompatibilityProvider.compatibility.world((Entity)entityPlayer), null, explosionMessage.getPosX(), explosionMessage.getPosY(), explosionMessage.getPosZ(), explosionMessage.getStrength(), explosionMessage.getAffectedBlockPositions());
        explosion.doExplosionB(true);
        entityPlayer.motionX += explosionMessage.getMotionX();
        entityPlayer.motionY += explosionMessage.getMotionY();
        entityPlayer.motionZ += explosionMessage.getMotionZ();
    }
}
