package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.client.resources.*;
import java.util.*;
import net.minecraft.client.resources.data.*;
import java.io.*;

public abstract class CompatibleResourcePack implements IResourcePack
{
    public CompatibleResourcePack() {
        super();
    }
    
    public final Set<?> getResourceDomains() {
        return this.getCompatibleResourceDomains();
    }
    
    protected abstract Set<String> getCompatibleResourceDomains();
    
    public IMetadataSection getPackMetadata(final IMetadataSerializer p_135058_1_, final String p_135058_2_) throws IOException {
        return null;
    }
}
