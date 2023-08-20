package com.vicmatskiv.weaponlib.electronics;

import net.minecraft.client.model.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import java.util.function.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.crafting.*;
import java.util.*;
import com.vicmatskiv.weaponlib.*;

public class ItemWirelessCamera extends CompatibleItem implements ModelSource
{
    public static final long DEFAULT_DURATION = 300000L;
    private Builder builder;
    private ModContext modContext;
    private List<Tuple<ModelBase, String>> texturedModels;
    
    public ItemWirelessCamera(final Builder builder, final ModContext modContext) {
        super();
        this.texturedModels = new ArrayList<Tuple<ModelBase, String>>();
        this.builder = builder;
        this.modContext = modContext;
        this.maxStackSize = 16;
    }
    
    @Override
    protected ItemStack onCompatibleItemRightClick(final ItemStack itemStack, final World world, final EntityPlayer player, final boolean mainHand) {
        CompatibilityProvider.compatibility.setStackSize(itemStack, CompatibilityProvider.compatibility.getStackSize(itemStack) - 1);
        if (!world.isRemote) {
            CompatibilityProvider.compatibility.spawnEntity(player, (Entity)new EntityWirelessCamera(this.modContext, world, player, this, this.builder.duration));
        }
        return itemStack;
    }
    
    @Override
    public List<Tuple<ModelBase, String>> getTexturedModels() {
        return this.texturedModels;
    }
    
    @Override
    public CustomRenderer<?> getPostRenderer() {
        return null;
    }
    
    public ModelBase getModel() {
        return (ModelBase)this.texturedModels.get(0).getU();
    }
    
    public String getTextureName() {
        return (String)this.texturedModels.get(0).getV();
    }
    
    static /* synthetic */ int access$002(final ItemWirelessCamera x0, final int x1) {
        return x0.maxStackSize = x1;
    }
    
    static /* synthetic */ List access$100(final ItemWirelessCamera x0) {
        return x0.texturedModels;
    }
    
    public static class Builder
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
        private List<Tuple<ModelBase, String>> texturedModels;
        private int maxStackSize;
        private CraftingComplexity craftingComplexity;
        private Object[] craftingMaterials;
        private int craftingCount;
        private long duration;
        
        public Builder() {
            super();
            this.texturedModels = new ArrayList<Tuple<ModelBase, String>>();
            this.maxStackSize = 1;
            this.craftingCount = 1;
            this.duration = 300000L;
        }
        
        public Builder withName(final String name) {
            this.name = name;
            return this;
        }
        
        public Builder withCreativeTab(final CreativeTabs tab) {
            this.tab = tab;
            return this;
        }
        
        public Builder withModId(final String modId) {
            this.modId = modId;
            return this;
        }
        
        public Builder withModel(final ModelBase model) {
            this.model = model;
            return this;
        }
        
        public Builder withTextureName(final String textureName) {
            this.textureName = textureName.toLowerCase();
            return this;
        }
        
        public Builder withMaxStackSize(final int maxStackSize) {
            this.maxStackSize = maxStackSize;
            return this;
        }
        
        public Builder withEntityPositioning(final Consumer<ItemStack> entityPositioning) {
            this.entityPositioning = entityPositioning;
            return this;
        }
        
        public Builder withInventoryPositioning(final Consumer<ItemStack> inventoryPositioning) {
            this.inventoryPositioning = inventoryPositioning;
            return this;
        }
        
        public Builder withThirdPersonPositioning(final BiConsumer<EntityPlayer, ItemStack> thirdPersonPositioning) {
            this.thirdPersonPositioning = thirdPersonPositioning;
            return this;
        }
        
        public Builder withFirstPersonPositioning(final BiConsumer<EntityPlayer, ItemStack> firstPersonPositioning) {
            this.firstPersonPositioning = firstPersonPositioning;
            return this;
        }
        
        public Builder withFirstPersonModelPositioning(final BiConsumer<ModelBase, ItemStack> firstPersonModelPositioning) {
            this.firstPersonModelPositioning = firstPersonModelPositioning;
            return this;
        }
        
        public Builder withEntityModelPositioning(final BiConsumer<ModelBase, ItemStack> entityModelPositioning) {
            this.entityModelPositioning = entityModelPositioning;
            return this;
        }
        
