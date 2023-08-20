package com.vicmatskiv.weaponlib.melee;

import com.vicmatskiv.weaponlib.state.*;

public static class ExitAttachmentModePermit extends Permit<MeleeState>
{
    public ExitAttachmentModePermit() {
        super();
    }
    
    public ExitAttachmentModePermit(final MeleeState state) {
        super(state);
    }
}
