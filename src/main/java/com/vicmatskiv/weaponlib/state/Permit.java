package com.vicmatskiv.weaponlib.state;

import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;

public class Permit<S extends ManagedState<S>> extends UniversalObject
{
    protected S state;
    protected Status status;
    protected long timestamp;
    
    public Permit() {
        super();
        this.status = Status.UNKNOWN;
    }
    
    public Permit(final S state) {
        super();
        this.state = state;
        this.status = Status.REQUESTED;
        this.timestamp = System.currentTimeMillis();
    }
    
    public S getState() {
        return this.state;
    }
    
    public void setStatus(final Status status) {
        this.status = status;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public long getTimestamp() {
        return this.timestamp;
    }
    
    @Override
    public void init(final ByteBuf buf) {
        super.init(buf);
        this.timestamp = buf.readLong();
        this.status = Status.values()[buf.readInt()];
        this.state = TypeRegistry.getInstance().fromBytes(buf);
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        super.serialize(buf);
        buf.writeLong(this.timestamp);
        buf.writeInt(this.status.ordinal());
        TypeRegistry.getInstance().toBytes(this.state, buf);
    }
    
    static {
        TypeRegistry.getInstance().register(Permit.class);
    }
    
    public enum Status
    {
        REQUESTED, 
        GRANTED, 
        DENIED, 
        UNKNOWN;
        
        private static final /* synthetic */ Status[] $VALUES;
        
        public static Status[] values() {
            return Status.$VALUES.clone();
        }
        
        public static Status valueOf(final String name) {
            return Enum.valueOf(Status.class, name);
        }
        
        static {
            $VALUES = new Status[] { Status.REQUESTED, Status.GRANTED, Status.DENIED, Status.UNKNOWN };
        }
    }
}
