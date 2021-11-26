package com.example.spring_group_one.lesson_three.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping("login")
    public String getLoginPage(){
        return "/lesson_three/login";
    }

    @GetMapping("logout")
    public String getLogoutPage(){
        return  "/lesson_three/logout";
    }

    @GetMapping("access-denied")
    public String showAccessDenied(){
        return "/lesson_five/" + "access-denied";
    }

    @GetMapping
    public String showPage(){
        return "/lesson_three/main";
    }
}
