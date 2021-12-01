package com.example_security.spring_group_two;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
@RequestMapping("/just")
public class ControllerDemo {

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("human",new Human());
        return "example";
    }

    @PostMapping("/add")
    public String addElem(@ModelAttribute("human") @Valid Human human,
                          BindingResult bindingResult,
                          @RequestParam("file_name") MultipartFile file,
                          Model model) throws IllegalStateException, IOException {
//        file.transferTo(new File(
//                "C:\\Users\\Rustam\\Desktop\\Developia\\backend\\demdo\\demo\\src\\main\\resources\\static\\img\\user_one\\"+
//                        file.getOriginalFilename()));
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        return "example";
    }
}
