package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;

public interface ApplyHandler<T>
{
    void apply(final ItemAttachment<T> p0, final T p1, final EntityPlayer p2);
}
