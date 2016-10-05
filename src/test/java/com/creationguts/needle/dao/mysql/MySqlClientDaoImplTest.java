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
        MySqlDbCreateDao dbCreateDao = (MySqlDbCreateDao)
                DaoFactory.getTestInstance().createDbCreateDao(clientData, requestData, workerData);
        dbCreateDao.createDb();
        clientDao = DaoFactory.getTestInstance().createClientDao();
    }

    @Test
    public void testFindAll() throws DataException {
        Collection<Client> clients = clientDao.findAll();
    }

    private static final String[][] clientData = {
            {"12312312312", "ANA BUT", null, null, null},
            {"09876543211", "Paulo Hübbe", "paulo@hotmail.com", null, null},
            {"13524678900", "Fabrizia Faulhaber", "ff@gmail.com", null, null},
            {null, "Jorge Has", null, null, null},
            {"11122233344", "Ana Laura Belmonte", "flaura@me.com", null, null},
            {null, "Adriana Cruz", "adri@facebook.com.br ", null, null},
            {"99988877766", "Marli Weber", null, null, null},
            {"12345678900", "Lisandra", null, null, null}
    };

    private static final Object[][] requestData = {
            {1, "Reparo em 1 lençol e diminuir 2 fronhas", "2012-07-02 00:00:00", "2012-07-11 00:00:00", null, 25.00, null, null, 1, 1, null},
            {2, "Camisa reparo em baixo dos braços e camisola reparo na manga.", "2012-06-26 00:00:00", "2012-07-02 00:00:00", null, 15.00, null, "ok", 1, 0, null},
            {3, "ziper bolso interno jaqueta", "2012-06-28 00:00:00", "2012-07-02 00:00:00", null, 30.00, null, null, 1, 0, null},
            {3, "Aumentar bolso casaco e barra calça", "1012-07-02 00:00:00", "2012-07-09 00:00:00", null, 32.00, null, null, 1, 1, null},
            {5, "3 casacos - mangas\r\n2 casaquinhos mangas\r\n1 pijama - barra e manga\r\n2 casaquinhos mangas", "2012-07-02 00:00:00", "2012-07-11 00:00:00", null, 140.00, null, null, 1, 0, null},
            {6, "8 calças ajuste\r\n2 retornos\r\nmais 1 calça jeans - ziper (já entregue", "2012-06-01 00:00:00", "2012-07-31 00:00:00", null, 135.00, null, null, 1, 1, null},
            {8, "tirar drapeado do vestido p/ usar separado", "2012-06-13 00:00:00", "2012-06-22 00:00:00", null, 25.00, null, "ok", 1, 0, null},
            {9, "Várias peças - barras - ajustes", "2012-06-01 00:00:00", "2012-06-22 00:00:00", null, 45.00, null, "ok", 1, 0, null},
            {10, "1 camisas baixar colarinho", "2012-07-03 00:00:00", "2012-07-11 00:00:00", null, 20.00, null, null, 1, 0, null},
            {11, "Casaco - Gola", "2012-06-01 00:00:00", "2012-07-03 00:00:00", null, 15.00, null, null, 1, 0, null},
            {12, "1 ziper calça\r\n1 casaco diminuir a manga", "2012-07-03 00:00:00", "2012-07-11 00:00:00", null, 35.00, null, null, 1, 1, null},
            {14, "Saia diminuir cintura\r\ncalça barra", "2012-07-02 00:00:00", "2012-07-05 00:00:00", null, 30.00, null, "ok", 1, 0, null},
            {15, "Vestido barra", "2012-07-03 00:00:00", "2012-09-10 00:00:00", null, 30.00, null, "Cleusa", 1, 1, 1},
            {16, "Calça - soltar cós\r\ncasacos - reparos", "2012-07-03 00:00:00", "2012-07-11 00:00:00", null, 25.00, null, null, 1, 1, null},
            {17, "7 peças\r\n2 calças - barra\r\ncasaco - pressão não foi p Cleusa\r\ncasaco verde encurtar\r\n3 camisas encurtar manter a forma na rosa e verde", "2012-07-02 00:00:00", "2012-07-10 00:00:00", null, 85.00, null, "Cleusa", 1, 1, 1},
            {18, "calça - barra e ajuste", "2012-06-21 00:00:00", "2012-07-03 00:00:00", null, 25.00, 25.00, null, 1, 0, null},
            {19, "Calça - reparo cós e ziper.", "2012-07-03 00:00:00", "2012-08-17 00:00:00", null, 10.00, null, null, 1, 1, null},
            {20, "3 camisas ajuste", "2012-07-02 00:00:00", "2012-07-10 00:00:00", null, 60.00, null, "Cleusa", 1, 0, 1},
            {22, "1 vestido ajuste 15, 00\r\n1 calça c ajuste 15, 00\r\n1 bermuda - 25, 00\r\n1 saia cortar 10, 00", "2012-07-03 00:00:00", "2012-07-10 00:00:00", null, 65.00, null, null, 1, 1, null},
            {23, "Casacão reforma", "2012-06-12 00:00:00", "2012-07-01 00:00:00", null, 50.00, null, "ok", 1, 0, null},
            {24, "1 calça - tirar sobras do forro overlocar\r\n2 calças - ajuste", "2012-07-03 00:00:00", "2012-07-12 00:00:00", null, 30.00, null, null, 1, 1, null}
    };

    private static final String[][] workerData = {
            {}
    };
}
