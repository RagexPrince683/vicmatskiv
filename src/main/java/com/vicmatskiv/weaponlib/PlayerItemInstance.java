package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.state.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import io.netty.buffer.*;
import com.vicmatskiv.weaponlib.network.*;
import com.vicmatskiv.weaponlib.perspective.*;
import org.apache.logging.log4j.*;

public class PlayerItemInstance<S extends ManagedState<S>> extends UniversalObject implements ExtendedState<S>, PlayerContext
{
    private static final Logger logger;
    protected S state;
    protected long stateUpdateTimestamp;
    protected long updateId;
    protected EntityPlayer player;
    protected Item item;
    protected int itemInventoryIndex;
    private PlayerItemInstance<S> preparedState;
    private long syncStartTimestamp;
    
    public PlayerItemInstance() {
        super();
        this.stateUpdateTimestamp = System.currentTimeMillis();
    }
    
    public PlayerItemInstance(final int itemInventoryIndex, final EntityPlayer player) {
        super();
        this.stateUpdateTimestamp = System.currentTimeMillis();
        this.itemInventoryIndex = itemInventoryIndex;
        this.player = player;
        final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)player);
        if (itemStack != null) {
            this.item = itemStack.getItem();
        }
    }
    
    public PlayerItemInstance(final int itemInventoryIndex, final EntityPlayer player, final ItemStack itemStack) {
        super();
        this.stateUpdateTimestamp = System.currentTimeMillis();
        this.itemInventoryIndex = itemInventoryIndex;
        this.player = player;
        if (itemStack != null) {
            this.item = itemStack.getItem();
        }
    }
    
    @Override
    public EntityPlayer getPlayer() {
        return this.player;
    }
    
    @Override
    public void setPlayer(final EntityPlayer player) {
        this.player = player;
    }
    
    public Item getItem() {
        return this.item;
    }
    
    public ItemStack getItemStack() {
        return CompatibilityProvider.compatibility.getInventoryItemStack(this.player, this.itemInventoryIndex);
    }
    
    public int getItemInventoryIndex() {
        return this.itemInventoryIndex;
    }
    
    protected void setItemInventoryIndex(final int itemInventoryIndex) {
        this.itemInventoryIndex = itemInventoryIndex;
    }
    
    protected <T extends PlayerItemInstance<S>> T getPreparedState() {
        return (T)this.preparedState;
    }
    
    @Override
    public void init(final ByteBuf buf) {
        super.init(buf);
        this.item = Item.getItemById(buf.readInt());
        this.itemInventoryIndex = buf.readInt();
        this.updateId = buf.readLong();
        this.state = TypeRegistry.getInstance().fromBytes(buf);
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        super.serialize(buf);
        buf.writeInt(Item.getIdFromItem(this.item));
        buf.writeInt(this.itemInventoryIndex);
        buf.writeLong(this.updateId);
        TypeRegistry.getInstance().toBytes(this.state, buf);
    }
    
    @Override
    public boolean setState(final S state) {
        this.state = state;
        this.stateUpdateTimestamp = System.currentTimeMillis();
        ++this.updateId;
        if (this.preparedState != null) {
            if (this.preparedState.getState().commitPhase() == state) {
                PlayerItemInstance.logger.debug("Committing state {} to {}", new Object[] { this.preparedState.getState(), ((ManagedState<Object>)this.preparedState.getState()).commitPhase() });
                this.updateWith(this.preparedState, false);
            }
            else {
                this.rollback();
            }
            this.preparedState = null;
        }
        return false;
    }
    
    protected void rollback() {
    }
    
    protected void updateWith(final PlayerItemInstance<S> otherState, final boolean updateManagedState) {
        if (updateManagedState) {
            this.setState(otherState.getState());
        }
    }
    
    @Override
    public S getState() {
        return this.state;
    }
    
    @Override
    public long getStateUpdateTimestamp() {
        return this.stateUpdateTimestamp;
    }
    
    public long getUpdateId() {
        return this.updateId;
    }
    
    void markDirty() {
        ++this.updateId;
    }
    
    @Override
    public <E extends ExtendedState<S>> void prepareTransaction(final E preparedExtendedState) {
        this.setState(preparedExtendedState.getState());
        this.preparedState = (PlayerItemInstance)preparedExtendedState;
    }
    
    public long getSyncStartTimestamp() {
        return this.syncStartTimestamp;
    }
    
    public void setSyncStartTimestamp(final long syncStartTimestamp) {
        this.syncStartTimestamp = syncStartTimestamp;
    }
    
    public Class<? extends Perspective<?>> getRequiredPerspectiveType() {
        return null;
    }
    
    static {
        logger = LogManager.getLogger((Class)PlayerItemInstance.class);
        TypeRegistry.getInstance().register(PlayerItemInstance.class);
        TypeRegistry.getInstance().register(PlayerWeaponInstance.class);
    }
}
