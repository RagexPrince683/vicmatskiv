package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.perspective.*;
import net.minecraft.client.shader.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;
import com.vicmatskiv.weaponlib.config.*;
import net.minecraft.client.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import com.vicmatskiv.weaponlib.command.*;
import net.minecraft.client.resources.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.electronics.*;
import java.util.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.melee.*;
import com.vicmatskiv.weaponlib.grenade.*;

public class ClientModContext extends CommonModContext
{
    private ClientEventHandler clientEventHandler;
    private Lock mainLoopLock;
    private Queue<Runnable> runInClientThreadQueue;
    private CompatibleRenderingRegistry rendererRegistry;
    private SafeGlobals safeGlobals;
    private StatusMessageCenter statusMessageCenter;
    private PerspectiveManager viewManager;
    private float aspectRatio;
    private Framebuffer inventoryFramebuffer;
    private Map<Object, Integer> inventoryTextureMap;
    private EffectManager effectManager;
    
    public ClientModContext() {
        super();
        this.mainLoopLock = new ReentrantLock();
        this.runInClientThreadQueue = new LinkedBlockingQueue<Runnable>();
        this.safeGlobals = new SafeGlobals();
    }
    
    @Override
    public void init(final Object mod, final String modId, final ConfigurationManager configurationManager, final CompatibleChannel channel) {
        super.init(mod, modId, configurationManager, channel);
        this.aspectRatio = Minecraft.getMinecraft().displayWidth / (float)Minecraft.getMinecraft().displayHeight;
        ClientCommandHandler.instance.registerCommand((ICommand)new DebugCommand(modId));
        ClientCommandHandler.instance.registerCommand((ICommand)new MainCommand(modId, this));
        this.statusMessageCenter = new StatusMessageCenter();
        this.rendererRegistry = new CompatibleRenderingRegistry(modId);
        final List<IResourcePack> defaultResourcePacks = CompatibilityProvider.compatibility.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "defaultResourcePacks", "field_110449_ao");
        defaultResourcePacks.add((IResourcePack)new WeaponResourcePack());
        CompatibilityProvider.compatibility.registerWithEventBus(new CustomGui(Minecraft.getMinecraft(), this, this.weaponAttachmentAspect));
        CompatibilityProvider.compatibility.registerWithEventBus(new WeaponEventHandler(this, this.safeGlobals));
        KeyBindings.init();
        final ClientWeaponTicker clientWeaponTicker = new ClientWeaponTicker(this);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> clientWeaponTicker2.shutdown()));
        clientWeaponTicker.start();
        this.clientEventHandler = new ClientEventHandler(this, this.mainLoopLock, this.safeGlobals, this.runInClientThreadQueue);
        CompatibilityProvider.compatibility.registerWithFmlEventBus(this.clientEventHandler);
        CompatibilityProvider.compatibility.registerRenderingRegistry(this.rendererRegistry);
        this.rendererRegistry.registerEntityRenderingHandler(WeaponSpawnEntity.class, new SpawnEntityRenderer());
        this.rendererRegistry.registerEntityRenderingHandler((Class<? extends Entity>)EntityWirelessCamera.class, new WirelessCameraRenderer(modId));
        this.rendererRegistry.registerEntityRenderingHandler(EntityShellCasing.class, new ShellCasingRenderer());
        this.rendererRegistry.registerEntityRenderingHandler(EntityGrenade.class, new EntityGrenadeRenderer());
        this.rendererRegistry.registerEntityRenderingHandler(EntitySmokeGrenade.class, new EntityGrenadeRenderer());
        this.viewManager = new PerspectiveManager(this);
        this.inventoryTextureMap = new HashMap<Object, Integer>();
        this.effectManager = new ClientEffectManager();
    }
    
    @Override
    public void registerServerSideOnly() {
    }
    
    public PerspectiveManager getViewManager() {
        return this.viewManager;
    }
    
    public SafeGlobals getSafeGlobals() {
        return this.safeGlobals;
    }
    
    @Override
    public void registerWeapon(final String name, final Weapon weapon, final WeaponRenderer renderer) {
        super.registerWeapon(name, weapon, renderer);
        this.rendererRegistry.register(weapon, weapon.getName(), weapon.getRenderer());
        renderer.setClientModContext(this);
    }
    
    @Override
    public void registerRenderableItem(final String name, final Item item, final Object renderer) {
        super.registerRenderableItem(name, item, renderer);
        this.rendererRegistry.register(item, name, renderer);
    }
    
    @Override
    protected EntityPlayer getPlayer(final CompatibleMessageContext ctx) {
        return CompatibilityProvider.compatibility.clientPlayer();
    }
    
    @Override
    public void runSyncTick(final Runnable runnable) {
        this.mainLoopLock.lock();
        try {
            runnable.run();
        }
        finally {
            this.mainLoopLock.unlock();
        }
    }
    
    @Override
    public void runInMainThread(final Runnable runnable) {
        this.runInClientThreadQueue.add(runnable);
    }
    
    @Override
    public PlayerItemInstanceRegistry getPlayerItemInstanceRegistry() {
        return this.playerItemInstanceRegistry;
    }
    
    protected SyncManager<?> getSyncManager() {
        return this.syncManager;
    }
    
    @Override
    public PlayerWeaponInstance getMainHeldWeapon() {
        return this.getPlayerItemInstanceRegistry().getMainHandItemInstance(CompatibilityProvider.compatibility.clientPlayer(), PlayerWeaponInstance.class);
    }
    
    @Override
    public StatusMessageCenter getStatusMessageCenter() {
        return this.statusMessageCenter;
    }
    
    public PlayerMeleeInstance getMainHeldMeleeWeapon() {
        return this.getPlayerItemInstanceRegistry().getMainHandItemInstance(CompatibilityProvider.compatibility.clientPlayer(), PlayerMeleeInstance.class);
    }
    
    @Override
    public void registerMeleeWeapon(final String name, final ItemMelee itemMelee, final MeleeRenderer renderer) {
        super.registerMeleeWeapon(name, itemMelee, renderer);
        this.rendererRegistry.register(itemMelee, itemMelee.getName(), itemMelee.getRenderer());
        renderer.setClientModContext(this);
    }
    
    @Override
    public void registerGrenadeWeapon(final String name, final ItemGrenade itemGrenade, final GrenadeRenderer renderer) {
        super.registerGrenadeWeapon(name, itemGrenade, renderer);
        this.rendererRegistry.register(itemGrenade, itemGrenade.getName(), itemGrenade.getRenderer());
        renderer.setClientModContext(this);
    }
    
    @Override
    public float getAspectRatio() {
        return this.aspectRatio;
    }
    
    public Framebuffer getInventoryFramebuffer() {
        if (this.inventoryFramebuffer == null) {
            (this.inventoryFramebuffer = new Framebuffer(256, 256, true)).setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        return this.inventoryFramebuffer;
    }
    
    public Map<Object, Integer> getInventoryTextureMap() {
        return this.inventoryTextureMap;
    }
    
    @Override
    public String getModId() {
        return this.modId;
    }
    
    @Override
    public EffectManager getEffectManager() {
        return this.effectManager;
    }
    
    private static /* synthetic */ void lambda$init$205(final ClientWeaponTicker clientWeaponTicker) {
        clientWeaponTicker.shutdown();
    }
}
