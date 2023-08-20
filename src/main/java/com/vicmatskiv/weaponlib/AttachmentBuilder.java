package com.vicmatskiv.weaponlib;

import net.minecraft.client.model.*;
import net.minecraft.entity.player.*;
import net.minecraft.creativetab.*;
import java.util.function.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.crafting.*;
import java.util.*;

public class AttachmentBuilder<T>
{
    protected String name;
    protected String modId;
    protected ModelBase model;
    protected String textureName;
    protected Consumer<ItemStack> entityPositioning;
    protected Consumer<ItemStack> inventoryPositioning;
    protected BiConsumer<EntityPlayer, ItemStack> thirdPersonPositioning;
    protected BiConsumer<EntityPlayer, ItemStack> firstPersonPositioning;
    protected BiConsumer<ModelBase, ItemStack> firstPersonModelPositioning;
    protected BiConsumer<ModelBase, ItemStack> thirdPersonModelPositioning;
    protected BiConsumer<ModelBase, ItemStack> inventoryModelPositioning;
    protected BiConsumer<ModelBase, ItemStack> entityModelPositioning;
    protected Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioning;
    protected Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioning;
    protected CreativeTabs tab;
    protected AttachmentCategory attachmentCategory;
    protected ItemAttachment.ApplyHandler<T> apply;
    protected ItemAttachment.ApplyHandler<T> remove;
    protected ItemAttachment.ApplyHandler2<T> apply2;
    protected ItemAttachment.ApplyHandler2<T> remove2;
    private String crosshair;
    private CustomRenderer<?> postRenderer;
    private List<Tuple<ModelBase, String>> texturedModels;
    private boolean isRenderablePart;
    private int maxStackSize;
    private Function<ItemStack, String> informationProvider;
    private CraftingComplexity craftingComplexity;
    private Object[] craftingMaterials;
    Map<ItemAttachment<T>, CompatibleAttachment<T>> compatibleAttachments;
    private int craftingCount;
    private Object[] craftingRecipe;
    
    public AttachmentBuilder() {
        super();
        this.texturedModels = new ArrayList<Tuple<ModelBase, String>>();
        this.maxStackSize = 1;
        this.compatibleAttachments = new HashMap<ItemAttachment<T>, CompatibleAttachment<T>>();
        this.craftingCount = 1;
    }
    
    public AttachmentBuilder<T> withCategory(final AttachmentCategory attachmentCategory) {
        this.attachmentCategory = attachmentCategory;
        return this;
    }
    
    public AttachmentBuilder<T> withName(final String name) {
        this.name = name;
        return this;
    }
    
    public AttachmentBuilder<T> withCreativeTab(final CreativeTabs tab) {
        this.tab = tab;
        return this;
    }
    
    public AttachmentBuilder<T> withModId(final String modId) {
        this.modId = modId;
        return this;
    }
    
