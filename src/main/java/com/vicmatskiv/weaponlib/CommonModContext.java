package com.vicmatskiv.weaponlib;

import net.minecraft.util.*;
import com.vicmatskiv.weaponlib.crafting.*;
import com.vicmatskiv.weaponlib.config.*;
import java.util.*;
import com.vicmatskiv.weaponlib.tracking.*;
import com.vicmatskiv.weaponlib.particle.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.melee.*;
import com.vicmatskiv.weaponlib.grenade.*;
import com.vicmatskiv.weaponlib.network.*;
import com.vicmatskiv.weaponlib.state.*;
import com.vicmatskiv.weaponlib.electronics.*;

public class CommonModContext implements ModContext
{
    protected String modId;
    protected CompatibleChannel channel;
    protected WeaponReloadAspect weaponReloadAspect;
    protected WeaponAttachmentAspect weaponAttachmentAspect;
    protected WeaponFireAspect weaponFireAspect;
    protected MeleeAttachmentAspect meleeAttachmentAspect;
    protected MeleeAttackAspect meleeAttackAspect;
    protected SyncManager<?> syncManager;
    protected MagazineReloadAspect magazineReloadAspect;
    protected NetworkPermitManager permitManager;
    protected PlayerItemInstanceRegistry playerItemInstanceRegistry;
    private Map<ResourceLocation, CompatibleSound> registeredSounds;
    private RecipeManager recipeManager;
    private CompatibleSound changeZoomSound;
    private CompatibleSound changeFireModeSound;
    private CompatibleSound noAmmoSound;
    private int modEntityID;
    private GrenadeAttackAspect grenadeAttackAspect;
    private CompatibleSound explosionSound;
    protected ConfigurationManager configurationManager;
    
    public CommonModContext() {
        super();
        this.registeredSounds = new HashMap<ResourceLocation, CompatibleSound>();
        this.modEntityID = 256;
    }
    
    @Override
    public void init(final Object mod, final String modId, final ConfigurationManager configurationManager, final CompatibleChannel channel) {
        this.channel = channel;
        this.modId = modId;
        this.configurationManager = configurationManager;
        this.weaponReloadAspect = new WeaponReloadAspect(this);
        this.magazineReloadAspect = new MagazineReloadAspect(this);
        this.weaponFireAspect = new WeaponFireAspect(this);
        this.weaponAttachmentAspect = new WeaponAttachmentAspect(this);
        this.meleeAttackAspect = new MeleeAttackAspect(this);
        this.meleeAttachmentAspect = new MeleeAttachmentAspect(this);
        this.grenadeAttackAspect = new GrenadeAttackAspect(this);
        final StateManager<GrenadeState, PlayerGrenadeInstance> grenadeStateManager = new StateManager<GrenadeState, PlayerGrenadeInstance>((s1, s2) -> s1 == s2);
        this.grenadeAttackAspect.setStateManager(grenadeStateManager);
        this.permitManager = new NetworkPermitManager(this);
        this.syncManager = new SyncManager<Object>(this.permitManager);
        this.playerItemInstanceRegistry = new PlayerItemInstanceRegistry(this.syncManager);
        final StateManager<WeaponState, PlayerWeaponInstance> weaponStateManager = new StateManager<WeaponState, PlayerWeaponInstance>((s1, s2) -> s1 == s2);
        this.weaponReloadAspect.setPermitManager(this.permitManager);
        this.weaponReloadAspect.setStateManager(weaponStateManager);
        this.weaponFireAspect.setPermitManager(this.permitManager);
        this.weaponFireAspect.setStateManager(weaponStateManager);
        this.weaponAttachmentAspect.setPermitManager(this.permitManager);
        this.weaponAttachmentAspect.setStateManager(weaponStateManager);
        final StateManager<MeleeState, PlayerMeleeInstance> meleeStateManager = new StateManager<MeleeState, PlayerMeleeInstance>((s1, s2) -> s1 == s2);
        this.meleeAttackAspect.setStateManager(meleeStateManager);
        this.meleeAttachmentAspect.setPermitManager(this.permitManager);
        this.meleeAttachmentAspect.setStateManager(meleeStateManager);
        final StateManager<MagazineState, PlayerMagazineInstance> magazineStateManager = new StateManager<MagazineState, PlayerMagazineInstance>((s1, s2) -> s1 == s2);
        this.magazineReloadAspect.setPermitManager(this.permitManager);
        this.magazineReloadAspect.setStateManager(magazineStateManager);
        this.recipeManager = new RecipeManager();
        channel.registerMessage((CompatibleMessageHandler<? super TryFireMessage, ? extends CompatibleMessage>)new TryFireMessageHandler(this.weaponFireAspect), TryFireMessage.class, 11, CompatibleSide.SERVER);
        channel.registerMessage((CompatibleMessageHandler<? super PermitMessage, ? extends CompatibleMessage>)this.permitManager, PermitMessage.class, 14, CompatibleSide.SERVER);
        channel.registerMessage((CompatibleMessageHandler<? super PermitMessage, ? extends CompatibleMessage>)this.permitManager, PermitMessage.class, 15, CompatibleSide.CLIENT);
        channel.registerMessage((CompatibleMessageHandler<? super TryAttackMessage, ? extends CompatibleMessage>)new TryAttackMessageHandler(this.meleeAttackAspect), TryAttackMessage.class, 16, CompatibleSide.SERVER);
        channel.registerMessage((CompatibleMessageHandler<? super SyncPlayerEntityTrackerMessage, ? extends CompatibleMessage>)new SyncPlayerEntityTrackerMessageMessageHandler(this), SyncPlayerEntityTrackerMessage.class, 17, CompatibleSide.CLIENT);
        channel.registerMessage((CompatibleMessageHandler<? super SpawnParticleMessage, ? extends CompatibleMessage>)new SpawnParticleMessageHandler(this), SpawnParticleMessage.class, 18, CompatibleSide.CLIENT);
        channel.registerMessage((CompatibleMessageHandler<? super BlockHitMessage, ? extends CompatibleMessage>)new BlockHitMessageHandler(this), BlockHitMessage.class, 19, CompatibleSide.CLIENT);
        channel.registerMessage((CompatibleMessageHandler<? super GrenadeMessage, ? extends CompatibleMessage>)new GrenadeMessageHandler(this.grenadeAttackAspect), GrenadeMessage.class, 20, CompatibleSide.SERVER);
        channel.registerMessage((CompatibleMessageHandler<? super ExplosionMessage, ? extends CompatibleMessage>)new ExplosionMessageHandler(this), ExplosionMessage.class, 21, CompatibleSide.CLIENT);
        final ServerEventHandler serverHandler = new ServerEventHandler(this, modId);
        CompatibilityProvider.compatibility.registerWithFmlEventBus(serverHandler);
        CompatibilityProvider.compatibility.registerWithEventBus(serverHandler);
        CompatibilityProvider.compatibility.registerWithFmlEventBus(new WeaponKeyInputHandler((ModContext)this, ctx -> this.getPlayer(ctx), this.weaponAttachmentAspect, channel));
        CompatiblePlayerEntityTrackerProvider.register(this);
        CompatibilityProvider.compatibility.registerModEntity(WeaponSpawnEntity.class, "Ammo" + this.modEntityID, this.modEntityID++, mod, modId, 64, 3, true);
        CompatibilityProvider.compatibility.registerModEntity((Class<? extends Entity>)EntityWirelessCamera.class, "wcam" + this.modEntityID, this.modEntityID++, mod, modId, 200, 3, true);
        CompatibilityProvider.compatibility.registerModEntity(EntityShellCasing.class, "ShellCasing" + this.modEntityID, this.modEntityID++, mod, modId, 64, 500, true);
        CompatibilityProvider.compatibility.registerModEntity(EntityGrenade.class, "Grenade" + this.modEntityID, this.modEntityID++, mod, modId, 64, 10000, false);
        CompatibilityProvider.compatibility.registerModEntity(EntitySmokeGrenade.class, "SmokeGrenade" + this.modEntityID, this.modEntityID++, mod, modId, 64, 10000, false);
    }
    
