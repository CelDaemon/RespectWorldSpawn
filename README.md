# Respect World Spawn

A lightweight mod to help tweak and fix the vanilla behvaiour of player spawning so that it doesn't override your Y height and your rotation(yaw).

Useful for servers that want to have a spawn with a roof and in any direction.

## Usage

Just drop into the server mods folder and enjoy.

There's two gamerules added and enabled by default to toggle each of the mod features on/off, you should never need these unless you want the default behaviour back for some reason.
- `respectSpawnHeight` Toggles the fix that prevents the server from positioning the player at the highest altitude block.
- `respectSpawnRotation` Toggles the fix that provides the spawning logic with the yaw provided to `/setworldspawn`, as it's bugged on vanilla Minecraft.
