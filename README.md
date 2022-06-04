# TECHNIC-DSL

Technic-dsl defines lego technic constructions in terms of Gremlin traversals.

Language:

| Noun |                |
|------|----------------|
| gear | g.gear(gearId) |

| Verb   |                                        |
|--------|----------------------------------------|
| drives | g.gear(gearId).drives(__.gear(gear2Id) |
