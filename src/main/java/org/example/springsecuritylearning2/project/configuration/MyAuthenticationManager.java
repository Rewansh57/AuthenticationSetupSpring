package org.example.springsecuritylearning2.project.configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationManager implements AuthenticationManager {
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;


    public Authentication authenticate(Authentication authentication ){
        String username=authentication.getName();
        String password=authentication.getCredentials().toString();
        UserDetails userDetails=userDetails






    }
}
