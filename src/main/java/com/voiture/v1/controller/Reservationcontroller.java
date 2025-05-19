package com.voiture.v1.controller;

import com.voiture.v1.entity.Reservation;
import com.voiture.v1.service.ReservationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class Reservationcontroller {

    private final ReservationServiceImpl reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        try {
            Reservation updatedReservation = reservationService.updateReservation(reservation, id);
            return ResponseEntity.ok(updatedReservation);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/client/{client}")
    public List<Reservation> getReservationsByClient(@PathVariable String client) {
        return reservationService.getReservationsByClient(client);
    }

    @GetMapping("/voiture/{voiture}")
    public List<Reservation> getReservationsByVoiture(@PathVariable String voiture) {
        return reservationService.getReservationsByVoiture(voiture);
    }

    @GetMapping("/date/{date}")
    public List<Reservation> getReservationsByDate(@PathVariable String date) {
        return reservationService.getReservationsByDate(date);
    }
}
