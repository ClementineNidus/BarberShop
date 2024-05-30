package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public class ServiceRepositoryImpl implements ServiceRepository {

    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    @Override
    public List<Service> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Service ", Service.class)
                .list();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Service service) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(service);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Service where id = " + id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Service getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Service.class, id);
    }



}
