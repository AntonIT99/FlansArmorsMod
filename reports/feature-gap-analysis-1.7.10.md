# Feature gap analysis: Ultimate 1.7.10 → Ultimate 2.0

Initial audit: 2026-09-10. Last updated: 2026-09-12. Direction is strictly reference → target.

- Reference: `C:/Users/alpha/Documents/Minecraft-Development/Flans-Mod-Ultimate-1.7.10`, HEAD `9b669b12149c3c9fa3a69f1a4ac5d8a55367506d`.
- Target initially audited: `C:/Users/alpha/Documents/Minecraft-Development/Flans-Mod-Ultimate-2.0`, HEAD `08494f8a4972c249feb4e7d8522e981547439c4e`.
- Sources inspected were the current working trees, not pristine commit snapshots. Existing staged reference texture deletions and the target's unrelated `warfare44/pack_names.json` change were left untouched.
- Completed findings are removed as they are implemented, so the report remains a backlog rather than a historical snapshot.
- Remaining: **7 MISSING, 7 PARTIAL, 0 UNCERTAIN**. These counts describe the findings below, not a percentage of port completeness.

## Scope and evidence conventions

This is a static, reference-driven semantic audit. Discovery covered reference types and configuration keys, weapons and ammunition, grenades, deployable/AA guns and targeting, tools and armor, driveables/aircraft/mechas, controls, rendering and effects, teams/game modes, commands, inventories/crafting, persistence, and networking. Candidate gaps were traced to active reference callers and checked against target entities, handlers, parsers, menus, configuration, and replacement mechanisms. Commented-out implementations and unused reference declarations were excluded.

Evidence paths use these roots:

- `R/` = reference `../src/main/java/com/flansmod`.
- `T/` = target `../src/main/java/com/flansmodultimate`.
- Resource paths explicitly identify their repository.

`MISSING` means the described capability has no equivalent in the inspected target paths. `PARTIAL` means the broader mechanic exists but the stated option or secondary behavior does not. Confidence concerns the narrow finding, not full subsystem equivalence. No gameplay code, packs, wiki pages, or generated files were changed. No builds or in-game tests were run; runtime parity is not established by this report.

## Multiplayer compatibility

### Content-definition mismatch detection and optional disconnect — MISSING

Reference: `R/common/ContentManager.java` (`Sync.addHash`), `R/common/sync/Sync.java`, `R/common/sync/SyncEventHandler.java#playerJoined`, `R/common/network/PacketHashSend.java`.
Loaded definition text contributes normalized hashes. On dedicated-server login, the server sends its aggregate hash and the client replies with its own. With `kickNonMatchingHashes` enabled, the server disconnects a mismatching client. This checks normalized definitions, not byte-for-byte equality of all pack assets.

Target checked: `T/network/PacketHandler.java`, `T/event/handler/CommonEventHandler.java#onPlayerLogin`, `T/config/ModCommonConfigSync.java`, `T/network/client/PacketSyncCommonConfig.java`, `T/ContentManager.java`.
Configuration synchronization and protocol registration do not compare client/server content-definition hashes. ContentManager's file hashing concerns generated texture handling, not a login handshake. No definition fingerprint exchange or configurable mismatch disconnect was found.

Missing: Optional enforcement that clients and the server loaded matching content definitions.

## Armor and ambient mobs

### Random pack armor on naturally spawning zombies and skeletons — MISSING

Reference: `R/common/eventhandlers/LivingSpawnEventListener.java#onLivingSpecialSpawn`, registered in `R/common/FlansMod.java`.
The configured `armourSpawnRate` gates armor assignment to spawning zombies/skeletons. The handler chooses either a random eligible armor item or pieces from a random team outfit. Its legacy slot choices are part of the implementation; this finding does not assume it equips a complete modern armor set.

Target checked: `T/event/handler/CommonEventHandler.java`, `T/config/ModCommonConfig.java`, `T/common/types/ArmorType.java`, `T/common/types/Team.java`, and spawn-event/equipment searches across target Java sources.
There is no corresponding ambient spawn handler or armor-spawn probability setting. Apocalypse skeleton-display world generation does not equip naturally spawning mobs.

Missing: Configurable ambient zombie/skeleton equipment drawn from loaded armor and team definitions.

### Zero-enchantability armor's anvil restriction — PARTIAL

