package com.saran.applicationdev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saran.applicationdev.model.AdminJobs;

public interface AdminjobsRepo extends JpaRepository<AdminJobs,Long> {
    
}
