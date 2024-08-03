package com.saran.applicationdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.applicationdev.model.Users;
import com.saran.applicationdev.repo.UserRepo;

@Service
public class UserService {
       @Autowired
       private UserRepo urepo;

       public List<Users> getUsers(){
        return urepo.findAll();
       }
       public Users addUsers(Users user){
        return urepo.save(user);
       }
}
