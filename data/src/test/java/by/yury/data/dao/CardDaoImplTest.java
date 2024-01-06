package by.yury.data.dao;

import by.yury.data.CloneTestSessionFactory;
import by.yury.data.TestDataConfiguration;
import by.yury.data.TestDataSource;
import by.yury.data.pojo.Account;
import by.yury.data.pojo.Card;
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

public class CardDaoImplTest {

    @Autowired
    CardDao cardDao;

    @Before
    public void setUp() throws Exception {
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_CARD;");
    }

    @After
    public void tearDown() throws Exception {
        cardDao = null;
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_CARD;");
    }



    @Test
    public void testSaveNewCard() throws Exception {
        // Given
        Connection conn = TestDataSource.getConnection();
        String accountUUID = "b5bed480-507b-4e5d-a33e-f3ce37af0000";
        conn.createStatement().executeUpdate("INSERT INTO T_ACCOUNT (ACCOUNT_ID,ACCOUNT_NUMBER, ACCOUNT_CURRENCY) VALUES('"
                + accountUUID
                + "','1232559874632502"
                + "', 'USD');");


        Card card = new Card(null, "VISA","1234567890123456", "10000");

        Account account = CloneTestSessionFactory
                .getSessionFactory().openSession().get(Account.class, accountUUID);
        card.setAccount(account);

        // When
        String savedCardId = cardDao.saveNewCard(card);

        // Then

        ResultSet rs = conn.createStatement().executeQuery(
                "SELECT ACCOUNT_ID from T_CARD where CARD_ID='" + savedCardId + "';"
        );
        rs.next();
        String savedAccountId = rs.getString(1);
        assertNotNull(savedAccountId);
        assertEquals(accountUUID, savedAccountId);
        conn.close();
    }
}
