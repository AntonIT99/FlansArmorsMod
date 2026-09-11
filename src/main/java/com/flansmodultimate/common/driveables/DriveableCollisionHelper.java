package com.flansmodultimate.common.driveables;

import com.flansmodultimate.FlansMod;
import com.flansmodultimate.common.entity.Driveable;
import com.flansmodultimate.common.types.DriveableType;
import org.jetbrains.annotations.Nullable;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/**
 * Per-entity runtime state for a driveable's shaped collision hull.
 *
 * <p>Entities treat the hull as solid during their own movement (see
 * {@link DriveableCollisionWorld}), so standing on and walking into a hull
 * behave like terrain. What movement cannot know is that the hull itself moves:
 * each tick this helper poses the hull, carries entities that were standing on
 * it along with it, and pushes out entities it moved into. Candidate discovery
 * is a bounded spatial query and never scans the world's loaded-entity list.</p>
 */
public final class DriveableCollisionHelper
{
    private static final int MAX_CANDIDATES = 128;
    private static final double MAX_QUERY_RADIUS = 96D;
    private static final double QUERY_MARGIN = 1D;
    private static final double MAX_PLATFORM_DELTA = 3D;
    private static final double MAX_SEPARATION_PER_TICK = 0.75D;
    private static final double SEPARATION_THRESHOLD = 1.0E-3D;
    private static final double SEPARATION_SKIN = 1.0E-4D;

    private final DriveableCollisionProfile profile;
    private final DriveableHullGeometry geometry;
    private final double[] boundsScratch = new double[6];
    private final double[] vectorScratch = new double[4];
    @Nullable
    private Driveable owner;
    @Nullable
    private DriveableCollisionWorld.LevelHulls registry;
    private int lastTick = Integer.MIN_VALUE;
    private double lastX;
    private double lastY;
    private double lastZ;

    public DriveableCollisionHelper(DriveableCollisionProfile profile)
    {
        this.profile = profile == null ? DriveableCollisionProfile.compile(null) : profile;
        geometry = new DriveableHullGeometry(this.profile);
    }

    public boolean matches(DriveableCollisionProfile candidate)
    {
        return profile == candidate;
    }

    public boolean hasGeometry()
    {
        return !profile.isEmpty();
    }

    DriveableHullGeometry geometry()
    {
        return geometry;
    }

    @Nullable
    Driveable owner()
    {
        return owner;
    }

    public void tick(Driveable driveable)
    {
        if (driveable == null || driveable.isRemoved() || profile.isEmpty())
            return;
        DriveableType type = driveable.getConfigType();
        if (type == null)
            return;

        owner = driveable;
        boolean continuous = lastTick == driveable.tickCount - 1
            && squaredDistance(lastX, lastY, lastZ, driveable.getX(), driveable.getY(), driveable.getZ())
                <= MAX_PLATFORM_DELTA * MAX_PLATFORM_DELTA;
        lastTick = driveable.tickCount;
        lastX = driveable.getX();
        lastY = driveable.getY();
        lastZ = driveable.getZ();
        geometry.update(driveable.getX(), driveable.getY(), driveable.getZ(), driveable.getYaw(),
            driveable.getPitch(), driveable.getRoll(), driveable.getTurretYaw(), driveable.getTurretPitch(),
            driveable.getCollisionTurretPivot(), driveable.getCollisionTurretOffset(), driveable::isPartIntact,
            continuous);
        register(driveable.level());
        if (!geometry.queryBounds(boundsScratch))
            return;

        double minX = Math.max(boundsScratch[0], driveable.getX() - MAX_QUERY_RADIUS);
        double minY = Math.max(boundsScratch[1], driveable.getY() - MAX_QUERY_RADIUS);
        double minZ = Math.max(boundsScratch[2], driveable.getZ() - MAX_QUERY_RADIUS);
        double maxX = Math.min(boundsScratch[3], driveable.getX() + MAX_QUERY_RADIUS);
        double maxY = Math.min(boundsScratch[4], driveable.getY() + MAX_QUERY_RADIUS);
        double maxZ = Math.min(boundsScratch[5], driveable.getZ() + MAX_QUERY_RADIUS);
        if (minX > maxX || minY > maxY || minZ > maxZ)
            return;

        Level level = driveable.level();
        boolean clientSide = level.isClientSide;
        AABB query = new AABB(minX, minY, minZ, maxX, maxY, maxZ).inflate(QUERY_MARGIN);
        List<Entity> candidates = level.getEntities(driveable, query,
            candidate -> DriveableCollisionWorld.collidesWithHulls(candidate) && !driveable.isPartOfThis(candidate)
                && (!clientSide || DriveableCollisionWorld.isSimulatedHere(candidate)));
        int count = Math.min(MAX_CANDIDATES, candidates.size());
        for (int index = 0; index < count; index++)
            handleCandidate(driveable, type, candidates.get(index));
    }

    /** Stops entities colliding with this hull, for a driveable leaving its level. */
    public void unregister()
    {
        if (registry != null)
            registry.remove(this);
        registry = null;
    }

    void forgetRegistry()
    {
        registry = null;
    }

