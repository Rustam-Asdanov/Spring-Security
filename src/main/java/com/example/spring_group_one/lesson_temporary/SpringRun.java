package com.example.spring_group_one.lesson_temporary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:persistence-mysql.properties")
public class SpringRun {
    public static void main(String[] args){
        SpringApplication.run(SpringRun.class,args);
        System.out.println("Success");
    }
}
