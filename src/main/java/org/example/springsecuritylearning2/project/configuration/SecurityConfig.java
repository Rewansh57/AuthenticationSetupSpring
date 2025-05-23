package org.example.springsecuritylearning2.project.configuration;


import lombok.RequiredArgsConstructor;
import org.example.springsecuritylearning2.project.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;


    @Bean

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }
    @Bean

    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;


    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, DaoAuthenticationProvider auth, MyUserDetailsService service) throws Exception {


        http.httpBasic(Customizer.withDefaults()).authenticationProvider(auth)
                .authorizeHttpRequests((c) -> c.requestMatchers("/register","/login").permitAll()
                        .anyRequest().authenticated())
                .csrf(c->c.disable())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);




        return http.build();


    }



}
