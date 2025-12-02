# IMPLEMENTATION — Current Layout

## Module and Build
- Maven jar under `pom.xml` (parent `com.jwebmp:parent:2.0.0-SNAPSHOT`), module name `com.jwebmp.plugins.agcharts` (`src/main/java/module-info.java`).
- Services: `src/main/resources/META-INF/services/com.jwebmp.core.services.IPageConfigurator` → `AgChartsPageConfigurator`; `...IGuiceScanModuleInclusions` → `AgChartsInclusionsModule`.
- TypeScript deps for bundling declared in `AgChartsPageConfigurator` (`ag-charts-community@^12.2.0`, `ag-charts-enterprise@^12.2.0`, `ag-charts-angular@^12.2.0`, `ag-charts-locale@^12.2.0`).
- CI: `.github/workflows/maven-package.yml` uses shared `GuicedEE/Workflows` GitHub Action (secrets: USERNAME, USER_TOKEN, SONA_USERNAME, SONA_PASSWORD).
- Tooling configs: `.mcp.json` registers Mermaid + ag-mcp; `.env.example` holds local runtime/auth/observability placeholders.

## AG Charts 12.2.0 Options — Complete Implementation

**127 Java option classes** implementing **38 official AG Charts 12.2.0 chart options**:

### Core Options (19 classes)
- `AgAxisBaseOptions` + axis subtypes (NumberAxis, TimeAxis, CategoryAxis, LogAxis, OrdinalTimeAxis, UnitTimeAxis, GroupedCategoryAxis)
- `AgSeriesBaseOptions` + 7 concrete series (Bar, Line, Area, Pie, Donut, Bubble, Scatter)
- `AgChartLegendOptions` (with pagination, listeners, styling)
- `AgChartTooltipOptions` (with position, interaction, anchoring)
- `AgLocaleOptions`, `AgChartBackground`, `AgChartTheme`, `AgSeriesAreaOptions`
- `AgChartOverlaysOptions`, `AgNavigatorOptions`, `AgGradientLegendOptions`

### NEW: Interaction & Feature Options (19 classes) — Added December 2025
**High Priority:**
- `AgChartHighlightOptions` + `AgChartHighlightStyleOptions` — Chart-level highlighting with fill/stroke/opacity control
- `AgChartAnimationOptions` — Duration, easing, enabled
- `AgChartZoomOptions` — Zoom/pan with wheel behavior control
- `AgChartRangesOptions` — Range presets and selection UI
- `AgChartSyncOptions` — Multi-chart synchronization modes

**Medium Priority:**
- `AgChartContextMenuOptions` — Context menu enable/disable
- `AgChartDataSourceOptions` — Data source adapter config
- `AgChartKeyboardOptions` — Keyboard input control
- `AgChartTouchOptions` — Touch gesture support
- `AgChartListenersOptions` — Chart-level event handlers (onClick, onHighlight, onSelection)
- `AgChartFormatterOptions` — Modern formatter configuration (replaces deprecated options)
- `AgChartContainerOptions` — Container element ID/className

**Lower Priority:**
- `AgChartDataOptions` — Chart-level data binding
- `AgChartAnnotationsOptions` — Annotations list
- `AgChartInitialStateOptions` — Initial zoom/pan state
- `AgChartMiscOptions` — CSP nonce, field notation, Google Fonts loading

### Package Structure
```
options/
├── AgChartOptions.java              (root: 38 properties, all CRTP setters)
├── AgChartCaptionOptions.java
├── AgChartBackground.java
├── AgBorderOptions.java
├── axes/                            (axis types + shared classes)
├── series/                          (7 concrete series + base + support classes)
├── legend/                          (legend + gradient legend)
├── tooltip/                         (chart & series tooltip)
├── theme/                           (theme + palette customization)
├── locale/                          (locale configuration)
├── overlays/                        (chart overlays)
├── navigator/                       (navigator + mini chart + mask/handle)
├── formatters/                      (deprecated formatter classes — kept for compatibility)
├── highlight/                       (NEW: chart-level highlight)
├── animation/                       (NEW: animation config)
├── zoom/                            (NEW: zoom control)
├── ranges/                          (NEW: range selection)
├── sync/                            (NEW: chart sync)
├── contextmenu/                     (NEW: context menu)
├── datasource/                      (NEW: data source)
├── keyboard/                        (NEW: keyboard control)
├── touch/                           (NEW: touch control)
├── listeners/                       (NEW: event listeners)
├── formatter/                       (NEW: modern formatter)
├── container/                       (NEW: container config)
├── data/                            (NEW: chart data)
├── annotations/                     (NEW: annotations)
├── initialstate/                    (NEW: initial state)
└── misc/                            (NEW: miscellaneous options)
```

## Runtime Components
- `AgChart<J>` base (websocket listeners, Angular signals, Mutiny `Uni` providers) — see `docs/architecture/c4-component-agcharts.md` and sequence diagrams.
- Receivers: `InitialOptionsReceiver` and `DataReceiver` (inner classes in `AgChart`) using `IGuiceContext` to resolve chart instances and push payloads via `AjaxResponse`.
- Concrete charts: bar/line/area/pie/donut/bubble/combination/scatter wrappers preconfiguring `AgChartOptions`.
- Guice inclusion: `AgChartsInclusionsModule` exposes `com.jwebmp.plugins.agcharts` for scanning.

## Module System
`src/main/java/module-info.java` exports all option packages (27 total after Dec 2025 update):
- Core: `options`, `options.axes`, `options.series`, `options.legend`, `options.tooltip`, `options.theme`, `options.locale`, `options.overlays`, `options.navigator`
- NEW: `options.highlight`, `options.animation`, `options.zoom`, `options.ranges`, `options.sync`, `options.contextmenu`, `options.datasource`, `options.keyboard`, `options.touch`, `options.listeners`, `options.formatter`, `options.container`, `options.data`, `options.annotations`, `options.initialstate`, `options.misc`
- Support: `options.formatters`, `options.series.fills`, `options.legend.gradient`

All packages also have `opens` directives for reflection (Guice, Jackson, JWebMP).

## How to Extend (align with GUIDES)
- Add or modify chart types by extending `AgChart` with CRTP setters and overriding `getInitialOptions()` (GUIDES → Frontend/Backend sections).
- Wire new data sources by supplying `getInitialData()` (Mutiny `Uni`) and updating sequences if flow changes.
- Add new option classes in dedicated `options/newfeature/` package; export and open in `module-info.java`.
- When adding logging or observability, follow Log4j2 defaults and platform observability rules.

## Deprecation Status
**Removed in December 2025 (AG Charts 12.2.0 minimum):**
- `formatterFunction` (field + methods removed from `AgChartOptions`)
- `formatterFunctions` (field + methods removed from `AgChartOptions`)
- `formatterFormats` (field + methods removed from `AgChartOptions`)
- `seriesId` field and methods removed from `AgSeriesBaseOptions`

**Replaced by:**
- `AgChartFormatterOptions` (modern formatter configuration)
- All series use only `id` field (no separate seriesId)

## Traceability
- Guides: `GUIDES.md` links to relevant rules for frontend, backend, and CI.
- Diagrams: `docs/architecture/` files depict current flows; update them alongside code changes.
- Terminology: `GLOSSARY.md` lists topic glossaries and host terms to keep naming consistent.
- Compliance: All 38 AG Charts 12.2.0 options fully implemented with CRTP fluent setters and Jackson JSON serialization.
