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

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }
        return user;
    }

    public ResponseEntity<String> deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("User not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> updateUser(int id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        if (users == null) {
            throw new ResourceNotFoundException("No users found");
        }
        return users;
    }
}
