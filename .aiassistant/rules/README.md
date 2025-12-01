# AI Assistant Workspace Rules

- Load first: `PACT.md`, `RULES.md`, `GLOSSARY.md`, `GUIDES.md`, `IMPLEMENTATION.md`, `docs/PROMPT_REFERENCE.md`.
- Behavioral and technical anchors: `rules/RULES.md` sections 4 (Behavioral Agreements) and 5 (Technical Commitments); apply Document Modularity Policy and Forward-Only Change Policy.
- Stage policy: documentation-first through Stage 3; Stage 4 may change code/config. Blanket approval for this run, but still record gate transitions.
- Stack: Java 25, Maven; JWebMP Client + Angular 20 + TypeScript; GuicedEE Client + Vert.x reactive (Mutiny); CRTP fluent setters only; Log4j2 preferred logging.
- Do not place project docs inside `rules/` submodule; link to topic guides instead (see `RULES.md` for indexes).
- Keep prompts aligned with topic-first glossary; avoid redefining terms covered by linked glossaries.
