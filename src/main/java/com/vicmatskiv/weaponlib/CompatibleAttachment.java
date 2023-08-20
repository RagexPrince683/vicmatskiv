package com.vicmatskiv.weaponlib;

import net.minecraft.client.model.*;
import java.util.function.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.melee.*;

public class CompatibleAttachment<T>
{
    private ItemAttachment<T> attachment;
    private Consumer<ModelBase> modelPositioning;
    private BiConsumer<EntityPlayer, ItemStack> positioning;
    private boolean isDefault;
    private boolean isPermanent;
    private ItemAttachment.ApplyHandler2<T> applyHandler;
    private ItemAttachment.ApplyHandler2<T> removeHandler;
    ItemAttachment.MeleeWeaponApplyHandler<ItemMelee> meleeApplyHandler;
    ItemAttachment.MeleeWeaponApplyHandler<ItemMelee> meleeRemoveHandler;
    
    public CompatibleAttachment(final ItemAttachment<T> attachment, final BiConsumer<EntityPlayer, ItemStack> positioning, final Consumer<ModelBase> modelPositioning, final boolean isDefault, final boolean isPermanent) {
        super();
        this.attachment = attachment;
        this.positioning = positioning;
        this.modelPositioning = modelPositioning;
        this.isDefault = isDefault;
        this.isPermanent = isPermanent;
    }
    
    public CompatibleAttachment(final ItemAttachment<T> attachment, final BiConsumer<EntityPlayer, ItemStack> positioning, final Consumer<ModelBase> modelPositioning, final boolean isDefault) {
        this(attachment, positioning, modelPositioning, isDefault, false);
    }
    
    public CompatibleAttachment(final ItemAttachment<T> attachment, final ItemAttachment.ApplyHandler2<T> applyHandler, final ItemAttachment.ApplyHandler2<T> removeHandler) {
        super();
        this.attachment = attachment;
        this.applyHandler = applyHandler;
        this.removeHandler = removeHandler;
    }
    
    public CompatibleAttachment(final ItemAttachment<T> attachment, final ItemAttachment.MeleeWeaponApplyHandler<ItemMelee> meleeApplyHandler, final ItemAttachment.MeleeWeaponApplyHandler<ItemMelee> meleeRemoveHandler) {
        super();
        this.attachment = attachment;
        this.meleeApplyHandler = meleeApplyHandler;
        this.meleeRemoveHandler = meleeRemoveHandler;
    }
    
    public CompatibleAttachment(final ItemAttachment<T> attachment, final Consumer<ModelBase> positioning) {
        this(attachment, null, positioning, false);
    }
    
    public CompatibleAttachment(final ItemAttachment<T> attachment, final Consumer<ModelBase> positioning, final boolean isDefault) {
        super();
        this.attachment = attachment;
        this.modelPositioning = positioning;
        this.isDefault = isDefault;
    }
    
    public ItemAttachment<T> getAttachment() {
        return this.attachment;
    }
    
    public Consumer<ModelBase> getModelPositioning() {
        return this.modelPositioning;
    }
    
    public BiConsumer<EntityPlayer, ItemStack> getPositioning() {
        return this.positioning;
    }
    
    public boolean isDefault() {
        return this.isDefault;
    }
    
    public ItemAttachment.ApplyHandler2<T> getApplyHandler() {
        return this.applyHandler;
    }
    
    public ItemAttachment.ApplyHandler2<T> getRemoveHandler() {
        return this.removeHandler;
    }
    
    public ItemAttachment.MeleeWeaponApplyHandler<ItemMelee> getMeleeApplyHandler() {
        return this.meleeApplyHandler;
    }
    
    public ItemAttachment.MeleeWeaponApplyHandler<ItemMelee> getMeleeRemoveHandler() {
        return this.meleeRemoveHandler;
    }
    
    public boolean isPermanent() {
        return this.isPermanent;
    }
}
