package by.yury.data.dao;


import by.yury.data.DataConfiguration;
import by.yury.data.DataSource;
import by.yury.data.TestDataConfiguration;
import by.yury.data.TestDataSource;
import by.yury.data.dao.ClientDao;
import by.yury.data.pojo.Card;
import by.yury.data.pojo.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class ClientDaoImplTest {

    @Autowired
    ClientDao clientDao;

    @Before
    public void setUp() throws Exception {
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_CLIENT;");
    }

    @After
    public void tearDown() throws Exception {
        clientDao = null;
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_CLIENT;");
    }


    @Test
    public void testReadName() throws SQLException, ClassNotFoundException {
        // Given
        String clientUUID = UUID.randomUUID().toString();
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO T_CLIENT (USER_ID, USER_NAME, PASSWORD, USER_ROLE) VALUES" +
                "('" + clientUUID + "',\n" +
                "'Yury',\n" +
                "'12345',\n" +
                "'ROLE_USER');\n");
        conn.close();

        //When
        List<String> clients = clientDao.readName();

        //Then
        assertNotNull(clients);
    }

    @Test
    public void testSaveNewClient() throws Exception {
        // Given
        Client client = new Client(null, "Yury","12345", "ROLE-USER");


        // When
        String savedAccountId = clientDao.saveNewClient(client);

        // Then
        assertNotNull(savedAccountId);
        Connection conn = TestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_CLIENT where USER_ID = '"+ savedAccountId +"' and  USER_NAME = 'Yury' and PASSWORD = '12345' and USER_ROLE='ROLE-USER'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testReadClientById() throws SQLException, ClassNotFoundException {
        // Given
        String clientUUID = UUID.randomUUID().toString();
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO T_CLIENT (USER_ID, USER_NAME, PASSWORD, USER_ROLE) VALUES" +
                "('" + clientUUID + "',\n" +
                "'Yury',\n" +
                "'12345',\n" +
                "'ROLE_USER');\n");
        conn.close();

        //When
        Client client = clientDao.readClientById(clientUUID);

        //Then
        assertNotNull(client);
        assertEquals(clientUUID, client.getId());
        assertEquals("Yury", client.getUserName());
        assertEquals("12345", client.getPassword());
        assertEquals("ROLE_USER", client.getRole());

    }

    @Test
    public void testReadClientByName() throws SQLException, ClassNotFoundException {
        // Given
        String clientUUID = UUID.randomUUID().toString();
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO T_CLIENT (USER_ID, USER_NAME, PASSWORD, USER_ROLE) VALUES" +
                "('" + clientUUID + "',\n" +
                "'Yury',\n" +
                "'12345',\n" +
                "'ROLE_USER');\n");
        conn.close();

        //When
        Client client = clientDao.readClientByName("Yury");

        //Then
        assertNotNull(client);
        assertEquals(clientUUID, client.getId());
        assertEquals("Yury", client.getUserName());
        assertEquals("12345", client.getPassword());
        assertEquals("ROLE_USER", client.getRole());

    }


}
