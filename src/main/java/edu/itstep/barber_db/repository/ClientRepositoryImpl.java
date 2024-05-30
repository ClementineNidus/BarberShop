package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository{


    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    @Override
    public List<Client> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Client ", Client.class)
                .list();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Client client) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(client);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Client where id = " + id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Client getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Client.class, id);
    }



}
