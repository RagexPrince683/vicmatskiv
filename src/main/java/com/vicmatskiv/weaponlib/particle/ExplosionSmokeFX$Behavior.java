package com.vicmatskiv.weaponlib.particle;

public enum Behavior
{
    EXPLOSION((TriFunction<Float, Integer, Integer, Float>)ExplosionSmokeFX.access$000(), (TriFunction<Float, Integer, Integer, Float>)ExplosionSmokeFX.access$100()), 
    SMOKE_GRENADE((TriFunction<Float, Integer, Integer, Float>)ExplosionSmokeFX.access$200(), (TriFunction<Float, Integer, Integer, Float>)ExplosionSmokeFX.access$300());
    
    private TriFunction<Float, Integer, Integer, Float> scaleUpdateFunction;
    private TriFunction<Float, Integer, Integer, Float> alphaUpdateFunction;
    private static final /* synthetic */ Behavior[] $VALUES;
    
    public static Behavior[] values() {
        return Behavior.$VALUES.clone();
    }
    
    public static Behavior valueOf(final String name) {
        return Enum.valueOf(Behavior.class, name);
    }
    
    private Behavior(final TriFunction<Float, Integer, Integer, Float> scaleUpdateFunction, final TriFunction<Float, Integer, Integer, Float> alphaUpdateFunction) {
        this.scaleUpdateFunction = scaleUpdateFunction;
        this.alphaUpdateFunction = alphaUpdateFunction;
    }
    
    static /* synthetic */ TriFunction access$400(final Behavior x0) {
        return x0.alphaUpdateFunction;
    }
    
    static /* synthetic */ TriFunction access$500(final Behavior x0) {
        return x0.scaleUpdateFunction;
    }
    
    static {
        $VALUES = new Behavior[] { Behavior.EXPLOSION, Behavior.SMOKE_GRENADE };
    }
}
