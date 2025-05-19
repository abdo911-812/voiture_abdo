package com.voiture.v1.service;

import com.voiture.v1.entity.Maintenance;
import com.voiture.v1.enums.Typemaintenance;
import java.util.List;
import java.util.Optional;

public interface MaintenanceService {
    List<Maintenance> getAllMaintenances();
    Optional<Maintenance> getMaintenanceById(Long id);
    Maintenance saveMaintenance(Maintenance maintenance);
    Maintenance updateMaintenance(Maintenance maintenance, Long id);
    void deleteMaintenance(Long id);
    
    // Specific business methods
    List<Maintenance> getMaintenancesByVoiture(Long voitureId);
    List<Maintenance> getMaintenancesByType(Typemaintenance type);
    List<Maintenance> getMaintenancesByDate(String date);
    Maintenance updateMaintenancePrice(Long id, String price);
} 