package com.vicmatskiv.weaponlib.grenade;

import net.minecraft.entity.player.*;

private static class StateManagerKey
{
    EntityPlayer player;
    int slot;
    
    public StateManagerKey(final EntityPlayer player, final int slot) {
        super();
        this.slot = -1;
        this.player = player;
        this.slot = slot;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.player == null) ? 0 : this.player.hashCode());
        result = 31 * result + this.slot;
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final StateManagerKey other = (StateManagerKey)obj;
        if (this.player == null) {
            if (other.player != null) {
                return false;
            }
        }
        else if (!this.player.equals((Object)other.player)) {
            return false;
        }
        return this.slot == other.slot;
    }
}
