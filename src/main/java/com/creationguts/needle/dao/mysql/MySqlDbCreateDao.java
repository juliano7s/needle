package com.creationguts.needle.dao.mysql;

import com.creationguts.needle.dao.DbCreateDao;

import java.sql.*;
import java.util.Arrays;

/**
 * Dao to initialize test database
 * Created by Juliano on 10/2/16.
 */
public class MySqlDbCreateDao extends MySqlBaseDaoImpl implements DbCreateDao {

    private String[][] clientData;
    private Object[][] requestData;
    private String[][] workerData;

    public MySqlDbCreateDao(
            String connectionUrl,
            String[][] clientData,
            Object[][] requestData,
            String[][] workerData) {
        this(connectionUrl);
        this.clientData = clientData;
        this.requestData = requestData;
        this.workerData = workerData;
    }

    public MySqlDbCreateDao(String connectionUrl) {
        super(connectionUrl);
    }

    public void createDb() {
        dropAllTables();
        createTables();
        insertTableData(MySqlDbStructure.insertClientQuery, clientData);
        //insertTableData(MySqlDbStructure.insertRequestQuery, requestData);
        //insertTableData(MySqlDbStructure.insertWorkerQuery, workerData);
    }

    private void dropAllTables() {
        String dropTable = "DROP TABLE IF EXISTS `%s`";

        try (Connection connection = DriverManager.getConnection(this.connectionUrl);
             Statement statement = connection.createStatement()) {
            for (String table : MySqlDbStructure.TABLES) {
                statement.execute(String.format(dropTable, table));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        try (Connection connection = DriverManager.getConnection(this.connectionUrl);
             Statement statement = connection.createStatement()) {
            statement.execute(MySqlDbStructure.createClientTable);
            statement.execute(MySqlDbStructure.createRequestTable);
            statement.execute(MySqlDbStructure.createWorkerTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertTableData(String query, Object[][] data) {
        try (Connection connection = DriverManager.getConnection(this.connectionUrl)) {
            Arrays.stream(data).forEach(a -> {
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setNull(1, Types.INTEGER);
                    int index = 2;
                    for (Object s : a) {
                        statement.setObject(index, s);
                        index++;
                    }
                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
