package com.example.spring_group_one.lesson_three.dao;

import com.example.spring_group_one.lesson_three.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AccountDAO {

    private List<Account> accountList;

    {
        if(accountList == null){
            accountList = new ArrayList<>();
            Collections.addAll(
                    accountList,
                    new Account(1,"John","Brazil"),
                    new Account(2,"Ket","Argentina"),
                    new Account(3,"Mamed","Azerbaijan")
            );
        }
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public Account getAccountById(int id){
        return accountList.stream()
                .filter(account -> account.getId()==id)
                .findFirst()
                .orElse(new Account(0,"Not found","not found"));
    }

    public void deleteAccountById(int id){
        Account account_rem = getAccountById(id);

        accountList.remove(account_rem);
        System.out.println("remove success");
    }

    public void updateAccountById(int id, Account theAccount){
           accountList.set(
                   accountList.indexOf(getAccountById(id)),
                   theAccount);
    }
}
