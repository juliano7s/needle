package com.creationguts.needle.dao.mysql;

import com.creationguts.needle.dao.BaseDao;

import java.io.Serializable;
import java.sql.Connection;

/**
 * Base class for MySQL dao implementations
 * Created by Juliano on 10/2/16.
 */
public abstract class MySqlBaseDaoImpl {

    protected String connectionUrl;

    public MySqlBaseDaoImpl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
}
