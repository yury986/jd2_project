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
    public String createCardwithAccount(Card card) {


        Session session = sessionFactory.getCurrentSession();
        String cardSavedId = (String )session.save(card);//Some work
        return cardSavedId;
    }

    @Override
    @Transactional(readOnly = true)
    public Card readCardById(String id) {
        Session session = null;
        Card card;
        session = sessionFactory.getCurrentSession();
        card = session.get(Card.class, id); //Some work
        card.getAccount();
        return card;
    }


}

