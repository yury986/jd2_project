package by.yury.service;

import by.yury.data.dto.CreditDto;
import by.yury.data.dto.DepositDto;
import by.yury.data.pojo.Client;
import by.yury.service.model.CardFromWeb;

public interface CreditService {


    void saveNewCredit(CreditDto creditDto,String clientId);

}
