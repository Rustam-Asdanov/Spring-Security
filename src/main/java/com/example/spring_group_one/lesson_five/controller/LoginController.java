package com.example.spring_group_one.lesson_five.controller;

import com.example.spring_group_one.lesson_five.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private String location = "/lesson_five/";

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("account", new Account());
        return location + "login";
    }

    @PostMapping("/login_check")
    public void checkData(@ModelAttribute Account account){

    }

    @GetMapping("/registration")
    public String getRegPage(Model model){
        model.addAttribute("new_account",new Account());
        return location+"registration";
    }
}
