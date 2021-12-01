package com.example_security.spring_group_one.lesson_one.controller;

import com.example_security.spring_group_one.lesson_one.dao.AccountsDAO;
import com.example_security.spring_group_one.lesson_one.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group_one/main")
public class ControllerDemo {

    @Autowired
    private AccountsDAO accountsDAO;

    @GetMapping
    public List<Account> getAllAccount(){
        System.out.println("All accounts return");
        return accountsDAO.getAccountList();
    }

    @GetMapping("/get/{id}")
    public Account getAccount(@PathVariable("id") int theId){
        System.out.println("you get account with id: " + theId);
        return accountsDAO.getAccountList().get(theId);
    }

    @PostMapping("/add")
    public void addAccount(@RequestBody Account account){
        accountsDAO.addAccount(account);
        System.out.println("we add new account: " + account);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable("id") int theId){
        accountsDAO.deleteAccountById(theId);
        System.out.println("we delete account with id: " + theId);
    }

    @PutMapping("/update/{id}")
    public void updateAccount(@PathVariable("id") int theId, @RequestBody Account account){
        accountsDAO.updateAccountById(theId,account);
        System.out.println("we update account with id: " + theId + " to: " + account);
    }
}