Reference: `R/common/eventhandlers/AnvilUpdateEventListener.java#onAnvilUsedEvent`, registered in `R/common/FlansMod.java`.
When global `armourEnchantability` is zero, an anvil operation with team armor on the left and a non-null right input is canceled. This is broader than merely preventing enchantment-table rolls.

Target checked: `T/common/item/CustomArmorItem.java#getEnchantmentValue`, `T/common/item/CustomArmorMaterial.java`, `T/config/ModCommonConfig.java`, and target event handlers.
The target exposes default/per-type enchantability but has no equivalent anvil cancellation handler or armor-specific anvil restriction. Returning zero enchantability does not reproduce the reference's explicit cancellation policy.

Missing: The global zero-enchantability rule blocking anvil operations with a second input. Exact vanilla anvil combinations should be verified in-game; source confidence is MEDIUM.

## Handheld weapons and inventory preferences

### Per-player reload inventory preferences — PARTIAL

Reference: `R/client/gui/GuiModOptions.java`, `R/client/FlansModClient.java` (reload preference setters), `R/client/KeyInputHandler.java`, `R/common/network/PacketReload.java`.
Players independently choose whether reloading combines damaged ammo and whether returned ammo goes to the upper inventory. Reload requests carry those choices; the normal client request also honors the server's allowance for combining ammo.

Target checked: `T/config/ModClientConfig.java`, `T/config/CommonConfigSnapshot.java`, `T/network/server/PacketGunReload.java`, `T/common/item/GunItemHandler.java#doPlayerReload`, `T/common/guns/reload/GunReloader.java`.
Combining ammo and upper-inventory placement exist, but `doPlayerReload` takes both choices from common configuration. The reload packet carries only the hand. No client preference or per-player override was found.

Missing: Independent player choices for these two reload behaviors, subject to server policy, including the reference's in-game preference controls.

### Configurable blocking of block interactions while holding guns — PARTIAL

Reference: `R/common/guns/ItemGun.java#onPlayerInteract`, registered through the first gun item in `R/common/FlansMod.java`; `holdingGunsDisablesChests` and `holdingGunsDisablesAll`.
Right-click block interaction can be canceled for inventory blocks specifically, or for all blocks, while holding a gun.

Target checked: `T/event/handler/ClientEventHandler.java` (interaction-key handler), `T/common/item/GunItem.java#use`, `T/common/item/GunItem.java#doesSneakBypassUse`, and common/client configuration.
Input suppression depends on the bound button, selected gun function, and hit result. Sneak bypass uses menu-provider detection. These mechanisms do not supply the two configurable reference policies and do not consistently apply a gun-held inventory-block/all-block rule.

Missing: Separate configurable inventory-block and all-block interaction suppression while armed.

## Vehicles, aircraft, and mechas

### BuildCraft oil/fuel bucket refueling — MISSING

Reference: `R/common/FlansHooks.java#hook`, called by `R/common/FlansMod.java`; `R/common/driveables/EntityDriveable.java` (BuildCraft bucket branches).
When BuildCraft Energy is installed, a non-electric engine can consume its oil/fuel bucket if the whole transfer fits. Oil adds 2,000 fuel units and fuel adds 4,000 with the reference multiplier, replacing the consumed stack with an empty bucket.

Target checked: `T/common/entity/Driveable.java#refuelFromInventory`, `#refuelFromEnergyItems`, `T/common/driveables/DriveableData.java`, and target-wide BuildCraft/fluid-capability searches.
Combustion refueling accepts Flan fuel parts. The Forge energy capability path serves electric engines and is not an oil/fuel fluid-container equivalent. No BuildCraft bucket mapping or general fluid-fuel adapter was found.

Missing: The reference's external oil/fuel-container integration. Availability of a compatible external mod on the target Minecraft version is outside this local source audit.

### Passenger guns functioning after their parent part is destroyed — PARTIAL

Reference: `R/common/driveables/EntitySeat.java#pressKey`, `R/common/FlansMod.java` (`gunsInDeadPartsWork`), `R/common/network/PacketModConfig.java`.
The optional global rule permits passenger-gun fire when its associated driveable part is no longer intact.

Target checked: `T/common/entity/Driveable.java#tickPassengerGuns`, `T/common/entity/Seat.java#tick`, and `T/config/CommonConfigSnapshot.java`.
The target always rejects passenger-gun fire on a destroyed part. Seat ticking also ejects passengers when their associated part is destroyed. No matching override exists.

