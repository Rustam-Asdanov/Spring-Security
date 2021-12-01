package com.example_rest.example_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example/rest/c1")
public class ControllerDemo {

    private String location = "/example_rest/example_1/";

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("messages","hi");

        return "example";
    }
}
