package com.voiture.v1.controller;

import com.voiture.v1.entity.Lesinfraction;
import com.voiture.v1.service.LesinfractionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/infraction")
@AllArgsConstructor
public class Lesinfractioncontroller {

    private final LesinfractionServiceImpl infractionService;

    @GetMapping
    public List<Lesinfraction> getAllInfractions() {
        return infractionService.getAllInfractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesinfraction> getInfractionById(@PathVariable Long id) {
        return infractionService.getInfractionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lesinfraction createInfraction(@RequestBody Lesinfraction infraction) {
        return infractionService.saveInfraction(infraction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lesinfraction> updateInfraction(@PathVariable Long id, @RequestBody Lesinfraction infraction) {
        try {
            Lesinfraction updatedInfraction = infractionService.updateInfraction(infraction, id);
            return ResponseEntity.ok(updatedInfraction);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfraction(@PathVariable Long id) {
        try {
            infractionService.deleteInfraction(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/client/{clientId}")
    public List<Lesinfraction> getInfractionsByClient(@PathVariable Long clientId) {
        return infractionService.getInfractionsByClient(clientId);
    }

    @GetMapping("/voiture/{voitureId}")
    public List<Lesinfraction> getInfractionsByVoiture(@PathVariable Long voitureId) {
        return infractionService.getInfractionsByVoiture(voitureId);
    }

    @GetMapping("/date")
    public List<Lesinfraction> getInfractionsByDate(@RequestParam Date date) {
        return infractionService.getInfractionsByDate(date);
    }

    @GetMapping("/type/{typeCharge}")
    public List<Lesinfraction> getInfractionsByType(@PathVariable String typeCharge) {
        return infractionService.getInfractionsByType(typeCharge);
    }

    @PutMapping("/price/{id}")
    public ResponseEntity<Lesinfraction> updateInfractionPrice(
            @PathVariable Long id,
            @RequestParam String price) {
        try {
            Lesinfraction updatedInfraction = infractionService.updateInfractionPrice(id, price);
            return ResponseEntity.ok(updatedInfraction);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
