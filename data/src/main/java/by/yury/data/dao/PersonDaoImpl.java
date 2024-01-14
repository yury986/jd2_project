package by.yury.data.dao;

import by.yury.data.DataSource;
import by.yury.data.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String saveNewPerson(Person person) {
        Session session = null;
        String savedId;
        session = sessionFactory.getCurrentSession();
        savedId = (String) session.save(person);//Some work
        return savedId;
    }

    @Override
    public List<String> readPassport() throws SQLException, ClassNotFoundException {
        Statement statement = DataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from T_PERSON");

        List<String> passports = new ArrayList<>();
        while (resultSet.next()) {

            String passport = resultSet.getString("passport");

            passports.add(passport);
        }
        resultSet.close();
        statement.close();
        return passports;
    }




}
