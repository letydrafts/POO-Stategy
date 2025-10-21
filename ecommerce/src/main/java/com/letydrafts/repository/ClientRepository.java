package com.letydrafts.repository;

import com.letydrafts.dao.ClientDAO;
import com.letydrafts.models.Client;
import java.util.List;

public class ClientRepository {

    private final ClientDAO clientDAO;

    public ClientRepository() {
        this.clientDAO = new ClientDAO();
    }

    public boolean add(Client client) {
        if (client.getEmail() == null || client.getName() == null) {
            System.out.println("invalid data.");
            return false;
        }
        return clientDAO.create(client);
    }

    public Client getById(int id) {
        return clientDAO.findById(id);
    }

    public List<Client> getAll() {
        return clientDAO.findAll();
    }

    public boolean delete(int id) {
        return clientDAO.delete(id);
    }
}
