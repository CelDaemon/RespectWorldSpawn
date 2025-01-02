# Respect World Spawn

A lightweight mod to help tweak and fix the vanilla behavior of player spawning so that it doesn't override your Y height and rotation(yaw).

Useful for modded servers that want to have a spawn with a roof and facing any direction.

## Usage

Set your world spawn if you haven't already using `/setworldspawn` and optionally change the `spawnRadius` gamerule so that players always spawn on the same block: `/gamerule spawnRadius 0`

There's two gamerules added by the mod and enabled by default to toggle each of the mod features on/off, you should never need these unless you want the default behavior back for some reason.
- `respectSpawnHeight` Toggles the fix that prevents the server from positioning the player at the highest altitude block.
- `respectSpawnRotation` Toggles the fix that provides the spawning logic with the yaw provided to `/setworldspawn`, as it's bugged on vanilla Minecraft.
