# Architecture Index

- Scope: AgCharts JWebMP plugin (server-side JWebMP + Angular 21 client with AG Charts).
- Evidence basis: `AgChart` websocket handlers, chart option models under `options/`, `module-info.java` exports/requires, `AgChartsPageConfigurator` TypeScript deps, `AgChartsInclusionsModule` service registration, Maven parent/dependency management.
- Stage policy: docs-as-code; diagrams are Mermaid sources stored here (no images committed). Stage gates are auto-approved per blanket approval but still traced through links below.
- Trust and threat notes: primary boundary is browser ↔ EventBus websocket ↔ server receivers; validate payload shapes before merging; enterprise package licensing handled by host app.
- Dependency map (high level): JWebMP server (Guice + Vert.x EventBus) ↔ generated Angular 21 client ↔ `ag-charts-angular` + `ag-charts-community`/`ag-charts-enterprise` npm packages; host services supply data/options.

Artifacts
- C4 Context — `./c4-context.md`
- C4 Container — `./c4-container.md`
- Component (AgCharts runtime) — `./c4-component-agcharts.md`
- Sequences — `./sequence-initial-load.md`, `./sequence-data-update.md`
- ERD (chart option model) — `./erd-chart-model.md`

References
- **[AG Charts Documentation](https://charts.ag-grid.com/)** — Official AG Charts documentation
- **[JWebMP Home](https://jwebmp.com/)** — JWebMP framework documentation
- **[Source Code](../../src/main/java/)** — Current implementation
