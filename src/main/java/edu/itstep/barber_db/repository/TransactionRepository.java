package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Transaction;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> getAll();

    void saveOrUpdate(Transaction transaction);

    void deleteById(int id);

    Transaction getById(int id);

}
