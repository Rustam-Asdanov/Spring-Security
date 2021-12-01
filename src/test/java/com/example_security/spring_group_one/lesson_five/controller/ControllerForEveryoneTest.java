package com.example_security.spring_group_one.lesson_five.controller;

import com.example_security.spring_group_one.lesson_five.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ControllerForEveryoneTest {

    @Autowired
    private ControllerForEveryone controllerForEveryone;

    @Test
    void isRegistrationWorkProperly(){
        // given
        Account account = new Account("mamed","mamed");
        String existsLink = "redirect:/login";
        // when
        String text = controllerForEveryone.addUser(account);
        // then
        assertThat(text).isEqualTo(existsLink);
    }

}