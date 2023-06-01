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

    public Optional<Messages> getMessage (int id) {
        return messageRepository.getMessage(id);
    }

    public Messages save (Messages messages) {
        if(messages.getIdMessage() == null) {
            return messageRepository.save(messages);
        } else {
            Optional<Messages> messageEncontrado= messageRepository.getMessage(messages.getIdMessage());
            if (messageEncontrado.isEmpty()) {
                return messageRepository.save(messages);
            } else {
                return messages;
            }
        }
    }

    public Messages update(Messages messages) {
        if (messages.getIdMessage() != null) {
            Optional<Messages> messageEncontrado = getMessage(messages.getIdMessage());
            if (messageEncontrado.isPresent()){
                if (messages.getMessageText() != null) {
                    messageEncontrado.get().setMessageText(messages.getMessageText());
                }
                return messageRepository.save(messageEncontrado.get());
            }
        } else {
            return messages;
        }
        return messages;
    }

    public boolean delete(int id) {
        Boolean respuesta = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
