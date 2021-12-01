package com.example_security.spring_group_one.lesson_five.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Statement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ConnectionDBTest {

    @Autowired
    private ConnectionDB connectionDB;

    @Test
    void isBaseConnected(){
        // given

        // when
        Object isConn = connectionDB.getConnection();
        // then
        assertThat(isConn).isNotEqualTo(null);
    }

    @Test
    void isStatementNotNull(){
        // given
        boolean statementIsExists = true;
        // when
        Statement isStatementExist = connectionDB.getStatement();

        // then
        assertThat(isStatementExist).isNotEqualTo(null);
    }
}