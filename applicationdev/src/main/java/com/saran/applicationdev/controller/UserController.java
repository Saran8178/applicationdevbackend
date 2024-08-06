package com.saran.applicationdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saran.applicationdev.model.User;
import com.saran.applicationdev.service.UserService;

@RestController
@RequestMapping("/api") // Add this annotation to ensure proper mapping
public class UserController {
    @Autowired
    private UserService uservice;

    @GetMapping("/getusers")
    public List<User> getUsers() {
        return uservice.getUsers();
    }

    @PostMapping("/register")
    public User AddUsers(@RequestBody User user) {
        return uservice.addUsers(user);
    }
}
