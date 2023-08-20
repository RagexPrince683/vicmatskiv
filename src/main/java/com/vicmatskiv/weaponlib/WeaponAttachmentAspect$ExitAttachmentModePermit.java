package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;

public static class ExitAttachmentModePermit extends Permit<WeaponState>
{
    public ExitAttachmentModePermit() {
        super();
    }
    
    public ExitAttachmentModePermit(final WeaponState state) {
        super(state);
    }
}
