package com.saran.applicationdev.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saran.applicationdev.model.AdminJobs;
import com.saran.applicationdev.model.User;
import com.saran.applicationdev.service.AdminjobsService;
import com.saran.applicationdev.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AdminjobsController {

    @Autowired
    private AdminjobsService adjobservice;

    @Autowired
    private UserService userService;

    @GetMapping("/getJobs")
    public List<AdminJobs> getJobs() {
        return adjobservice.getJobs();
    }

    @PostMapping("/addJobs")
    public ResponseEntity<AdminJobs> addJob(@RequestBody Map<String, Object> jobData) {
        try {
            Long userId = ((Number) jobData.get("userId")).longValue();
            String jobName = (String) jobData.get("jobName");
            String description = (String) jobData.get("description");

            User user = userService.getUserById(userId);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            AdminJobs adminJob = new AdminJobs();
            adminJob.setUser(user);
            adminJob.setJobName(jobName);
            adminJob.setDescription(description);

            AdminJobs createdJob = adjobservice.addJob(adminJob);
            return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteJob/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable Long jobId) {
        String response = adjobservice.delete(jobId);
        if (response.contains("deleted")) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
