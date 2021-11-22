package com.example.spring_group_one.lesson_five.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private String login;
    private String password;

    public Account() {
    }
}
