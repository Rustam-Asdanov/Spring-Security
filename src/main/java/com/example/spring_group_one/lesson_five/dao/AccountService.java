package com.example.spring_group_one.lesson_five.dao;

import com.example.spring_group_one.lesson_five.model.Account;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AccountService {

    private final AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Set<Account> getAccountList(){
        return accountDAO.getAccounts();
    }

    public void addAccount(Account account){
        accountDAO.insertAccount(account);
    }
}
