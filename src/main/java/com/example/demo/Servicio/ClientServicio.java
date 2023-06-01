package com.example.demo.Servicio;

import com.example.demo.Modelo.Client;
import com.example.demo.Repositorio.ClientRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save (Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> clientEncontrado=clientRepository.getClient(client.getIdClient());
            if (clientEncontrado.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> clientEncontrado = getClient(client.getIdClient());
            if (clientEncontrado.isPresent()){
                if (client.getName() != null) {
                    clientEncontrado.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    clientEncontrado.get().setAge(client.getAge());
                }
                if (client.getEmail() != null) {
                    clientEncontrado.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    clientEncontrado.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clientEncontrado.get());
            }
        } else {
            return client;
        }
        return client;
    }

    public boolean delete(int id) {
        Boolean respuesta = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
