package com.vicmatskiv.weaponlib.grenade;

import net.minecraft.entity.player.*;
import java.util.stream.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.*;
import java.util.function.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.crafting.*;

public class ItemGrenade extends CompatibleItem implements PlayerItemInstanceFactory<PlayerGrenadeInstance, GrenadeState>, AttachmentContainer, Updatable
{
    public static final int DEFAULT_FUSE_TIMEOUT = 3000;
    public static final float DEFAULT_EXPLOSION_STRENTH = 2.0f;
    public static final int EXPLODE_ON_IMPACT = -1;
    public static final float DEFAULT_GRAVITY_VELOCITY = 0.06f;
    public static final float DEFAULT_FAR_VELOCITY = 1.3f;
    public static final float DEFAULT_VELOCITY = 1.0f;
    public static final float DEFAULT_ROTATION_SLOWDOWN_FACTOR = 0.99f;
    public static final float DEFAULT_EFFECTIVE_RADIUS = 20.0f;
    public static final float DEFAULT_FRAGMENT_DAMAGE = 15.0f;
    public static final int DEFAULT_FRAGMENT_COUNT = 100;
    Builder builder;
    private ModContext modContext;
    private CompatibleSound bounceHardSound;
    private CompatibleSound bounceSoftSound;
    private CompatibleSound explosionSound;
    private CompatibleSound safetyPinOffSound;
    private CompatibleSound throwSound;
    private CompatibleSound stopAfterThrowingSound;
    
    public ItemGrenade(final Builder builder, final ModContext modContext) {
        super();
        this.builder = builder;
        this.modContext = modContext;
        this.maxStackSize = 16;
    }
    
    public GrenadeRenderer getRenderer() {
        return this.builder.renderer;
    }
    
    public String getTextureName() {
        return this.builder.textureNames.get(0);
    }
    
    public boolean hasSafetyPin() {
        return this.builder.explosionTimeout > 0;
    }
    
    @Override
    public List<CompatibleAttachment<? extends AttachmentContainer>> getActiveAttachments(final EntityPlayer player, final ItemStack itemStack) {
        return new ArrayList<CompatibleAttachment<? extends AttachmentContainer>>(this.builder.compatibleAttachments.values());
    }
    
    Map<ItemAttachment<ItemGrenade>, CompatibleAttachment<ItemGrenade>> getCompatibleAttachments() {
        return this.builder.compatibleAttachments;
    }
    
    public String getName() {
        return this.builder.name;
    }
    
    @Override
    public PlayerGrenadeInstance createItemInstance(final EntityPlayer player, final ItemStack itemStack, final int slot) {
        final PlayerGrenadeInstance instance = new PlayerGrenadeInstance(slot, player, itemStack);
        instance.setState(GrenadeState.READY);
        return instance;
    }
    
    public void attack(final EntityPlayer player, final boolean throwingFar) {
        this.modContext.getGrenadeAttackAspect().onAttackButtonClick(player, throwingFar);
    }
    
    public void attackUp(final EntityPlayer player, final boolean throwingFar) {
        this.modContext.getGrenadeAttackAspect().onAttackButtonUp(player, throwingFar);
    }
    
    @Override
    public void update(final EntityPlayer player) {
        this.modContext.getGrenadeAttackAspect().onUpdate(player);
    }
    
    public float getExplosionStrength() {
        return this.builder.explosionStrength;
    }
    
    public int getExplosionTimeout() {
        return this.builder.explosionTimeout;
    }
    
    public long getThrowTimeout() {
        return 200L;
    }
    
    public long getTotalTakeSafetyPinOffDuration() {
        return this.builder.renderer.getTotalTakingSafetyPinOffDuration();
    }
    
    public long getReequipTimeout() {
        return 800L;
    }
    
    public double getTotalThrowingDuration() {
        return (double)this.builder.renderer.getTotalThrowingDuration();
    }
    
    public float getVelocity() {
        return this.builder.velocity.get();
    }
    
    public float getFarVelocity() {
        return this.builder.farVelocity.get();
    }
    
    public float getGravityVelocity() {
        return this.builder.gravityVelocity.get();
    }
    
    public float getRotationSlowdownFactor() {
        return this.builder.rotationSlowdownFactor.get();
    }
    
    public CompatibleSound getBounceHardSound() {
        return this.bounceHardSound;
    }
    
