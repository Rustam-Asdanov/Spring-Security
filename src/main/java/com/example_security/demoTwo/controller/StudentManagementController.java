package com.example_security.demoTwo.controller;

import com.example_security.demoTwo.dao.UserDAO;
import com.example_security.demoTwo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public List<User> getAllUsers(){
        return userDAO.getUserList();
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        System.out.println(user);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteUser(@PathVariable("userID") Integer userId){
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user){
        System.out.println(String.format("%s %s", userId, user));
    }
}
