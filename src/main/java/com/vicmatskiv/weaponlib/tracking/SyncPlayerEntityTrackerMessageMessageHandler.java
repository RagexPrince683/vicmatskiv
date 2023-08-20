package com.vicmatskiv.weaponlib.tracking;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class SyncPlayerEntityTrackerMessageMessageHandler implements CompatibleMessageHandler<SyncPlayerEntityTrackerMessage, CompatibleMessage>
{
    private ModContext modContext;
    
    public SyncPlayerEntityTrackerMessageMessageHandler(final ModContext modContex) {
        super();
        this.modContext = modContex;
    }
    
    @Override
    public <T extends CompatibleMessage> T onCompatibleMessage(final SyncPlayerEntityTrackerMessage message, final CompatibleMessageContext ctx) {
        if (!ctx.isServerSide()) {
            CompatibilityProvider.compatibility.runInMainClientThread(() -> {
                CompatiblePlayerEntityTrackerProvider.setTracker(CompatibilityProvider.compatibility.clientPlayer(), syncPlayerEntityTrackerMessage.getTracker().apply(CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer())));
                if (syncPlayerEntityTrackerMessage.getStatusMessage() != null) {
                    this.modContext.getStatusMessageCenter().addMessage(syncPlayerEntityTrackerMessage.getStatusMessage(), 1000L);
                }
                return;
            });
        }
        return null;
    }
    
    @Override
    public /* bridge */ CompatibleMessage onCompatibleMessage(final CompatibleMessage compatibleMessage, final CompatibleMessageContext ctx) {
        return this.onCompatibleMessage((SyncPlayerEntityTrackerMessage)compatibleMessage, ctx);
    }
    
    private /* synthetic */ void lambda$onCompatibleMessage$283(final SyncPlayerEntityTrackerMessage syncPlayerEntityTrackerMessage) {
        CompatiblePlayerEntityTrackerProvider.setTracker(CompatibilityProvider.compatibility.clientPlayer(), syncPlayerEntityTrackerMessage.getTracker().apply(CompatibilityProvider.compatibility.world((Entity)CompatibilityProvider.compatibility.clientPlayer())));
        if (syncPlayerEntityTrackerMessage.getStatusMessage() != null) {
            this.modContext.getStatusMessageCenter().addMessage(syncPlayerEntityTrackerMessage.getStatusMessage(), 1000L);
        }
    }
}
