package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;
import io.netty.buffer.*;

public static class ChangeAttachmentPermit extends Permit<WeaponState>
{
    AttachmentCategory attachmentCategory;
    
    public ChangeAttachmentPermit() {
        super();
    }
    
    public ChangeAttachmentPermit(final AttachmentCategory attachmentCategory) {
        super(WeaponState.NEXT_ATTACHMENT);
        this.attachmentCategory = attachmentCategory;
    }
    
    @Override
    public void init(final ByteBuf buf) {
        super.init(buf);
        this.attachmentCategory = AttachmentCategory.values()[buf.readInt()];
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        super.serialize(buf);
        buf.writeInt(this.attachmentCategory.ordinal());
    }
}
