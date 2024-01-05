package by.yury.data.dao;

import by.yury.data.TestDataConfiguration;
import by.yury.data.TestDataSource;
import by.yury.data.pojo.Account;
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

public class AccountDaoImplTest {
    @Autowired
    AccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_ACCOUNT;");

    }

    @After
    public void tearDown() throws Exception {
        accountDao = null;
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_ACCOUNT;");
    }

    @Test
    public void testSaveNewAccount() throws Exception {
        // Given
        Account account = new Account(
                null, "HA123456", "USD");


        // When
        String savedAccountId = accountDao.saveNewAccount(account);

        // Then
        assertNotNull(savedAccountId);
        Connection conn = TestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_ACCOUNT where ACCOUNT_NUMBER='HA123456' and ACCOUNT_CURRENCY='USD'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }
}
