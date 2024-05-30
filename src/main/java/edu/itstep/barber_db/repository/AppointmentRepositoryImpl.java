package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Appointment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;



@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository{


    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    @Override
    public List<Appointment> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Appointment ", Appointment.class)
                .list();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Appointment appointment) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(appointment);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Appointment where id = " + id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Appointment getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Appointment.class, id);
    }


}
