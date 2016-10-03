package com.creationguts.needle.dao.mysql;

import com.creationguts.needle.dao.TestDbCreateDao;
import com.creationguts.needle.model.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao to initialize test database
 * Created by Juliano on 10/2/16.
 */
public class MySqlTestDbCreateDao extends MySqlBaseDaoImpl implements TestDbCreateDao {

    private static final String CLIENT_TABLE = "client";
    private static final String ORDER_TABLE = "order";
    private static final String[] TABLES = { CLIENT_TABLE, ORDER_TABLE };
    protected static final List<Client> CLIENT_DATA = new ArrayList<>();

    {
        CLIENT_DATA.add(new Client("12312312312","ANA BUT", null));
        CLIENT_DATA.add(new Client("09876543211","Paulo Hübbe","paulo@hotmail.com"));
        CLIENT_DATA.add(new Client("13524678900","Fabrizia Faulhaber","ff@gmail.com"));
        CLIENT_DATA.add(new Client(null,"Jorge Has", null));
        CLIENT_DATA.add(new Client("11122233344","Ana Laura Belmonte","flaura@me.com"));
        CLIENT_DATA.add(new Client(null,"Adriana Cruz","adri@facebook.com.br "));
        CLIENT_DATA.add(new Client("99988877766","Marli Weber", null));
        CLIENT_DATA.add(new Client(null,"12345678900","Lisandra", null));
    }


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
        String insertClientData = "INSERT INTO `" + CLIENT_TABLE + "` " +
                "VALUES (null,'12312312312','ANA BUT',NULL)," +
                "       (null,'12345678900','Lisandra',NULL)," +
                "       (null,'09876543211','Paulo Hübbe','paulo@hotmail.com')," +
                "       (null,'13524678900','Fabrizia Faulhaber','ff@gmail.com')," +
                "       (null,null,'Jorge Has',NULL)," +
                "       (null,11122233344,'Ana Laura Belmonte','flaura@me.com')," +
                "       (null,null,'Adriana Cruz','adri@facebook.com.br ')," +
                "       (null,99988877766,'Marli Weber',NULL)";

        try (Connection connection = DriverManager.getConnection(this.connectionUrl);
             Statement statement = connection.createStatement()) {
            statement.execute(insertClientData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
