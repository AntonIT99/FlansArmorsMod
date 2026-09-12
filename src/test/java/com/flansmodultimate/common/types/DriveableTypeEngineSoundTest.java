package com.flansmodultimate.common.types;

import com.flansmodultimate.ContentPack;
import com.flansmodultimate.IContentProvider;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DriveableTypeEngineSoundTest
{
    private static final IContentProvider PACK = new ContentPack("test",
        Path.of("build", "test-packs", "engine-sounds"));

    @Test
    void readsEngineStartupTimingAndPitchConfiguration()
    {
        VehicleType type = new VehicleType();
        type.read(new TypeFile("synthetic", EnumType.VEHICLE, PACK, List.of(
            "Driver 0 0 0",
            "StartEngineSoundLength 37",
            "EngineSoundPitchRange 1.2")));

        assertEquals(37, type.getStartEngineSoundLength());
        assertEquals(1.2F, type.getEngineSoundPitchRange());
    }

    @Test
    void usesSlightlyNarrowerDefaultPitchRange()
    {
        VehicleType type = new VehicleType();
        type.read(new TypeFile("synthetic", EnumType.VEHICLE, PACK, List.of("Driver 0 0 0")));

        assertEquals(0.8F, type.getEngineSoundPitchRange());
    }
}
