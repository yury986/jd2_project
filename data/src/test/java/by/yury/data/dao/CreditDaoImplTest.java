package by.yury.data.dao;

import by.yury.data.DataConfiguration;
import by.yury.data.TestDataSource;
import by.yury.data.pojo.Account;
import by.yury.data.pojo.Client;
import by.yury.data.pojo.Credit;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class CreditDaoImplTest {


    @Autowired
    CreditDao creditDao;

    @Autowired
    ClientDao clientDao;

    @Before
    public void setUp() throws Exception {
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_CREDIT;");
    }

    @After
    public void tearDown() throws Exception {
        creditDao = null;
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_CREDIT;");
    }
    @Test
    public void testSaveNewCredit() throws SQLException, ClassNotFoundException {
        // Given
        Credit credit = new Credit(null, "10000", "10");
        Client client = new Client(null, "Yury", "12345", "Role-User");
        // When
        clientDao.saveNewClient(client);
        creditDao.saveNewCredit(credit,client);

        // Then
        Connection conn = TestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_Credit where SUM_CREDIT='10000' and PERSENT_CREDIT='10'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

}
