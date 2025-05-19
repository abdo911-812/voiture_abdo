package com.voiture.v1.service;

import com.voiture.v1.entity.Maintenance;
import com.voiture.v1.repository.Maintenacerepo;
import com.voiture.v1.enums.Typemaintenance;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    private final Maintenacerepo maintenanceRepo;

    @Autowired
    public MaintenanceServiceImpl(Maintenacerepo maintenanceRepo) {
        this.maintenanceRepo = maintenanceRepo;
    }

    @Override
    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepo.findAll();
    }

    @Override
    public Optional<Maintenance> getMaintenanceById(Long id) {
        return maintenanceRepo.findById(id);
    }

    @Override
    @Transactional
    public Maintenance saveMaintenance(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    @Override
    @Transactional
    public Maintenance updateMaintenance(Maintenance maintenance, Long id) {
        if (!maintenanceRepo.existsById(id)) {
            throw new RuntimeException("Maintenance avec id " + id + " non trouvée");
        }
        maintenance.setId(id);
        return maintenanceRepo.save(maintenance);
    }

    @Override
    @Transactional
    public void deleteMaintenance(Long id) {
        if (!maintenanceRepo.existsById(id)) {
            throw new RuntimeException("Maintenance avec id " + id + " non trouvée");
        }
        maintenanceRepo.deleteById(id);
    }

    @Override
    public List<Maintenance> getMaintenancesByVoiture(Long voitureId) {
        return maintenanceRepo.findAll().stream()
                .filter(maintenance -> maintenance.getVoiture() != null && 
                        maintenance.getVoiture().getIdVoiture() == voitureId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Maintenance> getMaintenancesByType(Typemaintenance type) {
        return maintenanceRepo.findAll().stream()
                .filter(maintenance -> maintenance.getTypemaintenance() == type)
                .collect(Collectors.toList());
    }

    @Override
    public List<Maintenance> getMaintenancesByDate(String date) {
        return maintenanceRepo.findAll().stream()
                .filter(maintenance -> maintenance.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Maintenance updateMaintenancePrice(Long id, String price) {
        Maintenance maintenance = maintenanceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance avec id " + id + " non trouvée"));
        maintenance.setPrixpay(price);
        return maintenanceRepo.save(maintenance);
    }
} 