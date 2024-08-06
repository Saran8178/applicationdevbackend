package com.saran.applicationdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.applicationdev.model.Application;
import com.saran.applicationdev.repo.ApplicationRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;

    public List<Application> getAllApplications() {
        return applicationRepo.findAll();
    }

    public Application addApplication(Application application) {
        return applicationRepo.save(application);
    }

    public Optional<Application> getApplicationById(Long applicationId) {
        return applicationRepo.findById(applicationId);
    }

    public boolean deleteApplication(Long applicationId) {
        if (applicationRepo.existsById(applicationId)) {
            applicationRepo.deleteById(applicationId);
            return true;
        }
        return false;
    }
}
