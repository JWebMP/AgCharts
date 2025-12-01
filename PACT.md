# AgCharts JWebMP Plugin — Human × AI Pact

## Purpose
- Adopt the Rules Repository for this existing project while keeping change sets forward-only and documentation-first.
- Ground all decisions in observed code: reactive `AgChart` base (websocket/event bus), concrete chart wrappers, and options/series/axes/theme models under `src/main/java/com/jwebmp/plugins/agcharts`.
- Work across selected stacks: Java 25 LTS, JWebMP Client + Angular 20, CRTP fluent style, GuicedEE Client, Vert.x 5 reactive patterns, GitHub Actions CI, Documentation-as-Code.

## Collaboration & Stage Gates
- Stage flow (docs-first): Stage 1 Architecture → Stage 2 Guides & Design Validation → Stage 3 Implementation Plan → Stage 4 Implementation/Scaffolding.
- Blanket approval per prompt inputs; gates are auto-approved but still recorded in artifacts.
- Honor Rules Repository anchors: `rules/RULES.md` sections 4 (Behavioral), 5 (Technical), Document Modularity Policy, and Forward-Only Change Policy.
- No source code changes before Stage 4; documentation and planning carry the first three stages.

## Scope and System Snapshot (evidence-based)
- Server: JWebMP/GuicedEE module `com.jwebmp.plugins.agcharts` (see `module-info.java`) exporting chart components and options; depends on `com.jwebmp.core`, `com.jwebmp.core.angular`, `com.guicedee.guicedinjection`, Jackson annotations.
- Client: Angular component generated from annotations in `AgChart` with EventBus-driven websocket listeners for options/data; uses `ag-charts-angular` and AG Charts community packages declared in `AgChartsPageConfigurator`.
- Integration: Websocket receivers (`InitialOptionsReceiver`, `DataReceiver`) call `getInitialOptions()` / `getInitialData()` (Mutiny `Uni`) and push responses via `AjaxResponse` for the browser to hydrate.
- Packaging: Maven jar with parent `com.jwebmp:parent:2.0.0-SNAPSHOT`; Guice scan registration via `AgChartsInclusionsModule` and META-INF service entries.

## Stack and Rules Anchors (topic-first)
- Java 25 LTS — `rules/generative/language/java/java-25.rules.md`, build wiring per `rules/generative/language/java/build-tooling.md`.
- Angular 20 — Base `rules/generative/language/angular/README.md` plus override `rules/generative/language/angular/angular-20.rules.md`; TypeScript base `rules/generative/language/typescript/README.md`.
- JWebMP Client + TypeScript — `rules/generative/frontend/jwebmp/client/README.md`, `rules/generative/frontend/jwebmp/typescript/README.md`.
- CRTP Fluent API — `rules/generative/backend/fluent-api/GLOSSARY.md` (CRTP enforced; avoid builders).
- GuicedEE Client + Vert.x 5 reactive alignment — `rules/generative/backend/guicedee/README.md`, `rules/generative/backend/guicedee/client/README.md`, `rules/generative/backend/vertx/README.md`.
- CI/CD — GitHub Actions baseline `rules/generative/platform/ci-cd/README.md` and provider `rules/generative/platform/ci-cd/providers/github-actions.md`.

## Traceability Loop
- This Pact → `RULES.md` (project rules + topic links) → `GUIDES.md` (how to apply) → `IMPLEMENTATION.md` (code layout, decisions) → diagrams under `docs/architecture/` → back to Glossary for terminology.
- `docs/PROMPT_REFERENCE.md` captures selected stacks, diagram index, and prompt alignment requirements for future AI runs.

## Risks / Open Points
- AG Charts Enterprise vs Community: code references community packages but also exposes gradient legend/navigator options; enterprise licensing responsibilities remain with the host project.
- Data source boundaries are app-defined; no persistence layer found. Downstream adopters must define data validation and auth if chart data is sensitive.
- Existing codebase is already modified in this workspace; avoid reverting user changes while applying forward-only documentation.
