package com.voiture.v1.service;

import com.voiture.v1.entity.EtatVoiture;
import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface EtatVoitureService {
    List<EtatVoiture> getAllEtats();
    Optional<EtatVoiture> getEtatById(Long id);
    EtatVoiture saveEtat(EtatVoiture etat);
    EtatVoiture updateEtat(EtatVoiture etat, Long id);
    void deleteEtat(Long id);
    
    // Specific business methods
    List<EtatVoiture> getEtatsByContrat(Long contratId);
    List<EtatVoiture> getEtatsByDate(Date date);
    List<EtatVoiture> getEtatsByTypeOperation(String typeOperation);
    EtatVoiture updateKilometrage(Long id, String kilometrage);
} 