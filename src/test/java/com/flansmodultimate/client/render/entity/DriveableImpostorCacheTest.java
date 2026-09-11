package com.flansmodultimate.client.render.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DriveableImpostorCacheTest
{
    @Test
    void impostorActivatesByProjectedSizeOrMaximumDistance()
    {
        assertTrue(DriveableImpostorCache.shouldUseImpostor(31F, 80D, 32F, 128F, false));
        assertTrue(DriveableImpostorCache.shouldUseImpostor(96F, 128D, 32F, 128F, false));
        assertFalse(DriveableImpostorCache.shouldUseImpostor(96F, 127D, 32F, 128F, false));
    }

    @Test
    void impostorHysteresisPreventsBoundaryFlapping()
    {
        assertTrue(DriveableImpostorCache.shouldUseImpostor(38F, 110D, 32F, 128F, true));
        assertFalse(DriveableImpostorCache.shouldUseImpostor(39F, 100D, 32F, 128F, true));
        assertFalse(DriveableImpostorCache.shouldUseImpostor(1F, 1_000D, 0F, 0F, true));
    }
}
