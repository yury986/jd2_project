package by.yury.data.dao;

import by.yury.data.TestDataConfiguration;
import by.yury.data.TestDataSource;
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


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class PersonDaoImplTest {

    @Autowired
    PersonDao personDao;

    @Before
    public void setUp() throws Exception {
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");

    }

    @After
    public void tearDown() throws Exception {
        personDao = null;
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");
    }

    @Test
    public void testSaveNewPerson() throws Exception {
        // Given
        Person person = new Person(
                null, "John", "Smith", "Minsk,Krasnaya str., 22-3",
                "KB789632","+375339075645");


        // When
        String savedId = personDao.saveNewPerson(person);

        // Then
        assertNotNull(savedId);
        Connection conn = TestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where FIRST_NAME='John' and LAST_NAME='Smith'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }



    /*@Test
    public void testReadPersonById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `t_person`\n" +
                "(`PERSON_ID`,\n" +
                "`DATE_OF_BIRTH`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`)\n" +
                "VALUES\n" +
                "('" + testId + "',\n" +
                "'1980-01-01',\n" +
                "'Ivan',\n" +
                "'Petrov');\n");
        conn.close();

        //When
        Person person = personDao.readPersonById(testId);

        //Then
        assertNotNull(person);
        assertEquals(testId, person.getId());
        assertEquals("Ivan", person.getFirstName());
        assertEquals("Petrov", person.getLastName());

    }

    @Test
    public void testDeletePersonById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `t_person`\n" +
                "(`PERSON_ID`,\n" +
                "`DATE_OF_BIRTH`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`)\n" +
                "VALUES\n" +
                "('" + testId + "',\n" +
                "'1980-01-01',\n" +
                "'Ivan',\n" +
                "'Petrov');\n");

        //When
        boolean result = personDao.deletePersonById(testId);

        //Then
        assertTrue(result);
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where PERSON_ID='" + testId + "';"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(0, actualCount);
        conn.close();
    }

    @Test
    public void readAll() throws SQLException, ClassNotFoundException {
        // Given
        Connection conn = EShopTestDataSource.getConnection();
        for (int i = 0; i < 10; i++) {
            String testId = UUID.randomUUID().toString();
            conn.createStatement().executeUpdate("INSERT INTO t_person" +
                    "(PERSON_ID," +
                    "DATE_OF_BIRTH," +
                    "FIRST_NAME," +
                    "LAST_NAME)" +
                    "VALUES" +
                    "('" + testId + "'," +
                    "'1980-01-01'," +
                    "'Ivan" + i + "'," +
                    "'Petrov');");
        }
        conn.close();

        // When
        List<Person> people = personDao.readAll(2, 3);

        // Then
        assertEquals(3, people.size());
        assertEquals("Ivan2", people.get(0).getFirstName());
        assertEquals("Ivan3", people.get(1).getFirstName());
        assertEquals("Ivan4", people.get(2).getFirstName());
    }*/
}