package com.example_security.spring_group_one.lesson_five.controller;

import com.example_security.spring_group_one.lesson_five.dao.AccountService;
import com.example_security.spring_group_one.lesson_five.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson/five")
public class ControllerForEveryone {

    private String location = "/lesson_five/";

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String getPage(){
        return location+"main";
    }

    @GetMapping("/registration")
    public String getRegPage(Model model){
        model.addAttribute("new_account",new Account());
        return location+"registration";
    }

    @PostMapping("/add_new_user")
    public String addUser(@ModelAttribute Account account){
        accountService.addAccount(account);
        return "redirect:/login";
    }
}
