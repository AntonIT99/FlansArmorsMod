package com.wolff.armormod;

import com.mojang.logging.LogUtils;
import com.wolff.armormod.common.ModCreativeTabs;
import com.wolff.armormod.common.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ArmorMod.MOD_ID)
public class ArmorMod
{
    public static final String MOD_ID = "armormod";
    public static final Logger LOG = LogUtils.getLogger();

    private static final ContentManager contentManager = new ContentManager();

    public ArmorMod(IEventBus eventBus)
    {
        MinecraftForge.EVENT_BUS.register(this);

        contentManager.findContentInFlanFolder();
        contentManager.loadTypes();

        ModItems.REGISTRY.register(eventBus);
        ModCreativeTabs.REGISTRY.register(eventBus);
    }
}