    private void register(Level level)
    {
        DriveableCollisionWorld.LevelHulls hulls = DriveableCollisionWorld.hulls(level);
        if (hulls == registry)
            return;
        unregister();
        if (hulls != null)
        {
            hulls.add(this);
            registry = hulls;
        }
    }

    private void handleCandidate(Driveable driveable, DriveableType type, Entity entity)
    {
        // Players are simulated by their own client, against the hull pose it sees.
        boolean simulated = DriveableCollisionWorld.isSimulatedHere(entity);
        AABB box = entity.getBoundingBox();
        if (simulated)
        {
            int support = geometry.findSupport(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
            if (support >= 0)
            {
                carry(entity, support);
                box = entity.getBoundingBox();
                if (geometry.findPenetration(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ, true,
                    vectorScratch) && vectorScratch[3] > SEPARATION_THRESHOLD)
                    separate(entity, vectorScratch);
                return;
            }
        }

        if (!geometry.findPenetration(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ, false,
            vectorScratch) || vectorScratch[3] <= SEPARATION_THRESHOLD)
            return;
        if (simulated)
            separate(entity, vectorScratch);
        if (!driveable.level().isClientSide && entity instanceof LivingEntity living
            && Math.abs(vectorScratch[1]) < 0.6D)
            applyConfiguredImpactDamage(driveable, type, living);
    }

    /** Moves an entity with the surface it stood on, turning it with the hull as well. */
    private void carry(Entity entity, int shape)
    {
        AABB box = entity.getBoundingBox();
        double footX = (box.minX + box.maxX) * 0.5D;
        double footY = box.minY;
        double footZ = (box.minZ + box.maxZ) * 0.5D;
        if (!geometry.carryPoint(shape, footX, footY, footZ, vectorScratch))
            return;
        double deltaX = vectorScratch[0] - footX;
        double deltaY = vectorScratch[1] - footY;
        double deltaZ = vectorScratch[2] - footZ;
        double lengthSquared = deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
        if (!(lengthSquared <= MAX_PLATFORM_DELTA * MAX_PLATFORM_DELTA))
            return;
        if (lengthSquared > 1.0E-12D)
            DriveableCollisionWorld.moveIgnoringHulls(entity, deltaX, deltaY, deltaZ);
        float yaw = geometry.carryYaw(shape);
        if (Math.abs(yaw) > 1.0E-3F)
        {
            entity.setYRot(entity.getYRot() + yaw);
            entity.setYHeadRot(entity.getYHeadRot() + yaw);
            if (entity instanceof LivingEntity living)
                living.yBodyRot += yaw;
        }
        entity.resetFallDistance();
    }

    private static void separate(Entity entity, double[] push)
    {
        double distance = Math.min(MAX_SEPARATION_PER_TICK, push[3] + SEPARATION_SKIN);
        DriveableCollisionWorld.moveIgnoringHulls(entity, push[0] * distance, push[1] * distance, push[2] * distance);
        Vec3 motion = entity.getDeltaMovement();
        double into = motion.x * push[0] + motion.y * push[1] + motion.z * push[2];
        if (into < 0D)
            entity.setDeltaMovement(motion.x - push[0] * into, motion.y - push[1] * into, motion.z - push[2] * into);
        if (push[1] >= DriveableHullGeometry.MIN_SUPPORT_NORMAL_Y)
        {
            entity.setOnGround(true);
            entity.resetFallDistance();
        }
    }

    private static void applyConfiguredImpactDamage(Driveable driveable, DriveableType type, LivingEntity candidate)
    {
        float throttle = Math.abs(driveable.getThrottle());
        if (!type.isCollisionDamageEnable() || throttle <= Math.max(0F, type.getCollisionDamageThrottle())
            || !canDamageCandidate(driveable, candidate))
            return;
        float amount = throttle * Math.max(0F, type.getCollisionDamageTimes());
        if (amount <= 0F)
            return;
        Entity controller = driveable.getControllingEntity();
        DamageSource source = controller instanceof Player player
            ? driveable.level().damageSources().playerAttack(player)
            : controller instanceof LivingEntity living
                ? driveable.level().damageSources().mobAttack(living)
                : driveable.level().damageSources().flyIntoWall();
        candidate.hurt(source, amount);
    }

    private static boolean canDamageCandidate(Driveable driveable, LivingEntity candidate)
    {
        Entity controller = driveable.getControllingEntity();
        if (controller == null)
            return true;
        if (candidate instanceof ServerPlayer victim && controller instanceof ServerPlayer attacker)
        {
            try
            {
                return FlansMod.teamsManager.getCurrentGameType()
                    .map(gameType -> gameType.canPlayerBeAttacked(victim, attacker))
                    .orElseGet(() -> !victim.isAlliedTo(attacker));
            }
            catch (RuntimeException ignored)
            {
                // Teams state is optional outside an active server round.
            }
        }
        return !candidate.isAlliedTo(controller) && !controller.isAlliedTo(candidate);
    }

    private static double squaredDistance(double ax, double ay, double az, double bx, double by, double bz)
    {
        double x = ax - bx;
        double y = ay - by;
        double z = az - bz;
        return x * x + y * y + z * z;
    }
}
