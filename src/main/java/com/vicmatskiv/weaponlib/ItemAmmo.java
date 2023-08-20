package com.vicmatskiv.weaponlib;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class ItemAmmo extends Item
{
    private List<Weapon> compatibleWeapons;
    
    public ItemAmmo() {
        super();
        this.compatibleWeapons = new ArrayList<Weapon>();
    }
    
    public void addCompatibleWeapon(final Weapon weapon) {
        this.compatibleWeapons.add(weapon);
    }
    
    public void addInformation(final ItemStack itemStack, final EntityPlayer entityPlayer, final List info, final boolean p_77624_4_) {
        info.add("Compatible guns:");
        this.compatibleWeapons.forEach(weapon -> list.add(weapon.getName()));
    }
    
    private static /* synthetic */ void lambda$addInformation$234(final List list, final Weapon weapon) {
        list.add(weapon.getName());
    }
}
