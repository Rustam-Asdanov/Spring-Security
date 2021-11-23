package com.example.spring_group_one.lesson_five.dao;

import com.example.spring_group_one.lesson_five.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;


    public Set<Account> getAccountList(){
        return accountDAO.getAccounts();
    }

    public void addAccount(Account account){
            accountDAO.addAccount(account);
    }

    public Account findAccountByLogin(String username) {
        return accountDAO.findAccountByLogin(username);
    }
}
