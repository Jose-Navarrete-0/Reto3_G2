package com.example.demo.Repositorio;

import com.example.demo.Interface.ClientInterface;
import com.example.demo.Modelo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositorio {
    @Autowired
    private ClientInterface clientCrudRepository;
    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int idClient) {
        return clientCrudRepository.findById(idClient);
    }

    public Client save (Client client) {
        return clientCrudRepository.save(client);
    }

    public void delete(Client client) {
        clientCrudRepository.delete(client);
    }
}
