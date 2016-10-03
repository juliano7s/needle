package com.creationguts.needle.dao.mysql;

import com.creationguts.needle.dao.ClientDao;
import com.creationguts.needle.dao.DaoFactory;
import com.creationguts.needle.exception.DataException;
import com.creationguts.needle.model.Client;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

/**
 * Test class for {@code MySqlClientDaoImpl}
 * Created by Juliano on 10/2/16.
 */
public class MySqlClientDaoImplTest {

    private ClientDao clientDao;

    @Before
    public void setUp() throws Exception {
        MySqlTestDbCreateDao dbCreateDao = (MySqlTestDbCreateDao)
                DaoFactory.getTestInstance().createTestDbCreateDao();
        dbCreateDao.createTestDb();
        clientDao = DaoFactory.getTestInstance().createClientDao();
    }

    @Test
    public void testFindAll() throws DataException {
        Collection<Client> clients = clientDao.findAll();
    }

}
