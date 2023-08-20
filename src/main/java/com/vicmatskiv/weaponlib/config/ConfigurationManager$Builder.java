package com.vicmatskiv.weaponlib.config;

import javax.xml.transform.*;
import java.io.*;
import java.util.function.*;
import javax.xml.transform.stream.*;
import javax.xml.bind.*;
import java.util.*;

public static final class Builder
{
    private Map<String, Gun> guns;
    private Source defaultConfigSource;
    private Source userConfigSource;
    private File userConfigFile;
    private StatusBarPosition statusBarPosition;
    private Predicate<Ore> oreValidator;
    private Predicate<Explosions> explosionsValidator;
    private Configuration userConfig;
    
    public Builder() {
        super();
        this.guns = new LinkedHashMap<String, Gun>();
        this.statusBarPosition = StatusBarPosition.TOP_RIGHT;
        this.oreValidator = ConfigurationManager.access$000();
        this.explosionsValidator = ConfigurationManager.access$100();
    }
    
    public Builder withDefaultConfiguration(final Source defaultConfigSource) {
        this.defaultConfigSource = defaultConfigSource;
        return this;
    }
    
    Builder withUserConfiguration(final Source userConfigSource) {
        this.userConfigSource = userConfigSource;
        return this;
    }
    
    public Builder withUserConfiguration(final File userConfigFile) {
        this.userConfigFile = userConfigFile;
        this.userConfigSource = new StreamSource(userConfigFile);
        return this;
    }
    
    public Builder withOreValidator(final Predicate<Ore> oreValidator) {
        this.oreValidator = oreValidator;
        return this;
    }
    
    public Builder withExplosionsValidator(final Predicate<Explosions> explosionsValidator) {
        this.explosionsValidator = explosionsValidator;
        return this;
    }
    
    public ConfigurationManager build() {
        final Configuration defaultUpdatableConfig = createConfiguration(this.defaultConfigSource);
        this.userConfig = createConfiguration(this.userConfigSource);
        return new ConfigurationManager(this.merge(this.userConfig, defaultUpdatableConfig), this.userConfigFile, this);
    }
    
