package org.example.springsecuritylearning2.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http.httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests((c) -> {
                    c.requestMatchers("login").permitAll()
                            .anyRequest().authenticated();


                })
                .formLogin(Customizer.withDefaults());

        return http.build();


    }
    public AuthenticationManager authenticationManager(){
        return new MyAuthenticationManager();



    }
}