Missing: The optional legacy behavior that keeps passenger weapons usable after destruction of their associated part.

### Driver-controlled vehicle zoom — MISSING

Reference: `R/common/driveables/EntityVehicle.java#pressKey` (key 5), `#resetZoom`, `R/common/teams/CommandTeams.java` (`vehiclesCanZoom`), `R/common/network/PacketTeamInfo.java`.
When the server permits it, a vehicle control toggles a narrow field of view and lower mouse sensitivity, with zoom reset support. This does not depend on holding a scoped gun.

Target checked: `T/common/entity/Vehicle.java`, `T/common/entity/Driveable.java`, `T/common/driveables/DriveableInput.java`, `T/client/input/KeyInputHandler.java`, `T/client/render/MountedCameraView.java`, `T/client/ModClient.java` (scope/FOV paths).
Mounted camera transforms and handheld scope zoom are implemented, but no equivalent vehicle-only zoom action or synchronized permission is present.

Missing: A vehicle driver's zoom toggle, sensitivity adjustment, and server enable/disable control. Restoring the behavior would not require copying the reference's hardcoded default FOV restoration.

## Teams and administration

### Separate, configurable results and voting phases — PARTIAL

Reference: `R/common/teams/TeamsManager.java#tick`, `#displayScoreboardGUI`, `#displayVotingGUI`, world save/load methods; `R/common/teams/CommandTeams.java` (`scoreDisplayTime`, `votingTime`).
Round completion first displays results, then opens voting after the results interval. Administrators can set both durations independently, and those durations are persisted as `ScoreTime` and `VotingTime`.

Target checked: `T/common/teams/TeamsManager.java#finishRound`, `#tick`, saved runtime state, `T/common/command/TeamsCommand.java`, `T/common/teams/GameType*.java#setVariable`, and teams screens.
With voting enabled, the target opens voting immediately and sets one 400-tick intermission. Without voting, it uses a fixed 200-tick intermission. Runtime countdown persistence and an optional results screen do not restore independently configurable, sequential results/voting phases.

Missing: The guaranteed results-before-voting sequence, separate duration controls, and persistence of those configurable durations.

### Configurable autobalance interval and advance warning — PARTIAL

Reference: `R/common/teams/TeamsManager.java#tick`, `R/common/teams/CommandTeams.java` (`autobalancetime`).
Autobalancing uses an administrator-selected interval. When imbalance is detected, the tick path can broadcast an advance warning 200 ticks before the scheduled balance.

Target checked: `T/common/teams/TeamsManager.java#tick`, `#autoBalanceIfNeeded`, `T/common/teams/GameTypeTDM.java#setVariable`, and `T/common/command/TeamsCommand.java`.
Automatic balancing exists, including its enabled/disabled setting. It is invoked every 200 elapsed round ticks and informs the moved player afterward. The interval is fixed and there is no corresponding advance-warning phase.

Missing: Administrator-selected balancing frequency and the reference's advance broadcast before a scheduled balance.

### Detailed explosion-kill audit and spawn-kill warning log — MISSING

Reference: `R/common/eventhandlers/PlayerDeathEventListener.java#PlayerDied`, `#logKillMessage`, instantiated in `R/common/FlansMod.java`.
For player deaths entering its Flan bullet/grenade explosion branch, the listener logs the weapon, positions, victim lifetime, and armor information. It also logs a possible spawn-kill warning when the victim's lifetime is below `noticeSpawnKillTime`. This finding is limited to the branch the reference actually implements.

Target checked: `T/event/handler/CommonEventHandler.java#onLivingDeath`, `#sendKillMessage`, `T/common/teams/PlayerStats.java`, `T/common/teams/TeamsManager.java`, and target log/configuration searches.
Kill feed packets and persistent statistics do not provide this detailed event log or its configurable lifetime-based warning.

Missing: The reference's detailed explosion-kill server audit records and possible spawn-kill warning. This is logging, not spawn protection or automatic moderation.

## Crafting

### Optional charcoal/glowstone gunpowder recipe — MISSING

Reference: `R/common/FlansMod.java` (recipe registration guarded by `addGunpowderRecipe`).
The enabled option adds a shapeless recipe converting three charcoal and one glowstone dust into one gunpowder.

