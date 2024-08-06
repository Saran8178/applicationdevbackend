package com.saran.applicationdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.applicationdev.model.User;

import com.saran.applicationdev.repo.UserRepo;

@Service
public class UserService {
       @Autowired
       private UserRepo urepo;

       public List<User> getUsers(){
        return urepo.findAll();
       }
       public User addUsers(User user){
        return urepo.save(user);
       }
       public User getUserById(Long userId) {
              return urepo.findById(userId).orElse(null);
          }
          
}
