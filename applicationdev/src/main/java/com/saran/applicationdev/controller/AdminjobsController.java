package com.saran.applicationdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saran.applicationdev.model.AdminJobs;
import com.saran.applicationdev.service.AdminjobsService;

@RestController
@RequestMapping("/api")
public class AdminjobsController {

    @Autowired
    private AdminjobsService adjobservice;

    @GetMapping("/getUsers")
    public List<AdminJobs> getUsers() {
        return adjobservice.getJobs();
    }

    @PostMapping("/addJobs")
    public AdminJobs addJob(@RequestBody AdminJobs adjob) {
        return adjobservice.addJob(adjob);
    }
}
