package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import java.util.*;

public interface AttachmentContainer
{
    List<CompatibleAttachment<? extends AttachmentContainer>> getActiveAttachments(final EntityPlayer p0, final ItemStack p1);
    
    Collection<CompatibleAttachment<? extends AttachmentContainer>> getCompatibleAttachments(final AttachmentCategory... p0);
}
