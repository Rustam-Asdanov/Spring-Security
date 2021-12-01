package com.example_security.spring_group_one.lesson_three.controller;

import com.example_security.spring_group_one.lesson_three.dao.NewsDAO;
import com.example_security.spring_group_one.lesson_three.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public News getNewsById(@PathVariable("id") int theId){
        return newsDAO.getNewsById(theId);
    }
}
