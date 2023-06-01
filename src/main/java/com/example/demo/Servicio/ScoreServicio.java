package com.example.demo.Servicio;

import com.example.demo.Modelo.Score;
import com.example.demo.Modelo.Score;
import com.example.demo.Repositorio.ScoreRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServicio {
    @Autowired
    private ScoreRepositorio scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if (scoreEncontrado.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> scoreEncontrado = getScore(score.getIdScore());
            if (scoreEncontrado.isPresent()){
                if (score.getMessageText() != null) {
                    scoreEncontrado.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null) {
                    scoreEncontrado.get().setStars(score.getStars());
                }
                
                return scoreRepository.save(scoreEncontrado.get());
            }
        } else {
            return score;
        }
        return score;
    }

    public boolean delete(int id) {

        List<Score> a = getAll();

        a.forEach(score -> {
            System.out.println(score.getStars());
        });

        Boolean respuesta = getScore(id).map(calificacion -> {
            scoreRepository.delete(calificacion);
            return true;
        }).orElse(false);

        return respuesta;
    }

}
