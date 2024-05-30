package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Barber;

import java.util.List;

public interface BarberRepository {

    List<Barber> getAll();

    void saveOrUpdate(Barber barber);

    void deleteById(int id);

    Barber getById(int id);

    List<Barber> getAllSortedByName();

}
