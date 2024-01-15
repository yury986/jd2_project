package by.yury.service;

import by.yury.data.dao.AccountDao;
import by.yury.data.dao.CardDao;
import by.yury.data.dao.ClientDao;
import by.yury.data.dto.AccountDto;
import by.yury.data.dto.CardDto;
import by.yury.data.pojo.Account;
import by.yury.data.pojo.Card;
import by.yury.data.pojo.Client;
import by.yury.service.model.AccountFromWeb;
import by.yury.service.model.CardFromWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardDao cardDao;
    @Autowired
    AccountDao accountDao;
    @Autowired
    CardNumberGenerator cardNumberGenerator;
    @Autowired
    AccountNumberGenerator accountNumberGenerator;
    @Autowired
    ClientDao clientDao;
    String cardsaved;
    String accountsaved;

    @Override
    public void saveNewCard(CardFromWeb cardFromWeb, AccountFromWeb accountFromWeb,String clientId){
        Account account = new Account(
                accountFromWeb.getId(),
                accountNumberGenerator.generator(),
                accountFromWeb.getAccountCurrency()
        );
        account.setClient(clientDao.readClientById(clientId));
        accountsaved = accountDao.saveNewAccount(account);

        Card card = new Card(
                cardFromWeb.getId(),
                cardFromWeb.getCardName(),
                cardNumberGenerator.generator(),
                cardFromWeb.getCash()
        );
        card.setAccount(account);
        cardsaved = cardDao.saveNewCard(card);
    }

    public void cardMathSender (String cardSenderId, String sumTrans) {
        Card card = cardDao.readCardById(cardSenderId);
        Integer cardCashSender = (Integer.parseInt(card.getCash())-
                Integer.parseInt(sumTrans));
        String cardCashSender1 = cardCashSender.toString();

        try {
            cardDao.UpdateCash(cardSenderId,cardCashSender1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void cardMathRecipient (String cardRecipientId, String sumTrans){
        Card card = cardDao.readCardById(cardRecipientId);
        Integer cardCashRecipient = (Integer.parseInt(card.getCash()) +
                Integer.parseInt(sumTrans));
        String cardCashRecipient1 = cardCashRecipient.toString();
        try {
            cardDao.UpdateCash(cardRecipientId,cardCashRecipient1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getCardNumb (){
        Card card = cardDao.readCardById(cardsaved);
        String cardNumb = card.getCardNumb();
        return cardNumb;
    }

}
