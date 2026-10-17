---
applyTo: '*'
description: 'Security guidance for this repository based on OWASP principles'
---

## Security Posture

- Prefer secure defaults.
- When in doubt, choose the safer implementation and explain the tradeoff.
- Call out security risks you find instead of silently working around them.

## Input and API Safety

- Validate all external input.
- Use Bean Validation for request payloads where applicable.
- Avoid leaking stack traces, secrets, or internal implementation details in API
  responses.
- Return clear and appropriate HTTP status codes for invalid input and missing
  resources.

## Secrets and Configuration

- Never introduce new hardcoded passwords, tokens, API keys, or connection
  strings.
- Prefer environment variables or secure configuration sources for secrets.
- If existing hardcoded secrets are encountered, flag them and prefer a safer
  alternative in new code and documentation.

## Persistence and Query Safety

- Keep database access within the existing repository and service boundaries.
- Avoid building queries from untrusted input without validation.
- Prefer framework-supported APIs over ad hoc parsing or dynamic query building.

## Dependency and Runtime Safety

- Prefer stable, maintained dependencies.
- Avoid enabling development-only behavior in production-oriented code or docs.
- When adding configuration, consider least privilege and minimal exposure.

## Review Guidance

- Flag missing validation, insecure defaults, undocumented operational risks,
  and sensitive data exposure.
- Prefer small, explicit mitigations that fit the current Quarkus and MongoDB
  stack.
