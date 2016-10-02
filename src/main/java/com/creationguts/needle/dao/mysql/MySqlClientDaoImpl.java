package com.creationguts.needle.dao.mysql;

import com.creationguts.needle.dao.ClientDao;
import com.creationguts.needle.exception.DataException;
import com.creationguts.needle.model.Client;

import java.util.Collection;

/**
 * MySQL implementation of {@code ClientDao}
 * Created by Juliano on 10/2/16.
 */
public class MySqlClientDaoImpl extends MySqlBaseDaoImpl implements ClientDao {

    public MySqlClientDaoImpl(String connectionUrl) {
        super(connectionUrl);
    }

    @Override
    public Client find(Long id) throws DataException {
        return null;
    }

    @Override
    public Collection<Client> findAll() throws DataException {
        return null;
    }

    @Override
    public Client persist(Client entity) {
        return null;
    }

    @Override
    public void delete(Client entity) {

    }

    @Override
    public Collection<Client> findByNameLike(String name) {
        return null;
    }

    @Override
    public Collection<Client> findByNameExact(String name) {
        return null;
    }
}
