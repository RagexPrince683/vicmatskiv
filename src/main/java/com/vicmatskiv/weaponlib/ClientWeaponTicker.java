package com.vicmatskiv.weaponlib;

import java.util.concurrent.atomic.*;
import org.lwjgl.input.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.grenade.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.melee.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

class ClientWeaponTicker extends Thread
{
    boolean[] buttonsPressed;
    long[] buttonsPressedTimestamps;
    private AtomicBoolean running;
    private ClientModContext clientModContext;
    
    public ClientWeaponTicker(final ClientModContext clientModContext) {
        super();
        this.buttonsPressed = new boolean[2];
        this.buttonsPressedTimestamps = new long[2];
        this.running = new AtomicBoolean(true);
        this.clientModContext = clientModContext;
    }
    
    void shutdown() {
        this.running.set(false);
    }
    
    @Override
    public void run() {
        final SafeGlobals safeGlobals = this.clientModContext.getSafeGlobals();
        int currentItemIndex = safeGlobals.currentItemIndex.get();
        while (this.running.get()) {
            try {
                if (!Mouse.isCreated()) {
                    continue;
                }
                if (Mouse.isButtonDown(1)) {
                    if (!this.buttonsPressed[1]) {
                        this.buttonsPressed[1] = true;
                        this.buttonsPressedTimestamps[1] = System.currentTimeMillis();
                        if (!safeGlobals.guiOpen.get() && !this.isInteracting()) {
                            this.clientModContext.runSyncTick(this::onRightButtonDown);
                        }
                    }
                }
                else if (this.buttonsPressed[1]) {
                    this.buttonsPressed[1] = false;
                    this.clientModContext.runSyncTick(this::onRightButtonUp);
                }
                if (Mouse.isButtonDown(0)) {
                    currentItemIndex = safeGlobals.currentItemIndex.get();
                    if (!this.buttonsPressed[0]) {
                        this.buttonsPressed[0] = true;
                    }
                    if (!safeGlobals.guiOpen.get() && !this.isInteracting()) {
                        this.clientModContext.runSyncTick(this::onLeftButtonDown);
                    }
                }
                else if (this.buttonsPressed[0] || currentItemIndex != safeGlobals.currentItemIndex.get()) {
                    this.buttonsPressed[0] = false;
                    currentItemIndex = safeGlobals.currentItemIndex.get();
                    this.clientModContext.runSyncTick(this::onLeftButtonUp);
                }
                this.clientModContext.runSyncTick(this::onTick);
                Thread.sleep(10L);
                continue;
            }
            catch (final InterruptedException e) {}
            break;
        }
    }
    
    private void onLeftButtonUp() {
        final EntityPlayer player = CompatibilityProvider.compatibility.getClientPlayer();
        final Item item = this.getHeldItemMainHand(player);
        if (item instanceof Weapon) {
            ((Weapon)item).tryStopFire(player);
        }
        else if (item instanceof ItemGrenade) {
            ((ItemGrenade)item).attackUp(player, true);
        }
    }
    
    private void onRightButtonUp() {
        final EntityPlayer player = CompatibilityProvider.compatibility.getClientPlayer();
        final Item item = this.getHeldItemMainHand(player);
        if (item instanceof ItemGrenade) {
            ((ItemGrenade)item).attackUp(player, false);
        }
    }
    
    private void onLeftButtonDown() {
        final EntityPlayer player = CompatibilityProvider.compatibility.getClientPlayer();
        final Item item = this.getHeldItemMainHand(player);
        if (item instanceof Weapon) {
            ((Weapon)item).tryFire(player);
        }
        else if (item instanceof ItemMelee) {
            ((ItemMelee)item).attack(player, false);
        }
        else if (item instanceof ItemGrenade) {
            ((ItemGrenade)item).attack(player, true);
        }
    }
    
    private void onRightButtonDown() {
        final EntityPlayer player = CompatibilityProvider.compatibility.getClientPlayer();
        final Item item = this.getHeldItemMainHand(player);
        if (item instanceof Weapon) {
            ((Weapon)item).toggleAiming();
        }
        else if (item instanceof ItemMelee) {
            ((ItemMelee)item).attack(player, true);
        }
        else if (item instanceof ItemGrenade) {
            ((ItemGrenade)item).attack(player, false);
        }
    }
    
    private void onTick() {
        final EntityPlayer player = CompatibilityProvider.compatibility.getClientPlayer();
        final Item item = this.getHeldItemMainHand(player);
        if (item instanceof Updatable) {
            ((Updatable)item).update(player);
        }
    }
    
    private boolean isInteracting() {
        return false;
    }
    
    private Item getHeldItemMainHand(final EntityPlayer player) {
        if (player == null) {
            return null;
        }
        final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)player);
        return (itemStack != null) ? itemStack.getItem() : null;
    }
}
