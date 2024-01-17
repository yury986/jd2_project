package by.yury.data.dao;

import by.yury.data.DataSource;
import by.yury.data.pojo.Client;
import by.yury.data.pojo.Credit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
public class ClientDaoImpl implements ClientDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ClientDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<String> readName() throws SQLException, ClassNotFoundException {
        Statement statement = DataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from T_CLIENT");

        List<String> usersName = new ArrayList<>();
        while (resultSet.next()) {

            String userName = resultSet.getString("user_name");

            usersName.add(userName);
        }
        resultSet.close();
        statement.close();
        return usersName;
    }

    @Override
    public String saveNewClient(Client client) {
        Session session = null;
        String savedUserId;
        session = sessionFactory.getCurrentSession();
        savedUserId = (String) session.save(client);//Some work
        return savedUserId;
    }

    @Override
    public List<Client> findByUserName(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Client au where au.userName=:username", Client.class)
                .setParameter("username", username)
                .list();
    }


    @Override
    @Transactional(readOnly = true)
    public Client readClientById(String id) {
        Session session;
        Client client;
        session = sessionFactory.getCurrentSession();
        client = session.get(Client.class, id); //Some work
        return client;
    }

    @Override
    public Client readClientByName(String userName) {
        Session session;
        Client client;
        session = sessionFactory.getCurrentSession();
        String hql = "FROM Client where userName = :username";
        Query<Client> query = session.createQuery(hql,Client.class);
        query.setParameter("username", userName);
        return query.uniqueResult();
    }

    @Override
    public void saveorUpdateNewClient(Client client, List <Credit> credits) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        client.setCredits(credits);
        for(Credit credit : credits) {
            session.save(credit);
        }
        session.saveOrUpdate(client);//Some work

    }
}
