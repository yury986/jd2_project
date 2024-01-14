package by.yury.data.dao;

import by.yury.data.pojo.Client;
import by.yury.data.pojo.Credit;


public interface CreditDao {

    void saveNewCredit(Credit credit, Client client);

}
