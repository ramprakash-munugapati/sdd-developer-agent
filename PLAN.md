# Plan

## Architecture

- The application is a simple Java Spring Boot web service.
- Uses Spring Security for authentication and authorization.
- REST controllers expose endpoints.
- Logging via SLF4J/Logback to `auth.log`.

## Execution Steps

1. **Scaffold** a Spring Boot project with dependencies: web, security, lombok.
2. **Implement** a `UserDetailsService` loading users from an in‑memory map.
3. **Configure** `SecurityFilterChain` with form login disabled, token‑based auth.
4. **Create** a `StatusController` mapping `/api/status` returning `{"status":"ok"}`.
5. **Add** an `AuthenticationSuccessHandler` that appends a line to `auth.log` on successful login.
6. **Write** unit and integration tests covering REQ‑A1 through REQ‑A4.
7. **Run** checkstyle, unit tests, and JaCoCo coverage; ensure >=80% line coverage.

## Requirement Mapping

| Requirement | Implementation |
|-------------|----------------|
| REQ‑A1 | UserDetailsService + login endpoint |
| REQ‑A2 | Role‑based access using `@PreAuthorize` |
| REQ‑A3 | StatusController |
| REQ‑A4 | AuthenticationSuccessHandler writing to auth.log |

## Validation Strategy

- **Checkstyle**: enforce Google Java Style, run `mvn checkstyle:check`.
- **Tests**: JUnit 5 + Mockito; at least one test per acceptance scenario.
- **Coverage**: JaCoCo Maven plugin; target >=80% line coverage.
- **Evidence**: JUnit XML reports, JaCoCo XML, checkstyle XML captured after each build.