package com.example.demo.Servicio;

import com.example.demo.Modelo.Gama;
import com.example.demo.Modelo.Client;
import com.example.demo.Repositorio.GamaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class GamaServicio {
    @Autowired
    private GamaRepositorio gamaRepository;

    public List<Gama> getAll() {
        return gamaRepository.getAll();
    }

    public Optional<Gama> getGama(int id) {
        return gamaRepository.getGama(id);
    }

    public Gama save(Gama gama) {
        if (gama.getIdGama() == null) {
            return gamaRepository.save(gama);
        } else {
            Optional<Gama> gama1 = gamaRepository.getGama(gama.getIdGama());
            if (gama1.isEmpty()) {
                return gamaRepository.save(gama);
            } else {
                return gama;
            }
        }
    }

    public Gama update(Gama gama) {
        if (gama.getIdGama() != null) {
            Optional<Gama> gamaEncontrado = getGama(gama.getIdGama());
            if (gamaEncontrado.isPresent()){
                if (gama.getName() != null) {
                    gamaEncontrado.get().setName(gama.getName());
                }
                if (gama.getDescription() != null) {
                    gamaEncontrado.get().setDescription(gama.getDescription());
                }
                
                return gamaRepository.save(gamaEncontrado.get());
            }
        } else {
            return gama;
        }
        return gama;
    }

    public boolean delete(int id) {
        Boolean respuesta = getGama(id).map(gama -> {
            gamaRepository.delete(gama);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
