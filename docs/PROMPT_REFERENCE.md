# Prompt Reference

Use this file to prime any AI assistant before working in the repo.

## Selected stacks and policies
- Java 25 LTS, Maven build (parent `com.jwebmp:parent:2.0.0-SNAPSHOT`).
- JWebMP Client with Angular 20 and TypeScript integration; AG Charts via `ag-charts-angular`.
- GuicedEE Client + Vert.x 5 reactive style (Mutiny `Uni` in `AgChart#getInitialOptions` / `getInitialData`).
- Fluent API strategy: CRTP only (no builders), forward-only change policy, Document Modularity Policy.
- Logging default: Log4j2 if logging is added.
- CI: GitHub Actions (shared workflow per rules/platform/ci-cd providers).
- Stage gates: blanket approval granted in prompt; proceed through Stage 1–4 without waiting but record transitions.

## Rules Repository anchors (submodule at `rules/`)
- Behavioral/technical rules + forward-only: `rules/RULES.md` sections 4, 5, and Forward-Only.
- Language/framework: Java 25 (`rules/generative/language/java/java-25.rules.md`), Angular base + 20 override (`rules/generative/language/angular/README.md`, `rules/generative/language/angular/angular-20.rules.md`), TypeScript (`rules/generative/language/typescript/README.md`).
- JWebMP and GuicedEE: `rules/generative/frontend/jwebmp/client/README.md`, `rules/generative/frontend/jwebmp/typescript/README.md`, `rules/generative/backend/guicedee/README.md`, `rules/generative/backend/guicedee/client/README.md`, `rules/generative/backend/vertx/README.md`.
- Fluent API (CRTP): `rules/generative/backend/fluent-api/GLOSSARY.md`.
- CI/CD: `rules/generative/platform/ci-cd/README.md`, provider `rules/generative/platform/ci-cd/providers/github-actions.md`.

## Documents to load first
- Pact: `PACT.md`
- Rules: `RULES.md`
- Guides: `GUIDES.md`
- Implementation map: `IMPLEMENTATION.md`
- Glossary: `GLOSSARY.md`
- Architecture index and diagrams: `docs/architecture/README.md`, `docs/architecture/c4-context.md`, `docs/architecture/c4-container.md`, `docs/architecture/c4-component-agcharts.md`, `docs/architecture/sequence-initial-load.md`, `docs/architecture/sequence-data-update.md`, `docs/architecture/erd-chart-model.md`
- MCP config (Mermaid + ag-mcp): `.mcp.json` (register before rendering diagrams)

## Prompt language alignment
- Use CRTP-style fluent setters returning `(J) this`; avoid @Builder.
- Angular version is locked to 20; reference base rules plus override instead of mixing APIs across versions.
- Topic-first glossary precedence: use topic glossaries linked in `GLOSSARY.md`; avoid redefining terms unless mandated (e.g., CRTP enforcement).

## Evidence pointers
- Runtime flow: `AgChart` websocket listeners and receivers (`src/main/java/com/jwebmp/plugins/agcharts/AgChart.java`).
- Packaging: module exports in `src/main/java/module-info.java`; TypeScript deps in `AgChartsPageConfigurator`.
- Service registration: `src/main/resources/META-INF/services`.
