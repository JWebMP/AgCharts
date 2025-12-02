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

### AG Charts 12.2.0 Compliance
- **Version Lock**: AG Charts 12.2.0 is the minimum and only supported version; no backwards compatibility with earlier versions.
- **Options Coverage**: All 38 official AG Charts 12.2.0 chart-level options fully implemented as CRTP Java classes with Jackson JSON serialization.

### Core Components
- **AgChart**: base JWebMP component that generates Angular signals and registers websocket listeners for options/data (`src/main/java/com/jwebmp/plugins/agcharts/AgChart.java`).
- **Options Model**: `AgChartOptions` aggregates 38 chart-level configuration properties; series options live under `options/series/*`.
- **Option Classes**: 127 total classes organized into 27 packages (core + interactions/features).

### Configuration & Interactions
- **Core Options (19)**: axes, series, legend, tooltip, theme, locale, background, seriesArea, overlays, navigator, gradientLegend, width/height/minWidth/minHeight, padding, title/subtitle/footnote.
- **Interaction Options (19)**: highlight, animation, zoom, ranges, sync, contextMenu, dataSource, keyboard, touch, listeners, formatter, container, data, annotations, initialState, misc.
- **EventBus Channel**: client-side EventBusService over websocket; delivers options (`<id>Options`) and data (`<id>Data`) listener payloads.
- **Chart Types**: concrete wrappers (bar/line/area/pie/donut/bubble/combination/scatter) that preconfigure `AgChartOptions` using CRTP setters.

### New Features (December 2025)
- **Highlight**: Chart-level highlighting with per-state styling (highlighted/unhighlighted items and series).
- **Animation**: Duration, easing, enabled toggle for smooth transitions.
- **Zoom**: Zoom/pan with configurable wheel behavior.
- **Ranges**: Range presets and selection UI for time-series filtering.
- **Sync**: Multi-chart synchronization of tooltips/highlights/selections.
- **Listeners**: Chart-level event callbacks (onClick, onHighlight, onSelection) as raw JavaScript.
- **Formatter**: Modern FormatterConfiguration (replaces deprecated global formatter options).
- **Keyboard/Touch**: Input method toggles for accessibility.
- **Data/Annotations/InitialState**: Advanced configuration and state management.
- **Container/Misc**: Container element config and metadata (CSP nonce, Google Fonts).

### Deprecation (12.2.0 Alignment)
- **Removed**: formatterFunction, formatterFunctions, formatterFormats, seriesId field.
- **Replaced By**: AgChartFormatterOptions (modern formatter), series-level highlight, `id` field only.

## Prompt Language Alignment
- Fluent style: CRTP chaining returning `(J) this`; avoid Lombok builders.
- Logging: default to Log4j2 if logging is added.
- Angular version lock: use base Angular rules plus `angular-20` override; do not mix version APIs.
- Module system: all 27 option packages exported and opened for reflection (Guice, Jackson, JWebMP).
