package com.example.spring_group_one.lesson_five.dao;

import org.junit.jupiter.api.Test;

import java.sql.Statement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConnectionDBTest {

    @Test
    void isBaseConnected(){
        // given
        boolean conn = true;
        // when
        boolean isConn = new ConnectionDB().getConnection();
        // then
        assertThat(isConn).isEqualTo(conn);
    }

    @Test
    void isStatementNotNull(){
        // given
        boolean statementIsExists = true;
        // when
        Statement isStatementExist = new ConnectionDB().getStatement();

        // then
        assertThat(isStatementExist).isNotEqualTo(null);
    }
}