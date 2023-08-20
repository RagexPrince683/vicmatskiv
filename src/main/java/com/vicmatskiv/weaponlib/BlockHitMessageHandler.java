package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;

public class BlockHitMessageHandler implements CompatibleMessageHandler<BlockHitMessage, CompatibleMessage>
{
    private ModContext modContext;
    
    public BlockHitMessageHandler(final ModContext modContext) {
        super();
        this.modContext = modContext;
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final BlockHitMessage message, final CompatibleMessageContext ctx) {
        if (!ctx.isServerSide()) {
            CompatibilityProvider.compatibility.runInMainClientThread(() -> CompatibilityProvider.compatibility.addBlockHitEffect(blockHitMessage.getPosX(), blockHitMessage.getPosY(), blockHitMessage.getPosZ(), blockHitMessage.getSideHit()));
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((BlockHitMessage)compatibleMessage, ctx);
    }
    
    private static /* synthetic */ void lambda$onCompatibleMessage$242(final BlockHitMessage blockHitMessage) {
        CompatibilityProvider.compatibility.addBlockHitEffect(blockHitMessage.getPosX(), blockHitMessage.getPosY(), blockHitMessage.getPosZ(), blockHitMessage.getSideHit());
    }
}
