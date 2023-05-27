package com.example.demo.Servicio;

import com.example.demo.Modelo.Messages;
import com.example.demo.Repositorio.MessageRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MessageServicio {
    @Autowired
    private MessageRepositorio messageRepository;

    public List<Messages> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Messages> getMessage (int idMessage) {
        return messageRepository.getMessage(idMessage);
    }

    public Messages save (Messages messages) {
        if(messages.getIdMessage() == null) {
            return messageRepository.save(messages);
        } else {
            Optional<Messages> e= messageRepository.getMessage(messages.getIdMessage());
            if (e.isEmpty()) {
                return messageRepository.save(messages);
            } else {
                return messages;
            }
        }
    }
}
