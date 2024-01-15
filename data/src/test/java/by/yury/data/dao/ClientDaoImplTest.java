package by.yury.data.dao;


import by.yury.data.TestDataConfiguration;
import by.yury.data.dao.ClientDao;
import by.yury.data.pojo.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
public class ClientDaoImplTest {

    @Autowired
    ClientDao clientDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByUserName() {
        //Given
        String adminUserName = "admin";
        //When
        List<Client> results = clientDao.findByUserName(adminUserName);
        //Then
        assertEquals(1, results.size());
        assertEquals("admin", results.get(0).getPassword());
    }
}
