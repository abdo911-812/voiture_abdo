package com.voiture.v1.service;

import com.voiture.v1.entity.Reservation;
import com.voiture.v1.repository.Reservationrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final Reservationrepo reservationRepo;

    @Autowired
    public ReservationServiceImpl(Reservationrepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepo.findById(id);
    }

    @Override
    @Transactional
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    @Transactional
    public Reservation updateReservation(Reservation reservation, Long id) {
        if (!reservationRepo.existsById(id)) {
            throw new RuntimeException("Reservation avec id " + id + " non trouvée");
        }
        reservation.setId(id);
        return reservationRepo.save(reservation);
    }

    @Override
    @Transactional
    public void deleteReservation(Long id) {
        if (!reservationRepo.existsById(id)) {
            throw new RuntimeException("Reservation avec id " + id + " non trouvée");
        }
        reservationRepo.deleteById(id);
    }

    @Override
    public List<Reservation> getReservationsByClient(String client) {
        return reservationRepo.findAll().stream()
                .filter(reservation -> reservation.getClient() != null && 
                        reservation.getClient().equals(client))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> getReservationsByVoiture(String voiture) {
        return reservationRepo.findAll().stream()
                .filter(reservation -> reservation.getVoiture() != null && 
                        reservation.getVoiture().equals(voiture))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> getReservationsByDate(String date) {
        return reservationRepo.findAll().stream()
                .filter(reservation -> reservation.getDate() != null && 
                        reservation.getDate().equals(date))
                .collect(Collectors.toList());
    }
} 