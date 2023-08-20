package com.vicmatskiv.weaponlib.compatibility;

import net.minecraftforge.common.*;
import net.minecraft.world.*;
import com.vicmatskiv.weaponlib.tracking.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import io.netty.buffer.*;
import net.minecraft.nbt.*;
import org.apache.logging.log4j.*;
import java.util.function.*;

public class ExtendedPlayerProperties implements IExtendedEntityProperties
{
    private static final Logger logger;
    private static final String TAG_TRACKER = "tracker";
    private static final String EXTENDED_PROPERTY_NAME;
    private boolean initialized;
    private World world;
    private Container<PlayerEntityTracker, World> entityTrackerContainer;
    
    public static final ExtendedPlayerProperties getProperties(final EntityPlayer player) {
        if (player == null) {
            return null;
        }
        final ExtendedPlayerProperties properties = (ExtendedPlayerProperties)player.getExtendedProperties(ExtendedPlayerProperties.EXTENDED_PROPERTY_NAME);
        if (properties != null && !properties.initialized) {
            properties.init((Entity)player, CompatibilityProvider.compatibility.world((Entity)player));
        }
        return properties;
    }
    
    public static final void init(final EntityPlayer player) {
        final ExtendedPlayerProperties properties = new ExtendedPlayerProperties();
        properties.init((Entity)player, CompatibilityProvider.compatibility.world((Entity)player));
        player.registerExtendedProperties(ExtendedPlayerProperties.EXTENDED_PROPERTY_NAME, (IExtendedEntityProperties)properties);
    }
    
    public static final void set(final EntityPlayer player, final ExtendedPlayerProperties properties) {
        final ExtendedPlayerProperties existingProperties = getProperties(player);
        if (existingProperties != null) {
            existingProperties.copyFrom(properties);
        }
        else {
            player.registerExtendedProperties(ExtendedPlayerProperties.EXTENDED_PROPERTY_NAME, (IExtendedEntityProperties)properties);
        }
    }
    
    public static final ExtendedPlayerProperties fromBuf(final ByteBuf buf) {
        return new ExtendedPlayerProperties();
    }
    
    private void copyFrom(final ExtendedPlayerProperties properties) {
        this.entityTrackerContainer = properties.entityTrackerContainer;
    }
    
    ExtendedPlayerProperties() {
        super();
        this.entityTrackerContainer = new Container<PlayerEntityTracker, World>();
    }
    
    public void init(final Entity entity, final World world) {
        this.world = world;
        this.initialized = true;
        this.entityTrackerContainer.initializer = (Function<World, PlayerEntityTracker>)(w -> new PlayerEntityTracker(world2));
    }
    
    public void saveNBTData(final NBTTagCompound playerTagCompound) {
        if (!this.initialized) {
            return;
        }
        final NBTTagCompound tagCompound = new NBTTagCompound();
        final PlayerEntityTracker playerEntityTracker = this.entityTrackerContainer.get(this.world);
        if (playerEntityTracker != null) {
            tagCompound.setByteArray("tracker", playerEntityTracker.toByteArray());
        }
        playerTagCompound.setTag(ExtendedPlayerProperties.EXTENDED_PROPERTY_NAME, (NBTBase)tagCompound);
    }
    
    public void loadNBTData(final NBTTagCompound playerTagCompound) {
        final NBTTagCompound tagCompound = playerTagCompound.getCompoundTag(ExtendedPlayerProperties.EXTENDED_PROPERTY_NAME);
        if (tagCompound != null) {
            final byte[] bytes = tagCompound.getByteArray("tracker");
            if (bytes != null) {
                this.entityTrackerContainer.initializer = (Function<World, PlayerEntityTracker>)(w -> PlayerEntityTracker.fromByteArray(bytes2, w));
            }
        }
    }
    
    public PlayerEntityTracker getTracker() {
        if (!this.initialized) {
            return null;
        }
        return this.entityTrackerContainer.get(this.world);
    }
    
    public void serialize(final ByteBuf buf) {
        if (!this.initialized) {
            return;
        }
        final PlayerEntityTracker et = this.entityTrackerContainer.get(this.world);
        if (et != null) {
            et.serialize(buf);
        }
    }
    
    public void setTracker(final PlayerEntityTracker tracker) {
        this.entityTrackerContainer = new Container<PlayerEntityTracker, World>(w -> playerEntityTracker);
    }
    
    private static /* synthetic */ PlayerEntityTracker lambda$setTracker$263(final PlayerEntityTracker playerEntityTracker, final World w) {
        return playerEntityTracker;
    }
    
    private static /* synthetic */ PlayerEntityTracker lambda$loadNBTData$262(final byte[] bytes, final World w) {
        return PlayerEntityTracker.fromByteArray(bytes, w);
    }
    
    private static /* synthetic */ PlayerEntityTracker lambda$init$261(final World world, final World w) {
        return new PlayerEntityTracker(world);
    }
    
    static {
        logger = LogManager.getLogger((Class)ExtendedPlayerProperties.class);
        EXTENDED_PROPERTY_NAME = ExtendedPlayerProperties.class.getName();
    }
    
    private static class Container<T, I>
    {
        Function<I, T> initializer;
        T resolved;
        
        Container() {
            super();
        }
        
        Container(final Function<I, T> initializer) {
            super();
            this.initializer = initializer;
        }
        
        public T get(final I i) {
            if (this.initializer == null) {
                return null;
            }
            if (this.resolved == null) {
                this.resolved = this.initializer.apply(i);
            }
            return this.resolved;
        }
    }
}
