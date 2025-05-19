package com.voiture.v1.service;

import com.voiture.v1.entity.ContratLocation;
import com.voiture.v1.repository.ContratLocationrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratLocationServiceImpl implements ContratLocationService {
    private final ContratLocationrepo contratLocationRepo;

    @Autowired
    public ContratLocationServiceImpl(ContratLocationrepo contratLocationRepo) {
        this.contratLocationRepo = contratLocationRepo;
    }

    @Override
    public List<ContratLocation> getAllContrats() {
        return contratLocationRepo.findAll();
    }

    @Override
    public Optional<ContratLocation> getContratById(Long id) {
        return contratLocationRepo.findById(id);
    }

    @Override
    @Transactional
    public ContratLocation saveContrat(ContratLocation contrat) {
        return contratLocationRepo.save(contrat);
    }

    @Override
    @Transactional
    public ContratLocation updateContrat(ContratLocation contrat, Long id) {
        if (!contratLocationRepo.existsById(id)) {
            throw new RuntimeException("Contrat avec id " + id + " non trouvé");
        }
        contrat.setId(id);
        return contratLocationRepo.save(contrat);
    }

    @Override
    @Transactional
    public void deleteContrat(Long id) {
        if (!contratLocationRepo.existsById(id)) {
            throw new RuntimeException("Contrat avec id " + id + " non trouvé");
        }
        contratLocationRepo.deleteById(id);
    }

    @Override
    public List<ContratLocation> getContratsByClient(Long clientId) {
        return contratLocationRepo.findAll().stream()
                .filter(contrat -> contrat.getClient() != null && contrat.getClient().getIdClient() == clientId)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContratLocation> getContratsByVoiture(Long voitureId) {
        return contratLocationRepo.findAll().stream()
                .filter(contrat -> contrat.getVoiture() != null &&
                        contrat.getVoiture().getIdVoiture() == voitureId)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContratLocation> getContratsByEmployee(Long employeeId) {
        return contratLocationRepo.findAll().stream()
                .filter(contrat -> contrat.getEmployee() != null && 
                        contrat.getEmployee().getIdEmployee() == employeeId)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContratLocation> getContratsByDateRange(Date startDate, Date endDate) {
        return contratLocationRepo.findAll().stream()
                .filter(contrat -> contrat.getDateDebut() != null && 
                        contrat.getDateFin() != null &&
                        !contrat.getDateDebut().before(startDate) && 
                        !contrat.getDateFin().after(endDate))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ContratLocation updateContratStatus(Long id, String status) {
        ContratLocation contrat = contratLocationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat avec id " + id + " non trouvé"));
        contrat.setStatut(status);
        return contratLocationRepo.save(contrat);
    }
} 