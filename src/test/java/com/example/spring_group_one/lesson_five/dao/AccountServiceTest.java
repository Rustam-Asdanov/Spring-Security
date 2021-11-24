package com.example.spring_group_one.lesson_five.dao;

import com.example.spring_group_one.lesson_five.model.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class AccountServiceTest {

    @Mock
    private AccountDAO accountDAO;
    private AutoCloseable autoCloseable;
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        accountService = new AccountService(accountDAO);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @Disabled
    void canGetAccountList() {

    }

    @Test
    void addAccount() {
        // given
        Account account = new Account("user add","user add");

        // when
        accountService.addAccount(account);

        // then
        ArgumentCaptor<Account> argumentCaptor =
                ArgumentCaptor.forClass(Account.class);

        verify(accountDAO).addAccount(argumentCaptor.capture());

        Account capturedStudent = argumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(account);
    }

    @Test
    @Disabled
    void findAccountByLogin() {
    }
}