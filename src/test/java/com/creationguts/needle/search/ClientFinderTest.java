package com.creationguts.needle.search;

import com.creationguts.needle.dao.MockClientDao;
import com.creationguts.needle.exception.DataException;
import com.creationguts.needle.model.Client;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

/**
 * Unit test for ClientFinder class
 * Created by Juliano on 10/1/16.
 */
public class ClientFinderTest {

    private static final String NOT_FOUND_CLIENT_NAME = "Ulisses Guimarães";
    private static final String FIND_BY_NAME_EXACT_MATCH = MockClientDao.FIND_BY_NAME_EXACT_MATCH;

    private ClientFinder clientFinder;

    @Before
    public void setUp() {
        this.clientFinder = new ClientFinder(new MockClientDao());
    }

    @Test(expected = RuntimeException.class)
    public void testFindByName_withNull() throws DataException {
        Collection<Client> foundClient = clientFinder.findByNameLike(null);
    }

    @Test
    public void testFindByName_notFound() throws DataException {
        Collection<Client> foundClients = clientFinder.findByNameLike(NOT_FOUND_CLIENT_NAME);

        assert foundClients.isEmpty();
    }

    @Test(expected = RuntimeException.class)
    public void testFindByNameExact_withNull() throws DataException {
        Collection<Client> foundClients = clientFinder.findByNameExact(null);
    }

    @Test(expected = RuntimeException.class)
    public void testFindByNameExact_notFound() throws DataException {
        Collection<Client> foundClients = clientFinder.findByNameExact(NOT_FOUND_CLIENT_NAME);

        assert foundClients.isEmpty();
    }
}
