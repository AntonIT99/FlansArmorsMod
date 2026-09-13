# Feature gap analysis: Flan's Mod 5.10.0 (1.12.2) → Ultimate 2.0

Initial audit: 2026-09-12. Last updated: 2026-09-13. Direction is strictly reference → target.

- Reference: `C:/Users/alpha/Documents/Minecraft-Development/FlansMod`, Flan's Mod 5.10.0 / MC 1.12.2, HEAD `71ba7ed065d906d48f34ca471bbd0172b5192f6b`.
- Target: `C:/Users/alpha/Documents/Minecraft-Development/Flans-Mod-Ultimate-2.0`, Forge 1.20.1, HEAD `c7af2b0fb3cb85711796129fec789c51e96b999e` (clean tree).
- Remaining: **2 MISSING, 3 PARTIAL, 0 UNCERTAIN**. These counts describe the findings below, not a percentage of port completeness.
- Completed findings are removed as they are implemented, so this stays a backlog rather than a historical snapshot. The initial audit found 7 MISSING and 4 PARTIAL; the six Apocalypse findings were implemented on 2026-09-13.

## Scope and evidence conventions

This is a static, reference-driven semantic audit. Discovery walked the reference subsystem by subsystem: content loading and type definitions, handheld guns/ammunition/attachments/grenades, shooting, raytracing and penetration, deployed MGs and AA guns, driveables (planes, vehicles, mechas, seats, wheels, collisions, fuel, repair), tools and armor, enchantments, paintjobs, gun/armor boxes, workbenches and item holders, teams (gametypes, maps, rounds, rotations, bases, spawners, flags, loadout pools, ranks, reward boxes, op sticks, commands), client input/HUD/camera/rendering, networking, sounds and particles, world/loot injection, and the bundled sub-mods (apocalypse, and the pack mods).

For each candidate the reference call sites and data flow were traced, then the target was searched for direct, renamed, componentized, data-driven or newer-mechanism equivalents (Lombok accessors, mixins, datapacks, capability APIs and config snapshots included). Commented-out reference implementations (`MovingSoundDriveable`, `CommonProxy.playBlockBreakSound`, spawner chunk-loading) and reference-side dead fields were excluded. Definition-parameter parity is out of scope here — it is covered by `reports/infotype-parameter-gap-analysis-1.12.2.md`.

Evidence paths use these roots:

- `R/` = reference `src/main/java/com/flansmod`.
- `T/` = target `src/main/java/com/flansmodultimate`.
- Resource paths explicitly identify their repository.

`MISSING` means the described capability has no equivalent in the inspected target paths. `PARTIAL` means the broader mechanic exists but the stated behavior does not. Confidence concerns the narrow finding, not full subsystem equivalence. The audit itself changed nothing; the Apocalypse findings were implemented separately afterwards and removed from this backlog.

