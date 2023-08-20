package com.vicmatskiv.weaponlib.config;

import java.util.function.*;
import java.text.*;
import java.nio.file.*;
import java.io.*;
import org.apache.logging.log4j.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.bind.*;
import java.util.*;

public class ConfigurationManager
{
    private static final Logger logger;
    private static final float DROP_BLOCK_COEFFICIENT_MIN = 0.0f;
    private static final float DROP_BLOCK_COEFFICIENT_MAX = 5.0f;
    private static final float EXPLOSION_COEFFICIENT_MAX = 2.0f;
    private static final float EXPLOSION_COEFFICIENT_MIN = 0.2f;
    private static final float BLEEDING_ON_HIT_COEFFICIENT_MIN = 0.0f;
    private static final float BLEEDING_ON_HIT_COEFFICIENT_MAX = 1.0f;
    private static final int ORE_MIN_PER_CHUNK = 0;
    private static final int ORE_MAX_PER_CHUNK = 50;
    private static final Predicate<Ore> DEFAULT_ORE_VALIDATOR;
    private static final Predicate<Explosions> DEFAULT_EXPLOSIONS_VALIDATOR;
    private Configuration config;
    private File userConfigFile;
    private Builder builder;
    
    protected ConfigurationManager(final Configuration config, final File userConfigFile, final Builder builder) {
        super();
        this.config = config;
        this.userConfigFile = userConfigFile;
        this.builder = builder;
    }
    
    protected Configuration getConfiguration() {
        return this.config;
    }
    
    public void save() {
        if (this.userConfigFile.exists() && this.builder.userConfig == null) {
            final String extension = ".invalid." + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            final File invalidFileCopy = new File(this.userConfigFile.toString() + extension);
            try {
                Files.move(this.userConfigFile.toPath(), invalidFileCopy.toPath(), new CopyOption[0]);
            }
            catch (final IOException e) {
                ConfigurationManager.logger.error("Failed to rename {} to {}", new Object[] { this.userConfigFile, invalidFileCopy });
            }
        }
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            final Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", true);
            if (this.userConfigFile != null) {
                marshaller.marshal(new ObjectFactory().createConfiguration(this.config), this.userConfigFile);
            }
            else {
                marshaller.marshal(new ObjectFactory().createConfiguration(this.config), System.out);
            }
        }
        catch (final JAXBException e2) {
            ConfigurationManager.logger.error("Failed to save configuration to {}", new Object[] { this.userConfigFile });
        }
    }
    
    public Explosions getExplosions() {
        return this.config.getExplosions();
    }
    
    public Ore getOre(final String oreName) {
        final Ores ores = this.config.getOres();
        if (ores == null) {
            return null;
        }
        return ores.getOre().stream().filter(o -> s.equalsIgnoreCase(o.getName())).findFirst().orElse(null);
    }
    
    public Projectiles getProjectiles() {
        return this.config.getProjectiles();
    }
    
    public StatusBarPosition getStatusBarPosition() {
        return this.builder.statusBarPosition;
    }
    
    public Gun getGun(final String id) {
        return this.builder.guns.get(id);
    }
    
    private static /* synthetic */ boolean lambda$getOre$9(final String s, final Ore o) {
        return s.equalsIgnoreCase(o.getName());
    }
    
    private static /* synthetic */ boolean lambda$static$3(final Explosions explosions) {
        return explosions != null;
    }
    
    private static /* synthetic */ boolean lambda$static$2(final Ore ore) {
        return ore.spawnsPerChunk >= 0 && ore.spawnsPerChunk <= 50;
    }
    
    static /* synthetic */ Predicate access$000() {
        return ConfigurationManager.DEFAULT_ORE_VALIDATOR;
    }
    
    static /* synthetic */ Predicate access$100() {
        return ConfigurationManager.DEFAULT_EXPLOSIONS_VALIDATOR;
    }
    
    static /* synthetic */ Logger access$200() {
        return ConfigurationManager.logger;
    }
    
    static {
        logger = LogManager.getLogger((Class)ConfigurationManager.class);
        DEFAULT_ORE_VALIDATOR = (ore -> ore.spawnsPerChunk >= 0 && ore.spawnsPerChunk <= 50);
        DEFAULT_EXPLOSIONS_VALIDATOR = (explosions -> explosions != null);
    }
    
    public enum StatusBarPosition
    {
        TOP_RIGHT, 
        BOTTOM_RIGHT, 
        TOP_LEFT, 
        BOTTOM_LEFT;
        
        private static final /* synthetic */ StatusBarPosition[] $VALUES;
        
        public static StatusBarPosition[] values() {
            return StatusBarPosition.$VALUES.clone();
        }
        
        public static StatusBarPosition valueOf(final String name) {
            return Enum.valueOf(StatusBarPosition.class, name);
        }
        
        static {
            $VALUES = new StatusBarPosition[] { StatusBarPosition.TOP_RIGHT, StatusBarPosition.BOTTOM_RIGHT, StatusBarPosition.TOP_LEFT, StatusBarPosition.BOTTOM_LEFT };
        }
    }
    
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
            this.oreValidator = ConfigurationManager.DEFAULT_ORE_VALIDATOR;
            this.explosionsValidator = ConfigurationManager.DEFAULT_EXPLOSIONS_VALIDATOR;
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
                ConfigurationManager.logger.error("Failed to parse configuration: " + e, (Throwable)e);
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
}
