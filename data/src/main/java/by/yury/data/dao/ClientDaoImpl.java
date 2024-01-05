package by.yury.data.dao;

import by.yury.data.DataSource;
import by.yury.data.pojo.Client;
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
    public List<String> readPassword() throws SQLException, ClassNotFoundException {
        Statement statement = DataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from T_CLIENT");

        List<String> usersPassword = new ArrayList<>();
        while (resultSet.next()) {
            String password = resultSet.getString("password");
            usersPassword.add(password);
        }
        resultSet.close();
        statement.close();
        return usersPassword;
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
    @Transactional(readOnly = true)
    public Client readClientById(String id) {
        Session session = null;
        Client client;
        session = sessionFactory.getCurrentSession();
        client = session.get(Client.class, id); //Some work
        return client;
    }

    @Override
    public boolean deleteClientById(String id) {
        Session session = null;
        Client client;
        session = sessionFactory.getCurrentSession();
        client = session.get(Client.class, id); //Some work
        if (client == null) {
            return false;
        }
        session.delete(client);
        return true;
    }

  /*  @Override
    @Transactional(readOnly = true)
    public List<Client> readAll(int startPosition, int pageSize) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client order by firstName, lastName", Client.class)
                .setFirstResult(startPosition)
                .setMaxResults(pageSize)
                .list();
    }*/

}
