package com.example.spring_group_one.lesson_five.controller;

import com.example.spring_group_one.lesson_five.dao.AccountService;
import com.example.spring_group_one.lesson_five.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson/five")
public class ControllerDemo {

    private String location = "/lesson_five/";

    @Autowired
    private AccountService accountService;

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
