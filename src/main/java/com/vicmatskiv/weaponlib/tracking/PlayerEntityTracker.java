package com.vicmatskiv.weaponlib.tracking;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import java.util.*;
import io.netty.buffer.*;
import org.apache.logging.log4j.*;

public class PlayerEntityTracker
{
    private static final Logger logger;
    private World world;
    private Map<UUID, TrackableEntity> trackableEntities;
    
    public static final PlayerEntityTracker getTracker(final EntityPlayer player) {
        return CompatiblePlayerEntityTrackerProvider.getTracker(player);
    }
    
    public PlayerEntityTracker(final World world) {
        super();
        this.trackableEntities = new LinkedHashMap<UUID, TrackableEntity>();
        this.world = world;
    }
    
    public PlayerEntityTracker() {
        super();
        this.trackableEntities = new LinkedHashMap<UUID, TrackableEntity>();
    }
    
    void init(final World world) {
        this.world = world;
    }
    
    public void addTrackableEntity(final TrackableEntity te) {
        this.update();
        this.trackableEntities.put(te.getEntity().getPersistentID(), te);
    }
    
    public boolean updateTrackableEntity(final Entity entity) {
        this.update();
        final TrackableEntity te = this.trackableEntities.get(entity.getPersistentID());
        if (te != null) {
            te.setEntitySupplier(() -> entity2);
            return true;
        }
        return false;
    }
    
    public Collection<TrackableEntity> getTrackableEntitites() {
        return Collections.unmodifiableCollection((Collection<? extends TrackableEntity>)this.trackableEntities.values());
    }
    
    public void update() {
        final Iterator<TrackableEntity> it = this.trackableEntities.values().iterator();
        while (it.hasNext()) {
            final TrackableEntity te = it.next();
            if (te.isExpired()) {
                it.remove();
            }
        }
    }
    
    public TrackableEntity getTrackableEntity(final int index) {
        final Collection<TrackableEntity> values = this.trackableEntities.values();
        int i = 0;
        TrackableEntity result = null;
        for (final TrackableEntity te : values) {
            if (i == index) {
                result = te;
                break;
            }
            ++i;
        }
        return result;
    }
    
    public void serialize(final ByteBuf buf) {
        this.update();
        buf.writeInt(this.trackableEntities.size());
        for (final TrackableEntity te : this.trackableEntities.values()) {
            te.serialize(buf, this.world);
        }
    }
    
    private void init(final ByteBuf buf) {
        for (int trackableEntitiesSize = buf.readInt(), i = 0; i < trackableEntitiesSize; ++i) {
            try {
                final TrackableEntity te = TrackableEntity.fromBuf(buf, this.world);
                this.trackableEntities.put(te.getUuid(), te);
            }
            catch (final RuntimeException e) {
                PlayerEntityTracker.logger.error("Failed to deserialize trackable entity {}", new Object[] { e.toString(), e });
            }
        }
    }
    
    public byte[] toByteArray() {
        final ByteBuf buf = Unpooled.buffer();
        this.serialize(buf);
        return buf.array();
    }
    
    public static PlayerEntityTracker fromByteArray(final byte[] bytes, final World world) {
        final ByteBuf buf = Unpooled.wrappedBuffer(bytes);
        final PlayerEntityTracker tracker = new PlayerEntityTracker(world);
        if (bytes != null && bytes.length > 0) {
            tracker.init(buf);
        }
        else {
            PlayerEntityTracker.logger.warn("Cannot deserialize tracker from empty byte array");
        }
        return tracker;
    }
    
    public static PlayerEntityTracker fromBuf(final ByteBuf buf, final World world) {
        final PlayerEntityTracker tracker = new PlayerEntityTracker(world);
        tracker.init(buf);
        return tracker;
    }
    
    private static /* synthetic */ Entity lambda$updateTrackableEntity$244(final Entity entity) {
        return entity;
    }
    
    static {
        logger = LogManager.getLogger((Class)PlayerEntityTracker.class);
    }
}
