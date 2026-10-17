---
applyTo: '*'
description: 'Quarkus and Java instructions for this repository'
---

## Project Context

- This repository is a Quarkus REST API built with Java 21 and Maven.
- The current architecture is organized around `resource`, `application`,
  `domain`, and `infrastructure` packages.
- MongoDB is used for persistence through Quarkus MongoDB Panache.
- Prefer consistency with the existing codebase over introducing a new pattern.

## Java and Quarkus Standards

- Target Java 21.
- Use Quarkus 3.x conventions and Jakarta APIs already present in the project.
- Keep REST endpoints in `resource` classes and business rules in
  `application` services.
- Keep persistence-specific code in `domain` and `infrastructure`.
- Prefer readable, maintainable code over unnecessary abstraction.
- Use comments sparingly and only when they explain non-obvious intent.

## REST API Guidance

- Use JAX-RS annotations such as `@Path`, `@GET`, `@POST`, `@PUT`, and
  `@DELETE`.
- Keep `@Consumes(MediaType.APPLICATION_JSON)` and
  `@Produces(MediaType.APPLICATION_JSON)` on JSON resources.
- Use `Response` when explicit HTTP status handling improves clarity.
- Return correct status codes such as `200`, `201`, `204`, `400`, and `404`.
- Validate request payloads with Bean Validation annotations.
- Do not invent endpoints or payload fields that are not backed by code.

## Data and Persistence

- Treat the existing `Book` model and resource layer as the source of truth for
  the public API contract.
- Keep MongoDB changes compatible with the current Panache-based approach unless
  a migration is explicitly requested.
- Prefer clear repository and service boundaries.
- Avoid introducing SQL-oriented patterns or JPA-specific advice that does not
  fit MongoDB Panache.

## Configuration

- Do not add new hardcoded secrets, passwords, or connection strings.
- Prefer environment variables or Quarkus configuration overrides for sensitive
  settings.
- Use `application.properties` consistently unless there is a strong reason to
  introduce another config style.

## Testing

- Add or update tests when behavior changes.
- Prefer `@QuarkusTest` for API and integration-style tests.
- Use RestAssured to verify REST behavior.
- Keep tests deterministic and aligned with documented behavior.

## Documentation

- Update `README.md` when changing prerequisites, run instructions, external
  dependencies, or API behavior.
- Keep examples aligned with the actual request and response payloads.
- If MongoDB or another service is required locally, document it clearly.
