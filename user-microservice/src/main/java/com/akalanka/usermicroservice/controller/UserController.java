package com.akalanka.usermicroservice.controller;

import com.akalanka.usermicroservice.entity.User;
import com.akalanka.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public User saveUser(User user) {
        return userService.saveUser(user);
    }










}
