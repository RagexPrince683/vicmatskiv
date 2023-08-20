package com.vicmatskiv.mw;

import com.vicmatskiv.weaponlib.grenade.*;
import com.vicmatskiv.weaponlib.config.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.mw.models.*;
import net.minecraft.client.model.*;
import com.vicmatskiv.mw.items.grenade.*;

public class Grenades
{
    public static ItemGrenade FuseGrenade;
    public static ItemGrenade ImpactGrenade;
    public static ItemGrenade SmokeGrenade;
    public static ItemAttachment<ItemGrenade> GrenadeSafetyPin;
    
    public Grenades() {
        super();
    }
    
    public static void init(final Object mod, final ConfigurationManager configurationManager, final CompatibleFmlInitializationEvent event, final CommonProxy commonProxy) {
        Grenades.GrenadeSafetyPin = new AttachmentBuilder<ItemGrenade>().withCategory(AttachmentCategory.EXTRA).withModel(new Pin(), "AK12.png").withName("GrenadeSafetyPin").withRenderablePart().withModId("mw").withTextureName("Dummy.png").build(ModernWarfareMod.MOD_CONTEXT);
        Grenades.FuseGrenade = new FuseGrenadeFactory().createGrenade(commonProxy);
        Grenades.ImpactGrenade = new ImpactGrenadeFactory().createGrenade(commonProxy);
        Grenades.SmokeGrenade = new SmokeGrenadeFactory().createGrenade(commonProxy);
    }
}
