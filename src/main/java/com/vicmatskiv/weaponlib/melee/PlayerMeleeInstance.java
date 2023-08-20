package com.vicmatskiv.weaponlib.melee;

import java.util.concurrent.*;
import net.minecraft.entity.player.*;
import io.netty.buffer.*;
import net.minecraft.item.*;
import java.util.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.state.*;
import org.apache.logging.log4j.*;
import com.vicmatskiv.weaponlib.network.*;

public class PlayerMeleeInstance extends PlayerItemInstance<MeleeState>
{
    private static final int SERIAL_VERSION = 7;
    private static final Logger logger;
    private int ammo;
    private long lastFireTimestamp;
    private byte activeTextureIndex;
    private Deque<AsyncMeleeState> filteredStateQueue;
    private int[] activeAttachmentIds;
    private byte[] selectedAttachmentIndexes;
    
    public PlayerMeleeInstance() {
        super();
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncMeleeState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    public PlayerMeleeInstance(final int itemInventoryIndex, final EntityPlayer player, final ItemStack itemStack) {
        super(itemInventoryIndex, player, itemStack);
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncMeleeState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    public PlayerMeleeInstance(final int itemInventoryIndex, final EntityPlayer player) {
        super(itemInventoryIndex, player);
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncMeleeState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    @Override
    protected int getSerialVersion() {
        return 7;
    }
    
    private void addStateToHistory(final MeleeState state) {
        AsyncMeleeState t;
        while ((t = this.filteredStateQueue.peekFirst()) != null && t.getState().getPriority() < state.getPriority()) {
            this.filteredStateQueue.pollFirst();
        }
        final long expirationTimeout = 500L;
        this.filteredStateQueue.addFirst(new AsyncMeleeState(state, this.stateUpdateTimestamp, expirationTimeout));
    }
    
    @Override
    public boolean setState(final MeleeState state) {
        final boolean result = super.setState(state);
        this.addStateToHistory(state);
        return result;
    }
    
    public AsyncMeleeState nextHistoryState() {
        AsyncMeleeState result = this.filteredStateQueue.pollLast();
        if (result == null) {
            result = new AsyncMeleeState(this.getState(), this.stateUpdateTimestamp);
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
        this.activeAttachmentIds = initIntArray(buf);
        this.selectedAttachmentIndexes = initByteArray(buf);
        this.ammo = buf.readInt();
        this.activeTextureIndex = buf.readByte();
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        super.serialize(buf);
        serializeIntArray(buf, this.activeAttachmentIds);
        serializeByteArray(buf, this.selectedAttachmentIndexes);
        buf.writeInt(this.ammo);
        buf.writeByte((int)this.activeTextureIndex);
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
    protected void updateWith(final PlayerItemInstance<MeleeState> otherItemInstance, final boolean updateManagedState) {
        super.updateWith(otherItemInstance, updateManagedState);
        final PlayerMeleeInstance otherWeaponInstance = (PlayerMeleeInstance)otherItemInstance;
        this.setAmmo(otherWeaponInstance.ammo);
        this.setSelectedAttachmentIndexes(otherWeaponInstance.selectedAttachmentIndexes);
        this.setActiveAttachmentIds(otherWeaponInstance.activeAttachmentIds);
        this.setActiveTextureIndex(otherWeaponInstance.activeTextureIndex);
    }
    
    public ItemMelee getWeapon() {
        return (ItemMelee)this.item;
    }
    
    public long getLastAttackTimestamp() {
        return this.lastFireTimestamp;
    }
    
    void setLastAttackTimestamp(final long lastFireTimestamp) {
        this.lastFireTimestamp = lastFireTimestamp;
    }
    
    public int[] getActiveAttachmentIds() {
        if (this.activeAttachmentIds == null || this.activeAttachmentIds.length != AttachmentCategory.values.length) {
            this.activeAttachmentIds = new int[AttachmentCategory.values.length];
            for (final CompatibleAttachment<ItemMelee> attachment : this.getWeapon().getCompatibleAttachments().values()) {
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
    
    public ItemAttachment<ItemMelee> getAttachmentItemWithCategory(final AttachmentCategory category) {
        if (this.activeAttachmentIds == null || this.activeAttachmentIds.length <= category.ordinal()) {
            return null;
        }
        final Item scopeItem = Item.getItemById(this.activeAttachmentIds[category.ordinal()]);
        return (ItemAttachment)scopeItem;
    }
    
    public int getActiveTextureIndex() {
        return this.activeTextureIndex;
    }
    
    public void setActiveTextureIndex(final int activeTextureIndex) {
        if (this.activeTextureIndex != activeTextureIndex) {
            if (activeTextureIndex > 127) {
                throw new IllegalArgumentException("activeTextureIndex must be less than 127");
            }
            this.activeTextureIndex = (byte)activeTextureIndex;
            ++this.updateId;
        }
    }
    
    @Override
    public String toString() {
        return this.getWeapon().builder.name + "[" + this.getUuid() + "]";
    }
    
    @Override
    public /* bridge */ boolean setState(final ManagedState managedState) {
        return this.setState((MeleeState)managedState);
    }
    
    static {
        logger = LogManager.getLogger((Class)PlayerMeleeInstance.class);
        TypeRegistry.getInstance().register(PlayerMeleeInstance.class);
    }
}
