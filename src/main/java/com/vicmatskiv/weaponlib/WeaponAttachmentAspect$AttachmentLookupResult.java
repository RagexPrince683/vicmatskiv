package com.vicmatskiv.weaponlib;

private static class AttachmentLookupResult
{
    CompatibleAttachment<Weapon> compatibleAttachment;
    int index;
    
    private AttachmentLookupResult() {
        super();
        this.index = -1;
    }
    
    AttachmentLookupResult(final WeaponAttachmentAspect$1 x0) {
        this();
    }
}
