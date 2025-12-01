# AgCharts
Ag Charts plugin for JWebMP with Angular 20 integration and CRTP-based chart option models.

## Documentation-first
- Pact: `PACT.md`
- Rules: `RULES.md`
- Guides: `GUIDES.md`
- Implementation map: `IMPLEMENTATION.md`
- Implementation plan: `IMPLEMENTATION_PLAN.md`
- Glossary (topic-first): `GLOSSARY.md`
- Architecture diagrams: `docs/architecture/README.md`
- Prompt bootstrap for AI tools: `docs/PROMPT_REFERENCE.md`

## Rules Repository
- Submodule: `rules` (`https://github.com/GuicedEE/ai-rules.git`)
- Keep project-specific docs outside `rules/`; update submodule with `git submodule update --init --recursive` when needed.

## Stack
- Java 25 (Maven), JWebMP Client + Angular 20 + TypeScript, GuicedEE client/Vert.x reactive patterns (Mutiny `Uni`), Log4j2 as default logging choice, GitHub Actions CI.

## How to use these rules
- Load `PACT.md`, `RULES.md`, `GUIDES.md`, `IMPLEMENTATION.md`, `GLOSSARY.md`, and `docs/PROMPT_REFERENCE.md` first.
- For AgCharts-specific guidance, start at `rules/generative/frontend/jwebmp/agcharts/README.md` (new modular ruleset) and follow the linked topics (angular integration, options, data/events, testing).
- Follow language/framework anchors in `RULES.md` (Angular 20, TypeScript, JWebMP client) and architecture diagrams under `docs/architecture/README.md`.
- Generated Angular/TypeScript outputs remain read-only; apply changes via Java sources and update docs/diagrams accordingly.

## Prompt Language Alignment & Glossary
- Topic-first glossary lives at `rules/generative/frontend/jwebmp/agcharts/GLOSSARY.md`; host projects should link to it and copy only enforced aligned names when needed.
- Enforced names: listener channels `<componentId>Options` / `<componentId>Data`, CRTP fluent setters returning `(J) this`, Angular 20 APIs only.
- When other terms overlap with host glossaries, prefer links instead of duplicating definitions.
