package org.example.springsecuritylearning2.project.service;

import lombok.RequiredArgsConstructor;

import org.example.springsecuritylearning2.project.model.Users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;



public class MyUserDetails implements UserDetails {
    private Users user;

    public MyUserDetails(Users user){
        this.user=user;

    }




    public Collection<? extends GrantedAuthority> getAuthorities() {
       return  user.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getRoles()))
                .collect(Collectors.toSet());
    }

   @Override
    public String getUsername() {
        return user.getUsername();

    }

    @Override
    public String getPassword() {
        return user.getPassword();

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;

    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