    public CompatibleSound getBounceSoftSound() {
        return this.bounceSoftSound;
    }
    
    public CompatibleSound getExplosionSound() {
        return this.explosionSound;
    }
    
    public CompatibleSound getSafetyPinOffSound() {
        return this.safetyPinOffSound;
    }
    
    public CompatibleSound getThrowSound() {
        return this.throwSound;
    }
    
    public CompatibleSound getStopAfterThrowingSound() {
        return this.stopAfterThrowingSound;
    }
    
    public float getEffectiveRadius() {
        return this.builder.effectiveRadius;
    }
    
    public float getFragmentDamage() {
        return this.builder.fragmentDamage;
    }
    
    public int getFragmentCount() {
        return this.builder.fragmentCount;
    }
    
    public boolean isSmokeOnly() {
        return this.builder.smokeOnly;
    }
    
    public long getActiveDuration() {
        return this.builder.activeDuration;
    }
    
    @Override
    public Collection<CompatibleAttachment<? extends AttachmentContainer>> getCompatibleAttachments(final AttachmentCategory... categories) {
        final Collection<CompatibleAttachment<ItemGrenade>> c = this.builder.compatibleAttachments.values();
        final List<AttachmentCategory> inputCategoryList = Arrays.asList(categories);
        return c.stream().filter(e -> list.contains(e)).collect((Collector<? super CompatibleAttachment<ItemGrenade>, ?, Collection<CompatibleAttachment<? extends AttachmentContainer>>>)Collectors.toList());
    }
    
    @Override
    public /* bridge */ PlayerItemInstance createItemInstance(final EntityPlayer player, final ItemStack itemStack, final int slot) {
        return this.createItemInstance(player, itemStack, slot);
    }
    
    private static /* synthetic */ boolean lambda$getCompatibleAttachments$134(final List list, final CompatibleAttachment e) {
        return list.contains(e);
    }
    
    static /* synthetic */ int access$002(final ItemGrenade x0, final int x1) {
        return x0.maxStackSize = x1;
    }
    
    static /* synthetic */ CompatibleSound access$102(final ItemGrenade x0, final CompatibleSound x1) {
        return x0.bounceHardSound = x1;
    }
    
    static /* synthetic */ CompatibleSound access$202(final ItemGrenade x0, final CompatibleSound x1) {
        return x0.bounceSoftSound = x1;
    }
    
    static /* synthetic */ CompatibleSound access$302(final ItemGrenade x0, final CompatibleSound x1) {
        return x0.explosionSound = x1;
    }
    
    static /* synthetic */ CompatibleSound access$402(final ItemGrenade x0, final CompatibleSound x1) {
        return x0.safetyPinOffSound = x1;
    }
    
    static /* synthetic */ CompatibleSound access$502(final ItemGrenade x0, final CompatibleSound x1) {
        return x0.throwSound = x1;
    }
    
