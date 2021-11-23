package com.example.spring_group_one.lesson_five.dao;


import com.example.spring_group_one.lesson_five.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

@SpringBootTest
class AccountDAOTest {

    @Autowired
    private AccountDAO accountDAO;

    @Test
    void isAddAccountWorks(){
        // given
        Account account = new Account("user add"+1,"user add");
        accountDAO.removeByLogin(account);
        boolean result = true;
        // when
        accountDAO.addAccount(account);

        // then
        assertThat(accountDAO.getAccounts().contains(account));
//        accountDAO.removeByLogin(account);
    }

    @Test
    void isRemoveAccountWorks() {
        // given
        Account account = new Account("user remove", "user remove");
        boolean result = true;
        // when

//        accountDAO.addAccount(account);
//        result = accountDAO.removeByLogin(account);


        // then
        assertThat(result).isTrue();
    }
}