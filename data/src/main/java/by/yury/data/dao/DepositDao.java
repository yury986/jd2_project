package by.yury.data.dao;

import by.yury.data.pojo.Account;
import by.yury.data.pojo.Client;
import by.yury.data.pojo.Deposit;

public interface DepositDao  {

    void saveNewDeposit(Deposit deposit, Client client);

}
