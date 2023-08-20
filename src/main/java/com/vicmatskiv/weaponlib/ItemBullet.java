package com.vicmatskiv.weaponlib;

import net.minecraft.client.model.*;
import java.util.*;

public class ItemBullet extends ItemAttachment<Weapon>
{
    private List<ItemMagazine> compatibleMagazines;
    
    public ItemBullet(final String modId, final AttachmentCategory category, final ModelBase model, final String textureName, final String crosshair, final ApplyHandler<Weapon> apply, final ApplyHandler<Weapon> remove) {
        super(modId, category, model, textureName, crosshair, apply, remove);
        this.compatibleMagazines = new ArrayList<ItemMagazine>();
    }
    
    static /* synthetic */ List access$002(final ItemBullet x0, final List x1) {
        return x0.compatibleMagazines = x1;
    }
    
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
            bullet.compatibleMagazines = this.compatibleMagazines;
            return bullet;
        }
    }
}
