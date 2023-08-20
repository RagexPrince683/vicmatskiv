package com.vicmatskiv.weaponlib.melee;

import com.vicmatskiv.weaponlib.state.*;

public static class EnterAttachmentModePermit extends Permit<MeleeState>
{
    public EnterAttachmentModePermit() {
        super();
    }
    
    public EnterAttachmentModePermit(final MeleeState state) {
        super(state);
    }
}
