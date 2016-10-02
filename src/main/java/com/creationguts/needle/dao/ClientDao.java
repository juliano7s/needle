package com.creationguts.needle.dao;

import com.creationguts.needle.model.Client;

import java.util.Collection;

/**
 * ClientDao interface to define access for client data
 * Created by Juliano on 10/2/16.
 */
public interface ClientDao extends BaseDao<Client, Long> {

    /**
     * Get clients given a name.
     * @param name name to search
     * @return a {@code Collection} of clients with the given name
     */
    Collection<Client> findByNameLike(String name);

    /**
     * Get clients given a name.
     * @param name name to search
     * @return a {@code Collection} of clients with the given name
     */
    Collection<Client> findByNameExact(String name);
}
