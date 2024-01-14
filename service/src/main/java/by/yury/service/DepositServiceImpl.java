package by.yury.service;

import by.yury.data.dao.ClientDao;
import by.yury.data.dao.DepositDao;
import by.yury.data.dto.DepositDto;
import by.yury.data.pojo.Client;
import by.yury.data.pojo.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepositServiceImpl implements DepositService {


    @Autowired
    DepositDao depositDao;

    @Autowired
    ClientDao clientDao;

    @Override
    public void saveNewDeposit(DepositDto depositDto,String clientId) {
        Deposit deposit = new Deposit(
                depositDto.getDepositId(),
                depositDto.getDepositSum(),
                depositDto.getDepositPercent()
        );
        Client client = clientDao.readClientById(clientId);
        depositDao.saveNewDeposit(deposit,client);
    }
}
