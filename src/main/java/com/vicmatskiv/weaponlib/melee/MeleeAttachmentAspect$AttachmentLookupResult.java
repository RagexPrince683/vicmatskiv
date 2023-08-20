package com.vicmatskiv.weaponlib.melee;

import com.vicmatskiv.weaponlib.*;

private static class AttachmentLookupResult
{
    CompatibleAttachment<ItemMelee> compatibleAttachment;
    int index;
    
    private AttachmentLookupResult() {
        super();
        this.index = -1;
    }
    
    AttachmentLookupResult(final MeleeAttachmentAspect$1 x0) {
        this();
    }
}