    static Configuration createConfiguration(final Source source) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            final JAXBElement<Configuration> configElement = jaxbUnmarshaller.unmarshal(source, Configuration.class);
            return configElement.getValue();
        }
        catch (final JAXBException e) {
            ConfigurationManager.access$200().error("Failed to parse configuration: " + e, (Throwable)e);
            return null;
        }
    }
    
    private Configuration merge(final Configuration userConfig, final Configuration defaultUpdatableConfig) {
        if (userConfig == null) {
            return defaultUpdatableConfig;
        }
        this.mergeOres(userConfig, defaultUpdatableConfig);
        this.mergeExplosions(userConfig, defaultUpdatableConfig);
        this.mergeProjectiles(userConfig, defaultUpdatableConfig);
        this.mergeGui(userConfig, defaultUpdatableConfig);
        return defaultUpdatableConfig;
    }
    
    private void mergeExplosions(final Configuration userConfig, final Configuration defaultUpdatableConfig) {
        if (this.explosionsValidator.test(userConfig.getExplosions())) {
            Float userDamageCoefficient = userConfig.getExplosions().getDamage();
            if (userDamageCoefficient == null) {
                userDamageCoefficient = defaultUpdatableConfig.getExplosions().getDamage();
            }
            else if (userDamageCoefficient < 0.2f) {
                userDamageCoefficient = 0.2f;
            }
            else if (userDamageCoefficient > 2.0f) {
                userDamageCoefficient = 2.0f;
            }
            defaultUpdatableConfig.getExplosions().setDamage(userDamageCoefficient);
            Float userDropBlockChance = userConfig.getExplosions().getDropBlockChance();
            if (userDropBlockChance == null) {
                userDropBlockChance = defaultUpdatableConfig.getExplosions().getDropBlockChance();
            }
            else if (userDropBlockChance < 0.0f) {
                userDropBlockChance = 0.0f;
            }
            else if (userDropBlockChance > 5.0f) {
                userDropBlockChance = 5.0f;
            }
            defaultUpdatableConfig.getExplosions().setDropBlockChance(userDropBlockChance);
        }
    }
    
    private void mergeProjectiles(final Configuration userConfig, final Configuration defaultUpdatableConfig) {
        if (defaultUpdatableConfig.getProjectiles() != null) {
            final Gun gun;
            defaultUpdatableConfig.getProjectiles().getGun().stream().filter(gun -> gun.getId() != null).forEach(gun -> this.guns.put(gun.getId(), gun));
        }
        if (userConfig != null && userConfig.getProjectiles() != null) {
            Float bleedingOnHit = userConfig.getProjectiles().getBleedingOnHit();
            if (bleedingOnHit != null) {
                if (bleedingOnHit < 0.0f) {
                    bleedingOnHit = 0.0f;
                }
                else if (bleedingOnHit > 1.0f) {
                    bleedingOnHit = 1.0f;
                }
                defaultUpdatableConfig.getProjectiles().setBleedingOnHit(bleedingOnHit);
            }
            if (userConfig.getProjectiles().isDestroyGlassBlocks() != null) {
                defaultUpdatableConfig.getProjectiles().setDestroyGlassBlocks(userConfig.getProjectiles().isDestroyGlassBlocks());
            }
            if (userConfig.getProjectiles().isKnockbackOnHit() != null) {
                defaultUpdatableConfig.getProjectiles().setKnockbackOnHit(userConfig.getProjectiles().isKnockbackOnHit());
            }
            if (userConfig.getProjectiles().isMuzzleEffects() != null) {
                defaultUpdatableConfig.getProjectiles().setMuzzleEffects(userConfig.getProjectiles().isMuzzleEffects());
            }
            for (final Gun gun : userConfig.getProjectiles().getGun()) {
                if (gun.getId() != null) {
                    this.guns.put(gun.getId(), gun);
                }
            }
        }
        if (defaultUpdatableConfig.getProjectiles() != null) {
            defaultUpdatableConfig.getProjectiles().getGun().clear();
            defaultUpdatableConfig.getProjectiles().getGun().addAll(this.guns.values());
        }
    }
    
    private void mergeOres(final Configuration userConfiguration, final Configuration updatableDefaults) {
        if (userConfiguration.getOres() != null) {
            updatableDefaults.getOres().getOre().forEach(updatableDefaultOre -> configuration.getOres().getOre().stream().filter(o -> ore.getName().equalsIgnoreCase(o.getName())).findFirst().ifPresent(userOre -> this.mergeOre(userOre, updatableDefaultOre)));
        }
    }
    
    private void mergeOre(final Ore userOre, final Ore updatableDefaultOre) {
        if (this.oreValidator.test(userOre)) {
            updatableDefaultOre.spawnsPerChunk = userOre.spawnsPerChunk;
        }
    }
    
    private void mergeGui(final Configuration userConfig, final Configuration defaultUpdatableConfig) {
        if (userConfig.getGui() != null && userConfig.getGui().getStatusBarPosition() != null) {
            try {
                final String positionValue = userConfig.getGui().getStatusBarPosition().toUpperCase().replaceAll("[\\.\\-\\s]+", "_");
                this.statusBarPosition = StatusBarPosition.valueOf(positionValue);
            }
            catch (final IllegalArgumentException ex) {}
        }
        if (this.statusBarPosition == null) {
            this.statusBarPosition = StatusBarPosition.TOP_RIGHT;
        }
        if (defaultUpdatableConfig.getGui() == null) {
            defaultUpdatableConfig.setGui(new Gui());
        }
        defaultUpdatableConfig.getGui().setStatusBarPosition(this.statusBarPosition.toString());
    }
    
    private /* synthetic */ void lambda$mergeOres$8(final Configuration configuration, final Ore updatableDefaultOre) {
        configuration.getOres().getOre().stream().filter(o -> ore.getName().equalsIgnoreCase(o.getName())).findFirst().ifPresent(userOre -> this.mergeOre(userOre, updatableDefaultOre2));
    }
    
    private /* synthetic */ void lambda$null$7(final Ore updatableDefaultOre, final Ore userOre) {
        this.mergeOre(userOre, updatableDefaultOre);
    }
    
    private static /* synthetic */ boolean lambda$null$6(final Ore ore, final Ore o) {
        return ore.getName().equalsIgnoreCase(o.getName());
    }
    
    private /* synthetic */ void lambda$mergeProjectiles$5(final Gun gun) {
        this.guns.put(gun.getId(), gun);
    }
    
    private static /* synthetic */ boolean lambda$mergeProjectiles$4(final Gun gun) {
        return gun.getId() != null;
    }
    
    static /* synthetic */ Configuration access$300(final Builder x0) {
        return x0.userConfig;
    }
    
    static /* synthetic */ StatusBarPosition access$400(final Builder x0) {
        return x0.statusBarPosition;
    }
    
    static /* synthetic */ Map access$500(final Builder x0) {
        return x0.guns;
    }
}
