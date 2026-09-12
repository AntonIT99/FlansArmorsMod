# Feature gap analysis: Flan's Mod 5.10.0 (1.12.2) → Ultimate 2.0

Audit date: 2026-09-12. Direction is strictly reference → target.

- Reference: `C:/Users/alpha/Documents/Minecraft-Development/FlansMod`, Flan's Mod 5.10.0 / MC 1.12.2, HEAD `71ba7ed065d906d48f34ca471bbd0172b5192f6b`.
- Target: `C:/Users/alpha/Documents/Minecraft-Development/Flans-Mod-Ultimate-2.0`, Forge 1.20.1, HEAD `c7af2b0fb3cb85711796129fec789c51e96b999e` (clean tree).
- Result: **7 MISSING, 4 PARTIAL, 0 UNCERTAIN**. These counts describe the findings below, not a percentage of port completeness.

## Scope and evidence conventions

This is a static, reference-driven semantic audit. Discovery walked the reference subsystem by subsystem: content loading and type definitions, handheld guns/ammunition/attachments/grenades, shooting, raytracing and penetration, deployed MGs and AA guns, driveables (planes, vehicles, mechas, seats, wheels, collisions, fuel, repair), tools and armor, enchantments, paintjobs, gun/armor boxes, workbenches and item holders, teams (gametypes, maps, rounds, rotations, bases, spawners, flags, loadout pools, ranks, reward boxes, op sticks, commands), client input/HUD/camera/rendering, networking, sounds and particles, world/loot injection, and the bundled sub-mods (apocalypse, and the pack mods).

For each candidate the reference call sites and data flow were traced, then the target was searched for direct, renamed, componentized, data-driven or newer-mechanism equivalents (Lombok accessors, mixins, datapacks, capability APIs and config snapshots included). Commented-out reference implementations (`MovingSoundDriveable`, `CommonProxy.playBlockBreakSound`, spawner chunk-loading) and reference-side dead fields were excluded. Definition-parameter parity is out of scope here — it is covered by `reports/infotype-parameter-gap-analysis-1.12.2.md`.

Evidence paths use these roots:

- `R/` = reference `src/main/java/com/flansmod`.
- `T/` = target `src/main/java/com/flansmodultimate`.
- Resource paths explicitly identify their repository.

`MISSING` means the described capability has no equivalent in the inspected target paths. `PARTIAL` means the broader mechanic exists but the stated behavior does not. Confidence concerns the narrow finding, not full subsystem equivalence. Nothing was modified in either repository, and no builds or in-game tests were run.

