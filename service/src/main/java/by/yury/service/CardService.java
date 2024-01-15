package by.yury.service;

import by.yury.data.pojo.Card;
import by.yury.service.model.AccountFromWeb;
import by.yury.service.model.CardFromWeb;

import java.sql.SQLException;

public interface CardService {

    void saveNewCard(CardFromWeb cardFromWeb, AccountFromWeb accountFromWeb, String clientId);

     String getCardNumb ();

    public void cardMathSender (String cardSenderId, String sumTrans);

    public void cardMathRecipient (String cardRecipientId, String sumTrans);

}
