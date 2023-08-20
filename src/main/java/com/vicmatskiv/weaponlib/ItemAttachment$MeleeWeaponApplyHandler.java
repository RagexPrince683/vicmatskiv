package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.melee.*;

public interface MeleeWeaponApplyHandler<T>
{
    void apply(final ItemAttachment<T> p0, final PlayerMeleeInstance p1);
}