    public AttachmentBuilder<T> withCompatibleAttachment(final ItemAttachment<T> attachment, final Consumer<ModelBase> positioner) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<T>(attachment, positioner));
        return this;
    }
    
    public AttachmentBuilder<T> withModel(final ModelBase model) {
        this.model = model;
        return this;
    }
    
    public AttachmentBuilder<T> withTextureName(final String textureName) {
        this.textureName = textureName.toLowerCase();
        return this;
    }
    
    public AttachmentBuilder<T> withMaxStackSize(final int maxStackSize) {
        this.maxStackSize = maxStackSize;
        return this;
    }
    
    public AttachmentBuilder<T> withEntityPositioning(final Consumer<ItemStack> entityPositioning) {
        this.entityPositioning = entityPositioning;
        return this;
    }
    
    public AttachmentBuilder<T> withInventoryPositioning(final Consumer<ItemStack> inventoryPositioning) {
        this.inventoryPositioning = inventoryPositioning;
        return this;
    }
    
    public AttachmentBuilder<T> withThirdPersonPositioning(final BiConsumer<EntityPlayer, ItemStack> thirdPersonPositioning) {
        this.thirdPersonPositioning = thirdPersonPositioning;
        return this;
    }
    
    public AttachmentBuilder<T> withFirstPersonPositioning(final BiConsumer<EntityPlayer, ItemStack> firstPersonPositioning) {
        this.firstPersonPositioning = firstPersonPositioning;
        return this;
    }
    
    public AttachmentBuilder<T> withFirstPersonModelPositioning(final BiConsumer<ModelBase, ItemStack> firstPersonModelPositioning) {
        this.firstPersonModelPositioning = firstPersonModelPositioning;
        return this;
    }
    
    public AttachmentBuilder<T> withEntityModelPositioning(final BiConsumer<ModelBase, ItemStack> entityModelPositioning) {
        this.entityModelPositioning = entityModelPositioning;
        return this;
    }
    
    public AttachmentBuilder<T> withInventoryModelPositioning(final BiConsumer<ModelBase, ItemStack> inventoryModelPositioning) {
        this.inventoryModelPositioning = inventoryModelPositioning;
        return this;
    }
    
    public AttachmentBuilder<T> withThirdPersonModelPositioning(final BiConsumer<ModelBase, ItemStack> thirdPersonModelPositioning) {
        this.thirdPersonModelPositioning = thirdPersonModelPositioning;
        return this;
    }
    
    public AttachmentBuilder<T> withFirstPersonHandPositioning(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
        this.firstPersonLeftHandPositioning = leftHand;
        this.firstPersonRightHandPositioning = rightHand;
        return this;
    }
    
    public AttachmentBuilder<T> withCrosshair(final String crosshair) {
        this.crosshair = crosshair.toLowerCase();
        return this;
    }
    
    public AttachmentBuilder<T> withPostRender(final CustomRenderer<?> postRenderer) {
        this.postRenderer = postRenderer;
        return this;
    }
    
    public AttachmentBuilder<T> withModel(final ModelBase model, final String textureName) {
        this.texturedModels.add(new Tuple<ModelBase, String>(model, textureName.toLowerCase()));
        return this;
    }
    
    public AttachmentBuilder<T> withRenderablePart() {
        this.isRenderablePart = true;
        return this;
    }
    
    public AttachmentBuilder<T> withApply(final ItemAttachment.ApplyHandler<T> apply) {
        this.apply = apply;
        return this;
    }
    
    public AttachmentBuilder<T> withRemove(final ItemAttachment.ApplyHandler<T> remove) {
        this.remove = remove;
        return this;
    }
    
    public AttachmentBuilder<T> withApply(final ItemAttachment.ApplyHandler2<T> apply) {
        this.apply2 = apply;
        return this;
    }
    
    public AttachmentBuilder<T> withRemove(final ItemAttachment.ApplyHandler2<T> remove) {
        this.remove2 = remove;
        return this;
    }
    
    public AttachmentBuilder<T> withCrafting(final CraftingComplexity craftingComplexity, final Object... craftingMaterials) {
        return this.withCrafting(1, craftingComplexity, craftingMaterials);
    }
    
    public AttachmentBuilder<T> withInformationProvider(final Function<ItemStack, String> informationProvider) {
        this.informationProvider = informationProvider;
        return this;
    }
    
    public AttachmentBuilder<T> withCrafting(final int craftingCount, final CraftingComplexity craftingComplexity, final Object... craftingMaterials) {
        if (craftingComplexity == null) {
            throw new IllegalArgumentException("Crafting complexity not set");
        }
        if (craftingMaterials.length < 2) {
            throw new IllegalArgumentException("2 or more materials required for crafting");
        }
        if (craftingCount == 0) {
            throw new IllegalArgumentException("Invalid item count");
        }
        this.craftingComplexity = craftingComplexity;
        this.craftingMaterials = craftingMaterials;
        this.craftingCount = craftingCount;
        return this;
    }
    
    public AttachmentBuilder<T> withCraftingRecipe(final Object... craftingRecipe) {
        this.craftingRecipe = craftingRecipe;
        return this;
    }
    
    protected ItemAttachment<T> createAttachment(final ModContext modContext) {
        return new ItemAttachment<T>(this.getModId(), this.attachmentCategory, this.crosshair, this.apply, this.remove);
    }
    
    public ItemAttachment<T> build(final ModContext modContext) {
        final ItemAttachment<T> attachment = this.createAttachment(modContext);
        attachment.setUnlocalizedName(this.getModId() + "_" + this.name);
        attachment.setCreativeTab(this.tab);
        attachment.setPostRenderer(this.postRenderer);
        attachment.setName(this.name);
        attachment.apply2 = this.apply2;
        attachment.remove2 = this.remove2;
        attachment.maxStackSize = this.maxStackSize;
        if (attachment.getInformationProvider() == null) {
            attachment.setInformationProvider(this.informationProvider);
        }
        if (this.getTextureName() != null) {
            attachment.setTextureName(this.getModId() + ":" + stripFileExtension(this.getTextureName(), ".png"));
        }
        if (this.isRenderablePart) {
            attachment.setRenderablePart(new Part() {
                final /* synthetic */ AttachmentBuilder this$0;
                
                AttachmentBuilder$1() {
                    this.this$0 = this$0;
                    super();
                }
                
                @Override
                public String toString() {
                    return (this.this$0.name != null) ? ("Part [" + this.this$0.name + "]") : super.toString();
                }
            });
        }
        if (this.getModel() != null) {
            attachment.addModel(this.getModel(), addFileExtension(this.getTextureName(), ".png"));
        }
        this.texturedModels.forEach(tm -> itemAttachment.addModel(tm.getU(), addFileExtension(tm.getV(), ".png")));
        this.compatibleAttachments.values().forEach(a -> itemAttachment2.addCompatibleAttachment(a));
        if (this.getModel() != null || !this.texturedModels.isEmpty()) {
            modContext.registerRenderableItem(this.name, attachment, CompatibilityProvider.compatibility.isClientSide() ? this.registerRenderer(attachment, modContext) : null);
        }
        if (this.craftingRecipe != null && this.craftingRecipe.length >= 2) {
            modContext.getRecipeManager().registerShapedRecipe(attachment, this.craftingRecipe);
        }
        else if (this.craftingComplexity != null) {
            final OptionsMetadata optionsMetadata = new OptionsMetadata.OptionMetadataBuilder().withSlotCount(9).build(this.craftingComplexity, Arrays.copyOf(this.craftingMaterials, this.craftingMaterials.length));
            final List<Object> shape = modContext.getRecipeManager().createShapedRecipe(attachment, this.name, optionsMetadata);
            final ItemStack itemStack = new ItemStack((Item)attachment);
            CompatibilityProvider.compatibility.setStackSize(itemStack, this.craftingCount);
            if (optionsMetadata.hasOres()) {
                CompatibilityProvider.compatibility.addShapedOreRecipe(itemStack, shape.toArray());
            }
            else {
                CompatibilityProvider.compatibility.addShapedRecipe(itemStack, shape.toArray());
            }
        }
        else if (attachment.getCategory() == AttachmentCategory.GRIP || attachment.getCategory() == AttachmentCategory.SCOPE || attachment.getCategory() == AttachmentCategory.MAGAZINE || attachment.getCategory() == AttachmentCategory.BULLET || attachment.getCategory() == AttachmentCategory.SILENCER || attachment.getCategory() == AttachmentCategory.SKIN) {
            System.err.println("!!!No recipe defined for attachment " + this.name);
        }
        return attachment;
    }
    
    private Object registerRenderer(final ItemAttachment<T> attachment, final ModContext modContext) {
        return new StaticModelSourceRenderer.Builder().withEntityPositioning(this.entityPositioning).withFirstPersonPositioning(this.firstPersonPositioning).withThirdPersonPositioning(this.thirdPersonPositioning).withInventoryPositioning(this.inventoryPositioning).withEntityModelPositioning(this.entityModelPositioning).withFirstPersonModelPositioning(this.firstPersonModelPositioning).withThirdPersonModelPositioning(this.thirdPersonModelPositioning).withInventoryModelPositioning(this.inventoryModelPositioning).withFirstPersonHandPositioning(this.firstPersonLeftHandPositioning, this.firstPersonRightHandPositioning).withModContext(modContext).withModId(this.getModId()).build();
    }
    
    static String addFileExtension(final String s, final String ext) {
        return (s != null && !s.endsWith(ext)) ? (s + ext) : s;
    }
    
    protected static String stripFileExtension(final String str, final String extension) {
        return str.endsWith(extension) ? str.substring(0, str.length() - extension.length()) : str;
    }
    
    public <V extends ItemAttachment<T>> V build(final ModContext modContext, final Class<V> target) {
        return target.cast(this.build(modContext));
    }
    
    public String getModId() {
        return this.modId;
    }
    
    public ModelBase getModel() {
        return this.model;
    }
    
    public String getTextureName() {
        return this.textureName;
    }
    
    private static /* synthetic */ void lambda$build$197(final ItemAttachment itemAttachment, final CompatibleAttachment a) {
        itemAttachment.addCompatibleAttachment(a);
    }
    
    private static /* synthetic */ void lambda$build$196(final ItemAttachment itemAttachment, final Tuple tm) {
        itemAttachment.addModel(tm.getU(), addFileExtension(tm.getV(), ".png"));
    }
}
