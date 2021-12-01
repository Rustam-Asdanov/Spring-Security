package com.example_security.spring_group_one.lesson_four.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {


    @GetMapping("login")
    public String getLoginPage(HttpSession session){


        CsrfToken token
                = (CsrfToken) session.getAttribute("HttpSessionCsrfTokenRepository.CSRF_TOKEN");

        System.out.println(token);
        return "/lesson_four/login";
    }
}
