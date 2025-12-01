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
