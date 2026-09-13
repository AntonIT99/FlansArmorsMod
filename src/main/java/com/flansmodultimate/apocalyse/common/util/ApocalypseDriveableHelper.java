package com.flansmodultimate.apocalyse.common.util;

import com.flansmodultimate.apocalyse.common.entity.AiMechaEntity;
import com.flansmodultimate.apocalyse.common.entity.FlyByPlaneEntity;
import com.flansmodultimate.common.driveables.DriveableData;
import com.flansmodultimate.common.driveables.EnumMechaSlotType;
import com.flansmodultimate.common.item.GunItem;
import com.flansmodultimate.common.types.DriveableType;
import com.flansmodultimate.common.types.InfoType;
import com.flansmodultimate.common.types.MechaType;
import com.flansmodultimate.common.types.PlaneType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/** Builds the driveables the apocalypse populates itself with. */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApocalypseDriveableHelper
{
    /** How far out a flyover appears, and the altitude it cruises at. */
    private static final double FLYBY_SPAWN_DISTANCE = 200.0D;
    private static final double FLYBY_ALTITUDE = 120.0D;
    private static final double RADIANS_TO_DEGREES = 180D / Math.PI;

    /**
     * Sends an aircraft across the sky towards {@code target}, flown by a skeleton.
     *
     * @return the aircraft, or empty when no installed pack supplies a plane
     */
    public static Optional<FlyByPlaneEntity> spawnFlyBy(ServerLevel level, Vec3 target, RandomSource random)
    {
        Optional<PlaneType> planeType = randomType(PlaneType.class, random);
        if (planeType.isEmpty())
            return Optional.empty();

        double angle = random.nextDouble() * Math.PI * 2D;
        double offsetX = Math.cos(angle) * FLYBY_SPAWN_DISTANCE;
        double offsetZ = Math.sin(angle) * FLYBY_SPAWN_DISTANCE;
        double altitude = Math.min(FLYBY_ALTITUDE, level.getMaxBuildHeight() - 16D);
        // Point the nose back down the approach so the aircraft passes over the target.
        float yaw = (float) (Mth.atan2(-offsetZ, -offsetX) * RADIANS_TO_DEGREES);

        FlyByPlaneEntity plane = new FlyByPlaneEntity(level, planeType.get(),
            target.x + offsetX, altitude, target.z + offsetZ, yaw);
        // The aircraft boards its own crew once its seats exist, on its first tick.
        return level.addFreshEntity(plane) ? Optional.of(plane) : Optional.empty();
    }

    /**
     * Stands an armed, self-operating mecha at {@code pos} to guard whatever is there.
     *
     * @return the guard, or empty when no installed pack supplies a mecha
     */
    public static Optional<AiMechaEntity> spawnGuardMecha(ServerLevel level, BlockPos pos, RandomSource random)
    {
        Optional<MechaType> mechaType = randomType(MechaType.class, random);
        if (mechaType.isEmpty())
            return Optional.empty();

        MechaType type = mechaType.get();
        AiMechaEntity mecha = new AiMechaEntity(level, type,
            pos.getX() + 0.5D, pos.getY() + type.getYOffset(), pos.getZ() + 0.5D, random.nextFloat() * 360F);
        arm(mecha, type, random);
        return level.addFreshEntity(mecha) ? Optional.of(mecha) : Optional.empty();
    }

    /** Puts a loaded gun in each hand and spare magazines in the cargo hold. */
    private static void arm(AiMechaEntity mecha, MechaType type, RandomSource random)
    {
        DriveableData data = mecha.getDriveableData();
        if (data == null)
            return;
        int cargoSlots = Math.max(0, type.getNumCargoSlots());

        for (EnumMechaSlotType hand : List.of(EnumMechaSlotType.LEFT_TOOL, EnumMechaSlotType.RIGHT_TOOL))
        {
            Optional<ItemStack> gun = ApocalypseGunHelper.randomLoadedGun(random, false);
            if (gun.isEmpty())
                continue;
            ItemStack gunStack = gun.get();
            data.setMechaAddon(hand, gunStack);
            if (cargoSlots <= 0 || !(gunStack.getItem() instanceof GunItem gunItem))
                continue;

            int magazines = 1 + random.nextInt(2);
            for (int magazine = 0; magazine < magazines; magazine++)
            {
                int slot = random.nextInt(cargoSlots);
                if (!data.getCargo(slot).isEmpty())
                    continue;
                ApocalypseGunHelper.spareAmmoFor(gunItem.getConfigType(), random)
                    .ifPresent(ammo -> data.setCargo(slot, ammo));
            }
        }
        data.setChanged();
    }

    /**
     * A driveable type of the requested kind, chosen reproducibly.
     *
     * <p>Info types live in a hash map, so the candidates are sorted before the worldgen RNG
     * picks one; that keeps a given seed and pack set producing the same choice.</p>
     */
    private static <T extends DriveableType> Optional<T> randomType(Class<T> kind, RandomSource random)
    {
        List<T> candidates = InfoType.getInfoTypes().values().stream()
            .filter(kind::isInstance)
            .map(kind::cast)
            .distinct()
            .sorted(Comparator.comparing(DriveableType::getShortName, String.CASE_INSENSITIVE_ORDER))
            .toList();
        return candidates.isEmpty() ? Optional.empty() : Optional.of(candidates.get(random.nextInt(candidates.size())));
    }
}
