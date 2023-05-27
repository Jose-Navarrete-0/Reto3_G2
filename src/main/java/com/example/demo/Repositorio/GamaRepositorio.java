package com.example.demo.Repositorio;

import com.example.demo.Interface.GamaInterface;
import jdk.jfr.Category;
import com.example.demo.Modelo.Gama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public class GamaRepositorio {
    @Autowired
    private GamaInterface gamaCrudRepository;

    public List<Gama> getAll() {
        return (List<Gama>) gamaCrudRepository.findAll();
    }

    public Optional<Gama> getGama(int idGama) {
        return gamaCrudRepository.findById(idGama);
    }

    public Gama save (Gama gama) {
        return gamaCrudRepository.save(gama);
    }
}
