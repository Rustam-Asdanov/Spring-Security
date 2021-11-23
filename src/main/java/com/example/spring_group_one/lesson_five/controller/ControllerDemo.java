package com.example.spring_group_one.lesson_five.controller;

import com.example.spring_group_one.lesson_five.dao.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson/five/inside")
public class ControllerDemo {

    private String location = "/lesson_five/";

    @Autowired
    private AccountService accountService;

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
