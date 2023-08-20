package com.vicmatskiv.mw;

import net.minecraft.block.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.config.*;
import com.vicmatskiv.mw.blocks.*;
import com.vicmatskiv.mw.resources.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraftforge.oredict.*;

public class Ores
{
    public static final String DUST_SULFUR = "dustSulfur";
    public static final String INGOT_TITANIUM = "ingotTitanium";
    public static final String INGOT_STEEL = "ingotSteel";
    public static final String INGOT_COPPER = "ingotCopper";
    public static final String INGOT_TANTALUM = "ingotTantalum";
    public static final String INGOT_ALUMINIUM = "ingotAluminium";
    public static final String INGOT_TIN = "ingotTin";
    public static final String INGOT_LEAD = "ingotLead";
    public static Block TitaniumOre;
    public static Item TitaniumIngot;
    public static Block LeadOre;
    public static Item LeadIngot;
    public static Block CopperOre;
    public static Item CopperIngot;
    public static Block TinOre;
    public static Item TinIngot;
    public static Block SulfurOre;
    public static Item SulfurDust;
    public static Block BauxiteOre;
    public static Item AluminumIngot;
    public static Block SiliconOre;
    public static Block TantalumOre;
    public static Item TantalumIngot;
    public static Block RubyOre;
    public static Item Ruby;
    public static Item SteelDust;
    public static Item SteelIngot;
    public static Item Silicon;
    
    public Ores() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        Ores.TitaniumOre = new BlockTitaniumOre();
        Ores.TitaniumIngot = new ItemTitaniumIngot();
        Ores.LeadOre = new BlockLeadOre();
        Ores.LeadIngot = new ItemLeadIngot();
        Ores.CopperOre = new BlockCopperOre();
        Ores.CopperIngot = new ItemCopperIngot();
        Ores.TinOre = new BlockTinOre();
        Ores.TinIngot = new ItemTinIngot();
        Ores.SulfurOre = new BlockSulfurOre();
        Ores.SulfurDust = new ItemSulfurDust();
        Ores.BauxiteOre = new BlockBauxiteOre();
        Ores.AluminumIngot = new ItemAluminumIngot();
        Ores.RubyOre = new BlockRubyOre();
        Ores.Ruby = new ItemRuby();
        Ores.SiliconOre = new BlockSiliconOre();
        Ores.Silicon = new ItemSilicon();
        Ores.TantalumOre = new BlockTantalumOre();
        Ores.TantalumIngot = new ItemTantalumIngot();
        Ores.SteelDust = new ItemSteelDust();
        Ores.SteelIngot = new ItemSteelIngot();
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.TitaniumOre, "TitaniumOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.TitaniumIngot, "TitaniumIngot");
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.LeadOre, "LeadOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.LeadIngot, "LeadIngot");
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.CopperOre, "CopperOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.CopperIngot, "CopperIngot");
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.TinOre, "TinOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.TinIngot, "TinIngot");
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.SulfurOre, "SulfurOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.SulfurDust, "SulfurDust");
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.BauxiteOre, "BauxiteOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.AluminumIngot, "AluminumIngot");
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.SiliconOre, "SiliconOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.Silicon, "Silicon");
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.TantalumOre, "TantalumOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.TantalumIngot, "TantalumIngot");
        CompatibilityProvider.compatibility.registerBlock("mw", Ores.RubyOre, "RubyOre");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.Ruby, "Ruby");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.SteelDust, "SteelDust");
        CompatibilityProvider.compatibility.registerItem("mw", Ores.SteelIngot, "SteelIngot");
        OreDictionary.registerOre("ingotTitanium", Ores.TitaniumIngot);
        OreDictionary.registerOre("ingotTantalum", Ores.TantalumIngot);
        OreDictionary.registerOre("ingotLead", Ores.LeadIngot);
        OreDictionary.registerOre("ingotCopper", Ores.CopperIngot);
        OreDictionary.registerOre("ingotTin", Ores.TinIngot);
        OreDictionary.registerOre("dustSulfur", Ores.SulfurDust);
        OreDictionary.registerOre("ingotAluminium", Ores.AluminumIngot);
        OreDictionary.registerOre("Ruby", Ores.Ruby);
        OreDictionary.registerOre("ingotSteel", Ores.SteelIngot);
    }
}
