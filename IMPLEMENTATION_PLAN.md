# Implementation Plan (Stage 3 — Docs Only)

Context: Documentation-first with blanket approval; Stage 4 will execute the steps below.

## Scaffolding and File Tree
- Add environment sample at `.env.example` aligned to `rules/generative/platform/secrets-config/env-variables.md`, trimmed to keys relevant for this plugin (runtime, auth hooks, observability toggles).
- Add MCP registration for Mermaid + ag-mcp in `.mcp.json` to support diagram rendering and AG Charts MCP.
- Add AI workspace policies:
  - `.aiassistant/rules/README.md` summarizing RULES anchors (behavioral, technical, modularity, forward-only).
  - `.github/copilot-instructions.md` mirroring the same constraints for Copilot.
- Add CI workflow under `.github/workflows/maven-package.yml` using shared `GuicedEE/Workflows/.github/workflows/projects.yml@master` with `baseDir: ''` and job `Guiced Injection`.

## Build / Config Wiring
- Ensure no project-specific files are placed inside `rules/`; reference paths only.
- Keep module exports/imports unchanged; Stage 4 is limited to docs/config scaffolding.

## Rollout and Validation
- Validate links across PACT/RULES/GUIDES/IMPLEMENTATION/architecture/GLOSSARY after new files are added.
- For CI workflow, confirm secrets are referenced (USERNAME, USER_TOKEN, SONA_USERNAME, SONA_PASSWORD) and document them in `.env.example`.
- Run `git status` to review only intended files (no code deltas) after scaffolding.

## Risks
- Existing dirty workspace must not be reverted; limit edits to new docs/config files.
- `.env.example` must avoid real secrets; use placeholders.
- CI workflow relies on external shared workflow availability; note requirement in README if needed.
