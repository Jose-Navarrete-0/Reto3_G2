package com.example.demo.Controlador;

import com.example.demo.Modelo.Car;
import com.example.demo.Servicio.CarServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Car")

public class CarControlador {
    @Autowired
    private CarServicio carService;

    @GetMapping("/all")
    public List<Car> getCars() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") int idCar) {
        return carService.getCar(idCar);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save (@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Car update(@RequestBody Car car) {
        return carService.update(car);
    }

    @DeleteMapping("/{id}") // ->>>>> localhost...... /api/Car/12
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id) {
        return carService.delete(id);
    }
}
