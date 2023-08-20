package com.vicmatskiv.weaponlib.grenade;

import net.minecraft.client.model.*;
import net.minecraft.entity.player.*;
import java.util.function.*;
import net.minecraft.creativetab.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.item.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.crafting.*;

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
        ItemGrenade.access$002(grenade, this.maxStackSize);
        if (this.bounceHardSound != null) {
            ItemGrenade.access$102(grenade, modContext.registerSound(this.bounceHardSound));
        }
        if (this.bounceSoftSound != null) {
            ItemGrenade.access$202(grenade, modContext.registerSound(this.bounceSoftSound));
        }
        if (this.explosionSound != null) {
            ItemGrenade.access$302(grenade, modContext.registerSound(this.explosionSound));
        }
        if (this.safetyPinOffSound != null) {
            ItemGrenade.access$402(grenade, modContext.registerSound(this.safetyPinOffSound));
        }
        if (this.throwSound != null) {
            ItemGrenade.access$502(grenade, modContext.registerSound(this.throwSound));
        }
        if (this.stopAfterThrowingSound != null) {
            ItemGrenade.access$602(grenade, modContext.registerSound(this.stopAfterThrowingSound));
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