    static /* synthetic */ CompatibleSound access$602(final ItemGrenade x0, final CompatibleSound x1) {
        return x0.stopAfterThrowingSound = x1;
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
        protected Map<ItemAttachment<ItemGrenade>, CompatibleAttachment<ItemGrenade>> compatibleAttachments;
        private Supplier<Float> velocity;
        private Supplier<Float> farVelocity;
        private Supplier<Float> gravityVelocity;
        private int maxStackSize;
        private int explosionTimeout;
        private float explosionStrength;
        protected CreativeTabs tab;
        private CraftingComplexity craftingComplexity;
        private Object[] craftingMaterials;
        private int craftingCount;
        private GrenadeRenderer renderer;
        List<String> textureNames;
        private Supplier<Float> rotationSlowdownFactor;
        private String bounceHardSound;
        private String bounceSoftSound;
        private String explosionSound;
        private String safetyPinOffSound;
        private String stopAfterThrowingSound;
        private String throwSound;
        private float effectiveRadius;
        private float fragmentDamage;
        private int fragmentCount;
        private boolean smokeOnly;
        private long activeDuration;
        private Object[] craftingRecipe;
        
        public Builder() {
            super();
            this.compatibleAttachments = new HashMap<ItemAttachment<ItemGrenade>, CompatibleAttachment<ItemGrenade>>();
            this.velocity = (() -> 1.0f);
            this.farVelocity = (() -> 1.3f);
            this.gravityVelocity = (() -> 0.06f);
            this.maxStackSize = 1;
            this.explosionTimeout = 3000;
            this.explosionStrength = 2.0f;
            this.craftingCount = 1;
            this.textureNames = new ArrayList<String>();
            this.rotationSlowdownFactor = (() -> 0.99f);
            this.effectiveRadius = 20.0f;
            this.fragmentDamage = 15.0f;
            this.fragmentCount = 100;
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
        
        public Builder withVelocity(final Supplier<Float> velocity) {
            this.velocity = velocity;
            return this;
        }
        
        public Builder withFarVelocity(final Supplier<Float> farVelocity) {
            this.farVelocity = farVelocity;
            return this;
        }
        
        public Builder withGravityVelocity(final Supplier<Float> gravityVelocity) {
            this.gravityVelocity = gravityVelocity;
            return this;
        }
        
        public Builder withRotationSlowdownFactor(final Supplier<Float> rotationSlowdownFactor) {
            this.rotationSlowdownFactor = rotationSlowdownFactor;
            return this;
        }
        
        public Builder withExplosionStrength(final float explosionStrength) {
            this.explosionStrength = explosionStrength;
            return this;
        }
        
        public Builder withExplosionTimeout(final int explosionTimeout) {
            this.explosionTimeout = explosionTimeout;
            return this;
        }
        
        public Builder withExplosionOnImpact() {
            this.explosionTimeout = -1;
            return this;
        }
        
        public Builder withSmokeOnly() {
            this.smokeOnly = true;
            return this;
        }
        
        public Builder withTextureNames(final String... textureNames) {
            if (this.modId == null) {
                throw new IllegalStateException("ModId is not set");
            }
            for (final String textureName : textureNames) {
                this.textureNames.add(textureName.toLowerCase() + ".png");
            }
            return this;
        }
        
        public Builder withCompatibleAttachment(final ItemAttachment<ItemGrenade> attachment, final BiConsumer<EntityPlayer, ItemStack> positioning) {
            this.compatibleAttachments.put(attachment, new CompatibleAttachment<ItemGrenade>(attachment, positioning, null, true));
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
        
        public Builder withRenderer(final GrenadeRenderer renderer) {
            this.renderer = renderer;
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
        
        public Builder withCraftingRecipe(final Object... craftingRecipe) {
            this.craftingRecipe = craftingRecipe;
            return this;
        }
        
        public Builder withBounceHardSound(final String sound) {
            this.bounceHardSound = ((sound != null) ? sound.toLowerCase() : null);
            return this;
        }
        
        public Builder withBounceSoftSound(final String sound) {
            this.bounceSoftSound = ((sound != null) ? sound.toLowerCase() : null);
            return this;
        }
        
        public Builder withExplosionSound(final String sound) {
            this.explosionSound = ((sound != null) ? sound.toLowerCase() : null);
            return this;
        }
        
        public Builder withSafetyPinOffSound(final String sound) {
            this.safetyPinOffSound = ((sound != null) ? sound.toLowerCase() : null);
            return this;
        }
        
        public Builder withThrowSound(final String sound) {
            this.throwSound = ((sound != null) ? sound.toLowerCase() : null);
            return this;
        }
        
        public Builder withStopAfterThrowingSond(final String sound) {
            this.stopAfterThrowingSound = ((sound != null) ? sound.toLowerCase() : null);
            return this;
        }
        
        public Builder withEffectiveRadius(final float effectiveRadius) {
            this.effectiveRadius = effectiveRadius;
            return this;
        }
        
        public Builder withFragmentDamage(final float fragmentDamage) {
            this.fragmentDamage = fragmentDamage;
            return this;
        }
        
        public Builder withFragmentCount(final int fragmentCount) {
            this.fragmentCount = fragmentCount;
            return this;
        }
        
        public Builder withActiveDuration(final long duration) {
            this.activeDuration = duration;
            return this;
        }
        
        public ItemGrenade build(final ModContext modContext) {
            final ItemGrenade grenade = new ItemGrenade(this, modContext);
            grenade.setUnlocalizedName(this.modId + "_" + this.name);
            grenade.setCreativeTab(this.tab);
            grenade.maxStackSize = this.maxStackSize;
            if (this.bounceHardSound != null) {
                grenade.bounceHardSound = modContext.registerSound(this.bounceHardSound);
            }
            if (this.bounceSoftSound != null) {
                grenade.bounceSoftSound = modContext.registerSound(this.bounceSoftSound);
            }
            if (this.explosionSound != null) {
                grenade.explosionSound = modContext.registerSound(this.explosionSound);
            }
            if (this.safetyPinOffSound != null) {
                grenade.safetyPinOffSound = modContext.registerSound(this.safetyPinOffSound);
            }
            if (this.throwSound != null) {
                grenade.throwSound = modContext.registerSound(this.throwSound);
            }
            if (this.stopAfterThrowingSound != null) {
                grenade.stopAfterThrowingSound = modContext.registerSound(this.stopAfterThrowingSound);
            }
            modContext.registerGrenadeWeapon(this.name, grenade, this.renderer);
            if (this.craftingRecipe != null && this.craftingRecipe.length >= 2) {
                final ItemStack itemStack = new ItemStack((Item)grenade);
                final List<Object> registeredRecipe = modContext.getRecipeManager().registerShapedRecipe(grenade, this.craftingRecipe);
                final boolean hasOres = Arrays.stream(this.craftingRecipe).anyMatch(r -> r instanceof String);
                if (hasOres) {
                    CompatibilityProvider.compatibility.addShapedOreRecipe(itemStack, registeredRecipe.toArray());
                }
                else {
                    CompatibilityProvider.compatibility.addShapedRecipe(itemStack, registeredRecipe.toArray());
                }
            }
            else if (this.craftingComplexity != null) {
                final OptionsMetadata optionsMetadata = new OptionsMetadata.OptionMetadataBuilder().withSlotCount(9).build(this.craftingComplexity, Arrays.copyOf(this.craftingMaterials, this.craftingMaterials.length));
                final List<Object> shape = modContext.getRecipeManager().createShapedRecipe(grenade, this.name, optionsMetadata);
                final ItemStack itemStack2 = new ItemStack((Item)grenade);
                CompatibilityProvider.compatibility.setStackSize(itemStack2, this.craftingCount);
                if (optionsMetadata.hasOres()) {
                    CompatibilityProvider.compatibility.addShapedOreRecipe(itemStack2, shape.toArray());
                }
                else {
                    CompatibilityProvider.compatibility.addShapedRecipe(itemStack2, shape.toArray());
                }
            }
            else {
                System.err.println("!!!No recipe defined for grenade " + this.name);
            }
            return grenade;
        }
        
        static String addFileExtension(final String s, final String ext) {
            return (s != null && !s.endsWith(ext)) ? (s + ext) : s;
        }
        
        protected static String stripFileExtension(final String str, final String extension) {
            return str.endsWith(extension) ? str.substring(0, str.length() - extension.length()) : str;
        }
        
        private static /* synthetic */ boolean lambda$build$133(final Object r) {
            return r instanceof String;
        }
        
        private static /* synthetic */ Float lambda$new$132() {
            return 0.99f;
        }
        
        private static /* synthetic */ Float lambda$new$131() {
            return 0.06f;
        }
        
        private static /* synthetic */ Float lambda$new$130() {
            return 1.3f;
        }
        
        private static /* synthetic */ Float lambda$new$129() {
            return 1.0f;
        }
        
        static /* synthetic */ GrenadeRenderer access$700(final Builder x0) {
            return x0.renderer;
        }
        
        static /* synthetic */ int access$800(final Builder x0) {
            return x0.explosionTimeout;
        }
        
        static /* synthetic */ float access$900(final Builder x0) {
            return x0.explosionStrength;
        }
        
        static /* synthetic */ Supplier access$1000(final Builder x0) {
            return x0.velocity;
        }
        
        static /* synthetic */ Supplier access$1100(final Builder x0) {
            return x0.farVelocity;
        }
        
        static /* synthetic */ Supplier access$1200(final Builder x0) {
            return x0.gravityVelocity;
        }
        
        static /* synthetic */ Supplier access$1300(final Builder x0) {
            return x0.rotationSlowdownFactor;
        }
        
        static /* synthetic */ float access$1400(final Builder x0) {
            return x0.effectiveRadius;
        }
        
        static /* synthetic */ float access$1500(final Builder x0) {
            return x0.fragmentDamage;
        }
        
        static /* synthetic */ int access$1600(final Builder x0) {
            return x0.fragmentCount;
        }
        
        static /* synthetic */ boolean access$1700(final Builder x0) {
            return x0.smokeOnly;
        }
        
        static /* synthetic */ long access$1800(final Builder x0) {
            return x0.activeDuration;
        }
    }
}
