package com.vicmatskiv.weaponlib;

import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.util.*;
import java.io.*;
import java.awt.image.*;
import java.util.*;

public class WeaponResourcePack extends CompatibleResourcePack
{
    private static final String WEAPONLIB_RESOURCE_DOMAIN = "weaponlib";
    private static final Set<String> RESOURCE_DOMAINS;
    
    public WeaponResourcePack() {
        super();
    }
    
    public InputStream getInputStream(final ResourceLocation resourceLocation) throws IOException {
        final String resourcePath = this.modifyResourcePath(resourceLocation);
        return this.getClass().getResourceAsStream(resourcePath);
    }
    
    private String modifyResourcePath(final ResourceLocation resourceLocation) {
        String resourcePath = resourceLocation.getResourcePath();
        if (resourcePath.startsWith("textures")) {
            final int lastIndexOfSlash = resourcePath.lastIndexOf(47);
            if (lastIndexOfSlash >= 0) {
                final String fileName = resourcePath.substring(lastIndexOfSlash + 1);
                resourcePath = '/' + this.getClass().getPackage().getName().replace('.', '/') + "/resources/" + fileName;
            }
        }
        return resourcePath;
    }
    
    public boolean resourceExists(final ResourceLocation resourceLocation) {
        final String resourcePath = this.modifyResourcePath(resourceLocation);
        final boolean value = "weaponlib".equals(resourceLocation.getResourceDomain()) && this.getClass().getResource(resourcePath) != null;
        return value;
    }
    
    public Set<String> getCompatibleResourceDomains() {
        return WeaponResourcePack.RESOURCE_DOMAINS;
    }
    
    public BufferedImage getPackImage() throws IOException {
        return null;
    }
    
    public String getPackName() {
        return this.getClass().getSimpleName();
    }
    
    static {
        RESOURCE_DOMAINS = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(Collections.singleton("weaponlib")));
    }
}
