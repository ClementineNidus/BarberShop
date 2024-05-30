package edu.itstep.barber_db.repository;

import edu.itstep.barber_db.entity.Client;

import java.util.List;

public interface ClientRepository {

    List<Client> getAll();

    void saveOrUpdate(Client client);

    void deleteById(int id);

    Client getById(int id);

}
