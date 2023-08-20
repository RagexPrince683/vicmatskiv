package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.util.*;

public class CompatibleSound
{
    public static final CompatibleSound SNOWBALL_THROW;
    private String sound;
    private ResourceLocation soundResourceLocation;
    
    public CompatibleSound(final ResourceLocation soundResourceLocation) {
        super();
        this.soundResourceLocation = soundResourceLocation;
        this.sound = soundResourceLocation.toString();
    }
    
    private CompatibleSound(final String sound) {
        super();
        this.sound = sound;
    }
    
    public String getSound() {
        return this.sound;
    }
    
    public ResourceLocation getResourceLocation() {
        return this.soundResourceLocation;
    }
    
    static {
        SNOWBALL_THROW = new CompatibleSound("random.bow");
    }
}
