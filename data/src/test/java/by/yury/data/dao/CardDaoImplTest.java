package by.yury.data.dao;

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
        Card card = new Card(null, "VISA","1234567890123456", "10000");


        // When
        String savedAccountId = cardDao.saveNewCard(card);

        // Then
        assertNotNull(savedAccountId);
        Connection conn = TestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_CARD where  CARD_NAME='VISA' and CARD_NUMB = '1234567890123456' and CASH='10000'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }
}
