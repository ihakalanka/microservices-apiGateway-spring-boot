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

    @GetMapping("/findByEmail")
    public User findUserByEmail(@RequestBody String email) {
        return userService.findByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id).getBody();
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user).getBody();
    }

    @GetMapping("/all-users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/")
    public String getUser() {
        return "User Microservice";
    }
}
