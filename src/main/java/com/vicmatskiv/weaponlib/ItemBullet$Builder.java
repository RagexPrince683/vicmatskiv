package com.vicmatskiv.weaponlib;

import java.util.*;

public static final class Builder extends AttachmentBuilder<Weapon>
{
    private List<ItemMagazine> compatibleMagazines;
    
    public Builder() {
        super();
        this.compatibleMagazines = new ArrayList<ItemMagazine>();
        this.withMaxStackSize(64);
    }
    
    public Builder withCompatibleMagazine(final ItemMagazine magazine) {
        this.compatibleMagazines.add(magazine);
        return this;
    }
    
    @Override
    protected ItemAttachment<Weapon> createAttachment(final ModContext modContext) {
        final ItemBullet bullet = new ItemBullet(this.getModId(), AttachmentCategory.BULLET, this.getModel(), this.getTextureName(), null, null, null);
        ItemBullet.access$002(bullet, this.compatibleMagazines);
        return bullet;
    }
}
