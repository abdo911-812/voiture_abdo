package com.voiture.v1.service;

import com.voiture.v1.entity.Voiture;
import com.voiture.v1.repository.Voiturerepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Voitureserviceimp implements Voitureservice {
    private final Voiturerepo voiturerepo;

    public Voitureserviceimp(Voiturerepo voiturerepo) {
        this.voiturerepo = voiturerepo;
    }

    @Override
    public List<Voiture> getAllVoitures() {
        return this.voiturerepo.findAll();
    }

    @Override
    public Optional <Voiture> getVoitureById(Long id) {
        return this.voiturerepo.findById(id);
    }

    @Override
    @Transactional
    public Voiture saveVoiture(Voiture voiture) {
        return this.voiturerepo.save(voiture);
    }

    @Override
    @Transactional
    public Voiture updateVoiture(Voiture voiture, Long id) {
        if(voiturerepo.existsById(id)){
            throw new RuntimeException("voiture avec id "+id+"non trouve");
        }
        return this.voiturerepo.save(voiture);
    }

    @Override
    public void deleteVoiture(Long id) {
        if(!voiturerepo.existsById(id)){
            throw new RuntimeException("voiture avec id "+id+"non trouve");
        }else{
            voiturerepo.deleteById(id);
        }

    }

    @Override
    @Transactional
    public Voiture updatepriceVoiture(float newprice, Long id) {
        Voiture voiture = voiturerepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Voiture avec id " + id + " non trouvée"));

        voiture.setPrixLocation(newprice);
        return voiturerepo.save(voiture);
    }

    @Override
    @Transactional
    public Voiture updateKilometrageVoiture(int newkelo, Long id) {
        Voiture voiture =voiturerepo.findById(id)
                .orElseThrow(()->new RuntimeException("Voiture avec id " + id + " non trouvée"));
        voiture.setKilometrage(newkelo);
        return voiturerepo.save(voiture);
    }

    @Override
    @Transactional
    public Voiture updatedatefineAssurance(Date newdate, long id) {
        Voiture voiture = voiturerepo.findById(id)
                .orElseThrow(()->new RuntimeException("Voiture avec id " + id + " non trouve"));
        voiture.setDatefineAssurance(newdate);
        return voiturerepo.save(voiture);
    }

}
