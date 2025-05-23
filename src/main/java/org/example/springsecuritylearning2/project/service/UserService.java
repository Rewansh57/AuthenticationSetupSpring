package org.example.springsecuritylearning2.project.service;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritylearning2.project.configuration.MyAuthenticationManager;
import org.example.springsecuritylearning2.project.model.Users;
import org.example.springsecuritylearning2.project.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder Encoder;
    private final MyAuthenticationManager authManager;
    private final JwtService jwtService;




    public String register(Users userPresent){
        userPresent.setPassword(Encoder.encode(userPresent.getPassword()));

        userRepository.save(userPresent);

        return userPresent.getUsername()+" Added To The Database";




    }
    public String login ( Users user){
        UsernamePasswordAuthenticationToken authRequest=new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authToken=authManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        return jwtService.generateToken(user.getUsername());








    }


}
