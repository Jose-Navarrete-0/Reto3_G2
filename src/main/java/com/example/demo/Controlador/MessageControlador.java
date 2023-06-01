package com.example.demo.Controlador;

import com.example.demo.Modelo.Car;
import com.example.demo.Modelo.Messages;
import com.example.demo.Servicio.MessageServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages update(@RequestBody Messages messages) {
        return messageService.update(messages);
    }

    @DeleteMapping("/{id}") // ->>>>> localhost...... /api/Car/12
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id) {
        return messageService.delete(id);
    }
}
