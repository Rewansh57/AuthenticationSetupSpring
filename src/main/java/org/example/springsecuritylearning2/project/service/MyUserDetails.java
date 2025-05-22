package org.example.springsecuritylearning2.project.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class MyUserDetails implements UserDetails {
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Set<Role>
    }
}
