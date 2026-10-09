# Specification

## Requirements

- **REQ-A1**: System shall provide user authentication (login/logout) with username and password.
- **REQ-A2**: System shall authorize users based on roles (admin, user).
- **REQ-A3**: System shall expose a REST API endpoint `/api/status` that returns JSON `{status: "ok"}`.
- **REQ-A4**: System shall log all authentication events to a file `auth.log`.

## Acceptance Scenarios

1. A valid user can login and receive a session token.
2. An invalid credentials attempt is rejected and logged.
3. Authenticated users can access `/api/status` and receive `{status: "ok"}`.
4. Admin role can perform privileged operations; regular users cannot.