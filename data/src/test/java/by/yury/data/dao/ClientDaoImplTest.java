package by.yury.data.dao;

import by.yury.data.TestDataConfiguration;
import by.yury.data.TestDataSource;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
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
    public void testSaveNewClient() throws Exception {
        // Given
        Client client = new Client(
                null, "Qwerty","123456");


        // When
        String savedClientId = clientDao.saveNewClient(client);

        // Then
        assertNotNull(savedClientId);
        Connection conn = TestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_CLIENT where USER_NAME='Qwerty' and PASSWORD='123456'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }




}
