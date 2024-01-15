package by.yury.data.dao;

import by.yury.data.DataSource;
import by.yury.data.dto.AccountDto;
import by.yury.data.dto.CardDto;
import by.yury.data.pojo.Account;
import by.yury.data.pojo.Card;
import by.yury.data.pojo.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void UpdateCash(String id, String cash) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE T_CARD SET CASH =?  WHERE CARD_ID =?";
        PreparedStatement statement = DataSource.getConnection().prepareStatement(sql);
        statement.setString(1,cash);
        statement.setString(2, id);
        statement.executeUpdate();
        statement.close();

    }

    @Override
    public String saveNewCard (Card card) {
        Session session = sessionFactory.getCurrentSession();
        String cardSavedId = (String )session.save(card);//Some work
        return cardSavedId;
    }

    @Override
    @Transactional(readOnly = true)
    public Card readCardByNumber(String cardNumb) {
        Session session = null;
        Card card;
        session = sessionFactory.getCurrentSession();
        String hql = "FROM Card WHERE cardNumb =:cardnumb";
        Query<Card> query = session.createQuery(hql,Card.class);
        query.setParameter("cardnumb", cardNumb);
        return query.uniqueResult();
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

