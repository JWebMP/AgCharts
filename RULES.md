# Project RULES — AgCharts JWebMP

## Scope and Policies
- Applies to the AgCharts JWebMP plugin (Java 25, Maven, Angular 20 client). Do not place project docs inside the `rules/` submodule.
- Forward-only edits; remove/replace legacy anchors instead of keeping duplicates.
- Documentation-first with stage gates recorded; blanket approval for this run means stages proceed without pause.
- CRTP fluent APIs only; avoid @Builder. Default logging is Log4j2 when logging is added.
- Align naming/terminology with `GLOSSARY.md` (topic-first).

## Stack Anchors (Rules Repository)
- Frontend / Angular / JWebMP
  - Base Angular + version override: `rules/generative/language/angular/README.md`, `rules/generative/language/angular/angular-20.rules.md`
  - TypeScript base: `rules/generative/language/typescript/README.md`
  - JWebMP client and TypeScript integration: `rules/generative/frontend/jwebmp/client/README.md`, `rules/generative/frontend/jwebmp/typescript/README.md`
  - Angular Awesome (not selected) remains out of scope unless explicitly added later.
- Backend / Reactive / GuicedEE
  - GuicedEE + client focus: `rules/generative/backend/guicedee/README.md`, `rules/generative/backend/guicedee/client/README.md`
  - Vert.x 5 reactive alignment: `rules/generative/backend/vertx/README.md`
  - Fluent API strategy (CRTP): `rules/generative/backend/fluent-api/GLOSSARY.md`
- Language / Build
  - Java 25: `rules/generative/language/java/java-25.rules.md`
  - Maven build wiring: `rules/generative/language/java/build-tooling.md`
- Architecture / Process
  - Specification-Driven Design and TDD: `rules/generative/architecture/README.md`, `rules/generative/architecture/tdd/README.md`
  - Documentation-as-Code: Document Modularity Policy in `rules/RULES.md`
- Platform / CI-CD / Observability
  - CI/CD: `rules/generative/platform/ci-cd/README.md`, provider `rules/generative/platform/ci-cd/providers/github-actions.md`
  - Observability baseline: `rules/generative/platform/observability/README.md`
  - Secrets/config: `rules/generative/platform/secrets-config/env-variables.md`

## Application of Rules
- Angular version is locked to 20; when referencing Angular APIs, cite the base rules and the `angular-20` override.
- Web client scaffolding follows JWebMP client rules; server-side reactive flows follow GuicedEE client + Vert.x patterns with Mutiny.
- Fluent setters return `(J) this`; maintain CRTP signatures in all option/series classes.
- Logging: use Log4j2 configuration/examples when logging guidance is required.
- Keep docs modular: prefer linking to topic entries over long monoliths; update indexes when new docs are added.

## Traceability
- Pact → this RULES → GUIDES → IMPLEMENTATION → architecture diagrams under `docs/architecture/` → Glossary. Keep back-links updated when moving content.
