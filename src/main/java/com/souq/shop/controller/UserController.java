package com.souq.shop.controller;

import com.souq.shop.entity.User;
import com.souq.shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.signUp(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    // TODO : user can be deleted or blocked by admin. Maybe we need enabled/ disabled for specific time

}
