package com.voiture.v1.controller;

import com.voiture.v1.entity.EtatVoiture;
import com.voiture.v1.service.EtatVoitureServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etat-voiture")
@AllArgsConstructor
public class EtatVoiturecontroller {

    private final EtatVoitureServiceImpl etatVoitureService;

    @GetMapping
    public List<EtatVoiture> getAllEtats() {
        return etatVoitureService.getAllEtats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatVoiture> getEtatById(@PathVariable Long id) {
        return etatVoitureService.getEtatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EtatVoiture createEtat(@RequestBody EtatVoiture etat) {
        return etatVoitureService.saveEtat(etat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtatVoiture> updateEtat(@PathVariable Long id, @RequestBody EtatVoiture etat) {
        try {
            EtatVoiture updatedEtat = etatVoitureService.updateEtat(etat, id);
            return ResponseEntity.ok(updatedEtat);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtat(@PathVariable Long id) {
        try {
            etatVoitureService.deleteEtat(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/contrat/{contratId}")
    public List<EtatVoiture> getEtatsByContrat(@PathVariable Long contratId) {
        return etatVoitureService.getEtatsByContrat(contratId);
    }

    @GetMapping("/date")
    public List<EtatVoiture> getEtatsByDate(@RequestParam Date date) {
        return etatVoitureService.getEtatsByDate(date);
    }

    @GetMapping("/type/{typeOperation}")
    public List<EtatVoiture> getEtatsByTypeOperation(@PathVariable String typeOperation) {
        return etatVoitureService.getEtatsByTypeOperation(typeOperation);
    }

    @PutMapping("/kilometrage/{id}")
    public ResponseEntity<EtatVoiture> updateKilometrage(
            @PathVariable Long id,
            @RequestParam String kilometrage) {
        try {
            EtatVoiture updatedEtat = etatVoitureService.updateKilometrage(id, kilometrage);
            return ResponseEntity.ok(updatedEtat);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
} 