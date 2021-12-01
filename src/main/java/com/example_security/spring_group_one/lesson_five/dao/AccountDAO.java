package com.example_security.spring_group_one.lesson_five.dao;

import com.example_security.spring_group_one.lesson_five.model.Account;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Component
public class AccountDAO {

    private final ConnectionDB connectionDB;

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

    public void addAccount(Account account){
        String query = String.format("insert into account value('%s','%s');",
                account.getLogin().toLowerCase(Locale.ROOT),account.getPassword());

        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("some error with insert");
            e.printStackTrace();
        }
    }

    public void clearBase(){
        String query = String.format("truncate account");

        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("problem with clearing table");
        }
    }

    public boolean removeByLogin(Account account){
        String query = String.format("delete from account where login = '%s';",account.getLogin());

        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.getStackTrace();
            return false;
        }
        return true;
    }

    public Account findAccountByLogin(String username) {
        String query =
                String.format("select * from account where login = '%s';",username);
        try {
            ResultSet resultSet = connectionDB.getStatement().executeQuery(query);
            if(resultSet.next()){
                return new Account(
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
