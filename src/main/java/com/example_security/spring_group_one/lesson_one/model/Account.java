package com.example_security.spring_group_one.lesson_one.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private int id;
    private String firstName;
    private String lastName;
}
