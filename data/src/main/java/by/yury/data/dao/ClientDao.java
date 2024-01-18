package by.yury.data.dao;

import by.yury.data.pojo.Client;
import by.yury.data.pojo.Credit;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {

//    public List<String> readPassword() throws SQLException, ClassNotFoundException;

    public List<String> readName() throws SQLException, ClassNotFoundException;

    String saveNewClient(Client client);

    List<Client> findByUserName(String username);

    public Client readClientById(String id);

    public Client readClientByName(String userName);

//    public void saveorUpdateNewClient(Client client, List <Credit> credits);

}


