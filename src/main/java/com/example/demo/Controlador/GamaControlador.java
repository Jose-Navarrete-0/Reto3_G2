package com.example.demo.Controlador;

import com.example.demo.Modelo.Gama;
import com.example.demo.Modelo.Gama;
import com.example.demo.Servicio.GamaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author NAVA
 */

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Gama")
public class GamaControlador {
    @Autowired
    private GamaServicio gamaService;
    @GetMapping("/all")
    public List<Gama> getGamas() {
        return gamaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable("id") Integer idGama) {
        return gamaService.getGama(idGama);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama gama) {
        return gamaService.save(gama);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update(@RequestBody Gama gama) {
        return gamaService.update(gama);
    }

    @DeleteMapping("/{id}") // ->>>>> localhost...... /api/Gama/12
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id) {
        return gamaService.delete(id);
    }
}
