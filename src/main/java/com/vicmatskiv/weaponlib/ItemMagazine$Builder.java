package com.vicmatskiv.weaponlib;

import java.util.*;
import net.minecraft.item.*;

public static final class Builder extends AttachmentBuilder<Weapon>
{
    private int ammo;
    private long reloadingTimeout;
    private Set<ItemBullet> compatibleBullets;
    private String reloadSound;
    
    public Builder() {
        super();
        this.reloadingTimeout = 25L;
        this.compatibleBullets = new HashSet<ItemBullet>();
    }
    
    public Builder withAmmo(final int ammo) {
        this.ammo = ammo;
        return this;
    }
    
    public Builder withReloadingTimeout(final int reloadingTimeout) {
        this.reloadingTimeout = reloadingTimeout;
        return this;
    }
    
    public Builder withReloadSound(final String reloadSound) {
        this.reloadSound = reloadSound;
        return this;
    }
    
    public Builder withCompatibleBullet(final ItemBullet compatibleBullet) {
        this.compatibleBullets.add(compatibleBullet);
        return this;
    }
    
    @Override
    protected ItemAttachment<Weapon> createAttachment(final ModContext modContext) {
        final ItemMagazine magazine = new ItemMagazine(this.getModId(), this.getModel(), this.getTextureName(), this.ammo);
        ItemMagazine.access$002(magazine, this.reloadingTimeout);
        ItemMagazine.access$102(magazine, new ArrayList(this.compatibleBullets));
        if (this.reloadSound != null) {
            ItemMagazine.access$202(magazine, modContext.registerSound(this.reloadSound));
        }
        ItemMagazine.access$302(magazine, modContext);
        this.withInformationProvider(stack -> "Ammo: " + Tags.getAmmo(stack) + "/" + this.ammo);
        return magazine;
    }
    
    private /* synthetic */ String lambda$createAttachment$198(final ItemStack stack) {
        return "Ammo: " + Tags.getAmmo(stack) + "/" + this.ammo;
    }
}
