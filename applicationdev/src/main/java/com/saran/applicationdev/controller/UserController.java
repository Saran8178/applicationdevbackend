package com.saran.applicationdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saran.applicationdev.model.Users;
import com.saran.applicationdev.service.UserService;

@RestController("/api")
public class UserController {
    @Autowired
    private UserService uservice;

    @GetMapping("/getusers")
    public List<Users> getUsers()
    {
        return uservice.getUsers();
    }
    @PostMapping("/register")
    public Users AddUsers(@RequestBody Users user)
    {
        return uservice.addUsers(user);
    }
}