    public void registerServerSideOnly() {
    }
    
    @Override
    public CompatibleSound registerSound(final String sound) {
        final ResourceLocation soundResourceLocation = new ResourceLocation(this.modId, sound);
        return this.registerSound(soundResourceLocation);
    }
    
    protected CompatibleSound registerSound(final ResourceLocation soundResourceLocation) {
        CompatibleSound result = this.registeredSounds.get(soundResourceLocation);
        if (result == null) {
            result = new CompatibleSound(soundResourceLocation);
            this.registeredSounds.put(soundResourceLocation, result);
            CompatibilityProvider.compatibility.registerSound(result);
        }
        return result;
    }
    
    @Override
    public void registerWeapon(final String name, final Weapon weapon, final WeaponRenderer renderer) {
        CompatibilityProvider.compatibility.registerItem(weapon, name);
    }
    
    private EntityPlayer getServerPlayer(final CompatibleMessageContext ctx) {
        return (ctx != null) ? ctx.getPlayer() : null;
    }
    
    protected EntityPlayer getPlayer(final CompatibleMessageContext ctx) {
        return this.getServerPlayer(ctx);
    }
    
    @Override
    public CompatibleChannel getChannel() {
        return this.channel;
    }
    
    @Override
    public void runSyncTick(final Runnable runnable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void runInMainThread(final Runnable runnable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void registerRenderableItem(final String name, final Item item, final Object renderer) {
        CompatibilityProvider.compatibility.registerItem(item, name);
    }
    
    @Override
    public PlayerItemInstanceRegistry getPlayerItemInstanceRegistry() {
        return this.playerItemInstanceRegistry;
    }
    
    @Override
    public WeaponReloadAspect getWeaponReloadAspect() {
        return this.weaponReloadAspect;
    }
    
    @Override
    public WeaponFireAspect getWeaponFireAspect() {
        return this.weaponFireAspect;
    }
    
    @Override
    public WeaponAttachmentAspect getAttachmentAspect() {
        return this.weaponAttachmentAspect;
    }
    
    @Override
    public MagazineReloadAspect getMagazineReloadAspect() {
        return this.magazineReloadAspect;
    }
    
    @Override
    public MeleeAttackAspect getMeleeAttackAspect() {
        return this.meleeAttackAspect;
    }
    
    @Override
    public MeleeAttachmentAspect getMeleeAttachmentAspect() {
        return this.meleeAttachmentAspect;
    }
    
    @Override
    public PlayerWeaponInstance getMainHeldWeapon() {
        throw new IllegalStateException();
    }
    
    @Override
    public StatusMessageCenter getStatusMessageCenter() {
        throw new IllegalStateException();
    }
    
    @Override
    public RecipeManager getRecipeManager() {
        return this.recipeManager;
    }
    
    @Override
    public void setChangeZoomSound(final String sound) {
        this.changeZoomSound = this.registerSound(sound.toLowerCase());
    }
    
    @Override
    public CompatibleSound getZoomSound() {
        return this.changeZoomSound;
    }
    
    @Override
    public CompatibleSound getChangeFireModeSound() {
        return this.changeFireModeSound;
    }
    
    @Override
    public void setChangeFireModeSound(final String sound) {
        this.changeFireModeSound = this.registerSound(sound.toLowerCase());
    }
    
    @Override
    public void setNoAmmoSound(final String sound) {
        this.noAmmoSound = this.registerSound(sound.toLowerCase());
    }
    
    @Override
    public CompatibleSound getNoAmmoSound() {
        return this.noAmmoSound;
    }
    
    @Override
    public void setExplosionSound(final String sound) {
        this.explosionSound = this.registerSound(sound.toLowerCase());
    }
    
    @Override
    public CompatibleSound getExplosionSound() {
        return this.explosionSound;
    }
    
    @Override
    public void registerMeleeWeapon(final String name, final ItemMelee itemMelee, final MeleeRenderer renderer) {
        CompatibilityProvider.compatibility.registerItem(itemMelee, name);
    }
    
    @Override
    public void registerGrenadeWeapon(final String name, final ItemGrenade itemMelee, final GrenadeRenderer renderer) {
        CompatibilityProvider.compatibility.registerItem(itemMelee, name);
    }
    
    @Override
    public ResourceLocation getNamedResource(final String name) {
        return new ResourceLocation(this.modId, name);
    }
    
    @Override
    public float getAspectRatio() {
        return 1.0f;
    }
    
    @Override
    public AttachmentContainer getGrenadeAttachmentAspect() {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Override
    public GrenadeAttackAspect getGrenadeAttackAspect() {
        return this.grenadeAttackAspect;
    }
    
    @Override
    public String getModId() {
        return this.modId;
    }
    
    @Override
    public EffectManager getEffectManager() {
        throw new IllegalStateException();
    }
    
    @Override
    public ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }
    
    private /* synthetic */ EntityPlayer lambda$init$204(final CompatibleMessageContext ctx) {
        return this.getPlayer(ctx);
    }
    
    private static /* synthetic */ boolean lambda$init$203(final MagazineState s1, final MagazineState s2) {
        return s1 == s2;
    }
    
    private static /* synthetic */ boolean lambda$init$202(final MeleeState s1, final MeleeState s2) {
        return s1 == s2;
    }
    
    private static /* synthetic */ boolean lambda$init$201(final WeaponState s1, final WeaponState s2) {
        return s1 == s2;
    }
    
    private static /* synthetic */ boolean lambda$init$200(final GrenadeState s1, final GrenadeState s2) {
        return s1 == s2;
    }
    
    static {
        TypeRegistry.getInstance().register(MagazineReloadAspect.LoadPermit.class);
        TypeRegistry.getInstance().register(MagazineState.class);
        TypeRegistry.getInstance().register(PlayerItemInstance.class);
        TypeRegistry.getInstance().register(PlayerWeaponInstance.class);
        TypeRegistry.getInstance().register(PlayerMagazineInstance.class);
        TypeRegistry.getInstance().register(PlayerWeaponInstance.class);
        TypeRegistry.getInstance().register(Permit.class);
        TypeRegistry.getInstance().register(WeaponAttachmentAspect.EnterAttachmentModePermit.class);
        TypeRegistry.getInstance().register(WeaponAttachmentAspect.ExitAttachmentModePermit.class);
        TypeRegistry.getInstance().register(WeaponAttachmentAspect.ChangeAttachmentPermit.class);
        TypeRegistry.getInstance().register(WeaponReloadAspect.UnloadPermit.class);
        TypeRegistry.getInstance().register(MagazineReloadAspect.LoadPermit.class);
        TypeRegistry.getInstance().register(PlayerWeaponInstance.class);
        TypeRegistry.getInstance().register(WeaponState.class);
        TypeRegistry.getInstance().register(PlayerMeleeInstance.class);
        TypeRegistry.getInstance().register(PlayerGrenadeInstance.class);
        TypeRegistry.getInstance().register(PlayerTabletInstance.class);
        TypeRegistry.getInstance().register(MeleeState.class);
        TypeRegistry.getInstance().register(TabletState.class);
    }
}
