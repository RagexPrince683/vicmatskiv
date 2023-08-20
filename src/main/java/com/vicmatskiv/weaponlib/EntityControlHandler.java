package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;

public class EntityControlHandler implements CompatibleMessageHandler<EntityControlMessage, CompatibleMessage>
{
    private ModContext modContext;
    
    public EntityControlHandler(final ModContext modContext) {
        super();
        this.modContext = modContext;
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final EntityControlMessage message, final CompatibleMessageContext ctx) {
        if (!ctx.isServerSide()) {
            CompatibilityProvider.compatibility.runInMainClientThread(() -> {});
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((EntityControlMessage)compatibleMessage, ctx);
    }
    
    private static /* synthetic */ void lambda$onCompatibleMessage$271() {
    }
}
