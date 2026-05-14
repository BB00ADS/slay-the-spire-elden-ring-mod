# The Tarnished

Slay the Spire BaseMod character mod scaffold for `tarnished:`.

Implemented batches:

- Batch 0: BaseMod project structure, mod metadata, resources, Chinese localization.
- Batch 1: The Tarnished character, starter deck, starter relic placeholder.
- Minimal mechanism dependency: `BleedPower` and `ApplyBleedAction`, required by `Card003` / 猎犬长牙.

Starter-only cards are registered as `CardRarity.BASIC`, so they are available to the starting deck but excluded from normal card rewards.

## Local build setup

Place these jars in `lib/` before building:

- `desktop-1.0.jar`
- `ModTheSpire.jar`
- `BaseMod.jar`

Then run:

```powershell
gradle jar
```

Current placeholders:

- `MelinaRelic` is registered as a starter relic, with the full campfire conversion left as a TODO for batch 5.
- `Card004` / 灵马哨笛 uses the workbook's recommended first-pass approximation: immediately end a non-Boss combat. This is marked TODO because Slay the Spire has no ordinary escape API.
- Art assets are 1x1 placeholder PNGs so paths resolve while behavior is implemented.
