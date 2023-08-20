package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;

public static class UnloadPermit extends Permit<WeaponState>
{
    public UnloadPermit() {
        super();
    }
    
    public UnloadPermit(final WeaponState state) {
        super(state);
    }
}
