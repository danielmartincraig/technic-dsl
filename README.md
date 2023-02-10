# TECHNIC-DSL

Technic-dsl defines lego technic gears in terms of gremlin traversals

Language:

| Noun |                |
|------|----------------|
| gear | g.gear(gearId) |

| Verb   |                                                     |
|--------|-----------------------------------------------------|
| drives | g.gear(driverGearId).drives(__.gear(followerGearId) |
