package com.example.demo.Servicio;

import com.example.demo.Modelo.Car;
import com.example.demo.Repositorio.CarRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServicio {
    @Autowired
    private CarRepositorio carRepository;

    public List<Car> getAll() {
        return carRepository.getAll();
    }

    public Optional<Car> getCar(int idCar) {
        return carRepository.getCar(idCar);
    }

    public Car save(Car car) {
        if (car.getIdCar() == null) {
            return carRepository.save(car);
        } else {
            Optional<Car> e=carRepository.getCar(car.getIdCar() );
            if (e.isEmpty()) {
                return carRepository.save(car);
            } else {
                return car;
            }
        }
    }
}
