package com.mycompany.cardgameapi;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassewordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password";
        // String storedHash = "$2a$10$Dow1z9h9Q9j8YQ9j8YQ9j8u9j8YQ9j8YQ9j8YQ9j8YQ9j8YQ9j8YQ";

        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("BCrypt Hash: " + encodedPassword);

        boolean matches = encoder.matches(rawPassword, encodedPassword);
        System.out.println("Password matches: " + matches);
    }
}
