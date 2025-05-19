package com.voiture.v1.controller;

import com.voiture.v1.entity.Voiture;
import com.voiture.v1.service.Voitureserviceimp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voiture")
@AllArgsConstructor
public class Voiturecontroller {

    private final Voitureserviceimp voitureserviceimp;

    @GetMapping
    public List<Voiture> getVoitures() {
        return  voitureserviceimp.getAllVoitures();
    }

    @PostMapping
    public Voiture addVoiture(@RequestBody Voiture voiture) {
        return voitureserviceimp.saveVoiture(voiture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoitur(@PathVariable Long id) {
        try{
            voitureserviceimp.deleteVoiture(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable Long id, @RequestBody Voiture voiture) {
        voiture.setIdVoiture(id);
        try {
            Voiture voitureupdated = voitureserviceimp.updateVoiture(voiture,id);
            return ResponseEntity.ok(voitureupdated);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable Long id) {
        return voitureserviceimp.getVoitureById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/mileige/{id}/")
    public ResponseEntity<Voiture> updatemilaige(@PathVariable Long id,@RequestParam int mileige) {
        try{
            Voiture updatekilo= voitureserviceimp.updateKilometrageVoiture(mileige,id);
            return ResponseEntity.ok(updatekilo);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }

    @PutMapping("/assurance/{id}")
    public ResponseEntity<Voiture> updateAssurance(@PathVariable Long id, @RequestParam Date newdate) {
        try{
            Voiture voiture =voitureserviceimp.updatedatefineAssurance(newdate,id);
            return ResponseEntity.ok(voiture);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/price/{id}")
    public ResponseEntity<Voiture> updateprice(@PathVariable Long id, @RequestParam float price) {
        try{
            Voiture  updatedprice = voitureserviceimp.updatepriceVoiture(price,id);
                    return ResponseEntity.ok(updatedprice);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
