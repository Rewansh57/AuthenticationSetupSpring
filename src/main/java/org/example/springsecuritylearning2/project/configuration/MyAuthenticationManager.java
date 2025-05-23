package org.example.springsecuritylearning2.project.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyAuthenticationManager implements AuthenticationManager {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;


    public Authentication authenticate(Authentication authentication ){
        String username=authentication.getName();
        String password=authentication.getCredentials().toString();

        UserDetails userFromDb=userDetailsService.loadUserByUsername(username);
        if (passwordEncoder.matches(password,userFromDb.getPassword())){
            return new UsernamePasswordAuthenticationToken(username,password,userFromDb.getAuthorities());

        }
        else {
            throw new BadCredentialsException("Bad credentials");

        }









    }
}
