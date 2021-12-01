package com.example_rest.example_1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/example/rest/c2")
public class RestControllerDemo {

    private List<String> list;

    @GetMapping("/get")
    public List<String> getResult(){
        return list;
    }

    @GetMapping("/add")
    public void addElem(@RequestParam("messages") String message){

        if(list==null){
            list = new ArrayList<>();
            list.add("mamba");
        }

        list.add(message);
    }


}
