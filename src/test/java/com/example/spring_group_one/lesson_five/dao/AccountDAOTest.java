package com.example.spring_group_one.lesson_five.dao;


import com.example.spring_group_one.lesson_five.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AccountDAOTest {

    @Autowired
    private AccountDAO accountDAO;

    @Test
    void isAddAccountWorks(){
        // given
        Account account = new Account("lulush","lulush");
        boolean result = true;
        // when
        try{
            accountDAO.insertAccount(account);
        }catch (Exception ex){
            result = false;
        }
        // then
        assertThat(result).isTrue();
    }
}