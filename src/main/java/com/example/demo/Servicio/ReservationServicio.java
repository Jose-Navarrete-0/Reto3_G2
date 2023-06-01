package com.example.demo.Servicio;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.ReservationRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save (Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if (e.isEmpty()){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isPresent()){
                if (reservation.getStarDate() != null) {
                    reservationEncontrado.get().setStarDate(reservation.getStarDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }

                return reservationRepository.save(reservationEncontrado.get());
            }
        } else {
            return reservation;
        }
        return reservation;
    }

    public boolean delete(int id) {
        Boolean respuesta = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
