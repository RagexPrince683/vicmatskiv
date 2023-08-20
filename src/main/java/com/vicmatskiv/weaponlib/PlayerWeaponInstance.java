package com.vicmatskiv.weaponlib;

import java.util.concurrent.*;
import net.minecraft.entity.player.*;
import io.netty.buffer.*;
import net.minecraft.item.*;
import java.util.*;
import com.vicmatskiv.weaponlib.perspective.*;
import com.vicmatskiv.weaponlib.state.*;
import org.apache.logging.log4j.*;
import com.vicmatskiv.weaponlib.network.*;

public class PlayerWeaponInstance extends PlayerItemInstance<WeaponState>
{
    private static final int SERIAL_VERSION = 7;
    private static final Logger logger;
    private int ammo;
    private float recoil;
    private int seriesShotCount;
    private long lastFireTimestamp;
    private boolean aimed;
    private int maxShots;
    private float zoom;
    private byte activeTextureIndex;
    private boolean laserOn;
    private Deque<AsyncWeaponState> filteredStateQueue;
    private int[] activeAttachmentIds;
    private byte[] selectedAttachmentIndexes;
    
    public PlayerWeaponInstance() {
        super();
        this.zoom = 1.0f;
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncWeaponState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    public PlayerWeaponInstance(final int itemInventoryIndex, final EntityPlayer player, final ItemStack itemStack) {
        super(itemInventoryIndex, player, itemStack);
        this.zoom = 1.0f;
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncWeaponState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    public PlayerWeaponInstance(final int itemInventoryIndex, final EntityPlayer player) {
        super(itemInventoryIndex, player);
        this.zoom = 1.0f;
        this.filteredStateQueue = new LinkedBlockingDeque<AsyncWeaponState>();
        this.activeAttachmentIds = new int[0];
        this.selectedAttachmentIndexes = new byte[0];
    }
    
    @Override
    protected int getSerialVersion() {
        return 7;
    }
    
    private void addStateToHistory(final WeaponState state) {
        AsyncWeaponState t;
        while ((t = this.filteredStateQueue.peekFirst()) != null && t.getState().getPriority() < state.getPriority()) {
            this.filteredStateQueue.pollFirst();
        }
        long expirationTimeout;
        if (state == WeaponState.FIRING || state == WeaponState.RECOILED || state == WeaponState.PAUSED) {
            if (this.isAutomaticModeEnabled() && !this.getWeapon().hasRecoilPositioning()) {
                expirationTimeout = (long)(50.0f / this.getFireRate());
            }
            else {
                expirationTimeout = 500L;
            }
            expirationTimeout = 500L;
        }
        else {
            expirationTimeout = 2147483647L;
        }
        this.filteredStateQueue.addFirst(new AsyncWeaponState(state, this.stateUpdateTimestamp, expirationTimeout));
    }
    
    @Override
    public boolean setState(final WeaponState state) {
        final boolean result = super.setState(state);
        this.addStateToHistory(state);
        return result;
    }
    
    public AsyncWeaponState nextHistoryState() {
        AsyncWeaponState result = this.filteredStateQueue.pollLast();
        if (result == null) {
            result = new AsyncWeaponState(this.getState(), this.stateUpdateTimestamp);
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
        this.aimed = buf.readBoolean();
        this.recoil = buf.readFloat();
        this.maxShots = buf.readInt();
        this.zoom = buf.readFloat();
        this.activeTextureIndex = buf.readByte();
        this.laserOn = buf.readBoolean();
    }
    
    @Override
    public void serialize(final ByteBuf buf) {
        super.serialize(buf);
        serializeIntArray(buf, this.activeAttachmentIds);
        serializeByteArray(buf, this.selectedAttachmentIndexes);
        buf.writeInt(this.ammo);
        buf.writeBoolean(this.aimed);
        buf.writeFloat(this.recoil);
        buf.writeInt(this.maxShots);
        buf.writeFloat(this.zoom);
        buf.writeByte((int)this.activeTextureIndex);
        buf.writeBoolean(this.laserOn);
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
    protected void updateWith(final PlayerItemInstance<WeaponState> otherItemInstance, final boolean updateManagedState) {
        super.updateWith(otherItemInstance, updateManagedState);
        final PlayerWeaponInstance otherWeaponInstance = (PlayerWeaponInstance)otherItemInstance;
        this.setAmmo(otherWeaponInstance.ammo);
        this.setZoom(otherWeaponInstance.zoom);
        this.setRecoil(otherWeaponInstance.recoil);
        this.setSelectedAttachmentIndexes(otherWeaponInstance.selectedAttachmentIndexes);
        this.setActiveAttachmentIds(otherWeaponInstance.activeAttachmentIds);
        this.setActiveTextureIndex(otherWeaponInstance.activeTextureIndex);
        this.setLaserOn(otherWeaponInstance.laserOn);
        this.setMaxShots(otherWeaponInstance.maxShots);
    }
    
    public Weapon getWeapon() {
        return (Weapon)this.item;
    }
    
    public float getRecoil() {
        return this.recoil;
    }
    
    public void setRecoil(final float recoil) {
        if (recoil != this.recoil) {
            this.recoil = recoil;
            ++this.updateId;
        }
    }
    
    public int getMaxShots() {
        return this.maxShots;
    }
    
    void setMaxShots(final int maxShots) {
        if (this.maxShots != maxShots) {
            this.maxShots = maxShots;
            ++this.updateId;
        }
    }
    
    public int getSeriesShotCount() {
        return this.seriesShotCount;
    }
    
    public void setSeriesShotCount(final int seriesShotCount) {
        this.seriesShotCount = seriesShotCount;
    }
    
    public long getLastFireTimestamp() {
        return this.lastFireTimestamp;
    }
    
    public void setLastFireTimestamp(final long lastFireTimestamp) {
        this.lastFireTimestamp = lastFireTimestamp;
    }
    
    public void resetCurrentSeries() {
        this.seriesShotCount = 0;
    }
    
    public float getFireRate() {
        return this.getWeapon().builder.fireRate;
    }
    
    public boolean isAutomaticModeEnabled() {
        return this.maxShots > 1;
    }
    
    public boolean isAimed() {
        return this.aimed;
    }
    
    public void setAimed(final boolean aimed) {
        if (aimed != this.aimed) {
            this.aimed = aimed;
            ++this.updateId;
        }
    }
    
    public int[] getActiveAttachmentIds() {
        if (this.activeAttachmentIds == null || this.activeAttachmentIds.length != AttachmentCategory.values.length) {
            this.activeAttachmentIds = new int[AttachmentCategory.values.length];
            for (final CompatibleAttachment<Weapon> attachment : this.getWeapon().getCompatibleAttachments().values()) {
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
    
    public boolean isAttachmentZoomEnabled() {
        final Item scopeItem = this.getAttachmentItemWithCategory(AttachmentCategory.SCOPE);
        return scopeItem instanceof ItemScope;
    }
    
    public ItemAttachment<Weapon> getAttachmentItemWithCategory(final AttachmentCategory category) {
        if (this.activeAttachmentIds == null || this.activeAttachmentIds.length <= category.ordinal()) {
            return null;
        }
        final Item activeAttachment = Item.getItemById(this.activeAttachmentIds[category.ordinal()]);
        if (activeAttachment instanceof ItemAttachment) {
            return (ItemAttachment)activeAttachment;
        }
        return null;
    }
    
    public float getZoom() {
        return this.zoom;
    }
    
    public void setZoom(final float zoom) {
        if (this.zoom != zoom) {
            this.zoom = zoom;
            ++this.updateId;
        }
    }
    
    public boolean isLaserOn() {
        return this.laserOn;
    }
    
    public void setLaserOn(final boolean laserOn) {
        if (this.laserOn != laserOn) {
            this.laserOn = laserOn;
            ++this.updateId;
        }
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
    public Class<? extends Perspective<?>> getRequiredPerspectiveType() {
        Class<? extends Perspective<?>> result = null;
        if (this.isAimed()) {
            final ItemAttachment<Weapon> scope = this.getAttachmentItemWithCategory(AttachmentCategory.SCOPE);
            if (scope instanceof ItemScope && ((ItemScope)scope).isOptical()) {
                result = OpticalScopePerspective.class;
            }
        }
        return result;
    }
    
    @Override
    public String toString() {
        return this.getWeapon().builder.name + "[" + this.getUuid() + "]";
    }
    
    @Override
    public /* bridge */ boolean setState(final ManagedState managedState) {
        return this.setState((WeaponState)managedState);
    }
    
    static {
        logger = LogManager.getLogger((Class)PlayerWeaponInstance.class);
        TypeRegistry.getInstance().register(PlayerWeaponInstance.class);
    }
}
