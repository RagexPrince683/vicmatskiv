package com.vicmatskiv.weaponlib.compatibility;

public final class CompatibilityProvider
{
    public static Compatibility compatibility;
    
    public CompatibilityProvider() {
        super();
    }
    
    private static Compatibility initCompatibility() {
        final String compatibilityClassName = Compatibility.class.getName() + "1_7_10";
        try {
            return (Compatibility)Class.forName(compatibilityClassName).newInstance();
        }
        catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find compatible implementation class " + compatibilityClassName);
        }
    }
    
    static {
        CompatibilityProvider.compatibility = initCompatibility();
    }
}
