package by.yury.data.dao;

import by.yury.data.pojo.Account;
import by.yury.data.pojo.Deposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class DepositDaoImpl implements DepositDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public DepositDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String saveNewDeposit(Deposit deposit) {
        Session session = null;
        String savedDepositId;
        session = sessionFactory.getCurrentSession();
        savedDepositId = (String) session.save(deposit);//Some work
        return savedDepositId;
    }
}
