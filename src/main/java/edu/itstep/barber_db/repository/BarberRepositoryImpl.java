package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Barber;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Repository
public class BarberRepositoryImpl implements BarberRepository{


    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Barber> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Barber ", Barber.class)
                .list();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Barber barber) {
        try {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(barber);
        } catch (ConstraintViolationException e) {
            throw new DataIntegrityViolationException("Duplicate entry for barber phone number", e);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Barber where id = " + id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Barber getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Barber.class, id);
    }

    @Transactional
    @Override
    public List<Barber> getAllSortedByName() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Barber order by firstName", Barber.class)
                .list();
    }

}
