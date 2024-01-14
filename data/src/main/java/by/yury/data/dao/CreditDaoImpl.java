package by.yury.data.dao;

import by.yury.data.pojo.Client;
import by.yury.data.pojo.Credit;
import by.yury.data.pojo.Deposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CreditDaoImpl implements CreditDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CreditDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveNewCredit(Credit credit, Client client) {
        Session session = null;
        String savedCreditId;
        session = sessionFactory.getCurrentSession();
        credit.setClient(client);
        //session.persist(client);
        session.saveOrUpdate(credit);//Some work

    }
}
