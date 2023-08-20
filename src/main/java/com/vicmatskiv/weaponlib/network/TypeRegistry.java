package com.vicmatskiv.weaponlib.network;

import java.util.*;
import java.util.concurrent.*;
import java.security.*;
import io.netty.buffer.*;

public class TypeRegistry
{
    private static final String SHA1PRNG_ALG = "SHA1PRNG";
    private ConcurrentMap<UUID, Class<? extends UniversallySerializable>> typeRegistry;
    private static final TypeRegistry instance;
    
    public static TypeRegistry getInstance() {
        return TypeRegistry.instance;
    }
    
    private TypeRegistry() {
        super();
        this.typeRegistry = new ConcurrentHashMap<UUID, Class<? extends UniversallySerializable>>();
    }
    
    public <T extends UniversallySerializable> void register(final Class<T> cls) {
        this.typeRegistry.put(this.createUuid(cls), cls);
    }
    
    protected UUID createUuid(final Class<?> cls) {
        try {
            final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(cls.getName().getBytes());
            return new UUID(random.nextLong(), random.nextLong());
        }
        catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
            return UUID.fromString(this.getClass().getName());
        }
    }
    
    public <T extends UniversallySerializable> void toBytes(final T object, final ByteBuf buf) {
        final UUID typeUuid = this.createUuid(object.getClass());
        if (!this.typeRegistry.containsKey(typeUuid)) {
            throw new RuntimeException("Failed to serialize object " + object + " because its class is not registered: " + object.getClass());
        }
        buf.writeLong(typeUuid.getMostSignificantBits());
        buf.writeLong(typeUuid.getLeastSignificantBits());
        if (object.getClass().isEnum()) {
            buf.writeInt(((Enum)object).ordinal());
        }
        else {
            object.serialize(buf);
        }
    }
    
    public <T extends UniversallySerializable> T fromBytes(final ByteBuf buf) {
        final long mostSigBits = buf.readLong();
        final long leastSigBits = buf.readLong();
        final UUID typeUuid = new UUID(mostSigBits, leastSigBits);
        final Class<T> targetClass = (Class<T>)this.typeRegistry.get(typeUuid);
        if (targetClass == null) {
            throw new RuntimeException("Failed to deserailize object. Did you forget to register type?");
        }
        T instance;
        if (targetClass.isEnum()) {
            final T[] constants = targetClass.getEnumConstants();
            instance = constants[buf.readInt()];
        }
        else {
            try {
                instance = targetClass.newInstance();
            }
            catch (final InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot create instance of  " + targetClass);
            }
            instance.init(buf);
        }
        return targetClass.cast(instance);
    }
    
    static {
        instance = new TypeRegistry();
    }
}
