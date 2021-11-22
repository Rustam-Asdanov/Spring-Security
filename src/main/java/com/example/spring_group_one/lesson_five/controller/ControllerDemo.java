package com.example.spring_group_one.lesson_five.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson/five")
public class ControllerDemo {

    private String location = "/lesson_five/";

    @GetMapping
    public String getPage(){
        return location+"main";
    }

    @GetMapping("/user")
    public String getUserPage(Model model){

        model.addAttribute("info","Users and admins are here");
        return location+"page";
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model){
        model.addAttribute("info","Only admins here");
        return location+"page";
    }
}
