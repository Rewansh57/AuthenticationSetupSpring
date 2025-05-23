package org.example.springsecuritylearning2.project.service;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritylearning2.project.model.Users;
import org.example.springsecuritylearning2.project.repository.UserRepository;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    public UserDetails loadUserByUsername(String username){
        Optional<Users> user=userRepository.findByUsername(username);
        if (user.isPresent()){
           Users customUser= user.get();
           return new MyUserDetails(customUser);


        }



       throw new UsernameNotFoundException("Wrong username password");




    }



}
