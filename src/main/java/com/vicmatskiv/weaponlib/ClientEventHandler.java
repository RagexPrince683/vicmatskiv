package com.vicmatskiv.weaponlib;

import net.minecraft.entity.ai.attributes.*;
import java.util.*;
import java.util.concurrent.locks.*;
import com.vicmatskiv.weaponlib.tracking.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.perspective.*;
import org.apache.logging.log4j.*;

public class ClientEventHandler extends CompatibleClientEventHandler
{
    private static final UUID SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER_UUID;
    private static final AttributeModifier SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER;
    private static final Logger logger;
    private Lock mainLoopLock;
    private SafeGlobals safeGlobals;
    private Queue<Runnable> runInClientThreadQueue;
    private long renderEndNanoTime;
    private ClientModContext modContext;
    
    public ClientEventHandler(final ClientModContext modContext, final Lock mainLoopLock, final SafeGlobals safeGlobals, final Queue<Runnable> runInClientThreadQueue) {
        super();
        this.mainLoopLock = new ReentrantLock();
        this.modContext = modContext;
        this.mainLoopLock = mainLoopLock;
        this.safeGlobals = safeGlobals;
        this.runInClientThreadQueue = runInClientThreadQueue;
        this.renderEndNanoTime = System.nanoTime();
    }
    
    public void onCompatibleClientTick(final CompatibleClientTickEvent event) {
        if (event.getPhase() == CompatibleClientTickEvent.Phase.START) {
            this.mainLoopLock.lock();
        }
        else if (event.getPhase() == CompatibleClientTickEvent.Phase.END) {
            this.update();
            this.modContext.getSyncManager().run();
            final PlayerEntityTracker tracker = PlayerEntityTracker.getTracker(CompatibilityProvider.compatibility.clientPlayer());
            if (tracker != null) {
                tracker.update();
            }
            this.mainLoopLock.unlock();
            this.processRunInClientThreadQueue();
            this.safeGlobals.objectMouseOver.set(CompatibilityProvider.compatibility.getObjectMouseOver());
            if (CompatibilityProvider.compatibility.clientPlayer() != null) {
                this.safeGlobals.currentItemIndex.set(CompatibilityProvider.compatibility.clientPlayer().inventory.currentItem);
            }
        }
    }
    
    private void update() {
        final EntityPlayer player = CompatibilityProvider.compatibility.clientPlayer();
        this.modContext.getPlayerItemInstanceRegistry().update(player);
        final PlayerWeaponInstance mainHandHeldWeaponInstance = this.modContext.getMainHeldWeapon();
        if (mainHandHeldWeaponInstance != null) {
            if (player.isSprinting()) {
                mainHandHeldWeaponInstance.setAimed(false);
            }
            if (mainHandHeldWeaponInstance.isAimed()) {
                this.slowPlayerDown(player);
            }
            else {
                this.restorePlayerSpeed(player);
            }
        }
        else if (player != null) {
            this.restorePlayerSpeed(player);
        }
    }
    
    private void restorePlayerSpeed(final EntityPlayer entityPlayer) {
        if (entityPlayer.getEntityAttribute(CompatibilityProvider.compatibility.getMovementSpeedAttribute()).getModifier(ClientEventHandler.SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER.getID()) != null) {
            entityPlayer.getEntityAttribute(CompatibilityProvider.compatibility.getMovementSpeedAttribute()).removeModifier(ClientEventHandler.SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER);
        }
    }
    
    private void slowPlayerDown(final EntityPlayer entityPlayer) {
        if (entityPlayer.getEntityAttribute(CompatibilityProvider.compatibility.getMovementSpeedAttribute()).getModifier(ClientEventHandler.SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER.getID()) == null) {
            entityPlayer.getEntityAttribute(CompatibilityProvider.compatibility.getMovementSpeedAttribute()).applyModifier(ClientEventHandler.SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER);
        }
    }
    
    private void processRunInClientThreadQueue() {
        Runnable r;
        while ((r = this.runInClientThreadQueue.poll()) != null) {
            r.run();
        }
    }
    
    @Override
    protected void onCompatibleRenderTickEvent(final CompatibleRenderTickEvent event) {
        if (event.getPhase() == CompatibleRenderTickEvent.Phase.START && CompatibilityProvider.compatibility.clientPlayer() != null) {
            final PlayerItemInstance<?> instance = this.modContext.getPlayerItemInstanceRegistry().getMainHandItemInstance(CompatibilityProvider.compatibility.clientPlayer());
            if (instance != null) {
                final Perspective<?> view = this.modContext.getViewManager().getPerspective(instance, true);
                if (view != null) {
                    view.update(event);
                }
            }
        }
        else if (event.getPhase() == CompatibleRenderTickEvent.Phase.END) {
            this.safeGlobals.renderingPhase.set(null);
        }
    }
    
    @Override
    protected ModContext getModContext() {
        return this.modContext;
    }
    
    static {
        SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER_UUID = UUID.fromString("8efa8469-0256-4f8e-bdd9-3e7b23970663");
        SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER = new AttributeModifier(ClientEventHandler.SLOW_DOWN_WHILE_ZOOMING_ATTRIBUTE_MODIFIER_UUID, "Slow Down While Zooming", -0.5, 2).setSaved(false);
        logger = LogManager.getLogger((Class)ClientEventHandler.class);
    }
}
