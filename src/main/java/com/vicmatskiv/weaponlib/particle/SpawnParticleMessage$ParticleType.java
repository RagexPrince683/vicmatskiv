package com.vicmatskiv.weaponlib.particle;

public enum ParticleType
{
    BLOOD, 
    SHELL, 
    SMOKE_GRENADE_SMOKE;
    
    private static final /* synthetic */ ParticleType[] $VALUES;
    
    public static ParticleType[] values() {
        return ParticleType.$VALUES.clone();
    }
    
    public static ParticleType valueOf(final String name) {
        return Enum.valueOf(ParticleType.class, name);
    }
    
    static {
        $VALUES = new ParticleType[] { ParticleType.BLOOD, ParticleType.SHELL, ParticleType.SMOKE_GRENADE_SMOKE };
    }
}
