package com.saran.applicationdev.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saran.applicationdev.model.User;


public interface UserRepo extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
