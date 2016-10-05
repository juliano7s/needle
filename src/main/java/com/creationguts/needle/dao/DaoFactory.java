package com.creationguts.needle.dao;

import com.creationguts.needle.dao.mysql.MySqlDaoFactory;

/**
 * Base factory for daos
 * Created by Juliano on 10/2/16.
 */
public abstract class DaoFactory {

    public static DaoFactory getInstance() throws Exception {
        return new MySqlDaoFactory(MySqlDaoFactory.DB.PROD);
    }

    public static DaoFactory getTestInstance() throws Exception {
        return new MySqlDaoFactory(MySqlDaoFactory.DB.TEST);
    }

    public abstract ClientDao createClientDao() throws Exception;

    public abstract DbCreateDao createDbCreateDao(
            String[][] clientData,
            Object[][] requestData,
            String[][] workerData) throws Exception;

}
