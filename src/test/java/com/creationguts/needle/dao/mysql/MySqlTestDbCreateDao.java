package com.creationguts.needle.dao.mysql;

import com.google.common.base.Joiner;
import com.google.common.util.concurrent.ExecutionError;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Dao to initialize test database
 * Created by Juliano on 10/2/16.
 */
public class MySqlTestDbCreateDao extends MySqlBaseDaoImpl {

    public MySqlTestDbCreateDao(String connectionUrl) {
        super(connectionUrl);
    }

    public void createTestDb() {
        dropAllTables();
        createTables();
        insertTableData();
    }

    private void dropAllTables() {
        String dropClientTable = "DROP TABLE IF EXISTS client";
        String dropOrderTable = "DROP TABLE IF EXISTS order";
        Joiner joiner = Joiner.on(';');

        String dropAllTables = joiner.join(dropClientTable, dropOrderTable);
        try(Connection connection = DriverManager.getConnection(this.connectionUrl);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(dropAllTables)) {

        } catch (Exception e) {

        }
    }

    private void createTables() {
        createClientTable();
    }

    private void insertTableData() {

    }

    private void createClientTable() {

    }
}
