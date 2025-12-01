# IMPLEMENTATION — Current Layout

## Module and Build
- Maven jar under `pom.xml` (parent `com.jwebmp:parent:2.0.0-SNAPSHOT`), module name `com.jwebmp.plugins.agcharts` (`src/main/java/module-info.java`).
- Services: `src/main/resources/META-INF/services/com.jwebmp.core.services.IPageConfigurator` → `AgChartsPageConfigurator`; `...IGuiceScanModuleInclusions` → `AgChartsInclusionsModule`.
- TypeScript deps for bundling declared in `AgChartsPageConfigurator` (`ag-charts-community`, `ag-charts-enterprise`, `ag-charts-angular`, `ag-charts-locale`).
- CI: `.github/workflows/maven-package.yml` uses shared `GuicedEE/Workflows` GitHub Action (secrets: USERNAME, USER_TOKEN, SONA_USERNAME, SONA_PASSWORD).
- Tooling configs: `.mcp.json` registers Mermaid + ag-mcp; `.env.example` holds local runtime/auth/observability placeholders.

## Runtime Components
- `AgChart<J>` base (websocket listeners, Angular signals, Mutiny `Uni` providers) — see `docs/architecture/c4-component-agcharts.md` and sequence diagrams.
- Receivers: `InitialOptionsReceiver` and `DataReceiver` (inner classes in `AgChart`) using `IGuiceContext` to resolve chart instances and push payloads via `AjaxResponse`.
- Concrete charts: bar/line/area/pie/donut/bubble/combination/scatter wrappers preconfiguring `AgChartOptions`.
- Options model: `options/AgChartOptions` aggregates axes, legend, tooltip, theme, overlays, navigator, gradient legend, locale, padding; series options live under `options/series/*`.
- Guice inclusion: `AgChartsInclusionsModule` exposes `com.jwebmp.plugins.agcharts` for scanning.

## How to Extend (align with GUIDES)
- Add or modify chart types by extending `AgChart` with CRTP setters and overriding `getInitialOptions()` (GUIDES → Frontend/Backend sections).
- Wire new data sources by supplying `getInitialData()` (Mutiny `Uni`) and updating sequences if flow changes.
- When adding logging or observability, follow Log4j2 defaults and platform observability rules.

## Traceability
- Guides: `GUIDES.md` links to relevant rules for frontend, backend, and CI.
- Diagrams: `docs/architecture/` files depict current flows; update them alongside code changes.
- Terminology: `GLOSSARY.md` lists topic glossaries and host terms to keep naming consistent.
