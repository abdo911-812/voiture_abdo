package com.voiture.v1.service;

import com.voiture.v1.entity.Lesinfraction;
import com.voiture.v1.repository.Lesinfractionrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LesinfractionServiceImpl implements LesinfractionService {
    private final Lesinfractionrepo infractionRepo;

    @Autowired
    public LesinfractionServiceImpl(Lesinfractionrepo infractionRepo) {
        this.infractionRepo = infractionRepo;
    }

    @Override
    public List<Lesinfraction> getAllInfractions() {
        return infractionRepo.findAll();
    }

    @Override
    public Optional<Lesinfraction> getInfractionById(Long id) {
        return infractionRepo.findById(id);
    }

    @Override
    @Transactional
    public Lesinfraction saveInfraction(Lesinfraction infraction) {
        return infractionRepo.save(infraction);
    }

    @Override
    @Transactional
    public Lesinfraction updateInfraction(Lesinfraction infraction, Long id) {
        if (!infractionRepo.existsById(id)) {
            throw new RuntimeException("Infraction avec id " + id + " non trouvée");
        }
        infraction.setId(id);
        return infractionRepo.save(infraction);
    }

    @Override
    @Transactional
    public void deleteInfraction(Long id) {
        if (!infractionRepo.existsById(id)) {
            throw new RuntimeException("Infraction avec id " + id + " non trouvée");
        }
        infractionRepo.deleteById(id);
    }

    @Override
    public List<Lesinfraction> getInfractionsByClient(Long clientId) {
        return infractionRepo.findAll().stream()
                .filter(infraction -> infraction.getClient() != null && 
                        infraction.getClient().getIdClient() == clientId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Lesinfraction> getInfractionsByVoiture(Long voitureId) {
        return infractionRepo.findAll().stream()
                .filter(infraction -> infraction.getVoiture() != null && 
                        infraction.getVoiture().getIdVoiture() == voitureId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Lesinfraction> getInfractionsByDate(Date date) {
        return infractionRepo.findAll().stream()
                .filter(infraction -> infraction.getDate() != null && 
                        infraction.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Lesinfraction> getInfractionsByType(String typeCharge) {
        return infractionRepo.findAll().stream()
                .filter(infraction -> infraction.getTypeCharge() != null && 
                        infraction.getTypeCharge().equals(typeCharge))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Lesinfraction updateInfractionPrice(Long id, String price) {
        Lesinfraction infraction = infractionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Infraction avec id " + id + " non trouvée"));
        infraction.setPrixpay(price);
        return infractionRepo.save(infraction);
    }
} 