        public Builder withInventoryModelPositioning(final BiConsumer<ModelBase, ItemStack> inventoryModelPositioning) {
            this.inventoryModelPositioning = inventoryModelPositioning;
            return this;
        }
        
        public Builder withThirdPersonModelPositioning(final BiConsumer<ModelBase, ItemStack> thirdPersonModelPositioning) {
            this.thirdPersonModelPositioning = thirdPersonModelPositioning;
            return this;
        }
        
        public Builder withFirstPersonHandPositioning(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioning = leftHand;
            this.firstPersonRightHandPositioning = rightHand;
            return this;
        }
        
        public Builder withModel(final ModelBase model, final String textureName) {
            this.texturedModels.add(new Tuple<ModelBase, String>(model, textureName.toLowerCase()));
            return this;
        }
        
        public Builder withCrafting(final CraftingComplexity craftingComplexity, final Object... craftingMaterials) {
            return this.withCrafting(1, craftingComplexity, craftingMaterials);
        }
        
        public Builder withCrafting(final int craftingCount, final CraftingComplexity craftingComplexity, final Object... craftingMaterials) {
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
        
        public Builder withDuration(final long duration) {
            this.duration = duration;
            return this;
        }
        
        public ItemWirelessCamera build(final ModContext modContext) {
            final ItemWirelessCamera camera = new ItemWirelessCamera(this, modContext);
            camera.setUnlocalizedName(this.modId + "_" + this.name);
            camera.setCreativeTab(this.tab);
            camera.maxStackSize = this.maxStackSize;
            this.texturedModels.forEach(tm -> x0.texturedModels.add(new Tuple(tm.getU(), addFileExtension(tm.getV(), ".png"))));
            if (this.model != null) {
                this.texturedModels.add(new Tuple<ModelBase, String>(this.model, addFileExtension(this.textureName, ".png")));
            }
            if (this.model != null || !this.texturedModels.isEmpty()) {
                modContext.registerRenderableItem(this.name, camera, CompatibilityProvider.compatibility.isClientSide() ? this.registerRenderer(camera, modContext) : null);
            }
            if (this.craftingComplexity != null) {
                final OptionsMetadata optionsMetadata = new OptionsMetadata.OptionMetadataBuilder().withSlotCount(9).build(this.craftingComplexity, Arrays.copyOf(this.craftingMaterials, this.craftingMaterials.length));
                final List<Object> shape = modContext.getRecipeManager().createShapedRecipe(camera, this.name, optionsMetadata);
                final ItemStack itemStack = new ItemStack((Item)camera);
                CompatibilityProvider.compatibility.setStackSize(itemStack, this.craftingCount);
                if (optionsMetadata.hasOres()) {
                    CompatibilityProvider.compatibility.addShapedOreRecipe(itemStack, shape.toArray());
                }
                else {
                    CompatibilityProvider.compatibility.addShapedRecipe(itemStack, shape.toArray());
                }
            }
            return camera;
        }
        
        static String addFileExtension(final String s, final String ext) {
            return (s != null && !s.endsWith(ext)) ? (s + ext) : s;
        }
        
        protected static String stripFileExtension(final String str, final String extension) {
            return str.endsWith(extension) ? str.substring(0, str.length() - extension.length()) : str;
        }
        
        private Object registerRenderer(final ItemWirelessCamera camera, final ModContext modContext) {
            return new StaticModelSourceRenderer.Builder().withEntityPositioning(this.entityPositioning).withFirstPersonPositioning(this.firstPersonPositioning).withThirdPersonPositioning(this.thirdPersonPositioning).withInventoryPositioning(this.inventoryPositioning).withEntityModelPositioning(this.entityModelPositioning).withFirstPersonModelPositioning(this.firstPersonModelPositioning).withThirdPersonModelPositioning(this.thirdPersonModelPositioning).withInventoryModelPositioning(this.inventoryModelPositioning).withFirstPersonHandPositioning(this.firstPersonLeftHandPositioning, this.firstPersonRightHandPositioning).withModContext(modContext).withModId(this.modId).build();
        }
        
        private static /* synthetic */ void lambda$build$265(final ItemWirelessCamera x0, final Tuple tm) {
            x0.texturedModels.add(new Tuple(tm.getU(), addFileExtension(tm.getV(), ".png")));
        }
        
        static /* synthetic */ long access$200(final Builder x0) {
            return x0.duration;
        }
    }
}
