# Glossary (Topic-First)

## Precedence Policy
- Topic glossaries override root definitions for their scope. Use this file as an index, not a rewrite.
- When ambiguity exists, follow the most specific topic (e.g., Angular 20 override before base Angular) and defer to `rules/RULES.md` sections 4, 5, and Forward-Only.
- CRTP is mandatory for fluent APIs; do not introduce builders unless a topic rule explicitly requires it.

## Topic Glossaries to load
- Language: `rules/generative/language/java/GLOSSARY.md`, `rules/generative/language/typescript/GLOSSARY.md`
- Angular: `rules/generative/language/angular/GLOSSARY.md` plus `rules/generative/language/angular/angular-20.rules.md` for version-specific guidance
- JWebMP: `rules/generative/frontend/jwebmp/client/GLOSSARY.md`, `rules/generative/frontend/jwebmp/typescript/GLOSSARY.md`
- AgCharts (JWebMP wrapper): `rules/generative/frontend/jwebmp/agcharts/GLOSSARY.md`
- GuicedEE: `rules/generative/backend/guicedee/GLOSSARY.md`, `rules/generative/backend/guicedee/client/GLOSSARY.md`
- Reactive/Vert.x: `rules/generative/backend/vertx/GLOSSARY.md`
- Fluent API (CRTP): `rules/generative/backend/fluent-api/GLOSSARY.md`

## Host terms (minimal, evidence-based)
- AgChart: base JWebMP component that generates Angular signals and registers websocket listeners for options/data (`src/main/java/com/jwebmp/plugins/agcharts/AgChart.java`).
- Options Model: `AgChartOptions` aggregates axes/series/theme/legend/tooltip/etc.; concrete series options live under `options/series/*`.
- EventBus channel: client-side EventBusService over websocket used to deliver options (`<id>Options`) and data (`<id>Data`) listener payloads.
- Chart types: concrete wrappers (bar/line/area/pie/donut/bubble/combination/scatter) that preconfigure `AgChartOptions` using CRTP setters.

## Prompt Language Alignment
- Fluent style: CRTP chaining returning `(J) this`; avoid Lombok builders.
- Logging: default to Log4j2 if logging is added.
- Angular version lock: use base Angular rules plus `angular-20` override; do not mix version APIs.