Large, well-ported areas that produced no findings are deliberately not enumerated. Notable examples verified as present: mecha upgrade behaviors (including diamond detection, auto-repair, ore multipliers, rocket pack, item vacuum, waste compaction, forced light level), grenade behaviors (proximity triggers, stickiness, deployable bags, smoke/potion effects, heal amounts), AA gun and deployed-MG mechanics, CTF flag handling, smart weapon drops with ammo consolidation, team spawner vehicle/item spawning, dungeon-loot injection, creative paintjob variants, gun attribute modifiers, flashlight attachments, and the Mecha Parts pack contents (folded into the target's Titan pack).

## Apocalypse: the apocalypse event

### AI-chip mecha apocalypse trigger sequence — MISSING

Reference: `R/apocalypse/common/CommonProxyApocalypse.java#itemPlaced` and `#serverTick` (lines 85-137, 208-226), `R/apocalypse/common/FlansModApocalypse.java:87,114,342,353,365`, `R/apocalypse/common/network/PacketApocalypseCountdown.java`, `R/apocalypse/common/entity/EntityNukeDrop.java`.
Spawning a mecha in the overworld whose engine part has `IsAIChip` starts a server-side countdown (`Apocalypse Countdown Length`, default 469 ticks), which is pushed to the placer's HUD. During the countdown the mecha's head sweeps randomly and a nuke is dropped every 20 ticks within a 150-block radius. When the countdown expires the mecha is removed and players are transferred to the apocalypse dimension according to the configurable `Option` (`PLACER_ONLY`, `DIM`, `DIM_OPT_IN`, `NEARBY`, `NEARBY_OPT_IN`).

Target checked: `T/apocalyse/ApocalypseContent.java`, `T/apocalyse/event/handler/CommonEventHandler.java`, `T/apocalyse/common/world/ApocalypsePortalManager.java`, `T/apocalyse/common/world/ApocalypseBossFightManager.java`, `T/config/ModApocalypseConfig.java`, `T/common/types/PartType.java:72,92`.
`PartType.aiChip` is parsed and is read only by `T/apocalyse/common/util/ApocalypseLoot.java:127` to *exclude* AI chips from loot. `ModApocalypseConfig.APOCALYPSE_COUNTDOWN_LENGTH` is declared, config-synced and exposed by `apocalypseCountdownLength()`, but no code reads that accessor — the value is dead. `NukeDropEntity` exists but is only summoned by `SkullBossEntity#callNukeDrop`. Dimension entry in the target happens solely through the teleporter/portal blocks. No countdown, no countdown HUD packet, and no teleport-option setting were found.

Missing: The entire AI-chip-triggered apocalypse event — countdown with client HUD, the nuke barrage, and the configurable mass transfer of players to the apocalypse dimension.

### Dimension entry: inventory holder and starter kit — MISSING

Reference: `R/apocalypse/common/CommonProxyApocalypse.java#sendPlayerToApocalypse` (lines 208-226) and `#giveStarterKit` (lines 228-235), `R/apocalypse/common/entity/EntityFakePlayer.java`, `R/apocalypse/client/model/RenderFakePlayer.java`.
Being sent to the apocalypse spawns an `EntityFakePlayer` copy at the departure point that holds the player's inventory until they return, clears the real inventory, and grants a starter kit (stone pickaxe, stone shovel, 8 logs, 4 cooked beef).

Target checked: `T/apocalyse/common/world/ApocalypsePortalManager.java#teleportPlayer`, `T/apocalyse/common/world/ApocalypseSavedData.java`, `T/apocalyse/event/handler/CommonEventHandler.java`, `T/ApocalypseContent.java` entity registry.
`teleportPlayer` records the entry point and teleports the player with their inventory untouched; there is no fake-player entity registered, no inventory stripping and no starter kit anywhere in the target.

Missing: Inventory confiscation into a persistent stand-in entity on entry, and the survival starter kit.

### Fly-by planes with skeleton pilots — MISSING

Reference: `R/apocalypse/common/CommonProxyApocalypse.java` lines 148-187, `R/apocalypse/common/entity/EntityFlyByPlane.java`, `R/apocalypse/common/FlansModLootGenerator.java` (`getRandomPlane`, `getRandomEngine`), registered at `R/apocalypse/common/FlansModApocalypse.java:321,330`.
Roughly once every 5000 player-ticks in the apocalypse dimension, a randomly chosen plane type with a random engine spawns 200 blocks away at Y=120 at full throttle, oriented toward the player, with a skeleton seated in the pilot seat.

Target checked: `T/apocalyse/event/handler/CommonEventHandler.java` (the per-player server tick, which handles only wandering survivors), `T/apocalyse/common/util/ApocalypseLoot.java`, `T/apocalyse/ApocalypseContent.java`, plus a repository-wide search for `flyby`/`fly_by` (only `Bullet#playFlybyIfClose`, an unrelated bullet whizz sound).
No ambient aircraft spawning exists in the target.

Missing: Periodic hostile-atmosphere plane flyovers in the apocalypse dimension.

### AI-piloted guard mechas in apocalypse structures — MISSING

Reference: `R/apocalypse/common/entity/EntityAIMecha.java` (registered at `R/apocalypse/common/FlansModApocalypse.java:318,327`), spawned by `R/apocalypse/common/world/buildings/WorldGenResearchLab.java:290-306` and `R/apocalypse/common/world/buildings/WorldGenAbandonedPortal.java`.
Research labs and abandoned portals are guarded by autonomous mechas that run at full throttle, acquire a target within 20 blocks every 40 ticks, and fire the random guns placed in their left/right tool slots, with matching ammunition stocked in their cargo slots.

Target checked: `T/apocalyse/common/world/ApocalypseWorldgen.java#generateResearchLab` (`:209-215`) and `#generateBossPillar`, `T/apocalyse/common/world/ApocalypsePortalManager.java#createPortal`, `T/common/entity/Mecha.java`, `T/apocalyse/ApocalypseContent.java`.
The target's research lab is a plain 7×4×7 lab-stone room with two loot chests and one gun rack; portals are bare frames. A repository-wide search for `aimecha`/`ai_mecha` returns nothing — no autonomous mecha entity or mecha AI exists.

Missing: Autonomous armed mecha guards and the structure population that places them.

### Apocalypse biomes and terrain generation — PARTIAL

Reference: `R/apocalypse/common/world/BiomeApocalypse.java:17-28`, `BiomeDesertCanyon.java`, `BiomeSulphurPits.java`, `BiomeProviderApocalypse.java`, `GenLayerApocalypse.java`, `GenLayerBiomes.java`, `ChunkProviderApocalypse.java`, `BiomeDecoratorApocalypse.java`, `WorldProviderApocalypse.java`.
The dimension is built from six purpose-made biomes (Deep Canyon, Canyon, Desert, Plateau, High Plateau, Sulphur Pits) at fixed base heights from -1.8 to 2.5 with no height variation and rain disabled, laid out by a custom `GenLayer` chain of common/rare biomes, rendered by a bespoke chunk provider with red-sand surfaces, and decorated per biome (sulphur lakes only in Sulphur Pits). Structure placement is biome-gated — runways and research labs only spawn on High Plateau (`ChunkProviderApocalypse.java:74,77`).

Target checked: `src/main/resources/datapacks/apocalypse/data/flansmodapocalypse/dimension/apocalypse.json`, `.../worldgen/biome/apocalypse.json`, `.../dimension_type/apocalypse.json`, `T/apocalyse/ApocalypseDatapackSource.java`, `T/apocalyse/common/world/ApocalypseWorldgen.java`.
The dimension exists and is themed (custom sky/fog/grass colors, no precipitation, no vanilla spawners or features), and the scattered decorations are reproduced procedurally in `ApocalypseWorldgen`. But the generator is `minecraft:noise` with the unmodified `minecraft:overworld` noise settings over a `minecraft:fixed` biome source pinned to one biome, so terrain shape and surface blocks are vanilla overworld.

Missing: The multiple canyon/plateau/sulphur biomes with their own base heights and surface blocks, the biome layout layer, the wasteland terrain shape, biome-specific decoration, and biome-gated structure placement.

### Abandoned villages and road networks — MISSING

Reference: `R/apocalypse/common/world/buildings/MapGenAbandonedVillage.java`, `StructureAbandonedVillagePieces.java`, `WorldGenRoads.java`, wired into `R/apocalypse/common/world/ChunkProviderApocalypse.java:59,71,227`.
The apocalypse chunk generator places ruined villages during chunk generation and lays a road network across the wasteland.

Target checked: `T/apocalyse/common/world/ApocalypseWorldgen.java#generate` (the complete feature list: sulphur pools, dead trees, skeleton displays, portals, research labs, dye factories, runways, abandoned vehicles, boss pillars, survivors), and the apocalypse datapack, whose biome declares `"features": []`.
Neither villages nor roads appear in the target's generation list, and there are no structure or feature JSONs for them.

Missing: Abandoned-village structures and generated road networks in the apocalypse dimension.

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
| Apocalypse | AI-chip mecha apocalypse trigger sequence | MISSING | HIGH |
| Apocalypse | Dimension-entry inventory holder and starter kit | MISSING | HIGH |
| Apocalypse | Fly-by planes with skeleton pilots | MISSING | HIGH |
| Apocalypse | AI-piloted guard mechas in structures | MISSING | HIGH |
| Apocalypse | Custom biomes and wasteland terrain generation | PARTIAL | HIGH |
| Apocalypse | Abandoned villages and road networks | MISSING | HIGH |
| Teams | Server MOTD and `/teams motd` | MISSING | HIGH |
| Teams | Separate rank-update intermission stage | PARTIAL | HIGH |
| Teams | Mid-round defection kill, broadcast and class feedback | PARTIAL | HIGH |
| Teams | Op stick connection line feedback | PARTIAL | MEDIUM |
| Driveables | Fluid-bucket refueling | MISSING | HIGH |

## Areas requiring deeper audit

- **Apocalypse structure interiors.** The target rebuilds the reference's `common/world/buildings/*` generators procedurally rather than porting them. Only the research lab was compared closely (finding above); the dye factory, runway, boss pillar, dead tree, skeleton display and abandoned-portal generators were read at call-site level only, so smaller content differences (block palettes, loot placement, secondary rooms, spawned props) may remain inside each.
- **Apocalypse mob AI.** `SurvivorEntity`, `SkullBossEntity` and `SkullDroneEntity` exist in the target, but their goal sets were not diffed against `EntitySurvivor`, `EntitySkullBoss` and `EntitySkullDrone`, nor against `EntityAIGoSomewhere`. `EntitySkuller` was excluded because it is never registered in the reference.
- **Driveable flight and ground physics.** The target replaced the reference's per-tick math with a `common/driveables/physics/**` model (`LegacyPlanePhysics`, `AircraftPerformancePhysics`, `SuspensionPhysics`, `MarineDraftPhysics`, …). Every reference `type.*` field consumed by `EntityPlane`/`EntityVehicle` has a target consumer, but numeric handling parity was not established and can only be judged in play.
- **Teams gametype hook surface.** The reference `Gametype` exposes hooks the target's `GameType` does not (`baseAttacked`, `objectAttacked`, `entityKilled`, `playerJoined`, `playerQuit`, `playerRespawned`, `roundCleanup`, `getTeamsCanSpawnAs`, `givePoints`). In the shipped gametypes most of these bodies are empty and the non-empty ones were traced to target equivalents in `TeamsManager`, but a third-party gametype extending the reference class would have less to override.
- **Content-pack Java model classes.** The reference ships pack models as compiled classes inside the mod jar (`R/modernweapons/**`, `R/titan/**`, `R/nerf/**`); the target compiles pack-supplied Java models at load time (`T/util/JavaModelCompiler.java`, `ContentPackClassLoader`). Coverage of individual legacy model classes and their animation fields was not enumerated here.
