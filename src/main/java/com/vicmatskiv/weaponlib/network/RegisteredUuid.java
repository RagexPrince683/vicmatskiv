package com.vicmatskiv.weaponlib.network;

import java.util.*;

public final class RegisteredUuid
{
    private UUID value;
    
    RegisteredUuid(final UUID value) {
        super();
        this.value = value;
    }
    
    public UUID getValue() {
        return this.value;
    }
}
