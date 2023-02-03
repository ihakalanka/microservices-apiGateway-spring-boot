package com.akalanka.usermicroservice.repository;

import com.akalanka.usermicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
