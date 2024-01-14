package by.yury.service;

import by.yury.service.model.AccountFromWeb;
import by.yury.service.model.CardFromWeb;

public interface CardService {

    void saveNewCard(CardFromWeb cardFromWeb, AccountFromWeb accountFromWeb, String clientId);

     String getCardNumb ();

}
