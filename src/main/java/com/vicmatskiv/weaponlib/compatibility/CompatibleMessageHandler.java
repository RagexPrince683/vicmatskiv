package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.network.simpleimpl.*;

public interface CompatibleMessageHandler<Request extends CompatibleMessage, Response extends CompatibleMessage> extends IMessageHandler<Request, Response>
{
    default Response onMessage(final Request message, final MessageContext ctx) {
        return this.onCompatibleMessage(message, new CompatibleMessageContext(ctx));
    }
    
     <T extends CompatibleMessage> T onCompatibleMessage(final Request p0, final CompatibleMessageContext p1);
    
    default /* bridge */ IMessage onMessage(final IMessage message, final MessageContext ctx) {
        return this.onMessage((CompatibleMessage)message, ctx);
    }
}
