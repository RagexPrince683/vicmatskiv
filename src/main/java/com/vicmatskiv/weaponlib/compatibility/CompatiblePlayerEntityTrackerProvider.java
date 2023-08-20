package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.entity.player.*;
import com.vicmatskiv.weaponlib.tracking.*;
import com.vicmatskiv.weaponlib.*;

public class CompatiblePlayerEntityTrackerProvider
{
    public CompatiblePlayerEntityTrackerProvider() {
        super();
    }
    
    public static PlayerEntityTracker getTracker(final EntityPlayer player) {
        final ExtendedPlayerProperties extendedProperties = ExtendedPlayerProperties.getProperties(player);
        PlayerEntityTracker tracker = null;
        if (extendedProperties != null) {
            tracker = extendedProperties.getTracker();
        }
        return tracker;
    }
    
    public static void setTracker(final EntityPlayer clientPlayer, final PlayerEntityTracker tracker) {
        final ExtendedPlayerProperties properties = ExtendedPlayerProperties.getProperties(CompatibilityProvider.compatibility.clientPlayer());
        properties.setTracker(tracker);
    }
    
    public static void register(final ModContext commonModContext) {
    }
}
