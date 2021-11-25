package com.example.spring_group_one.lesson_five.dao;

import com.example.spring_group_one.lesson_five.model.Account;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountDAO accountDAO;

    public AccountService(PasswordEncoder passwordEncoder, AccountDAO accountDAO) {
        this.passwordEncoder = passwordEncoder;
        this.accountDAO = accountDAO;
    }


    public Set<Account> getAccountList(){
        return accountDAO.getAccounts();
    }

    public void addAccount(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountDAO.addAccount(account);
    }

    public Account findAccountByLogin(String username) {
        return accountDAO.findAccountByLogin(username);
    }
}
