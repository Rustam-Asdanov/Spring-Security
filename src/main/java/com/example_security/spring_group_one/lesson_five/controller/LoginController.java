package com.example_security.spring_group_one.lesson_five.controller;

import org.springframework.stereotype.Controller;
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
