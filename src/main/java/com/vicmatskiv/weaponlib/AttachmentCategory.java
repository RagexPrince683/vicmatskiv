package com.vicmatskiv.weaponlib;

public enum AttachmentCategory
{
    SCOPE, 
    GRIP, 
    SILENCER, 
    MAGAZINE, 
    BULLET, 
    SKIN, 
    EXTRA, 
    EXTRA2, 
    EXTRA3, 
    EXTRA4, 
    EXTRA5, 
    EXTRA6, 
    EXTRA7, 
    EXTRA8;
    
    public static final AttachmentCategory[] values;
    private static final /* synthetic */ AttachmentCategory[] $VALUES;
    
    public static AttachmentCategory[] values() {
        return AttachmentCategory.$VALUES.clone();
    }
    
    public static AttachmentCategory valueOf(final String name) {
        return Enum.valueOf(AttachmentCategory.class, name);
    }
    
    public static AttachmentCategory valueOf(final int ordinal) {
        return AttachmentCategory.values[ordinal];
    }
    
    static {
        $VALUES = new AttachmentCategory[] { AttachmentCategory.SCOPE, AttachmentCategory.GRIP, AttachmentCategory.SILENCER, AttachmentCategory.MAGAZINE, AttachmentCategory.BULLET, AttachmentCategory.SKIN, AttachmentCategory.EXTRA, AttachmentCategory.EXTRA2, AttachmentCategory.EXTRA3, AttachmentCategory.EXTRA4, AttachmentCategory.EXTRA5, AttachmentCategory.EXTRA6, AttachmentCategory.EXTRA7, AttachmentCategory.EXTRA8 };
        values = values();
    }
}
