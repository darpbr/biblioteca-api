---
description: 'Markdown guidance for repository documentation'
applyTo: '**/*.md'
---

## Documentation Goals

- Keep documentation accurate, concise, and easy to scan.
- Prefer practical instructions over generic framework marketing text.
- Treat code and configuration as the source of truth.

## Markdown Style

- Use clear heading hierarchy.
- Use fenced code blocks with a language identifier when possible.
- Use bullet lists for short enumerations and numbered lists for ordered steps.
- Keep lines reasonably readable; wrap long paragraphs when helpful.
- Use descriptive link text.

## Repository-Specific Guidance

- `README.md` may use a single `#` title at the top.
- Do not require YAML front matter for normal repository documentation files.
- Do not add blog-style metadata fields such as `post_title`, `author1`,
  `categories`, or `featured_image` unless a file explicitly needs them.
- When documenting commands, prefer commands that work from the repository root.
- When documenting the API, keep endpoint names, payloads, prerequisites, and
  environment setup aligned with the implementation.

## Quality Checks

- Remove stale examples instead of polishing inaccurate content.
- If a document mentions infrastructure dependencies, document how to run or
  configure them locally.
- When behavior changes, update related docs in the same change whenever
  practical.
