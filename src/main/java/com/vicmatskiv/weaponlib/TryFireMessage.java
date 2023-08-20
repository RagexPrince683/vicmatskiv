package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import io.netty.buffer.*;

public class TryFireMessage implements CompatibleMessage
{
    private boolean on;
    
    public TryFireMessage() {
        super();
    }
    
    public TryFireMessage(final boolean on) {
        super();
        this.on = on;
    }
    
    public boolean isOn() {
        return this.on;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.on = buf.readBoolean();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeBoolean(this.on);
    }
}
