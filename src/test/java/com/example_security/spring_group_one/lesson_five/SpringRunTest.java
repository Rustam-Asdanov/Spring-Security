package com.example_security.spring_group_one.lesson_five;

import com.example_security.spring_group_one.lesson_five.auth.ApplicationUserService;
import com.example_security.spring_group_one.lesson_five.dao.AccountDAO;
import com.example_security.spring_group_one.lesson_five.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringRunTest {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private ApplicationUserService applicationUserService;

    @Test
    void isAccountRegistered(){
        // given
        Account account = new Account("mamesd","mamde");
        String text = "redirect:/login";
        // when
//        String result = accountDAO.addAccount(account);
        // then

//        assertThat(result).isEqualTo(text);
    }

    /**
     * there we try to check how fast work
     * checking and login process in this application
     *  with MySQL search engine approximately --- 350ms
     *  with Hibernate search engine approximately ---
     */
    @Test
    void howFast(){
        // given
        Account account;
        long timerStart;
        long timerEnd;
        accountDAO.clearBase();

        // when

        for(int i=0; i<100; i++){
            account = new Account("temporary"+i,"temporary"+i);
            accountDAO.addAccount(account);
        }

        // then
        timerStart = System.currentTimeMillis();
        int i = (int) (Math.random()*100);
        applicationUserService.loadUserByUsername("temporary"+i);
        timerEnd = System.currentTimeMillis();

        System.out.println(timerEnd-timerStart);
        accountDAO.clearBase();
    }

}