package com.mycompany.cardgameapi.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return User.builder()
                .username("admin")
                .password("$2a$10$5/38T0gELXMsuD17nGFMxezR3/LgXRquq3TVAjoXjSZ.m2aOL5xcm") // BCrypt hash for "password"
                .roles("ADMIN")
                .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}