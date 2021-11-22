package com.example.spring_group_one.lesson_three.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private int id;
    private String name;
    private String country;
}
