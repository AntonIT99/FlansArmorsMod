package com.wolff.armormod.common;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.nio.file.Path;

public interface ICustomIconItem
{
    @OnlyIn(Dist.CLIENT)
    Path getIconPath();
}
