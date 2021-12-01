package com.example_security.spring_group_one.lesson_five.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class ConnectionDB {

    private final String URL = "jdbc:mysql://localhost:3310/exercise";
    private final String USERNAME = "root";
    private final String PASSWORD = "11111";
    private Connection conn;
    private Statement statement;

    private void startConnection(){
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Problem with connection");
        }
    }

    public Connection getConnection() {
        startConnection();
        return conn;
    }

    public Statement getStatement() {
        getConnection();
        return statement;
    }
}
