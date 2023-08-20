package com.vicmatskiv.mw;

import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.config.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class Armors
{
    public static Item Marinechest;
    public static Item Marineboots;
    public static Item Marinehelmet;
    public static Item Spetznazchest;
    public static Item Spetznazboots;
    public static Item Spetznazhelmet;
    public static Item Swatchest;
    public static Item Swatboots;
    public static Item Swathelmet;
    public static Item GasSwatchest;
    public static Item GasSwatboots;
    public static Item GasSwathelmet;
    public static Item Tacticalchest;
    public static Item Tacticalboots;
    public static Item Tacticalhelmet;
    static ItemArmor.ArmorMaterial Marine;
    static ItemArmor.ArmorMaterial Tactical;
    
    public Armors() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event, final boolean isClient) {
        final CustomArmor.Builder marineArmorBuilder = new CustomArmor.Builder().withModId("mw").withMaterial(Armors.Marine).withUnlocalizedName("Marine").withTextureName("Marine").withModelClass("com.vicmatskiv.mw.models.Marine").withHudTextureName("Marine").withCreativeTab(ModernWarfareMod.ArmorTab);
        Armors.Marinehelmet = (Item)marineArmorBuilder.buildHelmet(isClient);
        Armors.Marinechest = (Item)marineArmorBuilder.buildChest(isClient);
        Armors.Marineboots = (Item)marineArmorBuilder.buildBoots(isClient);
        final CustomArmor.Builder spetznazArmorBuilder = new CustomArmor.Builder().withModId("mw").withMaterial(Armors.Marine).withCreativeTab(ModernWarfareMod.ArmorTab).withUnlocalizedName("Spetznaz").withTextureName("Spetznaz").withModelClass("com.vicmatskiv.mw.models.Marine").withHudTextureName("Marine").withCreativeTab(ModernWarfareMod.ArmorTab);
        Armors.Spetznazhelmet = (Item)spetznazArmorBuilder.buildHelmet(isClient);
        Armors.Spetznazchest = (Item)spetznazArmorBuilder.buildChest(isClient);
        Armors.Spetznazboots = (Item)spetznazArmorBuilder.buildBoots(isClient);
        final CustomArmor.Builder swatArmorBuilder = new CustomArmor.Builder().withModId("mw").withMaterial(Armors.Marine).withUnlocalizedName("Swat").withTextureName("Swat").withModelClass("com.vicmatskiv.mw.models.Swat").withHudTextureName("Marine").withCreativeTab(ModernWarfareMod.ArmorTab);
        Armors.Swathelmet = (Item)swatArmorBuilder.buildHelmet(isClient);
        Armors.Swatchest = (Item)swatArmorBuilder.buildChest(isClient);
        Armors.Swatboots = (Item)swatArmorBuilder.buildBoots(isClient);
        final CustomArmor.Builder tacticalArmorBuilder = new CustomArmor.Builder().withModId("mw").withMaterial(Armors.Tactical).withUnlocalizedName("Tactical").withTextureName("Tactical").withModelClass("com.vicmatskiv.mw.models.Tactical").withHudTextureName("Tactical").withCreativeTab(ModernWarfareMod.ArmorTab);
        Armors.Tacticalhelmet = (Item)tacticalArmorBuilder.buildHelmet(isClient);
        Armors.Tacticalchest = (Item)tacticalArmorBuilder.buildChest(isClient);
        Armors.Tacticalboots = (Item)tacticalArmorBuilder.buildBoots(isClient);
    }
    
    static {
        Armors.Marine = CompatibilityProvider.compatibility.addArmorMaterial("Marine", "Marine", 40, new int[] { 3, 5, 4, 3 }, 15, null, 0.0f);
        Armors.Tactical = CompatibilityProvider.compatibility.addArmorMaterial("Tactical", "Tactical", 40, new int[] { 2, 4, 3, 2 }, 15, null, 0.0f);
    }
}
