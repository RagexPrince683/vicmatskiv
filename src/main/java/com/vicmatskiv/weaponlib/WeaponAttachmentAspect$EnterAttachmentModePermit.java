package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;

public static class EnterAttachmentModePermit extends Permit<WeaponState>
{
    public EnterAttachmentModePermit() {
        super();
    }
    
    public EnterAttachmentModePermit(final WeaponState state) {
        super(state);
    }
}
