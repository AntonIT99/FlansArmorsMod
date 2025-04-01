package com.wolffsarmormod;

import com.mojang.logging.LogUtils;
import com.wolffsarmormod.client.ModClientConfigs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixins;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod(ArmorMod.MOD_ID)
public class ArmorMod
{
    public static final String MOD_ID = "wolffsarmormod";
    public static final String FLANSMOD_ID = "flansmod";
    public static final Logger log = LogUtils.getLogger();

    public static long ticker;

    public static Path flanPath = FMLPaths.GAMEDIR.get().resolve("flan");
    public static Path fallbackFlanPath = FMLPaths.GAMEDIR.get().resolve("Flan");

    public static final ContentManager contentManager = new ContentManager();
    public static final List<RegistryObject<Item>> items = new ArrayList<>();

    private static final DeferredRegister<Item> itemRegistry = DeferredRegister.create(ForgeRegistries.ITEMS, ArmorMod.FLANSMOD_ID);
    private static final DeferredRegister<CreativeModeTab> creativeModeTabRegistry = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArmorMod.MOD_ID);

    public ArmorMod(FMLJavaModLoadingContext context)
    {
        Mixins.addConfiguration("mixins." + MOD_ID + ".json");

        IEventBus eventBus = context.getModEventBus();
        context.registerConfig(ModConfig.Type.CLIENT, ModClientConfigs.CONFIG);

        itemRegistry.register(eventBus);
        creativeModeTabRegistry.register(eventBus);

        contentManager.findContentInFlanFolder();
        contentManager.loadTypes();
        contentManager.registerConfigs();
        registerCreativeModeTabs();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> contentManager::prepareAssets);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void registerItem(String itemName, Supplier<? extends Item> initItem)
    {
        items.add(itemRegistry.register(itemName, initItem));
    }

    public void registerCreativeModeTabs()
    {
        creativeModeTabRegistry.register("custom_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab." + MOD_ID + ".custom_tab"))
            .icon(() -> new ItemStack(items.get(0).get()))
            .displayItems((parameters, output) -> items.forEach(item -> output.accept(item.get())))
            .withSearchBar()
            .build());
    }
}
