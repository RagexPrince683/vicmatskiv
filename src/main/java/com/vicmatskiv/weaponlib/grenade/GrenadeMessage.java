package com.vicmatskiv.weaponlib.grenade;

import com.vicmatskiv.weaponlib.compatibility.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;

public class GrenadeMessage implements CompatibleMessage
{
    private PlayerGrenadeInstance instance;
    private long activationTimestamp;
    
    public GrenadeMessage() {
        super();
    }
    
    public GrenadeMessage(final PlayerGrenadeInstance instance, final long activationTimestamp) {
        super();
        this.instance = instance;
        this.activationTimestamp = activationTimestamp;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.instance = TypeRegistry.getInstance().fromBytes(buf);
        this.activationTimestamp = buf.readLong();
    }
    
    public void toBytes(final ByteBuf buf) {
        TypeRegistry.getInstance().toBytes(this.instance, buf);
        buf.writeLong(this.activationTimestamp);
    }
    
    public PlayerGrenadeInstance getInstance() {
        return this.instance;
    }
    
    public long getActivationTimestamp() {
        return this.activationTimestamp;
    }
}
