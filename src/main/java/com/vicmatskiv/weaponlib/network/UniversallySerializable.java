package com.vicmatskiv.weaponlib.network;

import io.netty.buffer.*;

public interface UniversallySerializable
{
    void init(final ByteBuf p0);
    
    void serialize(final ByteBuf p0);
}
