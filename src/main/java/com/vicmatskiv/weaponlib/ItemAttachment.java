package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.client.model.*;
import java.util.function.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import com.vicmatskiv.weaponlib.melee.*;

public class ItemAttachment<T> extends CompatibleItem implements ModelSource
{
    private AttachmentCategory category;
    private String crosshair;
    private ApplyHandler<T> apply;
    private ApplyHandler<T> remove;
    protected ApplyHandler2<T> apply2;
    protected ApplyHandler2<T> remove2;
    protected MeleeWeaponApplyHandler<T> apply3;
    protected MeleeWeaponApplyHandler<T> remove3;
    private List<Tuple<ModelBase, String>> texturedModels;
    private CustomRenderer<?> postRenderer;
    private CustomRenderer<?> preRenderer;
    private Part renderablePart;
    private String name;
    private Function<ItemStack, String> informationProvider;
    protected int maxStackSize;
    private List<CompatibleAttachment<T>> attachments;
    private List<Weapon> compatibleWeapons;
    protected String textureName;
    
    protected ItemAttachment(final String modId, final AttachmentCategory category, final ModelBase model, final String textureName, final String crosshair, final ApplyHandler<T> apply, final ApplyHandler<T> remove) {
        super();
        this.texturedModels = new ArrayList<Tuple<ModelBase, String>>();
        this.maxStackSize = 1;
        this.attachments = new ArrayList<CompatibleAttachment<T>>();
        this.compatibleWeapons = new ArrayList<Weapon>();
        this.category = category;
        this.textureName = textureName.toLowerCase();
        this.crosshair = ((crosshair != null) ? (modId + ":" + "textures/crosshairs/" + crosshair + ".png") : null);
        this.apply = apply;
        this.remove = remove;
    }
    
    protected ItemAttachment(final String modId, final AttachmentCategory category, final String crosshair, final ApplyHandler<T> apply, final ApplyHandler<T> remove) {
        super();
        this.texturedModels = new ArrayList<Tuple<ModelBase, String>>();
        this.maxStackSize = 1;
        this.attachments = new ArrayList<CompatibleAttachment<T>>();
        this.compatibleWeapons = new ArrayList<Weapon>();
        this.category = category;
        this.crosshair = ((crosshair != null) ? (modId + ":" + "textures/crosshairs/" + crosshair + ".png") : null);
        this.apply = apply;
        this.remove = remove;
    }
    
    public int getItemStackLimit() {
        return this.maxStackSize;
    }
    
    public Item setTextureName(final String name) {
        return this;
    }
    
    public Part getRenderablePart() {
        return this.renderablePart;
    }
    
    protected void setRenderablePart(final Part renderablePart) {
        this.renderablePart = renderablePart;
    }
    
    protected Function<ItemStack, String> getInformationProvider() {
        return this.informationProvider;
    }
    
    protected void setInformationProvider(final Function<ItemStack, String> informationProvider) {
        this.informationProvider = informationProvider;
    }
    
    @Deprecated
    public ItemAttachment<T> addModel(final ModelBase model, final String textureName) {
        this.texturedModels.add(new Tuple<ModelBase, String>(model, textureName));
        return this;
    }
    
    public ItemAttachment(final String modId, final AttachmentCategory category, final String crosshair) {
        this(modId, category, crosshair, (a, w, p) -> {}, (a, w, p) -> {});
    }
    
    public ItemAttachment(final String modId, final AttachmentCategory category, final ModelBase attachment, final String textureName, final String crosshair) {
        this(modId, category, attachment, textureName, crosshair, (a, w, p) -> {}, (a, w, p) -> {});
    }
    
    public AttachmentCategory getCategory() {
        return this.category;
    }
    
    @Override
    public List<Tuple<ModelBase, String>> getTexturedModels() {
        return this.texturedModels;
    }
    
    public String getCrosshair() {
        return this.crosshair;
    }
    
    public ApplyHandler<T> getApply() {
        return this.apply;
    }
    
    public ApplyHandler<T> getRemove() {
        return this.remove;
    }
    
    public void addCompatibleWeapon(final Weapon weapon) {
        this.compatibleWeapons.add(weapon);
    }
    
    public void addInformation(final ItemStack itemStack, final EntityPlayer entityPlayer, final List list, final boolean p_77624_4_) {
        if (list != null && this.informationProvider != null) {
            list.add(this.informationProvider.apply(itemStack));
        }
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setPostRenderer(final CustomRenderer<?> postRenderer) {
        this.postRenderer = postRenderer;
    }
    
    @Override
    public CustomRenderer<?> getPostRenderer() {
        return this.postRenderer;
    }
    
    public CustomRenderer<?> getPreRenderer() {
        return this.preRenderer;
    }
    
    public void setPreRenderer(final CustomRenderer<?> preRenderer) {
        this.preRenderer = preRenderer;
    }
    
    protected void addCompatibleAttachment(final CompatibleAttachment<T> attachment) {
        this.attachments.add(attachment);
    }
    
    public List<CompatibleAttachment<T>> getAttachments() {
        return Collections.unmodifiableList((List<? extends CompatibleAttachment<T>>)this.attachments);
    }
    
    public String toString() {
        return (this.name != null) ? ("Attachment [" + this.name + "]") : super.toString();
    }
    
    public ApplyHandler2<T> getApply2() {
        return this.apply2;
    }
    
    protected ApplyHandler2<T> getRemove2() {
        return this.remove2;
    }
    
    public MeleeWeaponApplyHandler<T> getApply3() {
        return this.apply3;
    }
    
    public MeleeWeaponApplyHandler<T> getRemove3() {
        return this.remove3;
    }
    
    private static /* synthetic */ void lambda$new$82(final ItemAttachment a, final Object w, final EntityPlayer p) {
    }
    
    private static /* synthetic */ void lambda$new$81(final ItemAttachment a, final Object w, final EntityPlayer p) {
    }
    
    private static /* synthetic */ void lambda$new$80(final ItemAttachment a, final Object w, final EntityPlayer p) {
    }
    
    private static /* synthetic */ void lambda$new$79(final ItemAttachment a, final Object w, final EntityPlayer p) {
    }
    
    public interface MeleeWeaponApplyHandler<T>
    {
        void apply(final ItemAttachment<T> p0, final PlayerMeleeInstance p1);
    }
    
    public interface ApplyHandler2<T>
    {
        void apply(final ItemAttachment<T> p0, final PlayerWeaponInstance p1);
    }
    
    public interface ApplyHandler<T>
    {
        void apply(final ItemAttachment<T> p0, final T p1, final EntityPlayer p2);
    }
}
