package by.yury.service;

import by.yury.data.dao.CardDao;
import by.yury.data.dto.AccountDto;
import by.yury.data.dto.CardDto;
import by.yury.service.model.AccountFromWeb;
import by.yury.service.model.CardFromWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardDao cardDao;

    @Autowired
    CardNumberGenerator cardNumberGenerator;


    @Autowired
    AccountNumberGenerator accountNumberGenerator;



    @Override
    public void saveNewCard(CardFromWeb cardFromWeb, AccountFromWeb accountFromWeb){
        AccountDto accountDto = new AccountDto(
                accountFromWeb.getId(),
                accountNumberGenerator.generator(),
                accountFromWeb.getAccountCurrency()
        );

        CardDto cardDto = new CardDto(
                cardFromWeb.getId(),
                cardFromWeb.getCardName(),
                cardNumberGenerator.generator(),
                cardFromWeb.getCash()
        );
        cardDao.createCard(cardDto,accountDto);

    }

}
