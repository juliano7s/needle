package com.creationguts.needle.dao;

import com.creationguts.needle.exception.DataException;

import java.io.Serializable;
import java.util.Collection;

/**
 * Base interface for daos
 * Created by Juliano on 10/2/16.
 */
public interface BaseDao<T, PK extends Serializable> {

    /**
     * Returns an entity T given an id
     * @param id id of the entity to be returned
     * @return entity with the given id
     * @throws DataException if not found
     */
    T find(PK id) throws DataException;

    /**
     * Returns all entities of <T> on the databse
     * @return all entities of <T>
     * @throws DataException if not found
     */
    Collection<T> findAll() throws DataException;

    /**
     * Persist an entity, inserts if it does not exist or update if it does
     * @param entity to be persisted
     * @return the persisted entity
     */
    T persist(T entity);

    /**
     * Delete an entity on the database
     * @param entity to be deleted
     */
    void delete(T entity);
}
