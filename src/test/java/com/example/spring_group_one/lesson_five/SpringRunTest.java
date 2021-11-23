package com.example.spring_group_one.lesson_five;

import com.example.spring_group_one.lesson_five.controller.ControllerForEveryone;
import com.example.spring_group_one.lesson_five.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringRunTest {

    @Autowired
    private ControllerForEveryone controllerForEveryone;

    @Test
    void isAccountRegistered(){
        // given
        Account account = new Account("mamesd","mamde");
        String text = "redirect:/login";
        // when
        String result = controllerForEveryone.addUser(account);
        // then

        assertThat(result).isEqualTo(text);
    }
}