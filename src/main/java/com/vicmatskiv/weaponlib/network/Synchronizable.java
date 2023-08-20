package com.vicmatskiv.weaponlib.network;

public interface Synchronizable<T, SyncContext>
{
    T sync(final SyncContext p0);
}
