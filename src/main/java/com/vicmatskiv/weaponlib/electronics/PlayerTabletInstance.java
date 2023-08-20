package com.vicmatskiv.weaponlib.electronics;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.perspective.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.tracking.*;
import org.apache.logging.log4j.*;
import com.vicmatskiv.weaponlib.network.*;

public class PlayerTabletInstance extends PlayerItemInstance<TabletState>
{
    private static final int SERIAL_VERSION = 1;
    private static final Logger logger;
    private int activeWatchIndex;
    
    public PlayerTabletInstance() {
        super();
    }
    
    public PlayerTabletInstance(final int itemInventoryIndex, final EntityPlayer player, final ItemStack itemStack) {
        super(itemInventoryIndex, player, itemStack);
    }
    
    public PlayerTabletInstance(final int itemInventoryIndex, final EntityPlayer player) {
        super(itemInventoryIndex, player);
    }
    
    @Override
    public Class<? extends Perspective<?>> getRequiredPerspectiveType() {
        return WirelessCameraPerspective.class;
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        super.serialize(buf);
        buf.writeInt(this.activeWatchIndex);
    }
    
    public void setActiveWatchIndex(final int activeWatchIndex) {
        if (this.activeWatchIndex != activeWatchIndex) {
            PlayerTabletInstance.logger.debug("Changing active watch index to {}", new Object[] { activeWatchIndex });
            this.activeWatchIndex = activeWatchIndex;
            ++this.updateId;
        }
    }
    
    public int getActiveWatchIndex() {
        return this.activeWatchIndex;
    }
    
    @Override
    public void init(final ByteBuf buf) {
        super.init(buf);
        this.activeWatchIndex = buf.readInt();
    }
    
    @Override
    protected int getSerialVersion() {
        return 1;
    }
    
    public void nextActiveWatchIndex() {
        final PlayerEntityTracker tracker = PlayerEntityTracker.getTracker(this.player);
        if (tracker != null) {
            if (this.activeWatchIndex >= tracker.getTrackableEntitites().size() - 1) {
                this.setActiveWatchIndex(0);
            }
            else {
                this.setActiveWatchIndex(this.activeWatchIndex + 1);
            }
        }
    }
    
    public void previousActiveWatchIndex() {
        final PlayerEntityTracker tracker = PlayerEntityTracker.getTracker(this.player);
        if (tracker != null) {
            if (this.activeWatchIndex == 0) {
                this.setActiveWatchIndex(tracker.getTrackableEntitites().size() - 1);
            }
            else {
                this.setActiveWatchIndex(this.activeWatchIndex - 1);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Tablet [" + this.getUuid() + "]";
    }
    
    static {
        logger = LogManager.getLogger((Class)PlayerTabletInstance.class);
        TypeRegistry.getInstance().register(PlayerTabletInstance.class);
    }
}
