package com.voiture.v1.service;

import com.voiture.v1.entity.EtatVoiture;
import com.voiture.v1.repository.EtatVoiturerepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtatVoitureServiceImpl implements EtatVoitureService {
    private final EtatVoiturerepo etatVoitureRepo;

    @Autowired
    public EtatVoitureServiceImpl(EtatVoiturerepo etatVoitureRepo) {
        this.etatVoitureRepo = etatVoitureRepo;
    }

    @Override
    public List<EtatVoiture> getAllEtats() {
        return etatVoitureRepo.findAll();
    }

    @Override
    public Optional<EtatVoiture> getEtatById(Long id) {
        return etatVoitureRepo.findById(id);
    }

    @Override
    @Transactional
    public EtatVoiture saveEtat(EtatVoiture etat) {
        return etatVoitureRepo.save(etat);
    }

    @Override
    @Transactional
    public EtatVoiture updateEtat(EtatVoiture etat, Long id) {
        if (!etatVoitureRepo.existsById(id)) {
            throw new RuntimeException("Etat voiture avec id " + id + " non trouvé");
        }
        etat.setId(id);
        return etatVoitureRepo.save(etat);
    }

    @Override
    @Transactional
    public void deleteEtat(Long id) {
        if (!etatVoitureRepo.existsById(id)) {
            throw new RuntimeException("Etat voiture avec id " + id + " non trouvé");
        }
        etatVoitureRepo.deleteById(id);
    }

    @Override
    public List<EtatVoiture> getEtatsByContrat(Long contratId) {
        return etatVoitureRepo.findAll().stream()
                .filter(etat -> etat.getContratLocation() != null && 
                        etat.getContratLocation().getId() == contratId)
                .collect(Collectors.toList());
    }

    @Override
    public List<EtatVoiture> getEtatsByDate(Date date) {
        return etatVoitureRepo.findAll().stream()
                .filter(etat -> etat.getDate() != null && 
                        etat.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<EtatVoiture> getEtatsByTypeOperation(String typeOperation) {
        return etatVoitureRepo.findAll().stream()
                .filter(etat -> etat.getTypeoperation() != null && 
                        etat.getTypeoperation().equals(typeOperation))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EtatVoiture updateKilometrage(Long id, String kilometrage) {
        EtatVoiture etat = etatVoitureRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Etat voiture avec id " + id + " non trouvé"));
        etat.setKilometrage(kilometrage);
        return etatVoitureRepo.save(etat);
    }
} 