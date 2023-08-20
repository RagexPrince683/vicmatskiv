package com.vicmatskiv.weaponlib;

import net.minecraft.client.model.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import java.util.*;

public class ItemMagazine extends ItemAttachment<Weapon> implements PlayerItemInstanceFactory<PlayerMagazineInstance, MagazineState>, Reloadable, Updatable, Part
{
    private static final long DEFAULT_RELOADING_TIMEOUT_TICKS = 25L;
    private final int DEFAULT_MAX_STACK_SIZE = 1;
    private int ammo;
    private long reloadingTimeout;
    private List<ItemBullet> compatibleBullets;
    private CompatibleSound reloadSound;
    private ModContext modContext;
    
    ItemMagazine(final String modId, final ModelBase model, final String textureName, final int ammo) {
        this(modId, model, textureName, ammo, null, null);
    }
    
    ItemMagazine(final String modId, final ModelBase model, final String textureName, final int ammo, final ApplyHandler<Weapon> apply, final ApplyHandler<Weapon> remove) {
        super(modId, AttachmentCategory.MAGAZINE, model, textureName, null, apply, remove);
        this.ammo = ammo;
        this.setMaxStackSize(1);
    }
    
    ItemStack createItemStack() {
        final ItemStack attachmentItemStack = new ItemStack((Item)this);
        this.ensureItemStack(attachmentItemStack, this.ammo);
        return attachmentItemStack;
    }
    
    private void ensureItemStack(final ItemStack itemStack, final int initialAmmo) {
        if (CompatibilityProvider.compatibility.getTagCompound(itemStack) == null) {
            CompatibilityProvider.compatibility.setTagCompound(itemStack, new NBTTagCompound());
            Tags.setAmmo(itemStack, initialAmmo);
        }
    }
    
    @Override
    public void onCreated(final ItemStack stack, final World p_77622_2_, final EntityPlayer p_77622_3_) {
        this.ensureItemStack(stack, 0);
        super.onCreated(stack, p_77622_2_, p_77622_3_);
    }
    
    public boolean onItemUseFirst(final ItemStack stack, final EntityPlayer player, final World world) {
        return super.onItemUseFirst(stack, player, world);
    }
    
    public void onUpdate(final ItemStack stack, final World world, final Entity entity, final int p_77663_4_, final boolean p_77663_5_) {
        this.ensureItemStack(stack, this.ammo);
        super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);
    }
    
    List<ItemBullet> getCompatibleBullets() {
        return this.compatibleBullets;
    }
    
    int getAmmo() {
        return this.ammo;
    }
    
    public CompatibleSound getReloadSound() {
        return this.reloadSound;
    }
    
    public long getReloadTimeout() {
        return this.reloadingTimeout;
    }
    
    @Override
    public Part getRenderablePart() {
        return this;
    }
    
    @Override
    public PlayerMagazineInstance createItemInstance(final EntityPlayer player, final ItemStack itemStack, final int slot) {
        final PlayerMagazineInstance instance = new PlayerMagazineInstance(slot, player, itemStack);
        instance.setState(MagazineState.READY);
        return instance;
    }
    
    @Override
    public void update(final EntityPlayer player) {
        this.modContext.getMagazineReloadAspect().updateMainHeldItem(player);
    }
    
    @Override
    public void reloadMainHeldItemForPlayer(final EntityPlayer player) {
        this.modContext.getMagazineReloadAspect().reloadMainHeldItem(player);
    }
    
    @Override
    public /* bridge */ PlayerItemInstance createItemInstance(final EntityPlayer player, final ItemStack itemStack, final int slot) {
        return this.createItemInstance(player, itemStack, slot);
    }
    
    static /* synthetic */ long access$002(final ItemMagazine x0, final long x1) {
        return x0.reloadingTimeout = x1;
    }
    
    static /* synthetic */ List access$102(final ItemMagazine x0, final List x1) {
        return x0.compatibleBullets = x1;
    }
    
    static /* synthetic */ CompatibleSound access$202(final ItemMagazine x0, final CompatibleSound x1) {
        return x0.reloadSound = x1;
    }
    
    static /* synthetic */ ModContext access$302(final ItemMagazine x0, final ModContext x1) {
        return x0.modContext = x1;
    }
    
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
            magazine.reloadingTimeout = this.reloadingTimeout;
            magazine.compatibleBullets = (List<ItemBullet>)new ArrayList(this.compatibleBullets);
            if (this.reloadSound != null) {
                magazine.reloadSound = modContext.registerSound(this.reloadSound);
            }
            magazine.modContext = modContext;
            this.withInformationProvider(stack -> "Ammo: " + Tags.getAmmo(stack) + "/" + this.ammo);
            return magazine;
        }
        
        private /* synthetic */ String lambda$createAttachment$198(final ItemStack stack) {
            return "Ammo: " + Tags.getAmmo(stack) + "/" + this.ammo;
        }
    }
}
