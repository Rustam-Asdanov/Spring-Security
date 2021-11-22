package com.example.spring_group_one.lesson_five.dao;

import com.example.spring_group_one.lesson_five.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
public class AccountDAO {


    private final ConnectionDB connectionDB;

    @Autowired
    public AccountDAO(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    public Set<Account> getAccounts(){
        Set<Account> accountSet = new HashSet<>();
        try {
            ResultSet resultSet = connectionDB.getStatement().executeQuery("select * from account;");
            while(resultSet.next()){
                accountSet.add(
                        new Account(
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("some problems with getting data");
        }

        return accountSet;
    }

    public void insertAccount(Account account){
        String query = String.format("insert into account value('%s','%s');",
                account.getLogin(),account.getPassword());

        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("some error with insert");
        }
    }
}
