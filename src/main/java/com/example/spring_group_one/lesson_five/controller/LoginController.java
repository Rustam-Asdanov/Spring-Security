package com.example.spring_group_one.lesson_five.controller;

import com.example.spring_group_one.lesson_five.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private String location = "/lesson_five/";

    @GetMapping("/login")
    public String getLoginPage(){
        return location + "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "/lesson_five/" + "access-denied";
    }
}
