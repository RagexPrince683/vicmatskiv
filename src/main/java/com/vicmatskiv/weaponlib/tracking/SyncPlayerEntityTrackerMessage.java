package com.vicmatskiv.weaponlib.tracking;

import com.vicmatskiv.weaponlib.compatibility.*;
import java.util.function.*;
import net.minecraft.world.*;
import io.netty.buffer.*;
import org.apache.logging.log4j.*;

public class SyncPlayerEntityTrackerMessage implements CompatibleMessage
{
    private static final Logger logger;
    private Function<World, PlayerEntityTracker> playerEntityTracker;
    private String statusMessage;
    
    public SyncPlayerEntityTrackerMessage() {
        super();
    }
    
    public SyncPlayerEntityTrackerMessage(final PlayerEntityTracker playerEntityTracker) {
        this(playerEntityTracker, null);
    }
    
    public SyncPlayerEntityTrackerMessage(final PlayerEntityTracker playerEntityTracker, final String statusMessage) {
        super();
        this.playerEntityTracker = (Function<World, PlayerEntityTracker>)(a -> playerEntityTracker2);
        this.statusMessage = statusMessage;
    }
    
    public void fromBytes(final ByteBuf buf) {
        try {
            final int statusMessageBytesLength = buf.readInt();
            if (statusMessageBytesLength > 0) {
                final byte[] bytes = new byte[statusMessageBytesLength];
                buf.readBytes(bytes);
                this.statusMessage = new String(bytes);
            }
            this.playerEntityTracker = (Function<World, PlayerEntityTracker>)(w -> PlayerEntityTracker.fromBuf(buf2, w));
        }
        catch (final Exception e) {
            SyncPlayerEntityTrackerMessage.logger.error("Failed to deserialize tracker {}", (Throwable)e);
        }
    }
    
    public void toBytes(final ByteBuf buf) {
        final byte[] statusMessageBytes = (this.statusMessage != null) ? this.statusMessage.getBytes() : new byte[0];
        buf.writeInt(statusMessageBytes.length);
        if (statusMessageBytes.length > 0) {
            buf.writeBytes(statusMessageBytes);
        }
        this.playerEntityTracker.apply(null).serialize(buf);
    }
    
    public Function<World, PlayerEntityTracker> getTracker() {
        return this.playerEntityTracker;
    }
    
    public String getStatusMessage() {
        return this.statusMessage;
    }
    
    private static /* synthetic */ PlayerEntityTracker lambda$fromBytes$282(final ByteBuf buf, final World w) {
        return PlayerEntityTracker.fromBuf(buf, w);
    }
    
    private static /* synthetic */ PlayerEntityTracker lambda$new$281(final PlayerEntityTracker playerEntityTracker, final World a) {
        return playerEntityTracker;
    }
    
    static {
        logger = LogManager.getLogger((Class)SyncPlayerEntityTrackerMessage.class);
    }
}
