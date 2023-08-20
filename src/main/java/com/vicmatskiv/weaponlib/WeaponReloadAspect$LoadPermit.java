package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;

public static class LoadPermit extends Permit<WeaponState>
{
    public LoadPermit() {
        super();
    }
    
    public LoadPermit(final WeaponState state) {
        super(state);
    }
}
