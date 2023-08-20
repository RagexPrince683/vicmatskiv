package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public interface PlayerItemInstanceFactory<T extends PlayerItemInstance<S>, S extends ManagedState<S>>
{
    T createItemInstance(final EntityPlayer p0, final ItemStack p1, final int p2);
}
