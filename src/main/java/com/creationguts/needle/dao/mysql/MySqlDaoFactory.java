package com.creationguts.needle.dao.mysql;

import com.creationguts.needle.dao.ClientDao;
import com.creationguts.needle.dao.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Dao Factory for MySql dao implementations
 * Created by Juliano on 10/2/16.
 */
public class MySqlDaoFactory extends DaoFactory{

    private static final String baseUrl = "jdbc:mysql://%s/%s?user=%s&password=%s";

    private static String[] testParameters = { "localhost", "needle_test", "root", "root" };
    private static String[] prodParameters = { "localhost", "needle", "root", "root" };

    private Connection connection;

    public enum DB {
        TEST,
        PROD
    }

    public MySqlDaoFactory(DB db) throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(getJdbcUrl(db));
    }

    @Override
    public ClientDao createClientDao() throws Exception {
        return new MySqlClientDaoImpl(connection);
    }

    private static String getJdbcUrl(DB db) {
        String[] parameters = new String[4];
        switch (db) {
            case TEST:
                parameters = testParameters;
                break;
            case PROD:
                parameters = prodParameters;
                break;
        }

        return String.format(baseUrl, parameters[0], parameters[1], parameters[2], parameters[3]);
    }
}
