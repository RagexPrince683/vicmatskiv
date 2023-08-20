package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.melee.*;
import com.vicmatskiv.weaponlib.config.*;
import com.vicmatskiv.weaponlib.compatibility.*;

public class MeleeSkins
{
    public static MeleeSkin CrimsonBlood;
    public static MeleeSkin Chrome;
    public static MeleeSkin GodWillsIt;
    public static MeleeSkin Murasaki;
    public static MeleeSkin Evangelion;
    
    public MeleeSkins() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event) {
        MeleeSkins.CrimsonBlood = new MeleeSkin.Builder().withTextureVariant("TacKnifeCrimsonBlood").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("CrimsonBlood").withCraftingRecipe("AR", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 0, 0), 'R', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 1, 1)).build(ModernWarfareMod.MOD_CONTEXT, MeleeSkin.class);
        MeleeSkins.Chrome = new MeleeSkin.Builder().withTextureVariant("TacKnifeChrome").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Chrome").withCraftingRecipe("AR", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 5, 5), 'R', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 11, 11)).build(ModernWarfareMod.MOD_CONTEXT, MeleeSkin.class);
        MeleeSkins.GodWillsIt = new MeleeSkin.Builder().withTextureVariant("TacKnifeGodWillsIt").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("GodWillsIt").withCraftingRecipe("AR", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 11, 11), 'R', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 15, 15)).build(ModernWarfareMod.MOD_CONTEXT, MeleeSkin.class);
        MeleeSkins.Murasaki = new MeleeSkin.Builder().withTextureVariant("TacKnifeMurasaki").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Murasaki").withCraftingRecipe("AA", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 5, 5)).build(ModernWarfareMod.MOD_CONTEXT, MeleeSkin.class);
        MeleeSkins.Evangelion = new MeleeSkin.Builder().withTextureVariant("TacKnifeEvangelion").withModId("mw").withCreativeTab(ModernWarfareMod.AttachmentsTab).withName("Evangelion").withCraftingRecipe("AR", 'A', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 5, 5), 'R', CompatibilityProvider.compatibility.createItemStack(CompatibleItems.DYE, 10, 10)).build(ModernWarfareMod.MOD_CONTEXT, MeleeSkin.class);
    }
}
