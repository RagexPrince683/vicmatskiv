package com.vicmatskiv.weaponlib.compatibility;

import cpw.mods.fml.common.network.simpleimpl.*;

public class CompatibleChannel
{
    private SimpleNetworkWrapper channel;
    
    public CompatibleChannel(final SimpleNetworkWrapper channel) {
        super();
        this.channel = channel;
    }
    
    public SimpleNetworkWrapper getChannel() {
        return this.channel;
    }
    
    public <Request extends CompatibleMessage, Response extends CompatibleMessage> void registerMessage(final CompatibleMessageHandler<? super Request, ? extends Response> messageHandler, final Class<Request> requestMessageType, final int discriminator, final CompatibleSide side) {
        this.channel.registerMessage((IMessageHandler)messageHandler, (Class)requestMessageType, discriminator, side.getSide());
    }
    
    public void sendToAllAround(final CompatibleMessage spawnParticleMessage, final CompatibleTargetPoint point) {
        this.channel.sendToAllAround((IMessage)spawnParticleMessage, point.getTargetPoint());
    }
}
