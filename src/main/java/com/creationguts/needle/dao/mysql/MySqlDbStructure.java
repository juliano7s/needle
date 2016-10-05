package com.creationguts.needle.dao.mysql;

/**
 * Provides the structure of needle database on mysql
 * Created by Juliano on 10/4/16.
 */
public class MySqlDbStructure {

    public enum Table {
        CLIENT("client"),
        REQUEST("request"),
        WORKER("worker");

        Table(String tableName) {
            this.name = tableName;
        }

        public String getName() {
            return name;
        }

        private String name;
    }

    public static final String[] TABLES = {
            Table.REQUEST.name,
            Table.CLIENT.name,
            Table.WORKER.name
    };

    public static final String insertClientQuery = "INSERT INTO `" +
            Table.CLIENT.name + "` VALUES (?, ?, ?, ?, ?, ?)";

    public static final String createClientTable = "CREATE TABLE `" + Table.CLIENT.name + "` (" +
            "  `client_id` int(10) unsigned NOT NULL AUTO_INCREMENT," +
            "  `cpf` varchar(11) NULL UNIQUE," +
            "  `name` varchar(150) NOT NULL," +
            "  `email` varchar(150) NULL UNIQUE," +
            "  `phone` varchar(150) DEFAULT NULL," +
            "  `address` varchar(255) DEFAULT NULL," +
            "  PRIMARY KEY (`client_id`)" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";

    public static final String insertRequestQuery = "INSERT INTO `" +
            Table.REQUEST.name + "` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String createRequestTable = "CREATE TABLE `" + Table.REQUEST.name + "` (" +
            "  `request_id` int(10) unsigned NOT NULL AUTO_INCREMENT," +
            "  `client_id` int(10) unsigned NOT NULL," +
            "  `worker_id` int(10) DEFAULT NULL," +
            "  `description` text," +
            "  `status` varchar(20) NOT NULL DEFAULT 'PENDING'," +
            "  `added_date` datetime DEFAULT NULL," +
            "  `delivery_date` datetime DEFAULT NULL," +
            "  `scheduled_date` datetime DEFAULT NULL," +
            "  `ready_date` datetime DEFAULT NULL," +
            "  `price` float(10,2) DEFAULT NULL," +
            "  `cost` float(10,2) DEFAULT NULL," +
            "  PRIMARY KEY (`request_id`)," +
            "  KEY `fk_request_client` (`client_id`)," +
            "  KEY `fk_request_worker` (`worker_id`)," +
            "  CONSTRAINT `fk_request_client` FOREIGN KEY (`client_id`) REFERENCES `" + Table.CLIENT.name + "` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";

    public static final String insertWorkerQuery = "INSERT INTO `" +
            Table.WORKER.name + "` VALUES (?, ?, ?, ?)";

    public static final String createWorkerTable = "CREATE TABLE `" + Table.WORKER.name + "` (" +
            "  `worker_id` int(10) unsigned NOT NULL AUTO_INCREMENT," +
            "  `name` varchar(150) NOT NULL," +
            "  `email` varchar(150) NULL UNIQUE," +
            "  `phone` varchar(150) DEFAULT NULL," +
            "  PRIMARY KEY (`worker_id`)" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;";

}
