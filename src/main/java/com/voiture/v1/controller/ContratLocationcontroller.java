package com.voiture.v1.controller;

import com.voiture.v1.entity.ContratLocation;
import com.voiture.v1.service.ContratLocationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contrat")
@AllArgsConstructor
public class ContratLocationcontroller {
    private final ContratLocationServiceImpl contratService;

    @GetMapping
    public List<ContratLocation> getAllContrats() {
        return contratService.getAllContrats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratLocation> getContratById(@PathVariable Long id) {
        return contratService.getContratById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContratLocation createContrat(@RequestBody ContratLocation contrat) {
        return contratService.saveContrat(contrat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratLocation> updateContrat(@PathVariable Long id, @RequestBody ContratLocation contrat) {
        try {
            ContratLocation updatedContrat = contratService.updateContrat(contrat, id);
            return ResponseEntity.ok(updatedContrat);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        try {
            contratService.deleteContrat(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/client/{clientId}")
    public List<ContratLocation> getContratsByClient(@PathVariable Long clientId) {
        return contratService.getContratsByClient(clientId);
    }

    @GetMapping("/voiture/{voitureId}")
    public List<ContratLocation> getContratsByVoiture(@PathVariable Long voitureId) {
        return contratService.getContratsByVoiture(voitureId);
    }

    @GetMapping("/employee/{employeeId}")
    public List<ContratLocation> getContratsByEmployee(@PathVariable Long employeeId) {
        return contratService.getContratsByEmployee(employeeId);
    }

    @GetMapping("/date-range")
    public List<ContratLocation> getContratsByDateRange(
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        return contratService.getContratsByDateRange(startDate, endDate);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<ContratLocation> updateContratStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        try {
            ContratLocation updatedContrat = contratService.updateContratStatus(id, status);
            return ResponseEntity.ok(updatedContrat);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
