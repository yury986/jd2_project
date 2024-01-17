package by.yury.data.dao;

import by.yury.data.DataSource;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

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
                "select count(*) from T_CARD where CARD_NAME='VISA' and CARD_NUMB = '1234567890123456' and CASH='10000'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void UpdateCashTest() throws SQLException, ClassNotFoundException {
        // Given
        Connection conn = TestDataSource.getConnection();
        String cardUUID = "b5bed480-507b-4e5d-a33e-f3ce37af0000";
        conn.createStatement().executeUpdate("INSERT INTO T_CARD (CARD_ID, CARD_NAME, CARD_NUMB, CASH) VALUES" +
                "('" + cardUUID + "',\n" +
                "'VISA',\n" +
                "'1456987456325896',\n" +
                "'10000');\n");

        //When
        String newCash = "50";

        String sql = "UPDATE T_CARD SET CASH = ? WHERE CARD_ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, newCash);
        statement.setString(2, cardUUID);
        int rowsUpdated = statement.executeUpdate();

        //Then
        assertEquals(1, rowsUpdated);
    }

    @Test
    public void testReadCardById() throws SQLException, ClassNotFoundException {
        // Given
        String cardUUID = UUID.randomUUID().toString();
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO T_CARD (CARD_ID, CARD_NAME, CARD_NUMB, CASH) VALUES" +
                "('" + cardUUID + "',\n" +
                "'VISA',\n" +
                "'1456987456325896',\n" +
                "'10000');\n");
        conn.close();

        //When
        Card card = cardDao.readCardById(cardUUID);

        //Then
        assertNotNull(card);
        assertEquals(cardUUID, card.getId());
        assertEquals("VISA", card.getCardName());
        assertEquals("1456987456325896", card.getCardNumb());
        assertEquals("10000", card.getCash());

    }

    @Test
    public void testReadCardByName() throws SQLException, ClassNotFoundException {
        // Given
        String cardUUID = UUID.randomUUID().toString();
        String cardNumb = "1456987456325896";
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO T_CARD (CARD_ID, CARD_NAME, CARD_NUMB, CASH) VALUES" +
                "('" + cardUUID + "',\n" +
                "'VISA',\n" +
                "'"+ cardNumb +"',\n" +
                "'10000');\n");
        conn.close();

        //When
        Card card = cardDao.readCardByNumber(cardNumb);

        //Then
        assertNotNull(card);
        assertEquals(cardUUID, card.getId());
        assertEquals("VISA", card.getCardName());
        assertEquals("1456987456325896", card.getCardNumb());
        assertEquals("10000", card.getCash());

    }

}
