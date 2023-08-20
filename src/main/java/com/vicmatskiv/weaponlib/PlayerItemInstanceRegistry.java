package com.vicmatskiv.weaponlib;

import com.google.common.cache.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.state.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.item.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class PlayerItemInstanceRegistry
{
    private static final int CACHE_EXPIRATION_TIMEOUT_SECONDS = 5;
    private static final Logger logger;
    private Map<UUID, Map<Integer, PlayerItemInstance<?>>> registry;
    private SyncManager<?> syncManager;
    private Cache<ItemStack, Optional<PlayerItemInstance<?>>> itemStackInstanceCache;
    
    public PlayerItemInstanceRegistry(final SyncManager<?> syncManager) {
        super();
        this.registry = new HashMap<UUID, Map<Integer, PlayerItemInstance<?>>>();
        this.syncManager = syncManager;
        this.itemStackInstanceCache = CacheBuilder.newBuilder().weakKeys().maximumSize(1000L).expireAfterAccess(5L, TimeUnit.SECONDS).build();
    }
    
    public <T extends PlayerItemInstance<S>, S extends ManagedState<S>> T getMainHandItemInstance(final EntityPlayer player, final Class<T> targetClass) {
        if (player == null) {
            return null;
        }
        final PlayerItemInstance<?> instance = this.getItemInstance(player, CompatibilityProvider.compatibility.getCurrentInventoryItemIndex(player));
        return (T)(targetClass.isInstance(instance) ? ((T)targetClass.cast(instance)) : null);
    }
    
    public PlayerItemInstance<?> getMainHandItemInstance(final EntityPlayer player) {
        return this.getItemInstance(player, CompatibilityProvider.compatibility.getCurrentInventoryItemIndex(player));
    }
    
    public PlayerItemInstance<?> getItemInstance(final EntityPlayer player, final int slot) {
        final Map<Integer, PlayerItemInstance<?>> slotInstances = this.registry.computeIfAbsent(player.getPersistentID(), p -> new HashMap());
        PlayerItemInstance<?> result = slotInstances.get(slot);
        if (result == null) {
            result = this.createItemInstance(player, slot);
            if (result != null) {
                slotInstances.put(slot, result);
                this.syncManager.watch(result);
                result.markDirty();
            }
        }
        else {
            final ItemStack slotItemStack = CompatibilityProvider.compatibility.getInventoryItemStack(player, slot);
            if (slotItemStack != null && slotItemStack.getItem() != result.getItem()) {
                this.syncManager.unwatch(result);
                result = this.createItemInstance(player, slot);
                if (result != null) {
                    slotInstances.put(slot, result);
                    this.syncManager.watch(result);
                    result.markDirty();
                }
            }
            if (result != null && result.getItemInventoryIndex() != slot) {
                PlayerItemInstanceRegistry.logger.warn("Invalid instance slot id, correcting...");
                result.setItemInventoryIndex(slot);
            }
            if (result != null && result.getPlayer() != player) {
                PlayerItemInstanceRegistry.logger.warn("Invalid player " + result.getPlayer() + " associated with instance in slot, changing to {}", new Object[] { player });
                result.setPlayer(player);
            }
        }
        return result;
    }
    
    private boolean isSameItem(final PlayerItemInstance<?> instance1, final PlayerItemInstance<?> instance2) {
        return Item.getIdFromItem(instance1.getItem()) == Item.getIdFromItem(instance2.getItem());
    }
    
    public <S extends ManagedState<S>, T extends PlayerItemInstance<S>> boolean update(final S newManagedState, final T extendedStateToMerge) {
        final Map<Integer, PlayerItemInstance<?>> slotContexts = this.registry.get(extendedStateToMerge.getPlayer().getUniqueID());
        boolean result = false;
        if (slotContexts != null) {
            final T currentState = (T)slotContexts.get(extendedStateToMerge.getItemInventoryIndex());
            if (currentState != null && this.isSameItem(currentState, extendedStateToMerge)) {
                extendedStateToMerge.setState(newManagedState);
                if (newManagedState.commitPhase() != null) {
                    currentState.prepareTransaction(extendedStateToMerge);
                }
                else {
                    currentState.updateWith(extendedStateToMerge, true);
                }
                result = true;
            }
        }
        return result;
    }
    
    private PlayerItemInstance<?> createItemInstance(final EntityPlayer player, final int slot) {
        final ItemStack itemStack = CompatibilityProvider.compatibility.getInventoryItemStack(player, slot);
        PlayerItemInstance<?> result = null;
        if (itemStack != null && itemStack.getItem() instanceof PlayerItemInstanceFactory) {
            PlayerItemInstanceRegistry.logger.debug("Creating instance for slot {} from stack {}", new Object[] { slot, itemStack });
            try {
                result = Tags.getInstance(itemStack);
            }
            catch (final RuntimeException e) {
                PlayerItemInstanceRegistry.logger.debug("Failed to deserialize instance from {}", new Object[] { itemStack });
            }
            if (result == null) {
                result = ((PlayerItemInstanceFactory)itemStack.getItem()).createItemInstance(player, itemStack, slot);
            }
            result.setItemInventoryIndex(slot);
            result.setPlayer(player);
        }
        return result;
    }
    
    public PlayerItemInstance<?> getItemInstance(final EntityPlayer player, final ItemStack itemStack) {
        Optional<PlayerItemInstance<?>> result = Optional.empty();
        try {
            result = this.itemStackInstanceCache.get(itemStack, () -> {
                PlayerItemInstanceRegistry.logger.debug("ItemStack {} not found in cache, initializing...", new Object[] { itemStack2 });
                PlayerItemInstance<?> instance = null;
                int slot = -1;
                if (CompatibilityProvider.compatibility.clientPlayer() == player2) {
                    slot = CompatibilityProvider.compatibility.getInventorySlot(player2, itemStack2);
                }
                if (slot >= 0) {
                    instance = this.getItemInstance(player2, slot);
                    PlayerItemInstanceRegistry.logger.debug("Resolved item stack instance {} in slot {}", new Object[] { instance, slot });
                }
                else {
                    try {
                        instance = Tags.getInstance(itemStack2);
                    }
                    catch (final RuntimeException e2) {
                        PlayerItemInstanceRegistry.logger.error("Failed to deserialize instance from stack {}: {}", new Object[] { itemStack2, e2.toString() });
                    }
                }
                return Optional.ofNullable(instance);
            });
        }
        catch (final UncheckedExecutionException | ExecutionException e) {
            PlayerItemInstanceRegistry.logger.error("Failed to initialize cache instance from {}", new Object[] { itemStack, e.getCause() });
        }
        return result.orElse(null);
    }
    
    public void update(final EntityPlayer player) {
        if (player == null) {
            return;
        }
        final Map<Integer, PlayerItemInstance<?>> slotContexts = this.registry.get(player.getPersistentID());
        if (slotContexts != null) {
            final Iterator<Map.Entry<Integer, PlayerItemInstance<?>>> it = slotContexts.entrySet().iterator();
            while (it.hasNext()) {
                final Map.Entry<Integer, PlayerItemInstance<?>> e = it.next();
                final ItemStack slotStack = CompatibilityProvider.compatibility.getInventoryItemStack(player, e.getKey());
                if (slotStack == null || slotStack.getItem() != e.getValue().getItem()) {
                    PlayerItemInstanceRegistry.logger.debug("Removing {} from slot {}", new Object[] { e.getValue(), e.getKey() });
                    this.syncManager.unwatch(e.getValue());
                    it.remove();
                }
            }
        }
    }
    
    private /* synthetic */ Optional lambda$getItemInstance$54(final ItemStack itemStack, final EntityPlayer player) throws Exception {
        PlayerItemInstanceRegistry.logger.debug("ItemStack {} not found in cache, initializing...", new Object[] { itemStack });
        PlayerItemInstance<?> instance = null;
        int slot = -1;
        if (CompatibilityProvider.compatibility.clientPlayer() == player) {
            slot = CompatibilityProvider.compatibility.getInventorySlot(player, itemStack);
        }
        if (slot >= 0) {
            instance = this.getItemInstance(player, slot);
            PlayerItemInstanceRegistry.logger.debug("Resolved item stack instance {} in slot {}", new Object[] { instance, slot });
        }
        else {
            try {
                instance = Tags.getInstance(itemStack);
            }
            catch (final RuntimeException e) {
                PlayerItemInstanceRegistry.logger.error("Failed to deserialize instance from stack {}: {}", new Object[] { itemStack, e.toString() });
            }
        }
        return Optional.ofNullable(instance);
    }
    
    private static /* synthetic */ Map lambda$getItemInstance$53(final UUID p) {
        return new HashMap();
    }
    
    static {
        logger = LogManager.getLogger((Class)PlayerItemInstanceRegistry.class);
    }
}
