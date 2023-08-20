package com.vicmatskiv.weaponlib.melee;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import java.util.stream.*;
import org.apache.logging.log4j.*;
import net.minecraft.creativetab.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;
import java.util.function.*;
import net.minecraft.client.model.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.crafting.*;

public class ItemMelee extends CompatibleItem implements PlayerItemInstanceFactory<PlayerMeleeInstance, MeleeState>, AttachmentContainer, Modifiable, Updatable
{
    private static final Logger logger;
    static final long MAX_RELOAD_TIMEOUT_TICKS = 60L;
    static final long MAX_UNLOAD_TIMEOUT_TICKS = 60L;
    Builder builder;
    private ModContext modContext;
    private CompatibleSound attackSound;
    private CompatibleSound silencedShootSound;
    private CompatibleSound heavyAttackSound;
    private CompatibleSound unloadSound;
    private CompatibleSound ejectSpentRoundSound;
    
    ItemMelee(final Builder builder, final ModContext modContext) {
        super();
        this.builder = builder;
        this.modContext = modContext;
        this.setMaxStackSize(1);
    }
    
    public String getName() {
        return this.builder.name;
    }
    
    public CompatibleSound getShootSound() {
        return this.attackSound;
    }
    
    public CompatibleSound getSilencedShootSound() {
        return this.silencedShootSound;
    }
    
    public CompatibleSound getReloadSound() {
        return this.heavyAttackSound;
    }
    
    public CompatibleSound getUnloadSound() {
        return this.unloadSound;
    }
    
    public CompatibleSound getEjectSpentRoundSound() {
        return this.ejectSpentRoundSound;
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack itemStack) {
        return true;
    }
    
    public void onUpdate(final ItemStack itemStack, final World world, final Entity entity, final int p_77663_4_, final boolean active) {
    }
    
    Map<ItemAttachment<ItemMelee>, CompatibleAttachment<ItemMelee>> getCompatibleAttachments() {
        return this.builder.compatibleAttachments;
    }
    
    public static boolean isActiveAttachment(final PlayerMeleeInstance weaponInstance, final ItemAttachment<ItemMelee> attachment) {
        return weaponInstance != null && MeleeAttachmentAspect.isActiveAttachment(attachment, weaponInstance);
    }
    
    public int getMaxItemUseDuration(final ItemStack itemStack) {
        return 0;
    }
    
    @Override
    public List<CompatibleAttachment<? extends AttachmentContainer>> getActiveAttachments(final EntityPlayer player, final ItemStack itemStack) {
        return this.modContext.getMeleeAttachmentAspect().getActiveAttachments(player, itemStack);
    }
    
    public MeleeRenderer getRenderer() {
        return this.builder.renderer;
    }
    
    List<ItemAttachment<ItemMelee>> getCompatibleAttachments(final Class<? extends ItemAttachment<ItemMelee>> target) {
        return this.builder.compatibleAttachments.entrySet().stream().filter(e -> clazz.isInstance(e.getKey())).map(e -> e.getKey()).collect((Collector<? super Object, ?, List<ItemAttachment<ItemMelee>>>)Collectors.toList());
    }
    
    public void addInformation(final ItemStack itemStack, final EntityPlayer entityPlayer, final List list, final boolean p_77624_4_) {
        if (list != null && this.builder.informationProvider != null) {
            list.addAll(this.builder.informationProvider.apply(itemStack));
        }
    }
    
    @Override
    public void update(final EntityPlayer player) {
        this.modContext.getMeleeAttackAspect().onUpdate(player);
        this.modContext.getMeleeAttachmentAspect().onUpdate(player);
    }
    
    @Override
    public PlayerMeleeInstance createItemInstance(final EntityPlayer player, final ItemStack itemStack, final int slot) {
        final PlayerMeleeInstance instance = new PlayerMeleeInstance(slot, player, itemStack);
        instance.setState(MeleeState.READY);
        for (final CompatibleAttachment<ItemMelee> compatibleAttachment : ((ItemMelee)itemStack.getItem()).getCompatibleAttachments().values()) {
            final ItemAttachment<ItemMelee> attachment = compatibleAttachment.getAttachment();
            if (compatibleAttachment.isDefault() && attachment.getApply3() != null) {
                attachment.getApply3().apply(attachment, instance);
            }
        }
        return instance;
    }
    
    @Override
    public void toggleClientAttachmentSelectionMode(final EntityPlayer player) {
        this.modContext.getMeleeAttachmentAspect().toggleClientAttachmentSelectionMode(player);
    }
    
    public String getTextureName() {
        return this.builder.textureNames.get(0);
    }
    
    public ItemAttachment.ApplyHandler2<ItemMelee> getEquivalentHandler(final AttachmentCategory attachmentCategory) {
        return null;
    }
    
