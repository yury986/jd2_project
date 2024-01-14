package by.yury.service;

import by.yury.data.dao.ClientDao;
import by.yury.data.dao.CreditDao;
import by.yury.data.dao.DepositDao;
import by.yury.data.dto.CreditDto;
import by.yury.data.dto.DepositDto;
import by.yury.data.pojo.Client;
import by.yury.data.pojo.Credit;
import by.yury.data.pojo.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    ClientDao clientDao;

    @Autowired
    CreditDao creditDao;

    @Autowired
    CreditService creditService;


    @Override
    public void saveNewCredit(CreditDto creditDto,String clientId) {

                Credit credit = new Credit(
                creditDto.getCreditId(),
                creditDto.getCreditSum(),
                creditDto.getCreditPercent()
        );
        Client client = clientDao.readClientById(clientId);

        creditDao.saveNewCredit(credit,client);
    }
}
