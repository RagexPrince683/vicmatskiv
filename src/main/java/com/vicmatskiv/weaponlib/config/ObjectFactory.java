package com.vicmatskiv.weaponlib.config;

import javax.xml.namespace.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _Configuration_QNAME;
    
    public ObjectFactory() {
        super();
    }
    
    public Configuration createConfiguration() {
        return new Configuration();
    }
    
    public Gun createGun() {
        return new Gun();
    }
    
    public Ore createOre() {
        return new Ore();
    }
    
    public Ores createOres() {
        return new Ores();
    }
    
    public Projectiles createProjectiles() {
        return new Projectiles();
    }
    
    public Explosions createExplosions() {
        return new Explosions();
    }
    
    public Gui createGui() {
        return new Gui();
    }
    
    @XmlElementDecl(namespace = "http://moderwarfaremod.org/config", name = "configuration")
    public JAXBElement<Configuration> createConfiguration(final Configuration value) {
        return new JAXBElement<Configuration>(ObjectFactory._Configuration_QNAME, Configuration.class, null, value);
    }
    
    static {
        _Configuration_QNAME = new QName("http://moderwarfaremod.org/config", "configuration");
    }
}
