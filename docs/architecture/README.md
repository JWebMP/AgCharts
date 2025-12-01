# Architecture Index

- Scope: AgCharts JWebMP plugin (server-side JWebMP + Angular 20 client with AG Charts).
- Evidence basis: `AgChart` websocket handlers, chart option models under `options/`, `module-info.java` exports/requires, `AgChartsPageConfigurator` TypeScript deps, `AgChartsInclusionsModule` service registration, Maven parent/dependency management.
- Stage policy: docs-as-code; diagrams are Mermaid sources stored here (no images committed). Stage gates are auto-approved per blanket approval but still traced through links below.

Artifacts
- C4 Context — `./c4-context.md`
- C4 Container — `./c4-container.md`
- Component (AgCharts runtime) — `./c4-component-agcharts.md`
- Sequences — `./sequence-initial-load.md`, `./sequence-data-update.md`
- ERD (chart option model) — `./erd-chart-model.md`

Traceability
- Links referenced by `docs/PROMPT_REFERENCE.md`, `PACT.md`, `RULES.md`, `GUIDES.md`, and `IMPLEMENTATION.md` to close loops.
