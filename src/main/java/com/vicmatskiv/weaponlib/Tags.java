package com.vicmatskiv.weaponlib;

import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.network.*;
import io.netty.buffer.*;

public final class Tags
{
    private static final String AMMO_TAG = "Ammo";
    private static final String DEFAULT_TIMER_TAG = "DefaultTimer";
    private static final String INSTANCE_TAG = "Instance";
    
    public Tags() {
        super();
    }
    
    static int getAmmo(final ItemStack itemStack) {
        if (itemStack == null || CompatibilityProvider.compatibility.getTagCompound(itemStack) == null) {
            return 0;
        }
        return CompatibilityProvider.compatibility.getTagCompound(itemStack).getInteger("Ammo");
    }
    
    static void setAmmo(final ItemStack itemStack, final int ammo) {
        if (itemStack == null) {
            return;
        }
        CompatibilityProvider.compatibility.ensureTagCompound(itemStack);
        CompatibilityProvider.compatibility.getTagCompound(itemStack).setInteger("Ammo", ammo);
    }
    
    public static long getDefaultTimer(final ItemStack itemStack) {
        if (itemStack == null || CompatibilityProvider.compatibility.getTagCompound(itemStack) == null) {
            return 0L;
        }
        return CompatibilityProvider.compatibility.getTagCompound(itemStack).getLong("DefaultTimer");
    }
    
    static void setDefaultTimer(final ItemStack itemStack, final long ammo) {
        if (itemStack == null || CompatibilityProvider.compatibility.getTagCompound(itemStack) == null) {
            return;
        }
        CompatibilityProvider.compatibility.getTagCompound(itemStack).setLong("DefaultTimer", ammo);
    }
    
    public static PlayerItemInstance<?> getInstance(final ItemStack itemStack) {
        if (itemStack == null || CompatibilityProvider.compatibility.getTagCompound(itemStack) == null) {
            return null;
        }
        final byte[] bytes = CompatibilityProvider.compatibility.getTagCompound(itemStack).getByteArray("Instance");
        if (bytes != null && bytes.length > 0) {
            return TypeRegistry.getInstance().fromBytes(Unpooled.wrappedBuffer(bytes));
        }
        return null;
    }
    
    public static <T extends PlayerItemInstance<?>> T getInstance(final ItemStack itemStack, final Class<T> targetClass) {
        if (itemStack == null || CompatibilityProvider.compatibility.getTagCompound(itemStack) == null) {
            return null;
        }
        final byte[] bytes = CompatibilityProvider.compatibility.getTagCompound(itemStack).getByteArray("Instance");
        if (bytes != null && bytes.length > 0) {
            try {
                return targetClass.cast(TypeRegistry.getInstance().fromBytes(Unpooled.wrappedBuffer(bytes)));
            }
            catch (final RuntimeException e) {
                return null;
            }
        }
        return null;
    }
    
    static void setInstance(final ItemStack itemStack, final PlayerItemInstance<?> instance) {
        if (itemStack == null) {
            return;
        }
        CompatibilityProvider.compatibility.ensureTagCompound(itemStack);
        final ByteBuf buf = Unpooled.buffer();
        if (instance != null) {
            TypeRegistry.getInstance().toBytes(instance, buf);
            CompatibilityProvider.compatibility.getTagCompound(itemStack).setByteArray("Instance", buf.array());
        }
        else {
            CompatibilityProvider.compatibility.getTagCompound(itemStack).removeTag("Instance");
        }
    }
    
    public static byte[] getInstanceBytes(final ItemStack itemStack) {
        if (itemStack == null || CompatibilityProvider.compatibility.getTagCompound(itemStack) == null) {
            return null;
        }
        return CompatibilityProvider.compatibility.getTagCompound(itemStack).getByteArray("Instance");
    }
}
