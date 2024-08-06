package com.saran.applicationdev.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saran.applicationdev.model.Application;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
}
