package com.souq.shop.service;

import com.souq.shop.entity.User;
import com.souq.shop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    // inject using constructor
    private final UserRepository userRepository;
    // I created Encoding Class because of Bean Circular between WebSecurity Class and UserService
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
    public void signUp(User user){
        if (userRepository.findByEmail(user.getEmail()) != null){
            throw new NotAcceptableStatusException(user.getEmail() + "is already exists");
        }

        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        // TODO : send email verification
       // return "good";
    }
    // I use spring login
    // TODO : add custom login page. so custom logic
}
