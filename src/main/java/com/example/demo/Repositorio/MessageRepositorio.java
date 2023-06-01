package com.example.demo.Repositorio;


import com.example.demo.Interface.MessageInterface;
import com.example.demo.Modelo.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepositorio {
    @Autowired
    private MessageInterface messageCrudRepository;

    public List<Messages> getAll() {
        return (List<Messages>) messageCrudRepository.findAll();
    }

    public Optional<Messages> getMessage(int idMessage) {
        return messageCrudRepository.findById(idMessage);
    }

    public Messages save (Messages messages) {
        return messageCrudRepository.save(messages);
    }

    public void delete(Messages messages) {
        messageCrudRepository.delete(messages);
    }
}
