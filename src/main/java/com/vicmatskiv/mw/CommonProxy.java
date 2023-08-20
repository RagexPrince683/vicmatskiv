package com.vicmatskiv.mw;

import net.minecraft.item.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.weaponlib.config.*;
import com.vicmatskiv.mw.parts.*;
import com.vicmatskiv.mw.items.*;
import com.vicmatskiv.mw.resources.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.mw.items.melee.*;
import cpw.mods.fml.common.*;

public class CommonProxy
{
    public static Item ElectronicCircuitBoard;
    public static Item CGrip;
    public static Item OpticGlass;
    public static Item Cloth;
    public static Item TanCloth;
    public static Item GreenCloth;
    public static Item Inductor;
    public static Item Transistor;
    public static Item Resistor;
    public static Item Diode;
    public static Item Capacitor;
    public static Item CopperWiring;
    public static Item Piston;
    public static Item LaserPointer;
    public static Item AluminumPlate;
    public static Item SteelPlate;
    public static Item BigSteelPlate;
    public static Item MiniSteelPlate;
    public static Item MetalComponents;
    public static Item Plastic;
    
    public CommonProxy() {
        super();
    }
    
    public ModelBiped getArmorModel(final int id) {
        return null;
    }
    
    protected boolean isClient() {
        return false;
    }
    
    public void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        ModernWarfareMod.MOD_CONTEXT.init(mod, "mw", configurationManager, new CompatibleChannel(ModernWarfareMod.CHANNEL));
        ModernWarfareMod.MOD_CONTEXT.setChangeZoomSound("OpticZoom");
        ModernWarfareMod.MOD_CONTEXT.setChangeFireModeSound("GunFireModeSwitch");
        ModernWarfareMod.MOD_CONTEXT.setNoAmmoSound("dryfire");
        ModernWarfareMod.MOD_CONTEXT.setExplosionSound("grenadeexplosion");
        CommonProxy.ElectronicCircuitBoard = new ItemElectronics();
        CommonProxy.OpticGlass = new ItemOpticGlass();
        CommonProxy.Cloth = new ItemCloth();
        CommonProxy.TanCloth = new ItemTanCloth();
        CommonProxy.GreenCloth = new ItemGreenCloth();
        CommonProxy.Inductor = new ItemInductor();
        CommonProxy.Resistor = new ItemResistor();
        CommonProxy.Transistor = new ItemTransistor();
        CommonProxy.Diode = new ItemDiode();
        CommonProxy.Capacitor = new ItemCapacitor();
        CommonProxy.CopperWiring = new ItemCopperWiring();
        CommonProxy.Piston = new ItemPiston();
        CommonProxy.LaserPointer = new ItemLaserPointer();
        CommonProxy.Plastic = new ItemPlastic();
        CommonProxy.AluminumPlate = new ItemAluminumPlate();
        CommonProxy.SteelPlate = new ItemSteelPlate();
        CommonProxy.BigSteelPlate = new ItemBigSteelPlate();
        CommonProxy.MiniSteelPlate = new ItemMiniSteelPlate();
        CommonProxy.MetalComponents = new ItemMetalComponents();
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.ElectronicCircuitBoard, "Electronics");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.OpticGlass, "OpticGlass");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.Cloth, "Cloth");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.TanCloth, "TanCloth");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.GreenCloth, "GreenCloth");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.AluminumPlate, "AluminumPlate");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.SteelPlate, "SteelPlate");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.BigSteelPlate, "BigSteelPlate");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.MiniSteelPlate, "MiniSteelPlate");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.MetalComponents, "MetalComponents");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.Transistor, "Transistor");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.Resistor, "Resistor");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.Inductor, "Inductor");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.Diode, "Diode");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.Capacitor, "Capacitor");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.CopperWiring, "CopperWiring");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.Piston, "Piston");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.LaserPointer, "LaserPointer");
        CompatibilityProvider.compatibility.registerItem("mw", CommonProxy.Plastic, "plastic");
        Ores.init(mod, configurationManager, event);
        Armors.init(mod, configurationManager, event, this.isClient());
        Attachments.init(mod, configurationManager, event);
        AuxiliaryAttachments.init(mod, configurationManager, event);
        GunSkins.init(mod, configurationManager, event);
        MeleeSkins.init(mod, configurationManager, event);
        Bullets.init(mod, configurationManager, event);
        Magazines.init(mod, configurationManager, event);
        Guns.init(mod, configurationManager, event, this);
        Electronics.init(mod, configurationManager, event);
        Grenades.init(mod, configurationManager, event, this);
        new TestMeleeFactory().createMelee(this);
        new KarambitFactory().createMelee(this);
        CompatibilityProvider.compatibility.registerWorldGenerator((IWorldGenerator)new WorldGeneratorEventHandler(configurationManager), 0);
    }
}
