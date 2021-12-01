package com.example_security.spring_group_one.lesson_four.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson_four/page")
public class ControllerDemo {

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("info", "you should authorize");
        return "/lesson_four/main";
    }

//    @GetMapping("/login")
//    public String getLoginPage(){
//        return "/lesson_four/login";
//    }

    @GetMapping("/user")
    public String getUserPage(Model model){
        model.addAttribute("info", "You are in user page");
        return "/lesson_four/main";
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model){
        model.addAttribute("info", "You are in admin club");
        return "/lesson_four/main";
    }

    @GetMapping("/admin/pro")
    public String getAdminProPage(Model model){
        model.addAttribute("info","You are in admin pro page");
        return "/lesson_four/main";
    }
}
