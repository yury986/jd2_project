package by.yury.service;

import by.yury.data.dao.CreditDao;
import by.yury.data.dao.DepositDao;
import by.yury.data.dto.CreditDto;
import by.yury.data.dto.DepositDto;
import by.yury.data.pojo.Credit;
import by.yury.data.pojo.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreditServiceImpl implements CreditService {


    @Autowired
    CreditDao creditDao;

    @Override
    public void saveNewCredit(CreditDto creditDto) {
        Credit credit = new Credit(
                creditDto.getCreditId(),
                creditDto.getCreditSum(),
                creditDto.getCreditPercent()
        );
        creditDao.saveNewCredit(credit);
    }
}
