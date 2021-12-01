package com.example_security.spring_group_one.lesson_two.controller;

import com.example_security.spring_group_one.lesson_two.dao.NewsDAO;
import com.example_security.spring_group_one.lesson_two.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/page")
public class ControllerDemo {

    @Autowired
    private NewsDAO newsDAO;

    @GetMapping
    public List<News> getPage(){
        return newsDAO.getNewsList();
    }
}
