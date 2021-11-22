package com.example.demoTwo.controller;

import com.example.demoTwo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class ControllerDemo {

    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public String getPage(Model model){

        model.addAttribute("userList",userDAO.getUserList());

        return "/lesson/main";
    }

    @PostMapping("/{userId}")
    public String getUser(@PathVariable(name = "userId") int userId, Model model){
        System.out.println(userId);
        model.addAttribute("users",userDAO.getUserById(userId));
        return "lesson/main";
    }
}
