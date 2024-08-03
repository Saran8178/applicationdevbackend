package com.saran.applicationdev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saran.applicationdev.model.Users;

public interface UserRepo extends JpaRepository<Users,Long>{
    
}
