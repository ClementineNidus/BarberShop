package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;



@Repository
public class TransactionRepositoryImpl implements TransactionRepository{

    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    @Override
    public List<Transaction> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Transaction ", Transaction.class)
                .list();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Transaction transaction) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(transaction);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Transaction where id = " + id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Transaction getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Transaction.class, id);
    }


}
