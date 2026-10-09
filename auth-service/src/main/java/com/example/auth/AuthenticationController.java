package com.example.auth;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    // In-memory user map for demo
    private static final java.util.Map<String, String> USERS = java.util.Map.of(
            "admin", "admin123",
            "user", "user123"
    );
    private static final java.util.Map<String, String> ROLES = java.util.Map.of(
            "admin", "ADMIN",
            "user", "USER"
    );

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (USERS.containsKey(username) && USERS.get(username).equals(password)) {
            // simulate session by returning a token / username
            return "{\"token\":\"simulated-token\",\"username\":\"" + username + "\",\"role\":\"" + ROLES.get(username) + "\"}";
        }
        return "Invalid credentials";
    }

    @GetMapping("/status")
    public String status(@RequestParam(required = false) String token) {
        // simple check: if token is present, consider authenticated
        if (token != null && !token.isEmpty()) {
            return "{\"status\":\"ok\"}";
        }
        return "{\"status\":\"unauthorized\"}";
    }
}