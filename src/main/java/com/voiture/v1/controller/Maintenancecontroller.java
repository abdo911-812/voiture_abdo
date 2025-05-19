package com.voiture.v1.controller;

import com.voiture.v1.entity.Maintenance;
import com.voiture.v1.service.MaintenanceServiceImpl;
import com.voiture.v1.enums.Typemaintenance;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maintenance")
@AllArgsConstructor
public class Maintenancecontroller {

    private final MaintenanceServiceImpl maintenanceService;

    @GetMapping
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.getAllMaintenances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.getMaintenanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.saveMaintenance(maintenance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        try {
            Maintenance updatedMaintenance = maintenanceService.updateMaintenance(maintenance, id);
            return ResponseEntity.ok(updatedMaintenance);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        try {
            maintenanceService.deleteMaintenance(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/voiture/{voitureId}")
    public List<Maintenance> getMaintenancesByVoiture(@PathVariable Long voitureId) {
        return maintenanceService.getMaintenancesByVoiture(voitureId);
    }

    @GetMapping("/type/{type}")
    public List<Maintenance> getMaintenancesByType(@PathVariable Typemaintenance type) {
        return maintenanceService.getMaintenancesByType(type);
    }

    @GetMapping("/date")
    public List<Maintenance> getMaintenancesByDate(@RequestParam String date) {
        return maintenanceService.getMaintenancesByDate(date);
    }

    @PutMapping("/price/{id}")
    public ResponseEntity<Maintenance> updateMaintenancePrice(
            @PathVariable Long id,
            @RequestParam String price) {
        try {
            Maintenance updatedMaintenance = maintenanceService.updateMaintenancePrice(id, price);
            return ResponseEntity.ok(updatedMaintenance);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
} 