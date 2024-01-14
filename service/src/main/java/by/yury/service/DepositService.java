package by.yury.service;

import by.yury.data.dto.DepositDto;
import by.yury.service.model.CardFromWeb;

public interface DepositService {

    void saveNewDeposit(DepositDto depositDto,String clientId);

}
