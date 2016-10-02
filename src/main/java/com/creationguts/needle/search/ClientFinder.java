package com.creationguts.needle.search;

import com.creationguts.needle.dao.ClientDao;
import com.creationguts.needle.exception.DataException;
import com.creationguts.needle.model.Client;

import java.util.Collection;

/**
 * Class to provide client finding functions
 * Created by Juliano on 10/1/16.
 */
public class ClientFinder {

    private ClientDao clientDao;

    public ClientFinder(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Collection<Client> findByNameLike(String name) throws DataException {
        if (name == null) throw new NullPointerException("Name can't null");

        return clientDao.findByNameLike(name);
    }

    public Collection<Client> findByNameExact(String name) throws DataException {
        if (name == null) throw new NullPointerException("Name can't null");

        return null;
    }
}