Target checked: target `../src/main/resources/data`, `T/common/recipe/RecipeJsonGenerator.java`, `T/common/recipe/RecipeResolver.java`, and common configuration.
No equivalent recipe or toggle was found. The target's `data/flansmodapocalypse/recipes/gunpowder_from_sulphur.json` consumes a different resource and does not replace this crafting route.

Missing: The three-charcoal plus glowstone-dust recipe and its enable/disable option.

## HUD and rendering preferences

### Independent ammo-HUD visibility and legacy layout selection — PARTIAL

Reference: `R/client/TickHandlerClient.java` (HOTBAR overlay and `renderAmmoHudPrimary`/`renderAmmoHudSecondary`), `R/common/FlansMod.java` (`bulletGuiEnable`, `fancyBulletGui`).
The ammo HUD can be disabled independently. When enabled, the fancy setting selects between two reference layouts for primary/secondary ammunition.

Target checked: `T/client/render/ClientHudOverlays.java#HUD`, `#renderPlayerAmmo`, `T/config/ModClientConfig.java`, and `T/config/CommonConfigSnapshot.java`.
The target draws an ammo HUD but exposes neither an independent ammo-HUD toggle nor the reference layout selector. The shootable durability-bar option controls item bars, and hiding the entire vanilla GUI is a different capability.

Missing: Independent ammo-HUD visibility and user-selectable legacy ammo-HUD layouts.

### Configurable normal and sneaking name-tag render ranges — MISSING

Reference: `R/client/FlansModClient.java` (assignments to `RendererLivingEntity.NAME_TAG_RANGE` and `NAME_TAG_RANGE_SNEAK`), `R/common/FlansMod.java` (`nameTagRenderRange`, `nameTagSneakRenderRange`).
The mod supplies independent configurable distances for ordinary and sneaking name tags.

Target checked: `T/config/ModClientConfig.java`, `T/config/CommonConfigSnapshot.java`, `T/event/handler/ClientEventHandler.java`, `T/client/teams/TeamsClientState.java`, and target name-tag/render-range searches.
Team-dependent player visibility and vanilla renderer behavior do not expose the reference's independently configurable name-tag distances.

Missing: Mod-level normal/sneaking name-tag distance controls.

## Findings table

| Subsystem | Feature | Status | Confidence |
| --------- | ------- | ------ | ---------- |
| Multiplayer | Content-definition mismatch enforcement | MISSING | HIGH |
| Armor/mobs | Ambient zombie/skeleton pack armor | MISSING | HIGH |
| Armor | Zero-enchantability anvil restriction | PARTIAL | MEDIUM |
| Inventory | Per-player reload preferences | PARTIAL | HIGH |
| Interactions | Configurable armed block-use suppression | PARTIAL | HIGH |
| Driveables | BuildCraft oil/fuel bucket integration | MISSING | HIGH |
| Driveables | Passenger guns on destroyed parts override | PARTIAL | HIGH |
| Vehicles | Driver zoom and permission | MISSING | HIGH |
| Teams | Separate configurable results/voting phases | PARTIAL | HIGH |
| Teams | Autobalance interval and advance warning | PARTIAL | HIGH |
| Administration | Explosion-kill audit/spawn-kill warning | MISSING | HIGH |
| Crafting | Charcoal/glowstone gunpowder recipe | MISSING | HIGH |
| HUD | Ammo-HUD visibility/layout controls | PARTIAL | HIGH |
| Rendering | Normal/sneaking name-tag range controls | MISSING | HIGH |

## Areas requiring deeper audit

- Validate the armor anvil finding with representative enchantment-book, repair, and combination inputs; the missing explicit policy is visible in source, but accepted operations also depend on vanilla item/anvil rules.
- Driveable physics, collision response, aircraft controls, mecha movement, and legacy model animation have substantially different implementations. This audit does not establish trajectory-level or visual equivalence across representative packs, especially articulated vehicles and custom model transforms.
- Exercise multiplayer reconnect/reload, late entity tracking, occupied-seat synchronization, and persisted rounds in-game to assess timing-dependent parity. Source-level searches do not prove absence of subtle synchronization differences.
- The BuildCraft finding is a source integration gap. Choosing an applicable modern fluid ecosystem would require a separate compatibility investigation.

These follow-up areas are validation limits, not additional counted missing features.
