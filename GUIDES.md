# GUIDES — How to Apply the Rules

Use these pointers to apply modular rules to this project. Always load `PACT.md`, `RULES.md`, `GLOSSARY.md`, and `docs/architecture/README.md` first.

## Frontend (Angular 20 + JWebMP)
- Angular base and override: follow `rules/generative/language/angular/README.md` with version specifics in `rules/generative/language/angular/angular-20.rules.md`.
- TypeScript integration and client packaging: `rules/generative/language/typescript/README.md`, `rules/generative/frontend/jwebmp/client/README.md`, `rules/generative/frontend/jwebmp/typescript/README.md`.
- Component flow reference: `docs/architecture/sequence-initial-load.md`, `docs/architecture/sequence-data-update.md`, and `docs/architecture/c4-component-agcharts.md` for websocket listener naming and signal wiring.

## Backend / Reactive
- GuicedEE client alignment and module scanning: `rules/generative/backend/guicedee/README.md`, `rules/generative/backend/guicedee/client/README.md`.
- Reactive patterns (Mutiny/Vert.x): `rules/generative/backend/vertx/README.md`; map to `getInitialOptions()` / `getInitialData()` flows shown in diagrams.
- Fluent API CRTP setters: `rules/generative/backend/fluent-api/GLOSSARY.md` — keep `(J) this` returns and avoid builders.

## Architecture, Quality, and Testing
- Specification-Driven Design and TDD: `rules/generative/architecture/README.md`, `rules/generative/architecture/tdd/README.md`.
- Use diagrams under `docs/architecture/` to anchor design changes and acceptance criteria; update sequences when flows change.
- Acceptance checks (minimum):
  - Initial options request returns a populated `AgChartOptions` and renders the chart (`chartReady` true).
  - Data channel delivers data without overwriting other options (merge behavior in `handleDataEvent`).
  - Websocket listeners are registered once per component id; teardown unsubscribes and unregisters listeners.

## CI/CD, Environments, and Secrets
- CI baseline: `rules/generative/platform/ci-cd/README.md`; GitHub Actions provider specifics at `rules/generative/platform/ci-cd/providers/github-actions.md`.
- Env/secrets: `rules/generative/platform/secrets-config/env-variables.md` — reflected in `.env.example` (see Stage 4).
- Observability starter: `rules/generative/platform/observability/README.md` (adopt Log4j2 defaults when adding logging).

## API Surface Sketch (server ↔ browser)
- Channels: `<componentId>Options` and `<componentId>Data` over EventBusService/websocket.
- Server contract: `AgChart#getInitialOptions(): Uni<AgChartOptions<?>>` (required), `AgChart#getInitialData(): Uni<Object>` (optional, may be null).
- Payload shape: raw object or `{ out: [<payload>] }` supported; options/data parsers normalize both.
- Angular binding: `[options]="chartOptions()"` with `chartReady()` guard; ag-charts-angular handles rendering.

## Traceability
- After implementing a change, update `IMPLEMENTATION.md` with the module touched and link back to relevant guide and diagram.