Large, well-ported areas that produced no findings are deliberately not enumerated. Notable examples verified as present: mecha upgrade behaviors (including diamond detection, auto-repair, ore multipliers, rocket pack, item vacuum, waste compaction, forced light level), grenade behaviors (proximity triggers, stickiness, deployable bags, smoke/potion effects, heal amounts), AA gun and deployed-MG mechanics, CTF flag handling, smart weapon drops with ammo consolidation, team spawner vehicle/item spawning, dungeon-loot injection, creative paintjob variants, gun attribute modifiers, flashlight attachments, and the Mecha Parts pack contents (folded into the target's Titan pack).

## Teams

### Server message of the day — MISSING

Reference: `R/common/teams/TeamsManager.java:155`, `R/common/teams/CommandTeams.java:100-113`, `R/common/teams/TeamsManagerRanked.java:119`, `R/common/network/PacketLoadoutData.java:21,34,49,105`, `R/client/teams/ClientTeamsData.java:40`, `R/client/gui/teams/GuiLandingPage.java:136`.
The teams server carries a settable MOTD (default "Welcome to the Teams server"), changed or printed with `/teams motd [text …]`, sent to clients with the loadout data and drawn as the header of the loadout landing page.

Target checked: `T/common/teams/TeamsManager.java` (full NBT key inventory at `:54-90`), `T/common/command/TeamsCommand.java` (full literal inventory), `T/network/client/PacketLoadoutState.java`, `T/client/gui/TeamsLoadoutHubScreen.java`, `T/client/teams/TeamsClientState.java`.
A case-insensitive search for `motd` across the target's Java and resources returns nothing: no stored setting, no command branch, no networked field and no header on the loadout hub.

Missing: The configurable teams MOTD, its command, and its display on the loadout hub.

### Separate rank-update intermission stage — PARTIAL

Reference: `R/common/teams/TeamsManager.java:102,308,1313,1378`, `R/common/teams/CommandTeams.java:677-685`, `R/common/teams/RoundFinishedData.java:27-29`, `R/common/teams/TeamsManagerRanked.java:225-235`, `R/client/teams/ClientTeamsData.java:42-90,147-152`.
The end of a round runs three timed stages in sequence — `SCORES` (scoreboard, `scoreDisplayTime`), then `RANK_UPDATE` (XP/rank results, `rankUpdateTime`, set by `/teams rankUpdateTime <seconds>` and persisted in NBT), then `VOTING` (`votingTime`) — with the inter-round time budgeted as `scoreDisplayTime + rankUpdateTime` plus voting.

Target checked: `T/common/teams/TeamsManager.java:177,184,537-620` (`intermissionTicks`, `intermissionVotingPhase`, `advanceIntermission`, `openScoreDisplay`), `T/client/gui/TeamsMissionResultsScreen.java`, `T/client/gui/TeamsScoreScreen.java`, `T/common/command/TeamsCommand.java`.
The target implements exactly two intermission phases, score display and voting. Both the scoreboard and the rank/XP screen exist, but they share the single `scoreDisplayTime` window and are mutually exclusive: `TeamsManager:584-588` opens `MISSION_RESULTS` when a loadout pool is active and `SCOREBOARD` otherwise. There is no `rankUpdateTime` setting or command.

Missing: The dedicated, separately configurable rank-update stage, and therefore the ability to show the scoreboard and the rank results one after the other in a ranked round.

### Mid-round team switching consequences — PARTIAL

Reference: `R/common/teams/TeamsManager.java#playerSelectedClass` lines 1058-1131, `Gametype#playerDefected`/`#playerChoseNewClass` (`R/common/teams/Gametype.java`).
Confirming a class selection resolves into three cases. Switching team while alive broadcasts "<name> switched to <team>", notifies the gametype through `playerDefected`, sets the next spawn point, and kills the player immediately (`attackEntityFrom(GENERIC, 10000F)`) so the change takes effect at once. Changing only the class on the same team notifies `playerChoseNewClass` and tells the player "You will respawn with the <class> class".

Target checked: `T/common/teams/TeamsManager.java#selectTeam` (`:684-705`), `#selectClass` (`:723-735`), `#applyPendingTeamSelection` in `T/common/PlayerData.java`, `T/network/server/PacketTeamsAction.java`, `T/common/teams/GameType.java` (hook inventory).
Selection is stored as `newTeam`/`newPlayerClass` and applied on the next death or respawn. Searching the teams package for a defection kill, a "switched to" broadcast or a "will respawn with" message returns nothing, and `GameType` exposes no `playerDefected`/`playerChoseNewClass` hook. The autobalancer does force a respawn (`autoBalanceIfNeeded`), but only for players it moves itself.

Missing: The immediate self-kill on voluntary mid-round defection, the public switch announcement, the player-facing class-change confirmation, and the gametype notifications for both events.

### Op stick connection line feedback — PARTIAL

Reference: `R/common/teams/EntityConnectingLine.java`, spawned by `R/common/teams/ItemOpStick.java:98,103-105,152,157-159`.
While the Stick of Connecting holds a selected base or team object, a fishing-line entity is anchored to it and rendered from the player, so the pending connection is visible until the second click completes or clears it.

Target checked: `T/common/item/ItemOpStick.java` (`OWNERSHIP`/`CONNECTING`/`MAPPING`/`DESTRUCTION` modes at `:38-41`, `connect`/`clearConnection` at `:142-186`), `T/client/render/entity/TeamObjectRenderer.java`, `T/client/gui/TeamsBaseEditScreen.java`.
All four stick modes work and the pending selection is stored on the stack, but a repository-wide search for a connecting-line entity or equivalent world-space link renderer returns nothing; the only feedback is chat text.

Missing: The in-world visual line showing which base or object the connecting stick currently has selected.

## Driveables

### Fluid-bucket refueling — MISSING

Reference: `R/common/FlansHooks.java`, `R/common/driveables/EntityDriveable.java:1210-1224`.
When BuildCraft Energy is present, an oil bucket in a driveable's fuel slot adds 1000 × fuel multiplier and a fuel bucket adds 2000 × fuel multiplier to the tank, leaving an empty bucket behind.

Target checked: `T/common/entity/Driveable.java:3398` (fuel consumption accepts only `PartType.Category.FUEL` part items) and `:3428` plus `T/common/driveables/DriveableData.java:280` (a Forge Energy path for RF-capable items), `T/common/inventory/DriveableInventoryMenu.java`, `T/client/gui/DriveableInventoryScreen.java` fuel page.
The target refuels from fuel parts and charges from `ForgeCapabilities.ENERGY` items. There is no bucket or fluid handling of any kind — no `FluidUtil`, `IFluidHandler` or bucket-item branch — so no liquid fuel can be poured into a tank.

Missing: Refueling a driveable from a liquid-fuel bucket. (BuildCraft itself has no 1.20.1 counterpart; the equivalent modern path would be a Forge fluid-capability branch alongside the existing energy branch.)

## Summary

| Subsystem | Feature | Status | Confidence |
| --------- | ------- | ------ | ---------- |
| Teams | Server MOTD and `/teams motd` | MISSING | HIGH |
| Teams | Separate rank-update intermission stage | PARTIAL | HIGH |
| Teams | Mid-round defection kill, broadcast and class feedback | PARTIAL | HIGH |
| Teams | Op stick connection line feedback | PARTIAL | MEDIUM |
| Driveables | Fluid-bucket refueling | MISSING | HIGH |

## Areas requiring deeper audit

- **Apocalypse structure interiors.** The target rebuilds the reference's `common/world/buildings/*` generators procedurally rather than porting them. The research lab and the village were compared closely; the dye factory, runway, boss pillar, dead tree, skeleton display and abandoned-portal generators were read at call-site level only, so smaller content differences (block palettes, loot placement, secondary rooms, spawned props) may remain inside each.
- **Apocalypse mob AI.** `SurvivorEntity`, `SkullBossEntity` and `SkullDroneEntity` exist in the target, but their goal sets were not diffed against `EntitySurvivor`, `EntitySkullBoss` and `EntitySkullDrone`, nor against `EntityAIGoSomewhere`. `EntitySkuller` was excluded because it is never registered in the reference.
- **Apocalypse terrain shape.** The implemented dimension keeps the vanilla overworld noise router and supplies its own biomes, climate placement and surface rules on top. That reproduces the reference's biome set, its canyon-low/plateau-high ordering and its red-sand wasteland surface, but not the 1.12.2 chunk provider's exact per-biome base heights, which have no direct equivalent in 1.18+ terrain generation.
- **Driveable flight and ground physics.** The target replaced the reference's per-tick math with a `common/driveables/physics/**` model (`LegacyPlanePhysics`, `AircraftPerformancePhysics`, `SuspensionPhysics`, `MarineDraftPhysics`, …). Every reference `type.*` field consumed by `EntityPlane`/`EntityVehicle` has a target consumer, but numeric handling parity was not established and can only be judged in play.
- **Teams gametype hook surface.** The reference `Gametype` exposes hooks the target's `GameType` does not (`baseAttacked`, `objectAttacked`, `entityKilled`, `playerJoined`, `playerQuit`, `playerRespawned`, `roundCleanup`, `getTeamsCanSpawnAs`, `givePoints`). In the shipped gametypes most of these bodies are empty and the non-empty ones were traced to target equivalents in `TeamsManager`, but a third-party gametype extending the reference class would have less to override.
- **Content-pack Java model classes.** The reference ships pack models as compiled classes inside the mod jar (`R/modernweapons/**`, `R/titan/**`, `R/nerf/**`); the target compiles pack-supplied Java models at load time (`T/util/JavaModelCompiler.java`, `ContentPackClassLoader`). Coverage of individual legacy model classes and their animation fields was not enumerated here.
