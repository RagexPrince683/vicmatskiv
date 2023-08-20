package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;

public static class LoadPermit extends Permit<MagazineState>
{
    public LoadPermit() {
        super();
    }
    
    public LoadPermit(final MagazineState state) {
        super(state);
    }
}
