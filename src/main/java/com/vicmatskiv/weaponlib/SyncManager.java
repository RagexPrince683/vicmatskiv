package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;
import net.minecraft.item.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import org.apache.logging.log4j.*;

public class SyncManager<S extends ManagedState<S>>
{
    private static final Logger logger;
    private PermitManager permitManager;
    private Map<PlayerItemInstance<?>, Long> watchables;
    private long syncTimeout;
    
    public SyncManager(final PermitManager permitManager) {
        super();
        this.watchables = new LinkedHashMap<PlayerItemInstance<?>, Long>();
        this.syncTimeout = 10000L;
        (this.permitManager = permitManager).registerEvaluator(Permit.class, PlayerItemInstance.class, this::syncOnServer);
    }
    
    private void syncOnServer(final Permit<S> permit, final PlayerItemInstance<S> instance) {
        SyncManager.logger.debug("Syncing {} in state {} on server", new Object[] { instance, instance.getState() });
        final ItemStack itemStack = instance.getItemStack();
        if (itemStack != null) {
            SyncManager.logger.debug("Stored {} in stack {}", new Object[] { instance, itemStack });
            Tags.setInstance(itemStack, instance);
        }
    }
    
    public void watch(final PlayerItemInstance<?> watchableInstance) {
        this.watchables.put(watchableInstance, watchableInstance.getUpdateId());
    }
    
    public void unwatch(final PlayerItemInstance<?> watchableInstance) {
        this.watchables.remove(watchableInstance);
    }
    
    public void run() {
        final List<PlayerItemInstance<?>> instancesToUpdate = this.watchables.entrySet().stream().filter(e -> e.getKey().getUpdateId() != e.getValue() && e.getKey().getSyncStartTimestamp() + this.syncTimeout < System.currentTimeMillis()).map(e -> e.getKey()).collect((Collector<? super Object, ?, List<PlayerItemInstance<?>>>)Collectors.toList());
        instancesToUpdate.forEach(this::sync);
    }
    
    private void sync(final PlayerItemInstance<?> watchable) {
        SyncManager.logger.debug("Syncing {} in state {} with update id {} to server", new Object[] { watchable, watchable.getState(), watchable.getUpdateId() });
        final long updateId = watchable.getUpdateId();
        watchable.setSyncStartTimestamp(System.currentTimeMillis());
        this.permitManager.request((Permit)new Permit((ManagedState)watchable.getState()), watchable, (p, e) -> {
            this.watchables.put(playerItemInstance, n);
            playerItemInstance.setSyncStartTimestamp(0L);
            SyncManager.logger.debug("Completed syncing {} with update id {}", new Object[] { playerItemInstance, n });
        });
    }
    
    private /* synthetic */ void lambda$sync$210(final PlayerItemInstance playerItemInstance, final long n, final Permit p, final PlayerItemInstance e) {
        this.watchables.put(playerItemInstance, n);
        playerItemInstance.setSyncStartTimestamp(0L);
        SyncManager.logger.debug("Completed syncing {} with update id {}", new Object[] { playerItemInstance, n });
    }
    
    private static /* synthetic */ PlayerItemInstance lambda$run$209(final Map.Entry e) {
        return e.getKey();
    }
    
    private /* synthetic */ boolean lambda$run$208(final Map.Entry e) {
        return e.getKey().getUpdateId() != e.getValue() && e.getKey().getSyncStartTimestamp() + this.syncTimeout < System.currentTimeMillis();
    }
    
    static {
        logger = LogManager.getLogger((Class)SyncManager.class);
    }
}
