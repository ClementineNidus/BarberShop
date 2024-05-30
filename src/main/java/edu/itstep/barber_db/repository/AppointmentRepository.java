package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Appointment;

import java.util.List;

public interface AppointmentRepository {

    List<Appointment> getAll();

    void saveOrUpdate(Appointment appointment);

    void deleteById(int id);

    Appointment getById(int id);

}
