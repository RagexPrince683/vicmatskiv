package com.vicmatskiv.weaponlib;

import net.minecraftforge.event.entity.item.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.tracking.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraftforge.event.entity.living.*;
import org.apache.logging.log4j.*;

public class ServerEventHandler extends CompatibleServerEventHandler
{
    private static final Logger logger;
    private ModContext modContext;
    private String modId;
    
    public ServerEventHandler(final ModContext modContext, final String modId) {
        super();
        this.modContext = modContext;
        this.modId = modId;
    }
    
    @Override
    protected void onCompatibleItemToss(final ItemTossEvent itemTossEvent) {
    }
    
    @Override
    protected void onCompatibleEntityJoinWorld(final CompatibleEntityJoinWorldEvent e) {
        if (e.getEntity() instanceof Contextual) {
            ((Contextual)e.getEntity()).setContext(this.modContext);
        }
        if (e.getEntity() instanceof EntityPlayerMP && !e.getWorld().isRemote) {
            ServerEventHandler.logger.debug("Player {} joined the world", new Object[] { e.getEntity() });
            final PlayerEntityTracker tracker = PlayerEntityTracker.getTracker((EntityPlayer)e.getEntity());
            if (tracker != null) {
                this.modContext.getChannel().getChannel().sendTo((IMessage)new SyncPlayerEntityTrackerMessage(tracker), (EntityPlayerMP)e.getEntity());
            }
        }
    }
    
    @Override
    protected void onCompatiblePlayerStartedTracking(final CompatibleStartTrackingEvent e) {
        if (e.getTarget() instanceof EntityProjectile || e.getTarget() instanceof EntityBounceable) {
            return;
        }
        final PlayerEntityTracker tracker = PlayerEntityTracker.getTracker((EntityPlayer)e.getEntity());
        if (tracker != null && tracker.updateTrackableEntity(e.getTarget())) {
            ServerEventHandler.logger.debug("Player {} started tracking {} with uuid {}", new Object[] { e.getPlayer(), e.getTarget(), e.getTarget().getUniqueID() });
            this.modContext.getChannel().getChannel().sendTo((IMessage)new SyncPlayerEntityTrackerMessage(tracker), (EntityPlayerMP)e.getPlayer());
        }
    }
    
    @Override
    protected void onCompatiblePlayerStoppedTracking(final CompatibleStopTrackingEvent e) {
        if (e.getTarget() instanceof EntityProjectile || e.getTarget() instanceof EntityBounceable) {
            return;
        }
        final PlayerEntityTracker tracker = PlayerEntityTracker.getTracker((EntityPlayer)e.getEntity());
        if (tracker != null && tracker.updateTrackableEntity(e.getTarget())) {
            ServerEventHandler.logger.debug("Player {} stopped tracking {}", new Object[] { e.getPlayer(), e.getTarget() });
            this.modContext.getChannel().getChannel().sendTo((IMessage)new SyncPlayerEntityTrackerMessage(tracker), (EntityPlayerMP)e.getPlayer());
        }
    }
    
    @Override
    protected void onCompatibleLivingDeathEvent(final LivingDeathEvent e) {
    }
    
    @Override
    public String getModId() {
        return this.modId;
    }
    
    static {
        logger = LogManager.getLogger((Class)ServerEventHandler.class);
    }
}
