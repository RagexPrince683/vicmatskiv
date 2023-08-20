package com.vicmatskiv.weaponlib.tracking;

import java.util.function.*;
import java.util.*;
import java.lang.ref.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import io.netty.buffer.*;
import net.minecraft.world.*;
import org.apache.logging.log4j.*;

public class TrackableEntity
{
    private static final Logger logger;
    private Supplier<Entity> entitySupplier;
    private long startTimestamp;
    private UUID uuid;
    private int entityId;
    private long trackingDuration;
    private WeakReference<Entity> entityRef;
    private String displayName;
    
    private TrackableEntity() {
        super();
        this.displayName = "";
    }
    
    public TrackableEntity(final Entity entity, final long startTimestamp, final long trackingDuration) {
        super();
        this.displayName = "";
        this.uuid = entity.getPersistentID();
        this.entityId = entity.getEntityId();
        this.entitySupplier = (() -> entity2);
        this.startTimestamp = startTimestamp;
        this.trackingDuration = trackingDuration;
    }
    
    public UUID getUuid() {
        if (this.uuid != null) {
            return this.uuid;
        }
        final Entity entity = this.getEntity();
        return (entity != null) ? entity.getPersistentID() : null;
    }
    
    public void setEntitySupplier(final Supplier<Entity> entitySupplier) {
        this.entitySupplier = entitySupplier;
        this.entityId = -1;
        this.entityRef = null;
    }
    
    public Entity getEntity() {
        if (this.entityRef == null || this.entityRef.get() == null) {
            final Entity entity = this.entitySupplier.get();
            if (entity != null) {
                if (entity instanceof EntityPlayer) {
                    this.displayName = CompatibilityProvider.compatibility.getDisplayName((EntityPlayer)entity);
                }
                else if (entity instanceof EntityLivingBase) {
                    this.displayName = EntityList.getEntityString(entity);
                }
                this.entityId = entity.getEntityId();
            }
            this.entityRef = new WeakReference<Entity>(entity);
        }
        return this.entityRef.get();
    }
    
    public static TrackableEntity fromBuf(final ByteBuf buf, final World world) {
        final TrackableEntity te = new TrackableEntity();
        te.init(buf, world);
        return te;
    }
    
    public void init(final ByteBuf buf, final World world) {
        this.uuid = new UUID(buf.readLong(), buf.readLong());
        this.entityId = buf.readInt();
        this.startTimestamp = buf.readLong();
        this.trackingDuration = buf.readLong();
        if (world.isRemote) {
            TrackableEntity.logger.debug("Initializing client entity uuid {}, id {}", new Object[] { this.uuid, this.entityId });
            this.entitySupplier = (() -> world2.getEntityByID(this.entityId));
        }
        else {
            TrackableEntity.logger.debug("Initializing server entity uuid {}, id {}", new Object[] { this.uuid, this.entityId });
            this.entitySupplier = (() -> this.getEntityByUuid(this.uuid, world3));
        }
    }
    
    public void serialize(final ByteBuf buf, final World world) {
        buf.writeLong(this.uuid.getMostSignificantBits());
        buf.writeLong(this.uuid.getLeastSignificantBits());
        final Entity entity = this.getEntity();
        int entityId = -1;
        if (entity != null) {
            entityId = entity.getEntityId();
        }
        TrackableEntity.logger.debug("Serializing server entity uuid {}, id {}", new Object[] { this.uuid, entityId });
        buf.writeInt(entityId);
        buf.writeLong(this.startTimestamp);
        buf.writeLong(this.trackingDuration);
    }
    
    private Entity getEntityByUuid(final UUID uuid, final World world) {
        return (Entity)world.getLoadedEntityList().stream().filter(e -> e.equals(((Entity)e).getPersistentID())).findAny().orElse(null);
    }
    
    public boolean isExpired() {
        return this.startTimestamp + this.trackingDuration < System.currentTimeMillis();
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public long getTrackingDuration() {
        return this.trackingDuration;
    }
    
    public long getStartTimestamp() {
        return this.startTimestamp;
    }
    
    private static /* synthetic */ boolean lambda$getEntityByUuid$248(final Object e) {
        return e.equals(((Entity)e).getPersistentID());
    }
    
    private /* synthetic */ Entity lambda$init$247(final World world) {
        return this.getEntityByUuid(this.uuid, world);
    }
    
    private /* synthetic */ Entity lambda$init$246(final World world) {
        return world.getEntityByID(this.entityId);
    }
    
    private static /* synthetic */ Entity lambda$new$245(final Entity entity) {
        return entity;
    }
    
    static {
        logger = LogManager.getLogger((Class)TrackableEntity.class);
    }
}
