

package com.saran.applicationdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.applicationdev.model.AdminJobs;
import com.saran.applicationdev.repo.AdminjobsRepo;

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
}
