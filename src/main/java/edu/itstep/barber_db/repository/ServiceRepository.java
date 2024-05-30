package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Service;

import java.util.List;

public interface ServiceRepository {

    List<Service> getAll();

    void saveOrUpdate(Service service);

    void deleteById(int id);

    Service getById(int id);

}
