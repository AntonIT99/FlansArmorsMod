package com.wolffsarmormod.client;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModClientConfigs
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CONFIG;

    // Example config values
    public static final ForgeConfigSpec.BooleanValue showPackNameInItemDescriptions;

    static {
        BUILDER.push("Client Settings");

        showPackNameInItemDescriptions = BUILDER
                .comment("Show pack names in item descriptions")
                .define("showPackNameInItemDescriptions", true);

        BUILDER.pop();
        CONFIG = BUILDER.build();
    }
}
