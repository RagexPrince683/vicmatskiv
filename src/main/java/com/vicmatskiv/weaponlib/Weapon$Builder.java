package com.vicmatskiv.weaponlib;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.model.*;
import java.util.function.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.model.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.crafting.*;
import java.util.*;
import com.vicmatskiv.weaponlib.config.*;
import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public static class Builder
{
    private static final float DEFAULT_SPAWN_ENTITY_SPEED = 10.0f;
    private static final float DEFAULT_INACCURACY = 1.0f;
    private static final String DEFAULT_SHELL_CASING_TEXTURE_NAME = "weaponlib:/com/vicmatskiv/weaponlib/resources/shell.png";
    private static final float DEFAULT_SHELL_CASING_VELOCITY = 0.1f;
    private static final float DEFAULT_SHELL_CASING_GRAVITY_VELOCITY = 0.05f;
    private static final float DEFAULT_SHELL_CASING_INACCURACY = 20.0f;
    String name;
    List<String> textureNames;
    int ammoCapacity;
    float recoil;
    private String shootSound;
    private String silencedShootSound;
    private String reloadSound;
    private String unloadSound;
    private String ejectSpentRoundSound;
    private String exceededMaxShotsSound;
    ItemAmmo ammo;
    float fireRate;
    private CreativeTabs creativeTab;
    private WeaponRenderer renderer;
    List<Integer> maxShots;
    String crosshair;
    String crosshairRunning;
    String crosshairZoomed;
    BiFunction<Weapon, EntityPlayer, ? extends WeaponSpawnEntity> spawnEntityWith;
    BiFunction<PlayerWeaponInstance, EntityPlayer, ? extends EntityShellCasing> spawnShellWith;
    private float spawnEntityDamage;
    private float spawnEntityExplosionRadius;
    private float spawnEntityGravityVelocity;
    long reloadingTimeout;
    private String modId;
    boolean crosshairFullScreen;
    boolean crosshairZoomedFullScreen;
    Map<ItemAttachment<Weapon>, CompatibleAttachment<Weapon>> compatibleAttachments;
    ModelBase ammoModel;
    String ammoModelTextureName;
    ModelBase shellCasingModel;
    String shellCasingModelTextureName;
    private float spawnEntitySpeed;
    private Class<? extends WeaponSpawnEntity> spawnEntityClass;
    ImpactHandler blockImpactHandler;
    long pumpTimeoutMilliseconds;
    private float inaccuracy;
    int pellets;
    float flashIntensity;
    Supplier<Float> flashScale;
    Supplier<Float> flashOffsetX;
    Supplier<Float> flashOffsetY;
    Supplier<Float> smokeOffsetX;
    Supplier<Float> smokeOffsetY;
    long unloadingTimeout;
    private boolean ejectSpentRoundRequired;
    public int maxBulletsPerReload;
    private Function<ItemStack, List<String>> informationProvider;
    private CraftingComplexity craftingComplexity;
    private Object[] craftingMaterials;
    private float shellCasingForwardOffset;
    private float shellCasingVerticalOffset;
    private float shellCasingSideOffset;
    private float shellCasingSideOffsetAimed;
    public boolean shellCasingEjectEnabled;
    private ShellCasingEjectDirection shellCasingEjectDirection;
    private float silencedShootSoundVolume;
    private float shootSoundVolume;
    private Object[] craftingRecipe;
    
    public Builder() {
        super();
        this.textureNames = new ArrayList<String>();
        this.ammoCapacity = 0;
        this.recoil = 1.0f;
        this.fireRate = 0.5f;
        this.maxShots = new ArrayList<Integer>();
        this.reloadingTimeout = 10L;
        this.crosshairFullScreen = false;
        this.crosshairZoomedFullScreen = false;
        this.compatibleAttachments = new HashMap<ItemAttachment<Weapon>, CompatibleAttachment<Weapon>>();
        this.spawnEntitySpeed = 10.0f;
        this.inaccuracy = 1.0f;
        this.pellets = 1;
        this.flashIntensity = 0.7f;
        this.flashScale = (() -> 1.0f);
        this.flashOffsetX = (() -> 0.0f);
        this.flashOffsetY = (() -> 0.0f);
        this.smokeOffsetX = (() -> 0.0f);
        this.smokeOffsetY = (() -> 0.0f);
        this.unloadingTimeout = 10L;
        this.shellCasingForwardOffset = 0.1f;
        this.shellCasingVerticalOffset = 0.0f;
        this.shellCasingSideOffset = 0.15f;
        this.shellCasingSideOffsetAimed = 0.05f;
        this.shellCasingEjectEnabled = true;
        this.shellCasingEjectDirection = ShellCasingEjectDirection.RIGHT;
        this.silencedShootSoundVolume = 0.7f;
        this.shootSoundVolume = 10.0f;
    }
    
    public Builder withModId(final String modId) {
        this.modId = modId;
        return this;
    }
    
    public Builder withEjectRoundRequired() {
        this.ejectSpentRoundRequired = true;
        return this;
    }
    
    public Builder withInformationProvider(final Function<ItemStack, List<String>> informationProvider) {
        this.informationProvider = informationProvider;
        return this;
    }
    
    public Builder withReloadingTime(final long reloadingTime) {
        this.reloadingTimeout = reloadingTime;
        return this;
    }
    
    public Builder withUnloadingTime(final long unloadingTime) {
        this.unloadingTimeout = unloadingTime;
        return this;
    }
    
    public Builder withName(final String name) {
        this.name = name;
        return this;
    }
    
    public Builder withAmmoCapacity(final int ammoCapacity) {
        this.ammoCapacity = ammoCapacity;
        return this;
    }
    
    public Builder withMaxBulletsPerReload(final int maxBulletsPerReload) {
        this.maxBulletsPerReload = maxBulletsPerReload;
        return this;
    }
    
    public Builder withRecoil(final float recoil) {
        this.recoil = recoil;
        return this;
    }
    
    @Deprecated
    public Builder withZoom(final float zoom) {
        return this;
    }
    
    public Builder withAmmo(final ItemAmmo ammo) {
        this.ammo = ammo;
        return this;
    }
    
    public Builder withMaxShots(final int... maxShots) {
        for (final int m : maxShots) {
            this.maxShots.add(m);
        }
        return this;
    }
    
    public Builder withFireRate(final float fireRate) {
        if (fireRate >= 1.0f || fireRate <= 0.0f) {
            throw new IllegalArgumentException("Invalid fire rate " + fireRate);
        }
        this.fireRate = fireRate;
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
    
    public Builder withCrosshair(final String crosshair) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.crosshair = this.modId + ":" + "textures/crosshairs/" + crosshair.toLowerCase() + ".png";
        return this;
    }
    
    public Builder withCrosshair(final String crosshair, final boolean fullScreen) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.crosshair = this.modId + ":" + "textures/crosshairs/" + crosshair.toLowerCase() + ".png";
        this.crosshairFullScreen = fullScreen;
        return this;
    }
    
    public Builder withCrosshairRunning(final String crosshairRunning) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.crosshairRunning = this.modId + ":" + "textures/crosshairs/" + crosshairRunning.toLowerCase() + ".png";
        return this;
    }
    
    public Builder withCrosshairZoomed(final String crosshairZoomed) {
        return this.withCrosshairZoomed(crosshairZoomed, true);
    }
    
    public Builder withCrosshairZoomed(final String crosshairZoomed, final boolean fullScreen) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.crosshairZoomed = this.modId + ":" + "textures/crosshairs/" + crosshairZoomed.toLowerCase() + ".png";
        this.crosshairZoomedFullScreen = fullScreen;
        return this;
    }
    
    public Builder withShootSound(final String shootSound) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.shootSound = shootSound.toLowerCase();
        return this;
    }
    
    public Builder withEjectSpentRoundSound(final String ejectSpentRoundSound) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.ejectSpentRoundSound = ejectSpentRoundSound.toLowerCase();
        return this;
    }
    
    public Builder withSilencedShootSound(final String silencedShootSound) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.silencedShootSound = silencedShootSound.toLowerCase();
        return this;
    }
    
    public Builder withReloadSound(final String reloadSound) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.reloadSound = reloadSound.toLowerCase();
        return this;
    }
    
    public Builder withUnloadSound(final String unloadSound) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.unloadSound = unloadSound.toLowerCase();
        return this;
    }
    
    public Builder withShootSoundVolume(final float volume) {
        this.shootSoundVolume = volume;
        return this;
    }
    
    public Builder withSilenceShootSoundVolume(final float volume) {
        this.silencedShootSoundVolume = volume;
        return this;
    }
    
    public Builder withExceededMaxShotsSound(final String shootSound) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        this.exceededMaxShotsSound = shootSound.toLowerCase();
        return this;
    }
    
    public Builder withCreativeTab(final CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }
    
    public Builder withSpawnEntityDamage(final float spawnEntityDamage) {
        this.spawnEntityDamage = spawnEntityDamage;
        return this;
    }
    
    public Builder withSpawnEntitySpeed(final float spawnEntitySpeed) {
        this.spawnEntitySpeed = spawnEntitySpeed;
        return this;
    }
    
    public Builder withSpawnEntityExplosionRadius(final float spawnEntityExplosionRadius) {
        this.spawnEntityExplosionRadius = spawnEntityExplosionRadius;
        return this;
    }
    
    public Builder withSpawnEntityGravityVelocity(final float spawnEntityGravityVelocity) {
        this.spawnEntityGravityVelocity = spawnEntityGravityVelocity;
        return this;
    }
    
    public Builder withInaccuracy(final float inaccuracy) {
        this.inaccuracy = inaccuracy;
        return this;
    }
    
    public Builder withRenderer(final WeaponRenderer renderer) {
        this.renderer = renderer;
        return this;
    }
    
    public Builder withCompatibleBullet(final ItemBullet bullet, final Consumer<ModelBase> positioner) {
        this.compatibleAttachments.put(bullet, new CompatibleAttachment<Weapon>(bullet, positioner));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<Weapon> attachment, final ItemAttachment.ApplyHandler2<Weapon> applyHandler, final ItemAttachment.ApplyHandler2<Weapon> removeHandler) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<Weapon>(attachment, applyHandler, removeHandler));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<Weapon> attachment, final BiConsumer<EntityPlayer, ItemStack> positioning, final Consumer<ModelBase> modelPositioning) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<Weapon>(attachment, positioning, modelPositioning, false));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<Weapon> attachment, final BiConsumer<EntityPlayer, ItemStack> positioning) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<Weapon>(attachment, positioning, null, false));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<Weapon> attachment, final Consumer<ModelBase> positioner) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<Weapon>(attachment, positioner));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<Weapon> attachment, final boolean isDefault, final BiConsumer<EntityPlayer, ItemStack> positioning, final Consumer<ModelBase> modelPositioning) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<Weapon>(attachment, positioning, modelPositioning, isDefault));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<Weapon> attachment, final boolean isDefault, final boolean isPermanent, final BiConsumer<EntityPlayer, ItemStack> positioning, final Consumer<ModelBase> modelPositioning) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<Weapon>(attachment, positioning, modelPositioning, isDefault, isPermanent));
        return this;
    }
    
    public Builder withCompatibleAttachment(final ItemAttachment<Weapon> attachment, final boolean isDefault, final Consumer<ModelBase> positioner) {
        this.compatibleAttachments.put(attachment, new CompatibleAttachment<Weapon>(attachment, positioner, isDefault));
        return this;
    }
    
    public Builder withSpawnEntityModel(final ModelBase ammoModel) {
        this.ammoModel = ammoModel;
        return this;
    }
    
    public Builder withSpawnEntityModelTexture(final String ammoModelTextureName) {
        this.ammoModelTextureName = this.modId + ":" + "textures/models/" + ammoModelTextureName.toLowerCase() + ".png";
        return this;
    }
    
    public Builder withSpawnEntityBlockImpactHandler(final ImpactHandler impactHandler) {
        this.blockImpactHandler = impactHandler;
        return this;
    }
    
    public Builder withShellCasingEjectEnabled(final boolean shellCasingEjectEnabled) {
        this.shellCasingEjectEnabled = shellCasingEjectEnabled;
        return this;
    }
    
    public Builder withShellCasingModel(final ModelBase shellCasingModel) {
        this.shellCasingModel = shellCasingModel;
        return this;
    }
    
    public Builder withShellCasingModelTexture(final String shellModelTextureName) {
        this.shellCasingModelTextureName = this.modId + ":" + "textures/models/" + shellModelTextureName.toLowerCase() + ".png";
        return this;
    }
    
    public Builder withShellCasingForwardOffset(final float shellCasingForwardOffset) {
        this.shellCasingForwardOffset = shellCasingForwardOffset;
        return this;
    }
    
    public Builder withShellCasingVerticalOffset(final float shellCasingVerticalOffset) {
        this.shellCasingVerticalOffset = shellCasingVerticalOffset;
        return this;
    }
    
    public Builder withShellCasingSideOffset(final float shellCasingSideOffset) {
        this.shellCasingSideOffset = shellCasingSideOffset;
        return this;
    }
    
    public Builder withShellCasingSideOffsetAimed(final float shellCasingSideOffsetAimed) {
        this.shellCasingSideOffsetAimed = shellCasingSideOffsetAimed;
        return this;
    }
    
    public Builder withShellCasingEjectDirection(final ShellCasingEjectDirection shellCasingEjectDirection) {
        this.shellCasingEjectDirection = shellCasingEjectDirection;
        return this;
    }
    
    public Builder withPumpTimeout(final long pumpTimeoutMilliseconds) {
        this.pumpTimeoutMilliseconds = pumpTimeoutMilliseconds;
        return this;
    }
    
    public Builder withPellets(final int pellets) {
        if (pellets < 1) {
            throw new IllegalArgumentException("Pellet count must be >= 1");
        }
        this.pellets = pellets;
        return this;
    }
    
    public Builder withFlashIntensity(final float flashIntensity) {
        if (flashIntensity < 0.0f || flashIntensity > 1.0f) {
            throw new IllegalArgumentException("Invalid flash intencity");
        }
        this.flashIntensity = flashIntensity;
        return this;
    }
    
    public Builder withFlashScale(final Supplier<Float> flashScale) {
        this.flashScale = flashScale;
        return this;
    }
    
    public Builder withFlashOffsetX(final Supplier<Float> flashOffsetX) {
        this.flashOffsetX = flashOffsetX;
        return this;
    }
    
    public Builder withFlashOffsetY(final Supplier<Float> flashOffsetY) {
        this.flashOffsetY = flashOffsetY;
        return this;
    }
    
    public Builder withSmokeOffsetX(final Supplier<Float> smokeOffsetX) {
        this.smokeOffsetX = smokeOffsetX;
        return this;
    }
    
    public Builder withSmokeOffsetY(final Supplier<Float> smokeOffsetY) {
        this.smokeOffsetY = smokeOffsetY;
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
    
    public Weapon build(final ModContext modContext) {
        if (this.modId == null) {
            throw new IllegalStateException("ModId is not set");
        }
        if (this.name == null) {
            throw new IllegalStateException("Weapon name not provided");
        }
        if (this.shootSound == null) {
            this.shootSound = this.name;
        }
        if (this.silencedShootSound == null) {
            this.silencedShootSound = this.shootSound;
        }
        if (this.reloadSound == null) {
            this.reloadSound = "reload";
        }
        if (this.unloadSound == null) {
            this.unloadSound = "unload";
        }
        if (this.spawnEntityClass == null) {
            this.spawnEntityClass = WeaponSpawnEntity.class;
        }
        if (this.spawnEntityWith == null) {
            final Weapon weapon;
            this.spawnEntityWith = (BiFunction<Weapon, EntityPlayer, ? extends WeaponSpawnEntity>)((weapon, player) -> {
                final WeaponSpawnEntity bullet = new WeaponSpawnEntity(weapon, CompatibilityProvider.compatibility.world((Entity)player), (EntityLivingBase)player, this.spawnEntitySpeed, this.spawnEntityGravityVelocity, this.inaccuracy, this.spawnEntityDamage, this.spawnEntityExplosionRadius, new Material[0]);
                bullet.setPositionAndDirection();
                return bullet;
            });
        }
        if (this.shellCasingModel == null) {
            this.shellCasingModel = new Shell();
        }
        if (this.shellCasingModelTextureName == null) {
            this.shellCasingModelTextureName = "weaponlib:/com/vicmatskiv/weaponlib/resources/shell.png";
        }
        if (this.spawnShellWith == null) {
            this.spawnShellWith = (BiFunction<PlayerWeaponInstance, EntityPlayer, ? extends EntityShellCasing>)((weaponInstance, player) -> {
                final EntityShellCasing shell = new EntityShellCasing(weaponInstance, CompatibilityProvider.compatibility.world((Entity)player), (EntityLivingBase)player, 0.1f, 0.05f, 20.0f);
                shell.setPositionAndDirection();
                return shell;
            });
        }
        if (this.crosshairRunning == null) {
            this.crosshairRunning = this.crosshair;
        }
        if (this.crosshairZoomed == null) {
            this.crosshairZoomed = this.crosshair;
        }
        if (this.blockImpactHandler == null) {
            this.blockImpactHandler = ((world, player, entity, position) -> {
                final CompatibleBlockState blockState = CompatibilityProvider.compatibility.getBlockAtPosition(world, position);
                final Boolean canDestroyGlassBlocks = modContext2.getConfigurationManager().getProjectiles().isDestroyGlassBlocks();
                if (canDestroyGlassBlocks != null && canDestroyGlassBlocks && CompatibilityProvider.compatibility.isGlassBlock(blockState)) {
                    CompatibilityProvider.compatibility.destroyBlock(world, position);
                }
                else {
                    final CompatibleTargetPoint point = new CompatibleTargetPoint(entity.dimension, position.getBlockPosX(), position.getBlockPosY(), position.getBlockPosZ(), 100.0);
                    modContext2.getChannel().sendToAllAround(new BlockHitMessage(position.getBlockPosX(), position.getBlockPosY(), position.getBlockPosZ(), position.getSideHit()), point);
                }
                return;
            });
        }
        if (this.maxBulletsPerReload == 0) {
            this.maxBulletsPerReload = this.ammoCapacity;
        }
        if (this.maxShots.isEmpty()) {
            this.maxShots.add(Integer.MAX_VALUE);
        }
        final Weapon weapon = new Weapon(this, modContext);
        Weapon.access$002(weapon, modContext.registerSound(this.shootSound));
        Weapon.access$102(weapon, modContext.registerSound(this.reloadSound));
        Weapon.access$202(weapon, modContext.registerSound(this.unloadSound));
        Weapon.access$302(weapon, modContext.registerSound(this.silencedShootSound));
        if (this.ejectSpentRoundSound != null) {
            Weapon.access$402(weapon, modContext.registerSound(this.ejectSpentRoundSound));
        }
        weapon.setCreativeTab(this.creativeTab);
        weapon.setUnlocalizedName(this.name);
        if (this.ammo != null) {
            this.ammo.addCompatibleWeapon(weapon);
        }
        for (final ItemAttachment<Weapon> attachment : this.compatibleAttachments.keySet()) {
            attachment.addCompatibleWeapon(weapon);
        }
        final Gun gunConfig = modContext.getConfigurationManager().getGun(this.name);
        if (gunConfig == null || gunConfig.isEnabled()) {
            modContext.registerWeapon(this.name, weapon, this.renderer);
            if (this.craftingRecipe != null && this.craftingRecipe.length >= 2) {
                final ItemStack itemStack = new ItemStack((Item)weapon);
                final List<Object> registeredRecipe = modContext.getRecipeManager().registerShapedRecipe(weapon, this.craftingRecipe);
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
                final List<Object> shape = modContext.getRecipeManager().createShapedRecipe(weapon, weapon.getName(), optionsMetadata);
                if (optionsMetadata.hasOres()) {
                    CompatibilityProvider.compatibility.addShapedOreRecipe(new ItemStack((Item)weapon), shape.toArray());
                }
                else {
                    CompatibilityProvider.compatibility.addShapedRecipe(new ItemStack((Item)weapon), shape.toArray());
                }
            }
            else {
                System.err.println("!!!No recipe defined for weapon " + this.name);
            }
        }
        return weapon;
    }
    
    private static /* synthetic */ boolean lambda$build$18(final Object r) {
        return r instanceof String;
    }
    
    private static /* synthetic */ void lambda$build$17(final ModContext modContext, final World world, final EntityPlayer player, final WeaponSpawnEntity entity, final CompatibleRayTraceResult position) {
        final CompatibleBlockState blockState = CompatibilityProvider.compatibility.getBlockAtPosition(world, position);
        final Boolean canDestroyGlassBlocks = modContext.getConfigurationManager().getProjectiles().isDestroyGlassBlocks();
        if (canDestroyGlassBlocks != null && canDestroyGlassBlocks && CompatibilityProvider.compatibility.isGlassBlock(blockState)) {
            CompatibilityProvider.compatibility.destroyBlock(world, position);
        }
        else {
            final CompatibleTargetPoint point = new CompatibleTargetPoint(entity.dimension, position.getBlockPosX(), position.getBlockPosY(), position.getBlockPosZ(), 100.0);
            modContext.getChannel().sendToAllAround(new BlockHitMessage(position.getBlockPosX(), position.getBlockPosY(), position.getBlockPosZ(), position.getSideHit()), point);
        }
    }
    
    private static /* synthetic */ EntityShellCasing lambda$build$16(final PlayerWeaponInstance weaponInstance, final EntityPlayer player) {
        final EntityShellCasing shell = new EntityShellCasing(weaponInstance, CompatibilityProvider.compatibility.world((Entity)player), (EntityLivingBase)player, 0.1f, 0.05f, 20.0f);
        shell.setPositionAndDirection();
        return shell;
    }
    
    private /* synthetic */ WeaponSpawnEntity lambda$build$15(final Weapon weapon, final EntityPlayer player) {
        final WeaponSpawnEntity bullet = new WeaponSpawnEntity(weapon, CompatibilityProvider.compatibility.world((Entity)player), (EntityLivingBase)player, this.spawnEntitySpeed, this.spawnEntityGravityVelocity, this.inaccuracy, this.spawnEntityDamage, this.spawnEntityExplosionRadius, new Material[0]);
        bullet.setPositionAndDirection();
        return bullet;
    }
    
    private static /* synthetic */ Float lambda$new$14() {
        return 0.0f;
    }
    
    private static /* synthetic */ Float lambda$new$13() {
        return 0.0f;
    }
    
    private static /* synthetic */ Float lambda$new$12() {
        return 0.0f;
    }
    
    private static /* synthetic */ Float lambda$new$11() {
        return 0.0f;
    }
    
    private static /* synthetic */ Float lambda$new$10() {
        return 1.0f;
    }
    
    static /* synthetic */ boolean access$500(final Builder x0) {
        return x0.ejectSpentRoundRequired;
    }
    
    static /* synthetic */ WeaponRenderer access$600(final Builder x0) {
        return x0.renderer;
    }
    
    static /* synthetic */ Function access$700(final Builder x0) {
        return x0.informationProvider;
    }
    
    static /* synthetic */ float access$800(final Builder x0) {
        return x0.shellCasingVerticalOffset;
    }
    
    static /* synthetic */ float access$900(final Builder x0) {
        return x0.shellCasingForwardOffset;
    }
    
    static /* synthetic */ float access$1000(final Builder x0) {
        return x0.shellCasingSideOffset;
    }
    
    static /* synthetic */ float access$1100(final Builder x0) {
        return x0.shellCasingSideOffsetAimed;
    }
    
    static /* synthetic */ ShellCasingEjectDirection access$1200(final Builder x0) {
        return x0.shellCasingEjectDirection;
    }
    
    static /* synthetic */ float access$1300(final Builder x0) {
        return x0.silencedShootSoundVolume;
    }
    
    static /* synthetic */ float access$1400(final Builder x0) {
        return x0.shootSoundVolume;
    }
}
