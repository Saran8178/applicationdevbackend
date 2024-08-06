package com.saran.applicationdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.applicationdev.model.AdminJobs;
import com.saran.applicationdev.repo.AdminjobsRepo;
import java.util.List;

@Service
public class AdminjobsService {

    @Autowired
    private AdminjobsRepo adjobsRepo;

    public List<AdminJobs> getJobs() {
        return adjobsRepo.findAll();
    }

    public AdminJobs addJob(AdminJobs adjob) {
        return adjobsRepo.save(adjob);
    }

    public String delete(Long jobId) {
        if (adjobsRepo.existsById(jobId)) {
            adjobsRepo.deleteById(jobId);
            return jobId + " deleted";
        } else {
            return "Job not found";
        }
    }
}
