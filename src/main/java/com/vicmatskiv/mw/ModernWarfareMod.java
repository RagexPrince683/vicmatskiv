package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.creativetab.*;
import com.vicmatskiv.weaponlib.config.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import java.io.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;

@Mod(modid = "mw", version = "1.10.3")
public class ModernWarfareMod
{
    private static final String DEFAULT_CONFIG_RESOURCE = "/mw.cfg";
    private static final String MODERN_WARFARE_CONFIG_FILE_NAME = "ModernWarfare.cfg";
    public static final String MODID = "mw";
    public static final String VERSION = "1.10.3";
    @SidedProxy(serverSide = "com.vicmatskiv.weaponlib.CommonModContext", clientSide = "com.vicmatskiv.weaponlib.ClientModContext")
    public static ModContext MOD_CONTEXT;
    public static final SimpleNetworkWrapper CHANNEL;
    public static CreativeTabs gunsTab;
    public static CreativeTabs ArmorTab;
    public static CreativeTabs AssaultRiflesTab;
    public static CreativeTabs PistolsTab;
    public static CreativeTabs SMGTab;
    public static CreativeTabs ShotgunsTab;
    public static CreativeTabs SnipersTab;
    public static CreativeTabs AmmoTab;
    public static CreativeTabs AttachmentsTab;
    public static CreativeTabs GrenadesTab;
    public static CreativeTabs GadgetsTab;
    public static CreativeTabs FunGunsTab;
    @SidedProxy(serverSide = "com.vicmatskiv.mw.CommonProxy", clientSide = "com.vicmatskiv.mw.ClientProxy")
    public static CommonProxy proxy;
    public static boolean oreGenerationEnabled;
    private ConfigurationManager configurationManager;
    
    public ModernWarfareMod() {
        super();
    }
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        this.initConfigurationManager(event);
        ModernWarfareMod.proxy.init(this, this.configurationManager, new CompatibleFmlInitializationEvent(event));
    }
    
    @Mod.EventHandler
    public void postInit(final FMLPostInitializationEvent event) {
        if (this.configurationManager != null) {
            this.configurationManager.save();
        }
    }
    
    private void initConfigurationManager(final FMLPreInitializationEvent event) {
        final File parentDirectory = event.getSuggestedConfigurationFile().getParentFile();
        File configFile;
        if (parentDirectory != null) {
            configFile = new File(parentDirectory, "ModernWarfare.cfg");
        }
        else {
            configFile = new File("ModernWarfare.cfg");
        }
        this.configurationManager = new ConfigurationManager.Builder().withUserConfiguration(configFile).withDefaultConfiguration(new StreamSource(this.getClass().getResourceAsStream("/mw.cfg"))).build();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        RecipeManager.init(ModernWarfareMod.MOD_CONTEXT);
    }
    
    static {
        CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel("mw");
        ModernWarfareMod.gunsTab = new GunsTab(CreativeTabs.getNextID(), "guns_tab");
        ModernWarfareMod.ArmorTab = new ArmorTab(CreativeTabs.getNextID(), "ArmorTab");
        ModernWarfareMod.AssaultRiflesTab = new AssaultRiflesTab(CreativeTabs.getNextID(), "AssaultRifles_tab");
        ModernWarfareMod.PistolsTab = new PistolsTab(CreativeTabs.getNextID(), "Pistols_tab");
        ModernWarfareMod.SMGTab = new SMGTab(CreativeTabs.getNextID(), "SMG_tab");
        ModernWarfareMod.ShotgunsTab = new ShotgunsTab(CreativeTabs.getNextID(), "ShotgunsTab");
        ModernWarfareMod.SnipersTab = new SnipersTab(CreativeTabs.getNextID(), "SnipersTab");
        ModernWarfareMod.AmmoTab = new AmmoTab(CreativeTabs.getNextID(), "AmmoTab");
        ModernWarfareMod.AttachmentsTab = new AttachmentsTab(CreativeTabs.getNextID(), "AttachmentsTab");
        ModernWarfareMod.GrenadesTab = new GrenadesTab(CreativeTabs.getNextID(), "GrenadesTab");
        ModernWarfareMod.GadgetsTab = new GadgetsTab(CreativeTabs.getNextID(), "GadgetsTab");
        ModernWarfareMod.FunGunsTab = new FunGunsTab(CreativeTabs.getNextID(), "FunGuns_tab");
        ModernWarfareMod.oreGenerationEnabled = true;
    }
}
