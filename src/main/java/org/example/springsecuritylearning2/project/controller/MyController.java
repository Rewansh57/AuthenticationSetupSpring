package org.example.springsecuritylearning2.project.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritylearning2.project.model.Users;
import org.example.springsecuritylearning2.project.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {
    private final UserService userService;


    @PostMapping("/register")
    public String register(@RequestBody Users user){
        return userService.register(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.login(user);

    }

}
