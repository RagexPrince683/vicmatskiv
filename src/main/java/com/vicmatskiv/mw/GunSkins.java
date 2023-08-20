package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.config.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class GunSkins
{
    public static ItemSkin ElectricSkin;
    public static ItemSkin Voltaic;
    public static ItemSkin LightningStrike;
    public static ItemSkin Fade;
    public static ItemSkin Emerald;
    public static ItemSkin Diamond;
    public static ItemSkin Gold;
    public static ItemSkin Sapphire;
    public static ItemSkin Desert;
    public static ItemSkin Forest;
    public static ItemSkin Amber;
    public static ItemSkin Arctic;
    public static ItemSkin Amethyst;
    
    public GunSkins() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        GunSkins.ElectricSkin = new ItemSkin.Builder().withTextureVariant("Electric").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Electric").withCraftingRecipe("AF", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 0, 0), 'F', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 12, 12)).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Voltaic = new ItemSkin.Builder().withTextureVariant("voltaic").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Voltaic").withCraftingRecipe("AF", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 5, 5), 'F', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 8, 8)).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.LightningStrike = new ItemSkin.Builder().withTextureVariant("AWPLightningStrike").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withCraftingRecipe("AF", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 5, 5), 'F', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 9, 9)).withName("LightningStrike").build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Fade = new ItemSkin.Builder().withTextureVariant("G18Fade").withTextureVariant("SMAWRuby").withTextureVariant("Ruby").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withCraftingRecipe("A", 'A', Ores.Ruby).withName("Fade").build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Emerald = new ItemSkin.Builder().withTextureVariant("Emerald").withTextureVariant("KrissVectorEmerald").withTextureVariant("MosinNagantEmerald").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Emerald").withCraftingRecipe("A", 'A', CompatibleItems.EMERALD).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Diamond = new ItemSkin.Builder().withTextureVariant("Diamond").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Diamond").withCraftingRecipe("A", 'A', CompatibleItems.DIAMOND).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Gold = new ItemSkin.Builder().withTextureVariant("Gold").withTextureVariant("KrissVectorGold").withTextureVariant("MosinNagantGold").withTextureVariant("SMAWGold").withTextureVariant("HecateIIGold").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Gold").withCraftingRecipe("AA", "AA", 'A', CompatibleItems.GOLD_NUGGET).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Sapphire = new ItemSkin.Builder().withTextureVariant("Sapphire").withTextureVariant("KrissVectorSapphire").withTextureVariant("SMAWSapphire").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Sapphire").withCraftingRecipe("A", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 4, 4)).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Desert = new ItemSkin.Builder().withTextureVariant("Desert").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Desert").withCraftingRecipe("A", 'A', CompatibleBlocks.SAND).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Forest = new ItemSkin.Builder().withTextureVariant("Forest").withTextureVariant("MosinNagantForest").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Forest").withCraftingRecipe("A", 'A', CompatibleBlocks.LEAVES).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Amber = new ItemSkin.Builder().withTextureVariant("Amber").withTextureVariant("M14Amber").withTextureVariant("HecateIIAmber").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Amber").withCraftingRecipe("A", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 14, 14)).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Arctic = new ItemSkin.Builder().withTextureVariant("Arctic").withTextureVariant("HecateIIArctic").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Arctic").withCraftingRecipe("AR", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 0, 0), 'R', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 15, 15)).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
        GunSkins.Amethyst = new ItemSkin.Builder().withTextureVariant("Amethyst").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Amethyst").withCraftingRecipe("A", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 5, 5)).build(ModernWarfareMod.MOD_CONTEXT, ItemSkin.class);
    }
}
