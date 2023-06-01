package com.example.demo.Repositorio;

import com.example.demo.Interface.ScoreInterface;
import com.example.demo.Modelo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepositorio {
    @Autowired
    private ScoreInterface scoreCrudRepository;

    public List<Score> findAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int idScore) {
        return scoreCrudRepository.findById(idScore);
    }

    public Score save(Score score) {
        return scoreCrudRepository.save(score);
    }

    public void delete(Score score) {
        scoreCrudRepository.delete(score);
    }

}
