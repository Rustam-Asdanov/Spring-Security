package com.example.spring_group_one.lesson_three.controller;

import com.example.spring_group_one.lesson_three.dao.AccountDAO;
import com.example.spring_group_one.lesson_three.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/users")
public class ControllerAdminUsers {

    @Autowired
    private AccountDAO accountDAO;
    private final String mainURL = "/manager/page";

    @GetMapping
    public List<Account> getAccounts(){
        return accountDAO.getAccountList();
    }

    @PostMapping
    public String addAccount(@RequestBody Account theAccount){
        accountDAO.getAccountList().add(theAccount);
        return mainURL;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable("id") int id){
        accountDAO.deleteAccountById(id);
        return mainURL;
    }

    @PutMapping("/update/{id}")
    public String updateAccount(
            @PathVariable("id") int id,
            @RequestBody Account theAccount
    ){
        accountDAO.updateAccountById(id,theAccount);
        return mainURL;
    }
}
