package by.yury.data.dao;

import by.yury.data.pojo.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public AccountDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }


    @Override
    public String saveNewAccount(Account account) {
        Session session = null;
        String savedAccountId;
        session = sessionFactory.getCurrentSession();
        savedAccountId = (String) session.save(account);//Some work
        return savedAccountId;
    }
}

