package com.vicmatskiv.weaponlib.compatibility;

import net.minecraft.item.*;
import net.minecraftforge.client.*;
import net.minecraft.entity.*;
import cpw.mods.fml.client.registry.*;
import net.minecraft.client.renderer.entity.*;

public class CompatibleRenderingRegistry
{
    public CompatibleRenderingRegistry(final String modId) {
        super();
    }
    
    public void register(final Item item, final String name, final Object renderer) {
        MinecraftForgeClient.registerItemRenderer(item, (IItemRenderer)renderer);
    }
    
    public void registerEntityRenderingHandler(final Class<? extends Entity> class1, final CompatibleEntityRenderer renderer) {
        RenderingRegistry.registerEntityRenderingHandler((Class)class1, (Render)renderer);
    }
}
