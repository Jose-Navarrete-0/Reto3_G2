package com.example.demo.Controlador;

import com.example.demo.Modelo.Messages;
import com.example.demo.Servicio.MessageServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Message")
public class MessageControlador {
    @Autowired
    private MessageServicio messageService;
    @GetMapping("/all")
    public List<Messages> getMessages() {
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Messages> getMessage(@PathVariable("id") int idMessage) {
        return messageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save (@RequestBody Messages messages) {
        return messageService.save(messages);
    }
}
