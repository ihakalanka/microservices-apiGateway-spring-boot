package com.akalanka.usermicroservice.service;

import com.akalanka.usermicroservice.entity.User;
import com.akalanka.usermicroservice.message.ResourceNotFoundException;
import com.akalanka.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
