# Copilot Instructions (Project)

- Load and follow `PACT.md`, `RULES.md`, `GLOSSARY.md`, `GUIDES.md`, `IMPLEMENTATION.md`, `docs/PROMPT_REFERENCE.md` before suggesting code.
- Obey Rules Repository anchors: `rules/RULES.md` sections 4/5, Document Modularity Policy, Forward-Only Change Policy.
- Stack locks: Java 25 + Maven; JWebMP Client with Angular 20/TypeScript; GuicedEE Client + Vert.x reactive (Mutiny); CRTP fluent setters only; Log4j2 for logging.
- AgCharts rules index: `rules/generative/frontend/jwebmp/agcharts/README.md` (enterprise extras at `.../agcharts-enterprise/README.md`); use topic glossary for listener naming/option terms.
- No project docs inside `rules/`; reference topic guides listed in `RULES.md`.
- Stage gates are documentation-first; code changes occur only at Stage 4 (blanket approval noted for this run).
