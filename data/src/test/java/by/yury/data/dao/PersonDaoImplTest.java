package by.yury.data.dao;

import by.yury.data.DataConfiguration;
import by.yury.data.TestDataSource;
import by.yury.data.pojo.Client;
import by.yury.data.pojo.Person;
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
public class PersonDaoImplTest {

    @Autowired
    PersonDao personDao;

    @Before
    public void setUp() throws Exception {
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_Person;");
    }

    @After
    public void tearDown() throws Exception {
        personDao = null;
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_Person;");
    }

    @Test
    public void testSaveNewClient() throws Exception {
        // Given
        Person person = new Person(null, "Yury","Petrov",
                "Pushkina.str 4-10", "KB123890", "+375291075089");


        // When
        String savedPersonId = personDao.saveNewPerson(person);

        // Then
        assertNotNull(savedPersonId);
        Connection conn = TestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_Person where PERSON_ID = '"+ savedPersonId +"' and  FIRST_NAME = 'Yury' and LAST_NAME = 'Petrov'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testReadPassport() throws SQLException, ClassNotFoundException {
        // Given
        String clientUUID = UUID.randomUUID().toString();
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO T_PERSON (PERSON_ID, FIRST_NAME, LAST_NAME, ADDRESS, PASSPORT, CONTACT) VALUES" +
                "('" + clientUUID + "',\n" +
                "'Yury',\n" +
                "'Petrov',\n" +
                "'Pushkina.str 4-10',\n" +
                "'KB123890',\n" +
                "'+375291075089');\n");
        conn.close();

        //When
        List<String> passports = personDao.readPassport();

        //Then
        assertNotNull(passports);


    }

}