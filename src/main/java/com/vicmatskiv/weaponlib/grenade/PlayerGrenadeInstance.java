package com.vicmatskiv.weaponlib.grenade;

import java.util.concurrent.*;
import net.minecraft.entity.player.*;
import io.netty.buffer.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;
import com.vicmatskiv.weaponlib.state.*;
import org.apache.logging.log4j.*;
import com.vicmatskiv.weaponlib.network.*;

public class PlayerGrenadeInstance extends PlayerItemInstance<GrenadeState>
{
    private static final int SERIAL_VERSION = 11;
    private static final Logger logger;
    private int ammo;
    private long activationTimestamp;
    private Deque<AsyncGrenadeState> filteredStateQueue;
    private int[] activeAttachmentIds;
    private byte[] selectedAttachmentIndexes;
    private long lastSafetyPinAlertTimestamp;
    private boolean throwingFar;
    
    public PlayerGrenadeInstance() {
        super();
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncGrenadeState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    public PlayerGrenadeInstance(final int itemInventoryIndex, final EntityPlayer player, final ItemStack itemStack) {
        super(itemInventoryIndex, player, itemStack);
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncGrenadeState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    public PlayerGrenadeInstance(final int itemInventoryIndex, final EntityPlayer player) {
        super(itemInventoryIndex, player);
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncGrenadeState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    @Override
    protected int getSerialVersion() {
        return 11;
    }
    
    private void addStateToHistory(final GrenadeState state) {
        AsyncGrenadeState t;
        while ((t = this.filteredStateQueue.peekFirst()) != null && t.getState().getPriority() < state.getPriority()) {
            this.filteredStateQueue.pollFirst();
        }
        final long expirationTimeout = 500L;
        this.filteredStateQueue.addFirst(new AsyncGrenadeState(state, this.stateUpdateTimestamp, expirationTimeout));
    }
    
    @Override
    public boolean setState(final GrenadeState state) {
        final boolean result = super.setState(state);
        this.addStateToHistory(state);
        return result;
    }
    
    public AsyncGrenadeState nextHistoryState() {
        AsyncGrenadeState result = this.filteredStateQueue.pollLast();
        if (result == null) {
            result = new AsyncGrenadeState(this.getState(), this.stateUpdateTimestamp);
        }
        return result;
    }
    
    public int getAmmo() {
        return this.ammo;
    }
    
    protected void setAmmo(final int ammo) {
        if (ammo != this.ammo) {
            this.ammo = ammo;
            ++this.updateId;
        }
    }
    
    @Override
    public void init(final ByteBuf buf) {
        super.init(buf);
        this.throwingFar = buf.readBoolean();
        this.activeAttachmentIds = initIntArray(buf);
        this.selectedAttachmentIndexes = initByteArray(buf);
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        super.serialize(buf);
        buf.writeBoolean(this.throwingFar);
        serializeIntArray(buf, this.activeAttachmentIds);
        serializeByteArray(buf, this.selectedAttachmentIndexes);
    }
    
    private static void serializeIntArray(final ByteBuf buf, final int[] a) {
        buf.writeByte(a.length);
        for (int i = 0; i < a.length; ++i) {
            buf.writeInt(a[i]);
        }
    }
    
    private static void serializeByteArray(final ByteBuf buf, final byte[] a) {
        buf.writeByte(a.length);
        for (int i = 0; i < a.length; ++i) {
            buf.writeByte((int)a[i]);
        }
    }
    
    private static int[] initIntArray(final ByteBuf buf) {
        final int length = buf.readByte();
        final int[] a = new int[length];
        for (int i = 0; i < length; ++i) {
            a[i] = buf.readInt();
        }
        return a;
    }
    
    private static byte[] initByteArray(final ByteBuf buf) {
        final int length = buf.readByte();
        final byte[] a = new byte[length];
        for (int i = 0; i < length; ++i) {
            a[i] = buf.readByte();
        }
        return a;
    }
    
    @Override
    protected void updateWith(final PlayerItemInstance<GrenadeState> otherItemInstance, final boolean updateManagedState) {
        super.updateWith(otherItemInstance, updateManagedState);
        final PlayerGrenadeInstance otherWeaponInstance = (PlayerGrenadeInstance)otherItemInstance;
        this.setAmmo(otherWeaponInstance.ammo);
        this.setSelectedAttachmentIndexes(otherWeaponInstance.selectedAttachmentIndexes);
        this.setActiveAttachmentIds(otherWeaponInstance.activeAttachmentIds);
    }
    
    public ItemGrenade getWeapon() {
        return (ItemGrenade)this.item;
    }
    
    public long getActivationTimestamp() {
        return this.activationTimestamp;
    }
    
    void setActivationTimestamp(final long activationTimestamp) {
        this.activationTimestamp = activationTimestamp;
    }
    
    public int[] getActiveAttachmentIds() {
        if (this.activeAttachmentIds == null || this.activeAttachmentIds.length != AttachmentCategory.values.length) {
            this.activeAttachmentIds = new int[AttachmentCategory.values.length];
            for (final CompatibleAttachment<ItemGrenade> attachment : this.getWeapon().getCompatibleAttachments().values()) {
                if (attachment.isDefault()) {
                    this.activeAttachmentIds[attachment.getAttachment().getCategory().ordinal()] = Item.getIdFromItem((Item)attachment.getAttachment());
                }
            }
        }
        return this.activeAttachmentIds;
    }
    
    void setActiveAttachmentIds(final int[] activeAttachmentIds) {
        if (!Arrays.equals(this.activeAttachmentIds, activeAttachmentIds)) {
            this.activeAttachmentIds = activeAttachmentIds;
            ++this.updateId;
        }
    }
    
    public byte[] getSelectedAttachmentIds() {
        return this.selectedAttachmentIndexes;
    }
    
    void setSelectedAttachmentIndexes(final byte[] selectedAttachmentIndexes) {
        if (!Arrays.equals(this.selectedAttachmentIndexes, selectedAttachmentIndexes)) {
            this.selectedAttachmentIndexes = selectedAttachmentIndexes;
            ++this.updateId;
        }
    }
    
    public ItemAttachment<ItemGrenade> getAttachmentItemWithCategory(final AttachmentCategory category) {
        if (this.activeAttachmentIds == null || this.activeAttachmentIds.length <= category.ordinal()) {
            return null;
        }
        final Item scopeItem = Item.getItemById(this.activeAttachmentIds[category.ordinal()]);
        return (ItemAttachment)scopeItem;
    }
    
    public List<CompatibleAttachment<? extends AttachmentContainer>> getActiveAttachments(final RenderContext<RenderableState> renderContext, final boolean attached) {
        final int[] activeIds = this.getActiveAttachmentIds();
        final List<CompatibleAttachment<? extends AttachmentContainer>> result = new ArrayList<CompatibleAttachment<? extends AttachmentContainer>>();
        for (int i = 0; i < activeIds.length; ++i) {
            if (activeIds[i] != 0) {
                final Item item = Item.getItemById(activeIds[i]);
                if (item instanceof ItemAttachment) {
                    final CompatibleAttachment<? extends AttachmentContainer> compatibleAttachment = this.getWeapon().getCompatibleAttachments().get(item);
                    if (compatibleAttachment != null) {
                        result.add(compatibleAttachment);
                    }
                }
            }
        }
        return result;
    }
    
    @Override
    public String toString() {
        return this.getWeapon().builder.name + "[" + this.getUuid() + "]";
    }
    
    public long getLastSafetyPinAlertTimestamp() {
        return this.lastSafetyPinAlertTimestamp;
    }
    
    public void setLastSafetyPinAlertTimestamp(final long lastSafetyPinAlertTimestamp) {
        this.lastSafetyPinAlertTimestamp = lastSafetyPinAlertTimestamp;
    }
    
    public void setThrowingFar(final boolean throwingFar) {
        this.throwingFar = throwingFar;
    }
    
    public boolean isThrowingFar() {
        return this.throwingFar;
    }
    
    @Override
    public /* bridge */ boolean setState(final ManagedState managedState) {
        return this.setState((GrenadeState)managedState);
    }
    
    static {
        logger = LogManager.getLogger((Class)PlayerGrenadeInstance.class);
        TypeRegistry.getInstance().register(PlayerGrenadeInstance.class);
    }
}
