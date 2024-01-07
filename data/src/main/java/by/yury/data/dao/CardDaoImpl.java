package by.yury.data.dao;

import by.yury.data.dto.AccountDto;
import by.yury.data.dto.CardDto;
import by.yury.data.pojo.Account;
import by.yury.data.pojo.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CardDaoImpl implements CardDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CardDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String saveNewCard(Card card) {
        Session session = null;
        String savedCardId;
        session = sessionFactory.getCurrentSession();
        savedCardId = (String) session.save(card);//Some work
        return savedCardId;
    }

    @Override
    public void createCard(CardDto cardDto, AccountDto accountDto) {

       Session session = sessionFactory.getCurrentSession();
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountNumber(),
                accountDto.getAccountCurrency()
        );

        Card card = new Card(
                cardDto.getId(),
                cardDto.getCardName(),
                cardDto.getCardNumb(),
                cardDto.getCash()

        );
        card.setAccount(account);
        session.saveOrUpdate(account);
        session.save(card);//Some work


    }
}

