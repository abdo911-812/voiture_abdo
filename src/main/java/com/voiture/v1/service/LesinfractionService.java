package com.voiture.v1.service;

import com.voiture.v1.entity.Lesinfraction;
import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface LesinfractionService {
    List<Lesinfraction> getAllInfractions();
    Optional<Lesinfraction> getInfractionById(Long id);
    Lesinfraction saveInfraction(Lesinfraction infraction);
    Lesinfraction updateInfraction(Lesinfraction infraction, Long id);
    void deleteInfraction(Long id);
    
    // Specific business methods
    List<Lesinfraction> getInfractionsByClient(Long clientId);
    List<Lesinfraction> getInfractionsByVoiture(Long voitureId);
    List<Lesinfraction> getInfractionsByDate(Date date);
    List<Lesinfraction> getInfractionsByType(String typeCharge);
    Lesinfraction updateInfractionPrice(Long id, String price);
} 