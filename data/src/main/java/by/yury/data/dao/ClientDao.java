package by.yury.data.dao;

import by.yury.data.pojo.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {

    public List<String> readPassword() throws SQLException, ClassNotFoundException;

    public List<String> readName() throws SQLException, ClassNotFoundException;

    String saveNewClient(Client client);

    Client readClientById(String userName);

    boolean deleteClientById(String id);

    // List<Client> readAll(int startPosition, int pageSize);

}
