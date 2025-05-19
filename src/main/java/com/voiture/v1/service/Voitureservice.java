package com.voiture.v1.service;

import com.voiture.v1.entity.Voiture;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Voitureservice {

    List<Voiture> getAllVoitures();
    Optional<Voiture> getVoitureById(Long id);
    Voiture saveVoiture(Voiture voiture);
    Voiture updateVoiture(Voiture voiture, Long id);
    void deleteVoiture(Long id);
    Voiture updatepriceVoiture(float newprice, Long id);

    Voiture updateKilometrageVoiture(int newkelo, Long id);
    Voiture updatedatefineAssurance(Date newdate, long id);
}
