package com.example.spring_group_one.lesson_one.dao;

import com.example.spring_group_one.lesson_one.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AccountsDAO {
    private List<Account> accountList;

    {
        if(accountList == null){
            accountList = new ArrayList<>();

            Collections.addAll(
                    accountList,
                    new Account(1,"John","Canada"),
                    new Account(2,"King", "USA"),
                    new Account(3,"Tom","UK")
            );
        }
    }

    public List<Account> getAccountList(){
        return accountList;
    }

    public void addAccount(Account theAccount){
        accountList.add(theAccount);
    }

    public void deleteAccountById(int theAccountId){
        accountList.remove(theAccountId);
    }

    public void updateAccountById(int theAccountId, Account theAccount){
        accountList.set(theAccountId,theAccount);
    }
}
