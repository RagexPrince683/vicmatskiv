package com.vicmatskiv.weaponlib.network;

import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.state.*;
import io.netty.buffer.*;

public class PermitMessage implements CompatibleMessage
{
    private Permit<?> permit;
    private Object context;
    
    public PermitMessage() {
        super();
    }
    
    public PermitMessage(final Permit<?> permit, final Object context) {
        super();
        this.permit = permit;
        this.context = context;
    }
    
    public Permit<?> getPermit() {
        return this.permit;
    }
    
    public Object getContext() {
        return this.context;
    }
    
    public void fromBytes(final ByteBuf buf) {
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        this.context = typeRegistry.fromBytes(buf);
        this.permit = typeRegistry.fromBytes(buf);
    }
    
    public void toBytes(final ByteBuf buf) {
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        typeRegistry.toBytes(this.context, buf);
        typeRegistry.toBytes(this.permit, buf);
    }
}
