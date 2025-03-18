package com.wolffsarmormod;

import java.nio.file.Path;

public record ContentPack(String name, Path path) implements IContentProvider
{
}
