package com.example.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class AuthenticationLogHandler implements AuthenticationSuccessHandler {

    private static final String LOG_FILE = "auth.log";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        String now = Instant.now().toString();
        String line = now + " | " + username + " logged in successfully";
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(line);
            writer.write("\n");
        }
    }
}