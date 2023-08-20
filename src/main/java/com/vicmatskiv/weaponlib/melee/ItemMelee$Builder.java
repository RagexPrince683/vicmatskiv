package com.vicmatskiv.weaponlib.melee;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import java.util.function.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.item.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.crafting.*;

public static class Builder
{
    private static final int DEFAULT_PREPARE_STUB_TIMEOUT = 100;
    private static final int DEFAULT_ATTACK_COOLDOWN_TIMEOUT = 500;
    private static final int DEFAULT_HEAVY_ATTACK_COOLDOWN_TIMEOUT = 1000;
    String name;
    List<String> textureNames;
    private String attackSound;
    private String heavyAttackSound;
    private CreativeTabs creativeTab;
    private MeleeRenderer renderer;
    private String modId;
    Map<ItemAttachment<ItemMelee>, CompatibleAttachment<ItemMelee>> compatibleAttachments;
    private Class<? extends WeaponSpawnEntity> spawnEntityClass;
    ImpactHandler blockImpactHandler;
    private Function<ItemStack, List<String>> informationProvider;
    private CraftingComplexity craftingComplexity;
    private Object[] craftingMaterials;
    public float attackDamage;
    public float heavyAttackDamage;
    public Supplier<Integer> prepareStubTimeout;
    public Supplier<Integer> prepareHeavyStubTimeout;
    public Supplier<Integer> attackCooldownTimeout;
    public Supplier<Integer> heavyAttackCooldownTimeout;
    private Object[] craftingRecipe;
    
    public Builder() {
        super();
        this.textureNames = new ArrayList<String>();
        this.compatibleAttachments = new HashMap<ItemAttachment<ItemMelee>, CompatibleAttachment<ItemMelee>>();
        this.attackDamage = 1.0f;
        this.heavyAttackDamage = 2.0f;
        this.prepareStubTimeout = (() -> 100);
        this.prepareHeavyStubTimeout = (() -> 100);
        this.attackCooldownTimeout = (() -> 500);
        this.heavyAttackCooldownTimeout = (() -> 1000);
    }
    
    public Builder withModId(final String modId) {
        this.modId = modId;
        return this;
    }
    
    public Builder withInformationProvider(final Function<ItemStack, List<String>> informationProvider) {
        this.informationProvider = informationProvider;
        return this;
    }
    
    public Builder withPrepareStubTimeout(final Supplier<Integer> prepareStubTimeout) {
        this.prepareStubTimeout = prepareStubTimeout;
        return this;
    }
    
    public Builder withPrepareHeavyStubTimeout(final Supplier<Integer> prepareHeavyStubTimeout) {
        this.prepareHeavyStubTimeout = prepareHeavyStubTimeout;
        return this;
    }
    
    public Builder withAttackCooldownTimeout(final Supplier<Integer> attackCooldownTimeout) {
        this.attackCooldownTimeout = attackCooldownTimeout;
        return this;
    }
    
    public Builder withHeavyAttackCooldownTimeout(final Supplier<Integer> heavyAttackCooldownTimeout) {
        this.heavyAttackCooldownTimeout = heavyAttackCooldownTimeout;
        return this;
    }
    
    public Builder withName(final String name) {
        this.name = name;
        return this;
    }
    
    public Builder withAttackDamage(final float attackDamage) {
        this.attackDamage = attackDamage;
        return this;
    }
    
    public Builder withHeavyAttackDamage(final float heavyAttackDamage) {
        this.heavyAttackDamage = heavyAttackDamage;
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
    
    public Builder withAttackSound(final String attackSound) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.attackSound = attackSound.toLowerCase();
        return this;
    }
    
