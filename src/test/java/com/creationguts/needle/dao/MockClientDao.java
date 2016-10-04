package com.creationguts.needle.dao;

import com.creationguts.needle.exception.DataException;
import com.creationguts.needle.model.Client;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class to mock an implementation of a client dao
 * Created by Juliano on 10/2/16.
 */
public class MockClientDao implements ClientDao {

    public static final String FIND_BY_NAME_EXACT_MATCH = "Jack Sparrow";

    private LinkedList<Client> persistedClients = new LinkedList<>();
    private long autoIncrementIndex;

    public MockClientDao() {
        persistedClients.addAll(initClients());
        autoIncrementIndex = persistedClients.size();
    }

    @Override
    public Client find(Long id) throws DataException {
        Optional<Client> maybeClient = persistedClients.stream()
                .filter(c -> c.getId() == id)
                .reduce((a, b) -> {
                    throw new IllegalStateException("More than one entity with the same id");
                });

        return maybeClient
                .orElseThrow(() -> new DataException("Client not found with id = " + id));
    }

    @Override
    public Collection<Client> findAll() throws DataException {
        return null;
    }

    @Override
    public Client persist(Client entity) {
        Optional<Client> maybeClient = persistedClients.stream()
                .filter(c -> c.getId() == entity.getId())
                .reduce((a, b) -> {
                    throw new IllegalStateException("More than one entity with the same id");
                });

        Client persisted;
        if (maybeClient.isPresent()) {
            persisted = (Client) entity.clone();
        } else {
            long id = autoIncrementIndex++;
            entity.setId(id);
            persisted = entity;
        }
        persistedClients.add(persisted);

        return persisted;
    }

    @Override
    public void delete(Client entity) {

    }

    @Override
    public Collection<Client> findByNameLike(String name) {
        return persistedClients.stream()
                .filter(c -> c.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Client> findByNameExact(String name) {
        return null;
    }

    private static Collection<Client> initClients() {
/*
        Client[] clients = new Client[5];
        clients[0] = new Client(1, FIND_BY_NAME_EXACT_MATCH, "00000000000");
        clients[1] = new Client(2, "Elizabeth Windsor", "11111111111");
        clients[2] = new Client(3, "Joan of Arc", "22222222222");
        clients[3] = new Client(4, "Luciana Genro", "33333333333");
        clients[4] = new Client(5, "Dilma Roussef", "44444444444");



        return Arrays.stream(clients).collect(Collectors.toList());
*/
        return null;
    }
}
