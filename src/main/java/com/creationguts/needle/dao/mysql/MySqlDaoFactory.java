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

    private String connectionUrl;

    public enum DB {
        TEST,
        PROD
    }

    public MySqlDaoFactory(DB db) throws Exception {
        this.connectionUrl = getJdbcUrl(db);
    }

    @Override
    public ClientDao createClientDao() throws Exception {
        return new MySqlClientDaoImpl(connectionUrl);
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
