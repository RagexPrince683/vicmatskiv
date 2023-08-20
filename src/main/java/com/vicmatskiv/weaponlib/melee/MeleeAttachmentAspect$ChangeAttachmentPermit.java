package com.vicmatskiv.weaponlib.melee;

import com.vicmatskiv.weaponlib.state.*;
import com.vicmatskiv.weaponlib.*;
import io.netty.buffer.*;

public static class ChangeAttachmentPermit extends Permit<MeleeState>
{
    AttachmentCategory attachmentCategory;
    
    public ChangeAttachmentPermit() {
        super();
    }
    
    public ChangeAttachmentPermit(final AttachmentCategory attachmentCategory) {
        super(MeleeState.NEXT_ATTACHMENT);
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
