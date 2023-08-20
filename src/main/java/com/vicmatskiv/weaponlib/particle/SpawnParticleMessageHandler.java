package com.vicmatskiv.weaponlib.particle;

import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;

public class SpawnParticleMessageHandler implements CompatibleMessageHandler<SpawnParticleMessage, CompatibleMessage>
{
    private ModContext modContext;
    private double yOffset;
    
    public SpawnParticleMessageHandler(final ModContext modContext) {
        super();
        this.yOffset = 1.0;
        this.modContext = modContext;
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final SpawnParticleMessage message, final CompatibleMessageContext ctx) {
        if (!ctx.isServerSide()) {
            CompatibilityProvider.compatibility.runInMainClientThread(() -> {
                for (int i = 0; i < spawnParticleMessage.getCount(); ++i) {
                    switch (spawnParticleMessage.getParticleType()) {
                        case BLOOD: {
                            CompatibilityProvider.compatibility.addBreakingParticle(this.modContext, spawnParticleMessage.getPosX(), spawnParticleMessage.getPosY(), spawnParticleMessage.getPosZ());
                            break;
                        }
                        case SMOKE_GRENADE_SMOKE: {
                            this.modContext.getEffectManager().spawnExplosionSmoke(spawnParticleMessage.getPosX(), spawnParticleMessage.getPosY(), spawnParticleMessage.getPosZ(), spawnParticleMessage.getMotionX(), spawnParticleMessage.getMotionY(), spawnParticleMessage.getMotionZ(), 0.2f * CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer()).rand.nextFloat(), 300, ExplosionSmokeFX.Behavior.SMOKE_GRENADE);
                            break;
                        }
                    }
                }
                return;
            });
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((SpawnParticleMessage)compatibleMessage, ctx);
    }
    
    private /* synthetic */ void lambda$onCompatibleMessage$280(final SpawnParticleMessage spawnParticleMessage) {
        for (int i = 0; i < spawnParticleMessage.getCount(); ++i) {
            switch (spawnParticleMessage.getParticleType()) {
                case BLOOD: {
                    CompatibilityProvider.compatibility.addBreakingParticle(this.modContext, spawnParticleMessage.getPosX(), spawnParticleMessage.getPosY(), spawnParticleMessage.getPosZ());
                    break;
                }
                case SMOKE_GRENADE_SMOKE: {
                    this.modContext.getEffectManager().spawnExplosionSmoke(spawnParticleMessage.getPosX(), spawnParticleMessage.getPosY(), spawnParticleMessage.getPosZ(), spawnParticleMessage.getMotionX(), spawnParticleMessage.getMotionY(), spawnParticleMessage.getMotionZ(), 0.2f * CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer()).rand.nextFloat(), 300, ExplosionSmokeFX.Behavior.SMOKE_GRENADE);
                    break;
                }
            }
        }
    }
}
