package by.yury.service;

import by.yury.data.dao.DepositDao;
import by.yury.data.dto.DepositDto;
import by.yury.data.pojo.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepositServiceImpl implements DepositService {


    @Autowired
    DepositDao depositDao;

    @Override
    public void saveNewDeposit(DepositDto depositDto) {
        Deposit deposit = new Deposit(
                depositDto.getDepositId(),
                depositDto.getDepositSum(),
                depositDto.getDepositPercent()
        );
        depositDao.saveNewDeposit(deposit);
    }
}