    public Builder withHeavyAttackSound(final String heavyAttackSound) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.heavyAttackSound = heavyAttackSound.toLowerCase();
        return this;
    }
    
    public Builder withCreativeTab(final CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }
    
    public Builder withRenderer(final MeleeRenderer renderer) {
        this.renderer = renderer;
        return this;
    }
    
    public Builder withCompatibleSkin(final MeleeSkin skin, final String activeTextureName) {
        this.withCompatibleAttachment(skin, (a, i) -> i.setActiveTextureIndex(meleeSkin.getTextureVariantIndex(s.toLowerCase())), (a, i) -> {});
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<ItemMelee> attachment, final ItemAttachment.MeleeWeaponApplyHandler<ItemMelee> applyHandler, final ItemAttachment.MeleeWeaponApplyHandler<ItemMelee> removeHandler) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<ItemMelee>(attachment, applyHandler, removeHandler));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<ItemMelee> attachment, final BiConsumer<EntityPlayer, ItemStack> positioning) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<ItemMelee>(attachment, positioning, null, false));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<ItemMelee> attachment, final boolean isDefault, final BiConsumer<EntityPlayer, ItemStack> positioning, final Consumer<ModelBase> modelPositioning) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<ItemMelee>(attachment, positioning, modelPositioning, isDefault));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<ItemMelee> attachment, final boolean isDefault, final Consumer<ModelBase> positioner) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<ItemMelee>(attachment, positioner, isDefault));
        return this;
    }
    
    public Builder withCrafting(final CraftingComplexity craftingComplexity, final Object... craftingMaterials) {
        if (craftingComplexity == null) {
            throw new IllegalArgumentException("Crafting complexity not set");
        }
        if (craftingMaterials.length < 2) {
            throw new IllegalArgumentException("2 or more materials required for crafting");
        }
        this.craftingComplexity = craftingComplexity;
        this.craftingMaterials = craftingMaterials;
        return this;
    }
    
    public Builder withCraftingRecipe(final Object... craftingRecipe) {
        this.craftingRecipe = craftingRecipe;
        return this;
    }
    
    public ItemMelee build(final ModContext modContext) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        if (this.name == null) {
            throw new IllegalStateException("Item name not provided");
        }
        if (this.heavyAttackSound == null) {
            this.heavyAttackSound = this.attackSound;
        }
        if (this.spawnEntityClass == null) {
            this.spawnEntityClass = WeaponSpawnEntity.class;
        }
        final ItemMelee itemMelee = new ItemMelee(this, modContext);
        ItemMelee.access$002(itemMelee, (this.attackSound != null) ? modContext.registerSound(this.attackSound) : CompatibleSound.SNOWBALL_THROW);
        ItemMelee.access$102(itemMelee, (this.heavyAttackSound != null) ? modContext.registerSound(this.heavyAttackSound) : CompatibleSound.SNOWBALL_THROW);
        itemMelee.setCreativeTab(this.creativeTab);
        itemMelee.setUnlocalizedName(this.name);
        modContext.registerMeleeWeapon(this.name, itemMelee, this.renderer);
        if (this.craftingRecipe != null && this.craftingRecipe.length >= 2) {
            final ItemStack itemStack = new ItemStack((Item)itemMelee);
            final List<Object> registeredRecipe = modContext.getRecipeManager().registerShapedRecipe(itemMelee, this.craftingRecipe);
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
            final List<Object> shape = modContext.getRecipeManager().createShapedRecipe(itemMelee, itemMelee.getName(), optionsMetadata);
            CompatibilityProvider.compatibility.addShapedRecipe(new ItemStack((Item)itemMelee), shape.toArray());
        }
        else {
            System.err.println("!!!No recipe defined for melee weapon " + this.name);
        }
        return itemMelee;
    }
    
    private static /* synthetic */ boolean lambda$build$100(final Object r) {
        return r instanceof String;
    }
    
    private static /* synthetic */ void lambda$withCompatibleSkin$99(final ItemAttachment a, final PlayerMeleeInstance i) {
    }
    
    private static /* synthetic */ void lambda$withCompatibleSkin$98(final MeleeSkin meleeSkin, final String s, final ItemAttachment a, final PlayerMeleeInstance i) {
        i.setActiveTextureIndex(meleeSkin.getTextureVariantIndex(s.toLowerCase()));
    }
    
    private static /* synthetic */ Integer lambda$new$97() {
        return 1000;
    }
    
    private static /* synthetic */ Integer lambda$new$96() {
        return 500;
    }
    
    private static /* synthetic */ Integer lambda$new$95() {
        return 100;
    }
    
    private static /* synthetic */ Integer lambda$new$94() {
        return 100;
    }
    
    static /* synthetic */ MeleeRenderer access$200(final Builder x0) {
        return x0.renderer;
    }
    
    static /* synthetic */ Function access$300(final Builder x0) {
        return x0.informationProvider;
    }
}
