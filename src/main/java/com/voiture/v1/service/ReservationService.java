package com.voiture.v1.service;

import com.voiture.v1.entity.Reservation;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(Long id);
    Reservation saveReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation, Long id);
    void deleteReservation(Long id);
    
    // Specific business methods
    List<Reservation> getReservationsByClient(String client);
    List<Reservation> getReservationsByVoiture(String voiture);
    List<Reservation> getReservationsByDate(String date);
} 