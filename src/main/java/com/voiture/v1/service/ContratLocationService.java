package com.voiture.v1.service;

import com.voiture.v1.entity.ContratLocation;
import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface ContratLocationService {
    List<ContratLocation> getAllContrats();
    Optional<ContratLocation> getContratById(Long id);
    ContratLocation saveContrat(ContratLocation contrat);
    ContratLocation updateContrat(ContratLocation contrat, Long id);
    void deleteContrat(Long id);
    
    // Specific business methods
    List<ContratLocation> getContratsByClient(Long clientId);
    List<ContratLocation> getContratsByVoiture(Long voitureId);
    List<ContratLocation> getContratsByEmployee(Long employeeId);
    List<ContratLocation> getContratsByDateRange(Date startDate, Date endDate);
    ContratLocation updateContratStatus(Long id, String status);
} 