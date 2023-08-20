package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class RecipeManager
{
    public RecipeManager() {
        super();
    }
    
    public static void init(final ModContext modContext) {
        CompatibilityProvider.compatibility.addSmelting(Ores.TitaniumOre, new ItemStack(Ores.TitaniumIngot), 5.0f);
        CompatibilityProvider.compatibility.addSmelting(Ores.CopperOre, new ItemStack(Ores.CopperIngot), 5.0f);
        CompatibilityProvider.compatibility.addSmelting(Ores.LeadOre, new ItemStack(Ores.LeadIngot), 5.0f);
        CompatibilityProvider.compatibility.addSmelting(Ores.TinOre, new ItemStack(Ores.TinIngot), 5.0f);
        CompatibilityProvider.compatibility.addSmelting(Ores.BauxiteOre, new ItemStack(Ores.AluminumIngot), 5.0f);
        CompatibilityProvider.compatibility.addSmelting(Ores.SiliconOre, new ItemStack(Ores.Silicon), 5.0f);
        CompatibilityProvider.compatibility.addSmelting(Ores.TantalumOre, new ItemStack(Ores.TantalumIngot), 5.0f);
        CompatibilityProvider.compatibility.addSmelting(Ores.SulfurDust, CompatibilityProvider.compatibility.createItemStack(CompatibleItems.GUNPOWDER, 1, 0), 5.0f);
        CompatibilityProvider.compatibility.addSmelting(Ores.SteelDust, new ItemStack(Ores.SteelIngot), 5.0f);
        modContext.getRecipeManager().registerShapedRecipe(Armors.Marinehelmet, "AAA", "AGA", "X X", 'A', CommonProxy.TanCloth, 'X', "ingotTitanium");
        modContext.getRecipeManager().registerShapedRecipe(Armors.Marinechest, "A A", "AAA", "XXX", 'A', CommonProxy.TanCloth, 'X', "ingotTitanium");
        modContext.getRecipeManager().registerShapedRecipe(Armors.Marineboots, "A A", "A A", "X X", 'A', CommonProxy.TanCloth, 'X', "ingotTitanium");
        modContext.getRecipeManager().registerShapedRecipe(Armors.Spetznazhelmet, "AAA", "AGA", "X X", 'A', CommonProxy.GreenCloth, 'X', "ingotTitanium");
        modContext.getRecipeManager().registerShapedRecipe(Armors.Spetznazchest, "A A", "AAA", "XXX", 'A', CommonProxy.GreenCloth, 'X', "ingotTitanium");
        modContext.getRecipeManager().registerShapedRecipe(Armors.Spetznazboots, "A A", "A A", "X X", 'A', CommonProxy.GreenCloth, 'X', "ingotTitanium");
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.Cloth, 3), "XAX", "AXA", "XAX", 'X', CompatibleItems.STRING, 'A', CompatibleBlocks.WOOL);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.TanCloth, 3), "XAX", "AXA", "XAX", 'X', CompatibleBlocks.SANDSTONE, 'A', CommonProxy.Cloth);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.GreenCloth, 3), "XAX", "AXA", "XAX", 'X', CompatibleBlocks.LEAVES, 'A', CommonProxy.Cloth);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.ElectronicCircuitBoard), "TAI", "ACA", "RAD", 'I', CommonProxy.Inductor, 'T', CommonProxy.Transistor, 'R', CommonProxy.Resistor, 'D', CommonProxy.Diode, 'C', CommonProxy.Capacitor, 'A', CommonProxy.CopperWiring);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.CGrip), "AAA", "XBX", "  A", 'A', CommonProxy.SteelPlate, 'X', "ingotSteel", 'B', CompatibleBlocks.STONE_BUTTON);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.OpticGlass), "XAX", "AEA", "XAX", 'X', "ingotTitanium", 'E', CommonProxy.CopperWiring, 'A', CompatibleBlocks.GLASS_PANE);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.MiniSteelPlate, 2), "XX", 'X', "ingotSteel");
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.SteelPlate, 2), "XXX", "XXX", 'X', "ingotSteel");
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.BigSteelPlate), "XAX", 'X', CommonProxy.SteelPlate, 'A', CommonProxy.MiniSteelPlate);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.MetalComponents), "XA", "AX", 'X', CommonProxy.SteelPlate, 'A', "ingotSteel");
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(Guns.M9SD), "AX", 'X', Guns.M9, 'A', Attachments.Silencer9mm);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.LaserPointer), "XXX", "AAR", "XXX", 'X', CommonProxy.MiniSteelPlate, 'A', Ores.Ruby, 'R', CommonProxy.Capacitor);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.Resistor, 3), "A", "X", "A", 'A', "ingotSteel", 'X', CompatibleItems.COAL);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.Transistor, 3), "AA", "XX", "XX", 'A', "ingotSteel", 'X', Ores.Silicon);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.Capacitor, 3), "XX", "AA", "RR", 'X', "ingotAluminium", 'A', CommonProxy.Plastic, 'R', "ingotTantalum");
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.Inductor, 3), " A ", "AXA", " A ", 'X', CommonProxy.Plastic, 'A', CommonProxy.CopperWiring);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.Diode, 3), "X", "A", "X", 'A', "ingotSteel", 'X', Ores.Silicon);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.CopperWiring, 10), "A  ", "A A", "AAA", 'A', "ingotCopper");
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.Plastic, 3), "AX", 'A', CompatibleItems.COAL, 'X', CompatibleItems.WATER_BUCKET);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.Piston), "XA ", "AXX", " XE", 'A', CommonProxy.SteelPlate, 'X', "ingotSteel", 'E', CommonProxy.ElectronicCircuitBoard);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(Ores.SteelDust, 4), " X ", "XAX", " X ", 'A', CompatibleItems.IRON_INGOT, 'X', CompatibleItems.COAL);
        modContext.getRecipeManager().registerShapedRecipe(new ItemStack(CommonProxy.AluminumPlate, 6), "   ", "XXX", 'X', "ingotAluminium");
    }
}
