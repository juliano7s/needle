package com.creationguts.needle.dao.mysql;

import com.creationguts.needle.dao.TestDbCreateDao;

import java.sql.*;
import java.util.Arrays;

/**
 * Dao to initialize test database
 * Created by Juliano on 10/2/16.
 */
public class MySqlTestDbCreateDao extends MySqlBaseDaoImpl implements TestDbCreateDao {

    private static final String CLIENT_TABLE = "client";
    private static final String ORDER_TABLE = "order";
    private static final String[] TABLES = { CLIENT_TABLE, ORDER_TABLE };
    private static final String[][] clientData = {
        { "12312312312","ANA BUT", null },
        { "09876543211","Paulo Hübbe","paulo@hotmail.com" },
        { "13524678900","Fabrizia Faulhaber","ff@gmail.com" },
        { null,"Jorge Has", null },
        { "11122233344","Ana Laura Belmonte","flaura@me.com" },
        { null,"Adriana Cruz","adri@facebook.com.br " },
        { "99988877766","Marli Weber", null },
        { null,"12345678900","Lisandra", null }
    };

    public MySqlTestDbCreateDao(String connectionUrl) {
        super(connectionUrl);
    }

    public void createTestDb() {
        dropAllTables();
        createTables();
        insertTableData();
    }

    private void dropAllTables() {
        String dropTable = "DROP TABLE IF EXISTS `%s`";

        try (Connection connection = DriverManager.getConnection(this.connectionUrl);
             Statement statement = connection.createStatement()) {
            for (String table : TABLES) {
                statement.execute(String.format(dropTable, table));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        String createClientTable = "CREATE TABLE `" + CLIENT_TABLE + "` (" +
                "  `clientid` int(10) unsigned NOT NULL AUTO_INCREMENT," +
                "  `cpf` varchar(11) NULL UNIQUE," +
                "  `name` varchar(150) NOT NULL," +
                "  `email` varchar(150) NULL UNIQUE," +
                "  PRIMARY KEY (`clientid`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";

        try (Connection connection = DriverManager.getConnection(this.connectionUrl);
             Statement statement = connection.createStatement()) {
            statement.execute(createClientTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertTableData() {
        String insertQuery = "INSERT INTO `%s` VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(this.connectionUrl)) {
            Arrays.stream(clientData)
                    .forEach(a -> {
                        StringBuilder query = new StringBuilder(String.format(insertQuery, CLIENT_TABLE));
                        try(PreparedStatement statement = connection.prepareStatement(query.toString())) {
                            statement.setNull(1, Types.INTEGER);
                            statement.setString(2, a[0]);
                            statement.setString(3, a[1]);
                            statement.setString(4, a[2]);
                            statement.execute();
                            System.out.println(statement.toString());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