    public void attack(final EntityPlayer player, final boolean heavy) {
        if (heavy) {
            this.modContext.getMeleeAttackAspect().onAttackButtonClick(player);
        }
        else {
            this.modContext.getMeleeAttackAspect().onHeavyAttackButtonClick(player);
        }
    }
    
    public boolean hitEntity(final ItemStack stack, final EntityLivingBase target, final EntityLivingBase player) {
        final PlayerItemInstance<?> instance = Tags.getInstance(stack);
        if (instance instanceof PlayerMeleeInstance) {
            ItemMelee.logger.debug("Player {} hits {} with {} in state {}", new Object[] { player, target, instance, instance.getState() });
        }
        return true;
    }
    
    public float getDamage(final boolean isHeavyAttack) {
        return isHeavyAttack ? this.builder.heavyAttackDamage : this.builder.attackDamage;
    }
    
    public long getPrepareStubTimeout() {
        return this.builder.prepareStubTimeout.get();
    }
    
    public long getPrepareHeavyStubTimeout() {
        return this.builder.prepareHeavyStubTimeout.get();
    }
    
    public long getAttackCooldownTimeout() {
        return this.builder.attackCooldownTimeout.get();
    }
    
    public long getHeavyAttackCooldownTimeout() {
        return this.builder.heavyAttackCooldownTimeout.get();
    }
    
    public CompatibleSound getHeavyAtackSound() {
        return this.heavyAttackSound;
    }
    
    public CompatibleSound getLightAtackSound() {
        return this.attackSound;
    }
    
    @Override
    public Collection<CompatibleAttachment<? extends AttachmentContainer>> getCompatibleAttachments(final AttachmentCategory... categories) {
        final Collection<CompatibleAttachment<ItemMelee>> c = this.builder.compatibleAttachments.values();
        final List<AttachmentCategory> inputCategoryList = Arrays.asList(categories);
        return c.stream().filter(e -> list.contains(e)).collect((Collector<? super CompatibleAttachment<ItemMelee>, ?, Collection<CompatibleAttachment<? extends AttachmentContainer>>>)Collectors.toList());
    }
    
    @Override
    public /* bridge */ PlayerItemInstance createItemInstance(final EntityPlayer player, final ItemStack itemStack, final int slot) {
        return this.createItemInstance(player, itemStack, slot);
    }
    
    private static /* synthetic */ boolean lambda$getCompatibleAttachments$103(final List list, final CompatibleAttachment e) {
        return list.contains(e);
    }
    
    private static /* synthetic */ ItemAttachment lambda$getCompatibleAttachments$102(final Map.Entry e) {
        return e.getKey();
    }
    
    private static /* synthetic */ boolean lambda$getCompatibleAttachments$101(final Class clazz, final Map.Entry e) {
        return clazz.isInstance(e.getKey());
    }
    
    static /* synthetic */ CompatibleSound access$002(final ItemMelee x0, final CompatibleSound x1) {
        return x0.attackSound = x1;
    }
    
    static /* synthetic */ CompatibleSound access$102(final ItemMelee x0, final CompatibleSound x1) {
        return x0.heavyAttackSound = x1;
    }
    
    static {
        logger = LogManager.getLogger((Class)ItemMelee.class);
    }
    
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
            itemMelee.attackSound = ((this.attackSound != null) ? modContext.registerSound(this.attackSound) : CompatibleSound.SNOWBALL_THROW);
            itemMelee.heavyAttackSound = ((this.heavyAttackSound != null) ? modContext.registerSound(this.heavyAttackSound) : CompatibleSound.SNOWBALL_THROW);
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
    
    public enum State
    {
        READY, 
        SHOOTING, 
        RELOAD_REQUESTED, 
        RELOAD_CONFIRMED, 
        UNLOAD_STARTED, 
        UNLOAD_REQUESTED_FROM_SERVER, 
        UNLOAD_CONFIRMED, 
        PAUSED, 
        MODIFYING, 
        EJECT_SPENT_ROUND;
        
        private static final /* synthetic */ State[] $VALUES;
        
        public static State[] values() {
            return State.$VALUES.clone();
        }
        
        public static State valueOf(final String name) {
            return Enum.valueOf(State.class, name);
        }
        
        static {
            $VALUES = new State[] { State.READY, State.SHOOTING, State.RELOAD_REQUESTED, State.RELOAD_CONFIRMED, State.UNLOAD_STARTED, State.UNLOAD_REQUESTED_FROM_SERVER, State.UNLOAD_CONFIRMED, State.PAUSED, State.MODIFYING, State.EJECT_SPENT_ROUND };
        }
    }
}
