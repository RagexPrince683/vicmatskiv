package com.vicmatskiv.weaponlib.network;

import java.util.*;
import io.netty.buffer.*;

public abstract class UniversalObject implements UniversallySerializable
{
    private UUID uuid;
    
    protected int getSerialVersion() {
        return 0;
    }
    
    protected UniversalObject() {
        super();
        this.uuid = UUID.randomUUID();
    }
    
    public UUID getUuid() {
        return this.uuid;
    }
    
    @Override
    public void init(final ByteBuf buf) {
        if (this.getSerialVersion() != buf.readInt()) {
            throw new IndexOutOfBoundsException("Serial version mismatch");
        }
        this.uuid = new UUID(buf.readLong(), buf.readLong());
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        buf.writeInt(this.getSerialVersion());
        buf.writeLong(this.uuid.getMostSignificantBits());
        buf.writeLong(this.uuid.getLeastSignificantBits());
    }
}
